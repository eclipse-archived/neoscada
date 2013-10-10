/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.datasource.base;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.datasource.DataSourceListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Basic implementation of a data source.
 * 
 * @author Jens Reimann
 * @since 0.15.0
 */
public abstract class AbstractDataSource implements DataSource
{
    public final static Logger logger = LoggerFactory.getLogger ( AbstractDataSource.class );

    private DataItemValue value = DataItemValue.DISCONNECTED;

    private final Set<DataSourceListener> listeners = new HashSet<DataSourceListener> ( 1 );

    private Variant lastValue = Variant.NULL;

    private Calendar lastTimestamp = null;

    private final Lock lock;

    public AbstractDataSource ()
    {
        this.lock = new ReentrantLock ();
    }

    /**
     * Return the executor to use for sending out events
     * 
     * @return the executor to use, must never be <code>null</code>
     */
    protected abstract Executor getExecutor ();

    @Override
    public void addListener ( final DataSourceListener listener )
    {
        try
        {
            this.lock.lock ();

            if ( this.listeners.add ( listener ) )
            {
                final DataItemValue value = this.value;
                getExecutor ().execute ( new Runnable () {

                    @Override
                    public void run ()
                    {
                        listener.stateChanged ( value );
                    }
                } );
            }
        }
        finally
        {
            this.lock.unlock ();
        }
    }

    @Override
    public void removeListener ( final DataSourceListener listener )
    {
        try
        {
            this.lock.lock ();
            this.listeners.remove ( listener );
        }
        finally
        {
            this.lock.unlock ();
        }
    }

    protected void updateData ( DataItemValue value )
    {
        logger.debug ( "Update data: {} -> {}", new Object[] { value, value == null ? "" : value.getAttributes () } );

        try
        {
            this.lock.lock ();

            if ( this.value != null )
            {
                if ( this.value.equals ( value ) )
                {
                    logger.debug ( "No data change. Discarding" );
                    return;
                }
            }

            value = applyAutoTimestamp ( value );

            this.lastValue = value == null ? null : value.getValue ();
            this.value = value;

            final DataItemValue finalValue = value;

            // fire listeners
            for ( final DataSourceListener listener : this.listeners )
            {
                getExecutor ().execute ( new Runnable () {

                    @Override
                    public void run ()
                    {
                        listener.stateChanged ( finalValue );
                    }
                } );
            }
        }
        finally
        {
            this.lock.unlock ();
        }
    }

    private DataItemValue applyAutoTimestamp ( DataItemValue value )
    {
        if ( value != null && value.getTimestamp () == null )
        {
            try
            {
                if ( !this.lastValue.equals ( value.getValue () ) )
                {
                    this.lastTimestamp = Calendar.getInstance ();
                }
            }
            catch ( final Exception e )
            {
                // nothing
                logger.info ( "Failed to update timestamp", e );
            }

            final DataItemValue.Builder builder = new DataItemValue.Builder ( value );
            builder.setTimestamp ( this.lastTimestamp );
            value = builder.build ();
        }
        return value;
    }

}