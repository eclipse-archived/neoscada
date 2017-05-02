/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - enhancements for legends
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer.input;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.List;

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.hd.QueryState;
import org.eclipse.scada.hd.data.ValueInformation;
import org.eclipse.scada.hd.ui.data.AbstractQueryBuffer;
import org.eclipse.scada.hd.ui.data.ServiceQueryBuffer;

public abstract class QueryInput extends LineInput
{

    private static final String PROP_STATE = "state"; //$NON-NLS-1$

    private ServiceQueryBuffer query;

    private PropertyChangeListener queryListener;

    private String state;

    private Calendar originalSelectedTimestamp;

    private String channelName;

    public QueryInput ( final ResourceManager resourceManager )
    {
        super ( resourceManager );
    }

    @Override
    public void dispose ()
    {
        if ( this.query != null )
        {
            this.query.removePropertyChangeListener ( this.queryListener );
        }

        super.dispose ();
    }

    protected String getChannelName ()
    {
        return this.channelName;
    }

    protected void setQuery ( final ServiceQueryBuffer query, final String channelName )
    {
        this.query = query;
        this.channelName = channelName;

        this.query.addPropertyChangeListener ( this.queryListener = new PropertyChangeListener () {

            @Override
            public void propertyChange ( final PropertyChangeEvent evt )
            {
                queryPropertyChange ( evt );
            }
        } );

        setState ( makeState () );
    }

    protected void queryPropertyChange ( final PropertyChangeEvent evt )
    {
        if ( AbstractQueryBuffer.PROP_STATE.equals ( evt.getPropertyName () ) )
        {
            setState ( makeState () );
        }
        else if ( AbstractQueryBuffer.PROP_PERCENT_FILLED.equals ( evt.getPropertyName () ) )
        {
            setState ( makeState () );
        }

        // FIXME: should be in "updateData"
        // reset selected timestamp and update 
        setSelection ( this.originalSelectedTimestamp );
    }

    protected String makeState ()
    {
        if ( this.query == null )
        {
            return null;
        }

        final QueryState state = this.query.getState ();
        if ( state == null )
        {
            return null;
        }

        switch ( state )
        {
            case LOADING:
                return String.format ( Messages.QueryInput_Format_LoadingState, this.query.getState (), this.query.getPercentFilled () * 100.0 );
            default:
                return this.query.getState ().name ();
        }
    }

    protected void setState ( final String state )
    {
        firePropertyChange ( PROP_STATE, this.state, this.state = state );
    }

    @Override
    public String getState ()
    {
        return this.state;
    }

    @Override
    protected void setSelectedTimestamp ( final Calendar selectedTimestamp )
    {
        if ( selectedTimestamp == null )
        {
            return;
        }

        this.originalSelectedTimestamp = selectedTimestamp;

        if ( this.query == null )
        {
            return;
        }

        final List<ValueInformation> infos = this.query.getValueInformation ();

        if ( infos == null )
        {
            return;
        }

        final long c = selectedTimestamp.getTimeInMillis ();

        for ( int i = 0; i < infos.size (); i++ )
        {
            final ValueInformation vi = infos.get ( i );

            if ( vi == null )
            {
                continue;
            }

            if ( vi.getStartTimestamp () <= c && vi.getEndTimestamp () >= c )
            {
                final Calendar ca = Calendar.getInstance ();
                ca.setTimeInMillis ( vi.getStartTimestamp () );
                super.setSelectedTimestamp ( ca );
                setSelectedQuality ( vi.getQuality () );
                setSelectedValue ( getValue ( this.query, i, this.channelName ) );
                break;
            }
        }
    }

    private static Double getValue ( final ServiceQueryBuffer query, final int index, final String channelName )
    {
        final List<Double> data = query.getValues ().get ( channelName );
        if ( data == null )
        {
            return null;
        }
        if ( index >= data.size () )
        {
            return null;
        }

        return data.get ( index );
    }

    @Override
    public boolean tick ( final long now )
    {
        return false;
    }
}
