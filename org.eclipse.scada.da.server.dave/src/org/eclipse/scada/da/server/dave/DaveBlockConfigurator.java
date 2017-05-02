/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.dave;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.da.server.common.memory.AbstractRequestBlock;
import org.eclipse.scada.protocol.dave.DaveReadRequest.Request;
import org.eclipse.scada.utils.osgi.FilterUtil;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaveBlockConfigurator
{

    private final static Logger logger = LoggerFactory.getLogger ( DaveBlockConfigurator.class );

    private final DaveDevice device;

    private final BundleContext context;

    private ServiceTracker<?, ?> tracker;

    private final Map<ServiceReference<?>, String> blocks = new HashMap<ServiceReference<?>, String> ();

    public DaveBlockConfigurator ( final DaveDevice device, final BundleContext context )
    {
        this.device = device;
        this.context = context;

        final Map<String, String> parameters = new HashMap<String, String> ();
        parameters.put ( "daveDevice", device.getId () );
        try
        {
            final Filter filter = FilterUtil.createAndFilter ( BlockConfiguration.class.getName (), parameters );
            this.tracker = new ServiceTracker<Object, Object> ( context, filter, new ServiceTrackerCustomizer<Object, Object> () {

                @Override
                public void removedService ( final ServiceReference<Object> reference, final Object service )
                {
                    if ( service instanceof BlockConfiguration )
                    {
                        if ( DaveBlockConfigurator.this.removeBlock ( reference, (BlockConfiguration)service ) )
                        {
                            context.ungetService ( reference );
                        }
                    }
                }

                @Override
                public void modifiedService ( final ServiceReference<Object> reference, final Object service )
                {
                    DaveBlockConfigurator.this.modifyBlock ( reference, (BlockConfiguration)service );
                }

                @Override
                public Object addingService ( final ServiceReference<Object> reference )
                {
                    final Object o = DaveBlockConfigurator.this.context.getService ( reference );
                    try
                    {
                        DaveBlockConfigurator.this.addOrReplaceBlock ( reference, (BlockConfiguration)o );
                        return o;
                    }
                    catch ( final Throwable e )
                    {
                        logger.warn ( "Failed to add block", e );
                        return o;
                    }
                }
            } );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to configure", e );
        }
        if ( this.tracker != null )
        {
            this.tracker.open ();
        }
    }

    protected void modifyBlock ( final ServiceReference<?> reference, final BlockConfiguration service )
    {
        logger.info ( "Modify block: {}", reference );

        // will be a quick remove and add operation
        addOrReplaceBlock ( reference, service );
    }

    protected boolean removeBlock ( final ServiceReference<?> reference, final BlockConfiguration block )
    {
        final String oldBlock = this.blocks.remove ( reference );
        if ( oldBlock != null )
        {
            this.device.removeBlock ( oldBlock );
            return true;
        }
        return false;
    }

    protected void addOrReplaceBlock ( final ServiceReference<?> reference, final BlockConfiguration block )
    {
        logger.info ( String.format ( "Adding or replace block - ref: %s, block: %s", new Object[] { reference, block } ) );

        final String oldBlock = this.blocks.put ( reference, block.getId () );

        if ( oldBlock != null )
        {
            logger.info ( "Replacing exisiting block" );
            this.device.removeBlock ( oldBlock );
        }

        final AbstractRequestBlock deviceBlock = makeBlock ( block );
        try
        {
            this.device.addBlock ( block.getId (), deviceBlock );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to add block", e );
            deviceBlock.dispose ();
        }
    }

    private AbstractRequestBlock makeBlock ( final BlockConfiguration block )
    {
        logger.debug ( "Make new block: {}", block );

        final Request request = new Request ( (byte)block.getArea (), (short)block.getBlock (), (short)block.getStart (), (short)block.getCount () );

        final DaveRequestBlock deviceBlock = new DaveRequestBlock ( block.getId (), block.getName (), block.getType (), this.device, this.context, request, block.isEnableStatistics (), block.getPeriod () );
        return deviceBlock;
    }

    public void dispose ()
    {
        if ( this.tracker != null )
        {
            this.tracker.close ();
        }
    }

}
