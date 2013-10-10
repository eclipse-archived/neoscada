/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - refactor to creating the tabular query
 *******************************************************************************/
package org.eclipse.scada.da.server.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.da.server.common.item.factory.DefaultChainItemFactory;
import org.eclipse.scada.da.server.common.item.factory.FolderItemFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractQuery
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractQuery.class );

    private final String id;

    private final int period;

    protected final String sql;

    protected final Connection connection;

    private ScheduledExecutorService timer;

    private final Runnable task;

    protected FolderItemFactory itemFactory;

    protected final Map<Integer, String> columnAliases;

    private ScheduledFuture<?> job;

    public AbstractQuery ( final String id, final int period, final String sql, final Connection connection, final Map<Integer, String> columnAliases )
    {
        this.id = id;
        this.period = period;
        this.sql = sql;
        this.connection = connection;
        this.columnAliases = columnAliases;

        logger.info ( "Created new query: {}", this.id );

        this.task = new Runnable () {

            @Override
            public void run ()
            {
                AbstractQuery.this.tick ();
            }
        };
    }

    public void register ( final ScheduledExecutorService timer, final DefaultChainItemFactory parentItemFactory )
    {
        this.timer = timer;
        this.itemFactory = parentItemFactory.createSubFolderFactory ( this.id );

        this.job = this.timer.scheduleAtFixedRate ( this.task, 0, this.period, TimeUnit.MILLISECONDS );
    }

    public void unregister ()
    {
        if ( this.job != null )
        {
            this.job.cancel ( false );
            this.job = null;
        }
        this.timer = null;

        if ( this.itemFactory != null )
        {
            this.itemFactory.dispose ();
            this.itemFactory = null;
        }
    }

    public void tick ()
    {
        try
        {
            doQuery ();
        }
        catch ( final Throwable e )
        {
            logger.debug ( "Global error", e );
            setGlobalError ( e );
        }
    }

    protected abstract void setGlobalError ( Throwable e );

    protected abstract void doQuery () throws Exception;

    protected String mapFieldName ( final int i, final ResultSet result ) throws SQLException
    {
        final String field;
        if ( this.columnAliases.containsKey ( i ) )
        {
            field = this.columnAliases.get ( i );
        }
        else
        {
            field = result.getMetaData ().getColumnName ( i );
        }
        return field;
    }

}
