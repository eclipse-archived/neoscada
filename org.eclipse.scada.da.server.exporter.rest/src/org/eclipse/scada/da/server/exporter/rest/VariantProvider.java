/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import org.eclipse.scada.base.json.VariantJsonDeserializer;
import org.eclipse.scada.base.json.VariantJsonSerializer;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Provider
@Produces ( value = { MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN } )
@Consumes ( value = { MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN } )
public class VariantProvider implements MessageBodyWriter<Variant>, MessageBodyReader<Variant>
{
    private final static Logger logger = LoggerFactory.getLogger ( VariantProvider.class );

    private static final MediaType[] SUPPORTED_TYPES_ARRAY = { //
    MediaType.APPLICATION_JSON_TYPE, // 
    MediaType.TEXT_PLAIN_TYPE // 
    };

    private final Gson gson;

    public VariantProvider ()
    {
        logger.debug ( "Created instance" );
        final GsonBuilder builder = new GsonBuilder ();
        builder.registerTypeAdapter ( Variant.class, new VariantJsonSerializer () );
        builder.registerTypeAdapter ( Variant.class, new VariantJsonDeserializer () );
        this.gson = builder.create ();
    }

    @Override
    public boolean isWriteable ( final Class<?> type, final Type genericType, final Annotation[] annotations, final MediaType mediaType )
    {
        logger.trace ( "isWritable" );

        return Variant.class.isAssignableFrom ( type );
    }

    @Override
    public long getSize ( final Variant t, final Class<?> type, final Type genericType, final Annotation[] annotations, final MediaType mediaType )
    {
        return -1;
    }

    @Override
    public void writeTo ( final Variant t, final Class<?> type, final Type genericType, final Annotation[] annotations, final MediaType mediaType, final MultivaluedMap<String, Object> httpHeaders, final OutputStream entityStream ) throws IOException, WebApplicationException
    {
        logger.trace ( "writeTo" );

        if ( MediaType.APPLICATION_JSON_TYPE.isCompatible ( mediaType ) )
        {
            final PrintWriter writer = new PrintWriter ( entityStream );
            writer.print ( this.gson.toJson ( t ) );
            writer.flush ();
        }
        else if ( MediaType.TEXT_PLAIN_TYPE.isCompatible ( mediaType ) )
        {
            final PrintWriter writer = new PrintWriter ( entityStream );
            writer.print ( t.toString () );
            writer.flush ();
        }
        else
        {
            throw new WebApplicationException ( Response.notAcceptable ( javax.ws.rs.core.Variant.mediaTypes ( SUPPORTED_TYPES_ARRAY ).build () ).build () );
        }
    }

    @Override
    public boolean isReadable ( final Class<?> type, final Type genericType, final Annotation[] annotations, final MediaType mediaType )
    {
        logger.trace ( "isReadable - mediaType: {}", mediaType );

        for ( final MediaType mt : SUPPORTED_TYPES_ARRAY )
        {
            if ( mt.isCompatible ( mediaType ) )
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Variant readFrom ( final Class<Variant> type, final Type genericType, final Annotation[] annotations, final MediaType mediaType, final MultivaluedMap<String, String> httpHeaders, final InputStream entityStream ) throws IOException, WebApplicationException
    {
        logger.trace ( "readFrom" );

        if ( MediaType.APPLICATION_JSON_TYPE.isCompatible ( mediaType ) )
        {
            return variantFromJson ( entityStream, mediaType.getParameters ().get ( "charset" ) );
        }
        else if ( MediaType.TEXT_PLAIN_TYPE.isCompatible ( mediaType ) )
        {
            return variantFromString ( entityStream, mediaType.getParameters ().get ( "charset" ) );
        }
        throw new WebApplicationException ( Response.notAcceptable ( javax.ws.rs.core.Variant.mediaTypes ( SUPPORTED_TYPES_ARRAY ).build () ).build () );
    }

    private Variant variantFromString ( final InputStream entityStream, String charsetName ) throws IOException
    {
        if ( charsetName == null )
        {
            charsetName = "UTF-8";
        }
        final InputStreamReader reader = new InputStreamReader ( entityStream, Charset.forName ( charsetName ) );

        final String data = CharStreams.toString ( reader );

        final VariantEditor ve = new VariantEditor ();
        ve.setAsText ( data );
        return (Variant)ve.getValue ();
    }

    private Variant variantFromJson ( final InputStream entityStream, String charsetName ) throws IOException
    {
        if ( charsetName == null )
        {
            charsetName = "UTF-8";
        }
        final InputStreamReader reader = new InputStreamReader ( entityStream, Charset.forName ( charsetName ) );

        return this.gson.fromJson ( reader, Variant.class );
    }
}
