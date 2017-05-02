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
package org.eclipse.scada.configuration.generator.component.app;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.component.ComponentWorld;
import org.eclipse.scada.configuration.component.MarkerConfiguration;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.infrastructure.lib.WorldGenerator;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.MarkerGroup;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.utils.str.StringHelper;

public class MarkerGroupGeneratorProcessor extends MasterApplicationProcessor
{
    public MarkerGroupGeneratorProcessor ()
    {
    }

    public MarkerGroupGeneratorProcessor ( final ComponentWorld system, final WorldGenerator world )
    {
        super ( system, world );
    }

    @Override
    public void processContext ( final MasterContext masterContext, final IProgressMonitor monitor )
    {
        final MasterServer app = masterContext.getImplementation ();

        final MarkerConfiguration cfg = findDefaultConfiguration ( MarkerConfiguration.class );
        if ( cfg == null )
        {
            // nothing to do, no marker configuration found
            return;
        }

        final Map<String, List<Item>> itemGroups = new HashMap<> ();

        for ( final Item item : app.getItems () )
        {
            if ( item.getInformation () == null )
            {
                continue;
            }

            buildMarker ( item, itemGroups, new LinkedList<> ( item.getInformation ().getHierarchy () ) );
        }

        if ( app.getMarkers () == null )
        {
            app.setMarkers ( OsgiFactory.eINSTANCE.createMarkers () );
        }

        for ( final Map.Entry<String, List<Item>> entry : itemGroups.entrySet () )
        {
            final MarkerGroup markerGroup = OsgiFactory.eINSTANCE.createMarkerGroup ();
            app.getMarkers ().getMarkerGroups ().add ( markerGroup );

            markerGroup.setName ( entry.getKey () );
            markerGroup.getItems ().addAll ( entry.getValue () );
            markerGroup.getMarkers ().addAll ( EcoreUtil.copyAll ( cfg.getMarkers () ) );
        }
    }

    private void buildMarker ( final Item item, final Map<String, List<Item>> itemGroups, final LinkedList<String> hierarchy )
    {
        if ( hierarchy.isEmpty () )
        {
            return;
        }

        final String id = StringHelper.join ( hierarchy, "_" );

        List<Item> items = itemGroups.get ( id );
        if ( items == null )
        {
            items = new LinkedList<> ();
            itemGroups.put ( id, items );
        }
        items.add ( item );
    }
}
