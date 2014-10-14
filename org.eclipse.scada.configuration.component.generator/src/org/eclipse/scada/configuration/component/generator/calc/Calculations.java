/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.generator.calc;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.configuration.component.CalculationModule;
import org.eclipse.scada.configuration.component.InputDefinition;
import org.eclipse.scada.configuration.component.OutputDefinition;
import org.eclipse.scada.configuration.component.OutputSpecification;

public final class Calculations
{
    private Calculations ()
    {
    }

    public static OutputDefinition findSingleByName ( final Collection<OutputDefinition> defs, final String name )
    {
        for ( final OutputDefinition def : defs )
        {
            if ( name.equals ( def.getName () ) )
            {
                return def;
            }
        }

        throw new IllegalArgumentException ( String.format ( "Unable to find an output named '%s'", name ) );
    }

    public static InputDefinition findSingleInputByName ( final Collection<InputDefinition> defs, final String name )
    {
        for ( final InputDefinition def : defs )
        {
            if ( name.equals ( def.getName () ) )
            {
                return def;
            }
        }

        throw new IllegalArgumentException ( String.format ( "Unable to find an input named '%s'", name ) );
    }

    public static List<InputDefinition> findByName ( final Collection<InputDefinition> defs, final String name )
    {
        if ( name == null )
        {
            return Collections.emptyList ();
        }

        final List<InputDefinition> result = new LinkedList<> ();

        for ( final InputDefinition def : defs )
        {
            if ( name.equals ( def.getName () ) )
            {
                result.add ( def );
            }
        }

        return result;
    }

    public static OutputSpecification findSpecification ( final CalculationModule implementation, final OutputDefinition output )
    {
        for ( final OutputSpecification spec : implementation.getKnownOutputs () )
        {
            if ( spec.getName () != null && spec.getName ().equals ( output.getName () ) )
            {
                return spec;
            }
        }
        return null;
    }

}
