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
package org.eclipse.scada.protocol.iec60870.server.testing;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.protocol.iec60870.ProtocolOptions;
import org.eclipse.scada.protocol.iec60870.ProtocolOptions.Builder;
import org.eclipse.scada.protocol.iec60870.server.Server;
import org.eclipse.scada.protocol.iec60870.server.ServerModule;
import org.eclipse.scada.protocol.iec60870.server.data.DataModule;
import org.eclipse.scada.protocol.iec60870.server.data.DataModuleOptions;
import org.eclipse.scada.protocol.iec60870.server.data.testing.SineDataModel;

public class Application
{
    public static void main ( final String[] args ) throws Exception
    {
        final List<ServerModule> modules = new LinkedList<> ();

        final Builder builder = new ProtocolOptions.Builder ();

        final DataModuleOptions dataModuleOptions = new DataModuleOptions.Builder ().build ();

        builder.setMaxUnacknowledged ( (short)10 );
        builder.setAcknowledgeWindow ( (short) ( builder.getMaxUnacknowledged () * 0.66 ) );

        final SineDataModel dataModel = new SineDataModel ( 1000 );
        modules.add ( new DataModule ( dataModuleOptions, dataModel ) );
        try ( Server server = new Server ( (short)2404, builder.build (), modules ) )
        {
            while ( true )
            {
                Thread.sleep ( 1000 );
            }
        }
    }
}
