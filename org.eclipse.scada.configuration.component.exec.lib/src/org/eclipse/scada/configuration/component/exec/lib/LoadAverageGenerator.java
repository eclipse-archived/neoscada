/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.exec.lib;

import org.eclipse.scada.configuration.component.exec.ExecComponentsPackage;
import org.eclipse.scada.configuration.component.exec.LoadAverage;
import org.eclipse.scada.configuration.component.exec.LoadAverageConfiguration;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.generator.GenerationContext;
import org.eclipse.scada.configuration.generator.text.Message;
import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.configuration.world.osgi.SourceItem;
import org.eclipse.scada.da.exec.configuration.ConfigurationFactory;
import org.eclipse.scada.da.exec.configuration.EnvEntryType;
import org.eclipse.scada.da.exec.configuration.FieldType;
import org.eclipse.scada.da.exec.configuration.ProcessType;
import org.eclipse.scada.da.exec.configuration.QueueType;
import org.eclipse.scada.da.exec.configuration.RegExExtractorType;
import org.eclipse.scada.da.exec.configuration.RootType;
import org.eclipse.scada.da.exec.configuration.SingleCommandType;
import org.eclipse.scada.da.exec.configuration.VariantTypeType;

public class LoadAverageGenerator extends ExecJobGenerator
{
    final LoadAverage loadAverage;

    public LoadAverageGenerator ( final LoadAverage loadAverage )
    {
        super ( loadAverage );
        this.loadAverage = loadAverage;
    }

    protected void createField ( final RegExExtractorType ext, final String name, final VariantTypeType variantType )
    {
        final FieldType field = ConfigurationFactory.eINSTANCE.createFieldType ();

        field.setName ( name );
        field.setVariantType ( variantType );

        ext.getField ().add ( field );
    }

    @Override
    public void generate ( final GenerationContext context )
    {
        super.generate ( context );
        generateExecDriver ();
    }

    @Message ( id = "loadAverage.1m.description", defaultText = "Load Average 1m" )
    private String description1m;

    @Message ( id = "loadAverage.5m.description", defaultText = "Load Average 5m" )
    private String description5m;

    @Message ( id = "loadAverage.15m.description", defaultText = "Load Average 15m" )
    private String description15m;

    @Override
    public void createItems ( final ItemCreator itemCreator )
    {
        {
            final CreationRequest<SourceItem> c = itemCreator.createSourceItem ( this.loadAverage.getRunsOn (), localItem ( "A.loadAvg1" ) ); //$NON-NLS-1$ 
            c.localTags ( "LAVG1" ).information ( this.description1m, null, null ); //$NON-NLS-1$ 
            c.dataType ( DataType.FLOAT ).customizationTags ( "input" ); //$NON-NLS-1$ 
            c.create ();
        }
        {
            final CreationRequest<SourceItem> c = itemCreator.createSourceItem ( this.loadAverage.getRunsOn (), localItem ( "A.loadAvg5" ) ); //$NON-NLS-1$ 
            c.localTags ( "LAVG5" ).information ( this.description5m, null, null ); //$NON-NLS-1$ 
            c.dataType ( DataType.FLOAT ).customizationTags ( "input" ); //$NON-NLS-1$ 
            c.create ();
        }
        {
            final CreationRequest<SourceItem> c = itemCreator.createSourceItem ( this.loadAverage.getRunsOn (), localItem ( "A.loadAvg15" ) ); //$NON-NLS-1$ 
            c.localTags ( "LAVG15" ).information ( this.description15m, null, null ); //$NON-NLS-1$ 
            c.dataType ( DataType.FLOAT ).customizationTags ( "input" ); //$NON-NLS-1$ 
            c.create ();
        }
    }

    private void generateExecDriver ()
    {
        final LoadAverageConfiguration cfg = findConfiguration ( LoadAverageConfiguration.class, ExecComponentsPackage.Literals.LOAD_AVERAGE_CONFIGURATION );

        final RootType root = findRoot ();

        final QueueType q = ConfigurationFactory.eINSTANCE.createQueueType ();
        q.setName ( "Q." + getFullLevelName () ); //$NON-NLS-1$ 
        root.getQueue ().add ( q );

        final SingleCommandType cmd = ConfigurationFactory.eINSTANCE.createSingleCommandType ();
        q.getCommand ().add ( cmd );

        cmd.setId ( jobName () );
        cmd.setPeriod ( cfg.getPeriod () );

        final ProcessType process = ConfigurationFactory.eINSTANCE.createProcessType ();
        process.setExec ( "uptime" ); //$NON-NLS-1$ 

        final EnvEntryType env = ConfigurationFactory.eINSTANCE.createEnvEntryType ();
        env.setName ( "LANG" ); //$NON-NLS-1$ 
        env.setValue ( "en_US" ); //$NON-NLS-1$ 
        process.getEnv ().add ( env );

        final RegExExtractorType ext = ConfigurationFactory.eINSTANCE.createRegExExtractorType ();
        ext.setExpression ( cfg.getPattern ().pattern () );
        ext.setName ( "A" ); //$NON-NLS-1$ 
        ext.setRequireFullMatch ( false );
        cmd.getExtractor ().add ( ext );

        createField ( ext, null, null );
        createField ( ext, "users", VariantTypeType.INTEGER ); //$NON-NLS-1$ 
        createField ( ext, "loadAvg1", VariantTypeType.DOUBLE ); //$NON-NLS-1$ 
        createField ( ext, "loadAvg5", VariantTypeType.DOUBLE ); //$NON-NLS-1$ 
        createField ( ext, "loadAvg15", VariantTypeType.DOUBLE ); //$NON-NLS-1$ 

        cmd.setProcess ( process );
    }
}
