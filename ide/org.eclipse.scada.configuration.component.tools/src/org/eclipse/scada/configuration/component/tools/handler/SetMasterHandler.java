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
package org.eclipse.scada.configuration.component.tools.handler;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.MasterAssigned;
import org.eclipse.scada.configuration.component.tools.MasterMode;
import org.eclipse.scada.configuration.component.tools.dialog.MasterSelectionDialog;
import org.eclipse.scada.configuration.component.tools.utils.CompoundManager;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.ui.utils.SelectionHelper;

public class SetMasterHandler extends AbstractToolHandler
{

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        final MasterSelectionDialog dlg;
        try
        {
            dlg = selectMaster ();
        }
        catch ( final CoreException e )
        {
            throw new ExecutionException ( "Failed to select driver", e );
        }

        if ( dlg != null )
        {
            setMaster ( dlg.getMaster (), dlg.getMode () );
        }
        return null;
    }

    private MasterSelectionDialog selectMaster () throws CoreException
    {
        final World world = findInfrastructureWorld ();
        if ( world == null )
        {
            return null;
        }

        final MasterSelectionDialog dlg = new MasterSelectionDialog ( getShell (), world );
        if ( dlg.open () == Window.OK )
        {
            return dlg;
        }
        else
        {
            return null;
        }
    }

    public void setMaster ( final MasterServer master, final MasterMode masterMode )
    {
        final CompoundManager manager = new CompoundManager ();

        for ( final MasterAssigned v : SelectionHelper.iterable ( getSelection (), MasterAssigned.class ) )
        {
            final EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor ( v );
            if ( domain == null )
            {
                continue;
            }

            switch ( masterMode )
            {
                case ADD:
                    manager.append ( domain, AddCommand.create ( domain, v, ComponentPackage.Literals.MASTER_ASSIGNED__MASTER_ON, master ) );
                    break;
                case REPLACE:
                    manager.append ( domain, SetCommand.create ( domain, v, ComponentPackage.Literals.MASTER_ASSIGNED__MASTER_ON, Collections.singletonList ( master ) ) );
                    break;
                case DELETE:
                    manager.append ( domain, RemoveCommand.create ( domain, v, ComponentPackage.Literals.MASTER_ASSIGNED__MASTER_ON, master ) );
                    break;
            }
        }

        manager.executeAll ();
    }

}
