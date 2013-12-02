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

import org.eclipse.scada.configuration.world.lib.oscar.MasterHandlerPriorities;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;
import org.eclipse.scada.configuration.world.lib.oscar.item.features.AttributesSummaryProcessor;
import org.eclipse.scada.configuration.world.lib.oscar.item.features.BlockProcessor;
import org.eclipse.scada.configuration.world.lib.oscar.item.features.BooleanMonitorProcessor;
import org.eclipse.scada.configuration.world.lib.oscar.item.features.EventLoggerProcessor;
import org.eclipse.scada.configuration.world.lib.oscar.item.features.ItemFeatureProcessor;
import org.eclipse.scada.configuration.world.lib.oscar.item.features.LevelMonitorProcessor;
import org.eclipse.scada.configuration.world.lib.oscar.item.features.ListMonitorProcessor;
import org.eclipse.scada.configuration.world.lib.oscar.item.features.ManualOverrideProcessor;
import org.eclipse.scada.configuration.world.lib.oscar.item.features.NegateProcessor;
import org.eclipse.scada.configuration.world.lib.oscar.item.features.RoundingProcessor;
import org.eclipse.scada.configuration.world.lib.oscar.item.features.ScaleProcessor;
import org.eclipse.scada.configuration.world.lib.oscar.item.features.ValueMapperProcessor;
import org.eclipse.scada.configuration.world.osgi.AttributesSummary;
import org.eclipse.scada.configuration.world.osgi.Block;
import org.eclipse.scada.configuration.world.osgi.BooleanMonitor;
import org.eclipse.scada.configuration.world.osgi.EventLogger;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry;
import org.eclipse.scada.configuration.world.osgi.LevelMonitor;
import org.eclipse.scada.configuration.world.osgi.ListMonitor;
import org.eclipse.scada.configuration.world.osgi.ManualOverride;
import org.eclipse.scada.configuration.world.osgi.Negate;
import org.eclipse.scada.configuration.world.osgi.Rounding;
import org.eclipse.scada.configuration.world.osgi.Scale;
import org.eclipse.scada.configuration.world.osgi.ValueMapper;

public abstract class ItemGenerator
{
    private final Item item;

    private final OscarContext ctx;

    private final MasterHandlerPriorities priorities;

    public ItemGenerator ( final Item item, final OscarContext ctx, final MasterHandlerPriorities priorities )
    {
        this.item = item;
        this.ctx = ctx;
        this.priorities = priorities;
    }

    protected String makeId ( final String tag )
    {
        return Items.makeId ( this.item, tag );
    }

    protected String makeMasterId ()
    {
        return Items.makeMasterId ( this.item );
    }

    protected abstract String makeSourceId ();

    public void generate ()
    {
        addMaster ( makeMasterId (), makeSourceId () );
        for ( final ItemFeatureEntry feature : this.item.getItemFeatures () )
        {
            final ItemFeatureProcessor processor = findProcessor ( feature );
            if ( processor == null )
            {
                throw new IllegalStateException ( String.format ( "Processor for item feature %s/%s not found", feature.getName (), feature.getClass ().getName () ) );
            }
            processor.process ( this.priorities, feature, this.ctx );
        }
    }

    private ItemFeatureProcessor findProcessor ( final ItemFeatureEntry feature )
    {
        if ( feature instanceof ManualOverride )
        {
            return new ManualOverrideProcessor ();
        }
        else if ( feature instanceof LevelMonitor )
        {
            return new LevelMonitorProcessor ();
        }
        else if ( feature instanceof AttributesSummary )
        {
            return new AttributesSummaryProcessor ();
        }
        else if ( feature instanceof EventLogger )
        {
            return new EventLoggerProcessor ();
        }
        else if ( feature instanceof ValueMapper )
        {
            return new ValueMapperProcessor ();
        }
        else if ( feature instanceof Scale )
        {
            return new ScaleProcessor ();
        }
        else if ( feature instanceof Negate )
        {
            return new NegateProcessor ();
        }
        else if ( feature instanceof Rounding )
        {
            return new RoundingProcessor ();
        }
        else if ( feature instanceof BooleanMonitor )
        {
            return new BooleanMonitorProcessor ();
        }
        else if ( feature instanceof ListMonitor )
        {
            return new ListMonitorProcessor ();
        }
        else if ( feature instanceof Block )
        {
            return new BlockProcessor ();
        }
        return null;
    }

    /**
     * Create a new master item instance
     * 
     * @param id
     * @param dataSourceId
     */
    protected void addMaster ( final String id, final String dataSourceId )
    {
        final Map<String, String> data = new HashMap<> ();

        data.put ( "datasource.id", dataSourceId ); //$NON-NLS-1$

        addData ( "master.item", id, data ); //$NON-NLS-1$
    }

    /**
     * Create an item export
     * 
     * @param id
     * @param itemId
     * @param dataSourceId
     * @param description
     */
    protected void addAlias ( final String id, final String itemId, final String dataSourceId, final String description )
    {
        final Map<String, String> data = new HashMap<String, String> ();

        data.put ( "datasource.id", dataSourceId ); //$NON-NLS-1$
        data.put ( "item.id", itemId ); //$NON-NLS-1$
        if ( description != null )
        {
            data.put ( "description", description ); //$NON-NLS-1$
        }

        addData ( "da.dataitem.datasource", id, data ); //$NON-NLS-1$
    }

    protected void addData ( final String factoryId, final String configurationId, final Map<String, String> data )
    {
        this.ctx.addData ( factoryId, configurationId, data );
    }

}
