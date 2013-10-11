/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.widgets;

import java.util.Map;

import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.details.swt.data.DataItemDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LabelComposite extends GenericComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( LabelComposite.class );

    private final Label label;

    private final String format;

    public LabelComposite ( final Composite parent, final int style, final DataItemDescriptor descriptor, final String format )
    {
        super ( parent, style, null, null );

        setLayout ( new FillLayout () );
        this.label = new Label ( this, SWT.NONE );

        this.format = format;
        if ( descriptor != null )
        {
            this.registrationManager.registerItem ( "value", descriptor.getItemId (), descriptor.getConnectionInformation (), false, false ); //$NON-NLS-1$
        }
        else
        {
            this.label.setText ( format );
        }

    }

    @Override
    protected void updateState ( final Map<String, DataValue> values, final SummaryInformation state )
    {
        if ( isDisposed () )
        {
            logger.info ( "No updateView cause widget is disposed" ); //$NON-NLS-1$
            return;
        }

        final DataItemValue value = values.get ( "value" ).getValue (); //$NON-NLS-1$

        if ( value == null )
        {
            return;
        }

        this.label.setText ( String.format ( this.format, value.getValue ().toLabel () ) );
        if ( state.isError () )
        {
            this.label.setBackground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_RED ) );
        }
        else
        {
            this.label.setBackground ( null );
        }
    }

}
