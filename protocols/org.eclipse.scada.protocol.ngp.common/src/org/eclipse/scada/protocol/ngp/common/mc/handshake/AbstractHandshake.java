/*******************************************************************************
 * Copyright (c) 2010, 2016 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *     IBH SYSTEMS GmbH - cleanups and fixes
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.common.mc.handshake;

import java.util.Map;

public abstract class AbstractHandshake implements Handshake
{

    protected static Integer getInteger ( final Map<String, String> properties, final String key, final Integer defaultValue )
    {
        final String value = properties.get ( key );
        if ( value == null )
        {
            return defaultValue;
        }
        try
        {
            return Integer.parseInt ( value );
        }
        catch ( final Exception e )
        {
            return defaultValue;
        }
    }

    protected static Boolean getBoolean ( final Map<String, String> properties, final String key, final Boolean defaultValue )
    {
        final String value = properties.get ( key );
        if ( value == null )
        {
            return defaultValue;
        }
        return Boolean.parseBoolean ( value );
    }

}
