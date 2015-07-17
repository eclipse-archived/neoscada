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
package org.eclipse.scada.configuration.infrastructure.validation;

import org.eclipse.scada.configuration.infrastructure.EquinoxBase;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.utils.ecore.validation.TypedValidator;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;

public class EquinoxBaseValidator extends TypedValidator<EquinoxBase>
{
    public EquinoxBaseValidator ()
    {
        super ( EquinoxBase.class );
    }

    @Override
    protected void validate ( final EquinoxBase target, final ValidationContext context )
    {
        if ( target.getInstanceNumber () <= 0 )
        {
            context.add ( InfrastructurePackage.Literals.EQUINOX_BASE__INSTANCE_NUMBER, "Instance number must be greater than zero (is {})", target.getInstanceNumber () );
        }
    }
}
