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

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.infrastructure.lib.WorldGenerator;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.SummaryGroup;

public class SummariesProcessor extends MasterApplicationProcessor
{
    public SummariesProcessor ()
    {
    }

    public SummariesProcessor ( final org.eclipse.scada.configuration.component.System system, final WorldGenerator world )
    {
        super ( system, world );
    }

    @Override
    public void processContext ( final MasterContext app, final IProgressMonitor monitor )
    {
        for ( final Item item : app.getImplementation ().getItems () )
        {
            processItem ( app.getImplementation (), item );
        }
    }

    private void processItem ( final MasterServer app, final Item item )
    {
        if ( item.getInformation () == null )
        {
            return;
        }

        final EList<String> hier = item.getInformation ().getHierarchy ();
        if ( hier.isEmpty () )
        {
            return;
        }

        final SummaryGroup group = getSummaryGroup ( null, app.getSummaryGroups (), new LinkedList<> ( hier ) );
        if ( group == null )
        {
            return;
        }

        group.getItems ().add ( item );
    }

    private SummaryGroup getSummaryGroup ( final SummaryGroup parent, final Collection<SummaryGroup> groups, final LinkedList<String> hierarchy )
    {
        if ( hierarchy.isEmpty () )
        {
            return parent;
        }

        final String level = hierarchy.pollFirst ();

        for ( final SummaryGroup group : groups )
        {
            if ( group.getName ().equals ( level ) )
            {
                return getSummaryGroup ( group, group.getSubGroups (), hierarchy );
            }
        }

        // finally we need to create

        final SummaryGroup group = OsgiFactory.eINSTANCE.createSummaryGroup ();
        group.setName ( level );
        groups.add ( group );
        return getSummaryGroup ( group, group.getSubGroups (), hierarchy );
    }
}
