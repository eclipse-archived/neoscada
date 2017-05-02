/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.stock.domain;

import java.util.Calendar;

public class StockQuote
{
    private String _symbol = null;

    private Double _value = null;

    private Calendar _timestamp = null;

    private String _error = null;

    public String getSymbol ()
    {
        return this._symbol;
    }

    public void setSymbol ( final String symbol )
    {
        this._symbol = symbol;
    }

    public Calendar getTimestamp ()
    {
        return this._timestamp;
    }

    public void setTimestamp ( final Calendar timestamp )
    {
        this._timestamp = timestamp;
    }

    public Double getValue ()
    {
        return this._value;
    }

    public void setValue ( final Double value )
    {
        this._value = value;
    }

    public String getError ()
    {
        return this._error;
    }

    public void setError ( final String error )
    {
        this._error = error;
    }
}
