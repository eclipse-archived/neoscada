/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/

package org.eclipse.scada.configuration.validation.internal;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.setup.SetupPackage;
import org.eclipse.ui.IStartup;

/**
 * Installs an EMF <code>EValidator</code> on the Model package when we
 * start up. This validator adapts EMF's <code>EValidator</code> API to the
 * EMF Model Validation Service API.
 */
public class Startup implements IStartup
{
    @Override
    public void earlyStartup ()
    {
        EValidator.Registry.INSTANCE.put ( ComponentPackage.eINSTANCE, new EValidatorAdapter () );
        EValidator.Registry.INSTANCE.put ( InfrastructurePackage.eINSTANCE, new EValidatorAdapter () );
        EValidator.Registry.INSTANCE.put ( WorldPackage.eINSTANCE, new EValidatorAdapter () );
        EValidator.Registry.INSTANCE.put ( DeploymentPackage.eINSTANCE, new EValidatorAdapter () );
        EValidator.Registry.INSTANCE.put ( SetupPackage.eINSTANCE, new EValidatorAdapter () );
    }
}
