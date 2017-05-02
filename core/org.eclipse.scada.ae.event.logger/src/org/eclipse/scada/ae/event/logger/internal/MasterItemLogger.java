/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.event.logger.internal;

import java.util.Date;
import java.util.Map;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Event.EventBuilder;
import org.eclipse.scada.ae.Event.Fields;
import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.master.AbstractMasterHandlerImpl;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.da.master.WriteRequest;
import org.eclipse.scada.da.master.WriteRequestResult;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;

public class MasterItemLogger extends AbstractMasterHandlerImpl
{
    private final EventProcessor eventProcessor;

    private DataItemValue lastValue;

    private boolean logSubscription;

    private boolean logValue;

    private boolean logAttributes;

    private boolean logWrites;

    private String typeWriteValue;

    private String typeWriteAttributes;

    private String typeValue;

    private String typeAttributes;

    private String typeSubscription;

    public MasterItemLogger ( final BundleContext context, final ObjectPoolTracker<MasterItem> poolTracker, final int priority ) throws InvalidSyntaxException
    {
        super ( poolTracker, priority );
        synchronized ( this )
        {
            this.eventProcessor = new EventProcessor ( context );
            this.eventProcessor.open ();
        }
    }

    @Override
    public synchronized void dispose ()
    {
        this.eventProcessor.close ();
        super.dispose ();
    }

    @Override
    public void dataUpdate ( final Map<String, Object> context, final DataItemValue.Builder value )
    {
        if ( this.logValue || this.logSubscription || this.logAttributes )
        {
            publishDiff ( DataItemValueDiff.diff ( this.lastValue, value.build () ) );
        }

        this.lastValue = value.build ();
    }

    private void publishDiff ( final DataItemValue diff )
    {
        if ( this.logSubscription && diff.getSubscriptionState () != null )
        {
            final EventBuilder builder = createEvent ( null );

            builder.attribute ( Event.Fields.VALUE, diff.getSubscriptionState () );
            builder.attribute ( Event.Fields.EVENT_TYPE, this.typeSubscription );

            this.eventProcessor.publishEvent ( builder.build () );
        }
        if ( this.logValue && diff.getValue () != null )
        {
            final EventBuilder builder = createEvent ( null );

            builder.attribute ( Event.Fields.VALUE, diff.getValue () );
            builder.attribute ( Event.Fields.EVENT_TYPE, this.typeValue );

            this.eventProcessor.publishEvent ( builder.build () );
        }
        if ( this.logAttributes && diff.getAttributes () != null && !diff.getAttributes ().isEmpty () )
        {
            final EventBuilder builder = createEvent ( null );

            builder.attribute ( Event.Fields.VALUE, formatAttributes ( diff.getAttributes () ) );
            builder.attribute ( Event.Fields.EVENT_TYPE, this.typeAttributes );

            this.eventProcessor.publishEvent ( builder.build () );
        }
    }

    @Override
    public synchronized void update ( final UserInformation userInformation, final Map<String, String> parameters ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        this.logSubscription = cfg.getBoolean ( "logSubscription", false );
        this.logValue = cfg.getBoolean ( "logValue", false );
        this.logAttributes = cfg.getBoolean ( "logAttributes", false );
        this.logWrites = cfg.getBoolean ( "logWrites", false );

        this.typeWriteValue = cfg.getString ( "type.write.value", "WRITE" );
        this.typeWriteAttributes = cfg.getString ( "type.write.attributes", "WRITE_ATTRIBUTES" );
        this.typeValue = cfg.getString ( "type.change.value", "VALUE" );
        this.typeAttributes = cfg.getString ( "type.change.attributes", "ATTRIBUTES" );
        this.typeSubscription = cfg.getString ( "type.change.subscription", "SUBSCRIPTION" );

        super.update ( userInformation, parameters );
    }

    @Override
    public WriteRequestResult processWrite ( final WriteRequest request )
    {
        if ( !this.logWrites )
        {
            return null; // return "no-change"
        }

        if ( request.getValue () != null )
        {
            final EventBuilder builder = createEvent ( request );

            builder.attribute ( Event.Fields.VALUE, request.getValue () );
            builder.attribute ( Event.Fields.EVENT_TYPE, this.typeWriteValue );

            this.eventProcessor.publishEvent ( builder.build () );
        }
        if ( request.getAttributes () != null && !request.getAttributes ().isEmpty () )
        {
            final EventBuilder builder = createEvent ( request );

            builder.attribute ( Event.Fields.VALUE, formatAttributes ( request.getAttributes () ) );
            builder.attribute ( Event.Fields.EVENT_TYPE, this.typeWriteAttributes );

            this.eventProcessor.publishEvent ( builder.build () );
        }

        return null; // return "no-change"
    }

    protected Variant formatAttributes ( final Map<String, Variant> attributes )
    {
        return Variant.valueOf ( attributes.toString () );
    }

    protected EventBuilder createEvent ( final WriteRequest request )
    {
        final EventBuilder builder = Event.create ();
        builder.sourceTimestamp ( new Date () );
        builder.attributes ( this.eventAttributes );

        builder.attribute ( Event.Fields.MONITOR_TYPE, "LOG" );

        if ( request != null )
        {
            final OperationParameters wi = request.getOperationParameters ();
            if ( wi != null )
            {
                final UserInformation ui = wi.getUserInformation ();
                if ( ui != null )
                {
                    builder.attribute ( Fields.ACTOR_NAME, ui.getName () );
                    builder.attribute ( Fields.ACTOR_TYPE, "USER" );
                }
            }
        }
        return builder;
    }
}
