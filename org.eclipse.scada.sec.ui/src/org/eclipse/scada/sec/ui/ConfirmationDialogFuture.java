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

import java.util.concurrent.CancellationException;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.scada.sec.callback.Callback;
import org.eclipse.scada.sec.callback.ConfirmationCallback;
import org.eclipse.scada.utils.concurrent.AbstractFuture;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ConfirmationDialogFuture extends AbstractFuture<Callback[]>
{

    public ConfirmationDialogFuture ( final Display display, final Shell parentShell, final Callback[] callbacks, final String dialogTitle )
    {
        display.asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                openDialog ( display, parentShell, callbacks, dialogTitle );
            }
        } );
    }

    protected void openDialog ( final Display display, final Shell parentShell, final Callback[] callbacks, final String dialogTitle )
    {
        try
        {
            for ( final Callback cb : callbacks )
            {
                if ( cb instanceof ConfirmationCallback )
                {
                    final Boolean result = showDialog ( (ConfirmationCallback)cb, display, parentShell, dialogTitle );
                    if ( result == null )
                    {
                        setError ( new CancellationException ( "Cancelled by user request" ) );
                    }
                    else
                    {
                        ( (ConfirmationCallback)cb ).setValue ( result );
                    }
                }
                else
                {
                    cb.cancel ();
                }
            }

            setResult ( callbacks );
        }
        catch ( final Exception e )
        {
            setError ( e );
        }
    }

    private Boolean showDialog ( final ConfirmationCallback cb, final Display display, final Shell parentShell, final String dialogTitle )
    {
        switch ( cb.getConfirmationType () )
        {
            case CONFIRM:
                return MessageDialog.openConfirm ( parentShell, dialogTitle, cb.getLabel () ) ? true : null;
            case ERROR:
                MessageDialog.openError ( parentShell, dialogTitle, cb.getLabel () );
                return true;
            case WARNING:
                MessageDialog.openWarning ( parentShell, dialogTitle, cb.getLabel () );
                return true;
            case INFORMATION:
                MessageDialog.openInformation ( parentShell, dialogTitle, cb.getLabel () );
                return true;
            case QUESTION:
                return MessageDialog.openQuestion ( parentShell, dialogTitle, cb.getLabel () );
            case QUESTION_WITH_CANCEL:
            {
                final MessageDialog dialog = new MessageDialog ( parentShell, dialogTitle, null, cb.getLabel (), MessageDialog.QUESTION_WITH_CANCEL, new String[] { IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL, IDialogConstants.CANCEL_LABEL }, 0 );
                final int result = dialog.open ();
                if ( result == 2 /*CANCEL*/)
                {
                    return null;
                }
                else
                {
                    return result == Window.OK;
                }
            }
            default:
                throw new IllegalArgumentException ( String.format ( "Unable to process type: %s", cb.getConfirmationType () ) );
        }
    }
}
