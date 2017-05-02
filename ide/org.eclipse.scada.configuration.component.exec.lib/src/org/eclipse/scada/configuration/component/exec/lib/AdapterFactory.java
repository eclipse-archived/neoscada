/*******************************************************************************
 * Copyright (c) 2013, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.exec.lib;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.configuration.component.exec.LoadAverage;
import org.eclipse.scada.configuration.component.exec.PingCheck;
import org.eclipse.scada.configuration.component.exec.SystemInformationVMStat;
import org.eclipse.scada.configuration.generator.Generator;

public class AdapterFactory implements IAdapterFactory
{
    @Override
    public <T> T getAdapter ( final Object adaptableObject, final Class<T> adapterType )
    {
        if ( !Generator.class.equals ( adapterType ) )
        {
            return null;
        }

        if ( adaptableObject instanceof LoadAverage )
        {
            return adapterType.cast ( new LoadAverageGenerator ( (LoadAverage)adaptableObject ) );
        }
        else if ( adaptableObject instanceof PingCheck )
        {
            return adapterType.cast ( new PingCheckGenerator ( (PingCheck)adaptableObject ) );
        }
        else if ( adaptableObject instanceof SystemInformationVMStat )
        {
            return adapterType.cast ( new SystemInformationVMStatGenerator ( (SystemInformationVMStat)adaptableObject ) );
        }
        return null;
    }

    @Override
    public Class<?>[] getAdapterList ()
    {
        return new Class<?>[] { Generator.class };
    }
}
