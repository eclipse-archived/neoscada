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
package org.eclipse.scada.protocol.syslog.time;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.CodecException;

import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatternTimestampParser implements TimestampParser
{
    private final static Logger logger = LoggerFactory.getLogger ( PatternTimestampParser.class );

    private final Pattern pattern;

    private final byte endMarker;

    private final Charset charset;

    public PatternTimestampParser ( final Pattern pattern, final byte endMarker, final Charset charset )
    {
        this.pattern = pattern;
        this.endMarker = endMarker;
        this.charset = charset;
    }

    @Override
    public Calendar parseTimestamp ( final ByteBuf data )
    {
        final int index = data.bytesBefore ( this.endMarker );
        if ( index < 0 )
        {
            throw new CodecException ( "Unable to find timestamp" );
        }

        final String timestampString = data.readSlice ( index ).toString ( this.charset );

        logger.debug ( "Timestamp string: '{}'", timestampString );

        final Matcher m = this.pattern.matcher ( timestampString );
        if ( !m.matches () )
        {
            throw new CodecException ( "Timestamp string does not match pattern: " + this.pattern.pattern () );
        }

        final int year = Integer.parseInt ( m.group ( "year" ) );
        final int month = Integer.parseInt ( m.group ( "month" ) ) - 1;
        final int day = Integer.parseInt ( m.group ( "day" ) );
        final int hour = Integer.parseInt ( m.group ( "hour" ) );
        final int minute = Integer.parseInt ( m.group ( "minute" ) );
        final int second = Integer.parseInt ( m.group ( "second" ) );
        final int ms = Integer.parseInt ( m.group ( "subsec" ) ) / 1000;

        TimeZone timezone = TimeZone.getDefault ();
        final String tz = m.group ( "tz" );
        if ( !tz.isEmpty () )
        {
            // FIXME: implement
            if ( "Z".equals ( tz ) )
            {
                timezone = TimeZone.getTimeZone ( "UTC" );
            }
            else
            {
                timezone = TimeZone.getTimeZone ( "GMT" + tz );
            }
        }

        final Calendar c = new GregorianCalendar ( year, month, day, hour, minute, second );
        c.setTimeZone ( timezone );
        c.set ( Calendar.MILLISECOND, ms );

        // skip marker byte
        data.skipBytes ( 1 );

        return c;
    }

}
