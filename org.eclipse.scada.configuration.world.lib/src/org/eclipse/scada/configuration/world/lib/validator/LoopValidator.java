/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/

package org.eclipse.scada.configuration.world.lib.validator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.scada.configuration.world.lib.validator.handler.AverageHandler;
import org.eclipse.scada.configuration.world.lib.validator.handler.FormulaHandler;
import org.eclipse.scada.configuration.world.lib.validator.handler.LoopHandler;
import org.eclipse.scada.configuration.world.lib.validator.handler.MapperHandler;
import org.eclipse.scada.configuration.world.lib.validator.handler.MasterHandler;
import org.eclipse.scada.configuration.world.lib.validator.handler.MovingAverageHandler;
import org.eclipse.scada.configuration.world.lib.validator.handler.MultiSourceAttributeHandler;
import org.eclipse.scada.configuration.world.lib.validator.handler.NoOpHandler;
import org.eclipse.scada.configuration.world.lib.validator.handler.ProxyQueryHandler;
import org.eclipse.scada.configuration.world.lib.validator.handler.SimpleAttributeHandler;
import org.eclipse.scada.configuration.world.lib.validator.handler.SimpleHandler;
import org.eclipse.scada.configuration.world.lib.validator.handler.SummaryHandler;
import org.eclipse.scada.utils.str.StringHelper;

public class LoopValidator
{

    private final Map<String, LoopHandler> handlers = new HashMap<String, LoopHandler> ();

    private final Map<String, Map<String, Map<String, String>>> data;

    private final PrintStream logStream;

    private final Set<DataSourceDescriptor> descriptorPool = new HashSet<DataSourceDescriptor> ();

    public LoopValidator ( final Map<String, Map<String, Map<String, String>>> data, final PrintStream logStream )
    {
        this.data = data;
        this.logStream = logStream;
        initLoopHandler ();
        initFixedSources ();
    }

    private void initFixedSources ()
    {
        this.descriptorPool.add ( new DataSourceDescriptor ( "datasource", "ae.server.info.NOT_AKN" ) );
        this.descriptorPool.add ( new DataSourceDescriptor ( "datasource", "ae.server.info.OK" ) );
        this.descriptorPool.add ( new DataSourceDescriptor ( "datasource", "ae.server.info.INIT" ) );
        this.descriptorPool.add ( new DataSourceDescriptor ( "datasource", "ae.server.info.ALERT_ACTIVE" ) );
        this.descriptorPool.add ( new DataSourceDescriptor ( "datasource", "ae.server.info.ALERT_DISABLED" ) );
        this.descriptorPool.add ( new DataSourceDescriptor ( "datasource", "ae.server.info.NOT_OK_NOT_AKN" ) );
        this.descriptorPool.add ( new DataSourceDescriptor ( "datasource", "ae.server.info.UNSAFE" ) );
        this.descriptorPool.add ( new DataSourceDescriptor ( "datasource", "ae.server.info.INACTIVE" ) );
        this.descriptorPool.add ( new DataSourceDescriptor ( "datasource", "ae.server.info.NOT_OK_AKN" ) );
        this.descriptorPool.add ( new DataSourceDescriptor ( "datasource", "ae.server.info.NOT_OK" ) );
    }

