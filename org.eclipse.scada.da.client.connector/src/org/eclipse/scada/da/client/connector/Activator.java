/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - cleanup deprecated connection initializer
 *******************************************************************************/
package org.eclipse.scada.da.client.connector;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.client.Connection;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin
{

    public static final String PLUGIN_ID = "org.eclipse.scada.da.client.connector"; //$NON-NLS-1$

    public static final String NATIVE_LS = System.getProperty ( "line.separator", "\n" ); //$NON-NLS-1$ //$NON-NLS-2$

    private static Activator instance;

    public Activator ()
    {
    }

    public static Activator getDefault ()
    {
        return instance;
    }

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        super.start ( context );
        instance = this;
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        instance = null;
        super.stop ( context );
    }

    public static Connection createConnection ( final ConnectionInformation ci )
    {
        return ConnectorHelper.createConnection ( ci );
    }
}
