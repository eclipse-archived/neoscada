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
package org.eclipse.scada.da.server.stock.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.eclipse.scada.da.server.stock.domain.StockQuote;

public class MockStockQuoteService implements StockQuoteService
{

    public Collection<StockQuote> getStockQuotes ( final Collection<String> symbols )
    {
        final List<StockQuote> result = new ArrayList<StockQuote> ( symbols.size () );

        final Random r = new Random ( System.currentTimeMillis () );

        for ( final String symbol : symbols )
        {
            final StockQuote quote = new StockQuote ();
            final double value = r.nextDouble () * 100.0 - 10.0;
            if ( value < 0 )
            {
                quote.setError ( "Failed to get value" );
            }
            else
            {
                quote.setValue ( value );
            }
            quote.setSymbol ( symbol );
            quote.setTimestamp ( Calendar.getInstance () );

            result.add ( quote );
        }

        return result;
    }

}
