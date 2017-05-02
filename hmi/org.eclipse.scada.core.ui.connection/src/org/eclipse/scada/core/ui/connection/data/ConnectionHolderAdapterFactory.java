/*******************************************************************************
 * Copyright (c) 2009, 2015 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - cleanup
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.data;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.eclipse.ui.views.properties.IPropertySource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionHolderAdapterFactory implements IAdapterFactory
{

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionHolderAdapterFactory.class );

    @Override
    public <T> T getAdapter ( final Object adaptableObject, final Class<T> adapterType )
    {
        logger.debug ( "Adapting: {} to {}", adaptableObject, adapterType );

        if ( adaptableObject instanceof ConnectionHolder && adapterType == IPropertySource.class )
        {
            return adapterType.cast ( new PropertySourceWrapper ( (ConnectionHolder)adaptableObject ) );
        }
        if ( adaptableObject instanceof IAdaptable )
        {
            return ( (IAdaptable)adaptableObject ).getAdapter ( adapterType );
        }
        return null;
    }

    @Override
    public Class<?>[] getAdapterList ()
    {
        return new Class[] { ConnectionService.class };
    }

}
