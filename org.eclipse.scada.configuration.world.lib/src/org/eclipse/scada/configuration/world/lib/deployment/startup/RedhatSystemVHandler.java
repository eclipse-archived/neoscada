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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.world.lib.deployment.startup.ResourceInformation.Type;
import org.eclipse.scada.configuration.world.lib.utils.Helper;

public class RedhatSystemVHandler implements StartupHandler
{

    private static Pattern ALT_PATTERN = Pattern.compile ( "\\@\\@(.*?)\\@\\@" ); //$NON-NLS-1$

    @Override
    public void createDriver ( final File packageFolder, final String driverName, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        File initFile;
        Helper.createFile ( initFile = new File ( packageFolder, "src/etc/init.d/scada.driver." + driverName ), RedhatSystemVHandler.class.getResourceAsStream ( "templates/redhat_sysv/driver.service.sh" ), replacements, monitor, ALT_PATTERN ); //$NON-NLS-1$
        initFile.setExecutable ( true );
    }

    @Override
    public void createEquinox ( final File packageFolder, final String appName, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        {
            final File file = new File ( packageFolder, "src/etc/init.d/scada.app." + appName ); //$NON-NLS-1$
            Helper.createFile ( file, RedhatSystemVHandler.class.getResourceAsStream ( "templates/redhat_sysv/p2.service.sh" ), replacements, monitor, ALT_PATTERN ); //$NON-NLS-1$
            file.setExecutable ( true );
        }
        {
            final File file = new File ( packageFolder, "src/usr/bin/scada.app." + appName + ".launcher" ); //$NON-NLS-1$  //$NON-NLS-2$
            Helper.createFile ( file, RedhatSystemVHandler.class.getResourceAsStream ( "templates/redhat_sysv/p2.launcher.sh" ), replacements, monitor, ALT_PATTERN ); //$NON-NLS-1$
            file.setExecutable ( true );
        }
    }

    @Override
    public Set<ResourceInformation> getDriverFiles ( final String driverName )
    {
        final Set<ResourceInformation> result = new HashSet<> ();

        result.add ( new ResourceInformation ( "/etc/init.d/scada.driver." + driverName, Type.EXECUTABLE ) );

        return result;
    }

    @Override
    public Set<ResourceInformation> getEquinoxFiles ( final String appName )
    {
        final Set<ResourceInformation> result = new HashSet<> ();

        result.add ( new ResourceInformation ( "/etc/init.d/scada.app." + appName, Type.EXECUTABLE ) );
        result.add ( new ResourceInformation ( "/etc/init.d/scada.app." + appName, Type.EXECUTABLE ) );
        result.add ( new ResourceInformation ( "/usr/bin/scada.app." + appName + ".launcher", Type.EXECUTABLE ) );

        return result;
    }

    @Override
    public String restartDriverCommand ( final String driverName )
    {
        return "/etc/init.d/scada.driver." + driverName + " condrestart";
    }

    @Override
    public String stopDriverCommand ( final String driverName )
    {
        return "/etc/init.d/scada.driver." + driverName + " stop";
    }

    @Override
    public String restartEquinoxCommand ( final String appName )
    {
        return "/etc/init.d/scada.app." + appName + " condrestart";
    }

    @Override
    public String stopEquinoxCommand ( final String appName )
    {
        return "/etc/init.d/scada.app." + appName + " stop";
    }

    @Override
    public Set<String> getAdditionalPackageDependencies ()
    {
        return Collections.singleton ( "screen" );
    }
}
