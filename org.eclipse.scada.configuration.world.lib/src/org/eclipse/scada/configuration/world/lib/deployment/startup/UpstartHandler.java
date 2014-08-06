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

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.world.lib.deployment.Contents;
import org.eclipse.scada.configuration.world.lib.deployment.startup.ResourceInformation.Type;
import org.eclipse.scada.utils.pkg.deb.BinaryPackageBuilder;
import org.eclipse.scada.utils.pkg.deb.EntryInformation;

public class UpstartHandler implements StartupHandler
{

    @Override
    public void createDriver ( final BinaryPackageBuilder builder, final String driverName, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        builder.addFile ( Contents.createContent ( RedhatSystemVHandler.class.getResourceAsStream ( "templates/upstart/driver.upstart.conf" ), replacements ), "/etc/init/scada.driver." + driverName + ".conf", EntryInformation.DEFAULT_FILE_CONF );
    }

    @Override
    public void createEquinox ( final BinaryPackageBuilder builder, final String appName, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        builder.addFile ( Contents.createContent ( RedhatSystemVHandler.class.getResourceAsStream ( "templates/upstart/app.upstart.conf" ), replacements ), "/etc/init/scada.app." + appName + ".conf", EntryInformation.DEFAULT_FILE_CONF );
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
    public String startDriverCommand ( final String driverName )
    {
        return "start scada.driver." + driverName;
    }

    @Override
    public String stopDriverCommand ( final String driverName )
    {
        return "stop scada.driver." + driverName;
    }

    @Override
    public String startEquinoxCommand ( final String appName )
    {
        return "start scada.app." + appName;
    }

    @Override
    public String stopEquinoxCommand ( final String appName )
    {
        return "stop scada.app." + appName;
    }

    @Override
    public Set<String> getAdditionalPackageDependencies ()
    {
        return Collections.singleton ( "screen" );
    }
}
