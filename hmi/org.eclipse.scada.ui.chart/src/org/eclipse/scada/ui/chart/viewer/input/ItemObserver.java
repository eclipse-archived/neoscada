/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - additional work
 *     IBH SYSTEMS GmbH - bug fixes and extensions, enhancements for legends
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer.input;

import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.chart.DataEntry;
import org.eclipse.scada.chart.Realm;
import org.eclipse.scada.chart.WritableSeries;
import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.chart.YAxis;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.render.AbstractLineRender;
import org.eclipse.scada.chart.swt.render.PositionYRuler;
import org.eclipse.scada.chart.swt.render.StepRenderer;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.ui.connection.data.DataItemHolder;
import org.eclipse.scada.da.ui.connection.data.DataSourceListener;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.ui.chart.Activator;
import org.eclipse.scada.ui.chart.viewer.ChartViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.RGB;

public class ItemObserver extends LineInput implements DataSourceListener
{
    private static final String PROP_STATE = "state"; //$NON-NLS-1$

    private final Item item;

    private final WritableSeries valueSeries;

    private DataItemHolder dataItem;

    private DataItemValue lastValue;

    private DataEntry lastTickMarker;

    private final StepRenderer valueRenderer;

    private boolean selection;

    private final YAxis y;

    private final Collection<LevelRuler> levelRulers = new LinkedList<LevelRuler> ();

    private final ChartViewer viewer;

    private boolean disposed;

    private SubscriptionState state;

    private Calendar originalSelectedTimestamp;

    private static class LevelRuler
    {
        private final String prefix;

        private final PositionYRuler ruler;

        private final ChartRenderer manager;

        private final int alpha;

        public LevelRuler ( final ChartRenderer manager, final String prefix, final YAxis y, final int style, final int alpha, final float lineWidth )
        {
            this.prefix = prefix;

            this.manager = manager;

            this.alpha = alpha;

            this.ruler = new PositionYRuler ( y, style );
            this.ruler.setAlpha ( this.alpha );
            this.ruler.setLineAttributes ( new LineAttributes ( lineWidth ) );
            this.manager.addRenderer ( this.ruler, 200 );
        }

        public void dispose ()
        {
            this.manager.removeRenderer ( this.ruler );
        }

        public void update ( final DataItemValue value )
        {
            this.ruler.setVisible ( false );

            if ( value != null )
            {
                final Variant levelValue = value.getAttributes ().get ( this.prefix + ".preset" ); //$NON-NLS-1$
                if ( levelValue != null )
                {
                    this.ruler.setPosition ( levelValue.asDouble ( null ) );
                    this.ruler.setVisible ( true );
                }
                final boolean active = value.getAttributeAsBoolean ( this.prefix + ".active" ); //$NON-NLS-1$
                final boolean unsafe = value.getAttributeAsBoolean ( this.prefix + ".unsafe" ); //$NON-NLS-1$
                final boolean error = value.getAttributeAsBoolean ( this.prefix + ".error" ); //$NON-NLS-1$
                final boolean alarm = value.getAttributeAsBoolean ( this.prefix + ".alarm" ); //$NON-NLS-1$

                if ( !active )
                {
                    this.ruler.setColor ( new RGB ( 128, 128, 128 ) );
                }
                else if ( unsafe )
                {
                    this.ruler.setColor ( new RGB ( 255, 0, 255 ) );
                }
                else if ( error || alarm )
                {
                    this.ruler.setColor ( new RGB ( 255, 0, 0 ) );
                }
                else
                {
                    this.ruler.setColor ( new RGB ( 0, 255, 0 ) );
                }
            }
        }
    }

    public ItemObserver ( final ChartViewer viewer, final Item item, final Realm realm, final XAxis x, final YAxis y, final ResourceManager resourceManager )
    {
        super ( resourceManager );

        this.item = item;
        this.viewer = viewer;

        this.y = y;

        this.valueSeries = new WritableSeries ( realm, x, y );

        this.valueRenderer = new StepRenderer ( viewer.getChartRenderer (), this.valueSeries );
        viewer.getChartRenderer ().addRenderer ( this.valueRenderer, 0 );

        connect ();

        attachHover ( viewer, x );
    }

