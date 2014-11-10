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

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism;
import org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor;
import org.eclipse.scada.configuration.world.setup.SetupModule;
import org.eclipse.scada.configuration.world.setup.SetupModuleContainer;

public class DeploymentSetupValidator extends AbstractModelConstraint
{
    @Override
    public IStatus validate ( final IValidationContext ctx )
    {
        if ( ctx.getTarget () instanceof CommonDeploymentMechanism )
        {
            final CommonDeploymentMechanism dep = (CommonDeploymentMechanism)ctx.getTarget ();
            final SetupModuleContainer smc = dep.getSetup ();

            final OperatingSystemDescriptor os = dep.getOperatingSystem ();

            final LinkedList<IStatus> result = new LinkedList<> ();

            if ( smc != null && os == null )
            {
                result.add ( ConstraintStatus.createStatus ( ctx, ctx.getTarget (), null, "The deployment mechansim has a setup module container set but no operating system assigned" ) );
            }
            else if ( smc != null )
            {
                addResult ( result, smc.validateOperatingSystem ( os, ctx ) );
            }

            if ( dep.getAdditionalSetupModules () != null && !dep.getAdditionalSetupModules ().isEmpty () && os == null )
            {
                result.add ( ConstraintStatus.createStatus ( ctx, ctx.getTarget (), null, "The deployment mechansim has a additional setup modules but no operating system assigned" ) );
            }
            else if ( smc != null )
            {
                for ( final SetupModule sm : dep.getAdditionalSetupModules () )
                {
                    addResult ( result, sm.validateOperatingSystem ( os, ctx ) );
                }
            }

            if ( result.isEmpty () )
            {
                return ctx.createSuccessStatus ();
            }
            else if ( result.size () == 1 )
            {
                return result.getFirst ();
            }
            else
            {
                return ConstraintStatus.createMultiStatus ( ctx, result );
            }
        }
        else
        {
            return ctx.createSuccessStatus ();
        }
    }

    private void addResult ( final Collection<? super IStatus> result, final IStatus status )
    {
        if ( status == null || status.isOK () )
        {
            return;
        }

        result.add ( status );
    }

}
