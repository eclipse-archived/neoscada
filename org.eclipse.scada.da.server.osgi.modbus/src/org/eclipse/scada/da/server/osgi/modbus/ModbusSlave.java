/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *     IBH SYSTEMS GmbH - some minor fixes
 *******************************************************************************/
package org.eclipse.scada.da.server.osgi.modbus;

import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.da.server.common.io.JobManager;
import org.eclipse.scada.da.server.osgi.modbus.MasterFactory.Listener;
import org.eclipse.scada.protocol.modbus.codec.ModbusProtocol;
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

    private final AtomicInteger transactionId;

    public static ModbusSlave create ( final BundleContext context, final Executor executor, final String configurationId, final Map<String, String> parameters, final MasterFactory masterFactory, final AtomicInteger transactionId )
    {
        final ModbusSlave slave = new ModbusSlave ( configurationId, context, masterFactory, executor, transactionId );
        slave.configure ( parameters );
        return slave;
    }

    public ModbusSlave ( final String id, final BundleContext context, final MasterFactory masterFactory, final Executor executor, final AtomicInteger transactionId )
    {
        this.id = id;
        this.executor = executor;
        this.context = context;
        this.masterFactory = masterFactory;
        this.transactionId = transactionId;

        synchronized ( this )
        {
            this.masterFactory.addMasterListener ( this );
        }
    }

    public void dispose ()
    {
        logger.info ( "Disposing block: {}", this.id );

        this.masterFactory.removeMasterListener ( this );
        stop ();
        for ( final ModbusRequestBlock block : this.blocks.values () )
        {
            block.dispose ();
        }
        this.blocks.clear ();

        logger.info ( "Block {} disposed", this.id );
    }

    protected synchronized void configure ( final Map<String, String> properties )
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        this.name = cfg.getString ( "name", this.id );
        this.slaveAddress = Byte.parseByte ( cfg.getStringChecked ( "slave.id", "'slave.id' must be set to a valid modbus slave id" ) );
        this.timeoutQuietPeriod = cfg.getLong ( "timeoutQuietPeriod", 10_000 );

        final ByteOrder dataOrder = ModbusProtocol.makeOrder ( cfg.getString ( "dataOrder" ), ByteOrder.BIG_ENDIAN );

        try
        {
            // we only add blocks since we are re-created on any change

            for ( final Map.Entry<String, String> entry : cfg.getPrefixed ( "block." ).entrySet () )
            {
                final Request request = parseRequest ( entry.getValue (), dataOrder );
                addBlock ( entry.getKey (), request );
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
        catch ( final Exception e )
        {
            // dispose since we might have added some blocks already
            dispose ();
            throw e;
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

    private Request parseRequest ( final String value, final ByteOrder dataOrder )
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

        return new Request ( type, startAddress, count, period, timeout, mainTypeName, eager, dataOrder );
    }

    public synchronized void start ( final ModbusMaster master, final JobManager jobManager )
    {
        logger.debug ( "Starting slave - slave: {}", this.name );

        this.master = master;
        this.jobManager = jobManager;

        for ( final Map.Entry<String, ModbusRequestBlock> entry : this.blocks.entrySet () )
        {
            this.jobManager.addBlock ( makeBlockId ( entry.getKey () ), entry.getValue () );
        }
    }

    public synchronized void stop ()
    {
        logger.debug ( "Stopping slave - slave: {}", this.name );

        if ( this.jobManager == null )
        {
            // we already are stopped
            return;
        }

        for ( final Map.Entry<String, ModbusRequestBlock> entry : this.blocks.entrySet () )
        {
            this.jobManager.removeBlock ( makeBlockId ( entry.getKey () ) );
        }

        this.master = null;
        this.jobManager = null;
    }

    protected synchronized void addBlock ( final String id, final Request request )
    {
        logger.debug ( "Adding block: {}", id );

        removeBlock ( id );

        final ModbusRequestBlock block = new ModbusRequestBlock ( this.executor, makeBlockId ( id ), this.name, request.getMainTypeName (), this, this.context, request, this.transactionId, true );

        this.blocks.put ( id, block );

        if ( this.jobManager != null )
        {
            this.jobManager.addBlock ( makeBlockId ( id ), block );
        }
    }

    private String makeBlockId ( final String id )
    {
        return this.id + "." + id;
    }

    protected synchronized void removeBlock ( final String id )
    {
        logger.trace ( "Removing block: {}", id );

        final ModbusRequestBlock block = this.blocks.remove ( id );
        if ( block != null )
        {
            logger.debug ( "Removed block: {}", id );
            if ( this.jobManager != null )
            {
                this.jobManager.removeBlock ( makeBlockId ( id ) );
            }
            block.dispose ();
        }
    }

    public Object createPollRequest ( final int transactionId, final Request request )
    {
        return new ReadRequest ( transactionId, this.slaveAddress, request.getType ().getReadFunctionCode (), request.getStartAddress (), request.getCount () );
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
