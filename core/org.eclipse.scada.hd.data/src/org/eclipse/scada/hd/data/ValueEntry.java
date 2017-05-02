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
package org.eclipse.scada.hd.data;

public class ValueEntry implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public ValueEntry ( final String valueType, final java.util.List<Double> values )
    {
        this.valueType = valueType;
        this.values = values;
    }

    /**
     * The type of value series (e.g. AVG)
     */
    private final String valueType;

    public String getValueType ()
    {
        return this.valueType;
    }

    private final java.util.List<Double> values;

    public java.util.List<Double> getValues ()
    {
        return this.values;
    }

    @Override
    public String toString ()
    {
        return "[ValueEntry - " + "valueType: " + this.valueType + ", " + "values: " + this.values + "]";
    }
}
