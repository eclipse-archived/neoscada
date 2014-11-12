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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.ComponentWorld;
import org.eclipse.scada.configuration.component.ExternalValue;
import org.eclipse.scada.configuration.component.MasterComponent;
import org.eclipse.scada.configuration.component.lib.Worlds;
import org.eclipse.scada.configuration.component.tools.Activator;
import org.eclipse.scada.configuration.component.tools.dialog.MasterSelectionDialog;
import org.eclipse.scada.configuration.component.tools.utils.CompoundManager;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.utils.SelectionHelper;

public class SetMasterHandler extends AbstractSelectionHandler
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
            setMaster ( dlg.getMaster (), dlg.isReplace () );
        }
        return null;
    }

    private MasterSelectionDialog selectMaster () throws CoreException
    {
        final World world = findWorld ();
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

    private World findWorld () throws CoreException
    {
        ComponentWorld world = null;
        for ( final ExternalValue v : SelectionHelper.iterable ( getSelection (), ExternalValue.class ) )
        {
            final ComponentWorld w = Worlds.findComponentWorld ( v );
            if ( w == null )
            {
                throw new CoreException ( new Status ( IStatus.ERROR, Activator.PLUGIN_ID, String.format ( "Element does not belong to a component world: %s", v ) ) );
            }
            if ( world != null && w != world )
            {
                throw new CoreException ( new Status ( IStatus.ERROR, Activator.PLUGIN_ID, String.format ( "Elements belong to different component worlds. This is not supported for now.", v ) ) );
            }
            world = w;
        }
        return world.getInfrastructure ();
    }

    public void setMaster ( final MasterServer master, final boolean replace )
    {
        final CompoundManager manager = new CompoundManager ();

        for ( final MasterComponent v : SelectionHelper.iterable ( getSelection (), MasterComponent.class ) )
        {
            final EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor ( v );
            if ( domain == null )
            {
                continue;
            }

            if ( replace )
            {
                manager.append ( domain, SetCommand.create ( domain, v, ComponentPackage.Literals.MASTER_COMPONENT__MASTER_ON, Collections.singletonList ( master ) ) );

            }
            else
            {
                manager.append ( domain, AddCommand.create ( domain, v, ComponentPackage.Literals.MASTER_COMPONENT__MASTER_ON, master ) );
            }
        }

        manager.executeAll ();
    }

}
