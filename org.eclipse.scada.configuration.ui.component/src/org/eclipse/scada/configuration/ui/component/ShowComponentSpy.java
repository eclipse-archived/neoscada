/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.ui.component;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.databinding.SelectionHelper;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.ui.statushandlers.StatusManager;

public class ShowComponentSpy extends AbstractSelectionHandler
{

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        final Component component = SelectionHelper.first ( getSelection (), Component.class );
        if ( component == null )
        {
            return null;
        }

        try
        {
            final IObservableSet input = Helper.createObversableInput ( SWTObservables.getRealm ( getShell ().getDisplay () ), component );
            new ComponentOutputDialog ( getShell (), input ).open ();
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, "Failed to generate component output", e ), StatusManager.BLOCK );
            throw new ExecutionException ( "Failed to generate component output", e );
        }

        return null;
    }
}
