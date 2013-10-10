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
package org.eclipse.scada.ae.monitor.datasource.common.level;

import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.monitor.common.level.LevelHelper;
import org.eclipse.scada.ae.monitor.datasource.AbstractNumericMonitor;
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

public class LevelMonitor extends AbstractNumericMonitor
{

    private final String firstPrefix;

    private Configuration configuration;

    public LevelMonitor ( final BundleContext context, final Executor executor, final Interner<String> stringInterner, final ObjectPoolTracker<MasterItem> poolTracker, final EventProcessor eventProcessor, final String id, final String prefix, final String defaultMonitorType )
    {
        super ( context, executor, stringInterner, poolTracker, eventProcessor, id, LevelMonitorFactory.FACTORY_ID, prefix, defaultMonitorType );
        this.firstPrefix = prefix;
    }

    @Override
    protected int getDefaultHandlerPriority ()
    {
        return 500;
    }

    @Override
    protected void performNumericUpdate ( final Builder builder, final Number value )
    {
        if ( this.configuration == null || this.configuration.preset == null )
        {
            setOk ( builder.getValue (), Helper.getTimestamp ( builder ) );
            return;
        }

        final Variant originalValue = builder.getValue ();

        final boolean failure = LevelHelper.isFailure ( value.doubleValue (), this.configuration.preset, this.configuration.lowerOk, this.configuration.includedOk );
        if ( failure )
        {
            if ( this.configuration.cap )
            {
                builder.setValue ( capValue ( this.configuration.preset, value ) );
            }
            setFailure ( originalValue, Helper.getTimestamp ( builder ), this.configuration.severity, this.configuration.requireAck );
        }
        else
        {
            setOk ( originalValue, Helper.getTimestamp ( builder ) );
        }
    }

    private Variant capValue ( final double preset, final Number value )
    {
        if ( this.configuration.lowerOk )
        {
            if ( value instanceof Long )
            {
                return Variant.valueOf ( Math.min ( (long)preset, value.longValue () ) );
            }
            if ( value instanceof Integer )
            {
                return Variant.valueOf ( Math.min ( (int)preset, value.intValue () ) );
            }
            return Variant.valueOf ( Math.min ( preset, value.doubleValue () ) );
        }
        else
        {
            if ( value instanceof Long )
            {
                return Variant.valueOf ( Math.max ( (long)preset, value.longValue () ) );
            }
            if ( value instanceof Integer )
            {
                return Variant.valueOf ( Math.max ( (int)preset, value.intValue () ) );
            }
            return Variant.valueOf ( Math.max ( preset, value.doubleValue () ) );
        }
    }

    @Override
    public synchronized void update ( final UserInformation userInformation, final Map<String, String> properties ) throws Exception
    {
        super.update ( userInformation, properties );

        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        final Configuration c = new Configuration ( this.configuration, this );

        c.setPreset ( userInformation, cfg.getDouble ( "preset" ) );
        c.setLowerOk ( userInformation, cfg.getBooleanChecked ( "lowerOk", "'lowerOk' is required" ) );
        c.setIncludedOk ( userInformation, cfg.getBoolean ( "includedOk", true ) );
        c.setSecondPrefix ( userInformation, cfg.getString ( "prefix", null ) );
        c.setCap ( userInformation, cfg.getBoolean ( "cap", false ) );
        c.setSeverity ( userInformation, cfg.getEnum ( "severity", Severity.class, Severity.ALARM ) );
        c.setRequireAck ( userInformation, cfg.getBoolean ( "requireAck", false ) );

        this.configuration = c;
        c.sendEvents ();

        if ( this.configuration.secondPrefix != null )
        {
            setPrefix ( this.firstPrefix + "." + this.configuration.secondPrefix );
        }
        else
        {
            setPrefix ( this.firstPrefix );
        }

        reprocess ();
    }

    @Override
    protected void injectAttributes ( final Builder builder )
    {
        super.injectAttributes ( builder );

        if ( this.configuration != null )
        {
            builder.setAttribute ( intern ( getPrefix () + ".preset" ), Variant.valueOf ( this.configuration.preset ) );
        }
    }

    @Override
    protected void handleConfigUpdate ( final Map<String, String> configUpdate, final Map<String, Variant> attributes, final WriteAttributeResults result )
    {
        super.handleConfigUpdate ( configUpdate, attributes, result );

        final Variant preset = attributes.get ( getPrefix () + ".preset" ); //$NON-NLS-1$
        if ( preset != null )
        {
            configUpdate.put ( "preset", "" + preset.asDouble ( 0.0 ) ); //$NON-NLS-1$ //$NON-NLS-2$
            result.put ( intern ( getPrefix () + ".preset" ), WriteAttributeResult.OK ); //$NON-NLS-1$
        }
    }
}
