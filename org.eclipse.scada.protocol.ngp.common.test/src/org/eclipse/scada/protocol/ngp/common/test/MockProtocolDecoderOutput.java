/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.common.test;

import java.util.LinkedList;
import java.util.List;

import org.apache.mina.core.filterchain.IoFilter.NextFilter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.eclipse.scada.protocol.ngp.common.mc.frame.Frame;
import org.junit.Assert;

/**
 * A protocol decoder output that will simply capture the protocol output
 */
public class MockProtocolDecoderOutput implements ProtocolDecoderOutput
{
    private final List<Object> messages = new LinkedList<> ();

    @Override
    public void write ( final Object message )
    {
        this.messages.add ( message );
    }

    @Override
    public void flush ( final NextFilter nextFilter, final IoSession session )
    {
        // NO-OP
    }

    public void assertMessages ( final Frame[] messages )
    {
        Assert.assertEquals ( "Number of messages", messages.length, this.messages.size () );

        final Object[] received = this.messages.toArray ( new Object[this.messages.size ()] );

        for ( int i = 0; i < messages.length; i++ )
        {
            Assert.assertTrue ( "Message is of type 'Frame'", received[i] instanceof Frame );
            final Frame frame = (Frame)received[i];

            Assert.assertEquals ( "Frame Type", messages[i].getType (), frame.getType () );
            Assert.assertEquals ( "Frame Data", messages[i].getData ().getHexDump (), frame.getData ().getHexDump () );
        }
    }

}
