/*******************************************************************************
 * Copyright (c) 2006, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.concurrent;

import java.lang.management.ManagementFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecutorServiceExporterImpl implements ExecutorServiceExporterMXBean
{

    private final static Logger logger = LoggerFactory.getLogger ( ExecutorServiceExporterImpl.class );

    private final MBeanServer mbs;

    private ObjectName name;

    private final ExecutorService executorService;

    public ExecutorServiceExporterImpl ( final ExecutorService executorService, final String key )
    {
        this.executorService = executorService;
        this.mbs = ManagementFactory.getPlatformMBeanServer ();

        try
        {
            this.name = new ObjectName ( "org.eclipse.scada.utils.concurrent", "executorService", key );
            this.mbs.registerMBean ( this, this.name );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to export", e );
        }
    }

    public void dispose ()
    {
        try
        {
            this.mbs.unregisterMBean ( this.name );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to unregister: " + this.name, e );
        }

    }

    @Override
    public Integer getActiveCount ()
    {
        if ( this.executorService instanceof ThreadPoolExecutor )
        {
            return ( (ThreadPoolExecutor)this.executorService ).getActiveCount ();
        }
        return null;
    }

    @Override
    public Long getCompletedTaskCount ()
    {
        if ( this.executorService instanceof ThreadPoolExecutor )
        {
            return ( (ThreadPoolExecutor)this.executorService ).getCompletedTaskCount ();
        }
        return null;
    }

    @Override
    public Integer getCorePoolSize ()
    {
        if ( this.executorService instanceof ThreadPoolExecutor )
        {
            return ( (ThreadPoolExecutor)this.executorService ).getCorePoolSize ();
        }
        return null;
    }

    @Override
    public Integer getLargestPoolSize ()
    {
        if ( this.executorService instanceof ThreadPoolExecutor )
        {
            return ( (ThreadPoolExecutor)this.executorService ).getLargestPoolSize ();
        }
        return null;
    }

    @Override
    public Integer getMaximumPoolSize ()
    {
        if ( this.executorService instanceof ThreadPoolExecutor )
        {
            return ( (ThreadPoolExecutor)this.executorService ).getMaximumPoolSize ();
        }
        return null;
    }

    @Override
    public Integer getPoolSize ()
    {
        if ( this.executorService instanceof ThreadPoolExecutor )
        {
            return ( (ThreadPoolExecutor)this.executorService ).getPoolSize ();
        }
        return null;
    }

    @Override
    public Long getTaskCount ()
    {
        if ( this.executorService instanceof ThreadPoolExecutor )
        {
            return ( (ThreadPoolExecutor)this.executorService ).getTaskCount ();
        }
        return null;
    }

    @Override
    public Integer getQueueSize ()
    {
        if ( this.executorService instanceof ThreadPoolExecutor )
        {
            return ( (ThreadPoolExecutor)this.executorService ).getQueue ().size ();
        }
        return null;
    }

    @Override
    public String getStatusString ()
    {
        return this.executorService.toString ();
    }

}
