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
package org.eclipse.scada.configuration.component.validation;

import org.eclipse.scada.configuration.component.CalculationComponent;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.utils.ecore.validation.TypedValidator;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;

public class CalculationComponentValidator extends TypedValidator<CalculationComponent>
{

    public CalculationComponentValidator ()
    {
        super ( CalculationComponent.class );
    }

    @Override
    protected void validate ( final CalculationComponent target, final ValidationContext context )
    {
        if ( target.getImplementation () == null )
        {
            context.add ( ComponentPackage.Literals.CALCULATION_COMPONENT__IMPLEMENTATION, "No implementation is assigned for the calculation component" );
        }
    }

}
