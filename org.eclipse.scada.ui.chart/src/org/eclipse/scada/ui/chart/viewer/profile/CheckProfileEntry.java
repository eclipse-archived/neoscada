/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - observe text label
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer.profile;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.Profile;
import org.eclipse.scada.ui.chart.viewer.ChartContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class CheckProfileEntry extends ProfileEntry
{

    private final Button widget;

    public CheckProfileEntry ( final DataBindingContext dbc, final Composite parent, final ProfileManager profileManager, final Profile profile, final ChartContext chartContext )
    {
        super ( dbc, profileManager, profile, chartContext );

        this.widget = new Button ( parent, SWT.CHECK );
        addBinding ( dbc.bindValue ( SWTObservables.observeText ( this.widget ), EMFObservables.observeValue ( profile, ChartPackage.Literals.PROFILE__LABEL ) ) );

        this.widget.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                fireSelection ( CheckProfileEntry.this.widget.getSelection () );
            };
        } );
    }

    @Override
    public void activate ()
    {
        this.widget.setSelection ( true );

        super.activate ();
    }

    @Override
    public void deactivate ()
    {
        this.widget.setSelection ( false );

        super.deactivate ();
    }

}
