/*******************************************************************************
 * Copyright (c) 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.vi.ui.viewer.ext.item;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.scada.core.Variant;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.scada.ui.databinding.item.DataItemObservableValue;
import org.eclipse.scada.vi.ui.viewer.ext.Activator;

public abstract class DataItemLabel
{
    protected final CLabel label;

    protected final DataItemObservableValue dataItem;

    protected final DataBindingContext dbc;

    protected final IObservableValue model;

    public DataItemLabel ( final Composite composite, final String connectionId, final String itemId )
    {
        this.label = new CLabel ( composite, SWT.NONE );
        this.dataItem = new DataItemObservableValue ( Activator.getDefault ().getBundle ().getBundleContext (), connectionId, itemId );
        this.label.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                handleDispose ();
            }
        } );
        this.model = PojoObservables.observeDetailValue ( this.dataItem, "value", Variant.class ); //$NON-NLS-1$
        this.dbc = new DataBindingContext ();

        bind ();
    }

    protected abstract void bind ();

    protected void handleDispose ()
    {
        this.dbc.dispose ();
        this.model.dispose ();
        this.dataItem.dispose ();
    }

    public Control getControl ()
    {
        return this.label;
    }
}