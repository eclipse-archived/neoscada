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
package org.eclipse.scada.utils.osgi.pool.internal;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class UnmodifyableDictionary<K, V> extends Hashtable<K, V>
{
    private static final long serialVersionUID = -2754201183982277308L;

    private final Dictionary<K, V> dictionary;

    public UnmodifyableDictionary ( final Dictionary<K, V> dictionary )
    {
        this.dictionary = dictionary;
    }

    @Override
    public synchronized Enumeration<V> elements ()
    {
        return this.dictionary.elements ();
    }

    @Override
    public synchronized boolean equals ( final Object o )
    {
        return this.dictionary.equals ( o );
    }

    @Override
    public synchronized V get ( final Object key )
    {
        return this.dictionary.get ( key );
    }

    @Override
    public synchronized int hashCode ()
    {
        return this.dictionary.hashCode ();
    }

    @Override
    public synchronized boolean isEmpty ()
    {
        return this.dictionary.isEmpty ();
    }

    @Override
    public synchronized Enumeration<K> keys ()
    {
        return this.dictionary.keys ();
    }

    @Override
    public synchronized V put ( final K key, final V value )
    {
        throw new UnsupportedOperationException ();
    }

    @Override
    public synchronized V remove ( final Object key )
    {
        throw new UnsupportedOperationException ();
    }

    @Override
    public synchronized int size ()
    {
        return this.dictionary.size ();
    }

    @Override
    public synchronized String toString ()
    {
        return this.dictionary.toString ();
    }

}
