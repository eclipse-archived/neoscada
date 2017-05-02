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
package org.eclipse.scada.core.server.common.session;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.eclipse.scada.core.server.Session;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.callback.Callback;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractSessionImpl implements Session
{
    private final static Logger logger = LoggerFactory.getLogger ( AbstractSessionImpl.class );

    private final UserInformation userInformation;

    private final Map<String, String> properties;

    private volatile Set<String> privileges = new HashSet<String> ();

    private final Set<SessionListener> listeners = new CopyOnWriteArraySet<Session.SessionListener> ();

    private final Set<DisposeListener> disposeListeners = new LinkedHashSet<DisposeListener> ();

    private boolean disposed;

    private final Set<SessionCallbackHandler> sessionCallbackHandlers = new HashSet<AbstractSessionImpl.SessionCallbackHandler> ();

    public interface DisposeListener
    {
        public void disposed ();
    }

    public AbstractSessionImpl ( final UserInformation userInformation, final Map<String, String> properties )
    {
        this.userInformation = userInformation;
        this.properties = properties != null ? new HashMap<String, String> ( properties ) : Collections.<String, String> emptyMap ();
    }

    @Override
    public Map<String, String> getProperties ()
    {
        return Collections.unmodifiableMap ( this.properties );
    }

    public UserInformation getUserInformation ()
    {
        return this.userInformation;
    }

    public void dispose ()
    {
        if ( this.disposed )
        {
            return;
        }

        this.disposed = true;

        final HashSet<SessionCallbackHandler> handlers;
        synchronized ( this.sessionCallbackHandlers )
        {
            handlers = new HashSet<SessionCallbackHandler> ( this.sessionCallbackHandlers );
            this.sessionCallbackHandlers.clear ();
        }

        for ( final SessionCallbackHandler handler : handlers )
        {
            handler.dispose ();
        }

        for ( final DisposeListener listener : this.disposeListeners )
        {
            try
            {
                listener.disposed ();
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to handle dispose", e );
            }
        }
    }

    public void addDisposeListener ( final DisposeListener disposeListener )
    {
        this.disposeListeners.add ( disposeListener );
    }

    public void removeDisposeListener ( final DisposeListener disposeListener )
    {
        this.disposeListeners.remove ( disposeListener );
    }

    @Override
    public void addSessionListener ( final SessionListener listener )
    {
        if ( this.listeners.add ( listener ) )
        {
            listener.privilegeChange ();
        }
    }

    @Override
    public void removeSessionListener ( final SessionListener listener )
    {
        this.listeners.remove ( listener );
    }

    protected void firePrivilegeChange ()
    {
        for ( final SessionListener listener : this.listeners )
        {
            listener.privilegeChange ();
        }
    }

    public void setPrivileges ( final Set<String> privileges )
    {
        this.privileges = privileges;
        firePrivilegeChange ();
    }

    @Override
    public Set<String> getPrivileges ()
    {
        return this.privileges;
    }

    private class SessionCallbackHandler implements CallbackHandler
    {
        private final CallbackHandler callbackHandler;

        private NotifyFuture<Callback[]> future;

        public SessionCallbackHandler ( final CallbackHandler callbackHandler )
        {
            this.callbackHandler = callbackHandler;
        }

        @Override
        public NotifyFuture<Callback[]> performCallback ( final Callback[] callbacks )
        {
            this.future = this.callbackHandler.performCallback ( callbacks );
            this.future.addListener ( new Runnable () {

                @Override
                public void run ()
                {
                    removeCallbackHandler ( SessionCallbackHandler.this );
                }
            } );
            return this.future;
        }

        public void dispose ()
        {
            if ( this.future != null )
            {
                this.future.cancel ( false );
            }
        }

    }

    /**
     * @param callbackHandler
     * @since 1.1
     */
    public CallbackHandler wrapCallbackHandler ( final CallbackHandler callbackHandler )
    {
        if ( callbackHandler == null || this.disposed )
        {
            return null;
        }

        final SessionCallbackHandler sch = new SessionCallbackHandler ( callbackHandler );
        addCallbackHandler ( sch );
        return sch;
    }

    private void addCallbackHandler ( final SessionCallbackHandler sessionCallbackHandler )
    {
        synchronized ( this.sessionCallbackHandlers )
        {
            this.sessionCallbackHandlers.add ( sessionCallbackHandler );
        }
    }

    private void removeCallbackHandler ( final SessionCallbackHandler sessionCallbackHandler )
    {
        synchronized ( this.sessionCallbackHandlers )
        {
            this.sessionCallbackHandlers.remove ( sessionCallbackHandler );
        }
    }
}
