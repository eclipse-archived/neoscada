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
package org.eclipse.scada.ngp.test.hd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.scada.hd.data.ValueEntry;
import org.eclipse.scada.hd.data.ValueInformation;
import org.eclipse.scada.hd.data.message.UpdateQueryData;

public class DataGenerator
{
    private final Set<String> valueTypes;

    private final int entries;

    public DataGenerator ( final Set<String> valueTypes, final int entries )
    {
        this.valueTypes = valueTypes;
        this.entries = entries;
    }

    public UpdateQueryData createData ()
    {
        return new UpdateQueryData ( 0, 0, makeValueInformation (), makeValues () );
    }

    private List<ValueEntry> makeValues ()
    {
        final List<ValueEntry> result = new LinkedList<ValueEntry> ();

        for ( final String valueType : this.valueTypes )
        {
            result.add ( new ValueEntry ( valueType, makePlainValues () ) );
        }

        return result;
    }

    private List<Double> makePlainValues ()
    {
        final ArrayList<Double> result = new ArrayList<Double> ( this.entries );

        for ( int i = 0; i < this.entries; i++ )
        {
            result.add ( Double.valueOf ( i ) );
        }

        return result;
    }

    private List<ValueInformation> makeValueInformation ()
    {
        final List<ValueInformation> result = new ArrayList<ValueInformation> ( this.entries );

        for ( int i = 0; i < this.entries; i++ )
        {
            result.add ( new ValueInformation ( 1.0, 0.0, System.currentTimeMillis (), System.currentTimeMillis (), 10 ) );
        }

        return result;
    }
}
