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
package org.eclipse.scada.ae.monitor.datasource;

import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;

import com.google.common.collect.Interner;

public abstract class AbstractNumericMonitor extends AbstractVariantMonitor
{

    public AbstractNumericMonitor ( final BundleContext context, final Executor executor, final Interner<String> stringInterner, final ObjectPoolTracker<MasterItem> poolTracker, final EventProcessor eventProcessor, final String id, final String factoryId, final String prefix, final String defaultMonitorType )
    {
        super ( context, executor, stringInterner, poolTracker, eventProcessor, id, factoryId, prefix, defaultMonitorType );
    }

    protected abstract void performNumericUpdate ( final Builder builder, final Number value );

    @Override
    protected void performValueUpdate ( final Map<String, Object> context, final Builder builder, final Variant value )
    {
        if ( value.isDouble () )
        {
            performNumericUpdate ( builder, value.asDouble ( null ) );
        }
        else if ( value.isInteger () )
        {
            performNumericUpdate ( builder, value.asInteger ( null ) );
        }
        else if ( value.isLong () )
        {
            performNumericUpdate ( builder, value.asInteger ( null ) );
        }
        else if ( value.isBoolean () )
        {
            performNumericUpdate ( builder, value.asBoolean ( null ) ? 1 : 0 );
        }
        else
        {
            final String str = value.asString ( "" );
            try
            {
                final double d = Double.parseDouble ( str );
                performNumericUpdate ( builder, d );
            }
            catch ( final NumberFormatException e )
            {
                setUnsafe ();
            }
        }
    }

}