/*******************************************************************************
 * Copyright (c) 2013, 2014 Jürgen Rose and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jürgen Rose - initial API and implementation
 *     IBH SYSTEMS GmbH - some enhancements
 *******************************************************************************/
package org.eclipse.scada.ae.server.storage.postgres;

import java.lang.reflect.Type;
import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map.Entry;
import java.util.UUID;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Event.EventBuilder;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantEditor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class EventConverter
{
    private static class VariantSerializer implements JsonSerializer<Variant>
    {
        @Override
        public JsonElement serialize ( final Variant src, final Type typeOfSrc, final JsonSerializationContext context )
        {
            return new JsonPrimitive ( src.toString () );
        }
    }

    private static class VariantDeserializer implements JsonDeserializer<Variant>
    {
        @Override
        public Variant deserialize ( final JsonElement jsonElement, final Type typeOfDst, final JsonDeserializationContext context ) throws JsonParseException
        {
            return VariantEditor.toVariant ( jsonElement.getAsString () );
        }
    }

    private static final String isoDatePatterrn = "yyyy-MM-dd HH:mm:ss.SSS";

    private static final Gson gson = new GsonBuilder ().setDateFormat ( isoDatePatterrn ).serializeNulls ().serializeSpecialFloatingPointValues ().registerTypeAdapter ( Variant.class, new VariantSerializer () ).registerTypeAdapter ( Variant.class, new VariantDeserializer () ).create ();

    public static final EventConverter INSTANCE = new EventConverter ();

    private EventConverter ()
    {
    }

    public Event toEvent ( final String json )
    {
        return gson.fromJson ( json, Event.class );
    }

    public String toJson ( final Event event )
    {
        return gson.toJson ( event );
    }

    public Array toSqlArray ( final Connection connection, final Event event ) throws SQLException
    {
        final DateFormat isoDateFormat = new SimpleDateFormat ( isoDatePatterrn );
        final String[] fields;
        // array must be large enough to hold all attributes plus id and both time stamps
        fields = new String[ ( event.getAttributes ().size () + 3 ) * 2];
        // now populate values
        fields[0] = "id";
        fields[1] = event.getId ().toString ();
        fields[2] = "sourceTimestamp";
        fields[3] = isoDateFormat.format ( event.getSourceTimestamp () );
        fields[4] = "entryTimestamp";
        fields[5] = isoDateFormat.format ( event.getEntryTimestamp () );
        int i = 6;
        for ( final Entry<String, Variant> entry : event.getAttributes ().entrySet () )
        {
            fields[i] = entry.getKey ();
            fields[i + 1] = entry.getValue ().toString ();
            i += 2;
        }
        return connection.createArrayOf ( "text", fields );
    }

    public Event fromSqlArray ( final Array array ) throws SQLException, ParseException
    {
        final DateFormat isoDateFormat = new SimpleDateFormat ( isoDatePatterrn );
        final EventBuilder eb = Event.create ();
        final String[] fields = (String[])array.getArray ();
        for ( int i = 0; i < fields.length; i += 2 )
        {
            final String key = fields[i];
            final String value = fields[i + 1];

            if ( key.equals ( "id" ) )
            {
                eb.id ( UUID.fromString ( value ) );
            }
            else if ( key.equals ( "sourceTimestamp" ) )
            {
                eb.sourceTimestamp ( isoDateFormat.parse ( value ) );
            }
            else if ( key.equals ( "entryTimestamp" ) )
            {
                eb.entryTimestamp ( isoDateFormat.parse ( value ) );
            }
            else
            {
                eb.attribute ( key, VariantEditor.toVariant ( value ) );
            }
        }
        return eb.build ();
    }
}
