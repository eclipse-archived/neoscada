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
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;

import com.google.common.collect.Interner;

public abstract class AbstractVariantMonitor extends AbstractDemotingMasterItemMonitor
{

    public AbstractVariantMonitor ( final BundleContext context, final Executor executor, final Interner<String> stringInterner, final ObjectPoolTracker<MasterItem> poolTracker, final EventProcessor eventProcessor, final String id, final String factoryId, final String prefix, final String defaultMonitorType )
    {
        super ( context, executor, stringInterner, poolTracker, eventProcessor, id, factoryId, prefix, defaultMonitorType );
    }

    @Override
    protected void performDataUpdate ( final Map<String, Object> context, final Builder builder )
    {
        if ( builder.getSubscriptionState () != SubscriptionState.CONNECTED )
        {
            setUnsafe ();
            return;
        }

        final Variant value = builder.getValue ();
        if ( value == null || value.isNull () )
        {
            setUnsafe ();
            return;
        }

        if ( builder.getAttributes () != null )
        {
            final Variant errorAttr = builder.getAttributes ().get ( "error" );
            if ( errorAttr != null && errorAttr.asBoolean () )
            {
                // error attribute set to "true"
                setUnsafe ();
                return;
            }
        }

        performValueUpdate ( context, builder, value );
    }

    protected abstract void performValueUpdate ( Map<String, Object> context, Builder builder, Variant value );

}
