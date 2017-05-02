/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.handler;

import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.scada.vi.details.Activator;
import org.eclipse.scada.vi.details.DetailViewDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.statushandlers.StatusManager;

public class ShowDetailDialog extends AbstractSelectionHandler
{

    private final boolean useWaitShell = !Boolean.getBoolean ( "org.eclipse.scada.vi.details.handler.disableWaitShell" );

    @SuppressWarnings ( "unchecked" )
    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        final String detailViewId = event.getParameter ( "org.eclipse.scada.vi.details.showDetailDialog.id" );
        final Map<String, String> parameters = (Map<String, String>)event.getObjectParameterForExecution ( "org.eclipse.scada.vi.details.showDetailDialog.parameters" );

        try
        {
            if ( this.useWaitShell )
            {
                openWithWaitShell ( getShell (), detailViewId, parameters );
            }
            else
            {
                open ( getShell (), detailViewId, parameters );
            }
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, "Failed to open detail view", e ), StatusManager.SHOW );
        }

        return null;
    }

    protected void openWithWaitShell ( final Shell parentShell, final String detailViewId, final Map<String, String> parameters )
    {

        final Shell waitShell = new Shell ( parentShell, SWT.PRIMARY_MODAL | SWT.BORDER );
        waitShell.setLayout ( new FillLayout () );
        final Label label = new Label ( waitShell, SWT.NONE );
        label.setText ( "Opening view…" );

        waitShell.pack ();
        waitShell.open ();

        // make sure the text is visible
        waitShell.getDisplay ().update ();

        try
        {
            open ( parentShell, detailViewId, parameters );
        }
        finally
        {
            // close the wait shell
            waitShell.close ();
        }

    }

    protected void open ( final Shell parentShell, final String detailViewId, final Map<String, String> parameters )
    {
        // now open the real dialog
        final DetailViewDialog dlg = new DetailViewDialog ( parentShell, detailViewId, parameters );
        dlg.open ();
    }

}
