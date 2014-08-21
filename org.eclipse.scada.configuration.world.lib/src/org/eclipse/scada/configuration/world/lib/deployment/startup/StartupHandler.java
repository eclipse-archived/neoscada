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

import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.world.lib.deployment.ResourceInformation;
import org.eclipse.scada.utils.pkg.deb.BinaryPackageBuilder;

public interface StartupHandler
{
    public void createDriver ( BinaryPackageBuilder builder, String driverName, Map<String, String> replacements, IProgressMonitor monitor ) throws Exception;

    public void createEquinox ( BinaryPackageBuilder builder, String appName, Map<String, String> replacements, IProgressMonitor monitor ) throws Exception;

    public String startDriverCommand ( String driverName );

    public String stopDriverCommand ( String driverName );

    public String startEquinoxCommand ( String appName );

    public String stopEquinoxCommand ( String appName );

    public Set<ResourceInformation> getDriverFiles ( String driverName );

    public Set<ResourceInformation> getEquinoxFiles ( String appName );

    public Set<String> getAdditionalPackageDependencies ();
}
