/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - more data types
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.modbus;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.List;
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
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.exporter.ObjectExporter;
import org.eclipse.scada.da.server.common.osgi.factory.ObjectPoolDataItemFactory;
import org.eclipse.scada.da.server.exporter.common.HiveSource;
import org.eclipse.scada.da.server.exporter.modbus.internal.InformationBean;
import org.eclipse.scada.da.server.exporter.modbus.internal.MemoryBlock;
import org.eclipse.scada.da.server.exporter.modbus.io.SourceDefinition;
import org.eclipse.scada.protocol.modbus.codec.ModbusSlaveProtocolFilter;
import org.eclipse.scada.protocol.modbus.codec.ModbusTcpDecoder;
import org.eclipse.scada.protocol.modbus.codec.ModbusTcpEncoder;
import org.eclipse.scada.protocol.modbus.message.BaseMessage;
import org.eclipse.scada.protocol.modbus.message.ErrorResponse;
import org.eclipse.scada.protocol.modbus.message.ReadRequest;
import org.eclipse.scada.protocol.modbus.message.ReadResponse;
import org.eclipse.scada.protocol.modbus.message.WriteMultiDataRequest;
import org.eclipse.scada.protocol.modbus.message.WriteMultiDataResponse;
import org.eclipse.scada.protocol.modbus.message.WriteSingleDataRequest;
import org.eclipse.scada.protocol.modbus.message.WriteSingleDataResponse;
import org.eclipse.scada.utils.osgi.pool.ManageableObjectPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ModbusExport
{
    private final static Logger logger = LoggerFactory.getLogger ( ModbusExport.class );

    private MemoryBlock block;

    private final ScheduledExecutorService executor;

    private Properties properties;

    private final HiveSource hiveSource;

    private final IoProcessor<NioSession> processor;

    private SocketAcceptor acceptor;

    private SocketAddress currentAddress;

    private short slaveId;

    private Integer readTimeout;

    private final InformationBean info = new InformationBean ();

    private ObjectExporter exporter;

    private final String logName;

    /**
     * Create a new modbus exporter
     *
     * @param executor
     *            the executor used for
     * @param processor
     *            the IO processor
     * @param hiveSource
     *            the source of the hive to export
     * @param itemFactory
     *            an optional item factory for publishing statistics
     * @param logName
     *            an optional name for logging
     */
    public ModbusExport ( final ScheduledExecutorService executor, final IoProcessor<NioSession> processor, final HiveSource hiveSource, final ObjectPoolDataItemFactory itemFactory, final String logName )
    {
        this.executor = executor;
        this.hiveSource = hiveSource;
        this.processor = processor;
        this.logName = logName != null ? logName : toString ();

        if ( itemFactory != null )
        {
            this.exporter = new ObjectExporter ( itemFactory, true, true );
            this.exporter.attachTarget ( this.info );
        }
        else
        {
            this.exporter = null;
        }
    }

    /**
     * Create a new modbus exporter
     *
     * @param executor
     *            the executor used for
     * @param processor
     *            the IO processor
     * @param hiveSource
     *            the source of the hive to export
     * @param itemFactory
     *            an optional item factory for publishing statistics
     */
    public ModbusExport ( final ScheduledExecutorService executor, final IoProcessor<NioSession> processor, final HiveSource hiveSource, final ObjectPoolDataItemFactory itemFactory )
    {
        this ( executor, processor, hiveSource, itemFactory, null );
    }

    public ModbusExport ( final String id, final ScheduledExecutorService executor, final IoProcessor<NioSession> processor, final HiveSource hiveSource, final ManageableObjectPool<DataItem> itemObjectPool )
    {
        this ( executor, processor, hiveSource, new ObjectPoolDataItemFactory ( executor, itemObjectPool, String.format ( "org.eclipse.scada.da.server.exporter.modbus.export.%s.information.", id ) ), "ModbusExporter/" + id ); //$NON-NLS-1$
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
            this.acceptor.dispose ( !Boolean.getBoolean ( "org.eclipse.scada.da.server.exporter.modbus.dontWaitDispose" ) ); //$NON-NLS-1$
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

    protected void setReadTimeout ( final Integer readTimeout )
    {
        this.readTimeout = readTimeout;
    }

    protected void setSlaveId ( final short slaveId )
    {
        logger.debug ( "Setting slave id: {}", slaveId ); //$NON-NLS-1$
        this.slaveId = slaveId;
    }

    protected void setPort ( final int port ) throws IOException
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

    protected void setBlockConfiguration ( final List<SourceDefinition> defs )
    {
        this.block.setConfiguration ( defs );
    }

    protected void setProperties ( final Properties properties )
    {
        if ( this.block == null )
        {
            logger.debug ( "Create new block" ); //$NON-NLS-1$
            this.block = new MemoryBlock ( this.executor, this.hiveSource, properties, this.logName );
        }
        else if ( !this.properties.equals ( properties ) )
        {
            // we do need to create a new hive session
            logger.debug ( "Re-create block" ); //$NON-NLS-1$
            this.block.dispose ();
            this.block = null;
            this.block = new MemoryBlock ( this.executor, this.hiveSource, properties, this.logName );
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
            // silently ignore
            return;
        }

        if ( message instanceof ReadRequest )
        {
            this.info.incrementReadRequestReceived ();
            handleRead ( session, (ReadRequest)message );
        }
        else if ( message instanceof WriteSingleDataRequest )
        {
            this.info.incrementWriteRequestSingleReceived ();
            handleWrite ( session, (WriteSingleDataRequest)message );
        }
        else if ( message instanceof WriteMultiDataRequest )
        {
            this.info.incrementWriteRequestMultiReceived ();
            handleWrite ( session, (WriteMultiDataRequest)message );
        }
    }

    private void handleWrite ( final IoSession session, final WriteMultiDataRequest message )
    {
        switch ( message.getFunctionCode () )
        {
            case 16:
                writeRegister ( session, message );
                break;
            default:
                logger.info ( "Function code {} is not implemented", message.getFunctionCode () ); //$NON-NLS-1$
                sendReply ( session, makeError ( message, 0x01 ) );
                break;
        }
    }

    private void handleWrite ( final IoSession session, final WriteSingleDataRequest message )
    {
        switch ( message.getFunctionCode () )
        {
            case 6:
                writeRegister ( session, message );
                break;
            default:
                logger.info ( "Function code {} is not implemented", message.getFunctionCode () ); //$NON-NLS-1$
                sendReply ( session, makeError ( message, 0x01 ) );
                break;
        }
    }

    private void writeRegister ( final IoSession session, final WriteSingleDataRequest message )
    {
        final IoBuffer buffer = IoBuffer.allocate ( 2 );
        buffer.putUnsignedShort ( message.getValue () );
        buffer.flip ();
        final int rc = performWrite ( message.getAddress (), buffer );

        if ( rc != 0 )
        {
            sendReply ( session, makeError ( message, rc ) );
            return;
        }

        final WriteSingleDataResponse response = new WriteSingleDataResponse ( message.getTransactionId (), message.getUnitIdentifier (), message.getFunctionCode (), message.getAddress (), message.getValue () );
        sendReply ( session, response );
    }

    private void writeRegister ( final IoSession session, final WriteMultiDataRequest message )
    {
        final int rc = performWrite ( message.getStartAddress (), IoBuffer.wrap ( message.getData () ) );

        if ( rc != 0 )
        {
            sendReply ( session, makeError ( message, rc ) );
            return;
        }

        final WriteMultiDataResponse response = new WriteMultiDataResponse ( message.getTransactionId (), message.getUnitIdentifier (), message.getFunctionCode (), message.getStartAddress (), message.getNumRegisters () );
        sendReply ( session, response );
    }

    private int performWrite ( final int address, final IoBuffer buffer )
    {
        return this.block.write ( address, buffer );
    }

    private void handleRead ( final IoSession session, final ReadRequest message )
    {
        switch ( message.getFunctionCode () )
        {
            case 3:
                this.info.incrementReadHoldingRequestReceived ();
                readHoldingData ( session, message );
                break;
            case 4:
                this.info.incrementReadInputRequestReceived ();
                // for now we return holding data
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
