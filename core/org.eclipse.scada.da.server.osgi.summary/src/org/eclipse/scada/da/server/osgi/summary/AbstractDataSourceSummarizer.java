/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.osgi.summary;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.datasource.DataSourceListener;
import org.eclipse.scada.da.datasource.base.AbstractInputDataSource;
import org.eclipse.scada.utils.osgi.pool.AllObjectPoolServiceTracker;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolListener;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractDataSourceSummarizer extends AbstractInputDataSource
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractDataSourceSummarizer.class );

    private final AllObjectPoolServiceTracker<DataSource> tracker;

    private final Map<DataSource, DataSourceListenerImpl> listeners = new HashMap<DataSource, DataSourceListenerImpl> ();

    private final Executor executor;

    public AbstractDataSourceSummarizer ( final Executor executor, final ObjectPoolTracker<DataSource> tracker )
    {
        this.executor = executor;
        this.tracker = new AllObjectPoolServiceTracker<DataSource> ( tracker, new ObjectPoolListener<DataSource> () {

            @Override
            public void serviceAdded ( final DataSource service, final Dictionary<?, ?> properties )
            {
                if ( ! ( service instanceof DataSource ) )
                {
                    return;
                }

                // we don't attach to ourself
                if ( service == AbstractDataSourceSummarizer.this )
                {
                    return;
                }

                if ( !isMatch ( service, properties ) )
                {
                    return;
                }

                AbstractDataSourceSummarizer.this.handleAdded ( service, properties );
            }

            @Override
            public void serviceModified ( final DataSource service, final Dictionary<?, ?> properties )
            {
            }

            @Override
            public void serviceRemoved ( final DataSource service, final Dictionary<?, ?> properties )
            {
                if ( ! ( service instanceof DataSource ) )
                {
                    return;
                }

                // we don't attach to ourself
                if ( service == AbstractDataSourceSummarizer.this )
                {
                    return;
                }

                AbstractDataSourceSummarizer.this.handleRemoved ( service, properties );
            }
        } );
    }

    protected boolean isMatch ( final DataSource service, final Dictionary<?, ?> properties )
    {
        return true;
    }

    @Override
    protected Executor getExecutor ()
    {
        return this.executor;
    }

    public void open ()
    {
        this.tracker.open ();
    }

    public void close ()
    {
        this.tracker.close ();
    }

    private class DataSourceListenerImpl implements DataSourceListener
    {
        private final DataSource source;

        private boolean disposed;

        public DataSourceListenerImpl ( final DataSource source )
        {
            this.source = source;
        }

        @Override
        public synchronized void stateChanged ( final DataItemValue value )
        {
            logger.debug ( "State change: {}", value );

            if ( !this.disposed )
            {
                handleStateChange ( this.source, value );
            }
        }

        public synchronized void dispose ()
        {
            if ( !this.disposed )
            {
                this.disposed = true;
                AbstractDataSourceSummarizer.this.handleRemoved ( this.source );
            }
        }

    }

    protected synchronized void handleAdded ( final DataSource service, final Dictionary<?, ?> properties )
    {
        logger.debug ( "Adding datasource {}", service );

        if ( this.listeners.containsKey ( service ) )
        {
            return;
        }

        final DataSourceListenerImpl listener = new DataSourceListenerImpl ( service );

        handleAdding ( service );

        this.listeners.put ( service, listener );
        service.addListener ( listener );
    }

    protected void handleRemoved ( final DataSource service, final Dictionary<?, ?> properties )
    {
        final DataSourceListenerImpl listener;
        synchronized ( this )
        {
            listener = this.listeners.remove ( service );
            if ( listener != null )
            {
                service.removeListener ( listener );
            }
        }
        if ( listener != null )
        {
            listener.dispose ();
        }
    }

    /**
     * Called right before the new data source is added but before it is registered
     * 
     * @param source
     *            the source that changed
     */
    protected abstract void handleAdding ( final DataSource source );

    /**
     * Called after the data source has been removed
     * 
     * @param source
     *            the source that changed
     */
    protected abstract void handleRemoved ( final DataSource source );

    protected abstract void handleStateChange ( final DataSource source, final DataItemValue value );
}
