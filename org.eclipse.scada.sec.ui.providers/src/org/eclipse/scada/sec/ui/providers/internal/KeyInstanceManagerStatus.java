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
package org.eclipse.scada.sec.ui.providers.internal;

import java.util.Date;

import org.eclipse.scada.sec.ui.providers.KeyInformation;
import org.eclipse.scada.sec.ui.providers.KeyInstanceManager;
import org.eclipse.scada.sec.ui.providers.KeyInstanceManager.StatusListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

public class KeyInstanceManagerStatus extends WorkbenchWindowControlContribution implements StatusListener
{

    private Display display;

    private Label label;

    private KeyInformation key;

    private Date validUntil;

    private final Runnable updateRunner = new Runnable () {
        @Override
        public void run ()
        {
            updateTimeout ();
        }
    };

    public KeyInstanceManagerStatus ()
    {
    }

    public KeyInstanceManagerStatus ( final String id )
    {
        super ( id );
    }

    @Override
    protected Control createControl ( final Composite parent )
    {
        this.display = parent.getDisplay ();
        KeyInstanceManager.getInstance ( parent.getDisplay () ).addStatusListener ( this );

        final Composite wrapper = new Composite ( parent, SWT.NONE );
        wrapper.setLayout ( new GridLayout ( 1, false ) );

        this.label = new Label ( wrapper, SWT.NONE );

        final GridData gd = new GridData ( SWT.FILL, SWT.FILL, false, true );
        gd.widthHint = 150;

        this.label.setLayoutData ( gd );

        this.display.timerExec ( 500, this.updateRunner );

        updateLabel ();

        return wrapper;
    }

    protected void updateTimeout ()
    {
        if ( this.label.isDisposed () )
        {
            return;
        }

        this.display.timerExec ( 500, this.updateRunner );
        updateLabel ();
    }

    @Override
    public void defaultKeyChanged ( final KeyInformation key, final Date validUntil )
    {
        this.key = key;
        this.validUntil = validUntil;
        updateLabel ();
    }

    private void updateLabel ()
    {
        final StringBuilder sb = new StringBuilder ( "" );

        if ( this.key != null )
        {
            if ( this.validUntil != null )
            {
                final long seconds = ( this.validUntil.getTime () - System.currentTimeMillis () ) / 1000;
                if ( seconds > 0 )
                {
                    sb.append ( String.format ( "%d:%02d ", seconds / 60, seconds % 60 ) );
                }
            }
            sb.append ( "" + this.key );
        }

        this.label.setToolTipText ( sb.toString () );
        this.label.setText ( sb.toString () );
    }

    @Override
    public void dispose ()
    {
        KeyInstanceManager.getInstance ( this.display ).removeStatusListener ( this );
        super.dispose ();
    }

}
