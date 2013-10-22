/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.utils;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class TypeWalker<T>
{
    private final Class<? extends T> clazz;

    public TypeWalker ( final Class<? extends T> clazz )
    {
        this.clazz = clazz;
    }

    public List<T> toList ( final EObject start )
    {
        final List<T> result = new LinkedList<> ();

        try
        {
            walk ( start, new TypeVisitor<T> () {
                @Override
                public void visit ( final T item )
                {
                    result.add ( item );
                }
            } );
        }
        catch ( final Exception e )
        {
            // we should never reach this point since our visitor does not throw an exception
            throw new RuntimeException ( e );
        }

        return result;
    }

    public void walk ( final EObject start, final TypeVisitor<? super T> visitor ) throws Exception
    {
        final TreeIterator<?> iterator = EcoreUtil.getAllContents ( start, true );
        walk ( iterator, visitor );
    }

    public void walk ( final Collection<?> start, final TypeVisitor<? super T> visitor ) throws Exception
    {
        final TreeIterator<?> iterator = EcoreUtil.getAllContents ( start, true );
        walk ( iterator, visitor );
    }

    protected void walk ( final TreeIterator<?> iterator, final TypeVisitor<? super T> visitor ) throws Exception
    {
        while ( iterator.hasNext () )
        {
            final Object o = iterator.next ();
            if ( this.clazz.isAssignableFrom ( o.getClass () ) )
            {
                visitor.visit ( this.clazz.cast ( o ) );
            }
        }
    }
}
