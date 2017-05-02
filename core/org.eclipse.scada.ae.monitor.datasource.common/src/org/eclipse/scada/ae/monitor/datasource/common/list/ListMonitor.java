/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.monitor.datasource.common.list;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.monitor.common.MessageDecorator;
import org.eclipse.scada.ae.monitor.datasource.AbstractVariantMonitor;
import org.eclipse.scada.ae.monitor.datasource.Helper;
import org.eclipse.scada.ae.monitor.datasource.common.ListSeverity;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantEditor;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;

import com.google.common.collect.Interner;

public class ListMonitor extends AbstractVariantMonitor
{

    private Configuration configuration;

    public ListMonitor ( final BundleContext context, final Executor executor, final Interner<String> stringInterner, final ObjectPoolTracker<MasterItem> poolTracker, final EventProcessor eventProcessor, final String id, final String prefix, final String defaultMonitorType )
    {
        super ( context, executor, stringInterner, poolTracker, eventProcessor, id, ListMonitorFactory.FACTORY_ID, prefix, defaultMonitorType );
    }

    @Override
    protected int getDefaultHandlerPriority ()
    {
        return 600;
    }

    @Override
    public synchronized void update ( final UserInformation userInformation, final Map<String, String> properties ) throws Exception
    {
        super.update ( userInformation, properties );

        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        final Configuration c = new Configuration ( this.configuration, this );

        // parse configuration
        c.setDefaultAck ( cfg.getBoolean ( "defaultAck", false ) );
        c.setDefaultSeverity ( cfg.getEnum ( "defaultSeverity", ListSeverity.class, ListSeverity.OK ) );
        c.setMessageAttribute ( cfg.getString ( "messageAttribute" ) );

        // read in severities
        final Map<Variant, ListSeverity> severityMap = new HashMap<Variant, ListSeverity> ();
        for ( final ListSeverity severity : ListSeverity.values () )
        {
            for ( final String str : cfg.getPrefixed ( "values." + severity.name () + "." ).values () )
            {
                severityMap.put ( VariantEditor.toVariant ( str ), severity );
            }
        }
        c.setSeverityMap ( severityMap );

        // read on ack flags
        final Map<Variant, Boolean> ackMap = new HashMap<Variant, Boolean> ();
        for ( final String str : cfg.getPrefixed ( "values.ack." ).values () )
        {
            ackMap.put ( VariantEditor.toVariant ( str ), true );
        }
        for ( final String str : cfg.getPrefixed ( "values.nak." ).values () )
        {
            ackMap.put ( VariantEditor.toVariant ( str ), false );
        }
        c.setAckMap ( ackMap );

        // apply
        c.sendEvents ();
        this.configuration = c;

        reprocess ();
    }

    @Override
    protected void performValueUpdate ( final Map<String, Object> context, final Builder builder, final Variant value )
    {
        if ( this.configuration == null )
        {
            setOk ( value, Helper.getTimestamp ( builder ) );
            return;
        }

        Boolean requireAck = this.configuration.ackMap.get ( value );
        ListSeverity severity = this.configuration.severityMap.get ( value );

        if ( requireAck == null )
        {
            requireAck = this.configuration.defaultAck;
        }
        if ( severity == null )
        {
            severity = this.configuration.defaultSeverity;
        }

        if ( severity.getSeverity () == null )
        {
            setOk ( value, Helper.getTimestamp ( builder ) );
        }
        else
        {
            setFailure ( value, Helper.getTimestamp ( builder ), severity.getSeverity (), requireAck, extractMessage ( builder ) );
        }
    }

    private MessageDecorator extractMessage ( final Builder builder )
    {
        if ( this.configuration.messageAttribute == null )
        {
            return null;
        }

        return new MessageDecorator ( builder.getAttributes ().get ( this.configuration.messageAttribute ) );
    }
}
