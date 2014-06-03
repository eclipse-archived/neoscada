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
package org.eclipse.scada.da.server.component.osgi;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.scada.da.server.component.ComponentFactory;
import org.eclipse.scada.da.server.component.ComponentHandle;
import org.eclipse.scada.da.server.component.ComponentHost;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class OsgiFactory
{
    private final ExecutorService executor;

    private final ServiceTracker<ComponentFactory, ComponentFactory> tracker;

    private final ServiceTrackerCustomizer<ComponentFactory, ComponentFactory> customizer = new ServiceTrackerCustomizer<ComponentFactory, ComponentFactory> () {

        @Override
        public void removedService ( final ServiceReference<ComponentFactory> reference, final ComponentFactory service )
        {
            handleRemovedService ( reference );
        }

        @Override
        public void modifiedService ( final ServiceReference<ComponentFactory> reference, final ComponentFactory service )
        {
            handleRemovedService ( reference );
            handleAddingService ( reference, service );
        }

        @Override
        public ComponentFactory addingService ( final ServiceReference<ComponentFactory> reference )
        {
            final ComponentFactory service = OsgiFactory.this.context.getService ( reference );
            if ( handleAddingService ( reference, service ) == null )
            {
                OsgiFactory.this.context.ungetService ( reference );
                return null;
            }
            return service;
        }
    };

    private final BundleContext context;

    private final ComponentHost componentHost;

    public OsgiFactory ( final BundleContext context, final ComponentHost componentHost )
    {
        this.componentHost = componentHost;
        this.context = context;
        this.executor = Executors.newSingleThreadExecutor ( new NamedThreadFactory ( "org.eclipse.scada.da.server.component.osgi" ) );
        this.tracker = new ServiceTracker<ComponentFactory, ComponentFactory> ( context, ComponentFactory.class, this.customizer );
        this.tracker.open ();
    }

    public void dispose ()
    {
        this.tracker.close ();
        this.executor.shutdown ();
    }

    private final Map<ServiceReference<ComponentFactory>, ComponentHandle> refMap = new ConcurrentHashMap<> ();

    protected ComponentFactory handleAddingService ( final ServiceReference<ComponentFactory> reference, final ComponentFactory service )
    {
        try
        {
            final ComponentHandle handle = this.componentHost.registerComponent ( service );
            this.refMap.put ( reference, handle );
            return service;
        }
        catch ( final Exception e )
        {
            return null;
        }

    }

    protected void handleRemovedService ( final ServiceReference<ComponentFactory> ref )
    {
        final ComponentHandle handle = this.refMap.remove ( ref );
        if ( handle != null )
        {
            handle.unregister ();
        }
    }

}
