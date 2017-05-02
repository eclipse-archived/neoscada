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
package org.eclipse.scada.configuration.world.validation;

import org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism;
import org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor;
import org.eclipse.scada.configuration.world.setup.SetupModule;
import org.eclipse.scada.configuration.world.setup.SetupModuleContainer;
import org.eclipse.scada.utils.ecore.validation.TypedValidator;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;

public class CommonDeploymentMechanismValidator extends TypedValidator<CommonDeploymentMechanism>
{
    public CommonDeploymentMechanismValidator ()
    {
        super ( CommonDeploymentMechanism.class );
    }

    @Override
    protected void validate ( final CommonDeploymentMechanism dep, final ValidationContext ctx )
    {
        final SetupModuleContainer smc = dep.getSetup ();

        final OperatingSystemDescriptor os = dep.getOperatingSystem ();

        if ( smc != null && os == null )
        {
            ctx.add ( "The deployment mechansim has a setup module container set but no operating system assigned" );
        }
        else if ( smc != null )
        {
            smc.validateOperatingSystem ( os, ctx );
        }

        if ( dep.getAdditionalSetupModules () != null && !dep.getAdditionalSetupModules ().isEmpty () && os == null )
        {
            ctx.add ( "The deployment mechansim has a additional setup modules but no operating system assigned" );
        }
        else if ( smc != null )
        {
            for ( final SetupModule sm : dep.getAdditionalSetupModules () )
            {
                sm.validateOperatingSystem ( os, ctx );
            }
        }
    }
}
