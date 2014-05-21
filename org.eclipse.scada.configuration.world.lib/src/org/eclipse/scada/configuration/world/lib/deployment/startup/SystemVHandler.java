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
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.world.lib.utils.Helper;

public class SystemVHandler implements StartupHandler
{

    @Override
    public void createDriver ( final File packageFolder, final String driverName, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        File initFile;
        Helper.createFile ( initFile = new File ( packageFolder, "src/etc/init.d/scada.driver." + driverName ), SystemVHandler.class.getResourceAsStream ( "templates/redhat_sysv/driver.service.sh" ), replacements, monitor ); //$NON-NLS-1$
        initFile.setExecutable ( true );
    }

    private static Pattern ALT_PATTERN = Pattern.compile ( "\\@\\@(.*?)\\@\\@" ); //$NON-NLS-1$

    @Override
    public void createEquinox ( final File packageFolder, final String appName, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        {
            final File file = new File ( packageFolder, "src/etc/init.d/scada.app." + appName ); //$NON-NLS-1$
            Helper.createFile ( file, SystemVHandler.class.getResourceAsStream ( "templates/redhat_sysv/p2.service.sh" ), replacements, monitor, ALT_PATTERN ); //$NON-NLS-1$
            file.setExecutable ( true );
        }
        {
            final File file = new File ( packageFolder, "src/usr/bin/scada.app." + appName + ".launcher" ); //$NON-NLS-1$  //$NON-NLS-2$
            Helper.createFile ( file, SystemVHandler.class.getResourceAsStream ( "templates/redhat_sysv/p2.launcher.sh" ), replacements, monitor, ALT_PATTERN ); //$NON-NLS-1$
            file.setExecutable ( true );
        }
    }

}
