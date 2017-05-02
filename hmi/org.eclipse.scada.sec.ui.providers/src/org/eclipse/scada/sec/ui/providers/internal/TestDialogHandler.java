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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.scada.sec.ui.providers.KeySelectorDialog;
import org.eclipse.ui.PlatformUI;

public class TestDialogHandler extends AbstractHandler
{

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        new KeySelectorDialog ( PlatformUI.getWorkbench ().getActiveWorkbenchWindow ().getShell (), "Select key", "Select a key for testing", 5 ).open ();
        return null;
    }

}
