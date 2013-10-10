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
package org.eclipse.scada.core.client.net;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.apache.mina.core.session.IoSession;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.client.PrivilegeListener;
import org.eclipse.scada.core.net.ConnectionHelper;
import org.eclipse.scada.core.net.MessageHelper;
import org.eclipse.scada.net.Constants;
import org.eclipse.scada.net.base.MessageListener;
import org.eclipse.scada.net.base.MessageStateListener;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SessionConnectionBase extends ConnectionBase
{
    private final static Logger logger = LoggerFactory.getLogger ( SessionConnectionBase.class );

    public static final String SESSION_CLIENT_VERSION = "client-version"; //$NON-NLS-1$

    private final ConnectionInformation connectionInformation;

    protected ScheduledExecutorService executor;

    private final Set<PrivilegeListener> privilegeListeners = new LinkedHashSet<PrivilegeListener> ();

    private volatile Set<String> currentPrivileges;

    public SessionConnectionBase ( final ConnectionInformation connectionInformation )
    {
        super ( connectionInformation );

        this.connectionInformation = connectionInformation;

        this.executor = Executors.newSingleThreadScheduledExecutor ( new NamedThreadFactory ( "ConnectionExecutor/" + getConnectionInformation ().toMaskedString () ) );

        this.messenger.setHandler ( MessageHelper.CC_PRIV_CHANGE, new MessageListener () {

            @Override
            public void messageReceived ( final Message message ) throws Exception
            {
                handlePrivChange ( MessageHelper.getPrivileges ( message ) );
            }
        } );
    }

    public abstract String getRequiredVersion ();

    @Override
    public void dispose ()
    {
        super.dispose ();

        this.executor.shutdown ();
    }

    @Override
    protected void onConnectionEstablished ()
    {
        requestSession ();
    }

    @Override
    protected void onConnectionClosed ()
    {
        super.onConnectionClosed ();
        handlePrivChange ( Collections.<String> emptySet () );
    }

    protected void requestSession ()
    {
        final Properties props = new Properties ();
        props.putAll ( this.connectionInformation.getProperties () );

        props.setProperty ( SESSION_CLIENT_VERSION, getRequiredVersion () );
        props.put ( MessageHelper.PROP_USING_SESSION_START, "true" );

        final String username = getConnectionInformation ().getProperties ().get ( ConnectionInformation.PROP_USER );
        final String password = getConnectionInformation ().getProperties ().get ( ConnectionInformation.PROP_PASSWORD );

        if ( username != null && password != null )
        {
            props.put ( ConnectionInformation.PROP_USER, username );
            props.put ( ConnectionInformation.PROP_PASSWORD, password );
        }
        else if ( username != null )
        {
            props.put ( ConnectionInformation.PROP_USER, username );
        }

        this.messenger.sendMessage ( MessageHelper.createSession ( props ), new MessageStateListener () {

            @Override
            public void messageReply ( final Message message )
            {
                processSessionReply ( message );
            }

            @Override
            public void messageTimedOut ()
            {
                disconnect ( new OperationTimedOutException ().fillInStackTrace () );
            }
        }, getMessageTimeout () );

    }

    protected void processSessionReply ( final Message message )
    {
        logger.debug ( "Got session reply!" ); //$NON-NLS-1$

        if ( message.getValues ().containsKey ( Message.FIELD_ERROR_INFO ) )
        {
            final String errorInfo = message.getValues ().get ( Message.FIELD_ERROR_INFO ).toString ();
            disconnect ( new DisconnectReason ( String.format ( Messages.getString ( "SessionConnectionBase.Error" ), errorInfo ) ).fillInStackTrace () ); //$NON-NLS-1$
        }
        else if ( message.getCommandCode () != Message.CC_ACK )
        {
            disconnect ( new DisconnectReason ( Messages.getString ( "SessionConnectionBase.InvalidReply" ) ).fillInStackTrace () ); //$NON-NLS-1$
        }
        else
        {
            final Properties properties = new Properties ();
            MessageHelper.getProperties ( properties, message.getValues ().get ( MessageHelper.FIELD_SESSION_PROPERTIES ) );
            logger.debug ( "Session properties: {}", properties );

            final Properties transportProperties = new Properties ();
            MessageHelper.getProperties ( transportProperties, message.getValues ().get ( MessageHelper.FIELD_TRANSPORT_PROPERTIES ) );
            logger.debug ( "Transport properties: {}", transportProperties );

            modifyFilterChain ( this.session, transportProperties );

            this.messenger.sendMessage ( new Message ( MessageHelper.CC_START_SESSION ) );

            setBound ( properties );
        }
    }

    protected void modifyFilterChain ( final IoSession session, final Properties properties )
    {
        ConnectionHelper.injectCompression ( session, properties.getProperty ( Constants.PROP_TR_COMPRESSION ) );
    }

    protected synchronized void handlePrivChange ( final Set<String> privileges )
    {
        final Set<String> newPrivs = Collections.unmodifiableSet ( privileges );
        this.currentPrivileges = newPrivs;

        logger.info ( "Privilege change: {}", privileges );

        for ( final PrivilegeListener listener : this.privilegeListeners )
        {
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    listener.privilegesChanged ( newPrivs );
                }
            } );
        }
    }

    @Override
    public synchronized void addPrivilegeListener ( final PrivilegeListener listener )
    {
        final Set<String> newPrivs = this.currentPrivileges;

        if ( this.privilegeListeners.add ( listener ) )
        {
            // send initial state
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    listener.privilegesChanged ( newPrivs );
                }
            } );
        }
    }

    @Override
    public synchronized void removePrivilegeListener ( final PrivilegeListener listener )
    {
        this.privilegeListeners.remove ( listener );
    }

    @Override
    public Set<String> getPrivileges ()
    {
        return Collections.unmodifiableSet ( this.currentPrivileges );
    }

}
