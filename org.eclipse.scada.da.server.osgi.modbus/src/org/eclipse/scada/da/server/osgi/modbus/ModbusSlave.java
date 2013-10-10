/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.osgi.modbus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.da.server.common.io.JobManager;
import org.eclipse.scada.da.server.osgi.modbus.MasterFactory.Listener;
import org.eclipse.scada.protocol.modbus.message.ReadRequest;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModbusSlave implements Listener
{
    private final static Logger logger = LoggerFactory.getLogger ( ModbusSlave.class );

    private ModbusMaster master;

    private JobManager jobManager;

    private final BundleContext context;

    private byte slaveAddress;

    private String name;

    private final Map<String, ModbusRequestBlock> blocks = new HashMap<> ();

    private final MasterFactory masterFactory;

    private String masterId;

    private final Executor executor;

    private final String id;

    private long timeoutQuietPeriod;

    public static ModbusSlave create ( final BundleContext context, final Executor executor, final String configurationId, final Map<String, String> parameters, final MasterFactory masterFactory )
    {
        final ModbusSlave slave = new ModbusSlave ( configurationId, context, masterFactory, executor );
        slave.configure ( parameters );
        return slave;
    }

    public ModbusSlave ( final String id, final BundleContext context, final MasterFactory masterFactory, final Executor executor )
    {
        this.id = id;
        this.executor = executor;
        this.context = context;
        this.masterFactory = masterFactory;

        synchronized ( this )
        {
            this.masterFactory.addMasterListener ( this );
        }
    }

    public void dispose ()
    {
        this.masterFactory.removeMasterListener ( this );
        stop ();
    }

    protected synchronized void configure ( final Map<String, String> properties )
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        this.name = cfg.getString ( "name", this.id );
        this.slaveAddress = Byte.parseByte ( cfg.getStringChecked ( "slave.id", "'slave.id' must be set to a valid modbus slave id" ) );
        this.timeoutQuietPeriod = cfg.getLong ( "timeoutQuietPeriod", 10_000 );

        final Set<String> ids = new HashSet<> ();

        for ( final Map.Entry<String, String> entry : cfg.getPrefixed ( "block." ).entrySet () )
        {
            final Request request = parseRequest ( entry.getValue () );
            addBlock ( entry.getKey (), request );
            ids.add ( entry.getKey () );
        }

        // now remove all that are not there anymore
        final HashSet<String> currentKeys = new HashSet<> ( this.blocks.keySet () );
        currentKeys.removeAll ( ids );
        for ( final String id : currentKeys )
        {
            removeBlock ( id );
        }

        // set master device

        final String newMasterId = cfg.getStringChecked ( "modbus.master.id", "'modbus.master.id' must be set to the id of a master device" );
        if ( !newMasterId.equals ( this.masterId ) )
        {
            logger.debug ( "setting new master id: {} -> {}", this.masterId, newMasterId );

            unbindMaster ();
            this.masterId = newMasterId;
            this.masterFactory.resend ( this );
        }
    }

    @Override
    public synchronized void masterAdded ( final String id, final ModbusMaster master )
    {
        logger.debug ( "Master added: {}", id );

        if ( id.equals ( this.masterId ) )
        {
            bindMaster ( master );
        }
    }

    @Override
    public synchronized void masterRemoved ( final String id, final ModbusMaster master )
    {
        logger.debug ( "Master removed: {}", id );

        if ( id.equals ( this.masterId ) )
        {
            unbindMaster ();
        }
    }

    private void bindMaster ( final ModbusMaster master )
    {
        if ( this.master != null )
        {
            unbindMaster ();
        }
        this.master = master;
        start ( master, master.getJobManager () );
    }

    private void unbindMaster ()
    {
        stop ();
    }

    private Request parseRequest ( final String value )
    {
        // format: FC:START:COUNT:PERIOD
        // period is in "ms"

        final String[] toks = value.split ( "\\:" );
        if ( toks.length != 6 )
        {
            throw new IllegalArgumentException ( String.format ( "Format must be 'functionCode:start:count:period:timeout:mainTypeName' = ( functionCode: %s )", new Object[] { RequestType.values () } ) );
        }

        int idx = 0;
        final RequestType type = RequestType.valueOf ( toks[idx++] );
        final int startAddress = Integer.parseInt ( toks[idx++] );
        final int count = Integer.parseInt ( toks[idx++] );

        final boolean eager;
        String periodString = toks[idx++];
        if ( periodString.startsWith ( "+" ) )
        {
            eager = true;
            periodString = periodString.substring ( 1 );
        }
        else
        {
            eager = false;
        }
        final long period = Long.parseLong ( periodString );

        final long timeout = Long.parseLong ( toks[idx++] );
        final String mainTypeName = toks[idx++];

        return new Request ( type, startAddress, count, period, timeout, mainTypeName, eager );
    }

    public synchronized void start ( final ModbusMaster master, final JobManager jobManager )
    {
        logger.debug ( "Starting slave - slave: {}", this.name );

        this.master = master;
        this.jobManager = jobManager;

        for ( final Map.Entry<String, ModbusRequestBlock> entry : this.blocks.entrySet () )
        {
            jobManager.addBlock ( this.id + "." + entry.getKey (), entry.getValue () );
        }
    }

    public synchronized void stop ()
    {
        logger.debug ( "Starting slave - slave: {}", this.name );

        if ( this.jobManager == null )
        {
            return;
        }

        for ( final Map.Entry<String, ModbusRequestBlock> entry : this.blocks.entrySet () )
        {
            this.jobManager.removeBlock ( entry.getKey () );
        }

        this.master = null;
        this.jobManager = null;
    }

    protected synchronized void addBlock ( final String id, final Request request )
    {
        logger.debug ( "Adding block: {}", id );

        final ModbusRequestBlock block = new ModbusRequestBlock ( this.executor, this.id + "." + id, this.name, request.getMainTypeName (), this, this.context, request, true );

        final ModbusRequestBlock oldBlock = this.blocks.put ( id, block );

        if ( oldBlock != null )
        {
            if ( this.jobManager != null )
            {
                this.jobManager.removeBlock ( id );
            }
            oldBlock.dispose ();
        }

        if ( this.jobManager != null )
        {
            this.jobManager.addBlock ( id, block );
        }
    }

    protected synchronized void removeBlock ( final String id )
    {
        logger.debug ( "Removing block: {}", id );

        final ModbusRequestBlock block = this.blocks.remove ( id );
        if ( this.jobManager != null )
        {
            this.jobManager.removeBlock ( id );
        }
        block.dispose ();
    }

    public Object createPollRequest ( final Request request )
    {
        return new ReadRequest ( this.slaveAddress, request.getType ().getReadFunctionCode (), request.getStartAddress (), request.getCount () );
    }

    public byte getSlaveAddress ()
    {
        return this.slaveAddress;
    }

    public void writeCommand ( final Object command, final long timeout )
    {
        this.jobManager.addWriteRequest ( command, timeout );
    }

    public long getTimeoutQuietPeriod ()
    {
        return this.timeoutQuietPeriod;
    }
}
