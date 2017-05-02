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

import org.eclipse.scada.configuration.infrastructure.SystemPropertyUserService;
import org.eclipse.scada.utils.ecore.validation.Severity;
import org.eclipse.scada.utils.ecore.validation.TypedValidator;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;

public class SystemPropertyUserServiceValidator extends TypedValidator<SystemPropertyUserService>
{

    public SystemPropertyUserServiceValidator ()
    {
        super ( SystemPropertyUserService.class );
    }

    @Override
    protected void validate ( final SystemPropertyUserService target, final ValidationContext context )
    {
        context.add ( Severity.WARNING, null, "The SystemPropertyUserService should not be used in productive environments" );
    }

}
