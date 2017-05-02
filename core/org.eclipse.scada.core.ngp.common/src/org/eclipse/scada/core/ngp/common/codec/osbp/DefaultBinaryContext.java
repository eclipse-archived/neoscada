/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *     IBH SYSTEMS GmbH - bug fixing
 *******************************************************************************/

package org.eclipse.scada.core.ngp.common.codec.osbp;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.filter.codec.ProtocolCodecException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantType;
import org.eclipse.scada.protocol.ngp.common.utils.ArrayListAllocator;
import org.eclipse.scada.protocol.ngp.common.utils.CollectionAllocator;
import org.eclipse.scada.protocol.ngp.common.utils.HashSetAllocator;
import org.eclipse.scada.utils.interner.InternerHelper;

import com.google.common.collect.Interner;

/*
 * Field numbers are written by the context but read by the protocol.
 * Therefore all encode methods put the field number but the decode
 * methods won't read them since are already read.
 */
public class DefaultBinaryContext implements BinaryContext
{

    private static final ArrayListAllocator<String> ALLOC_STRING_LIST = new ArrayListAllocator<String> ();

    private static final HashSetAllocator<String> ALLOC_STRING_SET = new HashSetAllocator<String> ();

    private static final ArrayListAllocator<Long> ALLOC_LONG_LIST = new ArrayListAllocator<Long> ();

    private static final HashSetAllocator<Long> ALLOC_LONG_SET = new HashSetAllocator<Long> ();

    private static final ArrayListAllocator<Integer> ALLOC_INT_LIST = new ArrayListAllocator<Integer> ();

    private static final HashSetAllocator<Integer> ALLOC_INT_SET = new HashSetAllocator<Integer> ();

    private static final ArrayListAllocator<Boolean> ALLOC_BOOLEAN_LIST = new ArrayListAllocator<Boolean> ();

    private static final HashSetAllocator<Boolean> ALLOC_BOOLEAN_SET = new HashSetAllocator<Boolean> ();

    private static final ArrayListAllocator<Double> ALLOC_DOUBLE_LIST = new ArrayListAllocator<Double> ();

    private static final HashSetAllocator<Double> ALLOC_DOUBLE_SET = new HashSetAllocator<Double> ();

    private static final ArrayListAllocator<Variant> ALLOC_VARIANT_LIST = new ArrayListAllocator<Variant> ();

    private static final HashSetAllocator<Variant> ALLOC_VARIANT_SET = new HashSetAllocator<Variant> ();

    private static final ArrayListAllocator<Map<String, Variant>> ALLOC_VARIANT_MAP_LIST = new ArrayListAllocator<Map<String, Variant>> ();

    private static final HashSetAllocator<Map<String, Variant>> ALLOC_VARIANT_MAP_SET = new HashSetAllocator<Map<String, Variant>> ();

    private static final ArrayListAllocator<Map<String, String>> ALLOC_PROPERTIES_LIST = new ArrayListAllocator<Map<String, String>> ();

    private static final HashSetAllocator<Map<String, String>> ALLOC_PROPERTIES_SET = new HashSetAllocator<Map<String, String>> ();

    // Main part

    private static final byte TYPE_NULL = 0x00;

    private static final byte TYPE_STRING = 0x01;

    private static final byte TYPE_STRING_LIST = 0x11;

    private static final byte TYPE_LONG = 0x02;

    private static final byte TYPE_LONG_LIST = 0x12;

    private static final byte TYPE_INT = 0x03;

    private static final byte TYPE_INT_LIST = 0x13;

    private static final byte TYPE_BOOLEAN = 0x04;

    private static final byte TYPE_BOOLEAN_LIST = 0x14;

    private static final byte TYPE_DOUBLE = 0x05;

    private static final byte TYPE_DOUBLE_LIST = 0x15;

    private static final byte TYPE_VARIANT = 0x06;

    private static final byte TYPE_VARIANT_LIST = 0x16;

    private static final byte TYPE_VARIANT_MAP = 0x07;

    private static final byte TYPE_VARIANT_MAP_LIST = 0x17;

    private static final byte TYPE_PROPERTIES = 0x08;

    private static final byte TYPE_PROPERTIES_LIST = 0x18;

    private static final byte TYPE_STRUCTURE = 0x09;

    private static final byte TYPE_STRUCTURE_LIST = 0x19;

