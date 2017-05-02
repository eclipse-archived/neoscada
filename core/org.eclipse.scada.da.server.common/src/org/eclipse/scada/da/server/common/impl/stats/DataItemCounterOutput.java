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
package org.eclipse.scada.da.server.common.impl.stats;

import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.common.impl.HiveCommon;
import org.eclipse.scada.utils.concurrent.DirectExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataItemCounterOutput implements CounterOutput
{

    private final static Logger logger = LoggerFactory.getLogger ( DataItemCounterOutput.class );

    private final DataItemInputChained averageItem;

    private final DataItemInputChained totalItem;

    private final MBeanServer mbs;

    private final CounterOutputMXBeanImpl export;

    private ObjectInstance exportInstance;

    private ObjectInstance totalInstance;

    private final String itemId;

    public DataItemCounterOutput ( final String itemId )
    {
        this.itemId = itemId;
        this.averageItem = new DataItemInputChained ( itemId + ".average", DirectExecutor.INSTANCE );
        this.totalItem = new DataItemInputChained ( itemId + ".total", DirectExecutor.INSTANCE );

        this.mbs = ManagementFactory.getPlatformMBeanServer ();

        this.export = new CounterOutputMXBeanImpl ();
    }

    @Override
    public void register ( final HiveCommon hive, final FolderCommon rootFolder, final String description )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ();

        hive.registerItem ( this.averageItem );
        attributes.put ( "description", Variant.valueOf ( description + " - Average value" ) );
        rootFolder.add ( this.averageItem.getInformation ().getName (), this.averageItem, attributes );

        attributes.clear ();

        hive.registerItem ( this.totalItem );
        attributes.put ( "description", Variant.valueOf ( description + " - Total counter" ) );
        rootFolder.add ( this.totalItem.getInformation ().getName (), this.totalItem, attributes );

        try
        {
            this.exportInstance = this.mbs.registerMBean ( this.export, makeName ( hive.getHiveId () + ".stats", this.itemId ) );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to export statistics", e );
        }
    }

    private ObjectName makeName ( final String domain, final String description ) throws MalformedObjectNameException, NullPointerException
    {
        final Hashtable<String, String> properties = new Hashtable<String, String> ( 1 );
        properties.put ( "value", description );
        return new ObjectName ( domain, properties );
    }

    @Override
    public void unregister ( final HiveCommon hive, final FolderCommon rootFolder )
    {
        rootFolder.remove ( this.averageItem );
        hive.unregisterItem ( this.averageItem );

        rootFolder.remove ( this.totalItem );
        hive.unregisterItem ( this.totalItem );

        if ( this.exportInstance != null )
        {
            try
            {
                this.mbs.unregisterMBean ( this.exportInstance.getObjectName () );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to unregister average", e );
            }
            this.exportInstance = null;
        }
        if ( this.totalInstance != null )
        {
            try
            {
                this.mbs.unregisterMBean ( this.totalInstance.getObjectName () );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to unregister total", e );
            }
            this.totalInstance = null;
        }
    }

    @Override
    public void setTickValue ( final double average, final long total )
    {
        this.averageItem.updateData ( Variant.valueOf ( average ), null, null );
        this.totalItem.updateData ( Variant.valueOf ( total ), null, null );
        this.export.setAverage ( average );
        this.export.setTotal ( total );
    }

}
