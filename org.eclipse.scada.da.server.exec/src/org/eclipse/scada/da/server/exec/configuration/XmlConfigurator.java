/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.exec.configuration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;
import org.eclipse.scada.da.exec.configuration.DocumentRoot;
import org.eclipse.scada.da.exec.configuration.EnvEntryType;
import org.eclipse.scada.da.exec.configuration.ExtractorType;
import org.eclipse.scada.da.exec.configuration.FieldExtractorType;
import org.eclipse.scada.da.exec.configuration.FieldType;
import org.eclipse.scada.da.exec.configuration.HiveProcessCommandType;
import org.eclipse.scada.da.exec.configuration.NagiosReturnCodeExtractorType;
import org.eclipse.scada.da.exec.configuration.PlainStreamExtractorType;
import org.eclipse.scada.da.exec.configuration.ProcessType;
import org.eclipse.scada.da.exec.configuration.QueueType;
import org.eclipse.scada.da.exec.configuration.RegExExtractorType;
import org.eclipse.scada.da.exec.configuration.ReturnCodeExtractorType;
import org.eclipse.scada.da.exec.configuration.RootType;
import org.eclipse.scada.da.exec.configuration.SingleCommandType;
import org.eclipse.scada.da.exec.configuration.SplitContinuousCommandType;
import org.eclipse.scada.da.exec.configuration.SplitterExtractorType;
import org.eclipse.scada.da.exec.configuration.SplitterType;
import org.eclipse.scada.da.exec.configuration.TriggerCommandType;
import org.eclipse.scada.da.exec.configuration.util.ConfigurationResourceFactoryImpl;
import org.eclipse.scada.da.server.exec.Hive;
import org.eclipse.scada.da.server.exec.command.CommandQueue;
import org.eclipse.scada.da.server.exec.command.CommandQueueImpl;
import org.eclipse.scada.da.server.exec.command.ContinuousCommand;
import org.eclipse.scada.da.server.exec.command.ExtractorContinuousCommand;
import org.eclipse.scada.da.server.exec.command.HiveProcessCommand;
import org.eclipse.scada.da.server.exec.command.ProcessConfiguration;
import org.eclipse.scada.da.server.exec.command.SingleCommand;
import org.eclipse.scada.da.server.exec.command.SingleCommandImpl;
import org.eclipse.scada.da.server.exec.command.TriggerCommand;
import org.eclipse.scada.da.server.exec.extractor.AbstractArrayExtractor;
import org.eclipse.scada.da.server.exec.extractor.Extractor;
import org.eclipse.scada.da.server.exec.extractor.NagiosExtractor;
import org.eclipse.scada.da.server.exec.extractor.PlainStreamExtractor;
import org.eclipse.scada.da.server.exec.extractor.RegExExtractor;
import org.eclipse.scada.da.server.exec.extractor.SimpleReturnCodeExtractor;
import org.eclipse.scada.da.server.exec.extractor.SplitterExtractor;
import org.eclipse.scada.da.server.exec.splitter.RegExMatchSplitter;
import org.eclipse.scada.da.server.exec.splitter.RegExSplitSplitter;
import org.eclipse.scada.da.server.exec.splitter.SplitSplitter;
import org.eclipse.scada.da.server.exec.splitter.Splitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlConfigurator implements Configurator
{

    private final static Logger logger = LoggerFactory.getLogger ( XmlConfigurator.class );

    private RootType root;

    /**
     * Configure based on provided root document
     * 
     * @param document
     *            the root document
     */
    public XmlConfigurator ( final RootType root )
    {
        this.root = root;
    }

    /**
     * Configure based on an XML node which will be parsed for a root document
     * 
     * @param node
     *            the node that will be parsed
     * @throws ConfigurationException
     *             if anything goes wrong
     */
    public XmlConfigurator ( final URI uri ) throws ConfigurationException
    {
        try
        {
            this.root = parse ( uri );
        }
        catch ( final IOException e )
        {
            throw new ConfigurationException ( "Failed to parse xml document", e );
        }
    }

    /**
     * Apply the configuration to the hive.
     * <p>
     * The origin of the documentation is the provided configuration
     */
    @Override
    public void configure ( final Hive hive ) throws ConfigurationException
    {
        configure ( this.root, hive );
    }

    private void configure ( final RootType root, final Hive hive ) throws ConfigurationException
    {
        // create scheduled commands
        for ( final QueueType queueType : root.getQueue () )
        {
            final CommandQueue queue = new CommandQueueImpl ( hive, queueType.getName (), 1000 );
            configureQueue ( queue, queueType, hive );
            hive.addQueue ( queue );
        }

        // create continuous commands with configured splitters and extractors
        for ( final SplitContinuousCommandType commandType : root.getCommand () )
        {
            final ProcessConfiguration processConfiguration = createProcessConfiguration ( commandType.getProcess () );
            final Splitter splitter = createSplitter ( commandType.getSplitter () );
            if ( splitter == null )
            {
                throw new ConfigurationException ( String.format ( "Unable to create splitter: " + commandType.getSplitter ().getType () ) );
            }
            final ContinuousCommand command = new ExtractorContinuousCommand ( commandType.getId (), processConfiguration, commandType.getRestartDelay (), commandType.getMaxInputBuffer (), commandType.getIgnoreStartLines (), splitter, createExtractors ( commandType.getExtractor (), hive ) );
            hive.addContinuousCommand ( command );
        }

        // create openscada command line hive processes
        for ( final HiveProcessCommandType hiveProcessType : root.getHiveProcess () )
        {
            final ProcessConfiguration processConfiguration = createProcessConfiguration ( hiveProcessType.getProcess () );
            final HiveProcessCommand command = new HiveProcessCommand ( hiveProcessType.getId (), processConfiguration, hiveProcessType.getRestartDelay (), hiveProcessType.getMaxInputBuffer () );
            hive.addContinuousCommand ( command );
        }

        // create triggers
        for ( final TriggerCommandType triggerType : root.getTrigger () )
        {
            final ProcessConfiguration processConfiguration = createProcessConfiguration ( triggerType.getProcess () );
            final boolean fork = triggerType.isSetFork () ? triggerType.isFork () : true;
            final TriggerCommand command = new TriggerCommand ( triggerType.getId (), processConfiguration, createExtractors ( triggerType.getExtractor (), hive ), triggerType.getArgumentPlaceholder (), triggerType.isSkipIfNull (), fork );
            hive.addTrigger ( command );
        }

        if ( root.getAdditionalConfigurationDirectory () != null )
        {
            for ( final String directory : root.getAdditionalConfigurationDirectory () )
            {
                logger.info ( "Processing include dir: {}", directory );

                final File dir = new File ( directory );
                if ( !dir.isDirectory () )
                {
                    logger.error ( "Unable to load configurations from directory: {}", dir );
                    continue;
                }
                for ( final File file : dir.listFiles () )
                {
                    logger.info ( "Found file: {}", file );
                    if ( !file.isFile () )
                    {
                        logger.warn ( "Is not a file. Skipping." );
                        continue;
                    }
                    if ( !file.canRead () )
                    {
                        logger.warn ( "Unable to read file. Skipping." );
                        continue;
                    }
                    processFile ( file, hive );
                }
            }
        }
    }

    private RootType parse ( final URI uri ) throws IOException
    {
        final ResourceSet rs = new ResourceSetImpl ();
        rs.getResourceFactoryRegistry ().getExtensionToFactoryMap ().put ( "*", new ConfigurationResourceFactoryImpl () );
        final Resource r = rs.createResource ( uri );
        r.load ( null );
        final DocumentRoot doc = (DocumentRoot)EcoreUtil.getObjectByType ( r.getContents (), ConfigurationPackage.Literals.DOCUMENT_ROOT );
        if ( doc == null )
        {
            return null;
        }
        return doc.getRoot ();
    }

    private void processFile ( final File file, final Hive hive ) throws ConfigurationException
    {
        try
        {
            final RootType subRoot = parse ( URI.createFileURI ( file.getAbsolutePath () ) );
            configure ( subRoot, hive );
        }
        catch ( final IOException e )
        {
            throw new ConfigurationException ( "Failed to parse sub xml document: " + file, e );
        }
    }

    /**
     * Construct a {@link Splitter} from the provided element
     * 
     * @param splitterType
     *            the provided element
     * @return the new splitter or <code>null</code> if none exists
     */
    private Splitter createSplitter ( final SplitterType splitterType )
    {
        final String splitterTypeName = splitterType.getType ();
        if ( "newline".equals ( splitterTypeName ) )
        {
            return new SplitSplitter ( System.getProperty ( "line.separator" ) );
        }
        if ( "split".equals ( splitterTypeName ) )
        {
            return new SplitSplitter ( splitterType.getParameter () );
        }
        if ( "regexpSplit".equals ( splitterTypeName ) )
        {
            return new RegExSplitSplitter ( Pattern.compile ( splitterType.getParameter () ) );
        }
        if ( "regexpMatch".equals ( splitterTypeName ) )
        {
            return new RegExMatchSplitter ( Pattern.compile ( splitterType.getParameter () ) );
        }
        return null;
    }

    private void configureQueue ( final CommandQueue queue, final QueueType queueType, final Hive hive ) throws ConfigurationException
    {
        for ( final SingleCommandType commandType : queueType.getCommand () )
        {
            final SingleCommand command = createSingleCommand ( commandType, hive );
            queue.addCommand ( command, commandType.getPeriod () );
        }
    }

    private SingleCommand createSingleCommand ( final SingleCommandType commandType, final Hive hive ) throws ConfigurationException
    {
        final SingleCommand command = new SingleCommandImpl ( commandType.getId (), createProcessConfiguration ( commandType.getProcess () ), createExtractors ( commandType.getExtractor (), hive ) );
        return command;
    }

    private Collection<Extractor> createExtractors ( final List<ExtractorType> extractorList, final Hive hive ) throws ConfigurationException
    {
        final Collection<Extractor> result = new LinkedList<Extractor> ();

        for ( final ExtractorType eType : extractorList )
        {
            result.add ( createExtractor ( eType, hive ) );
        }

        return result;
    }

    private Extractor createExtractor ( final ExtractorType type, final Hive hive ) throws ConfigurationException
    {
        if ( type instanceof PlainStreamExtractorType )
        {
            return new PlainStreamExtractor ( type.getName () );
        }
        else if ( type instanceof RegExExtractorType )
        {
            final RegExExtractorType regExType = (RegExExtractorType)type;
            boolean requireFullMatch = false;
            requireFullMatch = regExType.isRequireFullMatch ();
            return new RegExExtractor ( type.getName (), Pattern.compile ( regExType.getExpression () ), requireFullMatch, createFields ( regExType ) );
        }
        else if ( type instanceof SplitterExtractorType )
        {
            final SplitterExtractorType splitterType = (SplitterExtractorType)type;
            return new SplitterExtractor ( type.getName (), splitterType.getSplitExpression (), createFields ( splitterType ) );
        }
        else if ( type instanceof ReturnCodeExtractorType )
        {
            return new SimpleReturnCodeExtractor ( type.getName () );
        }
        else if ( type instanceof NagiosReturnCodeExtractorType )
        {
            return new NagiosExtractor ( type.getName () );
        }
        throw new ConfigurationException ( String.format ( "Extractor of %s is unknown", type.getClass () ) );
    }

    private List<AbstractArrayExtractor.FieldMapping> createFields ( final FieldExtractorType regExType )
    {
        final List<AbstractArrayExtractor.FieldMapping> groups = new ArrayList<AbstractArrayExtractor.FieldMapping> ();
        for ( final FieldType group : regExType.getField () )
        {
            final AbstractArrayExtractor.FieldMapping groupMapping = new AbstractArrayExtractor.FieldMapping ();
            groupMapping.setName ( group.getName () );
            groupMapping.setType ( AbstractArrayExtractor.FieldType.valueOf ( group.getVariantType ().toString () ) );
            groups.add ( groupMapping );
        }
        return groups;
    }

    /**
     * Create a new {@link ProcessConfiguration} instance based on a
     * {@link ProcessType}
     * 
     * @param process
     *            the {@link ProcessType} object
     * @return the new {@link ProcessConfiguration} instance
     */
    private ProcessConfiguration createProcessConfiguration ( final ProcessType process )
    {
        // create the env var map
        Map<String, String> env = null;

        if ( process.getEnv () != null && !process.getEnv ().isEmpty () )
        {
            env = new HashMap<String, String> ();
            for ( final EnvEntryType entry : process.getEnv () )
            {
                if ( entry.getName () != null && entry.getName ().length () > 0 )
                {
                    env.put ( entry.getName (), entry.getValue () );
                }
            }
        }

        // create the process configuration instance
        return new ProcessConfiguration ( process.getExec (), process.getArgument ().toArray ( new String[0] ), env );
    }

}
