/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.ui.client.test.console;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.scada.da.ui.client.test.Activator;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsolePageParticipant;
import org.eclipse.ui.part.IPageBookViewPage;

public class ItemTraceConsolePageParticipant implements IConsolePageParticipant
{
    public static class CloseAction extends Action
    {
        private final IConsole console;

        public CloseAction ( final IConsole console )
        {
            super ( "Close", Activator.getImageDescriptor ( "icons/16x16/close.gif" ) );
            this.console = console;
        }

        @Override
        public void run ()
        {
            ConsolePlugin.getDefault ().getConsoleManager ().removeConsoles ( new IConsole[] { this.console } );
        }
    }

    public static class StopAction extends Action
    {
        private final ItemTraceIOConsole console;

        public StopAction ( final ItemTraceIOConsole console )
        {
            super ( "Stop", Activator.getImageDescriptor ( "icons/16x16/stop.gif" ) );
            this.console = console;
        }

        @Override
        public void run ()
        {
            this.console.stop ();
        }
    }

    private IToolBarManager mgr;

    @SuppressWarnings ( "rawtypes" )
    @Override
    public Object getAdapter ( final Class adapter )
    {
        return null;
    }

    @Override
    public void init ( final IPageBookViewPage page, final IConsole console )
    {
        final ItemTraceIOConsole traceConsole = (ItemTraceIOConsole)console;

        this.mgr = page.getSite ().getActionBars ().getToolBarManager ();
        this.mgr.appendToGroup ( IConsoleConstants.OUTPUT_GROUP, new StopAction ( traceConsole ) );
        this.mgr.appendToGroup ( IConsoleConstants.OUTPUT_GROUP, new CloseAction ( traceConsole ) );
    }

    @Override
    public void dispose ()
    {
    }

    @Override
    public void activated ()
    {
    }

    @Override
    public void deactivated ()
    {
    }

}
