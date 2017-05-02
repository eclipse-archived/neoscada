/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.datasource;

import org.eclipse.scada.core.VariantType;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.datasource.SingleDataSourceTracker.ServiceListener;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.InvalidSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSourceHandlerImpl implements DataSourceListener, DataSourceHandler
{

    private final static Logger logger = LoggerFactory.getLogger ( DataSourceHandlerImpl.class );

    private final DataSourceHandlerListener listener;

    private final SingleDataSourceTracker tracker;

    private DataSource service;

    private DataItemValue value;

    private final VariantType type;

    public DataSourceHandlerImpl ( final ObjectPoolTracker<DataSource> poolTracker, final String datasourceId, final DataSourceHandlerListener listener, final VariantType type ) throws InvalidSyntaxException
    {
        this.listener = listener;
        this.type = type;

        this.tracker = new SingleDataSourceTracker ( poolTracker, datasourceId, new ServiceListener () {

            @Override
            public void dataSourceChanged ( final DataSource dataSource )
            {
                DataSourceHandlerImpl.this.setDataSource ( dataSource );
            }
        } );
        this.tracker.open ();
    }

    protected void setDataSource ( final DataSource service )
    {
        // disconnect
        disconnectService ();

        // connect
        if ( service != null )
        {
            this.service = service;
            this.service.addListener ( this );
        }
    }

    private void disconnectService ()
    {
        if ( this.service != null )
        {
            this.service.removeListener ( this );
            this.service = null;
            this.value = null;
            fireValueChange ();
        }
    }

    private void fireValueChange ()
    {
        try
        {
            this.listener.handleChange ();
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to handle state change", e );
        }
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.da.datasource.DataSourceHandler#dispose()
     */
    @Override
    public void dispose ()
    {
        if ( this.tracker != null )
        {
            this.tracker.close ();
        }
        disconnectService ();
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.da.datasource.DataSourceHandler#getValue()
     */
    @Override
    public DataItemValue getValue ()
    {
        return this.value;
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.da.datasource.DataSourceHandler#getType()
     */
    @Override
    public VariantType getType ()
    {
        return this.type;
    }

    @Override
    public void stateChanged ( final DataItemValue value )
    {
        this.value = value;
        fireValueChange ();
    }
}
