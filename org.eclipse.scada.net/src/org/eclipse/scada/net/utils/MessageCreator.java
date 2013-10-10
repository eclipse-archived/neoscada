/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.net.utils;

import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.base.data.StringValue;
import org.eclipse.scada.utils.ExceptionHelper;
import org.eclipse.scada.utils.statuscodes.CodedExceptionBase;
import org.eclipse.scada.utils.statuscodes.StatusCode;

public class MessageCreator
{

    public static Message createUnknownMessage ( final Message inputMessage )
    {
        final Message msg = new Message ( Message.CC_UNKNOWN_COMMAND_CODE );

        msg.setReplySequence ( inputMessage.getSequence () );

        return msg;
    }

    public static Message createFailedMessage ( final Message inputMessage, final Throwable error )
    {
        String msg = null;

        final Throwable root = ExceptionHelper.getRootCause ( error );

        if ( root instanceof CodedExceptionBase )
        {
            final StatusCode status = ( (CodedExceptionBase)root ).getStatus ();
            if ( status != null )
            {
                msg = status.toString ();
            }
        }
        else
        {
            msg = ExceptionHelper.getMessage ( error );
        }

        // if we still don't have a message ... use toString()
        if ( msg == null )
        {
            msg = error.toString ();
        }

        return createFailedMessage ( inputMessage, msg );
    }

    public static Message createFailedMessage ( final Message inputMessage, final String failMessage )
    {
        return createFailedMessage ( inputMessage, Message.CC_FAILED, failMessage );
    }

    public static Message createFailedMessage ( final Message inputMessage, final int commandCode, final String failMessage )
    {
        final Message msg = new Message ( commandCode );

        msg.setReplySequence ( inputMessage.getSequence () );
        msg.setValue ( Message.FIELD_ERROR_INFO, failMessage );

        return msg;
    }

    public static Message createPing ()
    {
        final Message msg = new Message ( Message.CC_PING );
        msg.getValues ().put ( "ping-data", new StringValue ( String.valueOf ( System.currentTimeMillis () ) ) );
        return msg;
    }

    public static Message createPong ( final Message inputMessage )
    {
        final Message msg = new Message ( Message.CC_PONG, inputMessage.getSequence () );
        msg.getValues ().put ( "pong-data", inputMessage.getValues ().get ( "ping-data" ) );
        return msg;
    }

    public static Message createACK ( final Message inputMessage )
    {
        return new Message ( Message.CC_ACK, inputMessage.getSequence () );
    }

}
