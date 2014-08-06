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

package org.eclipse.scada.configuration.validation.world.deployment;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism;
import org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor;
import org.eclipse.scada.configuration.world.setup.SetupModuleContainer;

public class DeploymentSetupValidator extends AbstractModelConstraint
{
    @Override
    public IStatus validate ( final IValidationContext ctx )
    {
        if ( ctx.getTarget () instanceof DebianDeploymentMechanism )
        {
            final DebianDeploymentMechanism dep = (DebianDeploymentMechanism)ctx.getTarget ();
            final SetupModuleContainer smc = dep.getSetup ();

            final OperatingSystemDescriptor os = dep.getOperatingSystem ();

            if ( smc != null && os == null )
            {
                return ConstraintStatus.createStatus ( ctx, ctx.getTarget (), null, "The deployment mechansim has a setup module container set but no operating system assigned" );
            }
            if ( smc != null )
            {
                return smc.validateOperatingSystem ( os, ctx );
            }
        }
        return ctx.createSuccessStatus ();
    }

}
