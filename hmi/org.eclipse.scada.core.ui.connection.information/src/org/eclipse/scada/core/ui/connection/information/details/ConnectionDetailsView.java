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
package org.eclipse.scada.core.ui.connection.information.details;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

public class ConnectionDetailsView extends ViewPart
{

    private DetailsView view;

    @Override
    public void createPartControl ( final Composite parent )
    {
        parent.setBackgroundMode ( SWT.INHERIT_FORCE );
        this.view = new DetailsView ( parent );
        getViewSite ().getWorkbenchWindow ().getSelectionService ().addSelectionListener ( new ISelectionListener () {

            @Override
            public void selectionChanged ( final IWorkbenchPart part, final ISelection selection )
            {
                ConnectionDetailsView.this.view.setSelection ( selection );
            }
        } );
        this.view.setSelection ( getViewSite ().getWorkbenchWindow ().getSelectionService ().getSelection () );
    }

    @Override
    public void setFocus ()
    {
        this.view.setFocus ();
    }

}
