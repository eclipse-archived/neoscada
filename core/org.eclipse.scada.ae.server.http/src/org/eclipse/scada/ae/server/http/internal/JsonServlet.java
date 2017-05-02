/*******************************************************************************
 * Copyright (c) 2010, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - generalize event injection
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
import org.eclipse.scada.ae.server.handler.InjectionContext;
import org.eclipse.scada.ae.server.injector.EventInjectorQueue;

public class JsonServlet extends HttpServlet
{
    private static final long serialVersionUID = -2152989291571139312L;

    private final EventInjectorQueue injector;

    public JsonServlet ( final EventInjectorQueue injector )
    {
        this.injector = injector;
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

            this.injector.injectEvent ( event, new InjectionContext.Builder ().sourceModule ( "org.eclipse.scada.ae.server.http" ).build () );

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