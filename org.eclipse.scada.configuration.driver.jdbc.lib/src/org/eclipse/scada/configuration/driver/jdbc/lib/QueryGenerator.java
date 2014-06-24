/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.driver.jdbc.lib;

import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.generator.DriverGenerator;
import org.eclipse.scada.configuration.driver.jdbc.JdbcDriverInstance;
import org.eclipse.scada.configuration.driver.jdbc.QueryBase;
import org.eclipse.scada.configuration.infrastructure.DatabaseSettings;
import org.eclipse.scada.configuration.world.PropertyEntry;
import org.eclipse.scada.da.server.jdbc.configuration.ConfigurationFactory;
import org.eclipse.scada.da.server.jdbc.configuration.ConnectionType;
import org.eclipse.scada.da.server.jdbc.configuration.RootType;

public abstract class QueryGenerator<T extends QueryBase & DataComponent> extends DriverGenerator
{
    private final T component;

    public QueryGenerator ( final T component )
    {
        super ( component );
        this.component = component;
    }

    @Override
    public JdbcDriverInstance findDriver ()
    {
        final JdbcDriverInstance driver = (JdbcDriverInstance)this.context.getDriverMap ().get ( this.component.getRunsOn () );
        if ( driver == null )
        {
            throw new IllegalStateException ( String.format ( "Query component %s has no driver assigned", this.component ) );
        }
        return driver;
    }

    public RootType findRoot ()
    {
        final JdbcDriverInstance driver = findDriver ();

        RootType root = driver.getRoot ();
        if ( root != null )
        {
            return root;
        }
        else
        {
            root = ConfigurationFactory.eINSTANCE.createRootType ();
            driver.setRoot ( root );
            return root;
        }
    }

    protected ConnectionType findConnection ( final DatabaseSettings database )
    {
        final RootType root = findRoot ();
        for ( final ConnectionType con : root.getConnection () )
        {
            if ( con.getId ().equals ( database.getId () ) )
            {
                return con;
            }
        }

        final ConnectionType con = ConfigurationFactory.eINSTANCE.createConnectionType ();

        con.setId ( database.getId () );
        con.setConnectionClass ( database.getDriverName () );
        con.setUsername ( database.getUser () );
        con.setPassword ( database.getPassword () );
        con.setUri ( database.getUri () );

        // convert types
        for ( final PropertyEntry pe : database.getProperties () )
        {
            final org.eclipse.scada.da.server.jdbc.configuration.PropertyEntry npe = ConfigurationFactory.eINSTANCE.createPropertyEntry ();
            npe.setKey ( pe.getKey () );
            npe.setValue ( pe.getValue () );
            con.getProperty ().add ( npe );
        }

        root.getConnection ().add ( con );

        return con;
    }

    protected String makeUpdateName ( final String name )
    {
        return String.format ( "%s.%s.START", this.component.getDatabase ().getId (), name );
    }

    protected String makeQueryColumnName ( final String queryName, final String columnName )
    {
        return String.format ( "%s.%s.%s", this.component.getDatabase ().getId (), queryName, columnName );
    }
}
