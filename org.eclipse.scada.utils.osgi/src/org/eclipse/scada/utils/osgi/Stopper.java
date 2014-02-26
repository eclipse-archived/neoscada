/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.osgi;

import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkUtil;

public class Stopper
{
    public static void stop ( final String[] args )
    {
        try
        {
            FrameworkUtil.getBundle ( Stopper.class ).getBundleContext ().getBundle ( 0 ).stop ();
        }
        catch ( final BundleException e )
        {
            e.printStackTrace (); // this is special
            // failed to stop
        }
    }
}
