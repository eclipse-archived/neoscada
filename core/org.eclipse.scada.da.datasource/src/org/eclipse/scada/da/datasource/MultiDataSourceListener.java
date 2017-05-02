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

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.VariantType;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.InvalidSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class MultiDataSourceListener
{

    private final static Logger logger = LoggerFactory.getLogger ( MultiDataSourceListener.class );

    private final ObjectPoolTracker<DataSource> poolTracker;

    private final DataSourceHandlerListener listener;

    private final Map<String, DataSourceHandlerImpl> sources = new HashMap<String, DataSourceHandlerImpl> ();

    private boolean disposed;

    public MultiDataSourceListener ( final ObjectPoolTracker<DataSource> poolTracker )
    {
        synchronized ( this )
        {
            this.poolTracker = poolTracker;
            this.listener = new DataSourceHandlerListener () {

                @Override
                public void handleChange ()
                {
                    MultiDataSourceListener.this.triggerHandleChange ();
                }
            };
        }
    }

    public synchronized Map<String, DataSourceHandler> getSourcesCopy ()
    {
        return new HashMap<String, DataSourceHandler> ( this.sources );
    }

    /**
     * Set datasources to include all datasources in the properties set with the prefix "datasource."
     * <p>
     * This will clear the already existing datasources.
     * </p>
     * 
     * @param parameters
     *            the list of properties
     * @throws InvalidSyntaxException
     */
    public synchronized void setDataSources ( final Map<String, String> parameters ) throws InvalidSyntaxException
    {
        clearSources ();

        for ( final Map.Entry<String, String> entry : parameters.entrySet () )
        {
            final String key = entry.getKey ();
            final String value = entry.getValue ();
            if ( key.startsWith ( "datasource." ) )
            {
                final String name = key.substring ( "datasource.".length () );
                final VariantType type = getType ( parameters.get ( "datasourceType." + name ) );
                addDataSource ( name, value, type );
            }
        }
    }

    public VariantType getType ( final String type )
    {
        if ( type == null || type.isEmpty () )
        {
            return null;
        }

        try
        {
            return VariantType.valueOf ( type );
        }
        catch ( final IllegalArgumentException e )
        {
            throw new IllegalArgumentException ( String.format ( "Datatype '%s' is unknown", type ), e );
        }
    }

    protected abstract void handleChange ( Map<String, DataSourceHandler> sources );

    public synchronized void addDataSource ( final String datasourceKey, final String datasourceId, final VariantType type ) throws InvalidSyntaxException
    {
        logger.info ( "Adding data source: {} -> {} ({})", new Object[] { datasourceKey, datasourceId, type } );

        final DataSourceHandlerImpl dsHandler = new DataSourceHandlerImpl ( this.poolTracker, datasourceId, this.listener, type );
        this.sources.put ( datasourceKey, dsHandler );
    }

    protected void triggerHandleChange ()
    {
        synchronized ( this )
        {
            if ( this.disposed )
            {
                return;
            }
        }
        handleChange ( Collections.<String, DataSourceHandler> unmodifiableMap ( this.sources ) );
    }

    /**
     * Clear all datasources
     */
    public synchronized void clearSources ()
    {
        for ( final DataSourceHandler source : this.sources.values () )
        {
            source.dispose ();
        }
        this.sources.clear ();
    }

    public void dispose ()
    {
        final Collection<DataSourceHandlerImpl> disposeSources;

        synchronized ( this )
        {
            disposeSources = this.sources.values ();
            this.disposed = true;
            this.sources.clear ();
        }

        for ( final DataSourceHandler handler : disposeSources )
        {
            handler.dispose ();
        }
    }
}
