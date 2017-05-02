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

import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.icu.text.MessageFormat;

public final class Validations
{
    private Validations ()
    {
    }

    public static final void validateRange ( final ValidationContext context, final EStructuralFeature feature, final long value, final Long min, final Long max, final String label )
    {
        if ( min != null && value < min )
        {
            context.add ( feature, MessageFormat.format ( "''{0}'' be greater or equal to {1,number,integer}", label, min ) );
        }
        if ( max != null && value > max )
        {
            context.add ( feature, MessageFormat.format ( "''{0}'' be less or equal to {1,number,integer}", label, min ) );
        }
    }
}
