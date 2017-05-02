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
package org.eclipse.scada.configuration.world.lib.oscar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.scada.configuration.lib.Names;
import org.eclipse.scada.configuration.world.lib.oscar.item.Items;
import org.eclipse.scada.configuration.world.osgi.Average;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.MovingAverage;
import org.eclipse.scada.utils.str.StringHelper;

public class AverageProcessor extends BasicOscarProcessor
{

    private final MasterServer app;

    public AverageProcessor ( final MasterServer app, final OscarContext ctx )
    {
        super ( app, ctx );
        this.app = app;
    }

    public void process ()
    {
        for ( final Average average : this.app.getAverages () )
        {
            createAverage ( average );
        }
        for ( final MovingAverage average : this.app.getMovingAverages () )
        {
            createMovingAverage ( average );
        }
    }

    private void createMovingAverage ( final MovingAverage average )
    {
        final String id = Names.makeName ( average );

        final Map<String, String> data = new HashMap<String, String> ();

        data.put ( "datasource.id", Items.makeMasterId ( average.getItem () ) ); //$NON-NLS-1$
        data.put ( "trigger", "" + average.getTrigger () ); //$NON-NLS-1$ //$NON-NLS-2$

        if ( average.getTriggerOnly () != null )
        {
            data.put ( "triggerOnly", "" + average.getTriggerOnly () ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        data.put ( "nullRange", "" + average.getNullRange () ); //$NON-NLS-1$ //$NON-NLS-2$
        data.put ( "range", "" + average.getRange () ); //$NON-NLS-1$ //$NON-NLS-2$

        addData ( Factories.FACTORY_DA_MOVING_AVERAGE, id, data );
    }

    private void createAverage ( final Average average )
    {
        final String id = Names.makeName ( average );

        final Map<String, String> data = new HashMap<String, String> ();

        if ( average.getSourcesRequired () != null )
        {
            data.put ( "validSourcesRequired", average.getSourcesRequired () ); //$NON-NLS-1$ 
        }
        else
        {
            data.put ( "validSourcesRequired", "0" ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        final List<String> sources = new ArrayList<> ( average.getItems ().size () );
        for ( final Item item : average.getItems () )
        {
            sources.add ( Items.makeMasterId ( item ) );
        }

        Collections.sort ( sources );

        data.put ( "sources", StringHelper.join ( sources, ", " ) ); //$NON-NLS-1$ //$NON-NLS-2$

        addData ( Factories.FACTORY_DA_AVERAGE, id, data );
    }

}
