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
package org.eclipse.scada.vi.details.swt.impl.visibility;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;

public class VisibilityTester
{
    public static VisibilityTester INSTANCE;

    private Shell dialog;

    public Button createTester ( final String label )
    {
        checkCreateDialog ();

        final Button result = new Button ( this.dialog, SWT.CHECK );
        result.setText ( label );
        this.dialog.layout ();
        return result;
    }

    public void removeTester ( final Button button )
    {
        button.dispose ();
        if ( this.dialog != null )
        {
            this.dialog.layout ();
        }
        checkDisposeDialog ();
    }

    private void checkDisposeDialog ()
    {
        if ( this.dialog == null || this.dialog.isDisposed () )
        {
            return;
        }

        if ( this.dialog.getChildren ().length == 0 )
        {
            this.dialog.dispose ();
            this.dialog = null;
        }
    }

    private void checkCreateDialog ()
    {
        if ( this.dialog != null )
        {
            return;
        }

        this.dialog = new Shell ();
        this.dialog.setText ( "Visibility Tester" );
        this.dialog.open ();
        this.dialog.setLayout ( new GridLayout ( 1, false ) );
        this.dialog.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                VisibilityTester.this.dialog = null;
            }
        } );
    }

    public void dispose ()
    {
        if ( this.dialog != null )
        {
            this.dialog.dispose ();
            this.dialog = null;
        }
    }
}
