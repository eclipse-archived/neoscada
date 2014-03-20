/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.modbus;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ScheduledExecutorService;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.service.IoProcessor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSession;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.exporter.ObjectExporter;
import org.eclipse.scada.da.server.common.osgi.factory.ObjectPoolDataItemFactory;
import org.eclipse.scada.da.server.exporter.common.HiveSource;
import org.eclipse.scada.da.server.exporter.modbus.io.DoubleType;
import org.eclipse.scada.da.server.exporter.modbus.io.MemoryBlock;
import org.eclipse.scada.da.server.exporter.modbus.io.ShortType;
import org.eclipse.scada.da.server.exporter.modbus.io.SourceDefinition;
import org.eclipse.scada.da.server.exporter.modbus.io.SourceType;
import org.eclipse.scada.da.server.exporter.modbus.io.UnsignedShortType;
import org.eclipse.scada.protocol.modbus.codec.ModbusSlaveProtocolFilter;
import org.eclipse.scada.protocol.modbus.codec.ModbusTcpDecoder;
import org.eclipse.scada.protocol.modbus.codec.ModbusTcpEncoder;
import org.eclipse.scada.protocol.modbus.message.BaseMessage;
import org.eclipse.scada.protocol.modbus.message.ErrorResponse;
import org.eclipse.scada.protocol.modbus.message.ReadRequest;
import org.eclipse.scada.protocol.modbus.message.ReadResponse;
import org.eclipse.scada.utils.osgi.pool.ManageableObjectPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModbusExport
{
    private final static Logger logger = LoggerFactory.getLogger ( ModbusExport.class );

    private MemoryBlock block;

    private final ScheduledExecutorService executor;

    private Properties properties;

    private final HiveSource hiveSource;

    private final IoProcessor<NioSession> processor;

    private SocketAcceptor acceptor;

    private SocketAddress currentAddress;

    private int slaveId;

    private Integer readTimeout;

    private final InformationBean info = new InformationBean ();

    private ObjectExporter exporter;

    public ModbusExport ( final String id, final ScheduledExecutorService executor, final IoProcessor<NioSession> processor, final HiveSource hiveSource, final ManageableObjectPool<DataItem> itemObjectPool )
    {
        this.executor = executor;
        this.hiveSource = hiveSource;
        this.processor = processor;

        final ObjectPoolDataItemFactory itemFactory = new ObjectPoolDataItemFactory ( executor, itemObjectPool, String.format ( "org.eclipse.scada.da.server.exporter.modbus.export.%s.information.", id ) ); //$NON-NLS-1$
        this.exporter = new ObjectExporter ( itemFactory, true, true );
        this.exporter.attachTarget ( this.info );
    }

    public void dispose ()
    {
        logger.debug ( "Disposing" ); //$NON-NLS-1$

        if ( this.exporter != null )
        {
            // the exporter also disposes the item factory
            this.exporter.dispose ();
            this.exporter = null;
        }
        disposeAcceptor ();
        if ( this.block != null )
        {
            this.block.dispose ();
            this.block = null;
        }
    }

    private void disposeAcceptor ()
    {
        if ( this.acceptor != null )
        {
            this.acceptor.dispose ( !Boolean.getBoolean ( "org.eclipse.scada.da.server.exporter.modbus.dontWaitDispose" ) );
            this.acceptor = null;
        }
    }

    private void createAcceptor ()
    {
        final NioSocketAcceptor acceptor = new NioSocketAcceptor ( this.processor );
        try
        {
            acceptor.setReuseAddress ( true );
            acceptor.setBacklog ( Integer.getInteger ( "org.eclipse.scada.da.server.exporter.modbus.acceptor.backlog", 5 ) ); //$NON-NLS-1$

            final ModbusTcpEncoder encoder = new ModbusTcpEncoder ();
            final ModbusTcpDecoder decoder = new ModbusTcpDecoder ();
            acceptor.getFilterChain ().addLast ( "modbusPdu", new ProtocolCodecFilter ( encoder, decoder ) ); //$NON-NLS-1$
            acceptor.getFilterChain ().addLast ( "modbus", new ModbusSlaveProtocolFilter () ); //$NON-NLS-1$

            acceptor.setHandler ( new IoHandlerAdapter () {
                @Override
                public void exceptionCaught ( final IoSession session, final Throwable cause ) throws Exception
                {
                    session.close ( true );
                };

                @Override
                public void sessionOpened ( final IoSession session ) throws Exception
                {
                    logger.info ( "Session opened: {}", session ); //$NON-NLS-1$
                    ModbusExport.this.info.incrementActiveSessions ();
                    handleSessionOpened ( session );
                };

                @Override
                public void sessionIdle ( final IoSession session, final IdleStatus status ) throws Exception
                {
                    logger.info ( "Session idle: {}", session ); //$NON-NLS-1$
                    handleSessionIdle ( session );
                };

                @Override
                public void sessionClosed ( final IoSession session ) throws Exception
                {
                    logger.info ( "Session closed: {}", session ); //$NON-NLS-1$
                    ModbusExport.this.info.decrementActiveSessions ();
                };

                @Override
                public void messageReceived ( final IoSession session, final Object message ) throws Exception
                {
                    handleMessageReceived ( session, message );
                };
            } );
            this.acceptor = acceptor;
            this.acceptor.bind ( this.currentAddress );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to create acceptor", e );
            this.acceptor.dispose ();
            throw new RuntimeException ( e );
        }
    }

    public void update ( final Map<String, String> parameters ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );
        setReadTimeout ( cfg.getInteger ( "timeout", 10_000 ) ); //$NON-NLS-1$
        setPort ( cfg.getInteger ( "port", 502 ) ); //$NON-NLS-1$ 
        setSlaveId ( cfg.getInteger ( "slaveId", 1 ) ); //$NON-NLS-1$
        setProperties ( cfg.getPrefixedProperties ( "hive." ) ); //$NON-NLS-1$
        configureDefinitions ( cfg );
    }

    private void setReadTimeout ( final Integer readTimeout )
    {
        this.readTimeout = readTimeout;
    }

    private void setSlaveId ( final int slaveId )
    {
        logger.debug ( "Setting slave id: {}", slaveId ); //$NON-NLS-1$
        this.slaveId = slaveId;
    }

    private void setPort ( final int port ) throws IOException
    {
        final SocketAddress address = new InetSocketAddress ( port );

        if ( this.currentAddress == null || !this.currentAddress.equals ( address ) )
        {
            logger.info ( "Rebinding interface - {} to {}", this.currentAddress, address ); //$NON-NLS-1$
            disposeAcceptor ();
            this.currentAddress = address;
            createAcceptor ();
        }
    }

    private void configureDefinitions ( final ConfigurationDataHelper cfg )
    {
        final List<SourceDefinition> defs = new LinkedList<> ();

        for ( final Map.Entry<String, String> entry : cfg.getPrefixed ( "item." ).entrySet () ) //$NON-NLS-1$
        {
            final String itemId = entry.getKey ();
            final String[] args = entry.getValue ().split ( ":" ); //$NON-NLS-1$
            logger.info ( "Adding - itemId: {}, arguments: {}", itemId, args ); //$NON-NLS-1$
            defs.add ( convert ( itemId, args ) );
        }

        this.block.setConfiguration ( defs );
    }

    private SourceDefinition convert ( final String itemId, final String[] args )
    {
        final int offset = Integer.parseInt ( args[0] );
        final SourceType type;

        switch ( args[1].toUpperCase () )
        {
            case "DOUBLE": //$NON-NLS-1$
                type = new DoubleType ( getFactor ( args ) );
                break;
            case "INT16": //$NON-NLS-1$
            case "SHORT": //$NON-NLS-1$
                type = new ShortType ( getFactor ( args ) );
                break;
            case "UINT16": //$NON-NLS-1$
            case "WORD": //$NON-NLS-1$
                type = new UnsignedShortType ( getFactor ( args ) );
                break;
            default:
                throw new IllegalArgumentException ( String.format ( "Type '%s' is unknown.", args[1] ) ); //$NON-NLS-1$
        }

        return new SourceDefinition ( itemId, offset, type );
    }

    private Double getFactor ( final String[] args )
    {
        if ( args.length > 2 )
        {
            return Double.parseDouble ( args[2] );
        }
        return null;
    }

    private void setProperties ( final Properties properties )
    {
        if ( this.block == null )
        {
            logger.debug ( "Create new block" ); //$NON-NLS-1$
            this.block = new MemoryBlock ( this.executor, this.hiveSource, properties );
        }
        else if ( !this.properties.equals ( properties ) )
        {
            // we do need to create a new hive session
            logger.debug ( "Re-create block" ); //$NON-NLS-1$
            this.block.dispose ();
            this.block = null;
            this.block = new MemoryBlock ( this.executor, this.hiveSource, properties );
        }
        this.properties = properties;
    }

    protected void handleSessionOpened ( final IoSession session )
    {
        Integer idle = this.readTimeout;
        if ( idle != null )
        {
            idle = idle / 1000;
            if ( idle < 0 )
            {
                idle = 1;
            }
            logger.debug ( "Setting read idle timeout: {} second(s)", idle ); //$NON-NLS-1$
            session.getConfig ().setIdleTime ( IdleStatus.READER_IDLE, idle );
        }
    }

    protected void handleSessionIdle ( final IoSession session )
    {
        logger.info ( "Closing session due to reader timeout" );
        session.close ( true );
    }

    protected void handleMessageReceived ( final IoSession session, final Object message )
    {
        logger.trace ( "New message - message: {}, session: {}", message, session ); //$NON-NLS-1$

        this.info.incrementMessagesReceived ();

        if ( ! ( message instanceof BaseMessage ) )
        {
            return;
        }

        final BaseMessage baseMessage = (BaseMessage)message;
        if ( baseMessage.getUnitIdentifier () != this.slaveId )
        {
            logger.trace ( "Invalid unit id - use: {}, them: {}", this.slaveId, baseMessage.getUnitIdentifier () ); //$NON-NLS-1$
            return;
        }

        if ( message instanceof ReadRequest )
        {
            this.info.incrementReadRequestReceived ();
            handleRead ( session, (ReadRequest)message );
        }
    }

    private void handleRead ( final IoSession session, final ReadRequest message )
    {
        switch ( message.getFunctionCode () )
        {
            case 3:
                this.info.incrementReadHoldingRequestReceived ();
                readHoldingData ( session, message );
                break;
            default:
                logger.info ( "Function code {} is not implemented", message.getFunctionCode () ); //$NON-NLS-1$
                sendReply ( session, makeError ( message, 0x01 ) );
                break;
        }
    }

    protected void readHoldingData ( final IoSession session, final ReadRequest message )
    {
        final int byteOffset = message.getStartAddress () * 2;
        final int byteLength = message.getQuantity () * 2;

        logger.debug ( "Reading - byteOffset: {}, byteLength: {}", byteOffset, byteLength ); //$NON-NLS-1$

        if ( message.getQuantity () < 0 || message.getQuantity () >= 0x7D )
        {
            logger.debug ( "Invalid quanity" ); //$NON-NLS-1$
            sendReply ( session, makeError ( message, 0x02 ) );
            return;
        }

        final IoBuffer data = this.block.readData ( byteOffset, byteLength );
        if ( data == null )
        {
            logger.debug ( "No data" ); //$NON-NLS-1$
            sendReply ( session, makeError ( message, 0x04 ) );
        }
        else
        {
            // reply data
            sendReply ( session, makeData ( message, data ) );
        }
    }

    protected Object makeData ( final BaseMessage message, final IoBuffer data )
    {
        data.flip ();

        logger.trace ( "Create data message - data: {}", data ); //$NON-NLS-1$
        return new ReadResponse ( message.getTransactionId (), message.getUnitIdentifier (), message.getFunctionCode (), data );
    }

    protected ErrorResponse makeError ( final BaseMessage message, final int exceptionCode )
    {
        this.info.incrementErrorReplies ();

        byte functionCode = message.getFunctionCode ();
        functionCode |= (byte)0x80;
        return new ErrorResponse ( message.getTransactionId (), message.getUnitIdentifier (), functionCode, (byte)exceptionCode );
    }

    protected void sendReply ( final IoSession session, final Object message )
    {
        logger.trace ( "Send reply - message: {}, session: {}", message, session ); //$NON-NLS-1$ 
        session.write ( message );
    }

}
