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
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.service.IoService;
import org.apache.mina.core.service.SimpleIoProcessorPool;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioProcessor;
import org.apache.mina.transport.socket.nio.NioSession;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.eclipse.scada.protocol.modbus.codec.ModbusRtuDecoder;
import org.eclipse.scada.protocol.modbus.codec.ModbusRtuEncoder;
import org.eclipse.scada.protocol.modbus.codec.ModbusSlaveProtocolFilter;
import org.eclipse.scada.protocol.modbus.codec.ModbusTcpDecoder;
import org.eclipse.scada.protocol.modbus.codec.ModbusTcpEncoder;
import org.eclipse.scada.protocol.modbus.message.BaseMessage;
import org.eclipse.scada.protocol.modbus.message.ErrorResponse;
import org.eclipse.scada.protocol.modbus.message.ReadResponse;
import org.eclipse.scada.protocol.modbus.message.WriteMultiDataRequest;
import org.eclipse.scada.protocol.modbus.message.WriteMultiDataResponse;
import org.eclipse.scada.protocol.modbus.message.WriteSingleDataRequest;
import org.eclipse.scada.protocol.modbus.message.WriteSingleDataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlaveHost
{
    private final static Logger logger = LoggerFactory.getLogger ( SlaveHost.class );

    private final SimpleIoProcessorPool<NioSession> processor;

    private final IoAcceptor acceptor;

    private final boolean disposeAcceptor;

    private final ProtocolOptions options;

    private ScheduledExecutorService executor;

    private final Map<Integer, Slave> slaves = new HashMap<> ();

    private final IoConnector connector;

    public interface SlaveHostCustomizer
    {
        public void customizeFilterChain ( DefaultIoFilterChainBuilder filterChain );
    }

    /**
     * Create a new slave host and bind to a single TCP port
     *
     * @param options
     *            optional protocol options
     * @param port
     *            the TCP port to bind to
     */
    public SlaveHost ( final ProtocolOptions options, final int port ) throws IOException
    {
        this.options = makeOptions ( options );

        this.connector = null;

        this.processor = new SimpleIoProcessorPool<> ( NioProcessor.class );
        final SocketAcceptor nioAcceptor = new NioSocketAcceptor ( this.processor );
        this.acceptor = nioAcceptor;

        nioAcceptor.setReuseAddress ( true );
        nioAcceptor.setBacklog ( 5 );

        this.disposeAcceptor = true;

        setupAcceptor ( null );

        this.acceptor.bind ( new InetSocketAddress ( port ) );
    }

    /**
     * Create a new slave host and bind to a list of socket addresses
     *
     * @param options
     *            optional protocol options
     * @param socketAddresses
     *            a list of socket addresses to bind to.
     *            <em>Note:<em> these socket addresses must be addresses of local interfaces, not remote addresses.
     */
    public SlaveHost ( final ProtocolOptions options, final SlaveHostCustomizer slaveHostCustomizer, final SocketAddress... socketAddresses ) throws IOException
    {
        this.options = makeOptions ( options );

        this.connector = null;

        this.processor = new SimpleIoProcessorPool<> ( NioProcessor.class );
        this.acceptor = new NioSocketAcceptor ( this.processor );
        this.disposeAcceptor = true;

        setupAcceptor ( slaveHostCustomizer );

        this.acceptor.bind ( socketAddresses );
    }

    /**
     * Create a new slave host <br/>
     * This constructor allows for the most flexible socket binding since the
     * caller can provide a arbitrary socket connection. In this case the caller
     * also has the responsibility of configuring and disposing the socket
     * acceptor.
     *
     * @param options
     *            optional protocol options
     * @param acceptor
     *            the socket acceptor to use
     */
    public SlaveHost ( final ProtocolOptions options, final SocketAcceptor acceptor, final SlaveHostCustomizer slaveHostCustomizer )
    {
        this.options = makeOptions ( options );

        this.connector = null;
        this.acceptor = acceptor;
        this.processor = null;
        this.disposeAcceptor = false;

        setupAcceptor ( slaveHostCustomizer );
    }

    public SlaveHost ( final ProtocolOptions options, final IoConnector connector, final SlaveHostCustomizer slaveHostCustomizer )
    {
        this.options = makeOptions ( options );

        this.connector = connector;
        this.acceptor = null;
        this.processor = null;
        this.disposeAcceptor = false;

        setupConnector ( slaveHostCustomizer );
    }

    private static ProtocolOptions makeOptions ( final ProtocolOptions options )
    {
        if ( options == null )
        {
            return new ProtocolOptions ();
        }

        return new ProtocolOptions ( options );
    }

    private void setupConnector ( final SlaveHostCustomizer slaveHostCustomizer )
    {
        setup ( this.connector, slaveHostCustomizer );
    }

    private void setupAcceptor ( final SlaveHostCustomizer slaveHostCustomizer )
    {
        setup ( this.acceptor, slaveHostCustomizer );
    }

    private void setup ( final IoService service, final SlaveHostCustomizer slaveHostCustomizer )
    {
        this.executor = Executors.newSingleThreadScheduledExecutor ();

        switch ( this.options.getMode () )
        {
            case RTU:
            {
                final ModbusRtuEncoder encoder = new ModbusRtuEncoder ();
                final ModbusRtuDecoder decoder = new ModbusRtuDecoder ( this.executor, this.options.getInterFrameDelay (), TimeUnit.MILLISECONDS );
                service.getFilterChain ().addLast ( "modbusPdu", new ProtocolCodecFilter ( encoder, decoder ) ); //$NON-NLS-1$
            }
            break;

            case TCP:
            {
                final ModbusTcpEncoder encoder = new ModbusTcpEncoder ();
                final ModbusTcpDecoder decoder = new ModbusTcpDecoder ();
                service.getFilterChain ().addLast ( "modbusPdu", new ProtocolCodecFilter ( encoder, decoder ) ); //$NON-NLS-1$
            }
            break;
        }

        service.getFilterChain ().addLast ( "modbus", new ModbusSlaveProtocolFilter () ); //$NON-NLS-1$

        if ( slaveHostCustomizer != null )
        {
            slaveHostCustomizer.customizeFilterChain ( service.getFilterChain () );
        }

        service.setHandler ( new IoHandlerAdapter () {
            @Override
            public void exceptionCaught ( final IoSession session, final Throwable cause ) throws Exception
            {
                logger.info ( "Uncaught exception", cause );
                handleExceptionCaught ( session, cause );
            };

            @Override
            public void sessionOpened ( final IoSession session ) throws Exception
            {
                logger.info ( "Session opened: {}", session ); //$NON-NLS-1$
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
                handleSessionClosed ( session );
            };

            @Override
            public void messageReceived ( final IoSession session, final Object message ) throws Exception
            {
                handleMessageReceived ( session, message );
            };
        } );
    }

    protected void handleExceptionCaught ( final IoSession session, final Throwable cause )
    {
        session.close ( true );
    }

    protected void handleMessageReceived ( final IoSession session, final Object message )
    {
        if ( ! ( message instanceof BaseMessage ) )
        {
            return;
        }

        final BaseMessage baseMessage = (BaseMessage)message;
        final Slave slave = this.slaves.get ( (int)baseMessage.getUnitIdentifier () );
        if ( slave == null )
        {
            // silently ignore
            handleInvalidSlave ( baseMessage );
            return;
        }
        slave.handleMessage ( new SessionContext () {

            @Override
            public void sendExceptionReply ( final BaseMessage baseMessage, final int exceptionCode )
            {
                session.write ( makeError ( baseMessage, exceptionCode ) );
            }

            @Override
            public void sendReadReply ( final BaseMessage baseMessage, final int[] data, final ByteOrder order )
            {
                session.write ( makeReadReply ( baseMessage, data, order ) );
            }

            @Override
            public void sendReadReply ( final BaseMessage baseMessage, final boolean[] data )
            {
                session.write ( makeReadReply ( baseMessage, data ) );
            }

            @Override
            public void sendWriteReply ( final WriteMultiDataRequest message )
            {
                final WriteMultiDataResponse reply = new WriteMultiDataResponse ( message.getTransactionId (), message.getUnitIdentifier (), message.getFunctionCode (), message.getStartAddress (), message.getNumRegisters () );
                session.write ( reply );
            }

            @Override
            public void sendWriteReply ( final WriteSingleDataRequest message )
            {
                final WriteSingleDataResponse reply = new WriteSingleDataResponse ( message.getTransactionId (), message.getUnitIdentifier (), message.getFunctionCode (), message.getAddress (), message.getData () );
                session.write ( reply );
            }
        }, baseMessage );
    }

    protected Object makeReadReply ( final BaseMessage baseMessage, final boolean[] data )
    {
        final byte[] reply = new byte[data.length / 8 + 1];

        for ( int i = 0; i < data.length; i++ )
        {
            if ( data[i] )
            {
                reply[i / 8] = (byte) ( reply[i / 8] | 1 << i % 8 );
            }
        }

        return new ReadResponse ( baseMessage.getTransactionId (), baseMessage.getUnitIdentifier (), baseMessage.getFunctionCode (), IoBuffer.wrap ( reply ) );
    }

    protected Object makeReadReply ( final BaseMessage baseMessage, final int[] data, final ByteOrder order )
    {
        final IoBuffer reply = IoBuffer.allocate ( data.length * 2 );

        reply.order ( order );

        for ( int i = 0; i < data.length; i++ )
        {
            reply.putUnsignedShort ( data[i] );
        }
        reply.flip ();
        return new ReadResponse ( baseMessage.getTransactionId (), baseMessage.getUnitIdentifier (), baseMessage.getFunctionCode (), reply );
    }

    protected Object makeError ( final BaseMessage baseMessage, final int exceptionCode )
    {
        return new ErrorResponse ( baseMessage.getTransactionId (), baseMessage.getUnitIdentifier (), baseMessage.getFunctionCode (), (byte)exceptionCode );
    }

    protected void handleInvalidSlave ( final BaseMessage baseMessage )
    {
    }

    protected void handleSessionClosed ( final IoSession session )
    {
    }

    protected void handleSessionIdle ( final IoSession session )
    {
        session.close ( true );
    }

    protected void handleSessionOpened ( final IoSession session )
    {
        final Integer idle = this.options.getReadTimeout ();

        if ( idle != null && idle > 0 )
        {
            session.getConfig ().setIdleTime ( IdleStatus.READER_IDLE, idle );
        }
    }

    public void dispose ()
    {
        if ( this.disposeAcceptor )
        {
            this.acceptor.dispose ();
        }
        if ( this.processor != null )
        {
            this.processor.dispose ();
        }
        this.executor.shutdown ();
    }

    public SlaveHandle registerSlave ( final Slave slave, final int slaveId )
    {
        if ( slaveId <= 0 || slaveId > 255 )
        {
            throw new IllegalArgumentException ( String.format ( "slaveId must be between 0 and 255" ) );
        }

        final Slave oldSlave;

        synchronized ( this )
        {
            oldSlave = this.slaves.put ( slaveId, slave );

        }
        if ( oldSlave != null )
        {
            oldSlave.dispose ();
        }

        return new SlaveHandle () {
            @Override
            public void dispose ()
            {
                unregisterSlave ( slave, slaveId );
            }
        };
    }

    protected void unregisterSlave ( final Slave slave, final int slaveId )
    {
        synchronized ( this )
        {
            if ( this.slaves.get ( slaveId ) != slave )
            {
                return;
            }
            this.slaves.remove ( slaveId );
        }
        slave.dispose ();
    }

}
