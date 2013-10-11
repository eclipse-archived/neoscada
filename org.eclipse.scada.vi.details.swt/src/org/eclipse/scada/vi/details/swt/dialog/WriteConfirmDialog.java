/*******************************************************************************
 * Copyright (c) 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.dialog;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.scada.core.ui.connection.login.SessionManager;

public final class WriteConfirmDialog
{
    private static final String suppressConfirmDialogRole = System.getProperty ( "org.eclipse.scada.vi.details.swt.widgets.roles.suppressConfirm", "developer" );

    private WriteConfirmDialog ()
    {
    }

    public static boolean create ( final Shell shell )
    {
        if ( SessionManager.getDefault ().hasRole ( suppressConfirmDialogRole ) )
        {
            return true;
        }
        if ( shell == null )
        {
            return MessageDialog.openQuestion ( org.eclipse.scada.vi.details.swt.Activator.getDefault ().getWorkbench ().getActiveWorkbenchWindow ().getShell (), Messages.WriteConfirmDialog_sendData, Messages.WriteConfirmDialog_confirmOperation );
        }
        else
        {
            return MessageDialog.openQuestion ( shell, Messages.WriteConfirmDialog_sendData, Messages.WriteConfirmDialog_confirmOperation );
        }

    }
}
