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
package org.eclipse.scada.ui.chart.viewer.profile;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.scada.ui.chart.viewer.ChartContext;
import org.eclipse.scada.ui.chart.viewer.controller.ControllerManager;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfileEntry
{

    private final static Logger logger = LoggerFactory.getLogger ( ProfileEntry.class );

    private final ProfileManager manager;

    private final Profile profile;

    private boolean active;

    private final DataBindingContext ctx;

    private ControllerManager controllerManager;

    private final ChartContext chartContext;

    private Binding binding;

    public ProfileEntry ( final DataBindingContext ctx, final ProfileManager manager, final Profile profile, final ChartContext chartContext )
    {
        this.ctx = ctx;
        this.chartContext = chartContext;
        this.manager = manager;
        this.profile = profile;
    }

    public void activate ()
    {
        if ( this.active )
        {
            return;
        }

        this.active = true;

        logger.info ( "Activate profile: {}", this.profile.getId () ); //$NON-NLS-1$

        this.controllerManager = new ControllerManager ( this.ctx, this.ctx.getValidationRealm (), this.chartContext );
        this.binding = this.ctx.bindList ( this.controllerManager.getList (), EMFObservables.observeList ( this.profile, ChartPackage.Literals.PROFILE__CONTROLLERS ) );
    }

    public void deactivate ()
    {
        if ( !this.active )
        {
            return;
        }

        this.active = false;

        logger.info ( "Deactivate profile: {}", this.profile.getId () ); //$NON-NLS-1$

        if ( this.binding != null )
        {
            this.binding.dispose ();
            this.binding = null;
        }

        if ( this.controllerManager != null )
        {
            this.controllerManager.dispose ();
            this.controllerManager = null;
        }
    }

    protected void fireSelection ( final boolean selection )
    {
        if ( selection )
        {
            this.manager.setActiveProfile ( this.profile );
        }
        else
        {
            this.manager.setActiveProfile ( null );
        }
    }

    public void dispose ()
    {
    }

}
