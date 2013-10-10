/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.slave.inject;

import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.utils.concurrent.ScheduledExportedExecutorService;
import org.osgi.service.jdbc.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventInjector
{

    private final static Logger logger = LoggerFactory.getLogger ( EventInjector.class );

    private final JdbcStorageDao storage;

    private final ScheduledExportedExecutorService scheduler;

    public EventInjector ( final DataSourceFactory factory, final Properties properties, final int delay ) throws SQLException
    {
        logger.info ( "Starting event injector" ); //$NON-NLS-1$
        this.storage = new JdbcStorageDao ( factory, properties, false, null );
        this.scheduler = new ScheduledExportedExecutorService ( "org.eclipse.scada.ae.slave.inject", 1 ); //$NON-NLS-1$

        this.scheduler.scheduleWithFixedDelay ( new Runnable () {

            @Override
            public void run ()
            {
                process ();
            }
        }, 0, delay, TimeUnit.MILLISECONDS );
    }

    public void dispose ()
    {
        logger.info ( "Disposing event injector ..." ); //$NON-NLS-1$

        this.scheduler.shutdown ();
        this.storage.dispose ();

        logger.info ( "Disposing event injector ... done!" ); //$NON-NLS-1$
    }

    private void process ()
    {
        try
        {
            final int result = EventInjector.this.storage.runOnce ();
            if ( result > 0 )
            {
                logger.info ( "Processed {} entries", result );
            }
            else
            {
                logger.debug ( "Processed {} entries", result );
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to process", e );
        }
    }

}
