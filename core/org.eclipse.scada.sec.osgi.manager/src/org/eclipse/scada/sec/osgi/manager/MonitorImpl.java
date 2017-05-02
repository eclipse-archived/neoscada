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
package org.eclipse.scada.sec.osgi.manager;

import org.eclipse.scada.sec.AuthorizationReply;
import org.eclipse.scada.sec.AuthorizationRequest;
import org.eclipse.scada.sec.authz.AuthorizationContext;
import org.eclipse.scada.sec.osgi.AuthorizationTracker.Listener;
import org.eclipse.scada.sec.osgi.AuthorizationTracker.Monitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonitorImpl implements Monitor
{

    private final static Logger logger = LoggerFactory.getLogger ( MonitorImpl.class );

    private final AuthorizationManagerImpl authorizationManagerImpl;

    private volatile Listener listener;

    private AuthorizationReply lastResult;

    private final AuthorizationContext context;

    public MonitorImpl ( final AuthorizationManagerImpl authorizationManagerImpl, final Listener listener, final AuthorizationRequest request )
    {
        this.authorizationManagerImpl = authorizationManagerImpl;
        this.listener = listener;

        this.context = new AuthorizationContext ();
        this.context.setRequest ( request );
    }

    @Override
    public void dispose ()
    {
        logger.debug ( "Dispose monitor" );
        this.listener = null;
        this.authorizationManagerImpl.disposeMonitor ( this );
    }

    public void setResult ( final AuthorizationReply result )
    {
        final Listener listener = this.listener;
        if ( listener != null )
        {

            if ( this.lastResult != null && this.lastResult.equals ( result ) )
            {
                return;
            }

            this.lastResult = result;

            logger.debug ( "Updating result - {}", result );

            try
            {
                listener.resultChanged ( result );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to notify listener", e );
            }
        }
    }

    public AuthorizationContext getContext ()
    {
        return this.context;
    }
}