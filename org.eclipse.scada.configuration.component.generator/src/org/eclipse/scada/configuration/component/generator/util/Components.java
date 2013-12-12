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
package org.eclipse.scada.configuration.component.generator.util;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.ComponentWorld;
import org.eclipse.scada.configuration.component.Level;
import org.eclipse.scada.configuration.item.CustomizationPipeline;
import org.eclipse.scada.configuration.item.CustomizationRequest;
import org.eclipse.scada.configuration.item.CustomizationRunner;
import org.eclipse.scada.configuration.item.Selector;
import org.eclipse.scada.configuration.item.SelectorRunner;
import org.eclipse.scada.configuration.world.osgi.Item;

public final class Components
{
    private Components ()
    {
    }

    public static void customizeItem ( final Component component, final Item item, final CustomizationRequest request )
    {
        final List<CustomizationPipeline> pipelines = new LinkedList<> ();

        pipelines.add ( component.getCustomizationPipeline () );

        ComponentWorld system = null;
        Level currentLevel = component.getLevel ();
        while ( currentLevel != null )
        {
            pipelines.add ( currentLevel.getCustomizationPipeline () );
            if ( currentLevel.getParent () == null && currentLevel.eContainer () instanceof ComponentWorld )
            {
                // we found to root of all
                system = (ComponentWorld)currentLevel.eContainer ();
            }
            currentLevel = currentLevel.getParent ();
        }

        if ( system != null )
        {
            pipelines.add ( system.getDefaultCustomizationPipeline () );
        }

        new CustomizationRunner ( pipelines ).run ( item, request );
    }

    public static boolean isArchived ( final Component component, final Item item, final CustomizationRequest request )
    {
        final List<Selector> selectors = new LinkedList<> ();

        selectors.add ( component.getArchiveSelector () );

        ComponentWorld system = null;
        Level currentLevel = component.getLevel ();
        while ( currentLevel != null )
        {
            selectors.add ( currentLevel.getArchiveSelector () );
            if ( currentLevel.getParent () == null && currentLevel.eContainer () instanceof ComponentWorld )
            {
                // we found to root of all
                system = (ComponentWorld)currentLevel.eContainer ();
            }
            currentLevel = currentLevel.getParent ();
        }

        if ( system != null )
        {
            selectors.add ( system.getDefaultArchiveSelector () );
        }

        return new SelectorRunner ( selectors ).run ( item, request, false );
    }

}
