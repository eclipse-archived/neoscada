package org.eclipse.scada.ae.server.injector.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator
{
    private EventInjectorManager manager;

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        if ( this.manager == null )
        {
            this.manager = new EventInjectorManager ();
            this.manager.start ();
        }
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        if ( this.manager != null )
        {
            this.manager.stop ();
            this.manager = null;
        }
    }

}
