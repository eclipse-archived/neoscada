/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.ComponentFactory;
import org.eclipse.scada.configuration.component.InputSpecification;
import org.eclipse.scada.configuration.component.Level;
import org.eclipse.scada.configuration.component.OutputSpecification;
import org.eclipse.scada.configuration.lib.Names;
import org.eclipse.scada.configuration.world.Documentable;
import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.utils.str.StringHelper;

public final class Components
{
    private static final String delimiter = ".";

    private Components ()
    {
    }

    public static List<String> makeHierarchy ( final Component component )
    {
        final LinkedList<String> result = new LinkedList<> ();

        Level level = component.getLevel ();
        while ( level != null )
        {
            result.add ( 0, level.getName () );
            level = level.getParent ();
        }

        return result;
    }

    public static String makeFullQualified ( final Component component, final String... local )
    {
        final List<String> hier = Components.makeHierarchy ( component );
        if ( component instanceof Documentable )
        {
            hier.add ( Names.makeName ( (Documentable)component ) );
        }
        hier.addAll ( Arrays.asList ( local ) );
        return StringHelper.join ( hier, delimiter );
    }

    public static InputSpecification createInput ( final String string )
    {
        final InputSpecification input = ComponentFactory.eINSTANCE.createInputSpecification ();
        input.setName ( string );
        return input;
    }

    public static OutputSpecification createOutput ( final String string, final DataType dataType )
    {
        final OutputSpecification output = ComponentFactory.eINSTANCE.createOutputSpecification ();
        output.setName ( string );
        output.setDataType ( dataType );
        return output;
    }
}
