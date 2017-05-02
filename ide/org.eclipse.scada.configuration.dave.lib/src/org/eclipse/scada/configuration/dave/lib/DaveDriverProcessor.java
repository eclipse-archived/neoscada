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
package org.eclipse.scada.configuration.dave.lib;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.dave.DaveCommunicationProcessor;
import org.eclipse.scada.configuration.dave.DaveDriver;
import org.eclipse.scada.configuration.dave.DaveRequestBlock;
import org.eclipse.scada.configuration.world.lib.oscar.EquinoxApplicationProcessor;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;

public class DaveDriverProcessor extends EquinoxApplicationProcessor
{
    private final DaveDriver driver;

    public DaveDriverProcessor ( final DaveDriver driver )
    {
        super ( driver );
        this.driver = driver;
    }

    @Override
    protected void processForContext ( final OscarContext ctx, final IFolder output, final IProgressMonitor monitor ) throws Exception
    {
        for ( final DaveCommunicationProcessor device : this.driver.getDevices () )
        {
            createDevice ( ctx, device );
        }
    }

    private void createDevice ( final OscarContext ctx, final DaveCommunicationProcessor device )
    {
        final Map<String, String> data = new HashMap<> ();

        final String id = device.getId ();

        data.put ( "host", device.getEndpoint ().getNode ().getHostName () );
        data.put ( "port", "" + device.getEndpoint ().getPortNumber () );
        data.put ( "readTimeout", "" + device.getReadTimeout () );
        data.put ( "rack", "" + device.getRack () );
        data.put ( "slot", "" + device.getSlot () );
        data.put ( "name", device.getId () );

        ctx.addData ( "org.eclipse.scada.da.server.dave.device", id, data );

        for ( final DaveRequestBlock block : device.getBlocks () )
        {
            createSlave ( ctx, device, block );
        }
    }

    private void createSlave ( final OscarContext ctx, final DaveCommunicationProcessor device, final DaveRequestBlock block )
    {
        final Map<String, String> data = new HashMap<> ();

        final String id = block.getId ();

        data.put ( "daveDevice", device.getId () );
        data.put ( "area", "" + block.getArea () );
        data.put ( "count", "" + block.getLength () );
        data.put ( "enableStatistics", "" + block.isEnableStatistics () );
        data.put ( "start", "" + block.getOffset () );
        data.put ( "name", block.getName () );
        data.put ( "block", "" + block.getBlock () );
        data.put ( "type", "" + block.getType ().getName () );

        ctx.addData ( "org.eclipse.scada.da.server.dave.block", id, data );
    }
}
