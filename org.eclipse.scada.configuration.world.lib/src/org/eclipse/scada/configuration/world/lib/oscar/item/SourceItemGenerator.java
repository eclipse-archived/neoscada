/*******************************************************************************
 * Copyright (c) 2013, 2015 IBH SYSTEMS GmbH and others.
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

import org.eclipse.scada.configuration.lib.Names;
import org.eclipse.scada.configuration.world.lib.oscar.Factories;
import org.eclipse.scada.configuration.world.lib.oscar.MasterHandlerPriorities;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;
import org.eclipse.scada.configuration.world.osgi.SourceItem;

public class SourceItemGenerator extends ItemGenerator
{
    private final SourceItem item;

    public SourceItemGenerator ( final SourceItem item, final OscarContext ctx, final MasterHandlerPriorities priorities )
    {
        super ( item, ctx, priorities );
        this.item = item;
    }

    @Override
    public void generate ()
    {
        super.generate ();
        if ( this.item.getConnection () == null )
        {
            throw new IllegalStateException ( String.format ( "Item '%s' has no connection set", this.item.getName () ) );
        }

        addSource ( makeSourceId (), this.item.getSourceName (), Names.makeName ( this.item.getConnection () ), this.item.getInformation ().getDescription () );
    }

    @Override
    protected String makeSourceId ()
    {
        return makeId ( "source" );
    }

    protected void addSource ( final String id, final String itemId, final String connectionId, final String description )
    {
        final Map<String, String> data = new HashMap<String, String> ();

        data.put ( "item.id", itemId ); //$NON-NLS-1$
        data.put ( "connection.id", connectionId ); //$NON-NLS-1$

        addData ( Factories.FACTORY_DA_SOURCE, id, data );
    }

}
