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
package org.eclipse.scada.da.server.component;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

import org.eclipse.scada.core.subscription.SubscriptionManagerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Component
{
    private class PatternActivationListener implements SubscriptionManagerListener<String>
    {
        private final Pattern pattern;

        private int count;

        private ActivationHandle handle;

        public PatternActivationListener ( final Pattern pattern )
        {
            this.pattern = pattern;
        }

        @Override
        public synchronized void subscriptionsAdded ( final Set<String> additions )
        {
            for ( final String itemId : additions )
            {
                logger.trace ( "Checking item: {}", itemId );

                if ( this.pattern.matcher ( itemId ).find () )
                {
                    logger.trace ( "Increment: {} (before)", this.count );
                    this.count++;
                }
            }
            if ( this.count == 1 )
            {
                logger.debug ( "Activate" );
                PatternActivationListener.this.handle = activate ();
            }
        }

        @Override
        public synchronized void subscriptionsRemoved ( final Set<String> removals )
        {
            for ( final String itemId : removals )
            {
                logger.trace ( "Checking item: {}", itemId );
                if ( this.pattern.matcher ( itemId ).find () )
                {
                    logger.trace ( "Decrement: {} (before)", this.count );
                    this.count--;
                }
            }
            if ( this.count == 0 )
            {
                logger.debug ( "Deactivate" );
                if ( this.handle != null )
                {
                    this.handle.dispose ();
                    this.handle = null;
                }
            }
        }
    }

    private final static Logger logger = LoggerFactory.getLogger ( Component.class );

    private final Executor executor;

    private final SubscriptionManagerListener<String> subscriptionListener;

    private final ComponentHost componentHost;

    private final String name;

    public Component ( final Executor executor, final ComponentHost componentHost, final String activationPrefix )
    {
        this.executor = executor;
        this.componentHost = componentHost;

        this.name = activationPrefix;

        this.subscriptionListener = new PatternActivationListener ( Pattern.compile ( "^" + Pattern.quote ( activationPrefix ) ) );

        componentHost.addItemSubscriptionListener ( this.subscriptionListener );
    }

    public void dispose ()
    {
        this.componentHost.removeItemSubscriptionListener ( this.subscriptionListener );
        stop ();
    }

    public ActivationHandle activate ()
    {
        final ActivationHandle result = register ( new ActivationHandle () {

            @Override
            public void dispose ()
            {
                unregister ( this );
            }
        } );

        logger.debug ( "Request to activate component: {} -> {}", this.name, result );

        return result;
    }

    private final Set<ActivationHandle> handles = new HashSet<> ();

    private synchronized ActivationHandle register ( final ActivationHandle activationHandle )
    {
        final boolean wasEmpty = this.handles.isEmpty ();

        this.handles.add ( activationHandle );

        if ( wasEmpty && !this.handles.isEmpty () )
        {
            start ();
        }

        return activationHandle;
    }

    private synchronized void unregister ( final ActivationHandle activationHandle )
    {
        logger.debug ( "Unregistering activation: {} -> {}", this.name, activationHandle );

        final boolean wasEmpty = this.handles.isEmpty ();
        this.handles.remove ( activationHandle );

        if ( !wasEmpty && this.handles.isEmpty () )
        {
            stop ();
        }
    }

    public synchronized void start ()
    {
        logger.debug ( "Start" );
        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                logger.debug ( "Perform start" );
                performStart ();
            }
        } );
    }

    public synchronized void stop ()
    {
        logger.debug ( "Stop" );
        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                logger.debug ( "Perform stop" );
                performStop ();
            }
        } );
        logger.debug ( "Component stopped" );
    }

    protected abstract void performStart ();

    protected abstract void performStop ();

    @Override
    public String toString ()
    {
        return String.format ( "[Component: %s]", this.name );
    }
}
