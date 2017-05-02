/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.hd.server.importer.hsdb;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.data.HistoricalItemInformation;
import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hd.server.common.HistoricalItem;
import org.eclipse.scada.hd.server.storage.common.QueryImpl;
import org.eclipse.scada.hd.server.storage.common.ValueSourceManager;
import org.eclipse.scada.hds.ValueVisitor;

public class HSDBHistoricalItem implements HistoricalItem, ValueSourceManager
{
    private final HistoricalItemInformation information;

    private final ScheduledExecutorService executor;

    private final HSDBValueSource source;

    private Set<QueryImpl> queries = new HashSet<QueryImpl> ();

    public HSDBHistoricalItem ( final ScheduledExecutorService executor, final HSDBValueSource source, final HistoricalItemInformation information )
    {
        this.executor = executor;
        this.information = information;
        this.source = source;
    }

    @Override
    public Query createQuery ( final QueryParameters parameters, final QueryListener listener, final boolean updateData )
    {
        final QueryImpl query = new QueryImpl ( this, this.executor, this.executor, parameters, listener, updateData, this.source.getStartTimestamp (), this.source.getEndTimestamp () );
        synchronized ( this )
        {
            if ( this.queries == null )
            {
                query.close ();
                return null;
            }
            this.queries.add ( query );
        }
        return query;
    }

    public void dispose ()
    {
        final Set<QueryImpl> queries;
        synchronized ( this )
        {
            queries = this.queries;
            this.queries = null;
        }

        for ( final QueryImpl query : queries )
        {
            query.close ();
        }
    }

    @Override
    public HistoricalItemInformation getInformation ()
    {
        return this.information;
    }

    @Override
    public void queryClosed ( final QueryImpl query )
    {
        synchronized ( this )
        {
            if ( this.queries != null )
            {
                this.queries.remove ( query );
            }
        }
    }

    @Override
    public boolean visit ( final QueryParameters parameters, final ValueVisitor visitor )
    {
        return this.source.visit ( visitor, new Date ( parameters.getStartTimestamp () ), new Date ( parameters.getEndTimestamp () ) );
    }

}
