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
package org.eclipse.scada.configuration.world.lib.oscar.item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.world.lib.oscar.Factories;
import org.eclipse.scada.configuration.world.lib.oscar.MasterHandlerPriorities;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;
import org.eclipse.scada.configuration.world.osgi.GlobalSummaryItem;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.SummaryItem;

public class GlobalSummaryItemGenerator extends ItemGenerator
{
    private final GlobalSummaryItem item;

    public GlobalSummaryItemGenerator ( final GlobalSummaryItem item, final OscarContext ctx, final MasterHandlerPriorities priorities )
    {
        super ( item, ctx, priorities );
        this.item = item;
    }

    @Override
    public void generate ()
    {
        super.generate ();
        addGlobalSummarySource ();
    }

    @Override
    protected String makeSourceId ()
    {
        return makeId ( "globalSummary" );
    }

    private void addGlobalSummarySource ()
    {
        final Map<String, String> data = new HashMap<String, String> ();

        final EObject container = this.item.eContainer ();
        if ( ! ( container instanceof MasterServer ) )
        {
            return;
        }

        final MasterServer app = (MasterServer)container;

        final List<String> blacklist = new ArrayList<> ();

        for ( final Item item : app.getItems () )
        {
            if ( item instanceof SummaryItem )
            {
                blacklist.add ( Items.makeMasterId ( item ) );
            }
            else if ( item instanceof GlobalSummaryItem )
            {
                blacklist.add ( Items.makeMasterId ( item ) );
            }
        }

        Collections.sort ( blacklist );
        data.put ( "attribute", this.item.getAttribute () ); //$NON-NLS-1$
        data.put ( "onlyMaster", "true" ); //$NON-NLS-1$ //$NON-NLS-2$

        int i = 0;
        for ( final String entry : blacklist )
        {
            data.put ( "blacklist." + i++, entry ); //$NON-NLS-1$
        }

        addData ( Factories.FACTORY_DA_GLOBAL_SUMMARY_SOURCE, makeSourceId (), data );
    }

}