    private void initLoopHandler ()
    {

        this.handlers.put ( "ae.server.info", new NoOpHandler () );
        this.handlers.put ( "org.eclipse.scada.da.server.exporter.rest", new NoOpHandler () );
        this.handlers.put ( "org.eclipse.scada.da.server.exporter.modbus.device", new NoOpHandler () );
        this.handlers.put ( "org.eclipse.scada.sec.osgi.manager", new NoOpHandler () );
        this.handlers.put ( "org.eclipse.scada.ae.event.logger", new NoOpHandler () );
        this.handlers.put ( "org.eclipse.scada.ae.server.http.eventFilter", new NoOpHandler () );
        this.handlers.put ( "org.eclipse.scada.sec.provider.jdbc.authenticator", new NoOpHandler () );

        this.handlers.put ( "ae.monitor.query", new SimpleHandler ( "monitor.query" ) );
        this.handlers.put ( "org.eclipse.scada.ae.server.common.event.pool", new SimpleHandler ( "event.query" ) );

        this.handlers.put ( "da.connection", new SimpleHandler ( "da.connection" ) );
        this.handlers.put ( "ae.connection", new SimpleHandler ( "ae.connection" ) );
        this.handlers.put ( "hd.connection", new SimpleHandler ( "hd.connection" ) );

        this.handlers.put ( "org.eclipse.scada.da.datasource.average", new AverageHandler () );
        this.handlers.put ( "org.eclipse.scada.da.datasource.movingaverage", new MovingAverageHandler () );

        this.handlers.put ( "da.dataitem.datasource", new SimpleAttributeHandler ( "datasource", "da.connection", "connection.id" ) );

        this.handlers.put ( "master.item", new MasterHandler () );
        this.handlers.put ( "da.datasource.dataitem", new SimpleHandler ( "datasource" ) );
        this.handlers.put ( "org.eclipse.scada.da.datasource.script", new MultiSourceAttributeHandler ( "datasource." ) );
        this.handlers.put ( "org.eclipse.scada.da.datasource.sum", new MultiSourceAttributeHandler ( "datasource.", "subDatasource." ) );

        this.handlers.put ( "org.eclipse.scada.da.datasource.ds", new SimpleHandler ( "datasource" ) );
        this.handlers.put ( "org.eclipse.scada.da.datasource.constant", new SimpleHandler ( "datasource" ) );

        this.handlers.put ( "org.eclipse.scada.da.server.osgi.summary.attribute", new SummaryHandler () );
        this.handlers.put ( "org.eclipse.scada.da.datasource.formula", new FormulaHandler () );

        this.handlers.put ( "org.eclipse.scada.ae.monitor.level", new SimpleAttributeHandler ( "masterHandler", "master", "master.id" ) );
        this.handlers.put ( "org.eclipse.scada.ae.monitor.bit", new SimpleAttributeHandler ( "masterHandler", "master", "master.id" ) );
        this.handlers.put ( "org.eclipse.scada.ae.monitor.list", new SimpleAttributeHandler ( "masterHandler", "master", "master.id" ) );

        this.handlers.put ( "org.eclipse.scada.da.master.common.marker", new SimpleAttributeHandler ( "masterHandler", "master", "master.id", ", ?" ) );

        this.handlers.put ( "org.eclipse.scada.da.level.ceil", new SimpleAttributeHandler ( "masterHandler", "master", "master.id" ) );
        this.handlers.put ( "org.eclipse.scada.da.level.highhigh", new SimpleAttributeHandler ( "masterHandler", "master", "master.id" ) );
        this.handlers.put ( "org.eclipse.scada.da.level.high", new SimpleAttributeHandler ( "masterHandler", "master", "master.id" ) );
        this.handlers.put ( "org.eclipse.scada.da.level.low", new SimpleAttributeHandler ( "masterHandler", "master", "master.id" ) );
        this.handlers.put ( "org.eclipse.scada.da.level.lowlow", new SimpleAttributeHandler ( "masterHandler", "master", "master.id" ) );

        this.handlers.put ( "da.master.handler.sum", new SimpleAttributeHandler ( "masterHandler", "datasource", "master.id" ) );
        this.handlers.put ( "org.eclipse.scada.da.negate.input", new SimpleAttributeHandler ( "masterHandler", "master", "master.id" ) );
        this.handlers.put ( "org.eclipse.scada.da.manual", new SimpleAttributeHandler ( "masterHandler", "master", "master.id" ) );
        this.handlers.put ( "org.eclipse.scada.da.master.common.block", new SimpleAttributeHandler ( "masterHandler", "master", "master.id", ", ?" ) );
        this.handlers.put ( "org.eclipse.scada.da.round", new SimpleAttributeHandler ( "masterHandler", "master", "master.id" ) );

        this.handlers.put ( "org.eclipse.scada.da.mapper.osgi.configuredMapper", new SimpleHandler ( "mapper" ) );
        this.handlers.put ( "org.eclipse.scada.da.mapper.osgi.jdbcMapper", new SimpleHandler ( "mapper" ) );
        this.handlers.put ( "org.eclipse.scada.da.master.mapper", new MapperHandler () );

        this.handlers.put ( "org.eclipse.scada.da.scale.input", new SimpleAttributeHandler ( "masterHandler", "master", "master.id" ) );

        this.handlers.put ( "org.eclipse.scada.ae.server.monitor.proxy", new ProxyQueryHandler ( "monitor.query" ) );
        this.handlers.put ( "org.eclipse.scada.ae.server.event.proxy", new ProxyQueryHandler ( "event.query" ) );
    }

