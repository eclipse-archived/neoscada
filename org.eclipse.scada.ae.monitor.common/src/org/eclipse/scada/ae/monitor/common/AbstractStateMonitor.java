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
package org.eclipse.scada.ae.monitor.common;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Event.EventBuilder;
import org.eclipse.scada.ae.Event.Fields;
import org.eclipse.scada.ae.data.MonitorStatus;
import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.monitor.common.StateInformation.Builder;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.sec.UserInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Interner;

public abstract class AbstractStateMonitor extends AbstractMonitorService
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractStateMonitor.class );

    private StateInformation currentState = new StateInformation ( null, null, null, null, null, null, null, null, null, null );

    private final PersistentInformation persistentInformation = new PersistentInformation ();

    private Map<String, Variant> attributes;

    private final EventProcessor eventProcessor;

    private boolean suppressEvents;

    public AbstractStateMonitor ( final String id, final Executor executor, final Interner<String> stringInterner, final EventProcessor eventProcessor )
    {
        super ( id, executor, stringInterner );
        this.eventProcessor = eventProcessor;
    }

    @Override
    public synchronized void akn ( final UserInformation userInformation, final Date aknTimestamp )
    {
        final long now = System.currentTimeMillis ();

        // either use the provided timestamp or "now"
        final long akn = aknTimestamp == null ? now : aknTimestamp.getTime ();

        final String user = extractUser ( userInformation );

        final Builder builder = new Builder ( this.currentState );
        builder.setLastAckTimestamp ( akn );
        builder.setLastAckUser ( user );

        final EventBuilder event = createEvent ( userInformation );
        event.attribute ( Fields.EVENT_TYPE, "AKN" );
        sendEvent ( event );

        this.persistentInformation.setLastAckTimestamp ( akn );
        this.persistentInformation.setLastAckUser ( user );
        storePersistentInformation ( this.persistentInformation );

        setState ( builder, now, null );
    }

    protected void sendEvent ( final EventBuilder builder )
    {
        sendEvent ( builder.build () );
    }

    protected void sendEvent ( final Event event )
    {
        sendEvent ( event, false );
    }

    protected void sendEvent ( final Event event, final boolean force )
    {
        logger.debug ( "Sending event: {} - suppressEvents: {}, force: {}", new Object[] { event, this.suppressEvents, force } );
        if ( !this.suppressEvents || force )
        {
            this.eventProcessor.publishEvent ( event );
        }
    }

    private String extractUser ( final UserInformation userInformation )
    {
        if ( userInformation == null )
        {
            return null;
        }
        return userInformation.getName ();
    }

    protected void setState ( final Builder builder, final long now, final MonitorDecorator decorator )
    {
        if ( isEqual ( builder.build () ) )
        {
            logger.trace ( "No change detected" );
            return;
        }

        builder.setLastChangeTimestamp ( now );

        this.currentState = builder.build ();

        final MonitorStatusInformation newState = renderState ( decorator );
        notifyStateChange ( newState );

        sendEvent ( createStateEvent ( newState, decorator ) );
    }

    protected EventBuilder createEvent ( final UserInformation userInformation )
    {
        final EventBuilder builder = Event.create ();

        injectEventAttributes ( builder );
        if ( userInformation != null )
        {
            builder.attribute ( Fields.ACTOR_TYPE, "USER" );
            builder.attribute ( Fields.ACTOR_NAME, userInformation.getName () );
        }

        return builder;
    }

    private Event createStateEvent ( final MonitorStatusInformation state, final MonitorDecorator decorator )
    {
        final EventBuilder builder = createEvent ( null );

        builder.attribute ( Fields.VALUE, state.getValue () );
        builder.attribute ( Fields.EVENT_TYPE, state.getStatus () );
        builder.attribute ( Fields.SEVERITY, state.getSeverity () );

        if ( decorator != null )
        {
            decorator.decorateEvent ( builder );
        }

        return builder.build ();
    }

    private boolean isEqual ( final StateInformation stateInformation )
    {
        if ( this.currentState == null )
        {
            return false;
        }

        return this.currentState.equals ( stateInformation );
    }

    private MonitorStatusInformation renderState ( final MonitorDecorator decorator )
    {
        final MonitorStatus status;

        logger.debug ( "Current state - {}", this.currentState );

        if ( this.currentState == null || this.currentState.getState () == null )
        {
            status = MonitorStatus.INIT;
        }
        else
        {
            switch ( this.currentState.getState () )
            {
                case INACTIVE:
                    status = MonitorStatus.INACTIVE;
                    break;
                case OK:
                    status = ack ( MonitorStatus.OK, MonitorStatus.NOT_AKN );
                    break;
                case UNSAFE:
                    status = MonitorStatus.UNSAFE;
                    break;
                case NOT_OK:
                    status = ack ( MonitorStatus.NOT_OK, MonitorStatus.NOT_OK_NOT_AKN );
                    break;
                default:
                    status = MonitorStatus.UNSAFE;
                    break;
            }
        }

        final Map<String, Variant> attributes;
        if ( decorator != null )
        {
            attributes = new HashMap<String, Variant> ( this.attributes );
            decorator.decorateMonitorAttributes ( attributes );
        }
        else
        {
            attributes = this.attributes;
        }

        return new MonitorStatusInformation ( getId (), status, this.currentState.getLastChangeTimestamp (), this.currentState.getSeverity (), this.currentState.getValue (), this.currentState.getLastAckTimestamp (), this.currentState.getLastAckUser (), this.currentState.getLastFailTimestamp (), this.currentState.getLastFailValue (), attributes );
    }

    public StateInformation getCurrentState ()
    {
        return this.currentState;
    }

    /**
     * Choose from two states via {@link #needAck(StateInformation)}
     * 
     * @param withAkn
     *            state if ack is not required or present
     * @param withoutAkn
     *            state if ack is not present but required
     * @return the correct state
     */
    private MonitorStatus ack ( final MonitorStatus withAkn, final MonitorStatus withoutAkn )
    {
        return needAck ( this.currentState ) ? withoutAkn : withAkn;
    }

    private static boolean needAck ( final StateInformation state )
    {
        if ( state.getLastAckRequiredTimestamp () == null )
        {
            // no requirement
            return false;
        }
        if ( state.getLastAckTimestamp () == null )
        {
            // required but no ack
            return true;
        }
        return state.getLastAckRequiredTimestamp () > state.getLastAckTimestamp ();
    }

    public synchronized void setSuppressEvents ( final boolean suppressEvents )
    {
        this.suppressEvents = suppressEvents;
    }

    public boolean isSuppressEvents ()
    {
        return this.suppressEvents;
    }

    protected synchronized void setAttributes ( final Map<String, Variant> attributes )
    {
        this.attributes = attributes;
    }

    protected synchronized void setStringAttributes ( final Map<String, String> attributes )
    {
        final Map<String, Variant> convertedAttributes = new HashMap<String, Variant> ( attributes.size () );

        for ( final Map.Entry<String, String> entry : attributes.entrySet () )
        {
            convertedAttributes.put ( entry.getKey (), Variant.valueOf ( entry.getValue () ) );
        }

        setAttributes ( convertedAttributes );
    }

    protected void buildMonitorAttributes ( final Map<String, Variant> attributes )
    {
        attributes.putAll ( this.attributes );
    }

    protected void injectEventAttributes ( final EventBuilder builder )
    {
        // put "id" first to give attributes a chance to override
        builder.attribute ( Fields.SOURCE, getId () );
        builder.attributes ( this.attributes );
    }

    protected void setUnsafe ()
    {
        final Builder builder = new Builder ( this.currentState );
        builder.setState ( State.UNSAFE );
        setState ( builder, System.currentTimeMillis (), null );
    }

    protected void setOk ( final Variant value, final Long valueTimestamp )
    {
        final Builder builder = new Builder ( this.currentState );
        builder.setState ( State.OK );

        if ( isEqual ( builder.build () ) )
        {
            return;
        }

        builder.setValue ( value );
        builder.setLastValueTimestamp ( valueTimestamp );

        setState ( builder, System.currentTimeMillis (), null );
    }

    protected void triggerFailure ( final Variant value, final Long valueTimestamp, final Severity severity, final boolean requireAck, final MonitorDecorator decorator )
    {
        final Builder builder = new Builder ( this.currentState );

        final long now = System.currentTimeMillis ();

        builder.setState ( State.OK );
        builder.setSeverity ( severity );

        if ( requireAck )
        {
            builder.setLastAckRequiredTimestamp ( now );
        }
        else
        {
            builder.setLastAckRequiredTimestamp ( null );
        }

        builder.setValue ( value );
        builder.setLastValueTimestamp ( valueTimestamp );
        builder.setLastFailTimestamp ( now );
        builder.setLastFailValue ( value );

        setState ( builder, now, decorator );
    }

    protected void setFailure ( final Variant value, final Long valueTimestamp, final Severity severity, final boolean requireAck )
    {
        setFailure ( value, valueTimestamp, severity, requireAck, null );
    }

    protected void setFailure ( final Variant value, final Long valueTimestamp, final Severity severity, final boolean requireAck, final MonitorDecorator decorator )
    {
        final Builder builder = new Builder ( this.currentState );

        builder.setState ( State.NOT_OK );
        builder.setSeverity ( severity );

        final long now = System.currentTimeMillis ();

        if ( !requireAck )
        {
            // we switch from require ack to not require ack
            builder.setLastAckRequiredTimestamp ( null );
        }
        else if ( this.currentState.getLastAckRequiredTimestamp () == null )
        {
            // we switch from not require ack to require ack
            builder.setLastAckRequiredTimestamp ( now );
        }

        if ( isEqual ( builder.build () ) )
        {
            logger.info ( "No change" );
            return;
        }

        // we are only interested in the initial alarm state
        builder.setValue ( value );
        builder.setLastValueTimestamp ( valueTimestamp );

        builder.setLastFailTimestamp ( now );
        builder.setLastFailValue ( value );

        if ( this.persistentInformation == null )
        {
            this.persistentInformation.setLastFailTimestamp ( now );
        }
        storePersistentInformation ( this.persistentInformation );

        if ( requireAck )
        {
            builder.setLastAckRequiredTimestamp ( now );
        }
        else
        {
            builder.setLastAckRequiredTimestamp ( null );
        }

        setState ( builder, now, decorator );
    }

    protected void setInactive ()
    {
        final Builder builder = new Builder ( this.currentState );
        builder.setState ( State.INACTIVE );
        setState ( builder, System.currentTimeMillis (), null );
    }

    protected synchronized void applyPersistentInformation ( final PersistentInformation persistentInformation )
    {
        if ( persistentInformation == null )
        {
            return;
        }

        logger.debug ( "Applying persistent information : {}", persistentInformation );

        final StateInformation.Builder builder = new Builder ( this.currentState );

        if ( this.currentState.getLastAckTimestamp () == null )
        {
            /* we set both timestamp and user here since the user might be null in case
            the akn was performed by an anonymous user. In this case the user
            would remain null although it is newer then then persisted user. But
            the timestamp is always updated */

            builder.setLastAckTimestamp ( persistentInformation.getLastAckTimestamp () );
            builder.setLastAckUser ( persistentInformation.getLastAckUser () );

            this.persistentInformation.setLastAckTimestamp ( persistentInformation.getLastAckTimestamp () );
            this.persistentInformation.setLastAckUser ( persistentInformation.getLastAckUser () );
        }
        if ( this.currentState.getLastFailTimestamp () == null )
        {
            builder.setLastFailTimestamp ( persistentInformation.getLastFailTimestamp () );
            builder.setLastFailValue ( persistentInformation.getLastFailValue () );
            this.persistentInformation.setLastFailTimestamp ( persistentInformation.getLastFailTimestamp () );
        }

        setState ( builder, System.currentTimeMillis (), null );
    }

    protected abstract void storePersistentInformation ( final PersistentInformation persistentInformation );
}
