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
import org.eclipse.scada.configuration.world.lib.oscar.Helper;
import org.eclipse.scada.configuration.world.lib.oscar.MasterHandlerPriorities;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;
import org.eclipse.scada.configuration.world.osgi.ItemReference;
import org.eclipse.scada.configuration.world.osgi.ScriptItem;

public class ScriptItemGenerator extends ItemGenerator
{
    private final ScriptItem item;

    public ScriptItemGenerator ( final ScriptItem item, final OscarContext ctx, final MasterHandlerPriorities priorities )
    {
        super ( item, ctx, priorities );
        this.item = item;
    }

    @Override
    public void generate ()
    {
        super.generate ();
        addScriptSource ();
    }

    @Override
    protected String makeSourceId ()
    {
        return makeId ( "script" );
    }

    private void addScriptSource ()
    {
        final Map<String, String> data = new HashMap<String, String> ();

        final String id = makeSourceId ();

        Helper.addOptional ( data, "engine", this.item.getScriptEngine () ); //$NON-NLS-1$

        for ( final ItemReference input : this.item.getInputs () )
        {
            data.put ( "datasource." + input.getName (), Items.makeMasterId ( input.getItem () ) ); //$NON-NLS-1$
        }

        for ( final ItemReference command : this.item.getCommands () )
        {
            data.put ( "writeSource." + command.getName (), Items.makeMasterId ( command.getItem () ) ); //$NON-NLS-1$
        }

        if ( this.item.getInitScript () != null )
        {
            Helper.addOptional ( data, "init", this.item.getInitScript ().getCode () ); //$NON-NLS-1$
        }
        if ( this.item.getUpdateScript () != null )
        {
            Helper.addOptional ( data, "update", this.item.getUpdateScript ().getCode () ); //$NON-NLS-1$
        }
        if ( this.item.getWriteCommandScript () != null )
        {
            Helper.addOptional ( data, "writeCommand", this.item.getWriteCommandScript ().getCode () ); //$NON-NLS-1$
        }

        if ( this.item.getTimer () != null )
        {
            data.put ( "timer", "" + this.item.getTimer ().getPeriod () ); //$NON-NLS-1$
            if ( this.item.getTimer ().getScript () != null )
            {
                Helper.addOptional ( data, "timerCommand", this.item.getTimer ().getScript ().getCode () ); //$NON-NLS-1$
            }
        }

        addData ( Factories.FACTORY_DA_SCRIPT_SOURCE, id, data );
    }

}
