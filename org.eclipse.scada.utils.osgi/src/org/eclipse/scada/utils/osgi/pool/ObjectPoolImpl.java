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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.eclipse.scada.utils.osgi.pool.internal.UnmodifyableDictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class ObjectPoolImpl<S> implements ObjectPool<S>, ManageableObjectPool<S>
{

    private final static Logger logger = LoggerFactory.getLogger ( ObjectPoolImpl.class );

    private final Multimap<String, ObjectPoolListener<S>> idListeners = HashMultimap.create ();

    private final Set<ObjectPoolListener<S>> anyListener = new HashSet<ObjectPoolListener<S>> ( 1 );

    private final Map<String, Map<S, Dictionary<?, ?>>> services = new HashMap<String, Map<S, Dictionary<?, ?>>> ( 1 );

    private final ExecutorService executor;

    private static final Dictionary<?, ?> emptyHashtable = new UnmodifyableDictionary<Object, Object> ( new Hashtable<Object, Object> ( 1 ) );

    private boolean disposed;

    public ObjectPoolImpl ()
    {
        this.executor = Executors.newSingleThreadExecutor ( new NamedThreadFactory ( toString () ) );
    }

    @Override
    @SuppressWarnings ( "unchecked" )
    public synchronized void addService ( final String id, final S service, Dictionary<?, ?> properties )
    {
        if ( this.disposed )
        {
            return;
        }

        if ( properties == null || properties.isEmpty () )
        {
            properties = emptyHashtable;
        }
        else
        {
            properties = new UnmodifyableDictionary<Object, Object> ( (Dictionary<Object, Object>)properties );
        }

        logger.debug ( "Adding service: {} -> {} -> {}", new Object[] { id, service, properties } );

        Map<S, Dictionary<?, ?>> serviceMap = this.services.get ( id );
        if ( serviceMap == null )
        {
            serviceMap = new HashMap<S, Dictionary<?, ?>> ( 1 );
            this.services.put ( id, serviceMap );
        }

        final Dictionary<?, ?> oldService = serviceMap.put ( service, properties );
        if ( oldService != null )
        {
            logger.warn ( "Replaced service: {}", new Object[] { id } );
        }

        fireAddedService ( id, service, properties );
    }

    @Override
    public synchronized void modifyService ( final String id, final S service, final Dictionary<?, ?> properties )
    {
        if ( this.disposed )
        {
            return;
        }

        logger.debug ( "Modifing service: {} -> {} -> {}", new Object[] { id, service, properties } );

        final Map<S, Dictionary<?, ?>> serviceMap = this.services.get ( id );
        if ( serviceMap != null )
        {
            serviceMap.put ( service, properties );
            fireModifiedService ( id, service, properties );
        }
    }

    @Override
    public synchronized void removeService ( final String id, final S service )
    {
        if ( this.disposed )
        {
            return;
        }

        logger.debug ( "Removing service: {} -> {}", id, service );

        final Map<S, Dictionary<?, ?>> serviceMap = this.services.get ( id );
        if ( serviceMap == null )
        {
            return;
        }
        final Dictionary<?, ?> properties = serviceMap.remove ( service );
        if ( properties != null )
        {
            if ( serviceMap.isEmpty () )
            {
                this.services.remove ( id );
            }
            fireRemoveService ( id, service, properties );
        }
    }

    private void fireAddedService ( final String id, final S service, final Dictionary<?, ?> properties )
    {
        final Collection<ObjectPoolListener<S>> listeners = cloneListeners ( id );

        logger.debug ( "Fire add service: {} ({} listeners)", id, listeners.size () );

        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                for ( final ObjectPoolListener<S> listener : listeners )
                {
                    listener.serviceAdded ( service, properties );
                }
            }
        } );
    }

    protected Collection<ObjectPoolListener<S>> cloneListeners ( final String id )
    {
        final Collection<ObjectPoolListener<S>> localListeners = this.idListeners.get ( id );
        final List<ObjectPoolListener<S>> listeners = new ArrayList<ObjectPoolListener<S>> ( localListeners.size () + this.anyListener.size () );
        listeners.addAll ( localListeners );
        listeners.addAll ( this.anyListener );
        return listeners;
    }

    private void fireModifiedService ( final String id, final S service, final Dictionary<?, ?> properties )
    {
        final Collection<ObjectPoolListener<S>> listeners = cloneListeners ( id );

        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                for ( final ObjectPoolListener<S> listener : listeners )
                {
                    listener.serviceModified ( service, properties );
                }
            }
        } );
    }

    private void fireRemoveService ( final String id, final S service, final Dictionary<?, ?> properties )
    {
        final Collection<ObjectPoolListener<S>> listeners = cloneListeners ( id );

        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                for ( final ObjectPoolListener<S> listener : listeners )
                {
                    listener.serviceRemoved ( service, properties );
                }
            }
        } );
    }

    public void dispose ()
    {
        synchronized ( this )
        {

            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    for ( final ObjectPoolListener<S> listener : ObjectPoolImpl.this.anyListener )
                    {
                        for ( final Map<S, Dictionary<?, ?>> map : ObjectPoolImpl.this.services.values () )
                        {
                            for ( final Map.Entry<S, Dictionary<?, ?>> serviceEntry : map.entrySet () )
                            {
                                listener.serviceRemoved ( serviceEntry.getKey (), serviceEntry.getValue () );
                            }
                        }
                    }
                    for ( final Map.Entry<String, ObjectPoolListener<S>> entry : ObjectPoolImpl.this.idListeners.entries () )
                    {
                        final Map<S, Dictionary<?, ?>> serviceMap = ObjectPoolImpl.this.services.get ( entry.getKey () );
                        if ( serviceMap != null )
                        {
                            for ( final Map.Entry<S, Dictionary<?, ?>> serviceEntry : serviceMap.entrySet () )
                            {
                                entry.getValue ().serviceRemoved ( serviceEntry.getKey (), serviceEntry.getValue () );
                            }
                        }
                    }

                    ObjectPoolImpl.this.anyListener.clear ();
                    ObjectPoolImpl.this.idListeners.clear ();
                    ObjectPoolImpl.this.services.clear ();

                }
            } );

            this.disposed = true;
        }

        // wait for termination outside of sync
        this.executor.shutdown ();
    }

    @Override
    public synchronized void addListener ( final String id, final ObjectPoolListener<S> listener )
    {
        if ( this.disposed )
        {
            return;
        }

        logger.debug ( "Adding listener for {}", id );

        if ( this.idListeners.put ( id, listener ) )
        {
            logger.debug ( "Added listener {} for {}", listener, id );

            final Map<S, Dictionary<?, ?>> serviceMap = this.services.get ( id );
            if ( serviceMap != null )
            {
                final Map<S, Dictionary<?, ?>> serviceMapClone = new HashMap<S, Dictionary<?, ?>> ( serviceMap );
                this.executor.execute ( new Runnable () {

                    @Override
                    public void run ()
                    {
                        for ( final Map.Entry<S, Dictionary<?, ?>> entry : serviceMapClone.entrySet () )
                        {
                            listener.serviceAdded ( entry.getKey (), entry.getValue () );
                        }

                    }
                } );
            }
        }
    }

    @Override
    public synchronized void removeListener ( final String id, final ObjectPoolListener<S> listener )
    {
        if ( this.disposed )
        {
            return;
        }

        this.idListeners.remove ( id, listener );
    }

    @Override
    public synchronized void addListener ( final ObjectPoolListener<S> listener )
    {
        if ( this.disposed )
        {
            return;
        }

        logger.debug ( "Adding listener {}", listener );

        if ( this.anyListener.add ( listener ) )
        {
            final Collection<Map<S, Dictionary<?, ?>>> servicesClone = new ArrayList<Map<S, Dictionary<?, ?>>> ( this.services.values () );

            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    for ( final Map<S, Dictionary<?, ?>> serviceMap : servicesClone )
                    {
                        for ( final Map.Entry<S, Dictionary<?, ?>> entry : serviceMap.entrySet () )
                        {
                            listener.serviceAdded ( entry.getKey (), entry.getValue () );
                        }
                    }

                }
            } );
        }
    }

    @Override
    public synchronized void removeListener ( final ObjectPoolListener<S> listener )
    {
        if ( this.disposed )
        {
            return;
        }

        this.anyListener.remove ( listener );
    }
}
