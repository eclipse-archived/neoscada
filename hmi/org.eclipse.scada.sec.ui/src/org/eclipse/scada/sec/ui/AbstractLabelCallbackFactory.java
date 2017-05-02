/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.ui;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.scada.sec.callback.LabelCallback;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public abstract class AbstractLabelCallbackFactory implements CallbackWidgetFactory
{
    private final LabelCallback labelCallback;

    public AbstractLabelCallbackFactory ( final LabelCallback labelCallback )
    {
        this.labelCallback = labelCallback;
    }

    @Override
    public void createGridWidgets ( final DataBindingContext dbc, final Composite composite )
    {
        final Label label = new Label ( composite, SWT.NONE );
        label.setText ( String.format ( "%s: ", this.labelCallback.getLabel () ) );

        createInput ( dbc, label, composite );
    }

    @Override
    public void complete ()
    {
    }

    @Override
    public boolean tryInstantComplete ()
    {
        return false;
    }

    protected abstract void createInput ( DataBindingContext dbc, final Label label, final Composite composite );
}
