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

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public final class VariantJsonSerializer implements JsonSerializer<Variant>
{
    @Override
    public JsonElement serialize ( final Variant src, final Type typeOfSrc, final JsonSerializationContext context )
    {
        if ( src == null )
        {
            return JsonNull.INSTANCE;
        }

        final JsonObject result = new JsonObject ();
        result.addProperty ( VariantJson.FIELD_TYPE, src.getType ().toString () );
        switch ( src.getType () )
        {
            case BOOLEAN:
                result.addProperty ( VariantJson.FIELD_VALUE, src.asBoolean ( null ) );
                break;
            case DOUBLE: //$FALL-THROUGH$
            case INT32: //$FALL-THROUGH$
            case INT64:
                result.addProperty ( VariantJson.FIELD_VALUE, (Number)src.getValue () );
                break;
            case STRING:
                result.addProperty ( VariantJson.FIELD_VALUE, src.asString ( null ) );
                break;
            case NULL:
                result.add ( VariantJson.FIELD_VALUE, JsonNull.INSTANCE );
                break;
            default:
                throw new RuntimeException ( String.format ( "Unknown variant type '%s' encountered", src.getType () ) );
        }
        return result;
    }
}