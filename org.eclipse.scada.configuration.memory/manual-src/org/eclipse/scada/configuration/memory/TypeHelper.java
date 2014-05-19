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
package org.eclipse.scada.configuration.memory;

public final class TypeHelper
{
    private TypeHelper ()
    {
    }

    public static int calculateByteSize ( final int offset, final TypeDefinition typeDefinition )
    {
        if ( typeDefinition == null )
        {
            return 0;
        }

        int max = 0;

        for ( final Variable var : typeDefinition.getVariables () )
        {
            max = Math.max ( max, offset + var.getType ().getIndex () + var.getType ().getLength () );
            for ( final Attribute attr : var.getAttributes () )
            {
                max = Math.max ( max, offset + attr.getType ().getIndex () + attr.getType ().getLength () );
            }
        }

        return max;
    }

    public static int calculateByteSize ( final TypeDefinition typeDefinition )
    {
        return calculateByteSize ( 0, typeDefinition );
    }
}
