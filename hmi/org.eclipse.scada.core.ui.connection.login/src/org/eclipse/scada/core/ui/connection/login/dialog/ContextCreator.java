/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.login.dialog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.scada.core.ui.connection.login.LoginContext;
import org.eclipse.scada.core.ui.connection.login.LoginFactory;
import org.eclipse.scada.core.ui.connection.login.LoginHandler;
import org.eclipse.scada.core.ui.connection.login.StateListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContextCreator
{

    private final static Logger logger = LoggerFactory.getLogger ( ContextCreator.class );

    private final LoginContext context;

    private final ContextCreatorListener listener;

    private final Realm realm;

    private final Set<LoginHandler> handlers = new HashSet<LoginHandler> ();

    private final ContextCreatorResultListener resultListener;

    private boolean complete = false;

    public ContextCreator ( final Realm realm, final LoginContext loginContext, final ContextCreatorListener listener, final ContextCreatorResultListener resultListener )
    {
        this.realm = realm;
        this.context = loginContext;
        this.listener = listener;
        this.resultListener = resultListener;
    }

    public void start ( final String username, final String password, final Map<String, String> properties )
    {
        for ( final LoginFactory factory : this.context.getFactories () )
        {
            try
            {
                final LoginHandler handler = factory.createHandler ( this.context, username, password, properties );
                if ( handler == null )
                {
                    notifyStateChange ( factory.getClass ().getName (), "MISSING", null );
                }
                else
                {
                    handler.setStateListener ( new StateListener () {

                        @Override
                        public void stateChanged ( final String connectionName, final String state, final Throwable error )
                        {
                            handleStateChange ( handler, connectionName, state, error );
                        }
                    } );
                    this.handlers.add ( handler );
                }
            }
            catch ( final Throwable e )
            {
                logger.warn ( "Failed to start logon", e );
                for ( final LoginHandler handler : this.handlers )
                {
                    handler.dispose ();
                }
                this.handlers.clear ();
                notifyStateChange ( factory.getClass ().getName (), "FAILED", e );
            }
        }

        if ( this.handlers.size () != this.context.getFactories ().size () )
        {
            // some handlers could not be created ... abort
            for ( final LoginHandler handler : this.handlers )
            {
                handler.dispose ();
            }
            this.handlers.clear ();
            notifyResult ( null );
        }
        else
        {
            // all got created now start the login process
            for ( final LoginHandler handler : this.handlers )
            {
                handler.startLogin ();
            }
        }
    }

    protected synchronized void handleStateChange ( final LoginHandler handler, final String connectionName, final String state, final Throwable error )
    {
        notifyStateChange ( connectionName, state, error );

        if ( isComplete () )
        {
            notifyResult ( allOk () ? new ArrayList<LoginHandler> ( this.handlers ) : null );
        }
    }

    private boolean isComplete ()
    {
        logger.debug ( "Check complete" ); //$NON-NLS-1$
        logger.debug ( "Handlers: {}", this.handlers ); //$NON-NLS-1$

        for ( final LoginHandler handler : this.handlers )
        {
            if ( !handler.isComplete () )
            {
                return false;
            }
        }
        return true;
    }

    private boolean allOk ()
    {
        for ( final LoginHandler handler : this.handlers )
        {
            if ( !handler.isOk () )
            {
                return false;
            }
        }
        return true;
    }

    public void dispose ()
    {
        if ( !this.complete )
        {
            notifyResult ( null );
        }

        for ( final LoginHandler handler : this.handlers )
        {
            handler.dispose ();
        }
        this.handlers.clear ();
    }

    private void notifyStateChange ( final String handlerName, final String state, final Throwable error )
    {
        if ( this.listener != null && handlerName != null )
        {
            logger.info ( "Fire state change - connection: {}, state: {}, error: {}", new Object[] { handlerName, state, error } ); //$NON-NLS-1$
            this.realm.asyncExec ( new Runnable () {

                @Override
                public void run ()
                {
                    ContextCreator.this.listener.stateChanged ( handlerName, state, error );
                }
            } );
        }
    }

    private void notifyResult ( final Collection<LoginHandler> result )
    {
        synchronized ( this )
        {
            if ( this.complete )
            {
                logger.warn ( "Somehow we wanted to send the result twice. Skipping!" ); //$NON-NLS-1$
                return;
            }
            this.complete = true;
        }

        // remove all our connection state listeners
        for ( final LoginHandler handler : this.handlers )
        {
            handler.setStateListener ( null );
        }

        if ( this.resultListener == null )
        {
            return;
        }

        // if we have a valid result the receive takes over control
        if ( result != null )
        {
            this.handlers.clear ();
        }

        this.realm.asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                ContextCreator.this.resultListener.complete ( result );
            }
        } );

    }

}
