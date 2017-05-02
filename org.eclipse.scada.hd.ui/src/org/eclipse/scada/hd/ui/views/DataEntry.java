/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.ui.views;

import java.util.List;

import org.eclipse.scada.hd.data.ValueInformation;

public class DataEntry
{
    private final ValueInformation info;

    private final List<Double> values;

    public DataEntry ( final ValueInformation info, final List<Double> values )
    {
        super ();
        this.info = info;
        this.values = values;
    }

    public ValueInformation getInfo ()
    {
        return this.info;
    }

    public List<Double> getValues ()
    {
        return this.values;
    }
}
