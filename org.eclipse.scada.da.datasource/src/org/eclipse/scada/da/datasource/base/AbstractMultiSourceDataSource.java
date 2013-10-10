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
package org.eclipse.scada.da.datasource.base;

import java.util.Map;

import org.eclipse.scada.core.VariantType;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.datasource.DataSourceHandler;
import org.eclipse.scada.da.datasource.MultiDataSourceListener;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.InvalidSyntaxException;

public abstract class AbstractMultiSourceDataSource extends AbstractDataSource
{

    private final MultiDataSourceListener listener;

    public AbstractMultiSourceDataSource ( final ObjectPoolTracker<DataSource> poolTracker )
    {
        super ();
        this.listener = new MultiDataSourceListener ( poolTracker ) {

            @Override
            protected void handleChange ( final Map<String, DataSourceHandler> sources )
            {
                AbstractMultiSourceDataSource.this.handleChange ( sources );
            }
        };
    }

    protected void setDataSources ( final Map<String, String> parameters ) throws InvalidSyntaxException
    {
        this.listener.setDataSources ( parameters );
    }

    protected abstract void handleChange ( Map<String, DataSourceHandler> sources );

    /**
     * Clear all datasources
     */
    protected void clearSources ()
    {
        this.listener.clearSources ();
    }

    public void dispose ()
    {
        this.listener.dispose ();
    }

    public void addDataSource ( final String datasourceKey, final String datasourceId, final VariantType type ) throws InvalidSyntaxException
    {
        this.listener.addDataSource ( datasourceKey, datasourceId, type );
    }

    public Map<String, DataSourceHandler> getSourcesCopy ()
    {
        return this.listener.getSourcesCopy ();
    }

    public VariantType getType ( final String type )
    {
        return this.listener.getType ( type );
    }
}