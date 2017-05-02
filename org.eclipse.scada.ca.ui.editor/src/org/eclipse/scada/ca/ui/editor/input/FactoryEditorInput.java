/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.ui.editor.input;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.scada.ca.data.DiffEntry;
import org.eclipse.scada.ca.data.Operation;
import org.eclipse.scada.ca.ui.jobs.DiffJob;
import org.eclipse.scada.ca.ui.jobs.LoadFactoryJob;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.scada.ca.connection.provider.ConnectionService;

public class FactoryEditorInput implements IEditorInput
{

    private final String connectionUri;

    private final String factoryId;

    private final ConnectionService connectionService;

    public FactoryEditorInput ( final ConnectionService connectionService, final String factoryId )
    {
        this.connectionService = connectionService;
        this.connectionUri = connectionService.getConnection ().getConnectionInformation ().toString ();
        this.factoryId = factoryId;
    }

    public String getConnectionUri ()
    {
        return this.connectionUri;
    }

    @Override
    public String toString ()
    {
        return this.factoryId;
    }

    @Override
    public boolean exists ()
    {
        return true;
    }

    @Override
    public ImageDescriptor getImageDescriptor ()
    {
        return null;
    }

    @Override
    public String getName ()
    {
        return toString ();
    }

    @Override
    public IPersistableElement getPersistable ()
    {
        return null;
    }

    @Override
    public String getToolTipText ()
    {
        return toString ();
    }

    @Override
    @SuppressWarnings ( "rawtypes" )
    public Object getAdapter ( final Class adapter )
    {
        return null;
    }

    public LoadFactoryJob createLoadJob ()
    {
        return new LoadFactoryJob ( this.connectionService, this.factoryId );
    }

    public Job createDeleteJob ( final Collection<String> items )
    {
        final List<DiffEntry> diffEntries = new LinkedList<DiffEntry> ();

        for ( final String configurationId : items )
        {
            diffEntries.add ( new DiffEntry ( this.factoryId, configurationId, Operation.DELETE, null, null, null ) );
        }

        return new DiffJob ( "Delete configurations", this.connectionService, diffEntries );
    }

    public Job createCreateJob ( final String configurationId )
    {
        final DiffEntry entry = new DiffEntry ( this.factoryId, configurationId, Operation.ADD, null, Collections.<String, String> emptyMap (), null );

        return new DiffJob ( "Create configuration", this.connectionService, entry );
    }

}
