/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.server.common.item.internal;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantEditor;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.hd.server.common.HistoricalItem;
import org.eclipse.scada.sec.UserInformation;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurationFactoryImpl implements ConfigurationFactory
{
    private final static Logger logger = LoggerFactory.getLogger ( ConfigurationFactoryImpl.class );

    protected final class ItemWrapper
    {
        private final HistoricalItemImpl item;

        private final ServiceRegistration<HistoricalItem> registration;

        public ItemWrapper ( final HistoricalItemImpl item, final ServiceRegistration<HistoricalItem> registration )
        {
            this.item = item;
            this.registration = registration;
        }

        public HistoricalItemImpl getItem ()
        {
            return this.item;
        }

        public ServiceRegistration<HistoricalItem> getRegistration ()
        {
            return this.registration;
        }

        public void update ( final Map<String, String> properties ) throws Exception
        {
            this.item.update ( properties );
        }
    }

    private final Map<String, ItemWrapper> items = new HashMap<String, ItemWrapper> ();

    private final BundleContext context;

    public ConfigurationFactoryImpl ( final BundleContext context )
    {
        this.context = context;
    }

    public void dispose ()
    {
        final Set<ItemWrapper> items;
        synchronized ( this )
        {
            items = new HashSet<ItemWrapper> ( this.items.values () );
            this.items.clear ();
        }

        for ( final ItemWrapper item : items )
        {
            unregisterItem ( item );
        }
    }

    @Override
    public void delete ( final UserInformation userInformation, final String configurationId ) throws Exception
    {
        final ItemWrapper item;
        synchronized ( this.items )
        {
            item = this.items.remove ( configurationId );
        }
        if ( item != null )
        {
            unregisterItem ( item );
        }
    }

    private void unregisterItem ( final ItemWrapper item )
    {
        item.getRegistration ().unregister ();
        item.getItem ().stop ();
    }

    @Override
    public void update ( final UserInformation userInformation, final String configurationId, final Map<String, String> properties ) throws Exception
    {
        logger.info ( "Update call for {} -> {}", new Object[] { configurationId, properties } );

        synchronized ( this )
        {
            ItemWrapper item = this.items.get ( configurationId );
            if ( item == null )
            {
                logger.info ( "Creating new item: {}", configurationId );
                item = createItem ( configurationId, properties );
            }
            else
            {
                logger.info ( "Updating {}", configurationId );
                item.update ( properties );
            }
            this.items.put ( configurationId, item );
        }
    }

    private ItemWrapper createItem ( final String configurationId, final Map<String, String> properties ) throws InvalidSyntaxException
    {
        final String masterId = properties.get ( DataSource.DATA_SOURCE_ID );
        if ( masterId == null )
        {
            throw new IllegalArgumentException ( String.format ( "'%s' is not set", DataSource.DATA_SOURCE_ID ) );
        }

        final Dictionary<String, String> serviceProperties = new Hashtable<String, String> ();
        serviceProperties.put ( Constants.SERVICE_PID, configurationId );
        serviceProperties.put ( Constants.SERVICE_DESCRIPTION, "A historical item implementation" );
        serviceProperties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );

        final Map<String, Variant> attributes = new HashMap<String, Variant> ();
        attributes.put ( Constants.SERVICE_DESCRIPTION, Variant.valueOf ( "A historical item implementation" ) );
        attributes.put ( Constants.SERVICE_VENDOR, Variant.valueOf ( "openSCADA.org" ) );
        attributes.put ( Constants.SERVICE_PID, Variant.valueOf ( configurationId ) );
        attributes.put ( "master.id", Variant.valueOf ( masterId ) );

        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );
        for ( final Map.Entry<String, String> entry : cfg.getPrefixed ( "information." ).entrySet () )
        {
            attributes.put ( entry.getKey (), VariantEditor.toVariant ( entry.getValue () ) );
        }

        final HistoricalItemImpl item = new HistoricalItemImpl ( configurationId, attributes, masterId, this.context );

        final ServiceRegistration<HistoricalItem> registration = this.context.registerService ( HistoricalItem.class, item, serviceProperties );

        item.start ();

        return new ItemWrapper ( item, registration );
    }

}
