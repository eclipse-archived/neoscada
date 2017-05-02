/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.test.items;

import java.io.File;
import java.io.IOException;
import java.util.Timer;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.test.utils.FileUtils;
import org.eclipse.scada.utils.collection.MapBuilder;

public class PlainFileDataItem extends ScheduledDataItem
{

    private final File _file;

    public PlainFileDataItem ( final String name, final File file, final Timer timer, final int period )
    {
        super ( name, timer, period );
        this._file = file;
    }

    @Override
    public void run ()
    {
        try
        {
            read ();
            updateData ( null, new MapBuilder<String, Variant> ().put ( "error-message", Variant.NULL ).getMap (), AttributeMode.UPDATE );
        }
        catch ( final Exception e )
        {
            // handle error
            updateData ( null, new MapBuilder<String, Variant> ().put ( "error-message", Variant.valueOf ( e.getMessage () ) ).getMap (), AttributeMode.UPDATE );
        }

    }

    private void read () throws IOException
    {
        final String[] data = FileUtils.readFile ( this._file );
        updateData ( Variant.valueOf ( data[0] ), null, null );
    }

}
