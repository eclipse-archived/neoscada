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

import org.eclipse.scada.core.client.Connection;
import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.eclipse.swt.widgets.TabFolder;

public abstract class AbstractConnectionTab implements DetailsTab
{

    @Override
    public void setSelection ( final ConnectionService connectionService )
    {
        if ( connectionService != null && connectionService.getConnection () != null )
        {
            setConnection ( connectionService.getConnection () );
        }
        else
        {
            setConnection ( null );
        }
    }

    protected abstract void setConnection ( Connection connection );

    @Override
    public abstract void createTab ( final TabFolder tabFolder );

}