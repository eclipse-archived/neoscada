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
package org.eclipse.scada.da.server.jdbc;

import org.eclipse.scada.da.core.server.Hive;
import org.eclipse.scada.da.core.server.HiveCreator;
import org.eclipse.scada.da.jdbc.configuration.RootType;
import org.osgi.framework.BundleContext;

public class HiveCreatorImpl implements HiveCreator
{
    private BundleContext context;

    public void activate ( final BundleContext context )
    {
        this.context = context;
    }

    @Override
    public Hive createHive ( final String reference, final Object configuration ) throws Exception
    {
        if ( !reference.equals ( org.eclipse.scada.da.server.jdbc.Hive.class.getName () ) )
        {
            return null;
        }

        if ( configuration instanceof RootType )
        {
            return new org.eclipse.scada.da.server.jdbc.Hive ( (RootType)configuration, this.context );
        }
        else if ( configuration instanceof String )
        {
            return new org.eclipse.scada.da.server.jdbc.Hive ( (String)configuration, this.context );
        }
        else
        {
            return null;
        }
    }

}
