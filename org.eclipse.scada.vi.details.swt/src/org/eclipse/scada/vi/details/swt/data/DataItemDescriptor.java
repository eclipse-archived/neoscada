/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.data;

import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.connection.data.Item.Type;

public class DataItemDescriptor
{

    private final String connectionInformation;

    private final String itemId;

    private final String descriptor;

    public DataItemDescriptor ( final String connectionInformation, final String itemId, final String descriptor )
    {
        this.connectionInformation = connectionInformation;
        this.itemId = itemId;
        this.descriptor = descriptor;
    }

    public String getConnectionInformation ()
    {
        return this.connectionInformation;
    }

    public String getItemId ()
    {
        return this.itemId;
    }

    public static DataItemDescriptor create ( final String descriptor )
    {
        if ( descriptor == null )
        {
            return null;
        }

        final String[] toks = descriptor.split ( "\\#", 2 ); //$NON-NLS-1$

        if ( toks.length != 2 )
        {
            return null;
        }

        return new DataItemDescriptor ( toks[0], toks[1], descriptor );
    }

    public String getDescriptor ()
    {
        return this.descriptor;
    }

    @Override
    public String toString ()
    {
        return this.connectionInformation + "#" + this.itemId; //$NON-NLS-1$
    }

    public Item asItem ()
    {
        return new Item ( this.connectionInformation, this.itemId, Type.ID );
    }
}
