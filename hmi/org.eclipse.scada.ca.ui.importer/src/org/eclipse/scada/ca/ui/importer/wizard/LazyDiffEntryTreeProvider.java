/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.ui.importer.wizard;

import java.util.List;

import org.eclipse.jface.viewers.ILazyTreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.scada.ca.data.DiffEntry;
import org.eclipse.scada.ca.data.Operation;

public class LazyDiffEntryTreeProvider implements ILazyTreeContentProvider
{

    private TreeViewer viewer;

    private Object input;

    @Override
    public void dispose ()
    {
    }

    @Override
    public void inputChanged ( final Viewer viewer, final Object oldInput, final Object newInput )
    {
        this.input = newInput;
        if ( viewer instanceof TreeViewer )
        {
            this.viewer = (TreeViewer)viewer;
        }
        else
        {
            this.viewer = null;
        }
    }

    @Override
    public void updateElement ( final Object parent, final int index )
    {
        if ( this.viewer == null )
        {
            return;
        }

        if ( parent instanceof List<?> )
        {
            final Object element = ( (List<?>)parent ).get ( index );
            this.viewer.replace ( parent, index, element );
            updateChildCount ( element, -1 );

        }
        else if ( parent instanceof DiffEntry )
        {
            this.viewer.replace ( parent, index, DiffEntryHelper.diffChildsByIndex ( (DiffEntry)parent, index ) );
        }
    }

    @Override
    public void updateChildCount ( final Object element, final int currentChildCount )
    {
        if ( this.viewer == null )
        {
            return;
        }

        int count = 0;
        if ( element instanceof DiffEntry )
        {
            final Operation op = ( (DiffEntry)element ).getOperation ();

            if ( op == Operation.UPDATE_DIFF || op == Operation.UPDATE_SET || op == Operation.ADD )
            {
                final Object[] childs = DiffEntryHelper.diffChilds ( (DiffEntry)element );
                count = childs.length;
            }
        }
        else if ( element instanceof List<?> )
        {
            count = ( (List<?>)element ).size ();
        }

        if ( count != currentChildCount )
        {
            this.viewer.setChildCount ( element, count );
        }
    }

    @Override
    public Object getParent ( final Object element )
    {
        if ( element instanceof DiffSubEntry )
        {
            return ( (DiffSubEntry)element ).getParentEntry ();
        }
        else if ( element instanceof DiffEntry )
        {
            return this.input;
        }
        return null;
    }

}