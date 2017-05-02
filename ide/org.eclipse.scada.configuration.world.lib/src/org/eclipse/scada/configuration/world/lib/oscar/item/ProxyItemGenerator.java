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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.world.lib.oscar.Factories;
import org.eclipse.scada.configuration.world.lib.oscar.MasterHandlerPriorities;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.ProxyItem;
import org.eclipse.scada.utils.str.StringHelper;

public class ProxyItemGenerator extends ItemGenerator
{
    private final ProxyItem item;

    public ProxyItemGenerator ( final ProxyItem item, final OscarContext ctx, final MasterHandlerPriorities priorities )
    {
        super ( item, ctx, priorities );
        this.item = item;
    }

    @Override
    public void generate ()
    {
        super.generate ();
        addProxySource ( makeSourceId (), makeSources ( this.item ) );
    }

    private Collection<String> makeSources ( final ProxyItem item )
    {
        final ArrayList<String> result = new ArrayList<> ( item.getItems ().size () );

        for ( final Item refItem : item.getItems () )
        {
            result.add ( Items.makeMasterId ( refItem ) );
        }

        Collections.sort ( result );

        return result;
    }

    @Override
    protected String makeSourceId ()
    {
        return makeId ( "proxy" );
    }

    private void addProxySource ( final String id, final Collection<String> sources )
    {
        final Map<String, String> data = new HashMap<String, String> ();

        data.put ( "sources", StringHelper.join ( sources, ", " ) );

        addData ( Factories.FACTORY_DA_PROXY_SOURCE, id, data );
    }

}
