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
package org.eclipse.scada.ui.utils;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

public class AbstractSelectionProvider implements ISelectionProvider
{
    private final Set<ISelectionChangedListener> listeners = new LinkedHashSet<ISelectionChangedListener> ();

    private ISelection selection = StructuredSelection.EMPTY;

    @Override
    public void setSelection ( final ISelection selection )
    {
        this.selection = selection;
        for ( final ISelectionChangedListener listener : this.listeners )
        {
            listener.selectionChanged ( new SelectionChangedEvent ( this, selection ) );
        }
    }

    @Override
    public void removeSelectionChangedListener ( final ISelectionChangedListener listener )
    {
        this.listeners.remove ( listener );
    }

    @Override
    public ISelection getSelection ()
    {
        return this.selection;
    }

    @Override
    public void addSelectionChangedListener ( final ISelectionChangedListener listener )
    {
        this.listeners.add ( listener );
    }
}