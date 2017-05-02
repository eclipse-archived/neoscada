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
package org.eclipse.scada.ae.server.syslog;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Event.EventBuilder;
import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.ae.server.handler.InjectionContext;
import org.eclipse.scada.ae.server.injector.EventInjectorQueue;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.protocol.relp.service.Receiver;
import org.eclipse.scada.protocol.relp.service.ReceiverHandler;
import org.eclipse.scada.protocol.relp.service.ReceiverHandlerFactory;
import org.eclipse.scada.protocol.relp.service.ReceiverSession;
import org.eclipse.scada.protocol.syslog.SyslogMessage;

public class ReceiverService
{
    private final EventInjectorQueue injector;

    private final Receiver receiver;

    private final ReceiverHandlerFactory factory = new ReceiverHandlerFactory () {

        @Override
        public ReceiverHandler createHandler ()
        {
            return new ReceiverHandler () {

                @Override
                public void opened ( final ReceiverSession session )
                {
                    handleOpened ( session );
                }

                @Override
                public void closed ( final ReceiverSession session )
                {
                    handleClosed ( session );
                }

                @Override
                public void message ( final ReceiverSession session, final SyslogMessage message )
                {
                    handleMessage ( session, message );
                }
            };
        }
    };

    public ReceiverService ( final EventInjectorQueue injector, final ReceiverConfiguration cfg )
    {
        this.injector = injector;

        if ( isLocal ( cfg.getHost () ) )
        {
            this.receiver = new Receiver ( this.factory, new InetSocketAddress ( InetAddress.getLoopbackAddress (), cfg.getPort () ) );
        }
        else if ( isWildcard ( cfg.getHost () ) )
        {
            this.receiver = new Receiver ( this.factory, new InetSocketAddress ( cfg.getPort () ) );
        }
        else
        {
            this.receiver = new Receiver ( this.factory, new InetSocketAddress ( cfg.getHost (), cfg.getPort () ) );
        }
    }

    private static boolean isLocal ( final String host )
    {
        if ( host == null )
        {
            return true;
        }
        if ( host.isEmpty () )
        {
            return true;
        }
        return host.equals ( "*local*" );
    }

    private static boolean isWildcard ( final String host )
    {
        if ( host.equals ( "*" ) || host.equals ( "*all*" ) )
        {
            return true;
        }
        return false;
    }

    protected void fillCommon ( final EventBuilder builder, final ReceiverSession session )
    {

        builder.attribute ( Event.Fields.ACTOR_TYPE, "SYSTEM" );
        builder.attribute ( Event.Fields.ACTOR_NAME, "SYSLOG" );
        builder.attribute ( Event.Fields.SYSTEM, makeAddressString ( session ) );
    }

    protected static String makeAddressString ( final ReceiverSession session )
    {
        final InetSocketAddress ra = session.getRemoteAddress ();
        return String.format ( "%s:%s", ra.getHostString (), ra.getPort () );
    }

    protected void handleOpened ( final ReceiverSession session )
    {
        final EventBuilder builder = Event.create ();

        fillCommon ( builder, session );

        builder.attribute ( Event.Fields.EVENT_TYPE, "CON" );
        builder.attribute ( Event.Fields.MESSAGE, "Syslog session opened" );

        this.injector.injectEvent ( builder.build (), makeContext () );
    }

    protected void handleClosed ( final ReceiverSession session )
    {
        final EventBuilder builder = Event.create ();

        fillCommon ( builder, session );

        builder.attribute ( Event.Fields.EVENT_TYPE, "DIS" );
        builder.attribute ( Event.Fields.MESSAGE, "Syslog session closed" );

        this.injector.injectEvent ( builder.build (), makeContext () );
    }

    protected void handleMessage ( final ReceiverSession session, final SyslogMessage message )
    {
        final Severity sev = convert ( message.getSeverity () );
        if ( sev == null )
        {
            // ignore message
            return;
        }

        final EventBuilder builder = Event.create ();

        fillCommon ( builder, session );

        builder.attribute ( Event.Fields.EVENT_TYPE, "LOG" );
        builder.attribute ( Event.Fields.MESSAGE, message.getMessage () );
        builder.attribute ( Event.Fields.SEVERITY, sev );
        builder.attribute ( Event.Fields.SOURCE, makeSource ( message ) );

        builder.attribute ( "level.0", message.getHostname () );
        builder.attribute ( "level.1", message.getProcessName () );
        if ( message.getProcessName () != null )
        {
            // only set level if parent was set
            builder.attribute ( "level.2", message.getProcessId () );
        }

        builder.sourceTimestamp ( message.getTimestamp ().getTime () );

        this.injector.injectEvent ( builder.build (), makeContext () );
    }

    private InjectionContext makeContext ()
    {
        return new InjectionContext.Builder ().sourceModule ( "org.eclipse.scada.ae.server.syslog" ).build ();
    }

    private Variant makeSource ( final SyslogMessage message )
    {
        final String name = message.getProcessName ();
        final Long id = message.getProcessId ();

        if ( name != null && id != null )
        {
            return Variant.valueOf ( String.format ( "%s:%s", name, id ) );
        }
        if ( name != null )
        {
            return Variant.valueOf ( name );
        }
        return null;
    }

    private Severity convert ( final org.eclipse.scada.protocol.syslog.Severity severity )
    {
        switch ( severity )
        {
            case EMERGENCY:
            case ALERT:
            case CRITICAL:
            case ERROR:
                return Severity.ERROR;
            case WARNING:
                return Severity.WARNING;
            case NOTICE:
            case INFORMATIONAL:
            case DEBUG:
                return Severity.INFORMATION;
            default:
                return Severity.ERROR;
        }
    }

    public void dispose ()
    {
        this.receiver.close ();
    }
}
