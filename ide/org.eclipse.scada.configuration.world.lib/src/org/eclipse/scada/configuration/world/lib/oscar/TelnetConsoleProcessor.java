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
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.TelnetConsole;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

public class TelnetConsoleProcessor extends TypedOscarProcessor<TelnetConsole>
{

    public TelnetConsoleProcessor ()
    {
        super ( TelnetConsole.class );
    }

    @Override
    protected void process ( final TelnetConsole item, final EquinoxApplication app, final OscarContext ctx, final IProgressMonitor monitor )
    {
        final Profile profile = Profiles.createOrGetCustomizationProfile ( app );

        if ( item.getHost () != null )
        {
            Profiles.addProgramArugment ( profile, "-console" );
            Profiles.addProgramArugment ( profile, item.getHost () + ":" + item.getPort () );
        }
        else
        {
            Profiles.addProgramArugment ( profile, "" + item.getPort () );
        }

    }

}
