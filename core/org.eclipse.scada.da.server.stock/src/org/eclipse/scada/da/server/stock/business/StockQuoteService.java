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

import java.util.Collection;

import org.eclipse.scada.da.server.stock.domain.StockQuote;

public interface StockQuoteService
{
    public abstract Collection<StockQuote> getStockQuotes ( Collection<String> symbols );
}
