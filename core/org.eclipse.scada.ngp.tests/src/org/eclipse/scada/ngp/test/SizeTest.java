/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ngp.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.serialization.ObjectSerializationEncoder;
import org.eclipse.scada.hd.data.message.UpdateQueryData;
import org.eclipse.scada.ngp.test.hd.DataGenerator;
import org.junit.Test;

public class SizeTest
{
    public static class TestingOutput implements ProtocolEncoderOutput
    {
        private final LinkedList<Object> queue = new LinkedList<Object> ();

        @Override
        public void write ( final Object data )
        {
            this.queue.add ( data );
        }

        @Override
        public void mergeAll ()
        {
        }

        @Override
        public WriteFuture flush ()
        {
            return null;
        }

        public long getSize ()
        {
            long size = 0;
            for ( final Object data : this.queue )
            {
                if ( data instanceof IoBuffer )
                {
                    size += ( (IoBuffer)data ).remaining ();
                }
                else
                {
                    throw new IllegalArgumentException ( "Can only handle IoBuffers" );
                }
            }
            return size;
        }
    }

    @Test
    public void test1 () throws Exception
    {
        final DataGenerator dg = new DataGenerator ( new HashSet<String> ( Arrays.asList ( "AVG", "MIN", "MAX" ) ), 1200 );
        final UpdateQueryData message = dg.createData ();

        final ProtocolEncoder encoder = new ObjectSerializationEncoder ();
        testEncoder ( encoder, message );
    }

    private void testEncoder ( final ProtocolEncoder encoder, final Object message ) throws Exception
    {
        final TestingOutput output = new TestingOutput ();
        encoder.encode ( null, message, output );
        System.out.println ( String.format ( "Encoder %s: %s bytes", encoder, output.getSize () ) );
    }
}
