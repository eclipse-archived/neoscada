/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.asdu.types;

import io.netty.buffer.ByteBuf;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.eclipse.neoscada.protocol.iec60870.ProtocolOptions;

public class TypeHelper
{
    public static final double MIN_NORMALIZED_VALUE = -1;

    public static final double MAX_NORMALIZED_VALUE = 1 - Math.pow ( 2, -15 );

    public static void encodeTimestamp ( final ProtocolOptions options, final ByteBuf out, final long timestamp )
    {
        final Calendar c = new GregorianCalendar ( options.getTimeZone () );
        c.setTimeInMillis ( timestamp );

        final int ms = c.get ( Calendar.SECOND ) * 1_000 + c.get ( Calendar.MILLISECOND );
        final int minutes = c.get ( Calendar.MINUTE );
        final int hours = c.get ( Calendar.HOUR_OF_DAY );
        final int dayOfMonth = c.get ( Calendar.DAY_OF_MONTH );
        final int month = c.get ( Calendar.MONTH ) + 1;
        final int year = c.get ( Calendar.YEAR ) % 100;

        byte hourField = (byte) ( hours & 0b00011111 );

        if ( !options.isIgnoreDaylightSavingTime () )
        {
            if ( c.get ( Calendar.DST_OFFSET ) > 0 )
            {
                hourField |= 0b10000000;
            }
        }

        out.writeShort ( ms );
        out.writeByte ( minutes ); // we implicitly set "valid"
        out.writeByte ( hourField );
        out.writeByte ( dayOfMonth ); // we implicitly set dayOfWeek to zero here
        out.writeByte ( month );
        out.writeByte ( year );
    }

    public static long parseTimestamp ( final ProtocolOptions options, final ByteBuf data )
    {
        final int ms = data.readUnsignedShort ();

        int minutes = data.readUnsignedByte ();
        minutes = minutes & 0b00111111; // mask out IV and RES1

        int hours = data.readUnsignedByte ();
        hours = hours & 0b00011111; // mask out SU and RES2

        final int dayOfMonth = data.readUnsignedByte () & 0b00011111; // directly mask out dayOfWeek

        final int month = data.readUnsignedByte () & 0b00001111; // directly mask out RES3
        int year = data.readUnsignedByte () & 0b01111111; // directly mask out RES4

        /*
         * This would be the right spot for another rant on time formats ...
         * ... we simply add 2000 here since:
         * a) we assume that the software and the other side run "now" and don't
         *    transmit historical data from before 2000.
         * b) we also assume this software will be changed some time before 2114
         *    to handle this case ... so either upgrade to a different protocol by then
         *    or start your project fixing this issue by 2070 ;-)
         */
        year = year + 2000;

        final Calendar c = new GregorianCalendar ( options.getTimeZone () );
        c.set ( year, month - 1, dayOfMonth, hours, minutes, ms / 1_000 );
        c.set ( Calendar.MILLISECOND, ms % 1_000 );
        return c.getTimeInMillis ();
    }

    /**
     * Encode Single-point information with quality descriptor
     *
     * @param withTimestamp
     *            <code>true</code> if the time should be encoded as well,
     *            <code>false</code> otherwise
     */
    public static void encodeBooleanValue ( final ProtocolOptions options, final ByteBuf out, final Value<Boolean> value, final boolean withTimestamp )
    {
        byte siq = (byte) ( value.getValue () ? 0x01 : 0x00 );
        siq = value.getQualityInformation ().apply ( siq );
        out.writeByte ( siq );

        if ( withTimestamp )
        {
            encodeTimestamp ( options, out, value.getTimestamp () );
        }
    }

    /**
     * Encode Double-point information with quality descriptor
     *
     * @param withTimestamp
     *            <code>true</code> if the time should be encoded as well,
     *            <code>false</code> otherwise
     */
    public static void encodeDoublePointValue ( final ProtocolOptions options, final ByteBuf out, final Value<DoublePoint> value, final boolean withTimestamp )
    {
        byte diq = (byte) ( value.getValue ().ordinal () & 0b00000011 );
        diq = value.getQualityInformation ().apply ( diq );
        out.writeByte ( diq );

        if ( withTimestamp )
        {
            encodeTimestamp ( options, out, value.getTimestamp () );
        }
    }

    /**
     * Parse Single-point information with quality descriptor
     *
     * @param withTimestamp
     *            <code>true</code> if the time should be parsed as well,
     *            <code>false</code> otherwise
     */
    public static Value<Boolean> parseBooleanValue ( final ProtocolOptions options, final ByteBuf data, final boolean withTimestamp )
    {
        final byte siq = data.readByte ();

        final Boolean value = ( siq & 0x01 ) > 0 ? Boolean.TRUE : Boolean.FALSE; // we need to use a boolean object due to the following generic object
        final QualityInformation qualityInformation = QualityInformation.parse ( siq );

        final long timestamp = withTimestamp ? parseTimestamp ( options, data ) : System.currentTimeMillis ();

        return new Value<Boolean> ( value, timestamp, qualityInformation );
    }

