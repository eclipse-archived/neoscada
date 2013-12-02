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
import org.eclipse.scada.configuration.utils.TypeVisitor;
import org.eclipse.scada.configuration.utils.TypeWalker;
import org.eclipse.scada.configuration.world.lib.oscar.item.Items;
import org.eclipse.scada.configuration.world.osgi.BlockGroup;
import org.eclipse.scada.configuration.world.osgi.BlockHandler;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.utils.str.StringHelper;

public class BlockingProcessor extends BasicOscarProcessor implements TypeVisitor<BlockGroup>
{

    private final EquinoxApplication app;

    public BlockingProcessor ( final EquinoxApplication app, final OscarContext ctx )
    {
        super ( app, ctx );
        this.app = app;
    }

    public void process ()
    {
        try
        {
            new TypeWalker<BlockGroup> ( BlockGroup.class ).walk ( this.app, this );
        }
        catch ( final Exception e )
        {
            throw new RuntimeException ( e );
        }
    }

    @Override
    public void visit ( final BlockGroup group ) throws Exception
    {
        if ( group.getHandlers ().isEmpty () )
        {
            return;
        }

        final List<String> masterIds = new ArrayList<> ( group.getHandlers ().size () );
        for ( final BlockHandler handler : group.getHandlers () )
        {
            masterIds.add ( Items.makeMasterId ( handler.getItem () ) );
        }
        Collections.sort ( masterIds );

        final String blockId = Names.makeName ( group );

        final Map<String, String> data = new HashMap<String, String> ();
        data.put ( "master.id", StringHelper.join ( masterIds, "," ) ); //$NON-NLS-1$ //$NON-NLS-2$

        final Map<String, String> infoAttributes = new HashMap<> ();
        Configurations.fillAttributesWithHierarchy ( infoAttributes, group.getHierarchy () );
        Configurations.applyInfoAttributes ( infoAttributes, data );

        addData ( Factories.FACTORY_MASTER_HANDLER_BLOCK, blockId, data );
    }
}
