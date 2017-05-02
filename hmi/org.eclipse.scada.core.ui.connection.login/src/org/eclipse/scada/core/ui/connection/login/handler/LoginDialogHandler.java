/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.login.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.scada.core.ui.connection.login.dialog.LoginDialog;

public class LoginDialogHandler extends AbstractHandler
{

    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        final Shell shell = PlatformUI.getWorkbench ().getActiveWorkbenchWindow ().getShell ();

        final LoginDialog dlg = new LoginDialog ( shell );
        return dlg.open ();
    }

}
