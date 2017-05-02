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
package org.eclipse.scada.configuration.infrastructure.validation;

import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.lib.Activator;
import org.eclipse.scada.configuration.infrastructure.lib.DriverFactory;
import org.eclipse.scada.utils.ecore.validation.TypedValidator;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;

public class DriverValidator extends TypedValidator<AbstractFactoryDriver>
{

    public DriverValidator ()
    {
        super ( AbstractFactoryDriver.class );
    }

    @Override
    protected void validate ( final AbstractFactoryDriver target, final ValidationContext context )
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
            context.add ( "There is no driver factory for type id \"{0}\"", driver.getDriverTypeId () );
            return;
        }

        factory.validate ( context, driver );
    }

}
