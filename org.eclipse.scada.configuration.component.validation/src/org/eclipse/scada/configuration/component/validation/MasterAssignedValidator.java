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

import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.MasterAssigned;
import org.eclipse.scada.utils.ecore.validation.Severity;
import org.eclipse.scada.utils.ecore.validation.TypedValidator;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;

public class MasterAssignedValidator extends TypedValidator<MasterAssigned>
{
    public MasterAssignedValidator ()
    {
        super ( MasterAssigned.class );
    }

    @Override
    protected void validate ( final MasterAssigned target, final ValidationContext context )
    {
        if ( target.getMasterOn ().isEmpty () )
        {
            context.add ( ComponentPackage.Literals.MASTER_ASSIGNED__MASTER_ON, Severity.WARNING, "Component is not assigned to any master server" );
        }
    }

}
