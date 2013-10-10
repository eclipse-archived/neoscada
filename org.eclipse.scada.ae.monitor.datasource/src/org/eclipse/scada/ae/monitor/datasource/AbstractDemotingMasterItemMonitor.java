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

import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.monitor.common.DemoteImpl;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;

import com.google.common.collect.Interner;

public abstract class AbstractDemotingMasterItemMonitor extends AbstractMasterItemMonitor
{

    private final DemoteImpl demoteProcessor = new DemoteImpl ();

    public AbstractDemotingMasterItemMonitor ( final BundleContext context, final Executor executor, final Interner<String> stringInterner, final ObjectPoolTracker<MasterItem> poolTracker, final EventProcessor eventProcessor, final String id, final String factoryId, final String prefix, final String defaultMonitorType )
    {
        super ( context, executor, stringInterner, poolTracker, eventProcessor, id, factoryId, prefix, defaultMonitorType );
    }

    @Override
    protected void handleDataUpdate ( final Map<String, Object> context, final DataItemValue.Builder value )
    {
        this.demoteProcessor.handleDataUpdate ( context, value );

        super.handleDataUpdate ( context, value );
    }

    @Override
    public synchronized void update ( final UserInformation userInformation, final Map<String, String> properties ) throws Exception
    {
        super.update ( userInformation, properties );

        this.demoteProcessor.update ( userInformation, properties );
    }

    @Override
    protected void setFailure ( final Variant value, final Long valueTimestamp, final Severity severity, final boolean requireAck )
    {
        final Severity result = this.demoteProcessor.demoteSeverity ( severity );
        if ( result == null )
        {
            setOk ( value, valueTimestamp );
        }
        else
        {
            super.setFailure ( value, valueTimestamp, result, this.demoteProcessor.demoteAck ( requireAck ) );
        }
    }

}
