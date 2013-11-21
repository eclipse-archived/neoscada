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
package org.eclipse.scada.build.helper.name;

import org.eclipse.scada.build.helper.name.QualifierNameProvider.Configuration;

public class Helper
{
    public static String getProperty ( final Configuration configuration, final String name, final String defaultValue )
    {
        final String result = configuration.getProperties ().get ( name );
        if ( result == null )
        {
            return defaultValue;
        }
        else
        {
            return result;
        }
    }
}
