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
package org.eclipse.scada.ae.ui.testing.navigator;

import java.util.List;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Query;
import org.eclipse.scada.ae.QueryListener;
import org.eclipse.scada.ae.data.QueryState;
import org.eclipse.scada.utils.beans.AbstractPropertyChange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryBean extends AbstractPropertyChange implements QueryListener
{

    private final static Logger logger = LoggerFactory.getLogger ( QueryBean.class );

    private static final String PROP_STATE = "state";

    private static final String PROP_COUNT = "count";

    private final String filterData;

    private final String filterType;

    private QueryState state;

    private Query query;

    private final WritableSet events = new WritableSet ();

    private final QueryListWrapper wrapper;

    public QueryBean ( final QueryListWrapper wrapper, final String filterType, final String filterData )
    {
        this.wrapper = wrapper;
        this.filterType = filterType;
        this.filterData = filterData;
    }

    public String getFilterData ()
    {
        return this.filterData;
    }

    public String getFilterType ()
    {
        return this.filterType;
    }

    @Override
    public void queryData ( final List<Event> events )
    {
        logger.debug ( "Received {} events", events.size () );

        this.events.getRealm ().asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                QueryBean.this.addData ( events );
            }
        } );

    }

    protected void addData ( final List<Event> events )
    {
        final long tix = System.currentTimeMillis ();
        final int oldSize = this.events.size ();
        this.events.addAll ( events );
        final int newSize = this.events.size ();
        logger.debug ( "String delta: {}", System.currentTimeMillis () - tix );

        firePropertyChange ( PROP_COUNT, oldSize, newSize );
    }

    public int getCount ()
    {
        return this.events.size ();
    }

    @Override
    public void queryStateChanged ( final QueryState state, final Throwable error )
    {
        logger.info ( "Query state changed {}: ", state, error != null ? error.getMessage () : "<none>" );

        final QueryState oldState = this.state;
        this.state = state;
        firePropertyChange ( PROP_STATE, oldState, state );
    }

    public void setController ( final Query createQuery )
    {
        this.query = createQuery;
    }

    public QueryState getState ()
    {
        return this.state;
    }

    public Query getQuery ()
    {
        return this.query;
    }

    public void remove ()
    {
        this.query.close ();
        this.wrapper.remove ( this );
    }

    public void dispose ()
    {
        this.query.close ();
    }

    public IObservableSet getEventObservable ()
    {
        return Observables.proxyObservableSet ( this.events );
    }

}
