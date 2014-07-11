/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - use new Adapter and Selection Helper
 *     IBH SYSTEMS GmbH - adding a connection store selector
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.wizards;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.scada.core.ui.connection.ConnectionDescriptor;
import org.eclipse.scada.core.ui.connection.ConnectionStore;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.statushandlers.StatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddConnectionWizard extends Wizard implements INewWizard
{

    private final static Logger logger = LoggerFactory.getLogger ( AddConnectionWizard.class );

    private AddConnectionWizardPage1 entryPage;

    private ConnectionStore store;

    private ConnectionDescriptor preset;

    private SelectConnectionStorePage storePage;

    protected boolean isUpdateMode ()
    {
        return false;
    }

    @Override
    public boolean performFinish ()
    {
        final ConnectionDescriptor connectionInformation = this.entryPage.getConnectionInformation ();

        final ConnectionStore store = getStore ();

        try
        {
            if ( connectionInformation != null )
            {
                if ( isUpdateMode () )
                {
                    store.update ( this.preset, connectionInformation );
                }
                else
                {
                    store.add ( connectionInformation );
                }
            }
        }
        catch ( final CoreException e )
        {
            StatusManager.getManager ().handle ( e.getStatus (), StatusManager.BLOCK );
            return false;
        }

        return connectionInformation != null;
    }

    protected ConnectionStore getStore ()
    {
        final ConnectionStore store;
        if ( this.storePage != null )
        {
            store = this.storePage.getStore ();
        }
        else
        {
            store = this.store;
        }
        return store;
    }

    @Override
    public void init ( final IWorkbench workbench, final IStructuredSelection selection )
    {
        final Object o = selection.getFirstElement ();

        if ( o == null )
        {
            return;
        }

        this.store = AdapterHelper.adapt ( o, ConnectionStore.class );
        logger.info ( "Store is: {}", this.store ); //$NON-NLS-1$

        final ConnectionHolder holder = AdapterHelper.adapt ( o, ConnectionHolder.class );
        if ( holder != null )
        {
            if ( this.store == null )
            {
                this.store = AdapterHelper.adapt ( holder.getDiscoverer (), ConnectionStore.class );
            }
            this.preset = holder.getConnectionInformation ();
        }
        logger.info ( "Preset is: {}", this.preset ); //$NON-NLS-1$
    }

    @Override
    public boolean canFinish ()
    {
        if ( !super.canFinish () )
        {
            return false;
        }

        if ( getStore () == null )
        {
            return false;
        }
        if ( this.entryPage.getConnectionInformation () == null )
        {
            return false;
        }
        return true;
    }

    @Override
    public void addPages ()
    {
        super.addPages ();
        if ( !isUpdateMode () && this.store == null )
        {
            addPage ( this.storePage = new SelectConnectionStorePage () );
        }
        addPage ( this.entryPage = new AddConnectionWizardPage1 ( this.preset ) );
    }
}
