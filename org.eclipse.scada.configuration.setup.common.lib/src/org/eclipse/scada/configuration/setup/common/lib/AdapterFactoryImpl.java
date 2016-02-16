/*******************************************************************************
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.setup.common.lib;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.configuration.setup.common.PostgresSetupModule;
import org.eclipse.scada.configuration.setup.common.SerialToNetworkSetupModule;
import org.eclipse.scada.configuration.world.lib.setup.SetupModuleHandler;

public class AdapterFactoryImpl implements IAdapterFactory
{
    @Override
    public <T> T getAdapter ( final Object adaptableObject, final Class<T> adapterType )
    {
        if ( adapterType.equals ( SetupModuleHandler.class ) )
        {
            if ( adaptableObject instanceof PostgresSetupModule )
            {
                return adapterType.cast ( new PostgresHandler ( (PostgresSetupModule)adaptableObject ) );
            }
            else if ( adaptableObject instanceof SerialToNetworkSetupModule )
            {
                return adapterType.cast ( new SerialToNetworkHandler ( (SerialToNetworkSetupModule)adaptableObject ) );
            }
        }
        return null;
    }

    @Override
    public Class<?>[] getAdapterList ()
    {
        return new Class[] { SetupModuleHandler.class };
    }
}
