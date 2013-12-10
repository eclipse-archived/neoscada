/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.common.lib;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.configuration.component.common.HeartbeatGenerator;
import org.eclipse.scada.configuration.generator.Generator;

public class AdapterFactory implements IAdapterFactory
{

    @SuppressWarnings ( "rawtypes" )
    @Override
    public Object getAdapter ( final Object adaptableObject, final Class adapterType )
    {
        if ( !Generator.class.equals ( adapterType ) )
        {
            return null;
        }

        if ( adaptableObject instanceof HeartbeatGenerator )
        {
            return new HeartbeatGeneratorGenerator ( (HeartbeatGenerator)adaptableObject );
        }
        return null;
    }

    @SuppressWarnings ( "rawtypes" )
    @Override
    public Class[] getAdapterList ()
    {
        return new Class<?>[] { Generator.class };
    }

}
