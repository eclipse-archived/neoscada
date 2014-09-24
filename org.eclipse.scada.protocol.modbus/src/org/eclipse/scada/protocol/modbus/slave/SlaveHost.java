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
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlaveHost
{
    private final static Logger logger = LoggerFactory.getLogger ( SlaveHost.class );

    private final SimpleIoProcessorPool<NioSession> processor;

    private final SocketAcceptor acceptor;

    private final boolean disposeAcceptor;

    private final ProtocolOptions options;

    private ScheduledExecutorService executor;

    private final Map<Integer, Slave> slaves = new HashMap<> ();

    public SlaveHost ( final ProtocolOptions options, final int port ) throws IOException
    {
        this.options = makeOptions ( options );

        this.processor = new SimpleIoProcessorPool<> ( NioProcessor.class );
        this.acceptor = new NioSocketAcceptor ( this.processor );

        this.acceptor.setReuseAddress ( true );
        this.acceptor.setBacklog ( 5 );

        this.disposeAcceptor = true;

        setup ();

        this.acceptor.bind ( new InetSocketAddress ( port ) );
    }

    public SlaveHost ( final ProtocolOptions options, final SocketAddress... socketAddresses ) throws IOException
    {
        this.options = makeOptions ( options );

        this.processor = new SimpleIoProcessorPool<> ( NioProcessor.class );
        this.acceptor = new NioSocketAcceptor ( this.processor );
        this.disposeAcceptor = true;

        setup ();

        this.acceptor.bind ( socketAddresses );
    }

    private static ProtocolOptions makeOptions ( final ProtocolOptions options )
    {
        if ( options == null )
        {
            return new ProtocolOptions ();
        }

        return options; // FIXME: make clone
    }

    public SlaveHost ( final ProtocolOptions options, final SocketAcceptor acceptor )
    {
        this.options = makeOptions ( options );

        this.acceptor = acceptor;
        this.processor = null;
        this.disposeAcceptor = false;

        setup ();
    }

    private void setup ()
    {
        this.executor = Executors.newSingleThreadScheduledExecutor ();

        switch ( this.options.getMode () )
        {
            case RTU:
            {
                final ModbusRtuEncoder encoder = new ModbusRtuEncoder ();
                final ModbusRtuDecoder decoder = new ModbusRtuDecoder ( this.executor, this.options.getInterFrameDelay (), TimeUnit.MILLISECONDS );
                this.acceptor.getFilterChain ().addLast ( "modbusPdu", new ProtocolCodecFilter ( encoder, decoder ) ); //$NON-NLS-1$
            }
            break;

            case TCP:
            {
                final ModbusTcpEncoder encoder = new ModbusTcpEncoder ();
                final ModbusTcpDecoder decoder = new ModbusTcpDecoder ();
                this.acceptor.getFilterChain ().addLast ( "modbusPdu", new ProtocolCodecFilter ( encoder, decoder ) ); //$NON-NLS-1$
            }
            break;
        }

        this.acceptor.getFilterChain ().addLast ( "modbus", new ModbusSlaveProtocolFilter () ); //$NON-NLS-1$

        this.acceptor.setHandler ( new IoHandlerAdapter () {
            @Override
            public void exceptionCaught ( final IoSession session, final Throwable cause ) throws Exception
            {
                session.close ( true );
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
            public void sendReadReply ( final BaseMessage baseMessage, final int[] data )
            {
                session.write ( makeReadReply ( baseMessage, data ) );
            }

            @Override
            public void sendReadReply ( final BaseMessage baseMessage, final boolean[] data )
            {
                session.write ( makeReadReply ( baseMessage, data ) );
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

    protected Object makeReadReply ( final BaseMessage baseMessage, final int[] data )
    {
        final IoBuffer reply = IoBuffer.allocate ( data.length * 2 );
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
