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
package org.eclipse.scada.vi.details.swt.source;

import java.util.Map;

import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.SummaryInformation;

public class ItemValueSourceController implements ValueSourceController
{
    private final String valueKey;

    private Map<String, DataValue> values;

    public ItemValueSourceController ( final String valueKey )
    {
        this.valueKey = valueKey;
    }

    @Override
    public DataItemValue value ()
    {
        final DataItemValue value = this.values.get ( this.valueKey ).getValue ();

        if ( value == null )
        {
            return DataItemValue.DISCONNECTED;
        }
        else
        {
            return value;
        }
    }

    @Override
    public void updateData ( final Map<String, DataValue> values, final SummaryInformation state )
    {
        this.values = values;
    }

}
