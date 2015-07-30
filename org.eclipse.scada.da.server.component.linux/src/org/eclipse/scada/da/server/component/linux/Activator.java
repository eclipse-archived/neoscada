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
package org.eclipse.scada.da.server.component.linux;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.da.server.component.ComponentFactory;
import org.eclipse.scada.utils.concurrent.ScheduledExportedExecutorService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{

    private ScheduledExecutorService executor;

    private final List<ServiceRegistration<?>> regs = new LinkedList<> ();

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.executor = ScheduledExportedExecutorService.newSingleThreadExportedScheduledExecutor ( context.getBundle ().getSymbolicName () );

        addFactory ( context, new CpuInfoComponentFactory ( this.executor ) );
    }

    private void addFactory ( final BundleContext context, final ComponentFactory componentFactory )
    {
        final Dictionary<String, Object> properties = new Hashtable<> ( 1 );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" ); //$NON-NLS-1$
        this.regs.add ( context.registerService ( ComponentFactory.class, componentFactory, properties ) );
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        for ( final ServiceRegistration<?> reg : this.regs )
        {
            reg.unregister ();
        }
        this.regs.clear ();

        // now shutdown
        this.executor.shutdown ();
    }

}
