/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.ui.connection.internal;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.scada.hd.connection.provider.ConnectionService;
import org.eclipse.scada.hd.ui.data.AbstractQueryBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryWrapper
{
    private final static Logger logger = LoggerFactory.getLogger ( QueryWrapper.class );

    private final ConnectionService service;

    private final WritableSet queries = new WritableSet ();

    public QueryWrapper ( final ConnectionService service )
    {
        this.service = service;
    }

    public ConnectionService getService ()
    {
        return this.service;
    }

    public void dispose ()
    {
        for ( final Object query : this.queries )
        {
            ( (AbstractQueryBuffer)query ).close ();
        }
        this.queries.clear ();
    }

    public IObservableSet getQueriesObservable ()
    {
        return Observables.proxyObservableSet ( this.queries );
    }

    public void createQuery ( final String id )
    {
        logger.info ( "Create new query for: {}", id ); //$NON-NLS-1$

        final QueryBufferBean query = new QueryBufferBean ( this, id );
        this.queries.add ( query );
    }

    protected void fakeIt ( final QueryBufferBean query )
    {
        this.queries.setStale ( true );
        this.queries.remove ( query );
        this.queries.add ( query );
        this.queries.setStale ( false );
    }

    /**
     * Remove the query and close it
     * @param queryBufferBean the query to remove and close
     */
    public void removeQuery ( final QueryBufferBean queryBufferBean )
    {
        this.queries.remove ( queryBufferBean );
        queryBufferBean.close ();
    }
}
