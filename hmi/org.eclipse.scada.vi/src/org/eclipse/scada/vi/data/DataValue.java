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
package org.eclipse.scada.vi.data;

import java.io.PrintStream;

import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.utils.lang.Immutable;
import org.eclipse.scada.da.ui.connection.data.Item;

@Immutable
public class DataValue
{
    private final DataItemValue value;

    private final boolean ignoreSummary;

    private final boolean nullInvalid;

    private final Item item;

    public DataValue ( final DataItemValue value, final Item item, final boolean ignoreSummary, final boolean nullInvalid )
    {
        super ();
        this.value = value;
        this.item = new Item ( item );
        this.ignoreSummary = ignoreSummary;
        this.nullInvalid = nullInvalid;
    }

    public Item getItem ()
    {
        return new Item ( this.item );
    }

    public DataItemValue getValue ()
    {
        return this.value;
    }

    public boolean isIgnoreSummary ()
    {
        return this.ignoreSummary;
    }

    public boolean isNullInvalid ()
    {
        return this.nullInvalid;
    }

    @Override
    public String toString ()
    {
        return this.value != null ? this.value.toString () : "<null>";
    }

    public void dump ( final PrintStream out )
    {
        out.print ( String.format ( "item: '%s', value: '%s', ignoreSummary: %s, nullInvalid: %s", this.item, this.value, this.ignoreSummary, this.nullInvalid ) );
    }
}
