/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.ui.connection;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.da.connection.provider.ConnectionService;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;

public class ConnectionHolderAdapterFactory implements IAdapterFactory
{

    @Override
    @SuppressWarnings ( "rawtypes" )
    public Object getAdapter ( final Object adaptableObject, final Class adapterType )
    {
        if ( adapterType == ConnectionService.class && adaptableObject instanceof ConnectionHolder )
        {
            final ConnectionHolder holder = (ConnectionHolder)adaptableObject;
            final org.eclipse.scada.core.connection.provider.ConnectionService service = holder.getConnectionService ();
            if ( service instanceof ConnectionService )
            {
                return service;
            }
        }
        return null;
    }

    @Override
    @SuppressWarnings ( "rawtypes" )
    public Class[] getAdapterList ()
    {
        return new Class[] { ConnectionService.class };
    }

}
