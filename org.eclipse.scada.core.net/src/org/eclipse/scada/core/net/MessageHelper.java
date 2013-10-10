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
package org.eclipse.scada.core.net;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.scada.core.NotConvertableException;
import org.eclipse.scada.core.NullValueException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.core.data.UserInformation;
import org.eclipse.scada.net.base.data.BooleanValue;
import org.eclipse.scada.net.base.data.DoubleValue;
import org.eclipse.scada.net.base.data.IntegerValue;
import org.eclipse.scada.net.base.data.ListValue;
import org.eclipse.scada.net.base.data.LongValue;
import org.eclipse.scada.net.base.data.MapValue;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.base.data.StringValue;
import org.eclipse.scada.net.base.data.Value;
import org.eclipse.scada.net.base.data.VoidValue;

public class MessageHelper
{
    public static final int CC_CREATE_SESSION = 0x00010001;

    public static final int CC_CLOSE_SESSION = 0x00010002;

    public static final int CC_PRIV_CHANGE = 0x00010003;

    public static final int CC_START_SESSION = 0x00010004;

    public static final String FIELD_SESSION_PROPERTIES = "properties";

    public static final String FIELD_TRANSPORT_PROPERTIES = "transport.properties";

    public static final String FIELD_PRIVS = "privileges";

    public static final Object PROP_USING_SESSION_START = "using.sessionStart";

    /**
     * Convert a MapValue to a attributes map
     * 
     * @param mapValue
     *            the map value to convert
     * @return the attributes map
     * @note Only scalar entries in the map are converted. Other values are
     *       skipped.
     */
    public static Map<String, Variant> mapToAttributes ( final MapValue mapValue )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ( mapValue.getValues ().size () );

        for ( final Map.Entry<String, Value> entry : mapValue.getValues ().entrySet () )
        {
            Variant value = null;
            final Value entryValue = entry.getValue ();

            value = valueToVariant ( entryValue, null );

            if ( value != null )
            {
                attributes.put ( entry.getKey (), value );
            }
        }

