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
package org.eclipse.scada.configuration.component.common.validation;

import org.eclipse.scada.configuration.component.common.CommonPackage;
import org.eclipse.scada.configuration.component.common.ScaledValue;
import org.eclipse.scada.ide.validation.Severity;
import org.eclipse.scada.ide.validation.TypedValidator;
import org.eclipse.scada.ide.validation.ValidationContext;

public class ScaledValueValidator extends TypedValidator<ScaledValue>
{

    public ScaledValueValidator ()
    {
        super ( ScaledValue.class );
    }

    @Override
    protected void validate ( final ScaledValue target, final ValidationContext context )
    {
        {
            final double diff = target.getInputMaximum () - target.getInputMinimum ();
            if ( diff == 0.0 )
            {
                context.add ( Severity.ERROR, new Object[] { target, CommonPackage.Literals.SCALED_VALUE__INPUT_MINIMUM, CommonPackage.Literals.SCALED_VALUE__INPUT_MAXIMUM }, "Input minimum and maximum must not be equal" );
            }
        }
        {
            final double diff = target.getOutputMaximum () - target.getOutputMinimum ();
            if ( diff == 0.0 )
            {
                context.add ( Severity.ERROR, new Object[] { target, CommonPackage.Literals.SCALED_VALUE__OUTPUT_MINIMUM, CommonPackage.Literals.SCALED_VALUE__OUTPUT_MAXIMUM }, "Output minimum and maximum must not be equal" );
            }
        }
    }

}
