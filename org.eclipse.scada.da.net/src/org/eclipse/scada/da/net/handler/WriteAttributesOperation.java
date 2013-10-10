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
package org.eclipse.scada.da.net.handler;

import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.core.net.MessageHelper;
import org.eclipse.scada.da.core.WriteAttributeResult;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.net.base.data.LongValue;
import org.eclipse.scada.net.base.data.MapValue;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.base.data.StringValue;
import org.eclipse.scada.net.base.data.Value;
import org.eclipse.scada.net.base.data.VoidValue;
import org.eclipse.scada.utils.lang.Holder;

public class WriteAttributesOperation
{

    /**
     * @since 1.1
     */
    public static Message createRequest ( final String itemId, final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        final Message message = new Message ( Messages.CC_WRITE_ATTRIBUTES_OPERATION );

        message.getValues ().put ( "item-id", new StringValue ( itemId ) );
        message.getValues ().put ( "attributes", MessageHelper.attributesToMap ( attributes ) );

        MessageHelper.encodeOperationParameters ( operationParameters, message );

        return message;
    }

    public static void parseRequest ( final Message message, final Holder<String> itemId, final Holder<Map<String, Variant>> attributes, final Holder<OperationParameters> operationParameters )
    {
        // FIXME: handle missing item name
        itemId.value = message.getValues ().get ( "item-id" ).toString ();

        final Value value = message.getValues ().get ( "attributes" );
        if ( value instanceof MapValue )
        {
            attributes.value = MessageHelper.mapToAttributes ( (MapValue)value );
        }

        operationParameters.value = MessageHelper.convertOperationParameters ( message.getValues ().get ( MessageHelper.FIELD_OPERATION_PARAMETERS ) );
    }

    public static Message createResponse ( final long id, final WriteAttributeResults writeAttributeResults )
    {
        final Message message = new Message ( Messages.CC_WRITE_ATTRIBUTES_OPERATION_RESULT );

        message.getValues ().put ( "id", new LongValue ( id ) );

        final MapValue resultValues = new MapValue ();
        for ( final Map.Entry<String, WriteAttributeResult> writeAttributeResult : writeAttributeResults.entrySet () )
        {
            if ( writeAttributeResult.getValue ().isError () )
            {
                resultValues.put ( writeAttributeResult.getKey (), new StringValue ( writeAttributeResult.getValue ().toString () ) );
            }
            else
            {
                resultValues.put ( writeAttributeResult.getKey (), VoidValue.INSTANCE );
            }
        }

        message.getValues ().put ( "results", resultValues );

        return message;
    }

    public static Message createResponse ( final long id, final Throwable error )
    {
        final Message message = new Message ( Messages.CC_WRITE_ATTRIBUTES_OPERATION_RESULT );

        message.getValues ().put ( "id", new LongValue ( id ) );

        if ( error.getMessage () != null )
        {
            message.getValues ().put ( Message.FIELD_ERROR_INFO, new StringValue ( error.getMessage () ) );
        }
        else
        {
            message.getValues ().put ( Message.FIELD_ERROR_INFO, new StringValue ( error.toString () ) );
        }

        return message;
    }

    public static WriteAttributeResults parseResponse ( final Message message ) throws Exception
    {
        final WriteAttributeResults writeAttributeResults = new WriteAttributeResults ();

        if ( message.getValues ().containsKey ( Message.FIELD_ERROR_INFO ) )
        {
            throw new Exception ( message.getValues ().get ( Message.FIELD_ERROR_INFO ).toString () );
        }

        if ( message.getValues ().containsKey ( "results" ) )
        {
            if ( message.getValues ().get ( "results" ) instanceof MapValue )
            {
                final MapValue resultValues = (MapValue)message.getValues ().get ( "results" );
                for ( final Map.Entry<String, Value> entry : resultValues.getValues ().entrySet () )
                {
                    final String name = entry.getKey ();
                    if ( entry.getValue () instanceof VoidValue )
                    {
                        writeAttributeResults.put ( name, WriteAttributeResult.OK );
                    }
                    else
                    {
                        writeAttributeResults.put ( name, new WriteAttributeResult ( new Exception ( entry.getValue ().toString () ) ) );
                    }
                }
            }
        }

        return writeAttributeResults;
    }
}
