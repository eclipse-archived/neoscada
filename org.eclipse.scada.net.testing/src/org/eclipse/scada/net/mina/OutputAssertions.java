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

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public class OutputAssertions implements ProtocolEncoderOutput
{

    private final IoBuffer buffer = IoBuffer.allocate ( 0 );

    public WriteFuture flush ()
    {
        return null;
    }

    public void mergeAll ()
    {
    }

    public void write ( final Object encodedMessage )
    {
        if ( encodedMessage instanceof IoBuffer )
        {
            this.buffer.setAutoExpand ( true );
            this.buffer.put ( (IoBuffer)encodedMessage );
        }
    }

    public IoBuffer getBuffer ()
    {
        return this.buffer;
    }
}