    @Override
    protected AbstractLineRender getLineRenderer ()
    {
        return this.valueRenderer;
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.ui.chart.model.view.ChartInput#setSelection(boolean)
     */
    @Override
    public void setSelection ( final boolean state )
    {
        if ( this.selection == state )
        {
            return;
        }
        this.selection = state;

        if ( this.selection )
        {
            this.levelRulers.add ( makeLevelRuler ( "org.eclipse.scada.da.level.ceil", SWT.NONE, 255, 2.0f ) ); //$NON-NLS-1$
            this.levelRulers.add ( makeLevelRuler ( "org.eclipse.scada.da.level.highhigh", SWT.TOP, 64, 1.0f ) ); //$NON-NLS-1$
            this.levelRulers.add ( makeLevelRuler ( "org.eclipse.scada.da.level.high", SWT.TOP, 32, 1.0f ) ); //$NON-NLS-1$
            this.levelRulers.add ( makeLevelRuler ( "org.eclipse.scada.da.level.low", SWT.BOTTOM, 32, 1.0f ) ); //$NON-NLS-1$
            this.levelRulers.add ( makeLevelRuler ( "org.eclipse.scada.da.level.lowlow", SWT.BOTTOM, 64, 1.0f ) ); //$NON-NLS-1$
            this.levelRulers.add ( makeLevelRuler ( "org.eclipse.scada.da.level.floor", SWT.NONE, 255, 2.0f ) ); //$NON-NLS-1$
            updateLevels ();
        }
        else
        {
            removeLevelRulers ();
        }
    }

    private void updateLevels ()
    {
        for ( final LevelRuler ruler : this.levelRulers )
        {
            ruler.update ( this.lastValue );
        }
    }

    private LevelRuler makeLevelRuler ( final String prefix, final int style, final int alpha, final float lineWidth )
    {
        final LevelRuler ruler = new LevelRuler ( this.viewer.getChartRenderer (), prefix, this.y, style, alpha, lineWidth );

        return ruler;
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.ui.chart.model.view.ChartInput#dispose()
     */
    @Override
    public void dispose ()
    {
        if ( this.disposed )
        {
            this.disposed = true;
        }

        removeLevelRulers ();

        this.viewer.removeInput ( this );
        this.viewer.getChartRenderer ().removeRenderer ( this.valueRenderer );
        this.valueRenderer.dispose ();
        disconnect ();
    }

    private void removeLevelRulers ()
    {
        for ( final LevelRuler ruler : this.levelRulers )
        {
            ruler.dispose ();
        }
        this.levelRulers.clear ();
    }

    public Item getItem ()
    {
        return this.item;
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.ui.chart.model.view.ChartInput#tick(long)
     */
    @Override
    public boolean tick ( final long now )
    {
        if ( this.lastTickMarker == null )
        {
            final DataEntry newMarker = makeEntry ( this.lastValue );
            if ( newMarker.getTimestamp () > now )
            {
                // don't add marker if the latest value is in the future
                return false;
            }
            this.lastTickMarker = newMarker;
        }
        else
        {
            this.valueSeries.getData ().remove ( this.lastTickMarker );
        }
        this.lastTickMarker = new DataEntry ( now, this.lastTickMarker.getValue () );
        this.valueSeries.getData ().add ( this.lastTickMarker );

        return true;
    }

    public void connect ()
    {
        this.dataItem = new DataItemHolder ( Activator.getDefault ().getBundle ().getBundleContext (), this.item, this );
    }

    public void disconnect ()
    {
        if ( this.dataItem != null )
        {
            this.dataItem.dispose ();
            this.dataItem = null;
        }
    }

    @Override
    public void updateData ( final DataItemValue value )
    {
        if ( !this.valueSeries.getRealm ().isDisposed () )
        {
            this.valueSeries.getRealm ().asyncExec ( new Runnable () {
                @Override
                public void run ()
                {
                    updateState ( value );
                    addNewValue ( value );
                }
            } );
        }
    }

    protected void updateState ( final DataItemValue value )
    {
        if ( value != null && this.state != value.getSubscriptionState () )
        {
            firePropertyChange ( PROP_STATE, this.state, this.state = value.getSubscriptionState () );
        }
    }

    private void addNewValue ( final DataItemValue value )
    {
        this.lastValue = value;

        if ( this.lastTickMarker != null )
        {
            this.valueSeries.getData ().remove ( this.lastTickMarker );
            this.lastTickMarker = null;
        }

        final DataEntry entry = makeEntry ( value );
        this.valueSeries.getData ().addAsLast ( entry );
        updateLevels ();

        setSelection ( this.originalSelectedTimestamp );
    }

    private DataEntry makeEntry ( final DataItemValue value )
    {
        if ( value == null || value.isError () || !value.isConnected () || value.getValue () == null )
        {
            return new DataEntry ( System.currentTimeMillis (), null );
        }
        else
        {
            final Calendar valueTimestamp = value.getTimestamp ();
            final long timestamp = valueTimestamp == null ? System.currentTimeMillis () : valueTimestamp.getTimeInMillis ();
            return new DataEntry ( timestamp, value.getValue ().asDouble ( null ) );
        }
    }

    @Override
    public String getState ()
    {
        final SubscriptionState state = this.state;
        return state == null ? null : state.name ();
    }

    @Override
    protected void setSelectedTimestamp ( final Calendar selectedTimestamp )
    {
        if ( selectedTimestamp == null )
        {
            return;
        }

        this.originalSelectedTimestamp = selectedTimestamp;

        if ( this.valueSeries == null || this.valueSeries.getData () == null )
        {
            return;
        }

        final DataEntry value = this.valueSeries.getData ().getEntries ().lower ( new DataEntry ( selectedTimestamp.getTimeInMillis (), null ) );
        if ( value == null )
        {
            setSelectedValue ( null );
            super.setSelectedTimestamp ( null );
            setSelectedQuality ( 0.0 );
        }
        else
        {
            setSelectedValue ( value.getValue () );
            setSelectedQuality ( value.getValue () == null ? 0.0 : 1.0 );
            final Calendar c = Calendar.getInstance ();
            c.setTimeInMillis ( value.getTimestamp () );
            super.setSelectedTimestamp ( c );
        }
    }

}