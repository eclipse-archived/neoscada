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
package org.eclipse.scada.ca.ui.editor.factory;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

public class RefreshAction implements IEditorActionDelegate
{

    private FactoryEditor activeEditor;

    @Override
    public void run ( final IAction action )
    {
        this.activeEditor.refresh ();
    }

    @Override
    public void selectionChanged ( final IAction action, final ISelection selection )
    {
    }

    @Override
    public void setActiveEditor ( final IAction action, final IEditorPart targetEditor )
    {
        this.activeEditor = (FactoryEditor)targetEditor;
    }

}
