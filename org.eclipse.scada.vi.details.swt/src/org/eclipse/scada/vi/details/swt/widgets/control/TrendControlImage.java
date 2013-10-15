/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - added logger
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.widgets.control;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.Parameterization;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.scada.vi.details.swt.Activator;
import org.eclipse.scada.vi.details.swt.widgets.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.statushandlers.StatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrendControlImage extends Composite
{

    private final static Logger logger = LoggerFactory.getLogger ( TrendControlImage.class );

    private final String connectionId;

    private final String itemId;

    private final String queryString;

    public TrendControlImage ( final Composite parent, final int style, final String connectionId, final String itemId, final String queryString )
    {
        super ( parent, style );

        this.connectionId = connectionId;
        this.itemId = itemId;
        this.queryString = queryString;

        setLayout ( new FillLayout () );

        final Button button = new Button ( parent, SWT.PUSH | SWT.FLAT );
        button.setImage ( org.eclipse.scada.vi.details.swt.Activator.getDefault ().getImageRegistry ().get ( org.eclipse.scada.vi.details.swt.Activator.IMG_TREND ) );
        button.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                startHdView ();
            }
        } );
    }

    protected void startHdView ()
    {
        try
        {
            final ICommandService commandService = (ICommandService)PlatformUI.getWorkbench ().getService ( ICommandService.class );
            final IHandlerService handlerService = (IHandlerService)PlatformUI.getWorkbench ().getService ( IHandlerService.class );

            final Command command = commandService.getCommand ( "org.eclipse.scada.ui.chart.commands.OpenParametersCharView" ); //$NON-NLS-1$

            final Parameterization[] parameterizations = new Parameterization[4];
            parameterizations[0] = new Parameterization ( command.getParameter ( "org.eclipse.scada.ui.chart.connectionId" ), this.connectionId ); //$NON-NLS-1$
            parameterizations[1] = new Parameterization ( command.getParameter ( "org.eclipse.scada.ui.chart.itemId" ), this.itemId ); //$NON-NLS-1$
            if ( this.queryString == null || this.queryString.isEmpty () )
            {
                parameterizations[2] = new Parameterization ( command.getParameter ( "org.eclipse.scada.ui.chart.queryTimespec" ), "2400000:600000" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            else
            {
                parameterizations[2] = new Parameterization ( command.getParameter ( "org.eclipse.scada.ui.chart.queryTimespec" ), this.queryString ); //$NON-NLS-1$ 
            }
            parameterizations[3] = new Parameterization ( command.getParameter ( "org.eclipse.scada.ui.chart.itemType" ), "hd" ); //$NON-NLS-1$ //$NON-NLS-2$

            final ParameterizedCommand parameterCommand = new ParameterizedCommand ( command, parameterizations );

            handlerService.executeCommand ( parameterCommand, null );
        }
        catch ( final Exception e )
        {
            logger.debug ( "Failed to open view", e );
            StatusManager.getManager ().handle ( new Status ( IStatus.ERROR, Activator.PLUGIN_ID, Messages.TrendControlImage_TrendError, e ), StatusManager.BLOCK );
        }
    }
}