        return attributes;
    }

    public static MapValue attributesToMap ( final Map<String, Variant> attributes )
    {
        final MapValue mapValue = new MapValue ( attributes.size () );

        for ( final Map.Entry<String, Variant> entry : attributes.entrySet () )
        {
            final Value value = variantToValue ( entry.getValue () );
            if ( value != null )
            {
                mapValue.put ( entry.getKey (), value );
            }
        }

        return mapValue;
    }

    public static Variant valueToVariant ( final Value value, final Variant defaultValue )
    {
        if ( value == null )
        {
            return defaultValue;
        }

        if ( value instanceof StringValue )
        {
            return Variant.valueOf ( ( (StringValue)value ).getValue () );
        }
        else if ( value instanceof BooleanValue )
        {
            return Variant.valueOf ( ( (BooleanValue)value ).getValue () );
        }
        else if ( value instanceof DoubleValue )
        {
            return Variant.valueOf ( ( (DoubleValue)value ).getValue () );
        }
        else if ( value instanceof LongValue )
        {
            return Variant.valueOf ( ( (LongValue)value ).getValue () );
        }
        else if ( value instanceof IntegerValue )
        {
            return Variant.valueOf ( ( (IntegerValue)value ).getValue () );
        }
        else if ( value instanceof VoidValue )
        {
            return Variant.NULL;
        }

        return defaultValue;
    }

    public static Value variantToValue ( final Variant value )
    {
        if ( value == null )
        {
            return null;
        }

        try
        {
            if ( value.isDouble () )
            {
                return new DoubleValue ( value.asDouble () );
            }
            else if ( value.isInteger () )
            {
                return new IntegerValue ( value.asInteger () );
            }
            else if ( value.isLong () )
            {
                return new LongValue ( value.asLong () );
            }
            else if ( value.isBoolean () )
            {
                return BooleanValue.valueOf ( value.asBoolean () );
            }
            else if ( value.isString () )
            {
                return new StringValue ( value.asString () );
            }
            else if ( value.isNull () )
            {
                return VoidValue.INSTANCE;
            }
        }
        catch ( final NullValueException e )
        {
            return VoidValue.INSTANCE;
        }
        catch ( final NotConvertableException e )
        {
        }
        return null;
    }

    /**
     * Construct a CC_CREATE_SESSION message
     * 
     * @param props
     *            the session properties
     * @return the create session message
     */
    public static Message createSession ( final Properties props )
    {
        final Message msg = new Message ( CC_CREATE_SESSION );

        msg.getValues ().put ( FIELD_SESSION_PROPERTIES, toValue ( props ) );

        return msg;
    }

    public static Message closeSession ()
    {
        return new Message ( CC_CLOSE_SESSION );
    }

    /**
     * Convert a map value to properties
     * <p>
     * If the value is not a {@link MapValue} or is <code>null</code> the
     * properties will not be modified.
     * </p>
     * 
     * @param properties
     *            the properties to fill
     * @param value
     *            the value to parse
     */
    public static void getProperties ( final Properties properties, final Value value )
    {
        if ( value instanceof MapValue )
        {
            final MapValue mapValue = (MapValue)value;
            for ( final Map.Entry<String, Value> entry : mapValue.getValues ().entrySet () )
            {
                properties.put ( entry.getKey (), entry.getValue ().toString () );
            }
        }
    }

    public static Message createSessionACK ( final Message inputMessage, final Map<String, String> sessionProperties, final Map<String, String> transportProperties )
    {
        final Message message = new Message ( Message.CC_ACK, inputMessage.getSequence () );
        if ( sessionProperties != null )
        {
            message.getValues ().put ( FIELD_SESSION_PROPERTIES, toValue ( sessionProperties ) );
        }
        if ( transportProperties != null )
        {
            message.getValues ().put ( FIELD_TRANSPORT_PROPERTIES, toValue ( transportProperties ) );
        }
        return message;
    }

    private static MapValue toValue ( final Map<? extends Object, ? extends Object> sessionProperties )
    {
        final MapValue value = new MapValue ();
        if ( sessionProperties != null )
        {
            for ( final Map.Entry<? extends Object, ? extends Object> entry : sessionProperties.entrySet () )
            {
                value.put ( entry.getKey ().toString (), new StringValue ( entry.getValue ().toString () ) );
            }
        }
        return value;
    }

    public static Message createPrivilegeChange ( final Set<String> privileges )
    {
        final Message message = new Message ( CC_PRIV_CHANGE );

        final ListValue value = new ListValue ( privileges.size () );
        for ( final String string : privileges )
        {
            value.add ( new StringValue ( string ) );
        }

        message.getValues ().put ( FIELD_PRIVS, value );

        return message;
    }

    /**
     * @since 1.1
     */
    public static Set<String> getPrivileges ( final Message message )
    {
        final Set<String> result = new HashSet<String> ();

        final Value value = message.getValues ().get ( FIELD_PRIVS );
        if ( ! ( value instanceof ListValue ) )
        {
            return result;
        }

        for ( final Value valueEntry : ( (ListValue)value ).getValues () )
        {
            if ( valueEntry == null )
            {
                continue;
            }
            result.add ( valueEntry.toString () );
        }

        return result;
    }

    public static final String FIELD_USER = "user";

    public static final String FIELD_OPERATION_PARAMETERS = "operation-parameters";

    public static OperationParameters convertOperationParameters ( final Value value )
    {
        if ( value == null )
        {
            return null;
        }
        if ( ! ( value instanceof MapValue ) )
        {
            return null;
        }
        final MapValue mapValue = (MapValue)value;

        final String user = mapValue.get ( FIELD_USER ) != null ? mapValue.get ( FIELD_USER ).toString () : null;

        return new OperationParameters ( new UserInformation ( user ), null );
    }

    /**
     * @since 1.1
     */
    public static void encodeOperationParameters ( final OperationParameters operationParameters, final Message message )
    {
        if ( operationParameters != null )
        {
            final MapValue parameters = new MapValue ( 2 );
            message.getValues ().put ( FIELD_OPERATION_PARAMETERS, parameters );
            if ( operationParameters.getUserInformation () != null && operationParameters.getUserInformation ().getName () != null )
            {
                parameters.put ( FIELD_USER, new StringValue ( operationParameters.getUserInformation ().getName () ) );
            }
        }
    }
}
