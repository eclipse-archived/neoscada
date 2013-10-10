/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.net.mina;

import org.eclipse.scada.net.base.data.IntegerValue;
import org.eclipse.scada.net.base.data.ListValue;
import org.eclipse.scada.net.base.data.MapValue;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.base.data.Value;
import org.eclipse.scada.net.codec.InvalidValueTypeException;
import org.eclipse.scada.net.mina.GMPPProtocolEncoder;
import org.junit.Test;

public class Test1
{

    public static void main ( final String[] args ) throws InvalidValueTypeException
    {
        new Test1 ().test1 ();
    }

    @Test
    public void test1 () throws InvalidValueTypeException
    {
        final GMPPProtocolEncoder encoder = new GMPPProtocolEncoder ();

        final Message message = createMessage ( 250 );

        encode ( encoder, message );
    }

    private void encode ( final GMPPProtocolEncoder encoder, final Message message ) throws InvalidValueTypeException
    {
        encoder.code ( message );
    }

    private Message createMessage ( final int count )
    {
        final Message message = new Message ( 0 );

        message.getValues ().put ( "values", createValue ( count ) );

        return message;
    }

    private Value createValue ( final int count )
    {
        final MapValue value = new MapValue ();

        final ListValue list = new ListValue ();
        for ( int i = 0; i < count; i++ )
        {
            final MapValue v = new MapValue ();
            for ( int j = 0; j < count; j++ )
            {
                v.put ( String.format ( "test%d", j ), createScalarValue ( j * i ) );
            }
            list.add ( v );
        }

        value.put ( "list", list );
        return value;
    }

    public Value createScalarValue ( final int index )
    {
        return IntegerValue.valueOf ( index );
    }
}
