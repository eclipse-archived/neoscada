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
import org.eclipse.scada.configuration.world.DatabaseSettings;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.EventInjector;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

public abstract class AbstractEventInjector<T extends EventInjector> extends BasicTypedOscarProcessor<T>
{

    public AbstractEventInjector ( final EquinoxApplication app, final OscarContext ctx, final Class<T> clazz )
    {
        super ( app, ctx, clazz );
    }

    protected void processCommon ( final String prefix, final EventInjector module )
    {
        final DatabaseSettings db = module.getDatabase ();

        final Profile profile = Profiles.createOrGetCustomizationProfile ( this.app );

        Profiles.addSystemProperty ( profile, prefix + ".schema", module.getSchema () );
        Profiles.addSystemProperty ( profile, prefix + ".replicationSchema", module.getReplicationSchema () );

        Profiles.addSystemProperty ( profile, prefix + ".loopDelay", module.getLoopDelay () );
        Profiles.addSystemProperty ( profile, prefix + ".instance", module.getInstanceName () );
        Profiles.addSystemProperty ( profile, prefix + ".deleteFailed", module.isDeleteFailed () );

        Profiles.addJdbcSystemProperties ( profile, prefix, db );
    }
}