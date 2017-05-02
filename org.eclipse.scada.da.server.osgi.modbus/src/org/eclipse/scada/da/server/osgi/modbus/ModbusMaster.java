/*******************************************************************************
 * Copyright (c) 2013, 2015 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *     IBH SYSTEMS GmbH - added modbus TCP, fix reload issue
 *******************************************************************************/
package org.eclipse.scada.da.server.osgi.modbus;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioProcessor;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.da.server.common.io.AbstractConnectionDevice;
import org.eclipse.scada.da.server.common.io.JobManager;
import org.eclipse.scada.protocol.modbus.codec.ModbusMasterProtocolFilter;
import org.eclipse.scada.protocol.modbus.codec.ModbusRtuDecoder;
import org.eclipse.scada.protocol.modbus.codec.ModbusRtuEncoder;
import org.eclipse.scada.protocol.modbus.codec.ModbusRtuProtocolCodecFilter;
import org.eclipse.scada.protocol.modbus.codec.ModbusTcpDecoder;
import org.eclipse.scada.protocol.modbus.codec.ModbusTcpEncoder;
import org.eclipse.scada.protocol.modbus.io.ChecksumProtocolException;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModbusMaster extends AbstractConnectionDevice
{
    private final static Logger logger = LoggerFactory.getLogger ( ModbusMaster.class );

    // see modbus spec page 13, Dec 20, 2006
    // For baud rates greater than 19200 Bps, [...] a value of 1.750ms for inter-frame delay
    private final static double INTER_FRAME_DELAY_DEFAULT = 1.750/*ms*/;

    private final static String TYPE_TCP = "TCP";

    private final static String TYPE_RTU = "RTU";

    private final static List<String> allowedModbusVariants = Arrays.asList ( new String[] { TYPE_TCP, TYPE_RTU } );

    private final Set<ModbusSlave> slaves = new CopyOnWriteArraySet<> ();

    private final JobManager jobManager;

    private String name;

    private int readTimeout;

    private double interFrameDelay = INTER_FRAME_DELAY_DEFAULT;

    private String protocolType = TYPE_TCP;

    public ModbusMaster ( final BundleContext context, final String id, final ScheduledExecutorService executor, final NioProcessor processor, final String threadPrefix, final String itemPrefix )
    {
        super ( context, id, processor, executor, itemPrefix );
        this.jobManager = new JobManager ( executor );
    }

    public static ModbusMaster create ( final BundleContext context, final ScheduledExecutorService executor, final String id, final NioProcessor processor, final Map<String, String> parameters ) throws Exception
    {
        final ModbusMaster device = new ModbusMaster ( context, id, executor, processor, "ModbusMaster", "modbus" );

        try
        {
            device.configure ( parameters );
        }
        catch ( final Exception e )
        {
            // dispose what was already created
            device.dispose ();
            throw e;
        }

        return device;
    }

    public JobManager getJobManager ()
    {
        return this.jobManager;
    }

    @Override
    protected void configure ( final Map<String, String> properties ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        this.name = cfg.getString ( this.name, this.id );

        this.readTimeout = getTimeout ( properties, "readTimeout", 10000/*ms*/ );

        // only relevant for modbus RTU
        this.interFrameDelay = cfg.getDouble ( "interFrameDelay", Double.parseDouble ( System.getProperty ( "org.eclipse.scada.da.server.osgi.modbus.defaultInterFrameDelay", "" + INTER_FRAME_DELAY_DEFAULT ) ) );

        this.protocolType = cfg.getStringOfChecked ( "protocolType", TYPE_TCP, allowedModbusVariants );

        super.configure ( properties );
    }

    @Override
    protected void configureConnector ( final NioSocketConnector connector )
    {
        logger.debug ( "Configuring connector: {}", connector );

        switch ( this.protocolType )
        {
            case TYPE_TCP:
                connector.getFilterChain ().addLast ( "modbusPdu", new ProtocolCodecFilter ( new ModbusTcpEncoder (), new ModbusTcpDecoder () ) );
                connector.getFilterChain ().addLast ( "modbus", new ModbusMasterProtocolFilter () );
                break;
            case TYPE_RTU:
                // convert milliseconds to microseconds to allow more accurate timing
                final ModbusRtuDecoder rtuDecoder = new ModbusRtuDecoder ( getExecutor (), Double.valueOf ( this.interFrameDelay * 1000 ).longValue (), TimeUnit.MICROSECONDS );
                connector.getFilterChain ().addLast ( "modbusPdu", new ModbusRtuProtocolCodecFilter ( new ModbusRtuEncoder (), rtuDecoder ) );
                connector.getFilterChain ().addLast ( "modbus", new ModbusMasterProtocolFilter () );
                break;
            default:
                throw new IllegalArgumentException ( String.format ( "'%s' is not an allowed modbus device type", this.protocolType ) );
        }

        if ( Boolean.getBoolean ( "org.eclipse.scada.da.server.osgi.modbus.trace" ) )
        {
            connector.getFilterChain ().addFirst ( "logger", new LoggingFilter ( ModbusMaster.class.getName () + ".protocol" ) );
        }
    }

    public void addSlave ( final ModbusSlave slave )
    {
        logger.debug ( "Adding slave: {}", slave );

        if ( this.slaves.add ( slave ) )
        {
            slave.start ( this, this.jobManager );
        }
    }

    public void removeSlave ( final ModbusSlave slave )
    {
        logger.debug ( "Removing slave: {}", slave );

        if ( this.slaves.remove ( slave ) )
        {
            slave.stop ();
        }
    }

    public String getId ()
    {
        return this.id;
    }

    public String getName ()
    {
        return this.name;
    }

    @Override
    protected synchronized void handleSessionCreated ( final IoSession session ) throws Exception
    {
        super.handleSessionCreated ( session );
        final int timeout = this.readTimeout / 1000;
        session.getConfig ().setIdleTime ( IdleStatus.READER_IDLE, timeout );
        logger.debug ( "Setting timeout to {} seconds", timeout );
    }

    @Override
    protected synchronized void handleSessionOpened ( final IoSession session ) throws Exception
    {
        super.handleSessionOpened ( session );
        this.jobManager.setSession ( session );
    }

    @Override
    protected synchronized void handleMessageReceived ( final IoSession session, final Object message ) throws Exception
    {
        super.handleMessageReceived ( session, message );

        this.jobManager.messageReceived ( message );
    }

    @Override
    protected synchronized void handleExceptionCaught ( final IoSession session, final Throwable error ) throws Exception
    {
        if ( error instanceof ChecksumProtocolException )
        {
            checkSession ( session );

            // we don't disconnect on checksum errors
            logger.info ( "Checksum error", error );
            this.jobManager.handleException ( error );
        }
        else
        {
            super.handleExceptionCaught ( session, error );
        }
    }

    @Override
    protected synchronized void handleSessionClosed ( final IoSession session ) throws Exception
    {
        super.handleSessionClosed ( session );
        this.jobManager.setSession ( null );
    }
}
