/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.chart;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractSeriesData implements SeriesData
{
    private final static Logger logger = LoggerFactory.getLogger ( AbstractSeriesData.class );

    private final XAxis xAxis;

    private final YAxis yAxis;

    private final PropertyChangeListener listener;

    private final Set<SeriesDataListener> listeners = new HashSet<SeriesDataListener> ();

    private final Realm realm;

    public AbstractSeriesData ( final Realm realm, final XAxis xAxis, final YAxis yAxis )
    {
        this.realm = realm;
        this.xAxis = xAxis;
        this.yAxis = yAxis;

        this.listener = new PropertyChangeListener () {

            @Override
            public void propertyChange ( final PropertyChangeEvent evt )
            {
                handlePropertyChange ( evt );
            }
        };

        xAxis.addPropertyChangeListener ( this.listener );
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.chart.SeriesData#addListener(org.eclipse.scada.chart.SeriesDataListener)
     */
    @Override
    public void addListener ( final SeriesDataListener listener )
    {
        this.listeners.add ( listener );
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.chart.SeriesData#removeListener(org.eclipse.scada.chart.SeriesDataListener)
     */
    @Override
    public void removeListener ( final SeriesDataListener listener )
    {
        this.listeners.remove ( listener );
    }

    protected void fireUpdateListener ( final long startTimestamp, final long endTimestamp )
    {
        this.realm.asyncExec ( new Runnable () {
            @Override
            public void run ()
            {
                logger.trace ( "Process update listener - start: {}, end: {}", startTimestamp, endTimestamp );
                for ( final SeriesDataListener listener : AbstractSeriesData.this.listeners )
                {
                    listener.dataUpdate ( startTimestamp, endTimestamp );
                }
            }
        } );
    }

    protected void handlePropertyChange ( final PropertyChangeEvent evt )
    {
        setRequestWindow ( this.xAxis.getMin (), this.xAxis.getMax () );
    }

    public void dispose ()
    {
        this.xAxis.removePropertyChangeListener ( this.listener );
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.chart.SeriesData#getXAxis()
     */
    @Override
    public XAxis getXAxis ()
    {
        return this.xAxis;
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.chart.SeriesData#getYAxis()
     */
    @Override
    public YAxis getYAxis ()
    {
        return this.yAxis;
    }

    public Realm getRealm ()
    {
        return this.realm;
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.chart.SeriesData#setRequestWindow(long, long)
     */
    @Override
    public abstract void setRequestWindow ( final long startTimestamp, final long endTimestamp );

    /* (non-Javadoc)
     * @see org.eclipse.scada.chart.SeriesData#setRequestWidth(int)
     */
    @Override
    public abstract void setRequestWidth ( final int width );

    /* (non-Javadoc)
     * @see org.eclipse.scada.chart.SeriesData#getViewData()
     */
    @Override
    public abstract SeriesViewData getViewData ();

}
