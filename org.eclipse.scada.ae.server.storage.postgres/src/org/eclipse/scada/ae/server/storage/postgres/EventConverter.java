/*******************************************************************************
 * Copyright (c) 2013 Jürgen Rose and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jürgen Rose - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.storage.postgres;

import java.lang.reflect.Type;

import org.eclipse.scada.ae.Event;
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

    public Event toEvent ( final String json )
    {
        return gson.fromJson ( json, Event.class );
    }

    public String toJson ( final Event event )
    {
        return gson.toJson ( event );
    }
}
