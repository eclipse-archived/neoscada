/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.utils.lang.Immutable;

/**
 * A current value snapshot of the {@link DataItem}
 * 
 * @author Jens Reimann
 */
@Immutable
public class DataItemValue
{
    private final Variant value;

    private final Map<String, Variant> attributes;

    private final SubscriptionState subscriptionState;

    private final Throwable subscriptionError;

    /**
     * A default instance that means <q>disconnected</q>
     * 
     * @since 0.17.0
     */
    public static final DataItemValue DISCONNECTED = new DataItemValue ();

    /**
     * Construct a new disconnected instance
     */
    private DataItemValue ()
    {
        super ();
        this.attributes = Collections.emptyMap ();
        this.value = Variant.NULL;
        this.subscriptionState = SubscriptionState.DISCONNECTED;
        this.subscriptionError = null;
    }

    public DataItemValue ( final Variant value, final Map<String, Variant> attributes, final SubscriptionState subscriptionState )
    {
        super ();
        this.attributes = makeAttributes ( attributes );
        this.subscriptionState = subscriptionState;
        this.subscriptionError = null;
        this.value = Variant.valueOf ( value ); // ensures that value is never null
    }

    public DataItemValue ( final Variant value, final Map<String, Variant> attributes, final SubscriptionState subscriptionState, final Throwable subscriptionError )
    {
        super ();
        this.attributes = makeAttributes ( attributes );
        this.subscriptionState = subscriptionState;
        this.value = Variant.valueOf ( value ); // ensures that value is never null
        this.subscriptionError = subscriptionError;
    }

    /**
     * Make the attribute map
     * 
     * @param attributes
     *            initial attributes
     * @return a new attribute map with cleared out attributes
     */
    private static Map<String, Variant> makeAttributes ( final Map<String, Variant> attributes )
    {
        if ( attributes == null || attributes.isEmpty () )
        {
            return Collections.emptyMap ();
        }
        final HashMap<String, Variant> result = new HashMap<String, Variant> ( attributes.size () );

        for ( final Map.Entry<String, Variant> entry : attributes.entrySet () )
        {
            final String key = entry.getKey ();
            final Variant value = entry.getValue ();

            if ( key == null || value == null )
            {
                continue;
            }
            if ( value.isNull () )
            {
                continue;
            }

            result.put ( key, value );
        }

        return result;
    }

    public DataItemValue ( final DataItemValue div )
    {
        this.attributes = div.attributes;
        this.value = div.value;
        this.subscriptionError = div.subscriptionError;
        this.subscriptionState = div.subscriptionState;
    }

    public Variant getValue ()
    {
        return this.value;
    }

    /**
     * Get an unmodifiable map of the attributes
     * 
     * @return an unmodifiable map of the attributes
     */
    public Map<String, Variant> getAttributes ()
    {
        return Collections.unmodifiableMap ( this.attributes );
    }

    public SubscriptionState getSubscriptionState ()
    {
        return this.subscriptionState;
    }

    /**
     * Get the message of the subscription error
     * 
     * @return the message of the subscription error or <code>null</code> if no subscription error is known
     */
    public String getSubscriptionErrorString ()
    {
        final Throwable subscriptionError = this.subscriptionError;
        if ( subscriptionError != null )
        {
            return subscriptionError.getMessage ();
        }
        return null;
    }

    public Throwable getSubscriptionError ()
    {
        return this.subscriptionError;
    }

    /**
     * Get the value of the attribute
     * 
     * @param attributeName
     *            the name of the attribute
     * @return the value of the attribute or <code>null</code> if the attribute is not set
     */
    public Boolean isAttribute ( final String attributeName )
    {
        try
        {
            final Variant value = this.attributes.get ( attributeName );
            if ( value == null )
            {
                return null;
            }
            return value.asBoolean ();
        }
        catch ( final Throwable e )
        {
            return null;
        }
    }

    /**
     * Get the boolean value of the named attribute
     * 
     * @param attributeName
     *            the attribute name to check
     * @param defaultValue
     *            the default value, if the attribute is not set
     * @return the attribute value or the default value it the attribute is not available
     */
    public boolean isAttribute ( final String attributeName, final boolean defaultValue )
    {
        final Boolean value = isAttribute ( attributeName );
        if ( value != null )
        {
            return value;
        }
        return defaultValue;
    }

    /**
     * Check if the value has the manual override attribute set
     * 
     * @return <code>true</code> if the value is manually overridden, <code>false</code> otherwise
     */
    public boolean isManual ()
    {
        return isAttribute ( "manual", false ) || isAttribute ( "org.openscada.da.manual.active", false );
    }

    public boolean isAlarm ()
    {
        return isAttribute ( "alarm", false );
    }

    public boolean isBlocked ()
    {
        return isAttribute ( "blocked", false );
    }

    public boolean isWarning ()
    {
        return isAttribute ( "warning", false );
    }

    public boolean isConnected ()
    {
        return this.subscriptionState == SubscriptionState.CONNECTED;
    }

    public boolean isError ()
    {
        if ( isConnected () )
        {
            return isAttribute ( "error", false );
        }
        return false;
    }

    /**
     * get an attribute as timestamp
     * 
     * @param attributeName
     *            the attribute to get
     * @return the timestamp or <code>null</code> if the timestamp property is not set
     */
    public static Calendar getAsTimestamp ( final Map<String, Variant> attributes, final String attributeName )
    {
        final Variant value = attributes.get ( attributeName );
        if ( value == null )
        {
            return null;
        }

        if ( !value.isLong () )
        {
            return null;
        }

        final Calendar c = Calendar.getInstance ();
        try
        {
            c.setTimeInMillis ( value.asLong () );
        }
        catch ( final Throwable e )
        {
            return null;
        }
        return c;
    }

