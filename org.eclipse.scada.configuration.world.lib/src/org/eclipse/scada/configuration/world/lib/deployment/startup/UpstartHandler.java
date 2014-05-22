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
package org.eclipse.scada.configuration.world.lib.deployment.startup;

import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.world.lib.deployment.startup.ResourceInformation.Type;
import org.eclipse.scada.configuration.world.lib.utils.Helper;

public class UpstartHandler implements StartupHandler
{

    @Override
    public void createDriver ( final File packageFolder, final String driverName, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        Helper.createFile ( new File ( packageFolder, "src/etc/init/scada.driver." + driverName + ".conf" ), UpstartHandler.class.getResourceAsStream ( "templates/upstart/driver.upstart.conf" ), replacements, monitor );
    }

    @Override
    public void createEquinox ( final File packageFolder, final String appName, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        Helper.createFile ( new File ( packageFolder, "src/etc/init/scada.app." + appName + ".conf" ), UpstartHandler.class.getResourceAsStream ( "templates/upstart/app.upstart.conf" ), replacements, monitor );
    }

    @Override
    public Set<ResourceInformation> getDriverFiles ( final String driverName )
    {
        return Collections.singleton ( new ResourceInformation ( "/etc/init/scada.driver." + driverName + ".conf", Type.FILE ) );
    }

    @Override
    public Set<ResourceInformation> getEquinoxFiles ( final String appName )
    {
        return Collections.singleton ( new ResourceInformation ( "/etc/init/scada.app." + appName + ".conf", Type.FILE ) );
    }

    @Override
    public String restartDriverCommand ( final String driverName )
    {
        return "restart scada.driver." + driverName;
    }

    @Override
    public String stopDriverCommand ( final String driverName )
    {
        return "stop scada.driver." + driverName;
    }

    @Override
    public String restartEquinoxCommand ( final String appName )
    {
        return null;
    }

    @Override
    public String stopEquinoxCommand ( final String appName )
    {
        return null;
    }

    @Override
    public Set<String> getAdditionalPackageDependencies ()
    {
        return Collections.singleton ( "screen" );
    }
}
