/*******************************************************************************
 * Copyright (c) 2010, 2013, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - some bugfixes and modifications
 *******************************************************************************/
package org.eclipse.scada.hd.exporter.http.server.internal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.QueryState;
import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hd.data.ValueInformation;
import org.eclipse.scada.hd.exporter.http.DataPoint;
import org.eclipse.scada.hd.exporter.http.HttpExporter;
import org.eclipse.scada.hd.server.Service;
import org.eclipse.scada.hd.server.Session;
import org.eclipse.scada.sec.callback.PropertiesCredentialsCallback;
import org.eclipse.scada.utils.concurrent.AbstractFuture;

/*
 * create session only on first request
 *
 * since it is possible that the whole authentication mechanism is not
 * completely running when service gets registered. That way even if
 * the first request would fail, then it is possible to try it at a
 * later time and then it could work correctly
 */
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
            if ( ( state == QueryState.COMPLETE ) || ( state == QueryState.DISCONNECTED ) )
            {
                setResult ( this.result );
            }
        }
    }

    private final Service hdService;

    private Session session = null;

    private final Lock lock;

    public LocalHttpExporter ( final Service hdService ) throws Exception
    {
        this.hdService = hdService;
        this.lock = new ReentrantLock ( true );
    }

    @Override
    public List<DataPoint> getData ( final String item, final String type, final Date from, final Date to, final Integer number )
    {
        tryCreateSession ();

        final QueryParameters parameters = new QueryParameters ( from.getTime (), to.getTime (), number );
        QueryFuture queryFuture = new QueryFuture ( type );
        Query q = null;
        try
        {
            q = this.hdService.createQuery ( this.session, item, parameters, queryFuture, false );
            return queryFuture.get ( 30, TimeUnit.SECONDS );
        }
        catch ( final Exception e )
        {
            throw new RuntimeException ( e );
        }
        finally
        {
            queryFuture = null;
            if ( q != null )
            {
                q.close ();
                q = null;
            }
        }
    }

    private void tryCreateSession ()
    {
        // session already created, so do not put in the effort to lock and create a new session
        if ( this.session != null )
        {
            return;
        }
        // ensure that session gets only created once
        this.lock.lock ();
        try
        {
            if ( this.session == null )
            {
                final Properties props = makeProperties ();
                this.session = this.hdService.createSession ( props, new PropertiesCredentialsCallback ( props ) ).get ( 30, TimeUnit.SECONDS );
            }
        }
        catch ( final Exception e )
        {
            throw new RuntimeException ( e );
        }
        finally
        {
            this.lock.unlock ();
        }
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

    @Override
    public void dispose () throws Exception
    {
        if ( ( this.session != null ) && ( this.hdService != null ) )
        {
            this.hdService.closeSession ( this.session );
        }
    }

    private Properties makeProperties ()
    {
        final String user = System.getProperty ( "org.eclipse.scada.hd.exporter.http.server.user", "" );
        final String password = System.getProperty ( "org.eclipse.scada.hd.exporter.http.server.password", "" );
        final Properties props = new Properties ();
        props.setProperty ( "user", user );
        props.setProperty ( "password", password );
        return props;
    }
}
