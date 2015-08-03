/*******************************************************************************
 * Copyright (c) 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.infrastructure.lib.internal;

import java.util.Collection;

import org.eclipse.scada.configuration.generator.Profiles;
import org.eclipse.scada.configuration.infrastructure.ConfigurationAdminSettings;
import org.eclipse.scada.configuration.infrastructure.EquinoxBase;
import org.eclipse.scada.configuration.infrastructure.Module;
import org.eclipse.scada.configuration.infrastructure.lib.ModuleHandler;
import org.eclipse.scada.configuration.world.osgi.ApplicationModule;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

public class CASettingsModuleHandler implements ModuleHandler
{
    @Override
    public void process ( final Module module, final Collection<ApplicationModule> modules, final EquinoxBase app, final org.eclipse.scada.configuration.world.osgi.EquinoxApplication implApp )
    {
        final ConfigurationAdminSettings s = (ConfigurationAdminSettings)module;

        final Profile p = Profiles.createOrGetCustomizationProfile ( implApp );

        if ( s.isAutomaticMerge () )
        {
            Profiles.addSystemProperty ( p, "org.eclipse.scada.ca.updater.active", "true" );
            if ( s.getSettleTimeout () != null )
            {
                Profiles.addSystemProperty ( p, "org.eclipse.scada.ca.updater.watcher.settleTimeout", s.getSettleTimeout ().toString () );
            }
            Profiles.addStartBundle ( p, "org.eclipse.scada.ca.updater" );
        }
    }
}
