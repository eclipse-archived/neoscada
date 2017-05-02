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
package org.eclipse.scada.configuration.world.lib.oscar;

import org.eclipse.scada.configuration.generator.Profiles;
import org.eclipse.scada.configuration.world.DatabaseSettings;
import org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

public abstract class AbstractEventStorageJdbcModuleProcessor<T> extends BasicTypedOscarProcessor<T>
{

    private final EquinoxApplication app;

    public AbstractEventStorageJdbcModuleProcessor ( final EquinoxApplication app, final OscarContext ctx, final Class<T> clazz )
    {
        super ( app, ctx, clazz );
        this.app = app;
    }

    protected void processCommon ( final AbstractEventStorageJdbc module )
    {
        final Profile profile = Profiles.createOrGetCustomizationProfile ( this.app );

        final DatabaseSettings db = module.getDatabase ();

        for ( final String bundle : db.getBundles () )
        {
            Profiles.addStartBundle ( profile, bundle );
            profile.getInstallationUnits ().add ( bundle );
        }

        Profiles.addJdbcSystemProperties ( profile, "org.eclipse.scada.ae.server.storage.jdbc", db );

        Profiles.addSystemProperty ( profile, "org.eclipse.scada.ae.server.storage.jdbc.schema", module.getSchema () );
        Profiles.addSystemProperty ( profile, "org.eclipse.scada.ae.server.storage.jdbc.instance", module.getInstanceName () );
        Profiles.addSystemProperty ( profile, "org.eclipse.scada.ae.server.storage.jdbc.enableReplication", module.isEnableReplication () );
        Profiles.addSystemProperty ( profile, "org.eclipse.scada.ae.server.storage.jdbc.replicationDataFormat", module.getReplicationDataFormat ().getLiteral () );
        Profiles.addSystemProperty ( profile, "org.eclipse.scada.ae.server.storage.jdbc.cleanupPeriodSeconds", module.getCleanupPeriodSeconds () );
        Profiles.addSystemProperty ( profile, "org.eclipse.scada.ae.server.storage.jdbc.archiveDays", module.getArchiveDays () );
    }

}