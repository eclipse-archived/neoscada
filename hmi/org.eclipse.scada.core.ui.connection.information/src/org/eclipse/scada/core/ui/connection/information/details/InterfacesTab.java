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

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class InterfacesTab implements DetailsTab
{
    private TabItem item;

    private ListViewer viewer;

    @Override
    public void createTab ( final TabFolder tabFolder )
    {
        this.item = new TabItem ( tabFolder, SWT.NONE );
        this.item.setText ( Messages.InterfacesTab_TabItem_Label );

        this.viewer = new ListViewer ( tabFolder );
        this.item.setControl ( this.viewer.getControl () );
        this.viewer.setContentProvider ( new ArrayContentProvider () );
    }

    @Override
    public void setSelection ( final ConnectionService connectionService )
    {
        if ( connectionService == null )
        {
            this.viewer.setInput ( null );
        }
        else
        {
            this.viewer.setInput ( connectionService.getSupportedInterfaces () );
        }
    }
}
