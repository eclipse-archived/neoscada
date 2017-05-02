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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.lib.Names;
import org.eclipse.scada.configuration.world.lib.oscar.item.Items;
import org.eclipse.scada.configuration.world.osgi.BufferedValue;
import org.eclipse.scada.configuration.world.osgi.MasterServer;

public class BufferProcessor extends BasicOscarProcessor
{

    private final MasterServer app;

    public BufferProcessor ( final MasterServer app, final OscarContext ctx )
    {
        super ( app, ctx );
        this.app = app;
    }

    public void process ()
    {
        for ( BufferedValue bufferedValue : app.getBufferedValues () )
        {
            addBufferedValue ( bufferedValue );
        }
    }

    private void addBufferedValue ( BufferedValue bufferedValue )
    {
        final String id = Names.makeName ( bufferedValue );

        final Map<String, String> data = new HashMap<String, String> ();
        if ( bufferedValue.getItem () != null )
        {
            data.put ( "datasource.id", Items.makeMasterId ( bufferedValue.getItem ().getItem () ) );
        }
        if ( bufferedValue.getInitialValue () != null )
        {
            data.put ( "initialValue", bufferedValue.getInitialValue ().toString () );
        }
        data.put ( "trigger", "" + bufferedValue.getTrigger () );
        data.put ( "range", "" + bufferedValue.getRange () );
        data.put ( "triggerOnly", "" + bufferedValue.getTriggerOnly () );
        data.put ( "persistence", bufferedValue.getPersistence ().getLiteral () );
        addData ( Factories.FACTORY_DA_BUFFER, id, data );
    }
}