    /**
     * Parse Double-point information with quality descriptor
     *
     * @param withTimestamp
     *            <code>true</code> if the time should be parsed as well,
     *            <code>false</code> otherwise
     */
    public static Value<DoublePoint> parseDoublePointValue ( final ProtocolOptions options, final ByteBuf data, final boolean withTimestamp )
    {
        final byte diq = data.readByte ();

        final DoublePoint value = DoublePoint.values ()[diq & 0b00000011];
        final QualityInformation qualityInformation = QualityInformation.parse ( diq );

        final long timestamp = withTimestamp ? parseTimestamp ( options, data ) : System.currentTimeMillis ();

        return new Value<DoublePoint> ( value, timestamp, qualityInformation );
    }

    /**
     * Encode Short floating point number with quality descriptor
     */
    public static void encodeFloatValue ( final ProtocolOptions options, final ByteBuf out, final Value<Float> value, final boolean withTimestamp )
    {
        final byte qds = (byte) ( value.isOverflow () ? 0b00000001 : 0b00000000 );
        final byte siq = value.getQualityInformation ().apply ( qds );

        out.writeFloat ( value.getValue () );
        out.writeByte ( siq );

        if ( withTimestamp )
        {
            encodeTimestamp ( options, out, value.getTimestamp () );
        }
    }

    /**
     * Parse Short floating point number with quality descriptor
     */
    public static Value<Float> parseFloatValue ( final ProtocolOptions options, final ByteBuf data, final boolean withTimestamp )
    {
        final float value = data.readFloat ();

        final byte qds = data.readByte ();

        final QualityInformation qualityInformation = QualityInformation.parse ( qds );
        final boolean overflow = ( qds & 0b00000001 ) > 0;

        final long timestamp = withTimestamp ? parseTimestamp ( options, data ) : System.currentTimeMillis ();

        return new Value<Float> ( value, timestamp, qualityInformation, overflow );
    }

    /**
     * Encode Short integer number with quality descriptor
     */
    public static void encodeScaledValue ( final ProtocolOptions options, final ByteBuf out, final Value<Short> value, final boolean withTimestamp )
    {
        final byte qds = (byte) ( value.isOverflow () ? 0b00000001 : 0b00000000 );
        final byte siq = value.getQualityInformation ().apply ( qds );

        out.writeShort ( value.getValue () );
        out.writeByte ( siq );

        if ( withTimestamp )
        {
            encodeTimestamp ( options, out, value.getTimestamp () );
        }
    }

    /**
     * Parse Short integer number with quality descriptor
     */
    public static Value<Short> parseScaledValue ( final ProtocolOptions options, final ByteBuf data, final boolean withTimestamp )
    {
        final short value = data.readShort ();

        final byte qds = data.readByte ();

        final QualityInformation qualityInformation = QualityInformation.parse ( qds );
        final boolean overflow = ( qds & 0b00000001 ) > 0;

        final long timestamp = withTimestamp ? parseTimestamp ( options, data ) : System.currentTimeMillis ();

        return new Value<Short> ( value, timestamp, qualityInformation, overflow );
    }

    /**
     * Encode Double as normalized value with quality descriptor
     */
    public static void encodeNormalizedValue ( final ProtocolOptions options, final ByteBuf out, final Value<Double> value, final boolean withTimestamp )
    {
        final boolean isOverflow;
        final short normalizedValue;
        if ( value.getValue () < MIN_NORMALIZED_VALUE )
        {
            normalizedValue = Short.MIN_VALUE;
            isOverflow = true;
        }
        else if ( value.getValue () > MAX_NORMALIZED_VALUE )
        {
            normalizedValue = Short.MAX_VALUE;
            isOverflow = true;
        }
        else
        {
            normalizedValue = (short) ( value.getValue () * 32768 );
            isOverflow = false;
        }

        final byte qds = (byte) ( ( value.isOverflow () || isOverflow ) ? 0b00000001 : 0b00000000 );
        final byte siq = value.getQualityInformation ().apply ( qds );

        out.writeShort ( normalizedValue );
        out.writeByte ( siq );

        if ( withTimestamp )
        {
            encodeTimestamp ( options, out, value.getTimestamp () );
        }
    }

    /**
     * Parse Double as normalized value with quality descriptor
     */
    public static Value<Double> parseNormalizedValue ( final ProtocolOptions options, final ByteBuf data, final boolean withTimestamp )
    {
        final short value = data.readShort ();

        final byte qds = data.readByte ();

        final QualityInformation qualityInformation = QualityInformation.parse ( qds );
        final boolean overflow = ( qds & 0b00000001 ) > 0;

        final long timestamp = withTimestamp ? parseTimestamp ( options, data ) : System.currentTimeMillis ();

        return new Value<Double> ( (double) ( value / 32768.0 ), timestamp, qualityInformation, overflow );
    }
}
