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
package org.eclipse.scada.ui.chart.viewer;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.render.YAxisDynamicRenderer;
import org.eclipse.swt.SWT;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.YAxis;

public class YAxisViewer extends AbstractAxisViewer
{
    private final YAxis axis;

    private final org.eclipse.scada.chart.YAxis control;

    private final YAxisDynamicRenderer renderer;

    public YAxisViewer ( final DataBindingContext dbc, final ChartRenderer manager, final YAxis axis, final boolean left )
    {
        super ( dbc, manager, axis );

        this.axis = axis;

        this.control = new org.eclipse.scada.chart.YAxis ();

        this.renderer = new YAxisDynamicRenderer ( manager );
        this.renderer.setAxis ( this.control );
        this.renderer.setAlign ( left ? SWT.LEFT : SWT.RIGHT );
        manager.addRenderer ( this.renderer, -1 );

        addBinding ( this.dbc.bindValue ( BeansObservables.observeValue ( this.control, "label" ), EMFObservables.observeValue ( this.axis, ChartPackage.Literals.AXIS__LABEL ) ) ); //$NON-NLS-1$
        addBinding ( this.dbc.bindValue ( BeansObservables.observeValue ( this.control, "min" ), EMFObservables.observeValue ( this.axis, ChartPackage.Literals.YAXIS__MINIMUM ) ) ); //$NON-NLS-1$
        addBinding ( this.dbc.bindValue ( BeansObservables.observeValue ( this.control, "max" ), EMFObservables.observeValue ( this.axis, ChartPackage.Literals.YAXIS__MAXIMUM ) ) ); //$NON-NLS-1$

        addBinding ( this.dbc.bindValue ( PojoObservables.observeValue ( this.renderer, "showLabels" ), EMFObservables.observeValue ( this.axis, ChartPackage.Literals.AXIS__LABEL_VISIBLE ) ) ); //$NON-NLS-1$
        addBinding ( this.dbc.bindValue ( PojoObservables.observeValue ( this.renderer, "format" ), EMFObservables.observeValue ( this.axis, ChartPackage.Literals.AXIS__FORMAT ) ) ); //$NON-NLS-1$
        addBinding ( this.dbc.bindValue ( PojoObservables.observeValue ( this.renderer, "textPadding" ), EMFObservables.observeValue ( this.axis, ChartPackage.Literals.AXIS__TEXT_PADDING ) ) ); //$NON-NLS-1$
        addBinding ( this.dbc.bindValue ( PojoObservables.observeValue ( this.renderer, "color" ), EMFObservables.observeValue ( this.axis, ChartPackage.Literals.AXIS__COLOR ) ) ); //$NON-NLS-1$
    }

    @Override
    public void dispose ()
    {
        super.dispose ();

        this.renderer.dispose ();
    }

    public org.eclipse.scada.chart.YAxis getAxis ()
    {
        return this.control;
    }
}
