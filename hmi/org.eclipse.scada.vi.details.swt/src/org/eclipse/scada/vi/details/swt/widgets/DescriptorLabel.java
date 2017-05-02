/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work, cleanup
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.scada.core.ui.connection.login.SessionManager;
import org.eclipse.scada.vi.details.swt.data.DataItemDescriptor;

public class DescriptorLabel extends Composite
{
    public DescriptorLabel ( final Composite parent, final int style, final String text, final DataItemDescriptor descriptor )
    {
        super ( parent, SWT.NONE );

        setLayout ( new FillLayout () );
        Label label = new Label ( this, style );

        if ( text != null )
        {
            label.setText ( text );
        }

        // TODO: make properties
        if ( SessionManager.getDefault ().hasRole ( "developer" ) ) //$NON-NLS-1$
        {
            label.setToolTipText ( String.format ( "%s", descriptor ) ); //$NON-NLS-1$
        }

    }
}
