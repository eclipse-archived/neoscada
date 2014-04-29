/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - additional work
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer;

import java.util.Collection;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiff;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.scada.chart.swt.ChartRenderer;

public abstract class AbstractAxisManager<Key, Value>
{

    private final WritableList list = new WritableList ();

    protected final DataBindingContext dbc;

    protected final ChartRenderer manager;

    private IListChangeListener listener;

    public AbstractAxisManager ( final DataBindingContext dbc, final ChartRenderer manager )
    {
        this.dbc = dbc;
        this.manager = manager;

        this.list.addListChangeListener ( this.listener = new IListChangeListener () {

            @Override
            public void handleListChange ( final ListChangeEvent event )
            {
                handleListeChange ( event.diff );
            }
        } );
    }

    protected void handleListeChange ( final ListDiff diff )
    {
        diff.accept ( new ListDiffVisitor () {

            @SuppressWarnings ( "unchecked" )
            @Override
            public void handleRemove ( final int index, final Object element )
            {
                AbstractAxisManager.this.handleRemove ( (Key)element );
            }

            @SuppressWarnings ( "unchecked" )
            @Override
            public void handleAdd ( final int index, final Object element )
            {
                AbstractAxisManager.this.handleAdd ( index, (Key)element );
            }
        } );
    }

    protected abstract void handleAdd ( int index, Key element );

    protected abstract void handleRemove ( Key element );

    public abstract Collection<Value> getAll ();

    public void dispose ()
    {
        this.list.removeListChangeListener ( this.listener );
    }

    public WritableList getList ()
    {
        return this.list;
    }

    public abstract Value getAxis ( final Key axis );

}
