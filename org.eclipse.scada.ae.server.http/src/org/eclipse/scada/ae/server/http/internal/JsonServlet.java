/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.http.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.server.http.filter.EventFilter;
import org.eclipse.scada.ae.server.http.monitor.EventMonitorEvaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonServlet extends HttpServlet
{

    private final static Logger logger = LoggerFactory.getLogger ( JsonServlet.class );

    private static final long serialVersionUID = -2152989291571139312L;

    private final EventProcessor eventProcessor;

    private final EventMonitorEvaluator eventMonitorEvaluator;

    private final EventFilter eventFilter;

    public JsonServlet ( final EventProcessor eventProcessor, final EventMonitorEvaluator evaluator, final EventFilter eventFilter )
    {
        // may be null
        this.eventFilter = eventFilter;

        if ( eventProcessor == null )
        {
            throw new IllegalArgumentException ( "eventProcessor must not be null" );
        }
        if ( evaluator == null )
        {
            throw new IllegalArgumentException ( "evaluator must not be null" );
        }
        this.eventProcessor = eventProcessor;
        this.eventMonitorEvaluator = evaluator;
    }

    @Override
    protected void doPost ( final HttpServletRequest request, final HttpServletResponse response ) throws ServletException, IOException
    {
        if ( request.getPathInfo () == null )
        {
            send404Error ( request, response );
            return;
        }
        if ( request.getPathInfo ().equals ( "/publish" ) || request.getPathInfo ().equals ( "/publish/" ) )
        {
            // read input
            final BufferedReader reader = request.getReader ();
            final char[] buffer = new char[4 * 1024];
            int len;
            final StringBuilder sb = new StringBuilder ();
            while ( ( len = reader.read ( buffer, 0, buffer.length ) ) != -1 )
            {
                sb.append ( buffer, 0, len );
            }
            final Event event = EventSerializer.deserializeEvent ( sb.toString () );

            if ( this.eventFilter != null && this.eventFilter.matches ( event ) )
            {
                // filter event
                logger.trace ( "Filter discarded event: {}", event );
            }
            else
            {
                // publish event
                final Event evalEvent = this.eventMonitorEvaluator.evaluate ( event );
                this.eventProcessor.publishEvent ( evalEvent );
            }

            // return output
            response.setContentType ( "text/plain" );
            final PrintWriter pw = new PrintWriter ( response.getOutputStream () );
            pw.write ( "OK" );
            pw.close ();
        }
        else
        {
            send404Error ( request, response );
        }
    }

    private void send404Error ( final HttpServletRequest request, final HttpServletResponse response ) throws IOException
    {
        response.sendError ( HttpServletResponse.SC_NOT_FOUND );
    }
}