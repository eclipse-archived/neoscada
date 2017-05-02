/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.information.details;

import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableSetContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.scada.core.client.Connection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class PrivilegeTab extends AbstractConnectionTab implements DetailsTab
{

    private PrivilegeSet privileges;

    private Display display;

    private TabItem item;

    private ListViewer viewer;

    @Override
    protected void setConnection ( final Connection connection )
    {
        if ( this.privileges != null )
        {
            this.privileges.dispose ();
            this.privileges = null;
        }

        if ( connection != null )
        {
            this.privileges = new PrivilegeSet ( connection, SWTObservables.getRealm ( this.display ) );
            this.viewer.setInput ( this.privileges );
        }
    }

    @Override
    public void createTab ( final TabFolder tabFolder )
    {
        this.display = tabFolder.getDisplay ();
        this.item = new TabItem ( tabFolder, SWT.NONE );
        this.item.setText ( "Privileges" );

        this.viewer = new ListViewer ( tabFolder );

        this.viewer.setContentProvider ( new ObservableSetContentProvider () );

        this.item.setControl ( this.viewer.getControl () );
    }

}
