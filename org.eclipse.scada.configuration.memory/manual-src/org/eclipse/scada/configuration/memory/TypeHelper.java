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

import java.util.HashSet;
import java.util.Set;

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
            if ( var.getType () == null )
            {
                continue;
            }

            max = Math.max ( max, offset + var.getType ().getIndex () + var.getType ().getLength () );
            for ( final Attribute attr : var.getAttributes () )
            {
                if ( attr.getType () == null )
                {
                    continue;
                }
                max = Math.max ( max, offset + attr.getType ().getIndex () + attr.getType ().getLength () );
            }
        }

        return max;
    }

    public static int calculateByteSize ( final TypeDefinition typeDefinition )
    {
        return calculateByteSize ( 0, typeDefinition );
    }

    /**
     * Test if a type system contains the type
     * 
     * @param typeSystem
     *            the type system
     * @param type
     *            the type to look for
     * @return <code>true</code> if the type system provides the type,
     *         <code>false</code> otherwise
     */
    public static boolean hasType ( final TypeSystem typeSystem, final TypeDefinition type )
    {
        final Set<TypeSystem> ctx = new HashSet<> ();
        return hasType ( ctx, typeSystem, type );
    }

    private static boolean hasType ( final Set<TypeSystem> ctx, final TypeSystem typeSystem, final TypeDefinition type )
    {
        if ( ctx.contains ( typeSystem ) )
        {
            return false;
        }

        ctx.add ( typeSystem );
        if ( typeSystem.getTypes ().contains ( type ) )
        {
            return true;
        }

        for ( final TypeSystem include : typeSystem.getIncludes () )
        {
            if ( hasType ( ctx, include, type ) )
            {
                return true;
            }
        }

        return false;
    }
}
