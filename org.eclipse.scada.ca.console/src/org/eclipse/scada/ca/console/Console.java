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

import java.io.PrintStream;
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
    final String factoryId )
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
    final String configurationId )
    {
        final NotifyFuture<Configuration> future = this.admin.deleteConfiguration ( null, factoryId, configurationId );
        future.addListener ( new CommonResultPrinter ( System.out, String.format ( "delete - %s/%s", factoryId, configurationId ) ) );
    }

    @Descriptor ( "Create a new configuration" )
    public void create ( @Descriptor ( "The factory id" )
    final String factoryId, @Descriptor ( "The configuration id" )
    final String configurationId, @Descriptor ( "The configuration data in key=value format" )
    final String[] data )
    {
        final NotifyFuture<Configuration> future = this.admin.createConfiguration ( null, factoryId, configurationId, parse ( data ) );
        future.addListener ( new CommonResultPrinter ( System.out, String.format ( "create - %s/%s", factoryId, configurationId ) ) );
    }

    @Descriptor ( "Make a delta update to the configuration" )
    public void update ( @Descriptor ( "The factory id" )
    final String factoryId, @Descriptor ( "The configuration id" )
    final String configurationId, @Descriptor ( "The configuration data in key=value format" )
    final String[] data )
    {
        final NotifyFuture<Configuration> future = this.admin.updateConfiguration ( null, factoryId, configurationId, parse ( data ), false );
        future.addListener ( new CommonResultPrinter ( System.out, String.format ( "update - %s/%s", factoryId, configurationId ) ) );
    }

    @Descriptor ( "Make a full update to the configuration" )
    public void set ( @Descriptor ( "The factory id" )
    final String factoryId, @Descriptor ( "The configuration id" )
    final String configurationId, @Descriptor ( "The configuration data in key=value format" )
    final String[] data )
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
    final String factoryId )
    {
        final Configuration[] cfgs = this.admin.getConfigurations ( factoryId );

        final List<List<String>> rows = new LinkedList<List<String>> ();
        if ( cfgs != null )
        {
            for ( final Configuration cfg : cfgs )
            {
                final List<String> row = new LinkedList<String> ();
                row.add ( cfg.getId () );
                row.add ( cfg.getState ().toString () );
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
            System.out.println ( String.format ( "Factory '%s' does not exists", factoryId ) );
        }

    }

    @Descriptor ( "Show configuration" )
    public void show ( @Descriptor ( "The factory id" )
    final String factoryId, @Descriptor ( "The configuration id" )
    final String configurationId )
    {
        final Configuration cfg = this.admin.getConfiguration ( factoryId, configurationId );
        if ( cfg == null )
        {
            System.out.println ( String.format ( "Configuration %s/%s does not exists", factoryId, configurationId ) );
        }
        else
        {
            System.out.println ( String.format ( "%s - %s - %s", cfg.getFactoryId (), cfg.getId (), cfg.getState () ) );
            for ( final Map.Entry<String, String> entry : cfg.getData ().entrySet () )
            {
                System.out.println ( String.format ( "\t'%s' => '%s'", entry.getKey (), entry.getValue () ) );
            }
            if ( cfg.getErrorInformation () != null )
            {
                cfg.getErrorInformation ().printStackTrace ( System.out );
            }
        }
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