    /**
     * get an attribute as timestamp
     * 
     * @param attributeName
     *            the attribute to get
     * @return the timestamp or <code>null</code> if the timestamp property is not set
     */
    public Calendar getAsTimestamp ( final String attributeName )
    {
        return getAsTimestamp ( this.attributes, attributeName );
    }

    /**
     * Get an attribute as boolean value
     * 
     * @param attributeName
     *            the name of the attribute to fetch
     * @return the value of the attribute or <code>false</code> if the attribute is not set
     * @see Variant#asBoolean()
     */
    public boolean getAttributeAsBoolean ( final String attributeName )
    {
        final Variant value = this.attributes.get ( attributeName );
        if ( value == null )
        {
            return false;
        }
        return value.asBoolean ();
    }

    public Boolean getAttributeAsBoolean ( final String attributeName, final Boolean defaultValue )
    {
        final Variant value = this.attributes.get ( attributeName );
        if ( value == null )
        {
            return defaultValue;
        }
        return value.asBoolean ( defaultValue );
    }

    /**
     * get the timestamp of the value
     * 
     * @return the timestamp or <code>null</code> if the timestamp property is not set
     */
    public Calendar getTimestamp ()
    {
        return getAsTimestamp ( "timestamp" );
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder ();

        if ( this.value != null )
        {
            sb.append ( this.value.toString () );
        }
        sb.append ( "[" );
        if ( isConnected () )
        {
            sb.append ( "C" );
        }
        if ( isAlarm () )
        {
            sb.append ( "A" );
        }
        if ( isError () )
        {
            sb.append ( "E" );
        }
        if ( isManual () )
        {
            sb.append ( "M" );
        }
        sb.append ( "]" );

        final Calendar c = getTimestamp ();
        if ( c != null )
        {
            sb.append ( String.format ( "[%1$tF %1$tT,%1$tL]", c ) );
        }
        else
        {
            sb.append ( "[none]" );
        }

        return sb.toString ();
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.attributes == null ? 0 : this.attributes.hashCode () );
        result = prime * result + ( this.subscriptionState == null ? 0 : this.subscriptionState.hashCode () );
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
        final DataItemValue other = (DataItemValue)obj;
        if ( this.attributes == null )
        {
            if ( other.attributes != null )
            {
                return false;
            }
        }
        else if ( !this.attributes.equals ( other.attributes ) )
        {
            return false;
        }
        if ( this.subscriptionState == null )
        {
            if ( other.subscriptionState != null )
            {
                return false;
            }
        }
        else if ( !this.subscriptionState.equals ( other.subscriptionState ) )
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

    /**
     * A mutable version of {@link DataItemValue}
     * 
     * @author Jens Reimann
     */
    public static class Builder
    {

        private SubscriptionState subscriptionState;

        private Throwable subscriptionError;

        private Variant value;

        private Map<String, Variant> attributes;

        public Builder ()
        {
            this.value = Variant.NULL;
            this.attributes = new HashMap<String, Variant> ();
            this.subscriptionState = SubscriptionState.DISCONNECTED;
        }

        public Builder ( final DataItemValue sourceValue )
        {
            if ( sourceValue == null )
            {
                this.value = Variant.NULL;
                this.attributes = new HashMap<String, Variant> ();
                this.subscriptionState = SubscriptionState.DISCONNECTED;
            }
            else
            {
                this.value = sourceValue.getValue ();
                this.attributes = new HashMap<String, Variant> ( sourceValue.getAttributes () );
                this.subscriptionState = sourceValue.getSubscriptionState ();
                this.subscriptionError = sourceValue.getSubscriptionError ();
            }
        }

        public SubscriptionState getSubscriptionState ()
        {
            return this.subscriptionState;
        }

        public Builder setSubscriptionState ( final SubscriptionState subscriptionState )
        {
            this.subscriptionState = subscriptionState;
            return this;
        }

        public Throwable getSubscriptionError ()
        {
            return this.subscriptionError;
        }

        public Builder setSubscriptionError ( final Throwable subscriptionError )
        {
            this.subscriptionError = subscriptionError;
            return this;
        }

        public Variant getValue ()
        {
            return this.value;
        }

        public Builder setValue ( final Variant value )
        {
            this.value = value;
            return this;
        }

        public Map<String, Variant> getAttributes ()
        {
            return this.attributes;
        }

        public Builder setAttributes ( final Map<String, Variant> attributes )
        {
            this.attributes = attributes;
            return this;
        }

        public Builder setAttribute ( final String name, final Variant value )
        {
            if ( value == null )
            {
                this.attributes.remove ( name );
            }
            else
            {
                this.attributes.put ( name, value );
            }
            return this;
        }

        public Builder clearAttribute ( final String name )
        {
            this.attributes.remove ( name );
            return this;
        }

        public Builder setTimestamp ( final long timestamp )
        {
            setAttribute ( "timestamp", Variant.valueOf ( timestamp ) );
            return this;
        }

        public Builder setTimestamp ( final Calendar timestamp )
        {
            if ( timestamp == null )
            {
                clearAttribute ( "timestamp" );
            }
            else
            {
                setAttribute ( "timestamp", Variant.valueOf ( timestamp.getTimeInMillis () ) );
            }
            return this;
        }

        public Calendar getTimestamp ()
        {
            return getAsTimestamp ( "timestamp" );
        }

        public Calendar getAsTimestamp ( final String attributeName )
        {
            return DataItemValue.getAsTimestamp ( this.attributes, attributeName );
        }

        public DataItemValue build ()
        {
            return new DataItemValue ( this.value, this.attributes, this.subscriptionState, this.subscriptionError );
        }

        @Override
        public String toString ()
        {
            return build ().toString ();
        }
    }
}
