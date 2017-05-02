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
package org.eclipse.scada.base.json;

import java.lang.reflect.Type;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantEditor;
import org.eclipse.scada.core.VariantType;
import org.eclipse.scada.utils.str.StringHelper;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

public class VariantJsonDeserializer implements JsonDeserializer<Variant>
{

    @Override
    public Variant deserialize ( final JsonElement json, final Type typeOfT, final JsonDeserializationContext context ) throws JsonParseException
    {
        if ( json.isJsonNull () )
        {
            return null;
        }

        if ( json instanceof JsonPrimitive )
        {
            return decodeFromPrimitive ( json );
        }

        if ( json instanceof JsonObject )
        {
            final JsonObject jsonObj = (JsonObject)json;
            final JsonElement type = jsonObj.get ( VariantJson.FIELD_TYPE );
            final JsonElement value = jsonObj.get ( VariantJson.FIELD_VALUE );

            if ( type == null || type.isJsonNull () )
            {
                if ( value == null )
                {
                    throw new JsonParseException ( String.format ( "Variant encoded as object must have a field '%s'", VariantJson.FIELD_VALUE ) );
                }
                return Variant.valueOf ( value.getAsString () );
            }

            if ( !type.isJsonPrimitive () )
            {
                throw new JsonParseException ( String.format ( "Variant field '%s' must be a string containing the variant type (%s)", VariantJson.FIELD_TYPE, StringHelper.join ( VariantType.values (), ", " ) ) );
            }

            final String typeStr = type.getAsString ();

            if ( typeStr.equals ( "NULL" ) )
            {
                return Variant.NULL;
            }

            if ( value == null || value.isJsonNull () )
            {
                throw new JsonParseException ( String.format ( "The type '%s' does not support a null value. Use variant type NULL instead.", typeStr ) );
            }

            if ( value.isJsonObject () || value.isJsonArray () )
            {
                throw new JsonParseException ( "The variant value must be a JSON primitive matching the type. Arrays and objects are not supported" );
            }

            switch ( type.getAsString () )
            {
                case "BOOLEAN":
                    return Variant.valueOf ( value.getAsBoolean () );
                case "STRING":
                    return Variant.valueOf ( value.getAsString () );
                case "DOUBLE":
                    return Variant.valueOf ( value.getAsDouble () );
                case "INT32":
                    return Variant.valueOf ( value.getAsInt () );
                case "INT64":
                    return Variant.valueOf ( value.getAsLong () );
                default:
                    throw new JsonParseException ( String.format ( "Type '%s' is unknown (known types: %s)", StringHelper.join ( VariantType.values (), ", " ) ) );
            }
        }

        throw new JsonParseException ( "Unknown serialization of Variant type" );
    }

    private Variant decodeFromPrimitive ( final JsonElement json )
    {
        final JsonPrimitive jsonPrim = (JsonPrimitive)json;
        if ( jsonPrim.isBoolean () )
        {
            return Variant.valueOf ( jsonPrim.getAsBoolean () );
        }
        else if ( jsonPrim.isNumber () )
        {
            return Variant.valueOf ( jsonPrim.getAsNumber () );
        }
        else
        {
            return VariantEditor.toVariant ( jsonPrim.getAsString () );
        }
    }
}
