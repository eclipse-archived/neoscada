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

import org.eclipse.scada.core.Variant;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Unit test for Variant JSON codec
 * 
 * @author Jens Reimann
 */
public class CodecTest
{
    private Gson gson;

    @Before
    public void setup ()
    {
        final GsonBuilder builder = new GsonBuilder ();
        builder.registerTypeAdapter ( Variant.class, new VariantJsonSerializer () );
        builder.registerTypeAdapter ( Variant.class, new VariantJsonDeserializer () );
        this.gson = builder.create ();
    }

    @Test
    public void codecNull ()
    {
        testEquals ( "null", Variant.NULL );
    }

    @Test
    public void codecBoolean ()
    {
        testEquals ( "boolean/true", Variant.TRUE );
        testEquals ( "boolean/false", Variant.FALSE );
    }

    @Test
    public void codecInt32 ()
    {
        testEquals ( "int32/0", Variant.valueOf ( 0 ) );
        testEquals ( "int32/1", Variant.valueOf ( 1 ) );
        testEquals ( "int32/-1", Variant.valueOf ( -1 ) );
        testEquals ( "int32/MAX", Variant.valueOf ( Integer.MAX_VALUE ) );
        testEquals ( "int32/MIN", Variant.valueOf ( Integer.MIN_VALUE ) );
    }

    @Test
    public void codecInt64 ()
    {
        testEquals ( "int64/0", Variant.valueOf ( 0L ) );
        testEquals ( "int64/1", Variant.valueOf ( 1L ) );
        testEquals ( "int64/-1", Variant.valueOf ( -1L ) );

        testEquals ( "int64/½MAX", Variant.valueOf ( Long.MAX_VALUE / 2L ) );
        testEquals ( "int64/½MIN", Variant.valueOf ( Long.MIN_VALUE / 2L ) );

        testEquals ( "int64/MAX", Variant.valueOf ( Long.MAX_VALUE ) );
        testEquals ( "int64/MIN", Variant.valueOf ( Long.MIN_VALUE ) );
    }

    @Test
    public void codecDouble ()
    {
        testEquals ( "double/0.0", Variant.valueOf ( 0.0 ) );
        testEquals ( "double/0.1", Variant.valueOf ( 0.1 ) );
        testEquals ( "double/-0.1", Variant.valueOf ( -0.1 ) );
    }

    @Test
    public void codecString ()
    {
        testEquals ( "string/", Variant.valueOf ( "" ) );
        testEquals ( "string/abc", Variant.valueOf ( "abc" ) );
        testEquals ( "string/  ", Variant.valueOf ( "  " ) );
        testEquals ( "string/äöü", Variant.valueOf ( "äöü" ) );
        testEquals ( "string/INT32#1", Variant.valueOf ( "INT32#1" ) );
        testEquals ( "string/{\"type\":\"BOOLEAN\",\"value\":true}", Variant.valueOf ( "{\"type\":\"BOOLEAN\",\"value\":true}" ) );
    }

    private void testEquals ( final String label, final Variant value )
    {
        final String json = this.gson.toJson ( value );
        System.out.println ( String.format ( "Encoded[%s] - '%s' -> '%s'", label, value, json ) );
        final Variant result = this.gson.fromJson ( json, Variant.class );
        Assert.assertEquals ( "Encode+Decode: " + label, value, result );
    }
}
