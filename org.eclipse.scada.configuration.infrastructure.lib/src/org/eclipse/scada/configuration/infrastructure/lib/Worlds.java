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
package org.eclipse.scada.configuration.infrastructure.lib;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.infrastructure.CommonDriver;
import org.eclipse.scada.configuration.infrastructure.Driver;
import org.eclipse.scada.configuration.infrastructure.EquinoxBase;
import org.eclipse.scada.configuration.infrastructure.EquinoxDriver;
import org.eclipse.scada.configuration.infrastructure.ExternalDriver;
import org.eclipse.scada.configuration.infrastructure.MasterImport;
import org.eclipse.scada.configuration.infrastructure.Node;
import org.eclipse.scada.configuration.infrastructure.Options;
import org.eclipse.scada.configuration.infrastructure.SystemPropertyUserService;
import org.eclipse.scada.configuration.infrastructure.UserService;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.configuration.infrastructure.lib.internal.SystemPropertiesUserServiceProcessor;
import org.eclipse.scada.configuration.lib.Endpoints;
import org.eclipse.scada.configuration.lib.Properties;
import org.eclipse.scada.configuration.security.Configuration;
import org.eclipse.scada.configuration.utils.Containers;
import org.eclipse.scada.configuration.world.Credentials;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.PasswordCredentials;
import org.eclipse.scada.configuration.world.PropertyEntry;
import org.eclipse.scada.configuration.world.UsernamePasswordCredentials;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.JdbcUserServiceModule;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;

public final class Worlds
{

    private Worlds ()
    {
    }

    /**
     * Find the credentials for accessing a driver
     * 
     * @param driver
     *            the driver to access
     * @return the credentials or <code>null</code> if there are none
     */
    public static Credentials findConnectionPassword ( final Driver driver )
    {
        if ( driver instanceof CommonDriver )
        {
            return findCommonConnectionPassword ( (CommonDriver)driver );
        }
        else if ( driver instanceof EquinoxDriver )
        {
            return findEquinoxConnectionPassword ( (EquinoxDriver)driver );
        }
        else if ( driver instanceof ExternalDriver )
        {
            return findExternalConnectionPassword ( (ExternalDriver)driver );
        }
        return null;
    }

    protected static Credentials findEquinoxConnectionPassword ( final EquinoxDriver driver )
    {
        if ( driver.getAccessCredentials () != null )
        {
            return driver.getAccessCredentials ();
        }

        return findDefaultAccessCredentials ( driver );
    }

    protected static Credentials findCommonConnectionPassword ( final CommonDriver driver )
    {
        if ( driver.getPassword () != null )
        {
            return driver.getPassword ();
        }

        return findDefaultAccessCredentials ( driver );
    }

    protected static Credentials findDefaultAccessCredentials ( final Driver driver )
    {
        final org.eclipse.scada.configuration.infrastructure.World world = Containers.findContainer ( driver, org.eclipse.scada.configuration.infrastructure.World.class );
        if ( world == null )
        {
            return null;
        }

        if ( world.getDefaultDriverAccessCredentials () != null )
        {
            return world.getDefaultCredentials ();
        }

        if ( driver instanceof CommonDriver )
        {
            return world.getDefaultDriverPassword ();
        }
        return null;
    }

    protected static Credentials findExternalConnectionPassword ( final ExternalDriver driver )
    {
        if ( driver.getAccessCredentials () != null )
        {
            return driver.getAccessCredentials ();
        }

        return findDefaultAccessCredentials ( driver );
    }

    /**
     * Find the password for a common driver
     * 
     * @param driver
     *            the driver to check
     * @return the password credentials, or <code>null</code> if was none
     */
    public static PasswordCredentials findCommonDriverPassword ( final CommonDriver driver )
    {
        if ( driver.getPassword () != null )
        {
            return driver.getPassword ();
        }

        final org.eclipse.scada.configuration.infrastructure.World world = Containers.findContainer ( driver, org.eclipse.scada.configuration.infrastructure.World.class );
        if ( world == null )
        {
            return null;
        }

        return world.getDefaultDriverPassword ();
    }

    /**
     * Find the access credentials for the target master server
     * 
     * @param app
     *            the master server
     * @return the access credentials, or <code>null</code> if there were none
     */
    public static Credentials findInterconnectCredentials ( final org.eclipse.scada.configuration.infrastructure.EquinoxApplication app )
    {
        if ( app.getLocalCredentials () != null )
        {
            return app.getLocalCredentials ();
        }
        else
        {
            final org.eclipse.scada.configuration.infrastructure.World world = Containers.findContainer ( app, org.eclipse.scada.configuration.infrastructure.World.class );
            if ( world == null )
            {
                return null;
            }
            return world.getDefaultCredentials ();
        }
    }

