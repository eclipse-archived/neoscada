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
import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.eclipse.ui.views.properties.IPropertySource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionHolderAdapterFactory implements IAdapterFactory
{

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionHolderAdapterFactory.class );

    @Override
    @SuppressWarnings ( "rawtypes" )
    public Object getAdapter ( final Object adaptableObject, final Class adapterType )
    {
        logger.debug ( "Adapting: {} to {}", adaptableObject, adapterType );

        if ( adaptableObject instanceof ConnectionHolder && adapterType == IPropertySource.class )
        {
            return new PropertySourceWrapper ( (ConnectionHolder)adaptableObject );
        }
        if ( adaptableObject instanceof IAdaptable )
        {
            return ( (IAdaptable)adaptableObject ).getAdapter ( adapterType );
        }
        return null;
    }

    @SuppressWarnings ( "rawtypes" )
    @Override
    public Class[] getAdapterList ()
    {
        return new Class[] { ConnectionService.class };
    }

}
