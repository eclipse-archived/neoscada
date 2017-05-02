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
package org.eclipse.scada.ae.server.storage.postgres.internal;

import java.util.Calendar;

import org.eclipse.scada.ae.server.storage.postgres.JdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CleanUpJob implements Runnable
{
    private final static Logger logger = LoggerFactory.getLogger ( CleanUpJob.class );

    private final JdbcDao jdbcDao;

    public CleanUpJob ( final JdbcDao jdbcDao )
    {
        this.jdbcDao = jdbcDao;
    }

    public static long getCleanupPeriod ()
    {
        // default to one hour
        return Long.getLong ( "org.eclipse.scada.ae.server.storage.jdbc.cleanupPeriodSeconds", 60 * 60 );
    }

    @Override
    public void run ()
    {
        try
        {
            final int entriesDeleted = cleanupArchive ( getCleanupDays () );
            logger.info ( "Deleted {} entries", entriesDeleted );
        }
        catch ( final Exception e )
        {
            logger.error ( "Failed to clean up archive", e );
        }
    }

    /**
     * Cleanup the archive
     * 
     * @param days
     *            days in the past that should remain in the archive
     * @return the number of entries deleted or -1 if the parameters <q>days</q>
     *         was negative or zero.
     */
    private int cleanupArchive ( final int days ) throws Exception
    {
        logger.info ( "Request to clean up archive - days: {}", days );
        if ( days <= 0 )
        {
            logger.info ( "Skipping archive cleanup" );
            return -1;
        }

        final Calendar c = Calendar.getInstance ();
        c.add ( Calendar.DAY_OF_MONTH, -days );

        return this.jdbcDao.cleanUp ( c.getTime () );
    }

    private int getCleanupDays ()
    {
        // default to no cleanup
        return Integer.getInteger ( "org.eclipse.scada.ae.server.storage.jdbc.archiveDays", -1 );
    }
}