    /**
     * Find the access credentials for the target
     * 
     * @param masterImport
     *            the target
     * @return the access credentials, or <code>null</code> if there were none
     */
    public static Credentials findConnectionCredentials ( final MasterImport masterImport )
    {
        if ( masterImport.getCredentials () != null )
        {
            return masterImport.getCredentials ();
        }
        return findInterconnectCredentials ( masterImport.getImportedMaster () );
    }

    public static Endpoint createDaEndpoint ( final Options options, final Driver driver )
    {
        if ( driver instanceof CommonDriver )
        {
            return Endpoints.createEndpoint ( ( (CommonDriver)driver ).getPortNumber (), "CommonDriver Endpoint: " + driver.getName () );
        }
        else if ( driver instanceof EquinoxBase )
        {
            return Endpoints.createEndpoint ( options.getBaseDaNgpPort () + ( (EquinoxBase)driver ).getInstanceNumber (), "EquinoxDriver Endpoint: " + driver.getName () );
        }
        else if ( driver instanceof ExternalDriver )
        {
            return Endpoints.createEndpoint ( ( (ExternalDriver)driver ).getPortNumber (), "ExternalDriver Endpoint: " + driver.getName () );
        }
        throw new IllegalStateException ( String.format ( "Unable to create DA endpoint for driver type: %s", driver.getClass ().getName () ) );
    }

    public static Configuration findSecurityConfiguration ( final EquinoxBase eDriver )
    {
        final World world = Containers.findContainer ( eDriver, World.class );

        if ( eDriver.getSecurityConfiguration () != null )
        {
            return eDriver.getSecurityConfiguration ();
        }
        else if ( world != null )
        {
            return world.getDefaultSecurityConfiguration ();
        }
        return null;
    }

    public static UserService findUserService ( final EquinoxBase app )
    {
        if ( app.getUserService () != null )
        {
            return app.getUserService ();
        }

        final World world = Containers.findContainer ( app, World.class );
        final Options options = world.getOptions ();

        if ( options != null && options.getDefaultUserService () != null )
        {
            return options.getDefaultUserService ();
        }

        return null;
    }

    public static void addUserService ( final EquinoxApplication application, final EquinoxBase driver )
    {
        final World world = Containers.findContainer ( driver, World.class );
        addUserService ( application, findUserService ( driver ), world.getOptions () );
    }

    public static void addUserService ( final EquinoxApplication application, UserService userService, final Options options )
    {
        if ( userService == null )
        {
            userService = options.getDefaultUserService ();
        }
        if ( userService == null )
        {
            return;
        }

        // TODO: allow other types of user service
        if ( userService instanceof org.eclipse.scada.configuration.infrastructure.JdbcUserService )
        {
            final JdbcUserServiceModule module = OsgiFactory.eINSTANCE.createJdbcUserServiceModule ();
            module.getUserServices ().add ( EcoreUtil.copy ( ( (org.eclipse.scada.configuration.infrastructure.JdbcUserService)userService ).getImplementation () ) );
            application.getModules ().add ( module );
        }
        else if ( userService instanceof SystemPropertyUserService )
        {
            new SystemPropertiesUserServiceProcessor ( (SystemPropertyUserService)userService ).process ( application );
        }
        else
        {
            throw new IllegalStateException ( String.format ( "User service type '%s' is currently unsupported", userService.getClass () ) );
        }
    }

    public static boolean isLocal ( final Node node1, final Node node2 )
    {
        return node1.getHostName ().equals ( node2.getHostName () );
    }

    public static String makeHostname ( final Node from, final Node to )
    {
        if ( isLocal ( from, to ) )
        {
            return "localhost"; //$NON-NLS-1$
        }
        else
        {
            return to.getHostName ();
        }
    }

    public static Collection<PropertyEntry> convertToProperties ( final Credentials creds )
    {
        final Collection<PropertyEntry> result = new LinkedList<> ();

        if ( creds instanceof PasswordCredentials )
        {
            result.add ( Properties.create ( "password", ( (PasswordCredentials)creds ).getPassword () ) );
        }
        else if ( creds instanceof UsernamePasswordCredentials )
        {
            result.add ( Properties.create ( "user", ( (UsernamePasswordCredentials)creds ).getUsername () ) );
            result.add ( Properties.create ( "password", ( (UsernamePasswordCredentials)creds ).getPassword () ) );
        }

        return result;
    }

    public static String makeConnectionName ( final Driver driver )
    {
        final Node node = driver.getNode ();
        String name = node.getName ();
        if ( name == null )
        {
            name = node.getHostName ();
        }

        return "driver." + driver.getName () + ".on." + name;
    }

}
