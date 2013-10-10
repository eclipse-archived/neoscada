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
 *     Jürgen Rose - additional work
 *******************************************************************************/
package org.eclipse.scada.ae;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.utils.lang.Immutable;

/**
 * A class holding the AE event information
 * <p>
 * Keys and values of the events attributes must not be null. If null is
 * inserted it will simply be ignored.
 * </p>
 */
@Immutable
public class Event implements Cloneable, Comparable<Event>, Serializable
{
    private static final long serialVersionUID = 1L;

    public static class EventComparator implements Comparator<Event>
    {
        @Override
        public int compare ( final Event o1, final Event o2 )
        {
            final int s = o1.getSourceTimestamp ().compareTo ( o2.getSourceTimestamp () );
            if ( s == 0 )
            {
                final int e = o1.getEntryTimestamp ().compareTo ( o2.getEntryTimestamp () );
                if ( e == 0 )
                {
                    return o1.getId ().compareTo ( o2.getId () );
                }
                return e;
            }
            return s;
        }
    }

    public static class EventBuilder
    {
        private final Event event = new Event ();

        private boolean allowOverrideAttributes = true;

        private EventBuilder ()
        {
        }

        public EventBuilder event ( final Event event )
        {
            this.event.id = event.getId ();
            this.event.sourceTimestamp = event.getSourceTimestamp ();
            this.event.entryTimestamp = event.getEntryTimestamp ();
            this.event.attributes.putAll ( event.getAttributes () );
            return this;
        }

        public EventBuilder id ( final UUID id )
        {
            this.event.id = id;
            return this;
        }

        public EventBuilder sourceTimestamp ( final Date sourceTimestamp )
        {
            this.event.sourceTimestamp = sourceTimestamp;
            return this;
        }

        public EventBuilder entryTimestamp ( final Date entryTimestamp )
        {
            this.event.entryTimestamp = entryTimestamp;
            return this;
        }

        public EventBuilder attributes ( final Map<String, Variant> attributes )
        {
            if ( attributes == null )
            {
                return this;
            }

            if ( this.allowOverrideAttributes )
            {
                for ( final Map.Entry<String, Variant> entry : attributes.entrySet () )
                {
                    if ( entry.getValue () != null && entry.getKey () != null )
                    {
                        this.event.attributes.put ( entry.getKey (), entry.getValue () );
                    }
                }
                this.event.attributes.putAll ( attributes );
            }
            else
            {
                for ( final Map.Entry<String, Variant> entry : attributes.entrySet () )
                {
                    if ( entry.getValue () != null && entry.getKey () != null )
                    {
                        attribute ( entry.getKey (), entry.getValue () );
                    }
                }
            }
            return this;
        }

        public EventBuilder attribute ( final String key, final Variant value )
        {
            if ( key == null || value == null )
            {
                return this;
            }
            if ( this.allowOverrideAttributes || !this.event.attributes.containsKey ( key ) )
            {
                this.event.attributes.put ( key, value );
            }
            return this;
        }

        public EventBuilder attribute ( final Fields key, final Variant value )
        {
            if ( value != null )
            {
                attribute ( key.getName (), value );
            }
            return this;
        }

        public EventBuilder attribute ( final String key, final Object value )
        {
            if ( value != null )
            {
                attribute ( key, Variant.valueOf ( value ) );
            }
            return this;
        }

        public EventBuilder attribute ( final Fields key, final Object value )
        {
            if ( value != null )
            {
                attribute ( key.getName (), Variant.valueOf ( value ) );
            }
            return this;
        }

        public boolean hasAttribute ( final String key )
        {
            return this.event.getAttributes ().containsKey ( key );
        }

        public boolean hasAttribute ( final Fields key )
        {
            return this.event.getAttributes ().containsKey ( key.getName () );
        }

        /**
         * Set allow override attributes flag
         * <p>
         * Setting to <code>true</code> allows attributes to be overridden by
         * calls to the attribute/attributes methods. Setting to
         * <code>false</code> will not set attributes that already have been set
         * by previous calls.
         * </p>
         * 
         * @param allowOverrideAttributes
         */
        public void setAllowOverrideAttributes ( final boolean allowOverrideAttributes )
        {
            this.allowOverrideAttributes = allowOverrideAttributes;
        }

