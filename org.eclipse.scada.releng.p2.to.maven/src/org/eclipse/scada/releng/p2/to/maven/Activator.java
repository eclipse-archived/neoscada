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
package org.eclipse.scada.releng.p2.to.maven;

import java.net.URI;

import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.IProvisioningAgentProvider;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator
{
    private ServiceTracker<IProvisioningAgentProvider, IProvisioningAgentProvider> tracker;

    private BundleContext context;

    private static Activator INSTANCE;

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.context = context;
        this.tracker = new ServiceTracker<IProvisioningAgentProvider, IProvisioningAgentProvider> ( context, IProvisioningAgentProvider.class, null );
        this.tracker.open ();
        Activator.INSTANCE = this;
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.context = null;
        Activator.INSTANCE = null;
        this.tracker.close ();
    }

    public static Activator getDefault ()
    {
        return INSTANCE;
    }

    public static IProvisioningAgent getAgent ( final URI location ) throws ProvisionException
    {
        final IProvisioningAgentProvider provider = INSTANCE.tracker.getService ();
        if ( provider == null )
        {
            throw new IllegalStateException ( "Provisioning agent provider not found. Is P2 started?" );
        }

        return provider.createAgent ( location );
    }

    public BundleContext getContext ()
    {
        return this.context;
    }

}
