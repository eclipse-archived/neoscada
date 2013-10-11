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
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.scada.sec.callback.TextCallback;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ConfirmationWidgetFactory extends AbstractLabelCallbackFactory
{
    private Text input;

    private final TextCallback callback;

    public ConfirmationWidgetFactory ( final TextCallback callback )
    {
        super ( callback );
        this.callback = callback;
    }

    @Override
    protected void createInput ( final DataBindingContext dbc, final Label label, final Composite composite )
    {
        this.input = new Text ( composite, SWT.BORDER );
        this.input.setLayoutData ( new GridData ( SWT.FILL, SWT.CENTER, true, false ) );
        dbc.bindValue ( SWTObservables.observeText ( this.input, SWT.Modify ), PojoObservables.observeValue ( this.callback, TextCallback.PROP_VALUE ) );
    }

}
