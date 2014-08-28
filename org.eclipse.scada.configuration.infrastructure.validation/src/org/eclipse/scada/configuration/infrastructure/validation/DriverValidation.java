/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.infrastructure.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.ide.validation.AbstractTargetValidator;
import org.eclipse.scada.ide.validation.ValidationContext;

public class DriverValidation extends AbstractTargetValidator<AbstractFactoryDriver>
{

    public DriverValidation ()
    {
        super ( AbstractFactoryDriver.class, Validation.VALIDATION_CONTEXT_ID );
    }

    @Override
    protected void performValidation ( final AbstractFactoryDriver target, final ValidationContext ctx )
    {
        final AbstractFactoryDriver driver = target;
        if ( driver.getDriverTypeId () == null || driver.getDriverTypeId ().isEmpty () )
        {
            // this is a success since further validation cannot be performed and the ECore model itself will
            // complain about an empty value
            return;
        }

        final DriverFactory factory = Activator.findDriverFactory ( driver.getDriverTypeId () );

        if ( factory == null )
        {
            ctx.add ( "There is no driver factory for type id \"{0}\"", driver.getDriverTypeId () );
            return;
        }

        return factory.validate ( ctx, driver );
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
