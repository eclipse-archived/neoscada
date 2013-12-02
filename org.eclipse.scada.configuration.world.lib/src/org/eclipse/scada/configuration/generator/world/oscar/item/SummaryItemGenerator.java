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
package org.eclipse.scada.configuration.generator.world.oscar.item;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.configuration.generator.world.oscar.Configurations;
import org.eclipse.scada.configuration.generator.world.oscar.Factories;
import org.eclipse.scada.configuration.generator.world.oscar.MasterHandlerPriorities;
import org.eclipse.scada.configuration.generator.world.oscar.OscarContext;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.SummaryGroup;
import org.eclipse.scada.configuration.world.osgi.SummaryItem;
import org.eclipse.scada.utils.str.StringHelper;

public class SummaryItemGenerator extends ItemGenerator
{
    private final SummaryItem item;

    public SummaryItemGenerator ( final SummaryItem item, final OscarContext ctx, final MasterHandlerPriorities priorities )
    {
        super ( item, ctx, priorities );
        this.item = item;
    }

    @Override
    protected String makeSourceId ()
    {
        return makeId ( "sum" );
    }

    @Override
    public void generate ()
    {
        super.generate ();
        process ( this.item.getGroup () );
    }

    public void process ( final SummaryGroup summaryGroup )
    {
        final List<String> sources = makeSources ( summaryGroup.getItems () );
        final List<String> subSources = makeGroups ( summaryGroup.getItems () );
        addSum ( makeSourceId (), sources, subSources, Configurations.groupsSum );
    }

    private List<String> makeGroups ( final List<Item> items )
    {
        final List<String> result = new LinkedList<> ();

        for ( final Item item : items )
        {
            if ( item instanceof SummaryItem )
            {
                result.add ( Items.makeMasterId ( item ) );
            }
        }

        return result;
    }

    private List<String> makeSources ( final List<Item> items )
    {
        final List<String> result = new LinkedList<> ();

        for ( final Item item : items )
        {
            if ( ! ( item instanceof SummaryItem ) )
            {
                result.add ( Items.makeMasterId ( item ) );
            }
        }

        return result;
    }

    private void addSum ( final String id, final List<String> sources, final List<String> subSources, final Set<String> groups )
    {
        final Map<String, String> data = new HashMap<String, String> ();

        // sort them in order to have a common base for diffs

        Collections.sort ( sources );
        Collections.sort ( subSources );

        {
            int i = 0;
            for ( final String item : sources )
            {
                data.put ( "datasource." + i, item ); //$NON-NLS-1$
                i++;
            }
        }

        {
            int i = 0;
            for ( final String item : subSources )
            {
                data.put ( "subDatasource." + i, item ); //$NON-NLS-1$
                i++;
            }
        }

        data.put ( "groups", StringHelper.join ( groups, "," ) ); //$NON-NLS-1$ //$NON-NLS-2$

        addData ( Factories.FACTORY_DA_SUM_SOURCE, id, data );
    }

}
