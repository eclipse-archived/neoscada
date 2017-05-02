/*******************************************************************************
 * Copyright (c) 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.server.proxy;

import org.eclipse.scada.hd.server.common.HistoricalItem;
import org.eclipse.scada.utils.osgi.FilterUtil;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

public class ProxyValueSource
{
    private final SingleServiceTracker<HistoricalItem> tracker;

    private final SingleServiceListener<HistoricalItem> listener;

    private ServiceEntry service;

    private final ProxyHistoricalItem item;

    private final int priority;

    public static class ServiceEntry
    {
        private final HistoricalItem item;

        private final int priority;

        public ServiceEntry ( final HistoricalItem item, final int priority )
        {
            super ();
            this.item = item;
            this.priority = priority;
        }

        public HistoricalItem getItem ()
        {
            return this.item;
        }

        public int getPriority ()
        {
            return this.priority;
        }

        @Override
        public int hashCode ()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ( this.item == null ? 0 : this.item.hashCode () );
            return result;
        }

        @Override
        public boolean equals ( final Object obj )
        {
            if ( this == obj )
            {
                return true;
            }
            if ( obj == null )
            {
                return false;
            }
            if ( getClass () != obj.getClass () )
            {
                return false;
            }
            final ServiceEntry other = (ServiceEntry)obj;
            if ( this.item == null )
            {
                if ( other.item != null )
                {
                    return false;
                }
            }
            else if ( !this.item.equals ( other.item ) )
            {
                return false;
            }
            return true;
        }

    }

    public ProxyValueSource ( final BundleContext context, final String id, final ProxyHistoricalItem item, final int priority ) throws InvalidSyntaxException
    {

        this.item = item;
        this.priority = priority;

        this.listener = new SingleServiceListener<HistoricalItem> () {

            @Override
            public void serviceChange ( final ServiceReference<HistoricalItem> reference, final HistoricalItem service )
            {
                setService ( service );
            }
        };

        this.tracker = new SingleServiceTracker<HistoricalItem> ( context, FilterUtil.createClassAndPidFilter ( HistoricalItem.class.getName (), id ), this.listener );
        this.tracker.open ();
    }

    protected void setService ( final HistoricalItem service )
    {
        if ( this.service != null )
        {
            this.item.removeSource ( this.service );
        }

        this.service = new ServiceEntry ( service, this.priority );

        if ( this.service != null )
        {
            this.item.addSource ( this.service );
        }
    }

    public void dispose ()
    {
        this.tracker.close ();

        if ( this.service != null )
        {
            this.item.removeSource ( this.service );
        }
    }
}
