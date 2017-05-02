/*******************************************************************************
 * Copyright (c) 2006, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.osgi.pool;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker.ObjectPoolServiceListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractObjectPoolServiceTracker<S>
{
    private final static Logger logger = LoggerFactory.getLogger ( AbstractObjectPoolServiceTracker.class );

    private final ObjectPoolTracker<S> poolTracker;

    private final ObjectPoolServiceListener<S> poolListener;

    protected final String serviceId;

    private final Map<ObjectPool<S>, PoolHandler> poolMap = new HashMap<ObjectPool<S>, PoolHandler> ( 1 );

    protected class PoolHandler implements ObjectPoolListener<S>
    {
        private final ObjectPool<S> pool;

        private final String serviceId;

        private final Map<S, Dictionary<?, ?>> services = new HashMap<S, Dictionary<?, ?>> ( 1 );

        public PoolHandler ( final ObjectPool<S> pool, final String serviceId )
        {
            this.pool = pool;
            this.serviceId = serviceId;

            synchronized ( this )
            {
                this.pool.addListener ( this.serviceId, this );
            }
        }

        public synchronized void dispose ()
        {
            Map<S, Dictionary<?, ?>> services;
            synchronized ( this )
            {
                this.pool.removeListener ( this.serviceId, this );
                services = new HashMap<S, Dictionary<?, ?>> ( this.services );
                this.services.clear ();
            }

            for ( final Map.Entry<S, Dictionary<?, ?>> entry : services.entrySet () )
            {
                fireServiceRemoved ( entry.getKey (), entry.getValue () );
            }
        }

        @Override
        public void serviceAdded ( final S service, final Dictionary<?, ?> properties )
        {
            synchronized ( this )
            {
                this.services.put ( service, properties );
            }
            fireServiceAdded ( service, properties );
        }

        private void fireServiceAdded ( final S service, final Dictionary<?, ?> properties )
        {
            logger.debug ( "Service added to pool: {} -> {}", new Object[] { this.serviceId, service } );
            handleServiceAdded ( service, properties );
        }

        @Override
        public void serviceModified ( final S service, final Dictionary<?, ?> properties )
        {
            synchronized ( this )
            {
                this.services.put ( service, properties );
            }
            fireServiceModified ( service, properties );
        }

        private void fireServiceModified ( final S service, final Dictionary<?, ?> properties )
        {
            handleServiceModified ( service, properties );
        }

        @Override
        public void serviceRemoved ( final S service, final Dictionary<?, ?> properties )
        {
            final Dictionary<?, ?> oldProperties;
            synchronized ( this )
            {
                oldProperties = this.services.remove ( service );
            }

            if ( oldProperties != null )
            {
                fireServiceRemoved ( service, properties );
            }
        }

        private void fireServiceRemoved ( final S service, final Dictionary<?, ?> properties )
        {
            handleServiceRemoved ( service, properties );
        }
    }

    public AbstractObjectPoolServiceTracker ( final ObjectPoolTracker<S> poolTracker, final String serviceId )
    {
        this.serviceId = serviceId;
        this.poolTracker = poolTracker;

        this.poolListener = new ObjectPoolServiceListener<S> () {

            @Override
            public void poolRemoved ( final ObjectPool<S> objectPool )
            {
                AbstractObjectPoolServiceTracker.this.handlePoolRemove ( objectPool );
            }

            @Override
            public void poolModified ( final ObjectPool<S> objectPool, final int newPriority )
            {
                AbstractObjectPoolServiceTracker.this.handlePoolModified ( objectPool, newPriority );
            }

            @Override
            public void poolAdded ( final ObjectPool<S> objectPool, final int priority )
            {
                AbstractObjectPoolServiceTracker.this.handlePoolAdd ( objectPool, priority );
            }
        };
    }

    protected abstract void handleServiceAdded ( final S service, final Dictionary<?, ?> properties );

    protected abstract void handleServiceModified ( final S service, final Dictionary<?, ?> properties );

    protected abstract void handleServiceRemoved ( final S service, final Dictionary<?, ?> properties );

    protected synchronized void handlePoolAdd ( final ObjectPool<S> objectPool, final int priority )
    {
        logger.debug ( "Pool added: {}/{}", objectPool, priority );
        this.poolMap.put ( objectPool, new PoolHandler ( objectPool, this.serviceId ) );
    }

    protected synchronized void handlePoolModified ( final ObjectPool<S> objectPool, final int newPriority )
    {
        // we don't care
    }

    protected void handlePoolRemove ( final ObjectPool<S> objectPool )
    {
        final PoolHandler handler;

        synchronized ( this )
        {
            logger.debug ( "Pool removed: {}", objectPool );
            handler = this.poolMap.get ( objectPool );
        }

        if ( handler != null )
        {
            handler.dispose ();
        }
    }

    public void open ()
    {
        this.poolTracker.addListener ( this.poolListener );
    }

    public void close ()
    {
        this.poolTracker.removeListener ( this.poolListener );
    }
}
