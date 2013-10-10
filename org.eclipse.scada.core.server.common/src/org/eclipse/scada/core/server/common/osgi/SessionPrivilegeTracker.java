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
package org.eclipse.scada.core.server.common.osgi;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.sec.AuthorizationReply;
import org.eclipse.scada.sec.AuthorizationRequest;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.osgi.AuthorizationTracker;
import org.eclipse.scada.sec.osgi.AuthorizationTracker.Listener;
import org.eclipse.scada.sec.osgi.AuthorizationTracker.Monitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionPrivilegeTracker
{
    private final static Logger logger = LoggerFactory.getLogger ( SessionPrivilegeTracker.class );

    private final Set<Monitor> monitors = new LinkedHashSet<Monitor> ();

    private final Set<String> granted = new HashSet<String> ();

    private final Executor executor;

    private volatile PrivilegeListener listener;

    public interface PrivilegeListener
    {
        public void privilegesChanged ( Set<String> granted );
    }

    private class ListenerImpl implements Listener
    {
        private final String privilege;

        public ListenerImpl ( final String privilege )
        {
            this.privilege = privilege;
        }

        @Override
        public void resultChanged ( final AuthorizationReply result )
        {
            privilegeChange ( this.privilege, result );
        }
    }

    public SessionPrivilegeTracker ( final Executor executor, final PrivilegeListener listener, final AuthorizationTracker tracker, final Set<String> privileges, final UserInformation userInformation )
    {
        this.executor = executor;
        this.listener = listener;

        logger.debug ( "Start tracking privileges for user: {}", userInformation );

        synchronized ( this )
        {
            for ( final String privilege : privileges )
            {
                logger.debug ( "Start tracking: {}", privilege );
                final Monitor monitor = tracker.createMonitor ( new ListenerImpl ( privilege ), new AuthorizationRequest ( "SESSION", privilege, "PRIV", userInformation, null ) );
                this.monitors.add ( monitor );
            }
        }
    }

    public synchronized void privilegeChange ( final String privilege, final AuthorizationReply result )
    {
        logger.debug ( "Privilege change - privilege: {}, result: {}", privilege, result );
        if ( result.isGranted () )
        {
            this.granted.add ( privilege );
        }
        else
        {
            this.granted.remove ( privilege );
        }
        fireChange ( Collections.unmodifiableSet ( this.granted ) );
    }

    private void fireChange ( final Set<String> granted )
    {
        if ( this.listener == null )
        {
            return;
        }

        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                final PrivilegeListener listener = SessionPrivilegeTracker.this.listener;
                if ( listener != null )
                {
                    listener.privilegesChanged ( granted );
                }
            }
        } );
    }

    public void dispose ()
    {
        synchronized ( this )
        {
            this.listener = null;
        }

        for ( final Monitor monitor : this.monitors )
        {
            monitor.dispose ();
        }
        this.monitors.clear ();
    }
}
