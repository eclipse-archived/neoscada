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

import java.util.List;

import org.eclipse.scada.sec.callback.Callback;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.sec.callback.ConfirmationCallback;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class DisplayCallbackHandler implements CallbackHandler
{
    private final Display display;

    private final String dialogTitle;

    private final String dialogMessage;

    private final Shell parentShell;

    public static DisplayCallbackHandler createDefault ( final Shell shell )
    {
        return new DisplayCallbackHandler ( shell, "Logon to system", "Enter logon credentials" );
    }

    public DisplayCallbackHandler ( final Display display, final String dialogTitle, final String dialogMessage )
    {
        this.parentShell = null;
        this.display = display;
        this.dialogTitle = dialogTitle;
        this.dialogMessage = dialogMessage;
    }

    public DisplayCallbackHandler ( final Shell parentShell, final String dialogTitle, final String dialogMessage )
    {
        this.parentShell = parentShell;
        this.display = parentShell.getDisplay ();
        this.dialogTitle = dialogTitle;
        this.dialogMessage = dialogMessage;
    }

    @Override
    public NotifyFuture<Callback[]> performCallback ( final Callback[] callbacks )
    {
        if ( callbacks.length == 1 && callbacks[0] instanceof ConfirmationCallback )
        {
            return new ConfirmationDialogFuture ( this.display, this.parentShell, callbacks, this.dialogTitle );
        }

        return performFullDialog ( callbacks, Helper.makeFactories ( callbacks ) );
    }

    private boolean tryInstant ( final List<CallbackWidgetFactory> factories )
    {
        if ( factories.isEmpty () )
        {
            return true;
        }

        for ( final CallbackWidgetFactory cwf : factories )
        {
            if ( !cwf.tryInstantComplete () )
            {
                return false;
            }
        }

        return true;
    }

    private NotifyFuture<Callback[]> performFullDialog ( final Callback[] callbacks, final List<CallbackWidgetFactory> factories )
    {
        final DialogFuture future;
        if ( this.parentShell != null )
        {
            future = new DialogFuture ( this.parentShell, callbacks, factories );
        }
        else
        {
            future = new DialogFuture ( this.display, callbacks, factories );
        }

        future.setTitle ( this.dialogTitle );
        future.setMessage ( this.dialogMessage );

        this.display.asyncExec ( new Runnable () {
            @Override
            public void run ()
            {
                processDialogFuture ( callbacks, factories, future );
            }
        } );

        return future;
    }

    private void processDialogFuture ( final Callback[] callbacks, final List<CallbackWidgetFactory> factories, final DialogFuture future )
    {

        if ( tryInstant ( factories ) )
        {
            future.setEarlyResult ( callbacks );
            return;
        }

        future.openDialog ();
    }
}
