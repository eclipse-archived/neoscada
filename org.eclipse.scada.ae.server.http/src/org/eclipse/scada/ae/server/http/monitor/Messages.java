/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.server.http.monitor;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages
{
    private static final String BUNDLE_NAME = "org.eclipse.scada.ae.server.http.monitor.messages"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle ( BUNDLE_NAME );

    private Messages ()
    {
    }

    public static String getString ( String key )
    {
        try
        {
            return RESOURCE_BUNDLE.getString ( key );
        }
        catch ( MissingResourceException e )
        {
            return '!' + key + '!';
        }
    }
}
