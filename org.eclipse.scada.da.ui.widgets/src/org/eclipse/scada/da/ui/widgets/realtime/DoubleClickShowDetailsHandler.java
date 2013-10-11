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
package org.eclipse.scada.da.ui.widgets.realtime;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.scada.da.ui.widgets.Activator;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.statushandlers.StatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DoubleClickShowDetailsHandler implements IDoubleClickListener
{

    private static final String COMMAND_ID = "org.eclipse.scada.da.client.dataitem.details.openDetails";

    private final static Logger logger = LoggerFactory.getLogger ( DoubleClickShowDetailsHandler.class );

    @Override
    public void doubleClick ( final DoubleClickEvent event )
    {
        try
        {
            final IHandlerService handlerService = (IHandlerService)PlatformUI.getWorkbench ().getService ( IHandlerService.class );
            handlerService.executeCommand ( COMMAND_ID, null );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to execute command", e );
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.BLOCK );
        }
    }

}
