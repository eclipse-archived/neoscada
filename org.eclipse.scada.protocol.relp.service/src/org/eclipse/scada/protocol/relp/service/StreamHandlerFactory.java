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
package org.eclipse.scada.protocol.relp.service;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Calendar;

import org.eclipse.scada.protocol.syslog.Facility;
import org.eclipse.scada.protocol.syslog.Severity;
import org.eclipse.scada.protocol.syslog.SyslogMessage;

public class StreamHandlerFactory implements ReceiverHandlerFactory
{
    private final PrintWriter writer;

    public StreamHandlerFactory ( final OutputStream stream )
    {
        this.writer = new PrintWriter ( stream, true );
    }

    protected void log ( final SyslogMessage msg )
    {
        this.writer.println ( msg );
    }

    @Override
    public ReceiverHandler createHandler ()
    {
        return new ReceiverHandler () {

            @Override
            public void opened ( final ReceiverSession session )
            {
                log ( new SyslogMessage ( Facility.INTERNAL, Severity.NOTICE, Calendar.getInstance (), null, null, null, "Session opened" ) );
            }

            @Override
            public void message ( final ReceiverSession session, final SyslogMessage message )
            {
                log ( message );
            }

            @Override
            public void closed ( final ReceiverSession session )
            {
                log ( new SyslogMessage ( Facility.INTERNAL, Severity.NOTICE, Calendar.getInstance (), null, null, null, "Session closed" ) );
            }
        };
    }

}
