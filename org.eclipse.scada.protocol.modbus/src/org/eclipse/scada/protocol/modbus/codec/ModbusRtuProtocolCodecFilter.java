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
package org.eclipse.scada.protocol.modbus.codec;

import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class ModbusRtuProtocolCodecFilter extends ProtocolCodecFilter
{
    private final ModbusRtuDecoder decoder;

    public ModbusRtuProtocolCodecFilter ( final ProtocolEncoder encoder, final ModbusRtuDecoder decoder )
    {
        super ( encoder, decoder );
        this.decoder = decoder;
    }

    @Override
    public void onPostAdd ( final IoFilterChain parent, final String name, final NextFilter nextFilter ) throws Exception
    {
        super.onPostAdd ( parent, name, nextFilter );
        this.decoder.setNextFilter ( nextFilter );
    }
}
