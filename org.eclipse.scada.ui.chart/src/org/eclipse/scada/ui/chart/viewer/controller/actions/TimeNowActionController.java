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

import org.eclipse.scada.ui.chart.viewer.ChartContext;
import org.eclipse.scada.ui.chart.viewer.XAxisViewer;
import org.eclipse.scada.ui.chart.viewer.controller.ChartController;
import org.eclipse.scada.ui.chart.viewer.controller.ControllerManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.scada.ui.chart.model.TimeNowAction;

public class TimeNowActionController extends AbstractXAxisController implements ChartController
{

    private Button button;

    private long milliseconds;

    public TimeNowActionController ( final ControllerManager controllerManager, final ChartContext chartContext, final TimeNowAction controller )
    {
        super ( controllerManager.getContext (), chartContext, controller );

        final Composite space = chartContext.getExtensionSpaceProvider ().getExtensionSpace ();
        if ( space != null )
        {
            this.button = new Button ( space, SWT.PUSH );
            this.button.setText ( Messages.TimeNowActionController_Label );
            this.button.setToolTipText ( Messages.TimeNowActionController_Description );
            this.button.addSelectionListener ( new SelectionAdapter () {
                @Override
                public void widgetSelected ( final SelectionEvent e )
                {
                    action ();
                };
            } );
            space.layout ();
        }
        else
        {
            this.button = null;
        }
    }

    protected void action ()
    {
        final long now = System.currentTimeMillis ();
        for ( final XAxisViewer viewer : getCurrentViewers () )
        {
            viewer.getAxis ().setCenter ( now );
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
