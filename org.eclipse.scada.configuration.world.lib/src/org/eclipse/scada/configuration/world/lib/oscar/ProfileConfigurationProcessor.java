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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.generator.Profiles;
import org.eclipse.scada.configuration.world.PropertyEntry;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.ProfileConfiguration;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

public class ProfileConfigurationProcessor extends TypedOscarProcessor<ProfileConfiguration>
{

    public ProfileConfigurationProcessor ()
    {
        super ( ProfileConfiguration.class );
    }

    @Override
    protected void process ( final ProfileConfiguration item, final EquinoxApplication app, final OscarContext ctx, final IProgressMonitor monitor )
    {
        final Profile profile = Profiles.createOrGetCustomizationProfile ( app );

        for ( final String bundle : item.getStartBundles () )
        {
            Profiles.addStartBundle ( profile, bundle );
            profile.getInstallationUnits ().add ( bundle );
        }

        for ( final String bundle : item.getInstallBundles () )
        {
            profile.getInstallationUnits ().add ( bundle );
        }

        for ( final PropertyEntry pe : item.getProperties () )
        {
            Profiles.addSystemProperty ( profile, pe.getKey (), pe.getValue () );
        }
    }

}
