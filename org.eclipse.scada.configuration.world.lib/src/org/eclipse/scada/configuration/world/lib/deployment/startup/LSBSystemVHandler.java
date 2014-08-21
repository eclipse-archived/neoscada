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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.world.lib.deployment.Contents;
import org.eclipse.scada.configuration.world.lib.deployment.ResourceInformation;
import org.eclipse.scada.configuration.world.lib.deployment.ResourceInformation.Type;
import org.eclipse.scada.utils.pkg.deb.BinaryPackageBuilder;
import org.eclipse.scada.utils.pkg.deb.EntryInformation;

public class LSBSystemVHandler implements StartupHandler
{

    private static Pattern ALT_PATTERN = Pattern.compile ( "\\@\\@(.*?)\\@\\@" ); //$NON-NLS-1$

    @Override
    public void createDriver ( final BinaryPackageBuilder builder, final String driverName, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        builder.addFile ( Contents.createContent ( LSBSystemVHandler.class.getResourceAsStream ( "templates/lsb_sysv/driver.service.sh" ), replacements, ALT_PATTERN ), "/etc/init.d/scada.driver." + driverName, EntryInformation.DEFAULT_FILE_EXEC );
    }

    @Override
    public void createEquinox ( final BinaryPackageBuilder builder, final String appName, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        builder.addFile ( Contents.createContent ( LSBSystemVHandler.class.getResourceAsStream ( "templates/lsb_sysv/p2.service.sh" ), replacements, ALT_PATTERN ), "/etc/init.d/scada.app." + appName, EntryInformation.DEFAULT_FILE_EXEC );
        builder.addFile ( Contents.createContent ( LSBSystemVHandler.class.getResourceAsStream ( "templates/redhat_sysv/p2.launcher.sh" ), replacements, ALT_PATTERN ), "/usr/bin/scada.app." + appName + ".launcher", EntryInformation.DEFAULT_FILE_EXEC );
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
    public String startDriverCommand ( final String driverName )
    {
        return "/etc/init.d/scada.driver." + driverName + " start";
    }

    @Override
    public String stopDriverCommand ( final String driverName )
    {
        return "/etc/init.d/scada.driver." + driverName + " stop";
    }

    @Override
    public String startEquinoxCommand ( final String appName )
    {
        return "/etc/init.d/scada.app." + appName + " start";
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
