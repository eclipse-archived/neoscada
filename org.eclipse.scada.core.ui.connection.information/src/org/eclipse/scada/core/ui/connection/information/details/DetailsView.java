/*******************************************************************************
 * Copyright (c) 2013, 2014 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *     IBH SYSTEMS GmbH - use new selection helper
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.information.details;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.eclipse.scada.ui.utils.SelectionHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;

public class DetailsView
{

    private final TabFolder tabFolder;

    private final Set<DetailsTab> tabs = new LinkedHashSet<DetailsTab> ();

    public DetailsView ( final Composite parent )
    {
        this.tabFolder = new TabFolder ( parent, SWT.NONE );

        this.tabs.add ( new InterfacesTab () );
        this.tabs.add ( new StatisticsTab () );
        this.tabs.add ( new PrivilegeTab () );
        this.tabs.add ( new PropertiesTab () );

        for ( final DetailsTab tab : this.tabs )
        {
            tab.createTab ( this.tabFolder );
        }
    }

    public void setFocus ()
    {
        this.tabFolder.setFocus ();
    }

    public void setSelection ( final ISelection selection )
    {
        final ConnectionService connectionService = SelectionHelper.first ( selection, ConnectionService.class );
        for ( final DetailsTab tab : this.tabs )
        {
            tab.setSelection ( connectionService );
        }
    }

}
