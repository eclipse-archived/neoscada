/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.hd.data.message;

public class UpdateQueryData implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public UpdateQueryData ( final long queryId, final int index, final java.util.List<org.eclipse.scada.hd.data.ValueInformation> valueInformation, final java.util.List<org.eclipse.scada.hd.data.ValueEntry> values )
    {
        this.queryId = queryId;
        this.index = index;
        this.valueInformation = valueInformation;
        this.values = values;
    }

    private final long queryId;

    public long getQueryId ()
    {
        return this.queryId;
    }

    private final int index;

    public int getIndex ()
    {
        return this.index;
    }

    private final java.util.List<org.eclipse.scada.hd.data.ValueInformation> valueInformation;

    public java.util.List<org.eclipse.scada.hd.data.ValueInformation> getValueInformation ()
    {
        return this.valueInformation;
    }

    private final java.util.List<org.eclipse.scada.hd.data.ValueEntry> values;

    public java.util.List<org.eclipse.scada.hd.data.ValueEntry> getValues ()
    {
        return this.values;
    }

    @Override
    public String toString ()
    {
        return "[UpdateQueryData - " + "queryId: " + this.queryId + ", " + "index: " + this.index + ", " + "valueInformation: " + this.valueInformation + ", " + "values: " + this.values + "]";
    }
}
