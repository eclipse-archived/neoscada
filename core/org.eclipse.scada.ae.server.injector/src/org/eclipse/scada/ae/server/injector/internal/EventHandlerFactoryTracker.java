package org.eclipse.scada.ae.server.injector.internal;

import org.eclipse.scada.ae.server.handler.EventHandlerFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class EventHandlerFactoryTracker
{
    public interface Listener
    {
        public void factoryAdded ( String factoryId, EventHandlerFactory factory );

        public void factoryRemoved ( String factoryId );
    }

    private final Listener listener;

    private final ServiceTrackerCustomizer<EventHandlerFactory, EventHandlerFactory> customizer = new ServiceTrackerCustomizer<EventHandlerFactory, EventHandlerFactory> () {

        @Override
        public void removedService ( final ServiceReference<EventHandlerFactory> reference, final EventHandlerFactory service )
        {
            handleRemoved ( reference, service );
        }

        @Override
        public void modifiedService ( final ServiceReference<EventHandlerFactory> reference, final EventHandlerFactory service )
        {
        }

        @Override
        public EventHandlerFactory addingService ( final ServiceReference<EventHandlerFactory> reference )
        {
            return handleAdding ( reference );
        }
    };

    private final ServiceTracker<EventHandlerFactory, EventHandlerFactory> tracker;

    private final BundleContext context;

    public EventHandlerFactoryTracker ( final BundleContext context, final Listener listener )
    {
        this.context = context;
        this.listener = listener;
        this.tracker = new ServiceTracker<EventHandlerFactory, EventHandlerFactory> ( context, EventHandlerFactory.class, this.customizer );
        this.tracker.open ();
    }

    public void dispose ()
    {
        this.tracker.close ();
    }

    protected EventHandlerFactory handleAdding ( final ServiceReference<EventHandlerFactory> reference )
    {
        final String factoryId = getFactoryId ( reference );
        if ( factoryId == null )
        {
            return null;
        }

        final EventHandlerFactory factory = this.context.getService ( reference );

        if ( this.listener != null )
        {
            this.listener.factoryAdded ( factoryId, factory );
        }

        return factory;
    }

    protected void handleRemoved ( final ServiceReference<EventHandlerFactory> reference, final EventHandlerFactory service )
    {
        final String factoryId = getFactoryId ( reference );
        if ( factoryId == null )
        {
            return;
        }

        if ( this.listener != null )
        {
            this.listener.factoryRemoved ( factoryId );
        }
    }

    private static String getFactoryId ( final ServiceReference<EventHandlerFactory> reference )
    {
        final Object o = reference.getProperty ( EventHandlerFactory.FACTORY_ID );
        if ( o instanceof String )
        {
            return (String)o;
        }
        return null;
    }
}
