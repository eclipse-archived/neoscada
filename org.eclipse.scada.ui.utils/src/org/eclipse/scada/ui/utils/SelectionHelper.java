/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - move to org.eclipse.scada.ui.utils, add ListMode
 *******************************************************************************/
package org.eclipse.scada.ui.utils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;

/**
 * A helper to work with {@link ISelection}
 */
public final class SelectionHelper
{

    public static enum ListMode
    {
        /**
         * Skip elements which cannot be casted to the target class
         */
        SKIP,
        /**
         * Return null instead of a list if at least one item cannot be casted.
         */
        NONE;
    }

    private SelectionHelper ()
    {
    }

    /**
     * Create an iterator that iterates only over objects in the selection of
     * the provided type
     * <p>
     * This implementation will only work with {@link IStructuredSelection} but
     * does not fail for others.
     * </p>
     *
     * @param selection
     *            the selection
     * @param clazz
     *            the required type
     * @return the resulting iterator, never <code>null</code>
     */
    public static <T> Iterator<T> iterator ( final ISelection selection, final Class<T> clazz )
    {
        return list ( selection, clazz ).iterator ();
    }

    public static List<?> list ( final ISelection selection )
    {
        final List<Object> result = new LinkedList<Object> ();

        if ( selection instanceof IStructuredSelection )
        {
            final Iterator<?> i = ( (IStructuredSelection)selection ).iterator ();
            while ( i.hasNext () )
            {
                final Object o = i.next ();
                if ( o == null )
                {
                    continue;
                }

                result.add ( o );
            }
        }
        return result;
    }

    public static <T> List<T> list ( final ISelection selection, final Class<T> clazz )
    {
        return list ( selection, ListMode.SKIP, clazz );
    }

    public static <T> List<T> list ( final ISelection selection, final ListMode mode, final Class<T> clazz )
    {
        final List<T> result = new LinkedList<T> ();

        if ( selection instanceof IStructuredSelection )
        {
            final Iterator<?> i = ( (IStructuredSelection)selection ).iterator ();
            while ( i.hasNext () )
            {
                final Object o = i.next ();
                if ( o == null )
                {
                    continue;
                }

                boolean added = false;
                if ( clazz.isAssignableFrom ( o.getClass () ) )
                {
                    result.add ( clazz.cast ( o ) );
                    added = true;
                }
                else
                {
                    final T ro = AdapterHelper.adapt ( o, clazz );
                    if ( ro != null )
                    {
                        result.add ( ro );
                        added = true;
                    }
                }

                if ( !added )
                {
                    // we did not add the element
                    if ( mode == ListMode.NONE )
                    {
                        // we are ordered to return nothing in this case
                        return null;
                    }
                }
            }
        }
        return result;
    }

    public static <T> Iterable<T> iterable ( final ISelection selection, final Class<T> clazz )
    {
        return new Iterable<T> () {

            @Override
            public Iterator<T> iterator ()
            {
                return SelectionHelper.iterator ( selection, clazz );
            }
        };
    }

    public static <T> T first ( final ISelection selection, final Class<T> clazz )
    {
        final Iterator<T> i = iterator ( selection, clazz );
        if ( i.hasNext () )
        {
            return i.next ();
        }
        return null;
    }
}
