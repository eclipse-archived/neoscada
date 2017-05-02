/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.styles;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class StyleGeneratorInformation
{
    private static final String EXTP_STYLE_GENERATOR = "org.eclipse.scada.core.ui.styles.styleGenerator"; //$NON-NLS-1$

    private static final String ELE_STYLE_GENERATOR = "styleGenerator"; //$NON-NLS-1$

    private final String id;

    private final String name;

    private final String description;

    public StyleGeneratorInformation ( final String id, final String name, final String description )
    {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getDescription ()
    {
        return this.description;
    }

    public String getId ()
    {
        return this.id;
    }

    public String getName ()
    {
        return this.name;
    }

    public static List<StyleGeneratorInformation> list ()
    {
        final List<StyleGeneratorInformation> result = new LinkedList<StyleGeneratorInformation> ();

        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_STYLE_GENERATOR ) )
        {
            if ( !ELE_STYLE_GENERATOR.equals ( ele.getName () ) )
            {
                continue;
            }

            final String id = ele.getAttribute ( "id" ); //$NON-NLS-1$
            final String name = ele.getAttribute ( "name" ); //$NON-NLS-1$
            final String description = getText ( ele.getChildren ( "description" ) ); //$NON-NLS-1$

            result.add ( new StyleGeneratorInformation ( id, name, description ) );
        }

        return result;
    }

    private static String getText ( final IConfigurationElement[] children )
    {
        if ( children == null )
        {
            return null;
        }
        for ( final IConfigurationElement ele : children )
        {
            return ele.getValue ();
        }
        return null;
    }

    public static IConfigurationElement getConfiguration ( final String generatorId )
    {
        if ( generatorId == null )
        {
            return null;
        }

        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_STYLE_GENERATOR ) )
        {
            if ( !ELE_STYLE_GENERATOR.equals ( ele.getName () ) )
            {
                continue;
            }

            final String id = ele.getAttribute ( "id" ); //$NON-NLS-1$
            if ( id == null )
            {
                continue;
            }
            if ( id.equals ( generatorId ) )
            {
                return ele;
            }
        }

        return null;
    }
}
