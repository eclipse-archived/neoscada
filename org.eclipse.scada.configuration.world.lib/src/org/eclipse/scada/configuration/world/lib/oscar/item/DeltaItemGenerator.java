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
package org.eclipse.scada.configuration.world.lib.oscar.item;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.world.lib.oscar.Factories;
import org.eclipse.scada.configuration.world.lib.oscar.MasterHandlerPriorities;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;
import org.eclipse.scada.configuration.world.osgi.DeltaItem;

public class DeltaItemGenerator extends ItemGenerator
{
    private final DeltaItem item;

    public DeltaItemGenerator ( final DeltaItem item, final OscarContext ctx, final MasterHandlerPriorities priorities )
    {
        super ( item, ctx, priorities );
        this.item = item;
    }

    @Override
    protected String makeSourceId ()
    {
        return Items.makeId ( this.item, "delta" );
    }

    @Override
    public void generate ()
    {
        super.generate ();

        final String id = makeSourceId ();
        final Map<String, String> data = new HashMap<String, String> ();

        data.put ( "datasource.id", Items.makeMasterId ( this.item.getSource () ) );

        addData ( Factories.FACTORY_DA_DELTA_SOURCE, id, data );
    }
}
