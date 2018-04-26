/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.login.factory;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.sec.callback.PropertiesCredentialsCallback;
import org.eclipse.scada.core.ui.connection.creator.ConnectionCreatorHelper;
import org.eclipse.scada.core.ui.connection.login.LoginContext;
import org.eclipse.scada.core.ui.connection.login.LoginFactory;
import org.eclipse.scada.core.ui.connection.login.LoginHandler;
import org.eclipse.scada.core.ui.connection.login.factory.internal.ConnectionLoginHandler;
import org.eclipse.scada.core.ui.connection.login.factory.internal.LoginConnection;
import org.eclipse.scada.core.ui.connection.login.factory.internal.LoginConnection.Mode;

/**
 * A login factory which builds up Eclipse SCADA connections
 * <p>
 * This factory feeds on the same extension point the login context does. This
 * should be changed in the future.
 * </p>
 * 
 * @author Jens Reimann
 */
public class ConnectionLoginFactory implements LoginFactory
{
    public static final String OPTION_CREDENTIALS_AS_PROPERTIES = "credentialsAsProperties";

    @Override
    public LoginHandler createHandler ( final LoginContext context, final String username, final String password, final Map<String, String> properties ) throws Exception
    {
        final Collection<LoginHandler> handlers = new LinkedList<LoginHandler> ();

        for ( final LoginConnection loginConnection : loadConnections ( context.getId () ) )
        {
            CallbackHandler callbackHandler;
            final ConnectionInformation.Builder cib = new ConnectionInformation.Builder ( loginConnection.getConnectionInformation () );
            if ( !loginConnection.isUseCallbacks () || properties.containsKey ( OPTION_CREDENTIALS_AS_PROPERTIES ) )
            {
                cib.setUser ( username );
                cib.setPassword ( password );
                callbackHandler = null;
            }
            else
            {
                callbackHandler = new PropertiesCredentialsCallback ( username, password );
            }

            final ConnectionService connectionService = ConnectionCreatorHelper.createConnection ( cib.build (), loginConnection.getAutoReconnectDelay (), loginConnection.getMode () == Mode.LAZY );
            if ( connectionService == null )
            {
                // dispose already created first
                disposeAll ( handlers );

                // now throw
                throw new IllegalStateException ( String.format ( "Unable to find connection creator for connection %s", loginConnection.getConnectionInformation ().toMaskedString () ) );
            }
            else
            {
                handlers.add ( new ConnectionLoginHandler ( connectionService, loginConnection, callbackHandler ) );
            }
        }

        return new MultiLoginHandler ( handlers );
    }

    protected Set<LoginConnection> loadConnections ( final String contextId )
    {
        final Set<LoginConnection> result = new HashSet<LoginConnection> ();

        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( "org.eclipse.scada.core.ui.connection.login.context" ) ) //$NON-NLS-1$
        {
            if ( !"context".equals ( ele.getName () ) ) //$NON-NLS-1$
            {
                continue;
            }

            if ( !contextId.equals ( ele.getAttribute ( "id" ) ) )
            {
                continue;
            }

            for ( final IConfigurationElement child : ele.getChildren ( "connection" ) )
            {
                final ConnectionInformation ci = ConnectionInformation.fromURI ( child.getAttribute ( "uri" ) );

                if ( ci == null )
                {
                    throw new IllegalArgumentException ( String.format ( "Unable to parse connection uri: %s", child.getAttribute ( "uri" ) ) );
                }

                final Set<String> servicePids = new HashSet<String> ();

                final String modeString = child.getAttribute ( "mode" );
                final LoginConnection.Mode mode = modeString == null ? Mode.NORMAL : Mode.valueOf ( modeString );

                // load single service pid
                addServicePid ( servicePids, child.getAttribute ( "servicePid" ) );

                // load multi service pids
                for ( final IConfigurationElement registrationElement : child.getChildren ( "registration" ) )
                {
                    addServicePid ( servicePids, registrationElement.getAttribute ( "servicePid" ) );
                }

                final Integer servicePriority;
                if ( child.getAttribute ( "servicePriority" ) != null )
                {
                    servicePriority = Integer.parseInt ( child.getAttribute ( "servicePriority" ) );
                }
                else
                {
                    servicePriority = null;
                }

                final Integer autoReconnectDelay;
                if ( child.getAttribute ( "autoReconnectDelay" ) != null )
                {
                    autoReconnectDelay = Integer.parseInt ( child.getAttribute ( "autoReconnectDelay" ) );
                }
                else
                {
                    autoReconnectDelay = null;
                }

                final boolean useCallbacks = Boolean.parseBoolean ( child.getAttribute ( "authUseCallbacks" ) );

                final LoginConnection lc = new LoginConnection ( ci, servicePids, autoReconnectDelay, servicePriority, mode, useCallbacks );
                result.add ( lc );
            }
        }

        return result;
    }

    private void addServicePid ( final Set<String> servicePids, final String attribute )
    {
        if ( attribute != null && !attribute.isEmpty () )
        {
            servicePids.add ( attribute );
        }
    }

    private void disposeAll ( final Collection<LoginHandler> handler )
    {
        for ( final LoginHandler service : handler )
        {
            service.dispose ();
        }
        handler.clear ();
    }

}
