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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.world.lib.oscar.Factories;
import org.eclipse.scada.configuration.world.lib.oscar.MasterHandlerPriorities;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;
import org.eclipse.scada.configuration.world.osgi.ChangeCounterItem;
import org.eclipse.scada.core.Variant;

public class ChangeCounterItemGenerator extends ItemGenerator
{
    private final ChangeCounterItem item;

    public ChangeCounterItemGenerator ( final ChangeCounterItem item, final OscarContext ctx, final MasterHandlerPriorities priorities )
    {
        super ( item, ctx, priorities );
        this.item = item;
    }

    @Override
    protected String makeSourceId ()
    {
        return makeId ( "changecounter" );
    }

    @Override
    public void generate ()
    {
        super.generate ();
        addChangeCounterSource ( makeSourceId () );
    }

    private void addChangeCounterSource ( final String id )
    {
        final Map<String, String> data = new HashMap<String, String> ();
        if ( item.getBuffer () != null )
        {
            data.put ( "buffered.datasource.id", item.getBuffer ().getName () );
        }
        else
        {
            throw new IllegalArgumentException ( "item attribute 'buffer' is not set!" );
        }
        data.put ( "type", item.getType ().getLiteral () );
        data.put ( "onError", item.getOnError ().getLiteral () );
        int i = 0;
        for ( Variant value : item.getValues () )
        {
            data.put ( "value." + i, value.toString () );
            i += 1;
        }
        addData ( Factories.FACTORY_DA_CHANGE_COUNTER, id, data );
    }
}
