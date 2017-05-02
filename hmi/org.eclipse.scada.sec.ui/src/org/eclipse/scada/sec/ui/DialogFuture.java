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

import org.eclipse.jface.window.Window;
import org.eclipse.scada.sec.callback.Callback;
import org.eclipse.scada.utils.concurrent.AbstractFuture;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class DialogFuture extends AbstractFuture<Callback[]>
{

    private CallbackDialog dlg;

    private final Display display;

    private final Callback[] callbacks;

    private final List<CallbackWidgetFactory> factories;

    private String title;

    private String message;

    private final Shell parentShell;

    public DialogFuture ( final Display display, final Callback[] callbacks, final List<CallbackWidgetFactory> factories )
    {
        this.parentShell = null;
        this.display = display;
        this.callbacks = callbacks;
        this.factories = factories;
    }

    public DialogFuture ( final Shell parentShell, final Callback[] callbacks, final List<CallbackWidgetFactory> factories )
    {
        this.parentShell = parentShell;
        this.display = parentShell.getDisplay ();
        this.callbacks = callbacks;
        this.factories = factories;
    }

    protected Shell getParentShell ()
    {
        if ( this.parentShell != null )
        {
            return this.parentShell;
        }

        final Shell shell = PlatformUI.getWorkbench ().getActiveWorkbenchWindow ().getShell ();
        if ( shell != null )
        {
            return shell;
        }
        return this.display.getActiveShell ();
    }

    public void openDialog ()
    {
        if ( isCancelled () || this.dlg != null )
        {
            return;
        }

        this.dlg = new CallbackDialog ( getParentShell (), this.factories );

        this.dlg.setBlockOnOpen ( false );
        if ( this.dlg.openDialog () )
        {
            this.dlg.getShell ().setText ( this.title );
            this.dlg.setTitle ( this.title );
            this.dlg.setMessage ( this.message );
            this.dlg.getShell ().setFocus ();

            this.dlg.getShell ().addDisposeListener ( new DisposeListener () {

                @Override
                public void widgetDisposed ( final DisposeEvent e )
                {
                    processDispose ();
                }
            } );
        }
        else
        {
            setResult ( this.callbacks );
            this.dlg = null;
        }
    }

    public void setEarlyResult ( final Callback[] result )
    {
        setResult ( result );
    }

    public void setErrorResult ( final Throwable error )
    {
        setError ( error );
    }

    protected void processDispose ()
    {
        if ( this.dlg.getReturnCode () != Window.OK )
        {
            setError ( new InterruptedException ( "Interrupted by user" ) );
        }
        else
        {
            setResult ( this.callbacks );
        }
        this.dlg = null;
    }

    protected void closeDialog ()
    {
        if ( this.dlg != null )
        {
            this.dlg.close ();
            this.dlg = null;
        }
    }

    @Override
    public boolean cancel ( final boolean mayInterruptIfRunning )
    {
        if ( super.cancel ( mayInterruptIfRunning ) )
        {
            this.display.asyncExec ( new Runnable () {
                @Override
                public void run ()
                {
                    closeDialog ();
                };
            } );
            return true;
        }
        else
        {
            return false;
        }
    }

    public void setTitle ( final String title )
    {
        this.title = title;
    }

    public void setMessage ( final String message )
    {
        this.message = message;
    }

}
