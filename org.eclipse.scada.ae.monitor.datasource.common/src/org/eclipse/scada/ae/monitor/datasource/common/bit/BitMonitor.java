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
package org.eclipse.scada.ae.monitor.datasource.common.bit;

import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.monitor.datasource.AbstractBooleanMonitor;
import org.eclipse.scada.ae.monitor.datasource.Helper;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.da.core.WriteAttributeResult;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;

import com.google.common.collect.Interner;

public class BitMonitor extends AbstractBooleanMonitor
{

    private Configuration configuration;

    public BitMonitor ( final BundleContext context, final Executor executor, final Interner<String> stringInterner, final ObjectPoolTracker<MasterItem> poolTracker, final EventProcessor eventProcessor, final String id, final String prefix, final String defaultMonitorType )
    {
        super ( context, executor, stringInterner, poolTracker, eventProcessor, id, BitMonitorFactory.FACTORY_ID, prefix, defaultMonitorType );
    }

    @Override
    protected int getDefaultHandlerPriority ()
    {
        return 600;
    }

    @Override
    protected void performBooleanUpdate ( final Builder builder, final boolean value )
    {
        if ( this.configuration == null || this.configuration.reference == null )
        {
            setOk ( builder.getValue (), Helper.getTimestamp ( builder ) );
            return;
        }

        final boolean failure = value != this.configuration.reference;
        if ( failure )
        {
            setFailure ( builder.getValue (), Helper.getTimestamp ( builder ), this.configuration.severity, this.configuration.requireAck );
        }
        else
        {
            setOk ( builder.getValue (), Helper.getTimestamp ( builder ) );
        }
    }

    @Override
    public synchronized void update ( final UserInformation userInformation, final Map<String, String> properties ) throws Exception
    {
        super.update ( userInformation, properties );

        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        final Configuration c = new Configuration ( this.configuration, this );

        c.setReference ( userInformation, cfg.getBoolean ( "reference" ) );
        c.setSeverity ( userInformation, cfg.getEnum ( "severity", Severity.class, Severity.ALARM ) );
        c.setRequireAck ( userInformation, cfg.getBoolean ( "requireAck", false ) );

        c.sendEvents ();
        this.configuration = c;

        reprocess ();
    }

    @Override
    protected void injectAttributes ( final Builder builder )
    {
        super.injectAttributes ( builder );

        if ( this.configuration != null )
        {
            builder.setAttribute ( intern ( getPrefix () + ".reference" ), Variant.valueOf ( this.configuration.reference ) );
        }
    }

    @Override
    protected void handleConfigUpdate ( final Map<String, String> configUpdate, final Map<String, Variant> attributes, final WriteAttributeResults result )
    {
        super.handleConfigUpdate ( configUpdate, attributes, result );

        final Variant active = attributes.get ( getPrefix () + ".reference" ); //$NON-NLS-1$
        if ( active != null )
        {
            configUpdate.put ( "reference", "" + active.asBoolean () ); //$NON-NLS-1$ //$NON-NLS-2$
            result.put ( intern ( getPrefix () + ".reference" ), WriteAttributeResult.OK ); //$NON-NLS-1$
        }
    }
}
