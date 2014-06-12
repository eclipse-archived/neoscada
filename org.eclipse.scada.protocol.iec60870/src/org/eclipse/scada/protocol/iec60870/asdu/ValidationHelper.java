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
package org.eclipse.scada.protocol.iec60870.asdu;

import java.util.Set;

import org.eclipse.scada.protocol.iec60870.asdu.types.Cause;

public final class ValidationHelper
{

    private ValidationHelper ()
    {
    }

    public static void validateCause ( final Cause cause, final Set<Cause> validCauses, final String asduName ) throws ValidationException
    {
        if ( !validCauses.contains ( cause ) )
        {
            throw new ValidationException ( String.format ( "Cause %s is not valid for %s", cause, asduName ) );
        }
    }
}
