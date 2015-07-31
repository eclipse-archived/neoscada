/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.console;

import static org.eclipse.scada.ca.updater.Updater.buildMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import org.apache.felix.service.command.Descriptor;
import org.eclipse.scada.ca.Configuration;
import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.Factory;
import org.eclipse.scada.ca.data.DiffEntry;
import org.eclipse.scada.ca.oscar.OscarWriter;
import org.eclipse.scada.ca.updater.Updater;
import org.eclipse.scada.utils.concurrent.FutureListener;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.str.Tables;

public class Console
{
    private ConfigurationAdministrator admin;

    private static abstract class ResultPrinter implements FutureListener<Configuration>
    {

        protected final PrintStream out;

        public ResultPrinter ( final PrintStream out )
        {
            this.out = out;
        }

        @Override
        public void complete ( final Future<Configuration> future )
        {
            try
            {
                processSuccess ( future.get () );
            }
            catch ( final Exception e )
            {
                processFail ( e );
            }
        }

        protected abstract void processFail ( Exception e );

        protected abstract void processSuccess ( Configuration configuration );
    }

    private static class CommonResultPrinter extends ResultPrinter
    {
        private final String operationName;

        public CommonResultPrinter ( final PrintStream out, final String operationName )
        {
            super ( out );
            this.operationName = operationName;
        }

        @Override
        protected void processFail ( final Exception e )
        {
            this.out.println ( "Failed - " + this.operationName + ":" );
            e.printStackTrace ( this.out );
        }

        @Override
        protected void processSuccess ( final Configuration configuration )
        {
            this.out.println ( "Completed - " + this.operationName + ":" );
            this.out.println ( configuration );
        }
    }

    public void setAdmin ( final ConfigurationAdministrator admin )
    {
        this.admin = admin;
    }

    @Descriptor ( "Delete all elements from the factory" )
    public void purge ( @Descriptor ( "The factory id" )
    final String factoryId)
    {
        final NotifyFuture<Void> future = this.admin.purgeFactory ( null, factoryId );
        future.addListener ( new FutureListener<Void> () {

            @Override
            public void complete ( final Future<Void> future )
            {
                System.out.println ( "Purge completed" );
                try
                {
                    future.get ();
                }
                catch ( final Exception e )
                {
                    // this is on here since it will be printed out to the OSGi console
                    e.printStackTrace ( System.out );
                }
            }
        } );
    }

    @Descriptor ( "Delete an existing configuration" )
    public void delete ( @Descriptor ( "The factory id" )
    final String factoryId, @Descriptor ( "The configuration id" )
    final String configurationId)
    {
        final NotifyFuture<Configuration> future = this.admin.deleteConfiguration ( null, factoryId, configurationId );
        future.addListener ( new CommonResultPrinter ( System.out, String.format ( "delete - %s/%s", factoryId, configurationId ) ) );
    }

    @Descriptor ( "Create a new configuration" )
    public void create ( @Descriptor ( "The factory id" )
    final String factoryId, @Descriptor ( "The configuration id" )
    final String configurationId, @Descriptor ( "The configuration data in key=value format" )
    final String[] data)
    {
        final NotifyFuture<Configuration> future = this.admin.createConfiguration ( null, factoryId, configurationId, parse ( data ) );
        future.addListener ( new CommonResultPrinter ( System.out, String.format ( "create - %s/%s", factoryId, configurationId ) ) );
    }

    @Descriptor ( "Make a delta update to the configuration" )
    public void update ( @Descriptor ( "The factory id" )
    final String factoryId, @Descriptor ( "The configuration id" )
    final String configurationId, @Descriptor ( "The configuration data in key=value format" )
    final String[] data)
    {
        final NotifyFuture<Configuration> future = this.admin.updateConfiguration ( null, factoryId, configurationId, parse ( data ), false );
        future.addListener ( new CommonResultPrinter ( System.out, String.format ( "update - %s/%s", factoryId, configurationId ) ) );
    }

    @Descriptor ( "Make a full update to the configuration" )
    public void set ( @Descriptor ( "The factory id" )
    final String factoryId, @Descriptor ( "The configuration id" )
    final String configurationId, @Descriptor ( "The configuration data in key=value format" )
    final String[] data)
    {
        final NotifyFuture<Configuration> future = this.admin.updateConfiguration ( null, factoryId, configurationId, parse ( data ), true );
        future.addListener ( new CommonResultPrinter ( System.out, String.format ( "set - %s/%s", factoryId, configurationId ) ) );
    }

    @Descriptor ( "Show full factories information" )
    public void showfactories ()
    {
        final List<List<String>> data = new LinkedList<List<String>> ();
        for ( final Factory factory : this.admin.getKnownFactories () )
        {
            final List<String> row = new LinkedList<String> ();

            row.add ( factory.getId () );
            row.add ( factory.getState ().toString () );
            row.add ( factory.getDescription () );

            data.add ( row );
        }

        Tables.showTable ( System.out, Arrays.asList ( "ID", "State", "Description" ), data, 2 );
    }

    @Descriptor ( "Enumerate factory IDs" )
    public void factories ()
    {
        for ( final Factory factory : this.admin.getKnownFactories () )
        {
            System.out.println ( factory.getId () );
        }
    }

