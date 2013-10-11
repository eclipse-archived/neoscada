/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - additional work
/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer.controller.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.ui.chart.viewer.ChartContext;
import org.eclipse.scada.ui.chart.viewer.XAxisViewer;
import org.eclipse.scada.ui.chart.viewer.controller.ChartController;
import org.eclipse.scada.ui.chart.viewer.controller.actions.AbstractXAxisController;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.CurrentTimeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrentTimeChartController extends AbstractXAxisController implements ChartController
{

    private final static Logger logger = LoggerFactory.getLogger ( CurrentTimeChartController.class );

    private long milliseconds;

    private Long timespan;

    private final Realm realm;

    private boolean disposed;

    private String alignDateFormat;

    public CurrentTimeChartController ( final DataBindingContext ctx, final Realm realm, final CurrentTimeController controller, final ChartContext chartContext )
    {
        super ( ctx, chartContext, controller );
        this.realm = realm;

        addBinding ( ctx.bindValue ( PojoObservables.observeValue ( this, "milliseconds" ), EMFObservables.observeValue ( controller, ChartPackage.Literals.CURRENT_TIME_CONTROLLER__DIFF ) ) ); //$NON-NLS-1$
        addBinding ( ctx.bindValue ( PojoObservables.observeValue ( this, "timespan" ), EMFObservables.observeValue ( controller, ChartPackage.Literals.CURRENT_TIME_CONTROLLER__TIMESPAN ) ) ); //$NON-NLS-1$
        addBinding ( ctx.bindValue ( PojoObservables.observeValue ( this, "alignDateFormat" ), EMFObservables.observeValue ( controller, ChartPackage.Literals.CURRENT_TIME_CONTROLLER__ALIGN_DATE_FORMAT ) ) ); //$NON-NLS-1$

        tick ();
    }

    public void setAlignDateFormat ( final String alignDateFormat )
    {
        this.alignDateFormat = alignDateFormat;
    }

    public String getAlignDateFormat ()
    {
        return this.alignDateFormat;
    }

    protected void startTimer ()
    {
        if ( this.disposed )
        {
            return;
        }

        this.realm.timerExec ( 1000, new Runnable () {

            @Override
            public void run ()
            {
                tick ();
            }
        } );
    }

    protected void tick ()
    {
        if ( this.disposed )
        {
            return;
        }

        handleTick ();

        startTimer ();
    }

    protected void handleTick ()
    {
        final long now = System.currentTimeMillis ();
        for ( final XAxisViewer viewer : getCurrentViewers () )
        {
            update ( now, viewer );
        }
    }

    private void update ( long now, final XAxisViewer viewer )
    {
        now += this.milliseconds;

        if ( this.alignDateFormat != null && !this.alignDateFormat.isEmpty () )
        {
            final SimpleDateFormat df = new SimpleDateFormat ( this.alignDateFormat );
            Date date;
            try
            {
                date = df.parse ( df.format ( new Date ( now ) ) );
            }
            catch ( final ParseException e )
            {
                logger.warn ( "Failed to update chart axis", e ); //$NON-NLS-1$
                return;
            }
            now = date.getTime ();
        }

        if ( viewer == null )
        {
            return;
        }
        final XAxis axis = viewer.getAxis ();
        if ( axis == null )
        {
            return;
        }

        if ( this.timespan != null )
        {
            axis.setMinMax ( now, now + this.timespan );
        }
        else
        {
            axis.setStartTimestamp ( now );
        }
    }

    public void setMilliseconds ( final long milliseconds )
    {
        this.milliseconds = milliseconds;
    }

    public long getMilliseconds ()
    {
        return this.milliseconds;
    }

    public void setTimespan ( final Long timespan )
    {
        this.timespan = timespan;
    }

    public Long getTimespan ()
    {
        return this.timespan;
    }

    @Override
    public void dispose ()
    {
        this.disposed = true;
        super.dispose ();
    }

}
