/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.server.storage.common;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.QueryState;
import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hd.data.ValueInformation;

public class TestQueryBuffer
{
    private final QueryBuffer queryBuffer;

    private final Executor executor = new Executor () {

        @Override
        public void execute ( final Runnable command )
        {
            command.run ();
        }
    };

    private final QueryListener queryListener = new QueryListener () {

        @Override
        public void updateState ( final QueryState state )
        {
            System.out.println ( "State update: " + state );
        }

        @Override
        public void updateParameters ( final QueryParameters parameters, final Set<String> valueTypes )
        {
            System.out.println ( "Parameters: " + parameters + ", values: " + valueTypes );
            handleUpdateParmaters ( parameters, valueTypes );
        }

        @Override
        public void updateData ( final int index, final Map<String, List<Double>> values, final List<ValueInformation> valueInformation )
        {
            handleUpdateData ( index, values, valueInformation );
        }
    };

    private ValueInformation[] information;

    private Map<String, Double[]> data;

    public TestQueryBuffer ( final Date fixedStartDate, final Date fixedEndDate, final int numberOfEntries )
    {
        this.queryBuffer = new QueryBuffer ( this.queryListener, this.executor, fixedStartDate, fixedEndDate );
        if ( numberOfEntries > 0 )
        {
            this.queryBuffer.changeParameters ( new QueryParameters ( fixedStartDate.getTime (), fixedEndDate.getTime (), numberOfEntries ) );
        }
    }

    protected void handleUpdateData ( final int index, final Map<String, List<Double>> values, final List<ValueInformation> valueInformation )
    {
        // copy data into our local buffer

        final int len = valueInformation.size ();

        for ( int i = 0; i < len; i++ )
        {
            this.information[i + index] = valueInformation.get ( i );
        }

        for ( final Map.Entry<String, List<Double>> entry : values.entrySet () )
        {
            final Double[] ar = this.data.get ( entry.getKey () );
            final List<Double> l = entry.getValue ();
            for ( int i = 0; i < len; i++ )
            {
                ar[i + index] = l.get ( i );
            }
        }
    }

    protected void handleUpdateParmaters ( final QueryParameters parameters, final Set<String> valueTypes )
    {
        // create our local buffer

        final int count = parameters.getNumberOfEntries ();
        this.information = new ValueInformation[count];

        this.data = new HashMap<> ();
        for ( final String type : valueTypes )
        {
            final Double[] ar = new Double[count];
            this.data.put ( type, ar );
        }
    }

    public ValueInformation[] getInformation ()
    {
        return this.information;
    }

    public Map<String, Double[]> getData ()
    {
        return this.data;
    }

    public void changeParameters ( final QueryParameters parameters )
    {
        this.queryBuffer.changeParameters ( parameters );
    }

    public void insertData ( final double value, final Date timestamp, final boolean error, final boolean manual )
    {
        this.queryBuffer.insertData ( value, timestamp, error, manual );
    }

    public void close ()
    {
        this.queryBuffer.close ();
    }

    /**
     * Data entry is completed
     */
    public void complete ()
    {
        this.queryBuffer.complete ();
    }

}
