/*******************************************************************************
 * Copyright (c) 2006, 2013 TH4 SYSTEMS GmbH and others.
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

/**
 * A service tracker which tracks all services of all object pools found
 * 
 * @author Jens Reimann
 * @param <S>
 *            the service class
 */
public class AllObjectPoolServiceTracker<S>
{

    private final static Logger logger = LoggerFactory.getLogger ( AllObjectPoolServiceTracker.class );

    private final ObjectPoolTracker<S> poolTracker;

    private final ObjectPoolServiceListener<S> poolListener;

    private final Map<ObjectPool<S>, PoolHandler> poolMap = new HashMap<ObjectPool<S>, PoolHandler> ();

    private final ObjectPoolListener<S> serviceListener;

    protected class PoolHandler implements ObjectPoolListener<S>
    {
        private final ObjectPool<S> pool;

        private final Map<S, Dictionary<?, ?>> services = new HashMap<S, Dictionary<?, ?>> ();

        public PoolHandler ( final ObjectPool<S> pool )
        {
            this.pool = pool;

            synchronized ( this )
            {
                this.pool.addListener ( this );
            }
        }

        public synchronized void dispose ()
        {
            this.pool.removeListener ( this );

            for ( final Map.Entry<S, Dictionary<?, ?>> entry : this.services.entrySet () )
            {
                fireServiceRemoved ( entry.getKey (), entry.getValue () );
            }
            this.services.clear ();
        }

        @Override
        public synchronized void serviceAdded ( final S service, final Dictionary<?, ?> properties )
        {
            this.services.put ( service, properties );
            fireServiceAdded ( service, properties );
        }

        private void fireServiceAdded ( final S service, final Dictionary<?, ?> properties )
        {
            AllObjectPoolServiceTracker.this.handleServiceAdded ( service, properties );
        }

        @Override
        public synchronized void serviceModified ( final S service, final Dictionary<?, ?> properties )
        {
            this.services.put ( service, properties );
            fireServiceModified ( service, properties );
        }

        private void fireServiceModified ( final S service, final Dictionary<?, ?> properties )
        {
            AllObjectPoolServiceTracker.this.handleServiceModified ( service, properties );
        }

        @Override
        public synchronized void serviceRemoved ( final S service, final Dictionary<?, ?> properties )
        {
            final Dictionary<?, ?> oldProperties = this.services.remove ( service );
            if ( oldProperties != null )
            {
                fireServiceRemoved ( service, properties );
            }
        }

        private void fireServiceRemoved ( final S service, final Dictionary<?, ?> properties )
        {
            AllObjectPoolServiceTracker.this.handleServiceRemoved ( service, properties );
        }
    }

    public AllObjectPoolServiceTracker ( final ObjectPoolTracker<S> poolTracker, final ObjectPoolListener<S> listener )
    {
        this.serviceListener = listener;
        this.poolTracker = poolTracker;

        this.poolListener = new ObjectPoolServiceListener<S> () {

            @Override
            public void poolRemoved ( final ObjectPool<S> objectPool )
            {
                AllObjectPoolServiceTracker.this.handlePoolRemove ( objectPool );
            }

            @Override
            public void poolModified ( final ObjectPool<S> objectPool, final int newPriority )
            {
                AllObjectPoolServiceTracker.this.handlePoolModified ( objectPool, newPriority );
            }

            @Override
            public void poolAdded ( final ObjectPool<S> objectPool, final int priority )
            {
                AllObjectPoolServiceTracker.this.handlePoolAdd ( objectPool, priority );
            }
        };
    }

    protected void handleServiceAdded ( final S service, final Dictionary<?, ?> properties )
    {
        logger.debug ( "Service added {} -> {}", new Object[] { service, properties } );
        this.serviceListener.serviceAdded ( service, properties );
    }

    protected void handleServiceModified ( final S service, final Dictionary<?, ?> properties )
    {
        this.serviceListener.serviceModified ( service, properties );
    }

    protected void handleServiceRemoved ( final S service, final Dictionary<?, ?> properties )
    {
        this.serviceListener.serviceRemoved ( service, properties );
    }

    protected synchronized void handlePoolAdd ( final ObjectPool<S> objectPool, final int priority )
    {
        this.poolMap.put ( objectPool, new PoolHandler ( objectPool ) );
    }

    protected synchronized void handlePoolModified ( final ObjectPool<S> objectPool, final int newPriority )
    {
        // we don't care
    }

    protected synchronized void handlePoolRemove ( final ObjectPool<S> objectPool )
    {
        final PoolHandler handler = this.poolMap.get ( objectPool );
        if ( handler != null )
        {
            handler.dispose ();
        }
    }

    /**
     * Start the tracker
     */
    public void open ()
    {
        this.poolTracker.addListener ( this.poolListener );
    }

    /**
     * Stop the tracker
     */
    public void close ()
    {
        this.poolTracker.removeListener ( this.poolListener );
    }
}
