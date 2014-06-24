/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.generator.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.scada.configuration.component.ChangeCounter;
import org.eclipse.scada.configuration.component.generator.DataComponentGenerator;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.generator.FinishContext;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.world.osgi.BufferedValue;
import org.eclipse.scada.configuration.world.osgi.ChangeCounterItem;
import org.eclipse.scada.configuration.world.osgi.DataType;

public class ChangeCounterGenerator extends DataComponentGenerator
{
    private ChangeCounter changeCounter;

    private Map<String, ChangeCounterItem> mapping = new HashMap<String, ChangeCounterItem> ();

    public ChangeCounterGenerator ( ChangeCounter changeCounter )
    {
        super ( changeCounter );
        this.changeCounter = changeCounter;
    }

    @Override
    public void createItems ( ItemCreator itemCreator )
    {
        final CreationRequest<ChangeCounterItem> request = itemCreator.createChangeCounterItem (this.changeCounter.getType (), this.changeCounter.getOnError (), this.changeCounter.getValues ()); // FIXME: implement parameters
        request.localTags ( this.changeCounter.getName () );
        request.customizationTags ( this.changeCounter.getCustomizationTags () );
        request.dataType ( DataType.INT64 );
        mapping.put ( this.changeCounter.getBuffer ().getName (), request.create () );
    }

    @Override
    protected void finishForMaster ( FinishContext context, MasterContext master )
    {
        for ( Entry<String, ChangeCounterItem> entry : mapping.entrySet () )
        {
            for ( BufferedValue bufferedValue : master.getImplementation ().getBufferedValues () )
            {
                if ( entry.getKey ().equals ( bufferedValue.getName () ) )
                {
                    entry.getValue ().setBuffer ( bufferedValue );
                }
            }
        }
        super.finishForMaster ( context, master );
    }
}
