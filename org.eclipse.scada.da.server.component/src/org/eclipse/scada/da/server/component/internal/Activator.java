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
package org.eclipse.scada.da.server.component.internal;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.da.server.component.Hive;
import org.eclipse.scada.utils.concurrent.ExportedExecutorService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{
    private Hive hive;

    private ServiceRegistration<org.eclipse.scada.da.core.server.Hive> handle;

    private ExportedExecutorService executor;

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.executor = new ExportedExecutorService ( "org.eclipse.scada.da.server.component", 1, 1, 1, TimeUnit.MINUTES ); //$NON-NLS-1$

        this.hive = new Hive ( context, this.executor );

        this.hive.start ();
        final Dictionary<String, Object> properties = new Hashtable<> ();
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        properties.put ( "hive.id", this.hive.getHiveId () ); //$NON-NLS-1$
        this.handle = context.registerService ( org.eclipse.scada.da.core.server.Hive.class, this.hive, properties );
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        if ( this.handle != null )
        {
            this.handle.unregister ();
            this.handle = null;
        }
        if ( this.hive != null )
        {
            this.hive.stop ();
            this.hive = null;
        }
        if ( this.executor != null )
        {
            this.executor.shutdown ();
            this.executor = null;
        }
    }

}
