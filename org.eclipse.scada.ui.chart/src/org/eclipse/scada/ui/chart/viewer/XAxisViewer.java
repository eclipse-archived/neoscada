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
 *     IBH SYSTEMS GmbH - bug fixes and extensions
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.render.XAxisDynamicRenderer;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.XAxis;
import org.eclipse.swt.SWT;

public class XAxisViewer extends AbstractAxisViewer
{
    private final XAxis axis;

    private final org.eclipse.scada.chart.XAxis control;

    private final XAxisDynamicRenderer renderer;

    public XAxisViewer ( final DataBindingContext dbc, final ChartRenderer manager, final XAxis axis, final boolean top )
    {
        super ( dbc, manager, axis );

        this.axis = axis;

        this.control = new org.eclipse.scada.chart.XAxis ();

        this.renderer = new XAxisDynamicRenderer ( manager );
        this.renderer.setAxis ( this.control );
        this.renderer.setAlign ( top ? SWT.TOP : SWT.BOTTOM );
        manager.addRenderer ( this.renderer, -2 );

        addBinding ( this.dbc.bindValue ( BeansObservables.observeValue ( this.control, "label" ), EMFObservables.observeValue ( this.axis, ChartPackage.Literals.AXIS__LABEL ) ) ); //$NON-NLS-1$
        addBinding ( this.dbc.bindValue ( BeansObservables.observeValue ( this.control, "min" ), EMFObservables.observeValue ( this.axis, ChartPackage.Literals.XAXIS__MINIMUM ) ) ); //$NON-NLS-1$
        addBinding ( this.dbc.bindValue ( BeansObservables.observeValue ( this.control, "max" ), EMFObservables.observeValue ( this.axis, ChartPackage.Literals.XAXIS__MAXIMUM ) ) ); //$NON-NLS-1$

        addBinding ( this.dbc.bindValue ( PojoObservables.observeValue ( this.renderer, "showLabels" ), EMFObservables.observeValue ( this.axis, ChartPackage.Literals.AXIS__LABEL_VISIBLE ) ) ); //$NON-NLS-1$
        addBinding ( this.dbc.bindValue ( PojoObservables.observeValue ( this.renderer, "format" ), EMFObservables.observeValue ( this.axis, ChartPackage.Literals.AXIS__FORMAT ) ) ); //$NON-NLS-1$
        addBinding ( this.dbc.bindValue ( PojoObservables.observeValue ( this.renderer, "textPadding" ), EMFObservables.observeValue ( this.axis, ChartPackage.Literals.AXIS__TEXT_PADDING ) ) ); //$NON-NLS-1$
        addBinding ( this.dbc.bindValue ( PojoObservables.observeValue ( this.renderer, "color" ), EMFObservables.observeValue ( this.axis, ChartPackage.Literals.AXIS__COLOR ) ) ); //$NON-NLS-1$
    }

    public org.eclipse.scada.chart.XAxis getAxis ()
    {
        return this.control;
    }

    @Override
    public void dispose ()
    {
        super.dispose ();

        if ( this.renderer != null )
        {
            this.renderer.dispose ();
        }
    }
}
