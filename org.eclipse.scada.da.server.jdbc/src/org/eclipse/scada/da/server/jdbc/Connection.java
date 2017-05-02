/*******************************************************************************
 * Copyright (c) 2010, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - add JDBC properties
 *******************************************************************************/
package org.eclipse.scada.da.server.jdbc;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Properties;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.item.factory.DefaultChainItemFactory;

public class Connection
{
    private final Collection<AbstractQuery> queries = new LinkedList<AbstractQuery> ();

    private final Collection<Update> updates = new LinkedList<Update> ();

    private final String uri;

    private final String id;

    private DefaultChainItemFactory itemFactory;

    private final Integer timeout;

    private final ConnectionFactory connectionFactory;

    private final String connectionClass;

    private final Properties properties;

    public Connection ( final ConnectionFactory connectionFactory, final String id, final Integer timeout, final String connectionClass, final String uri, final Properties properties )
    {
        this.connectionFactory = connectionFactory;
        this.uri = uri;
        this.properties = properties;
        this.id = id;
        this.timeout = timeout;
        this.connectionClass = connectionClass;
    }

    public void add ( final AbstractQuery query )
    {
        this.queries.add ( query );
    }

    public void register ( final Hive hive, final FolderCommon rootFolder, final ScheduledExecutorService timer )
    {
        this.itemFactory = new DefaultChainItemFactory ( hive, rootFolder, this.id, this.id );

        for ( final AbstractQuery query : this.queries )
        {
            query.register ( timer, this.itemFactory );
        }

        for ( final Update update : this.updates )
        {
            update.register ( this.itemFactory );
        }
    }

    public void unregister ( final Hive hive )
    {
        for ( final AbstractQuery query : this.queries )
        {
            query.unregister ();
        }

        for ( final Update update : this.updates )
        {
            update.unregister ();
        }

        if ( this.itemFactory != null )
        {
            this.itemFactory.dispose ();
            this.itemFactory = null;
        }
    }

    protected java.sql.Connection createConnection () throws Exception
    {
        return this.connectionFactory.createConnection ( this.connectionClass, this.uri, this.properties, this.timeout );
    }

    public java.sql.Connection getConnection () throws Exception
    {
        return createConnection ();
    }

    public Integer getTimeout ()
    {
        return this.timeout;
    }

    public void add ( final Update update )
    {
        this.updates.add ( update );
    }
}
