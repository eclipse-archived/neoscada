/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.test.items;

import java.util.EnumSet;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.da.server.common.DataItemInformationBase;
import org.eclipse.scada.da.server.common.chain.BaseChainItemCommon;
import org.eclipse.scada.da.server.common.chain.ChainItem;
import org.eclipse.scada.da.server.common.chain.ChainProcessEntry;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.common.chain.MemoryItemChained;
import org.eclipse.scada.da.server.common.chain.item.SumAlarmChainItem;
import org.eclipse.scada.da.server.common.chain.item.SumErrorChainItem;
import org.eclipse.scada.da.server.common.impl.HiveCommon;

public class MemoryChainedItem extends MemoryItemChained
{

    private class InjectChainItem extends BaseChainItemCommon
    {
        private MemoryChainedItem item = null;

        public InjectChainItem ( final MemoryChainedItem item )
        {
            this.item = item;
            setReservedAttributes ( "org.openscada.da.test.chain.value" );
        }

        @Override
        public Variant process ( final Variant value, final Map<String, Variant> attributes )
        {
            int i = 0;
            final StringBuilder str = new StringBuilder ();
            for ( final ChainProcessEntry item : this.item.getChainCopy () )
            {
                if ( i > 0 )
                {
                    str.append ( ", " );
                }

                str.append ( item.getWhat ().getClass ().getCanonicalName () );
                str.append ( "(" );
                str.append ( item.getWhen ().toString () );
                str.append ( ")" );

                i++;
            }
            attributes.put ( "org.openscada.da.test.chain.value", Variant.valueOf ( str.toString () ) );

            return null;
        }

    }

    /**
     * Add some default chain items to the item
     * <p>
     * Adds the following chain items:
     * <ul>
     * <li>{@link SumErrorChainItem}</li>
     * <li>{@link SUmAlarmChainItem}</li>
     * </ul>
     * </p>
     * 
     * @param hive
     *            the hive to use
     * @param item
     *            the item to modify
     */
    public static void applyDefaultInputChain ( final HiveCommon hive, final DataItemInputChained item )
    {
        item.addChainElement ( IODirection.INPUT, new SumErrorChainItem () );
        item.addChainElement ( IODirection.INPUT, new SumAlarmChainItem () );
    }

    public MemoryChainedItem ( final HiveCommon hive, final String id )
    {
        super ( new DataItemInformationBase ( id, EnumSet.of ( IODirection.INPUT, IODirection.OUTPUT ) ) );
        addChainElement ( IODirection.INPUT, new InjectChainItem ( this ) );

        applyDefaultInputChain ( hive, this );
    }

    public void addChainElement ( final IODirection direction, final String className ) throws Exception
    {
        final Class<?> itemClass = Class.forName ( className );
        final Object o = itemClass.newInstance ();

        addChainElement ( direction, (ChainItem)o );
    }

    synchronized public void removeChainElement ( final IODirection direction, final String className ) throws Exception
    {
        for ( final ChainProcessEntry entry : getChainCopy () )
        {
            if ( entry.getWhat ().getClass ().getCanonicalName ().equals ( className ) )
            {
                if ( entry.getWhen ().equals ( EnumSet.of ( direction ) ) )
                {
                    removeChainElement ( entry.getWhen (), entry.getWhat () );
                }
                return;
            }
        }
        throw new Exception ( "Item not found" );
    }

}
