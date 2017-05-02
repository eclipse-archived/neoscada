/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.databinding.observable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.observable.DisposeEvent;
import org.eclipse.core.databinding.observable.IDisposeListener;
import org.eclipse.core.databinding.observable.IStaleListener;
import org.eclipse.core.databinding.observable.ObservableTracker;
import org.eclipse.core.databinding.observable.StaleEvent;
import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.core.databinding.observable.map.MapDiff;
import org.eclipse.core.databinding.observable.map.ObservableMap;

public class KeyPrefixMapObservable extends ObservableMap
{

    private IStaleListener staleListener = new IStaleListener () {
        @Override
        public void handleStale ( final StaleEvent staleEvent )
        {
            fireStale ();
        }
    };

    private IObservableMap map;

    private final String keyPrefix;

    private final Object valueType;

    private IMapChangeListener changeListener = new IMapChangeListener () {

        @Override
        public void handleMapChange ( final MapChangeEvent event )
        {
            KeyPrefixMapObservable.this.handleMapChange ( event.diff );
        }

    };

    private IDisposeListener disposeListener = new IDisposeListener () {

        @Override
        public void handleDispose ( final DisposeEvent event )
        {
            dispose ();
        }
    };

    private final boolean removePrefix;

    protected KeyPrefixMapObservable ( final IObservableMap map, final String keyPrefix, final Object valueType, final boolean removePrefix )
    {
        super ( map.getRealm (), new HashMap<Object, Object> () );

        this.map = map;
        this.keyPrefix = keyPrefix;
        this.valueType = valueType;
        this.removePrefix = removePrefix;

        map.addMapChangeListener ( this.changeListener );
        map.addStaleListener ( this.staleListener );

        map.addDisposeListener ( this.disposeListener );
    }

    private String makeKey ( final Object key )
    {
        if ( key == null )
        {
            return null;
        }
        else if ( !this.removePrefix )
        {
            return key.toString ();
        }
        else
        {
            return key.toString ().substring ( this.keyPrefix.length () );
        }
    }

    private boolean isPrefix ( final Object key )
    {
        if ( key == null )
        {
            return this.keyPrefix == null;
        }
        if ( this.keyPrefix == null )
        {
            return false;
        }

        return key.toString ().startsWith ( this.keyPrefix );
    }

    @SuppressWarnings ( "unchecked" )
    private void handleMapChange ( final MapDiff diff )
    {
        final Set<String> added = new HashSet<String> ();
        final Set<String> changed = new HashSet<String> ();
        final Set<String> removed = new HashSet<String> ();

        final Map<String, Object> newValues = new HashMap<String, Object> ();
        final Map<String, Object> oldValues = new HashMap<String, Object> ();

        // process adds
        for ( final Object key : diff.getAddedKeys () )
        {
            if ( isPrefix ( key ) )
            {
                final Object value = diff.getNewValue ( key );
                final String localKey = makeKey ( key );

                added.add ( localKey );
                newValues.put ( localKey, value );
                this.wrappedMap.put ( localKey, value );
            }
        }

        // process changes
        for ( final Object key : diff.getChangedKeys () )
        {
            if ( isPrefix ( key ) )
            {
                final String localKey = makeKey ( key );
                changed.add ( localKey );

                final Object value = diff.getNewValue ( key );

                newValues.put ( localKey, value );
                oldValues.put ( localKey, diff.getOldValue ( key ) );

                this.wrappedMap.put ( localKey, value );
            }
        }

        // process removes
        for ( final Object key : diff.getRemovedKeys () )
        {
            if ( isPrefix ( key ) )
            {
                final String localKey = makeKey ( key );
                oldValues.put ( localKey, diff.getOldValue ( key ) );
                removed.add ( localKey );
                this.wrappedMap.remove ( localKey );
            }
        }

        fireMapChange ( createMapDiff ( added, changed, removed, newValues, oldValues ) );
    }

    private MapDiff createMapDiff ( final Set<String> added, final Set<String> changed, final Set<String> removed, final Map<String, ?> newValues, final Map<String, ?> oldValues )
    {
        return new MapDiff () {

            @Override
            public Set<?> getAddedKeys ()
            {
                return added;
            }

            @Override
            public Set<?> getRemovedKeys ()
            {
                return removed;
            }

            @Override
            public Set<?> getChangedKeys ()
            {
                return changed;
            }

            @Override
            public Object getOldValue ( final Object key )
            {
                return oldValues.get ( key );
            }

            @Override
            public Object getNewValue ( final Object key )
            {
                return newValues.get ( key );
            }
        };
    }

    @Override
    public Object getValueType ()
    {
        return this.valueType;
    }

    @Override
    public boolean isStale ()
    {
        ObservableTracker.getterCalled ( this );
        return this.map.isStale ();
    }

    @Override
    public synchronized void dispose ()
    {
        if ( this.map != null )
        {
            this.map.removeMapChangeListener ( this.changeListener );
            this.map.removeStaleListener ( this.staleListener );
            this.map.removeDisposeListener ( this.disposeListener );
            this.map = null;

            this.changeListener = null;
            this.staleListener = null;
            this.disposeListener = null;
        }
        super.dispose ();
    }

    @Override
    public Object put ( final Object key, final Object value )
    {
        checkRealm ();

        final String fullKey = reverseKey ( key );
        return this.map.put ( fullKey, value );
    }

    @Override
    public void clear ()
    {
        checkRealm ();

        for ( final Object key : this.wrappedMap.keySet () )
        {
            if ( key instanceof String )
            {
                this.map.remove ( reverseKey ( key ) );
            }
        }
    }

    @SuppressWarnings ( { "rawtypes", "unchecked" } )
    @Override
    public void putAll ( final Map values )
    {
        checkRealm ();
        final HashMap<String, Object> newValues = new HashMap<String, Object> ();

        for ( final Object o : values.entrySet () )
        {
            final Entry<?, ?> entry = (Map.Entry<?, ?>)o;
            final String fullKey = reverseKey ( entry.getKey () );
            newValues.put ( fullKey, entry.getValue () );
        }

        this.map.putAll ( newValues );
    }

    @Override
    public Object remove ( final Object key )
    {
        checkRealm ();
        return this.map.remove ( reverseKey ( key ) );
    }

    private String reverseKey ( final Object key )
    {
        if ( this.removePrefix && this.keyPrefix != null )
        {
            return this.keyPrefix + key;
        }
        else if ( key != null )
        {
            return key.toString ();
        }
        else
        {
            return null;
        }
    }

    public static IObservableMap observePrefix ( final IObservableMap map, final String keyPrefix )
    {
        return new KeyPrefixMapObservable ( map, keyPrefix, null, false );
    }

    public static IObservableMap observePrefix ( final IObservableMap map, final String keyPrefix, final boolean removePrefix )
    {
        return new KeyPrefixMapObservable ( map, keyPrefix, null, removePrefix );
    }

    public static IObservableMap observePrefix ( final IObservableMap map, final Object valueType, final String keyPrefix, final boolean removePrefix )
    {
        return new KeyPrefixMapObservable ( map, keyPrefix, valueType, removePrefix );
    }
}
