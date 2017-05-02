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
package org.eclipse.scada.protocol.modbus.slave;

import java.io.IOException;

import org.eclipse.scada.protocol.modbus.slave.ProtocolOptions;
import org.eclipse.scada.protocol.modbus.slave.SlaveHost;
import org.junit.Test;

public class SlaveTest
{

    @Test
    public void test1 () throws IOException
    {
        final ProtocolOptions options = new ProtocolOptions ();
        final SlaveHost slave = new SlaveHost ( options, 1502 );
        try
        {
        }
        finally
        {
            slave.dispose ();
        }
    }

    @Test
    public void test2 () throws IOException, InterruptedException
    {
        final ProtocolOptions options = new ProtocolOptions ();
        final SlaveHost slave = new SlaveHost ( options, 1502 );

        slave.registerSlave ( new TimeDataSlave (), 1 );

        try
        {
            Thread.sleep ( Integer.getInteger ( "stayActive", 0 ) );
        }
        finally
        {
            slave.dispose ();
        }
    }
}
