/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.datasource;

import java.util.Dictionary;

import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.eclipse.scada.utils.osgi.pool.SingleObjectPoolServiceTracker;
import org.osgi.framework.InvalidSyntaxException;

public class SingleDataSourceTracker
{
    public interface ServiceListener
    {
        public void dataSourceChanged ( DataSource dataSource );
    }

    private final SingleObjectPoolServiceTracker<DataSource> tracker;

    private final ServiceListener listener;

    /**
     * Create a new single datasource tracker
     * 
     * @param poolTracker
     *            the pool tracker to use
     * @param dataSourceId
     *            the id of the datasource to track
     * @param listener
     *            the listener that gets notified (must not be <code>null</code>)
     * @throws InvalidSyntaxException
     */
    public SingleDataSourceTracker ( final ObjectPoolTracker<DataSource> poolTracker, final String dataSourceId, final ServiceListener listener ) throws InvalidSyntaxException
    {
        this.listener = listener;
        if ( listener == null )
        {
            throw new NullPointerException ( "'listener' must not be null" );
        }

        this.tracker = new SingleObjectPoolServiceTracker<DataSource> ( poolTracker, dataSourceId, new SingleObjectPoolServiceTracker.ServiceListener<DataSource> () {
            @Override
            public void serviceChange ( final DataSource service, final Dictionary<?, ?> properties )
            {
                SingleDataSourceTracker.this.setDataSource ( service );
            }
        } );
    }

    protected void setDataSource ( final DataSource service )
    {
        this.listener.dataSourceChanged ( service );
    }

    public void open ()
    {
        this.tracker.open ();
    }

    public void close ()
    {
        this.tracker.close ();
    }
}
