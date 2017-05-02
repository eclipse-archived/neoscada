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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.utils.osgi.FilterUtil;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A tracker which tracks object pools
 * 
 * @author Jens Reimann
 */
public class ObjectPoolTracker<S>
{

    private final static Logger logger = LoggerFactory.getLogger ( ObjectPoolTracker.class );

    private final int DEFAULT_PRIORITY = Integer.getInteger ( "org.eclipse.scada.osgi.objectPool.defaultPriority", 0 );

    private final ServiceTracker<ObjectPool<S>, ObjectPool<S>> poolTracker;

    private final Set<ObjectPoolServiceListener<S>> listeners = new HashSet<ObjectPoolServiceListener<S>> ();

    public interface ObjectPoolServiceListener<S>
    {
        public void poolAdded ( ObjectPool<S> objectPool, int priority );

        public void poolRemoved ( ObjectPool<S> objectPool );

        public void poolModified ( ObjectPool<S> objectPool, int newPriority );
    }

    private final Map<ObjectPool<S>, Integer> poolMap = new HashMap<ObjectPool<S>, Integer> ();

    public ObjectPoolTracker ( final BundleContext context, final Class<? extends S> poolClass ) throws InvalidSyntaxException
    {
        this ( context, poolClass.getName () );
    }

    public ObjectPoolTracker ( final BundleContext context, final String poolClass ) throws InvalidSyntaxException
    {
        final Map<String, String> parameters = new HashMap<String, String> ();
        parameters.put ( ObjectPool.OBJECT_POOL_CLASS, poolClass );
        final Filter filter = FilterUtil.createAndFilter ( ObjectPool.class.getName (), parameters );

        this.poolTracker = new ServiceTracker<ObjectPool<S>, ObjectPool<S>> ( context, filter, new ServiceTrackerCustomizer<ObjectPool<S>, ObjectPool<S>> () {

            @Override
            public void removedService ( final ServiceReference<ObjectPool<S>> reference, final ObjectPool<S> service )
            {
                context.ungetService ( reference );
                ObjectPoolTracker.this.removePool ( service );
            }

            @Override
            public void modifiedService ( final ServiceReference<ObjectPool<S>> reference, final ObjectPool<S> service )
            {
                ObjectPoolTracker.this.modifyPool ( service, reference );
            }

            @Override
            public ObjectPool<S> addingService ( final ServiceReference<ObjectPool<S>> reference )
            {
                final ObjectPool<S> o = context.getService ( reference );
                ObjectPoolTracker.this.addPool ( o, reference );
                return o;
            }
        } );
    }

    protected int getPriority ( final ServiceReference<ObjectPool<S>> reference )
    {
        return getPriority ( reference, this.DEFAULT_PRIORITY );
    }

    protected int getPriority ( final ServiceReference<ObjectPool<S>> reference, final int defaultPriority )
    {
        final Object o = reference.getProperty ( Constants.SERVICE_RANKING );
        if ( o instanceof Number )
        {
            return ( (Number)o ).intValue ();
        }
        else
        {
            return defaultPriority;
        }
    }

    protected synchronized void addPool ( final ObjectPool<S> objectPool, final ServiceReference<ObjectPool<S>> reference )
    {
        logger.debug ( "Found new pool: {} -> {}", new Object[] { objectPool, reference } );

        final int priority = getPriority ( reference );
        this.poolMap.put ( objectPool, priority );
        fireAdded ( objectPool, priority );
    }

    private void fireAdded ( final ObjectPool<S> objectPool, final int priority )
    {
        for ( final ObjectPoolServiceListener<S> listener : this.listeners )
        {
            listener.poolAdded ( objectPool, priority );
        }
    }

    protected synchronized void modifyPool ( final ObjectPool<S> objectPool, final ServiceReference<ObjectPool<S>> reference )
    {
        logger.debug ( "Pool modified: {} -> {}", new Object[] { objectPool, reference } );

        final int newPriority = getPriority ( reference );
        this.poolMap.put ( objectPool, newPriority );
        fireModified ( objectPool, newPriority );
    }

    private void fireModified ( final ObjectPool<S> objectPool, final int newPriority )
    {
        for ( final ObjectPoolServiceListener<S> listener : this.listeners )
        {
            listener.poolModified ( objectPool, newPriority );
        }
    }

    protected synchronized void removePool ( final ObjectPool<S> objectPool )
    {
        logger.debug ( "Pool removed: {}", new Object[] { objectPool } );
        final Integer priority = this.poolMap.remove ( objectPool );
        if ( priority != null )
        {
            fireRemoved ( objectPool );
        }
    }

    private void fireRemoved ( final ObjectPool<S> objectPool )
    {
        for ( final ObjectPoolServiceListener<S> listener : this.listeners )
        {
            listener.poolRemoved ( objectPool );
        }
    }

    public synchronized void open ()
    {
        this.poolTracker.open ();
    }

    public synchronized void close ()
    {
        this.poolTracker.close ();
    }

    public synchronized void addListener ( final ObjectPoolServiceListener<S> listener )
    {
        logger.debug ( "Adding pool service listener: {}", listener );
        if ( this.listeners.add ( listener ) )
        {
            for ( final Map.Entry<ObjectPool<S>, Integer> entry : this.poolMap.entrySet () )
            {
                logger.debug ( "Add Announce pool: {}/{}", new Object[] { entry.getKey (), entry.getValue () } );
                listener.poolAdded ( entry.getKey (), entry.getValue () );
            }
        }
    }

    public void removeListener ( final ObjectPoolServiceListener<S> listener )
    {
        final Set<ObjectPool<S>> pools;

        synchronized ( this )
        {
            if ( !this.listeners.remove ( listener ) )
            {
                return;
            }
            pools = new HashSet<ObjectPool<S>> ( this.poolMap.keySet () );
        }

        for ( final ObjectPool<S> pool : pools )
        {
            listener.poolRemoved ( pool );
        }
    }
}
