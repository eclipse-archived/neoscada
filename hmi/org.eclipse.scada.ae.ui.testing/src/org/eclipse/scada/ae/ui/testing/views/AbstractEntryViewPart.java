/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.testing.views;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.scada.ae.ui.connection.data.BrowserEntryBean;
import org.eclipse.scada.ui.utils.SelectionHelper;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;

public abstract class AbstractEntryViewPart extends JobViewPart
{
    protected BrowserEntryBean entry;

    private ISelectionListener selectionListener;

    @Override
    public void dispose ()
    {
        removeSelectionListener ();
        super.dispose ();
    }

    protected void addSelectionListener ()
    {
        if ( this.selectionListener == null )
        {
            getViewSite ().getWorkbenchWindow ().getSelectionService ().addSelectionListener ( this.selectionListener = new ISelectionListener () {

                @Override
                public void selectionChanged ( final IWorkbenchPart part, final ISelection selection )
                {
                    AbstractEntryViewPart.this.setSelection ( selection );
                }
            } );
        }
    }

    protected void removeSelectionListener ()
    {
        if ( this.selectionListener != null )
        {
            getViewSite ().getWorkbenchWindow ().getSelectionService ().removeSelectionListener ( this.selectionListener );
            this.selectionListener = null;
        }
    }

    protected synchronized void setSelection ( final ISelection selection )
    {
        final BrowserEntryBean browserEntry = SelectionHelper.first ( selection, BrowserEntryBean.class );
        if ( browserEntry != this.entry && browserEntry != null && isSupported ( browserEntry ) )
        {
            clear ();
            if ( browserEntry != null )
            {
                setEntry ( browserEntry );
            }
        }
    }

    protected abstract boolean isSupported ( BrowserEntryBean browserEntry );

    protected abstract void clear ();

    protected abstract void setEntry ( BrowserEntryBean browserEntry );

}
