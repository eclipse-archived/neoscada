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
package org.eclipse.scada.da.server.proxy;

import org.eclipse.scada.da.core.server.Hive;
import org.eclipse.scada.da.core.server.HiveCreator;
import org.eclipse.scada.da.proxy.configuration.RootType;

public class HiveCreatorImpl implements HiveCreator
{

    @Override
    public Hive createHive ( final String reference, final Object configuration ) throws Exception
    {
        if ( !reference.equals ( org.eclipse.scada.da.server.proxy.Hive.class.getName () ) )
        {
            return null;
        }

        if ( configuration instanceof RootType )
        {
            return new org.eclipse.scada.da.server.proxy.Hive ( (RootType)configuration );
        }
        else if ( configuration instanceof String )
        {
            return new org.eclipse.scada.da.server.proxy.Hive ( (String)configuration );
        }
        else
        {
            return null;
        }
    }

}
