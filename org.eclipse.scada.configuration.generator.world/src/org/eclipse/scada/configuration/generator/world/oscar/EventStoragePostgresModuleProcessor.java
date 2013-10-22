/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.generator.world.oscar;

import org.eclipse.scada.configuration.generator.Profiles;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.EventStoragePostgres;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

public class EventStoragePostgresModuleProcessor extends AbstractEventStorageJdbcModuleProcessor<EventStoragePostgres>
{
    final EquinoxApplication app;

    public EventStoragePostgresModuleProcessor ( final EquinoxApplication app, final OscarContext ctx )
    {
        super ( app, ctx, EventStoragePostgres.class );
        this.app = app;
    }

    @Override
    protected void process ( final EventStoragePostgres module )
    {
        final Profile profile = Profiles.createOfGetCustomizationProfile ( this.app );

        processCommon ( module );

        Profiles.addStartBundle ( profile, "org.eclipse.scada.ae.server.storage.postgres" ); //$NON-NLS-1$
        Profiles.addSystemProperty ( profile, "org.eclipse.scada.ae.server.storage.postgres.batchSize", "" + module.getBatchSize (), false ); //$NON-NLS-1$ //$NON-NLS-2$
    }
}
