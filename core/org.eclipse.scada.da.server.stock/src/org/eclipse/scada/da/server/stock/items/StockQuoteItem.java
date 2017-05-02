/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.stock.items;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.DataItemInputCommon;
import org.eclipse.scada.da.server.common.ItemListener;
import org.eclipse.scada.da.server.stock.domain.StockQuote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StockQuoteItem extends DataItemInputCommon implements StockQuoteListener
{

    private final static Logger logger = LoggerFactory.getLogger ( StockQuoteItem.class );

    private String symbol = null;

    private UpdateManager updateManager = null;

    public StockQuoteItem ( final String symbol, final UpdateManager updateManager )
    {
        super ( symbol );
        this.symbol = symbol;
        this.updateManager = updateManager;
    }

    @Override
    public synchronized void setListener ( final ItemListener listener )
    {
        super.setListener ( listener );
        if ( listener != null )
        {
            wakeup ();
        }
        else
        {
            suspend ();
        }
    }

    public void suspend ()
    {
        logger.warn ( String.format ( "Item %1$s suspended", getInformation ().getName () ) );
        this.updateManager.remove ( this.symbol );
    }

    public void wakeup ()
    {
        logger.warn ( String.format ( "Item %1$s woken up", getInformation ().getName () ) );
        this.updateManager.add ( this.symbol, this );
    }

    @Override
    public void update ( final StockQuote stockQuote )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ();
        Variant value = Variant.NULL;

        if ( stockQuote.getValue () != null )
        {
            value = Variant.valueOf ( stockQuote.getValue () );
            attributes.put ( "stock.error", null );
        }
        else
        {
            attributes.put ( "stock.error", Variant.valueOf ( stockQuote.getError () ) );
        }
        attributes.put ( "timestamp", Variant.valueOf ( stockQuote.getTimestamp ().getTimeInMillis () ) );

        updateData ( value, attributes, AttributeMode.UPDATE );
    }

}
