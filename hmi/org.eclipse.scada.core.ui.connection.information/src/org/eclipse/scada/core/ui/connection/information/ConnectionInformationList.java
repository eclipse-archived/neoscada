/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.information;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.scada.core.connection.provider.info.ConnectionInformationProvider;
import org.eclipse.scada.utils.osgi.FilterUtil;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionInformationList
{

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionInformationList.class );

    private final WritableSet list;

    private final Map<ServiceReference<?>, Object> objectMap = new HashMap<ServiceReference<?>, Object> ();

    private ServiceListener listener;

    private final BundleContext context;

    public ConnectionInformationList ()
    {
        this.context = Activator.getDefault ().getBundle ().getBundleContext ();
        synchronized ( this )
        {
            try
            {
                this.context.addServiceListener ( this.listener = new ServiceListener () {

                    @Override
                    public void serviceChanged ( final ServiceEvent event )
                    {
                        handleServiceChanged ( event );
                    }
                }, FilterUtil.createClassFilter ( ConnectionInformationProvider.class.getName () ).toString () );
            }
            catch ( final InvalidSyntaxException e )
            {
                logger.warn ( "Failed to create filter expression", e );
            }

            this.list = new WritableSet ( SWTObservables.getRealm ( Display.getDefault () ) );
            ServiceReference<?>[] refs;
            try
            {
                refs = this.context.getAllServiceReferences ( ConnectionInformationProvider.class.getName (), null );

                if ( refs != null )
                {
                    addInitialServices ( refs );
                }
            }
            catch ( final InvalidSyntaxException e )
            {
                logger.warn ( "Failed to search services", e );
            }
        }
    }

    protected synchronized void handleServiceChanged ( final ServiceEvent event )
    {
        switch ( event.getType () )
        {
            case ServiceEvent.UNREGISTERING:
            case ServiceEvent.MODIFIED_ENDMATCH:
                removeService ( event.getServiceReference () );
                break;
            case ServiceEvent.REGISTERED:
                addService ( event.getServiceReference () );
                break;
        }
    }

    private synchronized void removeService ( final ServiceReference<?> serviceReference )
    {
        final Object old = this.objectMap.remove ( serviceReference );
        if ( old != null )
        {
            this.context.ungetService ( serviceReference );
            this.list.getRealm ().asyncExec ( new Runnable () {

                @Override
                public void run ()
                {
                    ConnectionInformationList.this.list.remove ( old );
                }
            } );
        }
    }

    private synchronized void addInitialServices ( final ServiceReference<?>[] refs )
    {
        final Map<ServiceReference<?>, Object> connections = new HashMap<ServiceReference<?>, Object> ();

        for ( final ServiceReference<?> serviceReference : refs )
        {
            final Object o = this.context.getService ( serviceReference );
            if ( ! ( o instanceof ConnectionInformationProvider ) )
            {
                this.context.ungetService ( serviceReference );
                continue;
            }

            connections.put ( serviceReference, o );
        }

        this.objectMap.putAll ( connections );
        this.list.addAll ( connections.values () );
    }

    private synchronized void addService ( final ServiceReference<?> serviceReference )
    {
        final Object o = this.context.getService ( serviceReference );
        if ( ! ( o instanceof ConnectionInformationProvider ) )
        {
            this.context.ungetService ( serviceReference );
            return;
        }

        final Object old = this.objectMap.put ( serviceReference, o );

        this.list.getRealm ().asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                addService ( o, old );
            }
        } );
    }

    private void addService ( final Object o, final Object old )
    {
        if ( this.list.isDisposed () )
        {
            return;
        }

        try
        {
            this.list.setStale ( true );

            if ( old != null )
            {
                this.list.remove ( old );
            }
            this.list.add ( o );
        }
        finally
        {
            this.list.setStale ( false );
        }
    }

    public IObservableSet getList ()
    {
        return this.list;
    }

    public void dispose ()
    {
        this.context.removeServiceListener ( this.listener );
        for ( final ServiceReference<?> ref : this.objectMap.keySet () )
        {
            this.context.ungetService ( ref );
        }
        if ( !this.list.isDisposed () )
        {
            this.list.clear ();
            this.list.dispose ();
        }
    }

}
