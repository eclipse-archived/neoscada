/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.net.mina;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.eclipse.scada.net.mina.GMPPProtocolDecoder;
import org.eclipse.scada.net.mina.GMPPProtocolEncoder;

public class InputStreamTestImpl
{
    private List<BytePacketTestImpl> _pseudoStream = new ArrayList<BytePacketTestImpl> ();

    /**
     * 
     */
    public InputStreamTestImpl ()
    {
        super ();
    }

    public InputStreamTestImpl ( final Collection<BytePacketTestImpl> packetList )
    {
        this._pseudoStream = new ArrayList<BytePacketTestImpl> ( packetList );
    }

    public void clear ()
    {
        this._pseudoStream.clear ();
    }

    public void add ( final BytePacketTestImpl packet )
    {
        this._pseudoStream.add ( packet );
    }

    public void run ( final GMPPProtocolDecoder decoder, final GMPPProtocolEncoder encoder, final ProtocolDecoderOutput in ) throws Exception
    {
        BytePacketTestImpl packet;
        final Iterator<BytePacketTestImpl> i = this._pseudoStream.iterator ();
        while ( i.hasNext () )
        {
            packet = i.next ();
            packet.process ( decoder, encoder, in );
        }
    }
}
