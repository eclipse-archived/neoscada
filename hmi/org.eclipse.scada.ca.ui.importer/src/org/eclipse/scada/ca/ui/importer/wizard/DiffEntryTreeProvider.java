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

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.scada.ca.data.DiffEntry;
import org.eclipse.scada.ca.data.Operation;

public class DiffEntryTreeProvider implements ITreeContentProvider
{

    @Override
    public void inputChanged ( final Viewer viewer, final Object oldInput, final Object newInput )
    {
    }

    @Override
    public void dispose ()
    {
    }

    @Override
    public boolean hasChildren ( final Object element )
    {
        if ( element instanceof DiffEntry )
        {
            final Operation op = ( (DiffEntry)element ).getOperation ();
            return op == Operation.UPDATE_DIFF || op == Operation.UPDATE_SET;
        }
        return false;
    }

    @Override
    public Object getParent ( final Object element )
    {
        if ( element instanceof DiffSubEntry )
        {
            return ( (DiffSubEntry)element ).getParentEntry ();
        }
        return null;
    }

    @Override
    public Object[] getElements ( final Object inputElement )
    {
        if ( inputElement instanceof List<?> )
        {
            return ( (List<?>)inputElement ).toArray ();
        }
        else if ( inputElement instanceof DiffEntry )
        {
            return DiffEntryHelper.diffChilds ( (DiffEntry)inputElement );
        }
        return null;
    }

    @Override
    public Object[] getChildren ( final Object parentElement )
    {
        return getElements ( parentElement );
    }

}