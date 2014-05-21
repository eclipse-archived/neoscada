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

import org.eclipse.core.runtime.IProgressMonitor;

public interface StartupHandler
{
    public void createDriver ( File packageFolder, String driverName, Map<String, String> replacements, IProgressMonitor monitor ) throws Exception;

    public void createEquinox ( File packageFolder, String appName, Map<String, String> replacements, IProgressMonitor monitor ) throws Exception;
}