        public Event build ()
        {
            return new Event ( this.event );
        }
    }

    public enum Fields
    {
        MONITOR_TYPE ( "monitorType", String.class ),
        EVENT_TYPE ( "eventType", String.class ),
        VALUE ( "value", Variant.class ),
        MESSAGE ( "message", String.class ),
        MESSAGE_CODE ( "messageSource", String.class ),
        PRIORITY ( "priority", Integer.class ),
        SEVERITY ( "severity", String.class ),
        SOURCE ( "source", String.class ),
        ACTOR_NAME ( "actorName", String.class ),
        ACTOR_TYPE ( "actorType", String.class ),
        HIVE ( "hive", String.class ),
        ITEM ( "item", String.class ),
        COMPONENT ( "component", String.class ),
        SYSTEM ( "system", String.class ),
        LOCATION ( "location", String.class ),
        COMMENT ( "comment", String.class );

        private final Class<? extends Object> clazz;

        private final String name;

        Fields ( final String name, final Class<? extends Object> clazz )
        {
            this.name = name;
            this.clazz = clazz;
        }

        public Class<? extends Object> getType ()
        {
            return this.clazz;
        }

        public String getName ()
        {
            return this.name;
        }

        public boolean contains ( final String name )
        {
            return byField ( name ) == null ? false : true;
        }

        public static Fields byField ( final String name )
        {
            for ( final Fields field : values () )
            {
                if ( field.getName ().equals ( name ) )
                {
                    return field;
                }
            }
            return null;
        }
    }

    public static final EventComparator comparator = new EventComparator ();

    private UUID id;

    private Date sourceTimestamp;

    private Date entryTimestamp;

    private final Map<String, Variant> attributes = new HashMap<String, Variant> ();

    public static final Event NULL_EVENT = create ().id ( new UUID ( 0, 0 ) ).sourceTimestamp ( new Date ( 0 ) ).entryTimestamp ( new Date ( 0 ) ).build ();

    private Event ( final Event event )
    {
        this.id = event.getId ();
        this.sourceTimestamp = event.getSourceTimestamp ();
        this.entryTimestamp = event.getEntryTimestamp ();
        this.attributes.putAll ( event.getAttributes () );
    }

    private Event ()
    {
    }

    public UUID getId ()
    {
        return this.id;
    }

    public Date getSourceTimestamp ()
    {
        return this.sourceTimestamp;
    }

    public Date getEntryTimestamp ()
    {
        return this.entryTimestamp;
    }

    public Map<String, Variant> getAttributes ()
    {
        return Collections.unmodifiableMap ( this.attributes );
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.id == null ? 0 : this.id.hashCode () );
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
        final Event other = (Event)obj;
        if ( this.id == null )
        {
            if ( other.id != null )
            {
                return false;
            }
        }
        else if ( !this.id.equals ( other.id ) )
        {
            return false;
        }
        return true;
    }

    public static EventBuilder create ()
    {
        return new EventBuilder ();
    }

    @Override
    public Event clone ()
    {
        return new Event ( this );
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder ();
        sb.append ( "Event {" );
        sb.append ( "id: " );
        sb.append ( this.id == null ? null : this.id.toString () );
        sb.append ( ", sourceTimestamp: " );
        sb.append ( this.sourceTimestamp == null ? null : this.sourceTimestamp.toString () );
        sb.append ( ", entryTimestamp: " );
        sb.append ( this.entryTimestamp == null ? null : this.entryTimestamp.toString () );
        for ( final Entry<String, Variant> entry : this.attributes.entrySet () )
        {
            sb.append ( ", " + entry.getKey () );
            sb.append ( ": " );
            sb.append ( entry.getValue () == null ? null : entry.getValue () );
        }
        sb.append ( "}" );
        return sb.toString ();
    }

    @Override
    public int compareTo ( final Event o )
    {
        return comparator.compare ( this, o );
    }

    public Variant getField ( final Fields field )
    {
        if ( field == null )
        {
            return null;
        }
        return this.attributes.get ( field.getName () );
    }

    public void setField ( final Fields field, final Variant value )
    {
        if ( field == null || value == null )
        {
            return;
        }
        this.attributes.put ( field.getName (), value );
    }
}
