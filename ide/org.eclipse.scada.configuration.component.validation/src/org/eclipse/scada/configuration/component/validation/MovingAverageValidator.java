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
package org.eclipse.scada.configuration.component.validation;

import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.MovingAverageModule;
import org.eclipse.scada.utils.ecore.validation.TypedValidator;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;
import org.eclipse.scada.utils.ecore.validation.Validations;

public class MovingAverageValidator extends TypedValidator<MovingAverageModule>
{

    public MovingAverageValidator ()
    {
        super ( MovingAverageModule.class );
    }

    @Override
    protected void validate ( final MovingAverageModule target, final ValidationContext context )
    {
        Validations.validateRange ( context, ComponentPackage.Literals.MOVING_AVERAGE_MODULE__RANGE, target.getRange (), 1L, null, "Range" );
        Validations.validateRange ( context, ComponentPackage.Literals.MOVING_AVERAGE_MODULE__NULL_RANGE, target.getNullRange (), 1L, target.getRange (), "Null range" );
        Validations.validateRange ( context, ComponentPackage.Literals.MOVING_AVERAGE_MODULE__TRIGGER, target.getTrigger (), 0L, null, "Trigger" );
    }

}
