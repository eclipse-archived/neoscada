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
package org.eclipse.scada.configuration.lib;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.Node;
import org.eclipse.scada.configuration.world.osgi.Connection;
import org.eclipse.scada.configuration.world.osgi.DataAccessConnection;
import org.eclipse.scada.configuration.world.osgi.DataAccessExporter;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.Exporter;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Locator
{

    private final static Logger logger = LoggerFactory.getLogger ( Locator.class );

    private Locator ()
    {
    }

    public static Collection<Endpoint> findLocalEndpoints ( final Exporter exp )
    {
        if ( ! ( exp.eContainer () instanceof EquinoxApplication ) )
        {
            return Collections.emptyList ();
        }
        final EquinoxApplication app = (EquinoxApplication)exp.eContainer ();
        if ( ! ( app.eContainer () instanceof Node ) )
        {
            return Collections.emptyList ();
        }
        return ( (Node)app.eContainer () ).getEndpoints ();
    }

    /**
     * Find all connections of a master server of the given type
     */
    public static <T extends Connection> List<T> findConnections ( final EquinoxApplication app, final Class<T> clazz )
    {
        final List<T> result = new LinkedList<> ();

        for ( final Connection connection : app.getConnections () )
        {
            if ( clazz.isAssignableFrom ( connection.getClass () ) )
            {
                result.add ( clazz.cast ( connection ) );
            }
        }

        return result;
    }

    /**
     * Find all connections of the give type from master server <q>from</q> to
     * master server <q>to</q>
     */
    public static <T extends Connection> List<T> findPossibleConnections ( final EquinoxApplication from, final EquinoxApplication to, final Class<T> clazz )
    {
        final List<T> result = new LinkedList<> ();

        for ( final T connection : findConnections ( from, clazz ) )
        {
            for ( final Exporter exporter : to.getExporter () )
            {
                final EList<Endpoint> possibleEndpoints = connection.getPossibleEndpoints ( exporter );
                if ( possibleEndpoints.isEmpty () )
                {
                    continue;
                }

                if ( possibleEndpoints.contains ( connection.getEndpoint () ) )
                {
                    result.add ( connection );
                }
            }
        }

        return result;
    }

    /**
     * Find exactly one connection between two master servers
     * <p>
     * Calls {@link #findPossibleConnections(MasterServer, MasterServer, Class)}
     * but fails if the result is not equal to
     * <q>one</q> exactly.
     * </p>
     */
    public static <T extends Connection> T findPossibleConnection ( final EquinoxApplication from, final EquinoxApplication to, final Class<T> clazz )
    {
        final List<T> result = findPossibleConnections ( from, to, clazz );
        if ( result.isEmpty () )
        {
            throw new IllegalStateException ( String.format ( "There must be exactly one connection of type %s. There is none.", clazz.getName () ) );
        }
        if ( result.size () > 1 )
        {
            throw new IllegalStateException ( String.format ( "There must be exactly one connection of type %s. There are %s.", clazz.getName (), result.size () ) );
        }
        return result.get ( 0 );
    }

    public static <T extends Exporter> List<T> findExporters ( final EObject start, final Class<T> clazz )
    {
        if ( ! ( start.eContainer () instanceof MasterServer ) )
        {
            return null;
        }

        final List<T> result = new LinkedList<> ();
        for ( final Exporter exporter : ( (MasterServer)start.eContainer () ).getExporter () )
        {
            if ( clazz.isAssignableFrom ( exporter.getClass () ) )
            {
                result.add ( clazz.cast ( exporter ) );
            }
        }

        return result;
    }

    public static <T extends Exporter> T findExporter ( final EObject start, final Class<T> clazz )
    {
        final List<T> result = findExporters ( start, clazz );
        if ( result.isEmpty () )
        {
            throw new IllegalStateException ( String.format ( "There must be exactly one exporter of type %s. There is none.", clazz.getName () ) );
        }
        if ( result.size () > 1 )
        {
            throw new IllegalStateException ( String.format ( "There must be exactly one exporter of type %s. There are %s.", clazz.getName (), result.size () ) );
        }
        return result.get ( 0 );
    }

    public static <T extends EquinoxApplication> T findApplication ( final EObject start, final Class<T> clazz )
    {
        EObject current = start;
        while ( current != null )
        {
            if ( clazz.isAssignableFrom ( current.getClass () ) )
            {
                return clazz.cast ( current );
            }
            current = current.eContainer ();
        }
        return null;
    }

    public static Connection findConnection ( final EquinoxApplication source, final Collection<Endpoint> target )
    {
        if ( source == null )
        {
            return null;
        }

        for ( final Endpoint ep : target )
        {
            for ( final Connection connection : source.getConnections () )
            {
                if ( connection.getEndpoint () == null )
                {
                    continue;
                }
                if ( connection.getEndpoint ().equals ( ep ) )
                {
                    return connection;
                }
            }
        }
        return null;
    }

    public static List<Endpoint> getSelfEndpoints ( final MasterServer master )
    {
        final List<Endpoint> result = new LinkedList<> ();

        if ( master == null )
        {
            return result;
        }

        final Map<Endpoint, Exporter> map = new HashMap<Endpoint, Exporter> ();

        // first gather all of our exporters
        for ( final Exporter exp : master.getExporter () )
        {
            if ( ! ( exp instanceof DataAccessExporter ) )
            {
                continue;
            }
            for ( final Endpoint endp : exp.getEndpoints () )
            {
                logger.debug ( "Recording endpoint - exporter {} -> {}", exp.getName (), endp.getName () );
                map.put ( endp, exp );
            }
        }

        // next get all connections that target endpoints that we export
        for ( final Connection con : master.getConnections () )
        {
            if ( ! ( con instanceof DataAccessConnection ) )
            {
                continue;
            }

            final Exporter exporter = map.get ( con.getEndpoint () );

            if ( exporter != null )
            {
                logger.debug ( "Connection points to - exporter: {}, endpoint: {}", exporter.getName (), con.getEndpoint ().getName () );
                result.add ( con.getEndpoint () );
            }
        }

        if ( result.isEmpty () )
        {
            throw new IllegalStateException ( "There is no connection to the local application instance. Create a DataAccess connection from the application to its own exporter." );
        }

        return result;
    }

    public static Connection findConnection ( final MasterServer master, final String name, final Class<DataAccessConnection> clazz )
    {
        for ( final Connection c : master.getConnections () )
        {
            if ( !clazz.isAssignableFrom ( c.getClass () ) )
            {
                continue;
            }
            if ( c.getName ().equals ( name ) )
            {
                return c;
            }
        }

        throw new IllegalStateException ( String.format ( "Unable to find a connection named '%s' of ype %s on %s", name, clazz.getName (), master ) );
    }

}
