/*******************************************************************************
 * Copyright (c) 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.pkg.deb;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public interface TimestampProvider
{
    long getModTime ();

    static DefaultTimestampProvider DEFAULT_TIMESTAMP_PROVIDER = new DefaultTimestampProvider ();

    /**
     * just use the current time, but for all files of the instance
     */
    public final class DefaultTimestampProvider implements TimestampProvider
    {
        private final long now = System.currentTimeMillis ();

        @Override
        public long getModTime ()
        {
            return now / 1000;
        }
    }

    /**
     * specify specific instant
     */
    public final class SpecificTimestampProvider implements TimestampProvider
    {
        private final long ts;

        public SpecificTimestampProvider ( long millis )
        {
            this.ts = millis;
        }

        public SpecificTimestampProvider ( Date date )
        {
            this.ts = date.getTime ();
        }

        public SpecificTimestampProvider ( Calendar calendar )
        {
            this.ts = calendar.getTimeInMillis ();
        }

        @Override
        public long getModTime ()
        {
            return ts / 1000;
        }
    }

    /**
     * use new year of the specified year 00:00:00.000
     */
    public final class SpecificYearTimestampProvider implements TimestampProvider
    {
        private final long newYear;

        public SpecificYearTimestampProvider ( int year )
        {
            GregorianCalendar cal = new GregorianCalendar ();
            cal.set ( Calendar.DAY_OF_YEAR, 1 );
            cal.set ( Calendar.HOUR_OF_DAY, 0 );
            cal.set ( Calendar.MINUTE, 0 );
            cal.set ( Calendar.SECOND, 0 );
            cal.set ( Calendar.MILLISECOND, 0 );
            cal.set ( Calendar.YEAR, year );
            newYear = cal.getTimeInMillis ();
        }

        @Override
        public long getModTime ()
        {
            return newYear / 1000;
        }
    }
}
