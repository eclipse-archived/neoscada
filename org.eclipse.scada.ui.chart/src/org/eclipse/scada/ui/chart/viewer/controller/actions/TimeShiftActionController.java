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
package org.eclipse.scada.ui.chart.viewer.controller.actions;

import java.util.concurrent.TimeUnit;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.scada.ui.chart.viewer.ChartContext;
import org.eclipse.scada.ui.chart.viewer.XAxisViewer;
import org.eclipse.scada.ui.chart.viewer.controller.ChartController;
import org.eclipse.scada.ui.chart.viewer.controller.ControllerManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.TimeShiftAction;

public class TimeShiftActionController extends AbstractXAxisController implements ChartController
{

    private Button button;

    private long milliseconds;

    public TimeShiftActionController ( final ControllerManager controllerManager, final ChartContext chartContext, final TimeShiftAction controller )
    {
        super ( controllerManager.getContext (), chartContext, controller );

        final DataBindingContext ctx = controllerManager.getContext ();

        final Composite space = chartContext.getExtensionSpaceProvider ().getExtensionSpace ();
        if ( space != null )
        {
            this.button = new Button ( space, SWT.PUSH );
            this.button.addSelectionListener ( new SelectionAdapter () {
                @Override
                public void widgetSelected ( final SelectionEvent e )
                {
                    action ();
                };
            } );
            addBinding ( ctx.bindValue ( PojoObservables.observeValue ( this, "milliseconds" ), EMFObservables.observeValue ( controller, ChartPackage.Literals.TIME_SHIFT_ACTION__DIFF ) ) ); //$NON-NLS-1$
            addBinding ( ctx.bindValue ( SWTObservables.observeText ( this.button ), EMFObservables.observeValue ( controller, ChartPackage.Literals.TIME_SHIFT_ACTION__LABEL ) ) );
            addBinding ( ctx.bindValue ( SWTObservables.observeTooltipText ( this.button ), EMFObservables.observeValue ( controller, ChartPackage.Literals.TIME_SHIFT_ACTION__DESCRIPTION ) ) );
            space.layout ();
        }
        else
        {
            this.button = null;
        }
    }

    protected void action ()
    {
        for ( final XAxisViewer viewer : getCurrentViewers () )
        {
            viewer.getAxis ().shiftByTimespan ( this.milliseconds, TimeUnit.MILLISECONDS );
        }
    }

    @Override
    public void dispose ()
    {
        if ( this.button != null )
        {
            this.button.dispose ();
        }
        super.dispose ();
    }

    public void setMilliseconds ( final long milliseconds )
    {
        this.milliseconds = milliseconds;
    }

    public long getMilliseconds ()
    {
        return this.milliseconds;
    }

}
