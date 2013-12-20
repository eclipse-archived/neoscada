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
package org.eclipse.scada.configuration.component.generator;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.lib.Items;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.MasterListener;
import org.eclipse.scada.configuration.generator.FinishContext;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.world.osgi.ItemReference;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.ScriptItem;

/**
 * Help in creating a component generator that uses script items and maybe other
 * dangling references. <br/>
 * Script items created by this generator must be created using the
 * {@link #createScriptItem(CreationRequest)} method in order to he processed.
 * All item references will be replaced with the correct items in the "finish"
 * step automatically.
 * 
 * @author Jens Reimann
 */
public abstract class AbstractDanglingGenerator extends DataComponentGenerator
{

    private final Map<MasterServer, ScriptItem> danglingScriptItemMap = new HashMap<> ();

    public AbstractDanglingGenerator ( final DataComponent component )
    {
        super ( component );
    }

    /**
     * Create a script item from a CreationRequest and record it for replacing
     * dangling references
     * 
     * @param req
     *            the creation request
     * @return the created script item
     */
    protected ScriptItem createScriptItem ( final CreationRequest<ScriptItem> req )
    {
        req.addMasterListener ( new MasterListener<ScriptItem> () {

            @Override
            public void setMaster ( final ScriptItem item, final MasterContext master )
            {
                AbstractDanglingGenerator.this.danglingScriptItemMap.put ( master.getImplementation (), item );
            }
        } );
        return req.create ();
    }

    @Override
    public void finish ( final FinishContext context )
    {
        super.finish ( context );
        for ( final Map.Entry<MasterServer, ScriptItem> entry : this.danglingScriptItemMap.entrySet () )
        {
            final MasterServer master = entry.getKey ();
            final ScriptItem item = entry.getValue ();

            for ( final ItemReference input : item.getInputs () )
            {
                input.setItem ( Items.replaceDanglingReference ( this.context, master, input.getItem () ) );
            }

            for ( final ItemReference command : item.getCommands () )
            {
                command.setItem ( Items.replaceDanglingReference ( this.context, master, command.getItem () ) );
            }
        }
    }

}