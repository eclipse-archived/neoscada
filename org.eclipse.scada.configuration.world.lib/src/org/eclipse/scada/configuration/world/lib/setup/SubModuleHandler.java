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
package org.eclipse.scada.configuration.world.lib.setup;

import java.util.Collection;

import org.eclipse.scada.configuration.world.lib.deployment.DeploymentContext;
import org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor;
import org.eclipse.scada.configuration.world.setup.SetupModule;
import org.eclipse.scada.configuration.world.setup.SubContainerModule;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;

public class SubModuleHandler implements SetupModuleHandler
{
    private final SubContainerModule module;

    public SubModuleHandler ( final SubContainerModule module )
    {
        this.module = module;
    }

    @Override
    public void perform ( final DeploymentContext context, final OperatingSystemDescriptor operatingSystem ) throws Exception
    {
        runSetup ( context, this.module.getContainer ().getModules (), operatingSystem );
    }

    public static void runSetup ( final DeploymentContext context, final Collection<? extends SetupModule> modules, final OperatingSystemDescriptor operatingSystem ) throws Exception
    {
        for ( final SetupModule module : modules )
        {
            final SetupModuleHandler handler = AdapterHelper.adapt ( module, SetupModuleHandler.class, true );
            if ( handler == null )
            {
                throw new IllegalStateException ( String.format ( "Unable to find setup handler for module: %s", module.eClass ().getName () ) );
            }
            handler.perform ( context, operatingSystem );
        }
    }

}
