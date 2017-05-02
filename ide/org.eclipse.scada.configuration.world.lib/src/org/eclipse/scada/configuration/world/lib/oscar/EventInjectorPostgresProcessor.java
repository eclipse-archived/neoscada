/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.lib.oscar;

import org.eclipse.scada.configuration.generator.Profiles;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.EventInjectorPostgres;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

public class EventInjectorPostgresProcessor extends AbstractEventInjector<EventInjectorPostgres>
{
    private static final String BUNDLE_NAME = "org.eclipse.scada.ae.slave.inject.postgres"; //$NON-NLS-1$

    private final EquinoxApplication app;

    public EventInjectorPostgresProcessor ( final EquinoxApplication app, final OscarContext ctx )
    {
        super ( app, ctx, EventInjectorPostgres.class );
        this.app = app;
    }

    @Override
    protected void process ( final EventInjectorPostgres module )
    {
        final Profile profile = Profiles.createOrGetCustomizationProfile ( this.app );

        processCommon ( BUNDLE_NAME, module );

        profile.getInstallationUnits ().add ( BUNDLE_NAME );
        Profiles.addStartBundle ( profile, BUNDLE_NAME );

        Profiles.addSystemProperty ( profile, BUNDLE_NAME + ".limit", module.getLimit () ); //$NON-NLS-1$
    }

}
