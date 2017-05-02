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
package org.eclipse.scada.ui.chart.viewer.controller.tools;

import org.eclipse.scada.ui.chart.viewer.AbstractObserver;
import org.eclipse.scada.ui.chart.viewer.ChartContext;
import org.eclipse.scada.ui.chart.viewer.ResetHandler;
import org.eclipse.scada.ui.chart.viewer.controller.ChartController;
import org.eclipse.scada.ui.chart.viewer.controller.ControllerManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.scada.ui.chart.model.ResetController;

public class ResetControllerImpl extends AbstractObserver implements ChartController
{

    private Button button;

    private final ResetHandler resetHandler;

    public ResetControllerImpl ( final ControllerManager controllerManager, final ChartContext chartContext, final ResetController controller )
    {
        final Composite space = chartContext.getExtensionSpaceProvider ().getExtensionSpace ();
        this.resetHandler = chartContext.getResetHandler ();
        if ( space != null && this.resetHandler != null )
        {
            this.button = new Button ( space, SWT.PUSH );
            this.button.setText ( Messages.ResetControllerImpl_Label );
            this.button.addSelectionListener ( new SelectionAdapter () {
                @Override
                public void widgetSelected ( final SelectionEvent e )
                {
                    action ();
                }
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
        this.resetHandler.reset ();
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

}
