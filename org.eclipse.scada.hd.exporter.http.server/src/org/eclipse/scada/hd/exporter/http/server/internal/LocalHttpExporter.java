/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.hd.exporter.http.server.internal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.QueryState;
import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hd.data.ValueInformation;
import org.eclipse.scada.hd.exporter.http.DataPoint;
import org.eclipse.scada.hd.exporter.http.HttpExporter;
import org.eclipse.scada.hd.server.Service;
import org.eclipse.scada.hd.server.Session;
import org.eclipse.scada.utils.concurrent.AbstractFuture;

public class LocalHttpExporter implements HttpExporter
{
    private class QueryFuture extends AbstractFuture<List<DataPoint>> implements QueryListener
    {
        final List<DataPoint> result = new ArrayList<DataPoint> ();

        final String type;

        public QueryFuture ( final String type )
        {
            this.type = type;
        }

        @Override
        public void updateData ( final int index, final Map<String, List<Double>> values, final List<ValueInformation> valueInformation )
        {
            int i = 0;
            for ( final ValueInformation vi : valueInformation )
            {
                final DataPoint dp = new DataPoint ();
                dp.setQuality ( vi.getQuality () );
                dp.setManual ( vi.getManualPercentage () );
                dp.setTimestamp ( new Date ( vi.getStartTimestamp () ) );
                dp.setValue ( values.get ( this.type ).get ( i ) );
                this.result.add ( dp );
                i++;
            }
        }

        @Override
        public void updateParameters ( final QueryParameters parameters, final Set<String> valueTypes )
        {
        }

        @Override
        public void updateState ( final QueryState state )
        {
            if ( state == QueryState.COMPLETE || state == QueryState.DISCONNECTED )
            {
                setResult ( this.result );
            }
        }
    }

    private final Service hdService;

    private final Session session;

    public LocalHttpExporter ( final Service hdService ) throws Exception
    {
        this.hdService = hdService;
        this.session = this.hdService.createSession ( new Properties (), null ).get ();
    }

    @Override
    public List<DataPoint> getData ( final String item, final String type, final Date from, final Date to, final Integer number )
    {
        final QueryParameters parameters = new QueryParameters ( from.getTime (), to.getTime (), number );
        QueryFuture queryFuture = new QueryFuture ( type );
        Query q = null;
        try
        {
            q = this.hdService.createQuery ( this.session, item, parameters, queryFuture, false );
            final List<DataPoint> result = queryFuture.get ( 30, TimeUnit.SECONDS );
            q.close ();
            queryFuture = null;
            q = null;
            return result;
        }
        catch ( final Exception e )
        {
            queryFuture = null;
            if ( q != null )
            {
                q.close ();
                q = null;
            }
        }
        return null;
    }

    @Override
    public List<String> getItems ()
    {
        return new ArrayList<String> ();
    }

    @Override
    public List<String> getSeries ( final String itemId )
    {
        return new ArrayList<String> ();
    }
}
