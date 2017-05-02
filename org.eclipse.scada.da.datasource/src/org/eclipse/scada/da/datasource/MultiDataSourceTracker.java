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

import java.util.Collection;
import java.util.Dictionary;
import java.util.LinkedList;
import java.util.Set;

import org.eclipse.scada.utils.osgi.pool.ObjectPoolListener;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolServiceTracker;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.InvalidSyntaxException;

public class MultiDataSourceTracker
{
    private final Collection<ObjectPoolServiceTracker<DataSource>> trackers;

    private final ServiceListener listener;

    public interface ServiceListener
    {
        public void dataSourceAdded ( String id, Dictionary<?, ?> properties, DataSource dataSource );

        public void dataSourceRemoved ( String id, Dictionary<?, ?> properties, DataSource dataSource );

        public void dataSourceModified ( String id, Dictionary<?, ?> properties, DataSource dataSource );
    }

    public MultiDataSourceTracker ( final ObjectPoolTracker<DataSource> poolTracker, final Set<String> dataSourceIds, final ServiceListener listener ) throws InvalidSyntaxException
    {
        this.trackers = new LinkedList<ObjectPoolServiceTracker<DataSource>> ();

        this.listener = listener;

        for ( final String id : dataSourceIds )
        {
            final ObjectPoolServiceTracker<DataSource> tracker = new ObjectPoolServiceTracker<DataSource> ( poolTracker, id, new ObjectPoolListener<DataSource> () {

                @Override
                public void serviceRemoved ( final DataSource service, final Dictionary<?, ?> properties )
                {
                    handleRemoved ( id, properties, service );
                }

                @Override
                public void serviceModified ( final DataSource service, final Dictionary<?, ?> properties )
                {
                    handleModified ( id, properties, service );
                }

                @Override
                public void serviceAdded ( final DataSource service, final Dictionary<?, ?> properties )
                {
                    handleAdded ( id, properties, service );
                }
            } );
            this.trackers.add ( tracker );
        }
    }

    protected void handleAdded ( final String id, final Dictionary<?, ?> properties, final DataSource service )
    {
        this.listener.dataSourceAdded ( id, properties, service );
    }

    protected void handleModified ( final String id, final Dictionary<?, ?> properties, final DataSource service )
    {
        this.listener.dataSourceModified ( id, properties, service );
    }

    protected void handleRemoved ( final String id, final Dictionary<?, ?> properties, final DataSource service )
    {
        this.listener.dataSourceRemoved ( id, properties, service );
    }

    public synchronized void open ()
    {
        for ( final ObjectPoolServiceTracker<DataSource> tracker : this.trackers )
        {
            tracker.open ();
        }
    }

    public synchronized void close ()
    {
        for ( final ObjectPoolServiceTracker<DataSource> tracker : this.trackers )
        {
            tracker.close ();
        }
    }
}
