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
package org.eclipse.scada.configuration.component.generator.simple;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.component.DeltaValue;
import org.eclipse.scada.configuration.component.lib.Items;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.component.lib.create.MasterListener;
import org.eclipse.scada.configuration.generator.FinishContext;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.world.osgi.DeltaItem;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;

public class DeltaValueGenerator extends AbstractSingleValueGenerator
{
    private final DeltaValue deltaValue;

    public DeltaValueGenerator ( final DeltaValue deltaValue )
    {
        super ( deltaValue );
        this.deltaValue = deltaValue;
    }

    private final Map<MasterServer, DeltaItem> items = new HashMap<> ();

    @Override
    protected CreationRequest<?> createRequest ( final ItemCreator itemCreator )
    {
        final DeltaItem item = OsgiFactory.eINSTANCE.createDeltaItem ();
        item.setSource ( this.deltaValue.getSource ().createReference () );
        final CreationRequest<DeltaItem> req = itemCreator.addItem ( item );

        req.addMasterListener ( new MasterListener<DeltaItem> () {

            @Override
            public void setMaster ( final DeltaItem item, final MasterContext master )
            {
                DeltaValueGenerator.this.items.put ( master.getImplementation (), item );
            }
        } );

        return req;
    }

    @Override
    public void finish ( final FinishContext context )
    {
        super.finish ( context );
        for ( final Map.Entry<MasterServer, DeltaItem> entry : this.items.entrySet () )
        {
            entry.getValue ().setSource ( Items.replaceDanglingReference ( this.context, entry.getKey (), entry.getValue ().getSource () ) );
        }
    }
}
