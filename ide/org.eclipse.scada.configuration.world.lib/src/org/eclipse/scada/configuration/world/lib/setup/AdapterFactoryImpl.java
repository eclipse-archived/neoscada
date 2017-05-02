/*******************************************************************************
 * Copyright (c) 2014, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.lib.setup;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.configuration.world.setup.SubContainerModule;

public class AdapterFactoryImpl implements IAdapterFactory
{
    @Override
    public <T> T getAdapter ( final Object adaptableObject, final Class<T> adapterType )
    {
        if ( adapterType.equals ( SetupModuleHandler.class ) )
        {
            if ( adaptableObject instanceof SubContainerModule )
            {
                return adapterType.cast ( new SubModuleHandler ( (SubContainerModule)adaptableObject ) );
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
