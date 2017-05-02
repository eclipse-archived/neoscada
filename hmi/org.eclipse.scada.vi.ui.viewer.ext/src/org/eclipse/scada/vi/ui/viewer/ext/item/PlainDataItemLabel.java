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
package org.eclipse.scada.vi.ui.viewer.ext.item;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.scada.ui.databinding.item.VariantToStringConverter;

public class PlainDataItemLabel extends DataItemLabel
{

    public PlainDataItemLabel ( final Composite composite, final String connectionId, final String itemId )
    {
        super ( composite, connectionId, itemId );
    }

    @Override
    protected void bind ()
    {
        this.dbc.bindValue ( SWTObservables.observeText ( this.label ), this.model, null, new UpdateValueStrategy ().setConverter ( new VariantToStringConverter () ) );
        this.model.addValueChangeListener ( new IValueChangeListener () {

            @Override
            public void handleValueChange ( final ValueChangeEvent event )
            {
                if ( !PlainDataItemLabel.this.label.isDisposed () )
                {
                    PlainDataItemLabel.this.label.getParent ().layout ();
                }
            }
        } );
    }

}
