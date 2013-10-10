/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.master.common.manual;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Event.Fields;
import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantEditor;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.da.master.common.AbstractCommonHandlerImpl;
import org.eclipse.scada.da.master.common.internal.Activator;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManualHandlerImpl extends AbstractCommonHandlerImpl
{

    private final static Logger logger = LoggerFactory.getLogger ( ManualHandlerImpl.class );

    private final EventProcessor eventProcessor;

    private final String id;

    /**
     * Send all updates, event if the value did not change
     * <p>
     * Defaults to <code>false</code>
     * </p>
     */
    private final boolean sendAllUpdates = Boolean.getBoolean ( "org.eclipse.scada.da.master.common.manual.sendAllUpdates" );

    public static class ManualStateData
    {
        private Variant value;

        private String user;

        private String reason;

        private Date timestmap;

        public ManualStateData ( final Variant value, final String user, final String reason, final Date timestmap )
        {
            super ();
            this.value = value != null ? value : Variant.NULL;
            this.user = user;
            this.reason = reason;
            this.timestmap = timestmap;
        }

        public Variant getValue ()
        {
            return this.value;
        }

        public void setValue ( final Variant value )
        {
            this.value = value;
        }

        public String getUser ()
        {
            return this.user;
        }

        public void setUser ( final String user )
        {
            this.user = user;
        }

        public String getReason ()
        {
            return this.reason;
        }

        public void setReason ( final String reason )
        {
            this.reason = reason;
        }

        public Date getTimestmap ()
        {
            return this.timestmap;
        }

        public void setTimestmap ( final Date timestmap )
        {
            this.timestmap = timestmap;
        }

        @Override
        public int hashCode ()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ( this.reason == null ? 0 : this.reason.hashCode () );
            result = prime * result + ( this.timestmap == null ? 0 : this.timestmap.hashCode () );
            result = prime * result + ( this.user == null ? 0 : this.user.hashCode () );
            result = prime * result + ( this.value == null ? 0 : this.value.hashCode () );
            return result;
        }

        @Override
        public boolean equals ( final Object obj )
        {
            if ( this == obj )
            {
                return true;
            }
            if ( obj == null )
            {
                return false;
            }
            if ( getClass () != obj.getClass () )
            {
                return false;
            }
            final ManualStateData other = (ManualStateData)obj;
            if ( this.reason == null )
            {
                if ( other.reason != null )
                {
                    return false;
                }
            }
            else if ( !this.reason.equals ( other.reason ) )
            {
                return false;
            }
            if ( this.timestmap == null )
            {
                if ( other.timestmap != null )
                {
                    return false;
                }
            }
            else if ( !this.timestmap.equals ( other.timestmap ) )
            {
                return false;
            }
            if ( this.user == null )
            {
                if ( other.user != null )
                {
                    return false;
                }
            }
            else if ( !this.user.equals ( other.user ) )
            {
                return false;
            }
            if ( this.value == null )
            {
                if ( other.value != null )
                {
                    return false;
                }
            }
            else if ( !this.value.equals ( other.value ) )
            {
                return false;
            }
            return true;
        }

    }

    private ManualStateData state = new ManualStateData ( Variant.NULL, null, null, null );

    private final String attrActive;

    private final String attrUser;

    private final String attrReason;

    private final String attrValueOriginal;

    private final String attrErrorOriginal;

    private final String attrErrorCountOriginal;

    private final String attrErrorItemsOriginal;

    private final String attrTimestampOriginal;

    private final String attrValue;

    public ManualHandlerImpl ( final String configurationId, final EventProcessor eventProcessor, final ObjectPoolTracker<MasterItem> poolTracker, final int priority, final ServiceTracker<ConfigurationAdministrator, ConfigurationAdministrator> caTracker )
    {
        super ( configurationId, poolTracker, priority, caTracker, ManualHandlerFactoryImpl.FACTORY_ID, ManualHandlerFactoryImpl.FACTORY_ID );
        this.id = configurationId;
        this.eventProcessor = eventProcessor;

        this.attrActive = getPrefixed ( "active", Activator.getStringInterner () ); //$NON-NLS-1$
        this.attrUser = getPrefixed ( "user", Activator.getStringInterner () ); //$NON-NLS-1$
        this.attrReason = getPrefixed ( "reason", Activator.getStringInterner () ); //$NON-NLS-1$
        this.attrValue = getPrefixed ( "value", Activator.getStringInterner () ); //$NON-NLS-1$

        this.attrValueOriginal = getPrefixed ( "value.original", Activator.getStringInterner () ); //$NON-NLS-1$
        this.attrErrorOriginal = getPrefixed ( "error.original", Activator.getStringInterner () ); //$NON-NLS-1$
        this.attrTimestampOriginal = getPrefixed ( "timestamp.original", Activator.getStringInterner () ); //$NON-NLS-1$

        this.attrErrorCountOriginal = getPrefixed ( "error.count.original", Activator.getStringInterner () ); //$NON-NLS-1$
        this.attrErrorItemsOriginal = getPrefixed ( "error.items.original", Activator.getStringInterner () ); //$NON-NLS-1$
    }

    @Override
    protected void processDataUpdate ( final Map<String, Object> context, final DataItemValue.Builder builder ) throws Exception
    {
        final Variant originalValue = builder.getValue ();

        injectAttributes ( builder );

        final ManualStateData state = this.state;

        if ( state.getValue ().isNull () )
        {
            final Date currentTimestamp = makeTimestamp ( builder );

            if ( currentTimestamp != null && state.getTimestmap () != null && currentTimestamp.after ( state.getTimestmap () ) )
            {
                // if we have a current timestamp and it is after the last manual change, reset the last manual change 
                state.setTimestmap ( null );
            }

            // inject old manual timestamp
            if ( state.getTimestmap () != null && ( currentTimestamp == null || state.getTimestmap ().after ( currentTimestamp ) ) )
            {
                injectTimestamp ( builder, state );
            }
            return;
        }

        // apply manual value : manual value is active

        final Variant originalError = builder.getAttributes ().remove ( "error" ); //$NON-NLS-1$
        builder.setAttribute ( this.attrErrorOriginal, originalError );
        builder.setAttribute ( "error", Variant.FALSE ); //$NON-NLS-1$
        builder.setSubscriptionState ( SubscriptionState.CONNECTED );
        builder.setSubscriptionError ( null );

        final Variant originalErrorCount = builder.getAttributes ().remove ( "error.count" ); //$NON-NLS-1$
        if ( originalErrorCount != null )
        {
            builder.setAttribute ( "error.count", Variant.valueOf ( 0 ) ); //$NON-NLS-1$
            builder.setAttribute ( this.attrErrorCountOriginal, originalErrorCount );
        }

        final Variant originalErrorItems = builder.getAttributes ().remove ( "error.items" ); //$NON-NLS-1$
        if ( originalErrorItems != null )
        {
            builder.setAttribute ( "error.items", Variant.valueOf ( "" ) ); //$NON-NLS-1$ //$NON-NLS-2$
            builder.setAttribute ( this.attrErrorItemsOriginal, originalErrorItems );
        }

        builder.setAttribute ( this.attrValueOriginal, originalValue );
        builder.setAttribute ( this.attrActive, Variant.TRUE );
        builder.setAttribute ( getPrefixed ( null, null ), Variant.TRUE );

        builder.setValue ( this.state.getValue () );

        if ( state.getUser () != null )
        {
            builder.setAttribute ( this.attrUser, Variant.valueOf ( state.getUser () ) );
        }
        if ( state.getReason () != null )
        {
            builder.setAttribute ( this.attrReason, Variant.valueOf ( state.getReason () ) );
        }
        injectTimestamp ( builder, state );
    }

    private Date makeTimestamp ( final DataItemValue.Builder value )
    {
        if ( value == null )
        {
            return null;
        }
        final Calendar c = value.getTimestamp ();
        if ( c == null )
        {
            return null;
        }
        return c.getTime ();
    }

    private void injectTimestamp ( final Builder builder, final ManualStateData state )
    {
        if ( state.getTimestmap () != null )
        {
            final Variant originalTimestamp = builder.getAttributes ().get ( "timestamp" ); //$NON-NLS-1$
            builder.setAttribute ( "timestamp", Variant.valueOf ( state.getTimestmap ().getTime () ) ); //$NON-NLS-1$
            if ( originalTimestamp != null )
            {
                builder.setAttribute ( this.attrTimestampOriginal, originalTimestamp );
            }
        }
    }

    @Override
    public synchronized void update ( final UserInformation userInformation, final Map<String, String> parameters ) throws Exception
    {
        super.update ( userInformation, parameters );

        final VariantEditor ve = new VariantEditor ();

        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        final String str = cfg.getString ( "value" ); //$NON-NLS-1$
        logger.debug ( "Request to set manual value '{}'", str ); //$NON-NLS-1$
        final Variant newValue;
        if ( str != null )
        {
            ve.setAsText ( str );
            newValue = Variant.valueOf ( ve.getValue () );
        }
        else
        {
            newValue = Variant.NULL;
        }

        final String newUser = cfg.getString ( "user" );//$NON-NLS-1$
        final String newReason = cfg.getString ( "reason" ); //$NON-NLS-1$;
        final Date ts = new Date ();
        final Date newTimestamp = makeNewTimestamp ( cfg, ts, newValue );

        final ManualStateData newState = new ManualStateData ( newValue, newUser, newReason, newTimestamp );

        if ( !this.state.equals ( newState ) || this.sendAllUpdates )
        {
            sendUpdateEvent ( newState, ts );
        }

        this.state = newState;

        reprocess ();
    }

    /**
     * Return the new timestamp value
     * <p>
     * The new timestamp
     * <ol>
     * <li>The provided timestamp</li>
     * <li>The previous timestamp of the value did not change</li>
     * <li>The
     * <q>now</q> timestamp</li>
     * </ol>
     * </p>
     * 
     * @param cfg
     *            the configuration data
     * @param ts
     *            the <q>now</q> time
     * @param newValue
     *            the new value
     * @return the new timestamp value, never returns <code>null</code>
     */
    private Date makeNewTimestamp ( final ConfigurationDataHelper cfg, final Date ts, final Variant newValue )
    {
        final Long newTimestamp = cfg.getLong ( "timestamp" );
        if ( newTimestamp != null )
        {
            return new Date ( newTimestamp );
        }

        if ( this.state.getValue ().equals ( newValue ) )
        {
            return this.state.getTimestmap ();
        }

        return ts;
    }

    private void sendUpdateEvent ( final ManualStateData newState, final Date eventTimestamp )
    {
        final Event.EventBuilder builder = createEventBuilder ();

        builder.entryTimestamp ( eventTimestamp );
        builder.sourceTimestamp ( eventTimestamp );
        builder.attribute ( Fields.MONITOR_TYPE, "MAN" ); //$NON-NLS-1$
        builder.attribute ( Fields.SOURCE, this.id );

        builder.attribute ( Fields.VALUE, newState.getValue () );
        if ( newState.getValue ().isNull () )
        {
            builder.attribute ( Fields.MESSAGE, Messages.getString ( "ManualHandlerImpl.Reset.Message" ) ); //$NON-NLS-1$
            builder.attribute ( Fields.MESSAGE_CODE, "MAN-RESET" ); //$NON-NLS-1$
            builder.attribute ( Fields.EVENT_TYPE, Messages.getString ( "ManualHandlerImpl.Reset.Type" ) ); //$NON-NLS-1$
        }
        else
        {
            builder.attribute ( Fields.MESSAGE, Messages.getString ( "ManualHandlerImpl.Set.Message" ) ); //$NON-NLS-1$
            builder.attribute ( Fields.MESSAGE_CODE, "MAN-SET" ); //$NON-NLS-1$
            builder.attribute ( Fields.EVENT_TYPE, Messages.getString ( "ManualHandlerImpl.Set.Type" ) ); //$NON-NLS-1$
        }

        if ( newState.getUser () != null && !newState.getUser ().isEmpty () )
        {
            builder.attribute ( Fields.ACTOR_NAME, newState.getUser () );
            builder.attribute ( Fields.ACTOR_TYPE, "USER" );
        }

        if ( newState.getReason () != null && !newState.getReason ().isEmpty () )
        {
            builder.attribute ( Fields.COMMENT, newState.getReason () );
        }

        this.eventProcessor.publishEvent ( builder.build () );
    }

    protected void injectAttributes ( final Builder builder )
    {
        builder.setAttribute ( getPrefixed ( null, null ), this.state.getValue ().isNull () ? Variant.FALSE : Variant.TRUE );
        builder.setAttribute ( this.attrActive, this.state.getValue ().isNull () ? Variant.FALSE : Variant.TRUE );
        builder.setAttribute ( this.attrValue, this.state.getValue () );
        builder.setAttribute ( this.attrReason, Variant.valueOf ( this.state.getReason () ) );
        builder.setAttribute ( this.attrUser, Variant.valueOf ( this.state.getUser () ) );
    }

    @Override
    protected WriteAttributeResults handleUpdate ( final Map<String, Variant> attributes, final OperationParameters operationParameters ) throws Exception
    {
        final Map<String, String> data = new HashMap<String, String> ();

        final Variant value = attributes.get ( "value" ); //$NON-NLS-1$
        if ( value != null )
        {
            data.put ( "value", value.toString () ); //$NON-NLS-1$
        }

        if ( operationParameters != null && operationParameters.getUserInformation () != null && operationParameters.getUserInformation ().getName () != null )
        {
            data.put ( "user", operationParameters.getUserInformation ().getName () ); //$NON-NLS-1$
        }
        else
        {
            data.put ( "user", "" ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        if ( value != null )
        {
            // clear user, reason and timestamp if we have a value

            data.put ( "reason", "" ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        final Variant reason = attributes.get ( "reason" ); //$NON-NLS-1$
        if ( reason != null && !reason.isNull () )
        {
            data.put ( "reason", reason.toString () ); //$NON-NLS-1$
        }

        final Variant timestamp = attributes.get ( "timestamp" ); //$NON-NLS-1$
        if ( timestamp != null && !timestamp.isNull () )
        {
            // we have a timestamp so we use it
            data.put ( "timestamp", "" + timestamp.asLong ( System.currentTimeMillis () ) ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        else
        {
            // we do not have a timestamp, so we use "now"
            data.put ( "timestamp", "" + System.currentTimeMillis () );//$NON-NLS-1$
        }

        return updateConfiguration ( data, attributes, false, operationParameters );
    }
}
