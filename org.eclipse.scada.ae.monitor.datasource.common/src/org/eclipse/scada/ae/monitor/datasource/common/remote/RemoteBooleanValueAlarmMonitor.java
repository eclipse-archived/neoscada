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
package org.eclipse.scada.ae.monitor.datasource.common.remote;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.ae.data.MonitorStatus;
import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.monitor.common.DataItemMonitor;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantEditor;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoteBooleanValueAlarmMonitor extends GenericRemoteMonitor implements DataItemMonitor
{

    final static Logger logger = LoggerFactory.getLogger ( RemoteBooleanValueAlarmMonitor.class );

    public static final String FACTORY_ID = "ae.monitor.da.remote.booleanValueAlarm";

    private String attributeAck;

    private String attributeActive;

    private String attributeAckTimestamp;

    private Variant aknValue = Variant.TRUE;

    public RemoteBooleanValueAlarmMonitor ( final BundleContext context, final Executor executor, final ObjectPoolTracker<MasterItem> poolTracker, final EventProcessor eventProcessor, final String id, final int priority )
    {
        super ( context, executor, poolTracker, priority, id, eventProcessor );
    }

    @Override
    protected void handleUpdate ( final DataItemValue.Builder builder )
    {
        logger.debug ( "Perform update" );

        final Variant value = builder.getValue ();
        final Variant ack = builder.getAttributes ().get ( this.attributeAck );
        final Variant active = builder.getAttributes ().get ( this.attributeActive );

        Calendar timestamp = builder.getTimestamp ();
        if ( timestamp == null )
        {
            timestamp = Calendar.getInstance ();
        }

        final Calendar aknTimestamp = getTimestamp ( builder, this.attributeAckTimestamp );

        if ( value == null )
        {
            setState ( MonitorStatus.UNSAFE );
            injectState ( builder );
            return;
        }

        final boolean alarmFlag = value.asBoolean ();

        final boolean activeFlag;
        if ( active == null )
        {
            activeFlag = true;
        }
        else
        {
            activeFlag = active.asBoolean ();
        }

        final MonitorStatus state;

        if ( !activeFlag )
        {
            state = MonitorStatus.INACTIVE;
        }
        else if ( ack == null )
        {
            state = alarmFlag ? MonitorStatus.NOT_OK : MonitorStatus.OK;
        }
        else
        {
            final boolean ackRequiredFlag = ack.asBoolean ();
            if ( alarmFlag )
            {
                if ( ackRequiredFlag )
                {
                    state = MonitorStatus.NOT_OK_NOT_AKN;
                }
                else
                {
                    state = MonitorStatus.NOT_OK_AKN;
                }
            }
            else
            {
                if ( ackRequiredFlag )
                {
                    state = MonitorStatus.NOT_AKN;
                }
                else
                {
                    state = MonitorStatus.OK;
                }
            }
        }

        setState ( state, timestamp.getTime (), aknTimestamp.getTime () );

        injectState ( builder );
    }

    @Override
    public void akn ( final UserInformation userInformation, final Date aknTimestamp )
    {
        publishAckRequestEvent ( userInformation, aknTimestamp );

        final Map<String, Variant> attributes = new HashMap<String, Variant> ();

        attributes.put ( this.attributeAck, this.aknValue );

        for ( final MasterItem item : getMasterItems () )
        {
            item.startWriteAttributes ( attributes, new OperationParameters ( userInformation, null, null ) );
        }
    }

    public void setActive ( final UserInformation userInformation, final boolean state )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ();
        attributes.put ( this.attributeActive, state ? Variant.TRUE : Variant.FALSE );

        for ( final MasterItem item : getMasterItems () )
        {
            item.startWriteAttributes ( attributes, new OperationParameters ( userInformation, null, null ) );
        }
    }

    @Override
    public synchronized void update ( final UserInformation userInformation, final Map<String, String> parameters ) throws Exception
    {
        logger.debug ( "Apply update: {}", parameters );

        super.update ( userInformation, parameters );

        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        this.attributeAck = cfg.getString ( "attribute.ack.name" );
        this.attributeActive = cfg.getString ( "attribute.active.name" );
        this.attributeAckTimestamp = cfg.getStringNonEmpty ( "attribute.ack.timestamp.name" );

        final VariantEditor ve = new VariantEditor ();
        ve.setAsText ( cfg.getString ( "attribute.ack.value", "BOOL#true" ) );
        this.aknValue = (Variant)ve.getValue ();

        reprocess ();

        logger.debug ( "Done applying" );
    }

}
