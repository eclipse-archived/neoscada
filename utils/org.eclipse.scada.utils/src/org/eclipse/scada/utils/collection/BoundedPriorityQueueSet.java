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
package org.eclipse.scada.utils.collection;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class BoundedPriorityQueueSet<E> implements SortedSet<E>, BoundedQueue<E>
{
    private final ConcurrentSkipListSet<E> internalSet;

    private final int capacity;

    public BoundedPriorityQueueSet ( final int capacity )
    {
        this ( capacity, (Comparator<E>)null );
    }

    public BoundedPriorityQueueSet ( final int capacity, final Comparator<E> comparator )
    {
        if ( capacity < 1 )
        {
            throw new IllegalArgumentException ();
        }
        this.capacity = capacity;
        this.internalSet = new ConcurrentSkipListSet<E> ( comparator );
    }

    public BoundedPriorityQueueSet ( final int capacity, final Collection<E> c )
    {
        this ( capacity, (Comparator<E>)null );
        shrinkToSize ();
    }

    public BoundedPriorityQueueSet ( final int capacity, final Comparator<E> comparator, final Collection<E> c )
    {
        this ( capacity, comparator );
        shrinkToSize ();
    }

    private void shrinkToSize ()
    {
        final int toRemove = this.internalSet.size () - this.capacity;
        if ( toRemove <= 0 )
        {
            return;
        }

        for ( int i = 0; i < toRemove; i++ )
        {
            this.internalSet.pollLast ();
        }

    }

    @Override
    public boolean add ( final E e )
    {
        final boolean result = this.internalSet.add ( e );
        if ( !result )
        {
            return false;
        }
        shrinkToSize ();
        return this.internalSet.contains ( e );
    }

    @Override
    public boolean addAll ( final Collection<? extends E> c )
    {
        final boolean result = this.internalSet.addAll ( c );
        if ( !result )
        {
            return false;
        }
        shrinkToSize ();
        for ( final E e : c )
        {
            if ( this.internalSet.contains ( e ) )
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear ()
    {
        this.internalSet.clear ();
    }

    @Override
    public Comparator<? super E> comparator ()
    {
        return this.internalSet.comparator ();
    }

    @Override
    public boolean contains ( final Object o )
    {
        return this.internalSet.contains ( o );
    }

    @Override
    public boolean containsAll ( final Collection<?> c )
    {
        return this.internalSet.containsAll ( c );
    }

    @Override
    public boolean equals ( final Object o )
    {
        return this.internalSet.equals ( o );
    }

    @Override
    public E first ()
    {
        return this.internalSet.first ();
    }

    @Override
    public int hashCode ()
    {
        return this.internalSet.hashCode ();
    }

    @Override
    public SortedSet<E> headSet ( final E toElement )
    {
        return this.internalSet.headSet ( toElement );
    }

    @Override
    public boolean isEmpty ()
    {
        return this.internalSet.isEmpty ();
    }

    @Override
    public Iterator<E> iterator ()
    {
        return this.internalSet.iterator ();
    }

    @Override
    public E last ()
    {
        return this.internalSet.last ();
    }

    @Override
    public boolean remove ( final Object o )
    {
        return this.internalSet.remove ( o );
    }

    @Override
    public boolean removeAll ( final Collection<?> c )
    {
        return this.internalSet.removeAll ( c );
    }

    @Override
    public boolean retainAll ( final Collection<?> c )
    {
        return this.internalSet.retainAll ( c );
    }

    @Override
    public int size ()
    {
        return this.internalSet.size ();
    }

    @Override
    public SortedSet<E> subSet ( final E fromElement, final E toElement )
    {
        return this.internalSet.subSet ( fromElement, toElement );
    }

    @Override
    public SortedSet<E> tailSet ( final E fromElement )
    {
        return this.internalSet.tailSet ( fromElement );
    }

    @Override
    public Object[] toArray ()
    {
        return this.internalSet.toArray ();
    }

    @Override
    public <T> T[] toArray ( final T[] a )
    {
        return this.internalSet.toArray ( a );
    }

    @Override
    public E element ()
    {
        return this.internalSet.first ();
    }

    @Override
    public E peek ()
    {
        try
        {
            return this.internalSet.first ();
        }
        catch ( final NoSuchElementException e )
        {
            return null;
        }
    }

    @Override
    public boolean offer ( final E e )
    {
        return this.add ( e );
    }

    @Override
    public E poll ()
    {
        return this.internalSet.pollFirst ();
    }

    @Override
    public E remove ()
    {
        final E result = this.internalSet.first ();
        this.internalSet.remove ( result );
        return result;
    }

    @Override
    public int getCapacity ()
    {
        return this.capacity;
    }
}
