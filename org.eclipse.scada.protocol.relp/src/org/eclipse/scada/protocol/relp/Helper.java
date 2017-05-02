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
package org.eclipse.scada.protocol.relp;

import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

import org.eclipse.scada.protocol.syslog.Constants;
import org.eclipse.scada.protocol.syslog.time.PatternTimestampParser;
import org.eclipse.scada.protocol.syslog.time.TimestampParser;

public final class Helper
{
    private Helper ()
    {
    }

    static String encodeResponseString ( final String string )
    {
        return string.replace ( Constants.LF_STRING, "#010" );
    }

    private static Pattern RELP_PATTERN = Pattern.compile ( "(?<year>\\d{4})-(?<month>\\d{2})-(?<day>\\d{2})T(?<hour>\\d{2}):(?<minute>\\d{2}):(?<second>\\d{2})\\.(?<subsec>\\d{1,6})(?<tz>.*)" );

    public static final TimestampParser RELP = new PatternTimestampParser ( RELP_PATTERN, Constants.SP, StandardCharsets.US_ASCII );

}
