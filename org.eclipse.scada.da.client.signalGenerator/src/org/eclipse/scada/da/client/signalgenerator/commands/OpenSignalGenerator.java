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
package org.eclipse.scada.da.client.signalgenerator.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.scada.da.client.signalgenerator.GeneratorView;
import org.eclipse.scada.da.ui.connection.commands.AbstractItemHandler;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

public class OpenSignalGenerator extends AbstractItemHandler
{

    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        for ( final Item item : getItems () )
        {
            GeneratorView view;
            try
            {
                view = (GeneratorView)getActivePage ().showView ( GeneratorView.VIEW_ID, asSecondardId ( item ), IWorkbenchPage.VIEW_ACTIVATE );
            }
            catch ( final PartInitException e )
            {
                throw new ExecutionException ( "Failed to open view", e );
            }
            view.setDataItem ( item );
        }

        return null;
    }

}
