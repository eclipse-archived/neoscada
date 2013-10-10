/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.hd.server.storage.slave.hds;

import java.io.File;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.scada.hd.server.common.HistoricalItem;
import org.eclipse.scada.hd.server.storage.hds.AbstractStorageImpl;
import org.eclipse.scada.hds.DataFilePool;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StorageImpl extends AbstractStorageImpl
{

    private final static Logger logger = LoggerFactory.getLogger ( StorageImpl.class );

    private final ServiceRegistration<HistoricalItem> handle;

    public StorageImpl ( final BundleContext context, final File file, final DataFilePool pool, final ScheduledExecutorService queryExecutor, final ScheduledExecutorService eventExecutor ) throws Exception
    {
        super ( file, pool, queryExecutor, eventExecutor );

        // register with OSGi
        final Dictionary<String, Object> properties = new Hashtable<String, Object> ( 2 );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        properties.put ( Constants.SERVICE_PID, this.id );
        this.handle = context.registerService ( HistoricalItem.class, this, properties );
    }

    @Override
    public void dispose ()
    {
        this.handle.unregister ();
        super.dispose ();
    }

    private final Pattern fileNamePattern = Pattern.compile ( "([0-9a-zA-Z]+)\\.hds" );

    public void fileDeleted ( final File file )
    {
        logger.info ( "File changed: {}", file );

        final Matcher m = this.fileNamePattern.matcher ( file.getName () );
        if ( !m.matches () )
        {
            logger.info ( "Filename did not match pattern" );
            return;
        }

        final long start = Long.parseLong ( m.group ( 1 ), 16 );

        final long slice = getStorageInformation ().getConfiguration ().getTimeSlice ();

        logger.info ( "File change {} to {}", start, start + slice );
        handleStoreChanged ( new Date ( start ), new Date ( start + slice ) );
    }

    public void fileChanged ( final File file )
    {
        // FIXME: should use file content for notification
        fileDeleted ( file );
    }

}
