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
package org.eclipse.scada.utils.ecore.validation;

import org.eclipse.emf.ecore.EValidator;

public class ExtensibleValidationDescriptor implements EValidator.Descriptor
{
    private final EValidator[] otherValidators;

    public ExtensibleValidationDescriptor ( final EValidator... otherValidators )
    {
        this.otherValidators = otherValidators;
    }

    @Override
    public EValidator getEValidator ()
    {
        return new ExtensibleValidator ( this.otherValidators );
    }
}
