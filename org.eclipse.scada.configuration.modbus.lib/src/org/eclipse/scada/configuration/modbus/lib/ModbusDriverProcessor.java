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
package org.eclipse.scada.configuration.modbus.lib;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.modbus.ModbusBlock;
import org.eclipse.scada.configuration.modbus.ModbusDriver;
import org.eclipse.scada.configuration.modbus.ModbusMaster;
import org.eclipse.scada.configuration.modbus.ModbusSlave;
import org.eclipse.scada.configuration.modbus.ProtocolType;
import org.eclipse.scada.utils.str.StringHelper;
import org.eclipse.scada.configuration.generator.world.oscar.EquinoxApplicationProcessor;
import org.eclipse.scada.configuration.generator.world.oscar.OscarContext;

public class ModbusDriverProcessor extends EquinoxApplicationProcessor
{
    private final ModbusDriver driver;

    public ModbusDriverProcessor ( final ModbusDriver driver )
    {
        super ( driver );
        this.driver = driver;
    }

    @Override
    protected void processForContext ( final OscarContext ctx, final IFolder output, final IProgressMonitor monitor ) throws Exception
    {
        for ( final ModbusMaster device : this.driver.getMasters () )
        {
            createDevice ( ctx, device );
        }
    }

    private void createDevice ( final OscarContext ctx, final ModbusMaster device )
    {
        final Map<String, String> data = new HashMap<> ();

        final String id = device.getId ();

        data.put ( "host", device.getEndpoint ().getNode ().getHostName () );
        data.put ( "port", "" + device.getEndpoint ().getPortNumber () );
        data.put ( "protocolType", device.getProtocolType ().getLiteral () );
        if ( device.getProtocolType () != ProtocolType.TCP && device.getInterFrameDelay () != null )
        {
            data.put ( "interFrameDelay", "" + device.getInterFrameDelay () );
        }

        ctx.addData ( "org.eclipse.scada.da.server.osgi.modbus.masterDevice", id, data );

        for ( final ModbusSlave slave : device.getSlaves () )
        {
            createSlave ( ctx, device, slave );
        }
    }

    private void createSlave ( final OscarContext ctx, final ModbusMaster master, final ModbusSlave slave )
    {
        final Map<String, String> data = new HashMap<> ();

        final String id = slave.getId ();

        data.put ( "modbus.master.id", master.getId () );
        data.put ( "slave.id", "" + slave.getUnitAddress () );

        for ( final ModbusBlock block : slave.getBlocks () )
        {
            final List<String> toks = new LinkedList<> ();

            toks.add ( block.getBlockType ().toString () );
            toks.add ( "" + block.getStartAddress () );
            toks.add ( "" + block.getCount () );
            toks.add ( "" + block.getPeriod () );
            toks.add ( "" + block.getTimeout () );
            toks.add ( "" + block.getType ().getName () );

            data.put ( "block." + block.getId (), StringHelper.join ( toks, ":" ) );
        }

        ctx.addData ( "org.eclipse.scada.da.server.osgi.modbus.slaveDevice", id, data );
    }
}
