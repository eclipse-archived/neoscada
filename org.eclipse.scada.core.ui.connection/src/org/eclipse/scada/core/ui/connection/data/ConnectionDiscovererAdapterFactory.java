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
package org.eclipse.scada.core.ui.connection.data;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.core.ui.connection.ConnectionDiscoverer;
import org.eclipse.scada.core.ui.connection.ConnectionStore;

public class ConnectionDiscovererAdapterFactory implements IAdapterFactory
{

    @Override
    public <T> T getAdapter ( final Object adaptableObject, final Class<T> adapterType )
    {
        if ( adaptableObject instanceof IAdaptable )
        {
            return ( (IAdaptable)adaptableObject ).getAdapter ( adapterType );
        }
        return null;
    }

    @Override
    public Class<?>[] getAdapterList ()
    {
        return new Class[] { ConnectionStore.class, ConnectionDiscoverer.class };
    }

}
