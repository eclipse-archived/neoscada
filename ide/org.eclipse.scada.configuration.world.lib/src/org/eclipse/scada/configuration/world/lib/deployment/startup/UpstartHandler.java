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
package org.eclipse.scada.configuration.world.lib.deployment.startup;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.world.lib.deployment.Contents;
import org.eclipse.scada.configuration.world.lib.deployment.DeploymentContext;
import org.eclipse.scada.configuration.world.lib.deployment.FileInformation;
import org.eclipse.scada.configuration.world.lib.deployment.FileOptions;
import org.eclipse.scada.configuration.world.lib.deployment.OperatingSystemDescriptors;
import org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor;

public class UpstartHandler extends AbstractStartupHandler
{

    private final OperatingSystemDescriptor operatingSystem;

    public UpstartHandler ( final OperatingSystemDescriptor operatingSystem )
    {
        this.operatingSystem = operatingSystem;
    }

    protected boolean needScreenFix ()
    {
        return OperatingSystemDescriptors.isProperty ( this.operatingSystem, "screen.pre.start", false ); //$NON-NLS-1$
    }

    @Override
    public void createDriver ( final DeploymentContext context, final String driverName, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        context.addFile ( Contents.createContent ( UpstartHandler.class.getResourceAsStream ( "templates/upstart/driver.upstart.conf" ), replacements ), "/etc/init/scada.driver." + driverName + ".conf", new FileInformation ( 0644, null, null, FileOptions.CONFIGURATION ) );
    }

    @Override
    public void createEquinox ( final DeploymentContext context, final String appName, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        if ( needScreenFix () )
        {
            context.addFile ( Contents.createContent ( UpstartHandler.class.getResourceAsStream ( "templates/upstart/app.upstart.sf.conf" ), replacements ), "/etc/init/scada.app." + appName + ".conf", new FileInformation ( 0644, null, null, FileOptions.CONFIGURATION ) );
        }
        else
        {
            context.addFile ( Contents.createContent ( UpstartHandler.class.getResourceAsStream ( "templates/upstart/app.upstart.conf" ), replacements ), "/etc/init/scada.app." + appName + ".conf", new FileInformation ( 0644, null, null, FileOptions.CONFIGURATION ) );
        }
    }

    @Override
    public String[] startDriverCommand ( final String driverName )
    {
        return new String[] { "start scada.driver." + driverName };
    }

    @Override
    public String[] stopDriverCommand ( final String driverName )
    {
        return new String[] { "stop scada.driver." + driverName };
    }

    @Override
    public String[] startEquinoxCommand ( final String appName )
    {
        return new String[] { "start scada.app." + appName };
    }

    @Override
    public String[] stopEquinoxCommand ( final String appName )
    {
        return new String[] { "stop scada.app." + appName };
    }

    @Override
    public Set<String> getAdditionalPackageDependencies ()
    {
        return Collections.singleton ( "screen" );
    }
}
