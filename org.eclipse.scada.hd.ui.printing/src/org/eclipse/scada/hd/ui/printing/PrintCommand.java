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
package org.eclipse.scada.hd.ui.printing;

import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.scada.hd.data.ValueInformation;
import org.eclipse.scada.hd.ui.connection.handler.AbstractQueryHandler;
import org.eclipse.scada.hd.ui.data.AbstractQueryBuffer;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;

public class PrintCommand extends AbstractQueryHandler
{

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        for ( final AbstractQueryBuffer query : getQueries () )
        {
            printQuery ( query );
        }
        return null;
    }

    private void printQuery ( final AbstractQueryBuffer query )
    {
        final List<ValueInformation> vis = query.getValueInformation ();
        final Map<String, List<Double>> values = query.getValues ();

        final PrintDialog dlg = new PrintDialog ( getWorkbenchWindow ().getShell () );

        final PrinterData printerData = dlg.open ();

        if ( printerData == null )
        {
            return;
        }

        printerData.orientation = PrinterData.LANDSCAPE;

        final Printer printer = new Printer ( printerData );

        try
        {
            final PrintProcessor processor = new PrintProcessor ( vis, values );
            processor.print ( printer );
        }
        finally
        {
            printer.dispose ();
        }
    }
}
