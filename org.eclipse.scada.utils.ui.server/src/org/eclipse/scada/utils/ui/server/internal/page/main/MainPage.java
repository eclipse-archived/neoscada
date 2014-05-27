/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.ui.server.internal.page.main;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.scada.utils.ui.server.Page;
import org.eclipse.scada.utils.ui.server.internal.Properties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class MainPage implements Page
{

    @Override
    public void createContent ( final Composite parent )
    {
        parent.setLayout ( new GridLayout ( 1, false ) );

        final Label label = new Label ( parent, SWT.NONE );
        label.setText ( System.getProperty ( Properties.MAIN_PAGE_TEXT, "Administration Console" ) );
        label.setData ( RWT.CUSTOM_VARIANT, "mainLabel" );

        final GridData gd = new GridData ( SWT.CENTER, SWT.BEGINNING, true, true );
        gd.verticalIndent = 20;
        label.setLayoutData ( gd );
    }

    @Override
    public boolean requestClose ()
    {
        return true;
    }

}
