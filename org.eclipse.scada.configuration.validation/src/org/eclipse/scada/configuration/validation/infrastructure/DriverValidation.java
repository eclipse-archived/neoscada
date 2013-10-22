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
package org.eclipse.scada.configuration.validation.infrastructure;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.lib.Activator;
import org.eclipse.scada.configuration.infrastructure.lib.DriverFactory;

public class DriverValidation extends AbstractModelConstraint
{

    public DriverValidation ()
    {
    }

    @Override
    public IStatus validate ( final IValidationContext ctx )
    {
        if ( ! ( ctx.getTarget () instanceof AbstractFactoryDriver ) )
        {
            return ctx.createSuccessStatus ();
        }

        final AbstractFactoryDriver driver = (AbstractFactoryDriver)ctx.getTarget ();
        if ( driver.getDriverTypeId () == null || driver.getDriverTypeId ().isEmpty () )
        {
            // this is a success since further validation cannot be performed and the ECore model itself will
            // complain about an empty value
            return ctx.createSuccessStatus ();
        }

        final DriverFactory factory = Activator.findDriverFactory ( driver.getDriverTypeId () );

        if ( factory == null )
        {
            return ConstraintStatus.createStatus ( ctx, driver, null, "There is no driver factory for type id \"{0}\"", driver.getDriverTypeId () );
        }

        return factory.validate ( ctx, driver );
    }
}
