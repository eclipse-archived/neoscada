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
package org.eclipse.scada.configuration.world.validation;

import org.eclipse.scada.configuration.world.deployment.ChangeEntry;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.utils.ecore.validation.TypedValidator;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;

public class ChangeEntryValidator extends TypedValidator<ChangeEntry>
{
    private static final int MIN_DESC_LENGTH = 10;

    public ChangeEntryValidator ()
    {
        super ( ChangeEntry.class );
    }

    @Override
    protected void validate ( final ChangeEntry target, final ValidationContext context )
    {
        if ( target.getDescription () != null )
        {
            if ( target.getDescription ().length () < MIN_DESC_LENGTH )
            {
                context.add ( DeploymentPackage.Literals.CHANGE_ENTRY__DESCRIPTION, "The description must have a minimum length of {0} characters", MIN_DESC_LENGTH );
            }
        }
    }
}
