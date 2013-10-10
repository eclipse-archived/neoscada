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
package org.eclipse.scada.ae.utils;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Event.EventBuilder;
import org.eclipse.scada.sec.UserInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractBaseConfiguration
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractBaseConfiguration.class );

    private final List<Event> events = new LinkedList<Event> ();

    protected abstract void injectEventAttributes ( final EventBuilder builder );

    protected abstract void sendEvent ( final Event event );

    protected final boolean initialUpdate;

    public AbstractBaseConfiguration ( final AbstractBaseConfiguration currentConfiguration )
    {
        super ();
        this.initialUpdate = currentConfiguration == null;
    }

    public void sendEvents ()
    {
        if ( !this.initialUpdate )
        {
            for ( final Event event : this.events )
            {
                logger.debug ( "Sending event: {}", event );
                sendEvent ( event );
            }
        }
        this.events.clear ();
    }

    protected void addEvent ( final EventBuilder builder )
    {
        this.events.add ( builder.build () );
    }

    protected EventBuilder create ( final Object value, final UserInformation userInformation )
    {
        final EventBuilder builder = Event.create ();

        injectEventAttributes ( builder );

        builder.attribute ( Event.Fields.EVENT_TYPE, "CFG" );

        if ( userInformation != null )
        {
            builder.attribute ( Event.Fields.ACTOR_TYPE, "USER" );
            builder.attribute ( Event.Fields.ACTOR_NAME, userInformation.getName () );
        }

        builder.attribute ( Event.Fields.VALUE, value );

        return builder;
    }

    protected <T> T update ( final UserInformation userInformation, final T oldValue, final T newValue )
    {
        if ( oldValue == newValue )
        {
            // both are equal ... no event
            return newValue;
        }

        if ( oldValue == null )
        {
            // the old value is null but the new is not ... send event
            addEvent ( create ( newValue, userInformation ) );
            return newValue;
        }

        if ( oldValue.equals ( newValue ) )
        {
            // old value and new value are equal ... no event
            return newValue;
        }

        // old value and new value or not equal ... send event
        addEvent ( create ( newValue, userInformation ) );
        return newValue;
    }

}