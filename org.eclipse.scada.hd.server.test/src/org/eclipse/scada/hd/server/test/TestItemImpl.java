/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.server.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.data.HistoricalItemInformation;
import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hd.server.common.HistoricalItem;

public class TestItemImpl implements HistoricalItem
{

    private final Set<TestQueryImpl> queries = new HashSet<TestQueryImpl> ();

    @Override
    public Query createQuery ( final QueryParameters parameters, final QueryListener listener, final boolean updateData )
    {
        final TestQueryImpl query = new TestQueryImpl ( this, parameters, listener );
        this.queries.add ( query );
        return query;
    }

    @Override
    public HistoricalItemInformation getInformation ()
    {
        return new HistoricalItemInformation ( "test1", new HashMap<String, Variant> () );
    }

    public void dispose ()
    {

        final Collection<TestQueryImpl> queries = new ArrayList<TestQueryImpl> ( this.queries );

        for ( final TestQueryImpl query : queries )
        {
            query.close ();
        }
    }

    protected void remove ( final TestQueryImpl query )
    {
        this.queries.remove ( query );
    }

}