    private static final byte TYPE_ENUM = 0x0A;

    private static final byte TYPE_ENUM_LIST = 0x1A;

    private static final byte TYPE_ENUM_SET = 0x2A;

    private static final int STRING_PREFIX_LEN = 4;

    private final CharsetEncoder encoder;

    private final CharsetDecoder decoder;

    private final Interner<String> stringInterner;

    public DefaultBinaryContext ( final Charset charset, final Interner<String> stringInterner )
    {
        this.encoder = charset.newEncoder ();
        this.decoder = charset.newDecoder ();
        this.stringInterner = stringInterner == null ? InternerHelper.makeNoOpInterner () : stringInterner;
    }

    public DefaultBinaryContext ()
    {
        this ( Charset.forName ( "UTF-8" ), InternerHelper.makeInterner ( "org.eclipse.scada.core.ngp.common.codec.osbp.stringInterner", "java" ) );
    }

    @Override
    public String getProtocolIdPart ()
    {
        return "osbp.v2";
    }

    private byte checkType ( final IoBuffer buffer, final byte expectedType, final boolean allowNull ) throws Exception
    {
        final byte type = buffer.get ();

        if ( allowNull && type == TYPE_NULL )
        {
            return type;
        }

        if ( type != expectedType )
        {
            if ( type == 0 && !allowNull )
            {
                throw new ProtocolCodecException ( String.format ( "Failed to decode. Field is transmitted as null but defined as not-null." ) );
            }

            throw new ProtocolCodecException ( String.format ( "Failed to decode string: Expected type %02x, found: %02x", expectedType, type ) );
        }
        return type;
    }

    // string

