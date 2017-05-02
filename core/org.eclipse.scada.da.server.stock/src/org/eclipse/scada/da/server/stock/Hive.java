/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.stock;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.ValidationStrategy;
import org.eclipse.scada.da.server.common.impl.HiveCommon;
import org.eclipse.scada.da.server.stock.business.YahooStockQuoteService;
import org.eclipse.scada.da.server.stock.items.StockQuoteItem;
import org.eclipse.scada.da.server.stock.items.UpdateManager;
import org.eclipse.scada.utils.collection.MapBuilder;

public class Hive extends HiveCommon
{

    private static final int UPDATE_PERIOD = 30 * 1000;

    private ScheduledExecutorService scheduler;

    private final FolderCommon symbolsFolder;

    private final UpdateManager updateManager;

    public Hive () throws IOException
    {
        super ();

        setValidatonStrategy ( ValidationStrategy.GRANT_ALL );

        // create root folder
        final FolderCommon rootFolder = new FolderCommon ();
        setRootFolder ( rootFolder );

        // create and register test folder
        this.symbolsFolder = new FolderCommon ();
        rootFolder.add ( "symbols", this.symbolsFolder, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "This folder contains the items by stock symbol" ) ).getMap () );

        this.updateManager = new UpdateManager ();
        this.updateManager.setStockQuoteService ( new YahooStockQuoteService () );

    }

    @Override
    public String getHiveId ()
    {
        return "org.eclipse.scada.da.server.stock";
    }

    @Override
    protected void performStart () throws Exception
    {
        super.performStart ();

        this.scheduler = Executors.newSingleThreadScheduledExecutor ();

        this.scheduler.scheduleAtFixedRate ( new Runnable () {

            @Override
            public void run ()
            {
                Hive.this.updateManager.update ();
            }
        }, UPDATE_PERIOD, UPDATE_PERIOD, TimeUnit.MILLISECONDS );

        addSymbol ( "RHT" );
        addSymbol ( "YHOO" );
    }

    @Override
    protected void performStop () throws Exception
    {
        this.scheduler.shutdown ();
        super.performStop ();
    }

    public void addSymbol ( final String symbol )
    {
        // this is a bad example, items are created but can never be destroyed!
        // TODO: should use some sort of ItemFactory
        final StockQuoteItem newItem = new StockQuoteItem ( symbol, this.updateManager );
        registerItem ( newItem );
        this.symbolsFolder.add ( symbol, newItem, new MapBuilder<String, Variant> ().getMap () );
    }

}