    public void validate ()
    {
        final Set<DataSourceNode> nodes = load ();
        searchForLoops ( nodes );
    }

    public void writeDot ( final File dotFile ) throws FileNotFoundException
    {
        final Set<DataSourceNode> nodes = load ();

        System.out.println ( "Writing to: " + dotFile );

        final PrintWriter writer = new PrintWriter ( dotFile );

        writer.println ( "digraph {" );

        writer.println ( "  rankdir=LR" );

        for ( final DataSourceNode node : nodes )
        {
            if ( "datasource".equals ( node.getType () ) )
            {
                writer.println ( String.format ( "\"%s\"", node.getId () ) );
                writer.println ();
            }
        }

        for ( final DataSourceNode node : nodes )
        {
            if ( "datasource".equals ( node.getType () ) )
            {
                for ( final DataSourceNode refNode : node.getReferences () )
                {
                    writer.println ( String.format ( "\"%s\" -> \"%s\"", node.getId (), refNode.getId () ) );
                }
                writer.println ();
            }
        }

        writer.println ( "}" );

        writer.close ();
    }

    private Set<DataSourceNode> load ()
    {
        for ( final Map.Entry<String, Map<String, Map<String, String>>> factory : this.data.entrySet () )
        {
            processFactory ( factory.getKey (), factory.getValue () );
        }

        for ( final LoopHandler handler : this.handlers.values () )
        {
            if ( handler.providesPostProcessing () )
            {
                handler.postProcess ( this.descriptorPool );
            }
        }

        this.logStream.println ( String.format ( "%s nodes in validation pool", this.descriptorPool.size () ) );

        final Set<DataSourceNode> nodes = buildGraph ();
        return nodes;
    }

    private void searchForLoops ( final Set<DataSourceNode> nodes )
    {
        for ( final DataSourceNode node : nodes )
        {
            final Stack<DataSourceNode> stack = new Stack<DataSourceNode> ();
            walk ( stack, node );
        }
    }

    private void walk ( final Stack<DataSourceNode> stack, final DataSourceNode node )
    {
        if ( stack.contains ( node ) )
        {
            this.logStream.println ( "Loop found: " + StringHelper.join ( stack, " -> " ) );
            // loop found
            return;
        }

        stack.push ( node );
        for ( final DataSourceNode ref : node.getReferences () )
        {
            walk ( stack, ref );
        }
        stack.pop ();
    }

    private Set<DataSourceNode> buildGraph ()
    {
        final Map<DataSourceReference, DataSourceNode> nodes = new HashMap<DataSourceReference, DataSourceNode> ();

        // create nodes
        for ( final DataSourceDescriptor desc : this.descriptorPool )
        {
            final DataSourceNode node = new DataSourceNode ( desc.getType (), desc.getId () );
            nodes.put ( desc, node );
        }
        // connect nodes
        for ( final DataSourceDescriptor desc : this.descriptorPool )
        {
            final DataSourceNode node = nodes.get ( desc );
            for ( final DataSourceReference reference : desc.getReferences () )
            {
                final DataSourceNode ref = nodes.get ( reference );
                if ( ref == null )
                {
                    this.logStream.println ( String.format ( "Reference from %s to %s not found", desc, reference ) );
                }
                else
                {
                    node.addReference ( ref );
                }
            }
        }

        return new HashSet<DataSourceNode> ( nodes.values () );
    }

    private void processFactory ( final String factoryId, final Map<String, Map<String, String>> value )
    {
        final LoopHandler handler = this.handlers.get ( factoryId );
        if ( handler == null )
        {
            this.logStream.println ( "Ignoring factory: " + factoryId );
            // ignore
            return;
        }

        if ( !handler.providesDescriptors () )
        {
            return;
        }

        for ( final Map.Entry<String, Map<String, String>> configuration : value.entrySet () )
        {
            processConfiguration ( handler, factoryId, configuration.getKey (), configuration.getValue () );
        }
    }

    private void processConfiguration ( final LoopHandler handler, final String factoryId, final String configurationId, final Map<String, String> parameters )
    {
        final Set<DataSourceDescriptor> descriptors = handler.getNode ( configurationId, parameters );
        for ( final DataSourceDescriptor desc : descriptors )
        {
            if ( !this.descriptorPool.add ( desc ) )
            {
                this.logStream.println ( "Duplicate data source: " + desc.getId () );
            }
        }
    }
}