    @Override
    public void encodeString ( final IoBuffer buffer, final byte fieldNumber, final String data ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( data != null )
        {
            buffer.put ( TYPE_STRING );
            buffer.putPrefixedString ( data, STRING_PREFIX_LEN, this.encoder );
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

    @Override
    public String decodeString ( final IoBuffer buffer ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_STRING, true );

        if ( type == TYPE_NULL )
        {
            return null;
        }
        else
        {
            return this.stringInterner.intern ( buffer.getPrefixedString ( STRING_PREFIX_LEN, this.decoder ) );
        }
    }

    @Override
    public void encodeStringCollection ( final IoBuffer buffer, final byte fieldNumber, final Collection<String> data ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( data != null )
        {
            buffer.put ( TYPE_STRING_LIST );
            buffer.putInt ( data.size () );
            for ( final String entry : data )
            {
                buffer.putPrefixedString ( entry, STRING_PREFIX_LEN, this.encoder );
            }
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

    private void fillStringCollection ( final IoBuffer buffer, final int items, final Collection<String> data ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            data.add ( this.stringInterner.intern ( buffer.getPrefixedString ( STRING_PREFIX_LEN, this.decoder ) ) );
        }
    }

    private <T extends Collection<String>> T decodeStringCollection ( final IoBuffer buffer, final CollectionAllocator<String, T> allactor ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_STRING_LIST, true );

        if ( type == TYPE_NULL )
        {
            return null;
        }
        else
        {
            final int items = buffer.getInt ();
            final T result = allactor.allocate ( items );
            fillStringCollection ( buffer, items, result );
            return result;
        }
    }

    @Override
    public List<String> decodeStringList ( final IoBuffer buffer ) throws Exception
    {
        return decodeStringCollection ( buffer, ALLOC_STRING_LIST );
    }

    @Override
    public Set<String> decodeStringSet ( final IoBuffer buffer ) throws Exception
    {
        return decodeStringCollection ( buffer, ALLOC_STRING_SET );
    }

    // long

    @Override
    public void encodeLong ( final IoBuffer buffer, final byte fieldNumber, final Long data ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( data != null )
        {
            buffer.put ( TYPE_LONG );
            buffer.putLong ( data );
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

    @Override
    public Long decodeLong ( final IoBuffer buffer ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_LONG, true );

        if ( type == TYPE_NULL )
        {
            return null;
        }
        else
        {
            return buffer.getLong ();
        }
    }

    @Override
    public void encodePrimitiveLong ( final IoBuffer buffer, final byte fieldNumber, final long data ) throws Exception
    {
        buffer.put ( fieldNumber );
        buffer.put ( TYPE_LONG );
        buffer.putLong ( data );
    }

    @Override
    public long decodePrimitiveLong ( final IoBuffer buffer ) throws Exception
    {
        checkType ( buffer, TYPE_LONG, false );
        return buffer.getLong ();
    }

    @Override
    public void encodeLongCollection ( final IoBuffer buffer, final byte fieldNumber, final Collection<Long> data ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( data != null )
        {
            buffer.put ( TYPE_LONG_LIST );
            buffer.putInt ( data.size () );
            for ( final Long entry : data )
            {
                buffer.putLong ( entry );
            }
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

    private void fillLongCollection ( final IoBuffer buffer, final int items, final Collection<Long> data ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            data.add ( buffer.getLong () );
        }
    }

    private <T extends Collection<Long>> T decodeLongCollection ( final IoBuffer buffer, final CollectionAllocator<Long, T> allactor ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_LONG_LIST, true );

        if ( type == TYPE_NULL )
        {
            return null;
        }
        else
        {
            final int items = buffer.getInt ();
            final T result = allactor.allocate ( items );
            fillLongCollection ( buffer, items, result );
            return result;
        }
    }

    @Override
    public List<Long> decodeLongList ( final IoBuffer buffer ) throws Exception
    {
        return decodeLongCollection ( buffer, ALLOC_LONG_LIST );
    }

    @Override
    public Set<Long> decodeLongSet ( final IoBuffer buffer ) throws Exception
    {
        return decodeLongCollection ( buffer, ALLOC_LONG_SET );
    }

    // int

    @Override
    public void encodeInt ( final IoBuffer buffer, final byte fieldNumber, final Integer data ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( data != null )
        {
            buffer.put ( TYPE_INT );
            buffer.putInt ( data );
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

    @Override
    public Integer decodeInt ( final IoBuffer buffer ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_INT, true );

        if ( type == TYPE_NULL )
        {
            return null;
        }
        else
        {
            return buffer.getInt ();
        }
    }

    @Override
    public void encodePrimitiveInt ( final IoBuffer buffer, final byte fieldNumber, final int data ) throws Exception
    {
        buffer.put ( fieldNumber );
        buffer.put ( TYPE_INT );
        buffer.putInt ( data );
    }

    @Override
    public int decodePrimitiveInt ( final IoBuffer buffer ) throws Exception
    {
        checkType ( buffer, TYPE_INT, false );
        return buffer.getInt ();
    }

    @Override
    public void encodeIntCollection ( final IoBuffer buffer, final byte fieldNumber, final Collection<Integer> data ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( data != null )
        {
            buffer.put ( TYPE_INT_LIST );
            buffer.putInt ( data.size () );
            for ( final Integer entry : data )
            {
                buffer.putInt ( entry );
            }
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

    private void fillIntCollection ( final IoBuffer buffer, final int items, final Collection<Integer> data ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            data.add ( buffer.getInt () );
        }
    }

    private <T extends Collection<Integer>> T decodeIntCollection ( final IoBuffer buffer, final CollectionAllocator<Integer, T> allactor ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_INT_LIST, true );

        if ( type == TYPE_NULL )
        {
            return null;
        }
        else
        {
            final int items = buffer.getInt ();
            final T result = allactor.allocate ( items );
            fillIntCollection ( buffer, items, result );
            return result;
        }
    }

    @Override
    public List<Integer> decodeIntList ( final IoBuffer buffer ) throws Exception
    {
        return decodeIntCollection ( buffer, ALLOC_INT_LIST );
    }

    @Override
    public Set<Integer> decodeIntSet ( final IoBuffer buffer ) throws Exception
    {
        return decodeIntCollection ( buffer, ALLOC_INT_SET );
    }

    // boolean

    @Override
    public void encodeBoolean ( final IoBuffer buffer, final byte fieldNumber, final Boolean data ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( data != null )
        {
            buffer.put ( TYPE_BOOLEAN );
            buffer.put ( data ? (byte)0xFF : (byte)0x00 );
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

    @Override
    public Boolean decodeBoolean ( final IoBuffer buffer ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_BOOLEAN, true );

        if ( type == TYPE_NULL )
        {
            return null;
        }
        else
        {
            return buffer.get () != (byte)0x00;
        }
    }

    @Override
    public void encodePrimitiveBoolean ( final IoBuffer buffer, final byte fieldNumber, final boolean data ) throws Exception
    {
        buffer.put ( fieldNumber );
        buffer.put ( TYPE_BOOLEAN );
        buffer.put ( data ? (byte)0xFF : (byte)0x00 );
    }

    @Override
    public boolean decodePrimitiveBoolean ( final IoBuffer buffer ) throws Exception
    {
        checkType ( buffer, TYPE_BOOLEAN, false );
        return buffer.get () != (byte)0x00;
    }

    @Override
    public void encodeBooleanCollection ( final IoBuffer buffer, final byte fieldNumber, final Collection<Boolean> data ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( data != null )
        {
            buffer.put ( TYPE_BOOLEAN_LIST );
            buffer.putInt ( data.size () );
            // FIXME: encode as bit array
            for ( final Boolean entry : data )
            {
                buffer.put ( entry ? (byte)0xFF : (byte)0x00 );
            }
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

    private void fillBooleanCollection ( final IoBuffer buffer, final int items, final Collection<Boolean> data ) throws Exception
    {
        // FIXME: decode as bit array
        for ( int i = 0; i < items; i++ )
        {
            data.add ( buffer.get () != (byte)0x00 );
        }
    }

    private <T extends Collection<Boolean>> T decodeBooleanCollection ( final IoBuffer buffer, final CollectionAllocator<Boolean, T> allactor ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_BOOLEAN_LIST, true );

        if ( type == TYPE_NULL )
        {
            return null;
        }
        else
        {
            final int items = buffer.getInt ();
            final T result = allactor.allocate ( items );
            fillBooleanCollection ( buffer, items, result );
            return result;
        }
    }

    @Override
    public List<Boolean> decodeBooleanList ( final IoBuffer buffer ) throws Exception
    {
        return decodeBooleanCollection ( buffer, ALLOC_BOOLEAN_LIST );
    }

    @Override
    public Set<Boolean> decodeBooleanSet ( final IoBuffer buffer ) throws Exception
    {
        return decodeBooleanCollection ( buffer, ALLOC_BOOLEAN_SET );
    }

    // double

    @Override
    public void encodeDouble ( final IoBuffer buffer, final byte fieldNumber, final Double data ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( data != null )
        {
            buffer.put ( TYPE_DOUBLE );
            buffer.putDouble ( data );
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

    @Override
    public Double decodeDouble ( final IoBuffer buffer ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_DOUBLE, true );

        if ( type == TYPE_NULL )
        {
            return null;
        }
        else
        {
            return buffer.getDouble ();
        }
    }

    @Override
    public void encodePrimitiveDouble ( final IoBuffer buffer, final byte fieldNumber, final double data ) throws Exception
    {
        buffer.put ( fieldNumber );
        buffer.put ( TYPE_DOUBLE );
        buffer.putDouble ( data );
    }

    @Override
    public double decodePrimitiveDouble ( final IoBuffer buffer ) throws Exception
    {
        checkType ( buffer, TYPE_DOUBLE, false );
        return buffer.getDouble ();
    }

    @Override
    public void encodeDoubleCollection ( final IoBuffer buffer, final byte fieldNumber, final Collection<Double> data ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( data != null )
        {
            buffer.put ( TYPE_DOUBLE_LIST );
            buffer.putInt ( data.size () );
            for ( final Double entry : data )
            {
                buffer.putDouble ( entry );
            }
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

    private void fillDoubleCollection ( final IoBuffer buffer, final int items, final Collection<Double> data ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            data.add ( buffer.getDouble () );
        }
    }

    private <T extends Collection<Double>> T decodeDoubleCollection ( final IoBuffer buffer, final CollectionAllocator<Double, T> allactor ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_DOUBLE_LIST, true );

        if ( type == TYPE_NULL )
        {
            return null;
        }
        else
        {
            final int items = buffer.getInt ();
            final T result = allactor.allocate ( items );
            fillDoubleCollection ( buffer, items, result );
            return result;
        }
    }

    @Override
    public List<Double> decodeDoubleList ( final IoBuffer buffer ) throws Exception
    {
        return decodeDoubleCollection ( buffer, ALLOC_DOUBLE_LIST );
    }

    @Override
    public Set<Double> decodeDoubleSet ( final IoBuffer buffer ) throws Exception
    {
        return decodeDoubleCollection ( buffer, ALLOC_DOUBLE_SET );
    }

    // variant

    private void inlineEncodeVariant ( final IoBuffer buffer, final Variant variant ) throws Exception
    {
        final VariantType type = variant.getType ();
        buffer.putEnum ( type );

        switch ( type )
        {
            case BOOLEAN:
                buffer.put ( variant.asBoolean () ? (byte)0xFF : (byte)0x00 );
                break;
            case DOUBLE:
                buffer.putDouble ( variant.asDouble () );
                break;
            case INT32:
                buffer.putInt ( variant.asInteger () );
                break;
            case INT64:
                buffer.putLong ( variant.asLong () );
                break;
            case STRING:
                buffer.putPrefixedString ( variant.asString (), STRING_PREFIX_LEN, this.encoder );
                break;
            case NULL:
                break;
            case UNKNOWN:
                break;
        }
    }

    private Variant inlineDecodeVariant ( final IoBuffer buffer ) throws Exception
    {
        final VariantType type = buffer.getEnum ( VariantType.class );

        switch ( type )
        {
            case BOOLEAN:
                return Variant.valueOf ( buffer.get () != 0x00 );
            case DOUBLE:
                return Variant.valueOf ( buffer.getDouble () );
            case INT32:
                return Variant.valueOf ( buffer.getInt () );
            case INT64:
                return Variant.valueOf ( buffer.getLong () );
            case STRING:
                return Variant.valueOf ( this.stringInterner.intern ( buffer.getPrefixedString ( STRING_PREFIX_LEN, this.decoder ) ) );
            default:
                return Variant.NULL;
        }
    }

    @Override
    public void encodeVariant ( final IoBuffer buffer, final byte fieldNumber, final Variant data ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( data != null )
        {
            buffer.put ( TYPE_VARIANT );
            inlineEncodeVariant ( buffer, data );
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

    @Override
    public Variant decodeVariant ( final IoBuffer buffer ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_VARIANT, true );

        if ( type == TYPE_NULL )
        {
            return null;
        }
        else
        {
            return inlineDecodeVariant ( buffer );
        }
    }

    @Override
    public void encodeVariantCollection ( final IoBuffer buffer, final byte fieldNumber, final Collection<Variant> data ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( data != null )
        {
            buffer.put ( TYPE_VARIANT_LIST );
            buffer.putInt ( data.size () );
            for ( final Variant entry : data )
            {
                inlineEncodeVariant ( buffer, entry );
            }
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

    private void fillVariantCollection ( final IoBuffer buffer, final int items, final Collection<Variant> data ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            data.add ( inlineDecodeVariant ( buffer ) );
        }
    }

    private <T extends Collection<Variant>> T decodeVariantCollection ( final IoBuffer buffer, final CollectionAllocator<Variant, T> allactor ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_VARIANT_LIST, true );

        if ( type == TYPE_NULL )
        {
            return null;
        }
        else
        {
            final int items = buffer.getInt ();
            final T result = allactor.allocate ( items );
            fillVariantCollection ( buffer, items, result );
            return result;
        }
    }

    @Override
    public List<Variant> decodeVariantList ( final IoBuffer buffer ) throws Exception
    {
        return decodeVariantCollection ( buffer, ALLOC_VARIANT_LIST );
    }

    @Override
    public Set<Variant> decodeVariantSet ( final IoBuffer buffer ) throws Exception
    {
        return decodeVariantCollection ( buffer, ALLOC_VARIANT_SET );
    }

    // variant map

    protected void inlineEncodeVariantMap ( final IoBuffer buffer, final Map<String, Variant> data ) throws Exception
    {
        buffer.putInt ( data.size () );
        for ( final Map.Entry<String, Variant> entry : data.entrySet () )
        {
            buffer.putPrefixedString ( entry.getKey (), STRING_PREFIX_LEN, this.encoder );
            inlineEncodeVariant ( buffer, entry.getValue () );
        }
    }

    protected Map<String, Variant> inlineDecodeVariantMap ( final IoBuffer buffer ) throws Exception
    {
        final int len = buffer.getInt ();
        final Map<String, Variant> result = new HashMap<String, Variant> ( len );
        for ( int i = 0; i < len; i++ )
        {
            final String key = this.stringInterner.intern ( buffer.getPrefixedString ( STRING_PREFIX_LEN, this.decoder ) );
            final Variant value = inlineDecodeVariant ( buffer );
            result.put ( key, value );
        }
        return result;
    }

    @Override
    public void encodeVariantMap ( final IoBuffer buffer, final byte fieldNumber, final Map<String, Variant> data ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( data != null )
        {
            buffer.put ( TYPE_VARIANT_MAP );
            inlineEncodeVariantMap ( buffer, data );
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

    @Override
    public Map<String, Variant> decodeVariantMap ( final IoBuffer buffer ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_VARIANT_MAP, true );

        if ( type == TYPE_NULL )
        {
            return null;
        }
        else
        {
            return inlineDecodeVariantMap ( buffer );
        }
    }

    @Override
    public void encodeVariantMapCollection ( final IoBuffer buffer, final byte fieldNumber, final Collection<Map<String, Variant>> data ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( data != null )
        {
            buffer.put ( TYPE_PROPERTIES );
            buffer.putInt ( data.size () );
            for ( final Map<String, Variant> entry : data )
            {
                inlineEncodeVariantMap ( buffer, entry );
            }
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

    private void fillVariantMapCollection ( final IoBuffer buffer, final int items, final Collection<Map<String, Variant>> data ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            data.add ( inlineDecodeVariantMap ( buffer ) );
        }
    }

    private <T extends Collection<Map<String, Variant>>> T decodeVariantMapCollection ( final IoBuffer buffer, final CollectionAllocator<Map<String, Variant>, T> allactor ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_VARIANT_MAP_LIST, true );

        if ( type == TYPE_NULL )
        {
            return null;
        }
        else
        {
            final int items = buffer.getInt ();
            final T result = allactor.allocate ( items );
            fillVariantMapCollection ( buffer, items, result );
            return result;
        }
    }

    @Override
    public List<Map<String, Variant>> decodeVariantMapList ( final IoBuffer buffer ) throws Exception
    {
        return decodeVariantMapCollection ( buffer, ALLOC_VARIANT_MAP_LIST );
    }

    @Override
    public Set<Map<String, Variant>> decodeVariantMapSet ( final IoBuffer buffer ) throws Exception
    {
        return decodeVariantMapCollection ( buffer, ALLOC_VARIANT_MAP_SET );
    }

    // properties

    protected void inlineEncodeProperties ( final IoBuffer buffer, final Map<String, String> data ) throws Exception
    {
        buffer.putInt ( data.size () );
        for ( final Map.Entry<String, String> entry : data.entrySet () )
        {
            buffer.putPrefixedString ( entry.getKey (), STRING_PREFIX_LEN, this.encoder );
            buffer.putPrefixedString ( entry.getValue (), STRING_PREFIX_LEN, this.encoder );
        }
    }

    protected Map<String, String> inlineDecodeProperties ( final IoBuffer buffer ) throws Exception
    {
        final int len = buffer.getInt ();
        final Map<String, String> result = new HashMap<String, String> ( len );
        for ( int i = 0; i < len; i++ )
        {
            final String key = this.stringInterner.intern ( buffer.getPrefixedString ( STRING_PREFIX_LEN, this.decoder ) );
            final String value = this.stringInterner.intern ( buffer.getPrefixedString ( STRING_PREFIX_LEN, this.decoder ) );
            result.put ( key, value );
        }
        return result;
    }

    @Override
    public void encodeProperties ( final IoBuffer buffer, final byte fieldNumber, final Map<String, String> data ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( data != null )
        {
            buffer.put ( TYPE_PROPERTIES );
            inlineEncodeProperties ( buffer, data );
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

    @Override
    public Map<String, String> decodeProperties ( final IoBuffer buffer ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_PROPERTIES, true );

        if ( type == TYPE_NULL )
        {
            return null;
        }
        else
        {
            return inlineDecodeProperties ( buffer );
        }
    }

    @Override
    public void encodePropertiesCollection ( final IoBuffer buffer, final byte fieldNumber, final Collection<Map<String, String>> data ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( data != null )
        {
            buffer.put ( TYPE_PROPERTIES );
            buffer.putInt ( data.size () );
            for ( final Map<String, String> entry : data )
            {
                inlineEncodeProperties ( buffer, entry );
            }
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

    private void fillPropertiesCollection ( final IoBuffer buffer, final int items, final Collection<Map<String, String>> data ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            data.add ( inlineDecodeProperties ( buffer ) );
        }
    }

    private <T extends Collection<Map<String, String>>> T decodePropertiesCollection ( final IoBuffer buffer, final CollectionAllocator<Map<String, String>, T> allactor ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_PROPERTIES_LIST, true );

        if ( type == TYPE_NULL )
        {
            return null;
        }
        else
        {
            final int items = buffer.getInt ();
            final T result = allactor.allocate ( items );
            fillPropertiesCollection ( buffer, items, result );
            return result;
        }
    }

    @Override
    public List<Map<String, String>> decodePropertiesList ( final IoBuffer buffer ) throws Exception
    {
        return decodePropertiesCollection ( buffer, ALLOC_PROPERTIES_LIST );
    }

    @Override
    public Set<Map<String, String>> decodePropertiesSet ( final IoBuffer buffer ) throws Exception
    {
        return decodePropertiesCollection ( buffer, ALLOC_PROPERTIES_SET );
    }

    // enum

    protected void inlineEncodeEnum ( final IoBuffer data, final Enum<?> value )
    {
        data.putEnum ( value );
    }

    protected <E extends Enum<E>> E inlineDecodeEnum ( final IoBuffer data, final Class<E> enumClazz )
    {
        return data.getEnum ( enumClazz );
    }

    @Override
    public <E extends Enum<E>> void encodeEnum ( final IoBuffer buffer, final byte fieldNumber, final E value ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( value != null )
        {
            buffer.put ( TYPE_ENUM );
            inlineEncodeEnum ( buffer, value );
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

    @Override
    public <E extends Enum<E>> E decodeEnum ( final IoBuffer buffer, final Class<E> enumClazz ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_ENUM, true );
        if ( type == TYPE_NULL )
        {
            return null;
        }
        else
        {
            return inlineDecodeEnum ( buffer, enumClazz );
        }
    }

    @Override
    public <E extends Enum<E>> void encodeEnumList ( final IoBuffer buffer, final byte fieldNumber, final List<E> data ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( data != null )
        {
            buffer.put ( TYPE_ENUM_LIST );
            buffer.putInt ( data.size () );
            for ( final Enum<?> entry : data )
            {
                inlineEncodeEnum ( buffer, entry );
            }
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

    @Override
    public <E extends Enum<E>> List<E> decodeEnumList ( final IoBuffer buffer, final Class<E> enumClazz ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_ENUM_LIST, true );
        if ( type == TYPE_NULL )
        {
            return null;
        }

        final int len = buffer.getInt ();
        final List<E> result = new ArrayList<E> ( len );
        for ( int i = 0; i < len; i++ )
        {
            result.add ( inlineDecodeEnum ( buffer, enumClazz ) );
        }

        return result;
    }

    @Override
    public <E extends Enum<E>> void encodeEnumSet ( final IoBuffer buffer, final byte fieldNumber, final Set<E> data ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( data != null )
        {
            buffer.put ( TYPE_ENUM_SET );
            buffer.putEnumSetShort ( data );
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

    @Override
    public <E extends Enum<E>> Set<E> decodeEnumSet ( final IoBuffer buffer, final Class<E> enumClazz ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_ENUM_SET, true );
        if ( type == TYPE_NULL )
        {
            return null;
        }

        return buffer.getEnumSetShort ( enumClazz );
    }

    // structure

    @Override
    public boolean beginReadStructure ( final IoBuffer buffer, final boolean allowNull ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_STRUCTURE, allowNull );
        return type == TYPE_NULL;
    }

    @Override
    public void beginWriteStructure ( final IoBuffer buffer, final byte fieldNumber, final boolean isNull ) throws Exception
    {
        buffer.put ( fieldNumber );
        buffer.put ( isNull ? TYPE_NULL : TYPE_STRUCTURE );
    }

    @Override
    public Integer beginReadStructureList ( final IoBuffer buffer, final boolean allowNull ) throws Exception
    {
        final byte type = checkType ( buffer, TYPE_STRUCTURE_LIST, allowNull );
        if ( type == TYPE_NULL )
        {
            return null;
        }

        return buffer.getInt ();
    }

    @Override
    public void beginWriteStructureList ( final IoBuffer buffer, final byte fieldNumber, final Collection<?> values ) throws Exception
    {
        buffer.put ( fieldNumber );
        if ( values != null )
        {
            buffer.put ( TYPE_STRUCTURE_LIST );
            buffer.putInt ( values.size () );
        }
        else
        {
            buffer.put ( TYPE_NULL );
        }
    }

}
