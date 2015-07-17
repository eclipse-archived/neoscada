/*******************************************************************************
 * Copyright (c) 2014, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.infrastructure.lib;

import java.util.Collection;

import org.eclipse.scada.configuration.infrastructure.Module;
import org.eclipse.scada.configuration.world.osgi.ApplicationModule;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;

public interface ModuleHandler
{
    public void process ( Module module, Collection<ApplicationModule> modules, org.eclipse.scada.configuration.infrastructure.EquinoxBase app, EquinoxApplication implApp );
}
