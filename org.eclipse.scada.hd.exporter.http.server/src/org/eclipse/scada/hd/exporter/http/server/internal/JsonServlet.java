/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.exporter.http.server.internal;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.scada.hd.exporter.http.HttpExporter;
import org.eclipse.scada.hd.exporter.http.Utils;

public class JsonServlet extends HttpServlet
{
    private static final long serialVersionUID = -2152989291571139312L;

    private final HttpExporter fallbackExporter = new NotAvailableHttpExporter ();

    private final AtomicReference<HttpExporter> exporter = new AtomicReference<HttpExporter> ( this.fallbackExporter );

    public JsonServlet ()
    {
    }

    @Override
    protected void doGet ( final HttpServletRequest request, final HttpServletResponse response ) throws ServletException, IOException
    {
        if ( request.getPathInfo () == null )
        {
            send404Error ( request, response );
            return;
        }
        if ( request.getPathInfo ().startsWith ( "/items" ) )
        {
            final String[] parts = request.getPathInfo ().split ( "/" );
            switch ( parts.length )
            {
            case 2:
                sendAvailableItems ( request, response );
                return;
            case 3:
                sendAvailableSeries ( request, response, parts[2] );
                return;
            case 4:
                sendData ( request, response, parts[2], parts[3] );
                return;
            default:
                send404Error ( request, response );
                return;
            }
        }
        else if ( request.getPathInfo ().equals ( "/info" ) )
        {
            sendInfo ( request, response );
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

    private void sendInfo ( final HttpServletRequest request, final HttpServletResponse response ) throws IOException
    {
        response.setContentType ( "text/html" );
        final PrintWriter pw = new PrintWriter ( response.getOutputStream () );
        pw.println ( "current Exporter is: " + this.exporter.get ().getClass ().getCanonicalName () );
        pw.close ();
    }

    private void sendAvailableItems ( final HttpServletRequest request, final HttpServletResponse response ) throws IOException, ServletException
    {
        setHeaders ( request, response );
        final PrintWriter pw = new PrintWriter ( response.getOutputStream () );
        try
        {
            pw.println ( Utils.gson.toJson ( this.exporter.get ().getItems () ) );
        }
        catch ( final Exception e )
        {
            throw new ServletException ( e );
        }
        pw.close ();
    }

    private void sendAvailableSeries ( final HttpServletRequest request, final HttpServletResponse response, final String itemId ) throws IOException, ServletException
    {
        setHeaders ( request, response );
        final PrintWriter pw = new PrintWriter ( response.getOutputStream () );
        try
        {
            pw.println ( Utils.gson.toJson ( this.exporter.get ().getSeries ( itemId ) ) );
        }
        catch ( final Exception e )
        {
            throw new ServletException ( e );
        }
        pw.close ();
    }

    private void sendData ( final HttpServletRequest request, final HttpServletResponse response, final String itemId, final String type ) throws IOException, ServletException
    {
        setHeaders ( request, response );
        final Date from = requiredDate ( request, "from" );
        final Date to = requiredDate ( request, "to" );
        final Integer number = requiredInteger ( request, "no" );
        final PrintWriter pw = new PrintWriter ( response.getOutputStream () );
        try
        {
            pw.println ( Utils.gson.toJson ( this.exporter.get ().getData ( itemId, type, from, to, number ) ) );
        }
        catch ( final Exception e )
        {
            throw new ServletException ( e );
        }
        pw.close ();
    }

    private void setHeaders ( final HttpServletRequest request, final HttpServletResponse response )
    {
        final String accept = request.getHeader ( "Accept" );
        if ( accept != null && accept.contains ( "application/json" ) )
        {
            response.setContentType ( "application/json" );
        }
        else
        {
            response.setContentType ( "application/javascript" );
        }
        if ( request.getAttribute ( "debug" ) != null )
        {
            response.setContentType ( "application/javascript" );
        }
        response.setCharacterEncoding ( "UTF-8" );
    }

    private String requiredString ( final HttpServletRequest request, final String parameter ) throws ServletException
    {
        final String result = request.getParameter ( parameter );
        if ( result == null )
        {
            throw new ServletException ( "parameter '" + parameter + "' does not exist" );
        }
        return result;
    }

    private Integer requiredInteger ( final HttpServletRequest request, final String parameter ) throws ServletException
    {
        final String intToParse = requiredString ( request, parameter );
        try
        {
            return Integer.parseInt ( intToParse );
        }
        catch ( final NumberFormatException e )
        {
            throw new ServletException ( "parameter '" + parameter + "' threw " + e.getMessage () );
        }
    }

    private Date requiredDate ( final HttpServletRequest request, final String parameter ) throws ServletException
    {
        final String dateToParse = requiredString ( request, parameter );
        try
        {
            return Utils.isoDateFormat.parse ( dateToParse );
        }
        catch ( final ParseException e )
        {
            throw new ServletException ( "parameter '" + parameter + "' threw " + e.getMessage () );
        }
    }

    public HttpExporter getExporter ()
    {
        return this.exporter.get ();
    }

    public void setExporter ( final HttpExporter exporter )
    {
        if ( exporter == null )
        {
            this.exporter.set ( this.fallbackExporter );
        }
        else
        {
            this.exporter.set ( exporter );
        }
    }
}