    @Descriptor ( "List content of a factory" )
    public void listfactory ( @Descriptor ( "The factory id" )
    final String factoryId)
    {
        final Configuration[] cfgs = this.admin.getConfigurations ( factoryId );

        final List<List<String>> rows = new LinkedList<List<String>> ();
        if ( cfgs != null )
        {
            for ( final Configuration cfg : cfgs )
            {
                final List<String> row = new LinkedList<String> ();
                row.add ( cfg.getId () );
                row.add ( "" + cfg.getState () );
                if ( cfg.getErrorInformation () != null )
                {
                    row.add ( cfg.getErrorInformation ().getMessage () );
                }
                rows.add ( row );
            }
            Tables.showTable ( System.out, Arrays.asList ( "ID", "State", "Error" ), rows, 2 );
        }
        else
        {
            System.out.format ( "Factory '%s' does not exists%n", factoryId );
        }

    }

    @Descriptor ( "Show configuration" )
    public void show ( @Descriptor ( "The factory id" )
    final String factoryId, @Descriptor ( "The configuration id" )
    final String configurationId)
    {
        final Configuration cfg = this.admin.getConfiguration ( factoryId, configurationId );
        if ( cfg == null )
        {
            System.out.println ( String.format ( "Configuration %s/%s does not exists", factoryId, configurationId ) );
        }
        else
        {
            System.out.format ( "%s - %s - %s%n", cfg.getFactoryId (), cfg.getId (), cfg.getState () );
            for ( final Map.Entry<String, String> entry : cfg.getData ().entrySet () )
            {
                System.out.format ( "\t'%s' => '%s'%n", entry.getKey (), entry.getValue () );
            }
            if ( cfg.getErrorInformation () != null )
            {
                cfg.getErrorInformation ().printStackTrace ( System.out );
            }
        }
    }

    @Descriptor ( "Apply update from local filesystem" )
    public void mergeFile ( @Descriptor ( "The file to load from" )
    final String file) throws IOException
    {
        final Updater updater = new Updater ( this.admin );
        try ( Reader reader = new BufferedReader ( new FileReader ( file ) ) )
        {
            updater.loadJson ( reader );
        }

        final List<DiffEntry> changes = updater.getChanges ();
        if ( changes != null )
        {
            System.out.format ( "Applying %s changes%n", changes.size () );
            final NotifyFuture<Void> future = updater.update ();
            System.out.println ( "Operation in progress..." );
            final PrintStream ps = System.out;
            future.addListener ( new FutureListener<Void> () {

                @Override
                public void complete ( final Future<Void> future )
                {
                    ps.println ( "Done" );
                    try
                    {
                        future.get ();
                    }
                    catch ( final Exception e )
                    {
                        ps.println ( "Failed to apply:" );
                        e.printStackTrace ( ps );
                    }
                }
            } );
        }
        else
        {
            System.out.println ( "Unable to build changes" );
        }
    }

    @Descriptor ( "Show a diff between the active configuration and the provided JSON file" )
    public void diffFile ( @Descriptor ( "The file to load from" )
    final File file) throws IOException
    {
        final Updater updater = new Updater ( this.admin );
        try ( Reader reader = new BufferedReader ( new FileReader ( file ) ) )
        {
            updater.loadJson ( reader );
        }

        final List<DiffEntry> changes = updater.getChanges ();
        if ( changes == null )
        {
            System.out.println ( "Unable to build changes" );
        }

        final List<List<String>> rows = new ArrayList<> ( changes.size () );

        for ( final DiffEntry entry : changes )
        {
            final List<String> row = new LinkedList<> ();
            rows.add ( row );

            row.add ( entry.getFactoryId () );
            row.add ( entry.getConfigurationId () );

            row.add ( entry.getOperation ().toString () );

            if ( entry.getOldData () != null )
            {
                row.add ( "" + entry.getOldData () );
            }
            else
            {
                row.add ( "" );
            }

            if ( entry.getAddedOrUpdatedData () != null )
            {
                row.add ( "" + entry.getAddedOrUpdatedData () );
            }
            else
            {
                row.add ( "" );
            }
        }

        Tables.showTable ( System.out, Arrays.asList ( "Factory ID", "Configuration ID", "Operation", "Old Data", "New Data" ), rows, 2 );
    }

    @Descriptor ( "Export the current CA to a JSON file" )
    public void export ( @Descriptor ( "The file to write to" )
    final File file) throws IOException
    {
        try ( OutputStream stream = new FileOutputStream ( file ) )
        {
            OscarWriter.writeData ( buildMap ( this.admin ), stream );
        }
        System.out.format ( "Output written to: %s%n", file.getAbsolutePath () );
    }

    private Map<String, String> parse ( final String[] data )
    {
        final Map<String, String> result = new HashMap<String, String> ();

        for ( final String word : data )
        {
            final String[] toks = word.split ( "=", 2 );
            if ( toks.length == 1 )
            {
                result.put ( toks[0], null );
            }
            else if ( toks.length == 2 )
            {
                result.put ( toks[0], toks[1] );
            }
        }

        return result;
    }
}
