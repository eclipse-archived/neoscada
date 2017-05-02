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
package org.eclipse.scada.utils.collection;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.utils.lang.Pair;

/**
 * A map builder which can create a HashMap by chained calls.
 * 
 * @author Jens Reimann &lt;jens.reimann@th4-systems.com&gt;
 * @param <Key>
 *            The key type
 * @param <Value>
 *            The value type
 */
public class MapBuilder<Key, Value>
{
    private final Map<Key, Value> map;

    /**
     * Create a new map builder with the provided map as input
     * 
     * @param map
     *            the content that should be used as initial content. The
     *            provided map will not be modified.
     */
    public MapBuilder ( final Map<Key, Value> map )
    {
        this.map = new HashMap<Key, Value> ( map );
    }

    public MapBuilder ()
    {
        this.map = new HashMap<Key, Value> ( 0 );
    }

    /**
     * Put a pair into the map held by the map builder
     * 
     * @param key
     *            The key
     * @param value
     *            The value
     * @return the current instance of the map builder
     */
    public final MapBuilder<Key, Value> put ( final Key key, final Value value )
    {
        this.map.put ( key, value );
        return this;
    }

    /**
     * Add all entries from the provided map
     * 
     * @param values
     *            the values to add
     * @return the current instance of the map builder
     */
    public final MapBuilder<Key, Value> putAll ( final Map<Key, Value> values )
    {
        this.map.putAll ( values );
        return this;
    }

    /**
     * Clean the map held by the map builder
     * 
     * @return the current instance of the map builder
     */
    public final MapBuilder<Key, Value> clear ()
    {
        this.map.clear ();
        return this;
    }

    /**
     * Get the map of the map builder.
     * <p>
     * Note that no copy is returned of the map. So further modifications using
     * the this MapBuilder instance will change the returned map.
     * </p>
     * 
     * @return The map
     */
    public final Map<Key, Value> getMap ()
    {
        return this.map;
    }

    /**
     * Return a new map which is separated from this map builder
     * 
     * @return a new and independent map
     */
    public Map<Key, Value> build ()
    {
        return new HashMap<Key, Value> ( this.map );
    }

    /**
     * Return a new map the containing only the provided value pair
     * 
     * @param <Key>
     *            The key type
     * @param <Value>
     *            The value type
     * @param pair
     *            The pair to add
     * @return the new map containing the pair
     */
    public static <Key, Value> Map<Key, Value> toMap ( final Pair<Key, Value> pair )
    {
        return toMap ( null, pair );
    }

    /**
     * Return a new map containing the provided pair, or add the pair to an
     * already existing map.
     * 
     * @param <Key>
     *            The key type
     * @param <Value>
     *            The value type
     * @param map
     *            The map to which the pair should be added (may be
     *            <code>null</code>)
     * @param pair
     *            The pair to add (may <em>not</em> be <code>null</code>)
     * @return The (new) map.
     */
    public static <Key, Value> Map<Key, Value> toMap ( Map<Key, Value> map, final Pair<Key, Value> pair )
    {
        if ( map == null )
        {
            map = new HashMap<Key, Value> ( 1 );
        }

        map.put ( pair.first, pair.second );

        return map;
    }
}
