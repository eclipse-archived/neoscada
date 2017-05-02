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
package org.eclipse.scada.da.server.stock.items;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.da.server.stock.business.StockQuoteService;
import org.eclipse.scada.da.server.stock.domain.StockQuote;

public class UpdateManager
{
    private final Map<String, StockQuoteListener> _registeredSymbols = new HashMap<String, StockQuoteListener> ();

    private StockQuoteService _stockQuoteService = null;

    public synchronized void update ()
    {
        if ( !this._registeredSymbols.isEmpty () )
        {
            fireEvents ( this._stockQuoteService.getStockQuotes ( this._registeredSymbols.keySet () ) );
        }
    }

    public synchronized void add ( final String symbol, final StockQuoteListener listener )
    {
        this._registeredSymbols.put ( symbol, listener );
        updateNow ( symbol );
    }

    protected void updateNow ( final String symbol )
    {
        fireEvents ( this._stockQuoteService.getStockQuotes ( Arrays.asList ( new String[] { symbol } ) ) );
    }

    protected void fireEvents ( final Collection<StockQuote> stockQuotes )
    {
        for ( final StockQuote stockQuote : stockQuotes )
        {
            final StockQuoteListener listener = this._registeredSymbols.get ( stockQuote.getSymbol () );
            try
            {
                listener.update ( stockQuote );
            }
            catch ( final Throwable e )
            {
            }
        }
    }

    public synchronized void remove ( final String symbol )
    {
        this._registeredSymbols.remove ( symbol );
    }

    public void setStockQuoteService ( final StockQuoteService stockQuoteService )
    {
        this._stockQuoteService = stockQuoteService;
    }
}
