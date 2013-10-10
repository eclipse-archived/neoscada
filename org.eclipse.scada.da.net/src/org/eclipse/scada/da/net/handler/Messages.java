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
package org.eclipse.scada.da.net.handler;

import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.net.base.data.IntegerValue;
import org.eclipse.scada.net.base.data.ListValue;
import org.eclipse.scada.net.base.data.MapValue;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.base.data.StringValue;
import org.eclipse.scada.net.base.data.Value;
import org.eclipse.scada.net.base.data.VoidValue;
import org.eclipse.scada.utils.lang.Holder;

public class Messages extends org.eclipse.scada.core.net.MessageHelper
{
    public final static int CC_SUBSCRIBE_ITEM = 0x00010010;

    public final static int CC_UNSUBSCRIBE_ITEM = 0x00010011;

    public final static int CC_NOTIFY_DATA = 0x00010020;

    // public final static int CC_NOTIFY_ATTRIBUTES = 0x00010021; // unsupported
    public static final int CC_SUBSCRIPTION_CHANGE = 0x00010022;

    public final static int CC_WRITE_OPERATION = 0x00010030;

    public final static int CC_WRITE_OPERATION_RESULT = 0x00010031;

    public final static int CC_READ_OPERATION = 0x00010040;

    public final static int CC_WRITE_ATTRIBUTES_OPERATION = 0x00010050;

    public final static int CC_WRITE_ATTRIBUTES_OPERATION_RESULT = 0x00010040;

    public final static int CC_BROWSER_LIST_REQ = 0x00010200;

    public final static int CC_BROWSER_LIST_RES = 0x00010201;

    public final static int CC_BROWSER_EVENT = 0x00010210;

    public final static int CC_BROWSER_SUBSCRIBE = 0x00010211;

    public final static int CC_BROWSER_UNSUBSCRIBE = 0x00010212;

    public static Message subscribeItem ( final String itemName )
    {
        final Message msg = new Message ( CC_SUBSCRIBE_ITEM );
        msg.getValues ().put ( "item-id", new StringValue ( itemName ) );
        return msg;
    }

    public static Message unsubscribeItem ( final String itemName )
    {
        final Message msg = new Message ( CC_UNSUBSCRIBE_ITEM );
        msg.getValues ().put ( "item-id", new StringValue ( itemName ) );
        return msg;
    }

    public static Message notifyData ( final String itemName, final Variant value, final Map<String, Variant> attributes, final boolean cache )
    {
        final Message msg = new Message ( CC_NOTIFY_DATA );

        msg.getValues ().put ( "item-id", new StringValue ( itemName ) );

        // flag if initial bit is set
        if ( cache )
        {
            msg.getValues ().put ( "cache-read", VoidValue.INSTANCE );
        }

        // encode message
        final Value messageValue = variantToValue ( value );
        if ( messageValue != null )
        {
            msg.getValues ().put ( "value", messageValue );
        }

        // encode attributes
        final ListValue unsetEntries = new ListValue ();
        final MapValue setEntries = new MapValue ();

        if ( attributes != null )
        {
            for ( final Map.Entry<String, Variant> entry : attributes.entrySet () )
            {
                final Value valueEntry = variantToValue ( entry.getValue () );
                if ( valueEntry == null )
                {
                    unsetEntries.add ( new StringValue ( entry.getKey () ) );
                }
                else
                {
                    setEntries.put ( entry.getKey (), valueEntry );
                }
            }
        }

        msg.getValues ().put ( "attributes-unset", unsetEntries );
        msg.getValues ().put ( "attributes-set", setEntries );

        return msg;
    }

    public static int encodeIO ( final Set<IODirection> io )
    {
        int bits = 0;
        if ( io.contains ( IODirection.INPUT ) )
        {
            bits |= 1;
        }
        if ( io.contains ( IODirection.OUTPUT ) )
        {
            bits |= 2;
        }

        return bits;
    }

    public static Set<IODirection> decodeIO ( final int bits )
    {
        final EnumSet<IODirection> ioDirection = EnumSet.noneOf ( IODirection.class );

        if ( ( bits & 1 ) > 0 )
        {
            ioDirection.add ( IODirection.INPUT );
        }
        if ( ( bits & 2 ) > 0 )
        {
            ioDirection.add ( IODirection.OUTPUT );
        }

        return ioDirection;
    }

    public static Message notifySubscriptionChange ( final String item, final SubscriptionState subscriptionState )
    {
        final Message msg = new Message ( CC_SUBSCRIPTION_CHANGE );
        msg.getValues ().put ( "item-id", new StringValue ( item ) );
        switch ( subscriptionState )
        {
        case DISCONNECTED:
            msg.getValues ().put ( "state", IntegerValue.valueOf ( 0 ) );
            break;
        case GRANTED:
            msg.getValues ().put ( "state", IntegerValue.valueOf ( 1 ) );
            break;
        case CONNECTED:
            msg.getValues ().put ( "state", IntegerValue.valueOf ( 2 ) );
            break;
        }
        return msg;
    }

    public static void parseSubscriptionChange ( final Message msg, final Holder<String> item, final Holder<SubscriptionState> subscriptionState )
    {
        if ( msg.getValues ().containsKey ( "item-id" ) )
        {
            item.value = msg.getValues ().get ( "item-id" ).toString ();
        }

        if ( msg.getValues ().containsKey ( "state" ) )
        {
            if ( msg.getValues ().get ( "state" ) instanceof IntegerValue )
            {
                switch ( ( (IntegerValue)msg.getValues ().get ( "state" ) ).getValue () )
                {
                case 0:
                    subscriptionState.value = SubscriptionState.DISCONNECTED;
                    break;
                case 1:
                    subscriptionState.value = SubscriptionState.GRANTED;
                    break;
                case 2:
                    subscriptionState.value = SubscriptionState.CONNECTED;
                    break;
                }
            }
        }
    }
}
