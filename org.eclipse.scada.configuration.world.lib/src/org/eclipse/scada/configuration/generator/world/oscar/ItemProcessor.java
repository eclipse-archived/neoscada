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
package org.eclipse.scada.configuration.generator.world.oscar;

import org.eclipse.scada.configuration.generator.world.oscar.item.AverageItemGenerator;
import org.eclipse.scada.configuration.generator.world.oscar.item.ConstantItemGenerator;
import org.eclipse.scada.configuration.generator.world.oscar.item.FormulaItemGenerator;
import org.eclipse.scada.configuration.generator.world.oscar.item.GlobalSummaryItemGenerator;
import org.eclipse.scada.configuration.generator.world.oscar.item.MovingAverageItemGenerator;
import org.eclipse.scada.configuration.generator.world.oscar.item.PersistentItemGenerator;
import org.eclipse.scada.configuration.generator.world.oscar.item.ProxyItemGenerator;
import org.eclipse.scada.configuration.generator.world.oscar.item.ReferenceItemGenerator;
import org.eclipse.scada.configuration.generator.world.oscar.item.ScriptItemGenerator;
import org.eclipse.scada.configuration.generator.world.oscar.item.SourceItemGenerator;
import org.eclipse.scada.configuration.generator.world.oscar.item.SummaryItemGenerator;
import org.eclipse.scada.configuration.generator.world.oscar.item.WeakReferenceDataSourceItemGenerator;
import org.eclipse.scada.configuration.world.osgi.AverageItem;
import org.eclipse.scada.configuration.world.osgi.ConstantItem;
import org.eclipse.scada.configuration.world.osgi.FormulaItem;
import org.eclipse.scada.configuration.world.osgi.GlobalSummaryItem;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.MovingAverageItem;
import org.eclipse.scada.configuration.world.osgi.PersistentItem;
import org.eclipse.scada.configuration.world.osgi.ProxyItem;
import org.eclipse.scada.configuration.world.osgi.ReferenceItem;
import org.eclipse.scada.configuration.world.osgi.ScriptItem;
import org.eclipse.scada.configuration.world.osgi.SourceItem;
import org.eclipse.scada.configuration.world.osgi.SummaryItem;
import org.eclipse.scada.configuration.world.osgi.WeakReferenceDataSourceItem;

public class ItemProcessor extends BasicOscarProcessor
{

    private final MasterServer app;

    private final MasterHandlerPriorities priorities;

    public ItemProcessor ( final MasterServer app, final OscarContext ctx, final MasterHandlerPriorities priorities )
    {
        super ( app, ctx );
        this.app = app;
        this.priorities = priorities;
    }

    public void process ()
    {
        for ( final Item item : this.app.getItems () )
        {
            processItem ( item );
        }
    }

    private void processItem ( final Item item )
    {
        if ( item instanceof SourceItem )
        {
            new SourceItemGenerator ( (SourceItem)item, this.ctx, this.priorities ).generate ();
        }
        else if ( item instanceof SummaryItem )
        {
            new SummaryItemGenerator ( (SummaryItem)item, this.ctx, this.priorities ).generate ();
        }
        else if ( item instanceof ConstantItem )
        {
            new ConstantItemGenerator ( (ConstantItem)item, this.ctx, this.priorities ).generate ();
        }
        else if ( item instanceof PersistentItem )
        {
            new PersistentItemGenerator ( (PersistentItem)item, this.ctx, this.priorities ).generate ();
        }
        else if ( item instanceof ProxyItem )
        {
            new ProxyItemGenerator ( (ProxyItem)item, this.ctx, this.priorities ).generate ();
        }
        else if ( item instanceof ScriptItem )
        {
            new ScriptItemGenerator ( (ScriptItem)item, this.ctx, this.priorities ).generate ();
        }
        else if ( item instanceof FormulaItem )
        {
            new FormulaItemGenerator ( (FormulaItem)item, this.ctx, this.priorities ).generate ();
        }
        else if ( item instanceof MovingAverageItem )
        {
            new MovingAverageItemGenerator ( (MovingAverageItem)item, this.ctx, this.priorities ).generate ();
        }
        else if ( item instanceof AverageItem )
        {
            new AverageItemGenerator ( (AverageItem)item, this.ctx, this.priorities ).generate ();
        }
        else if ( item instanceof GlobalSummaryItem )
        {
            new GlobalSummaryItemGenerator ( (GlobalSummaryItem)item, this.ctx, this.priorities ).generate ();
        }
        else if ( item instanceof WeakReferenceDataSourceItem )
        {
            new WeakReferenceDataSourceItemGenerator ( (WeakReferenceDataSourceItem)item, this.ctx, this.priorities ).generate ();
        }
        else if ( item instanceof ReferenceItem )
        {
            new ReferenceItemGenerator ( (ReferenceItem)item, this.ctx, this.priorities ).generate ();
        }
        else
        {
            throw new IllegalStateException ( String.format ( "Item type '%s' is not supported", item.getClass ().getName () ) );
        }
    }

}
