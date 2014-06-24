/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.driver.jdbc.lib;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.configuration.driver.jdbc.JdbcDriver;
import org.eclipse.scada.configuration.driver.jdbc.QueryComponent;
import org.eclipse.scada.configuration.driver.jdbc.UpdateCommand;
import org.eclipse.scada.configuration.generator.Generator;
import org.eclipse.scada.configuration.infrastructure.lib.DriverHandler;

public class AdapterFactory implements IAdapterFactory
{

    @SuppressWarnings ( "rawtypes" )
    @Override
    public Object getAdapter ( final Object adaptableObject, final Class adapterType )
    {
        if ( Generator.class.equals ( adapterType ) )
        {
            if ( adaptableObject instanceof UpdateCommand )
            {
                return new UpdateCommandGenerator ( (UpdateCommand)adaptableObject );
            }
            else if ( adaptableObject instanceof QueryComponent )
            {
                return new QueryComponentGenerator ( (QueryComponent)adaptableObject );
            }
        }
        if ( DriverHandler.class.equals ( adapterType ) )
        {
            if ( adaptableObject instanceof JdbcDriver )
            {
                return new DriverHandlerImpl ();
            }
        }

        return null;
    }

    @SuppressWarnings ( "rawtypes" )
    @Override
    public Class[] getAdapterList ()
    {
        return new Class<?>[] { Generator.class, DriverHandler.class };
    }

}
