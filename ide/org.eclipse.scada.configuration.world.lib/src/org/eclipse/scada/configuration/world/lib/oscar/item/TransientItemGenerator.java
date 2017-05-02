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
import org.eclipse.scada.configuration.world.osgi.TransientItem;

public class TransientItemGenerator extends ItemGenerator
{
    public TransientItemGenerator ( final TransientItem item, final OscarContext ctx, final MasterHandlerPriorities priorities )
    {
        super ( item, ctx, priorities );
    }

    @Override
    public void generate ()
    {
        super.generate ();
        addMemorySource ( makeSourceId () );
    }

    @Override
    protected String makeSourceId ()
    {
        return makeId ( "memory" );
    }

    private void addMemorySource ( final String id )
    {
        final Map<String, String> data = new HashMap<String, String> ();

        addData ( Factories.FACTORY_DA_MEMORY_SOURCE, id, data );
    }

}
