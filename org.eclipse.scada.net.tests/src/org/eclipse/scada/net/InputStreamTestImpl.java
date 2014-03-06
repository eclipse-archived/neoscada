/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - fix test case
 *******************************************************************************/
package org.eclipse.scada.net;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.mina.core.service.DefaultTransportMetadata;
import org.apache.mina.core.session.DummySession;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.eclipse.scada.net.mina.GMPPProtocolDecoder;
import org.eclipse.scada.net.mina.GMPPProtocolEncoder;

public class InputStreamTestImpl
{
    private List<BytePacketTestImpl> pseudoStream = new ArrayList<BytePacketTestImpl> ();

    public InputStreamTestImpl ()
    {
        super ();
    }

    public InputStreamTestImpl ( final Collection<BytePacketTestImpl> packetList )
    {
        this.pseudoStream = new ArrayList<BytePacketTestImpl> ( packetList );
    }

    public void clear ()
    {
        this.pseudoStream.clear ();
    }

    public void add ( final BytePacketTestImpl packet )
    {
        this.pseudoStream.add ( packet );
    }

    public void run ( final GMPPProtocolDecoder decoder, final GMPPProtocolEncoder encoder, final ProtocolDecoderOutput in ) throws Exception
    {
        final DummySession session = new DummySession ();
        session.setTransportMetadata ( new DefaultTransportMetadata ( "eclipse.scada", "test", false, true, SocketAddress.class, IoSessionConfig.class, Object.class ) );

        BytePacketTestImpl packet;
        final Iterator<BytePacketTestImpl> i = this.pseudoStream.iterator ();
        while ( i.hasNext () )
        {
            packet = i.next ();
            packet.process ( session, decoder, encoder, in );
        }
    }
}
