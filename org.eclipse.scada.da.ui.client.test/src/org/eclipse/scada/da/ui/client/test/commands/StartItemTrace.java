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
package org.eclipse.scada.da.ui.client.test.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.scada.da.ui.client.test.console.DataItemConsole;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.databinding.SelectionHelper;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;

public class StartItemTrace extends AbstractSelectionHandler
{

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {

        final List<IConsole> consoles = new ArrayList<IConsole> ();

        for ( final Item item : SelectionHelper.iterable ( getSelection (), Item.class ) )
        {
            final IConsole console = createConsole ( item ).getConsole ();
            if ( console != null )
            {
                consoles.add ( console );
            }
        }

        final IConsoleManager cm = ConsolePlugin.getDefault ().getConsoleManager ();
        if ( !consoles.isEmpty () )
        {
            cm.addConsoles ( consoles.toArray ( new IConsole[consoles.size ()] ) );
            cm.showConsoleView ( consoles.get ( 0 ) );
        }

        return null;
    }

    private DataItemConsole createConsole ( final Item item )
    {
        return new DataItemConsole ( item );
    }
}
