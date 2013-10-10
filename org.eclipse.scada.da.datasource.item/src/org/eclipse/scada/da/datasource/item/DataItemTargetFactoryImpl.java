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
package org.eclipse.scada.da.datasource.item;

import java.util.Dictionary;
import java.util.EnumSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.DataItemInformationBase;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceRegistration;

public class DataItemTargetFactoryImpl extends AbstractServiceConfigurationFactory<DataItemTargetImpl>
{
    public static final String FACTORY_ID = "da.dataitem.datasource";

    private final BundleContext context;

    private final ObjectPoolTracker<DataSource> poolTracker;

    private final ObjectPoolImpl<DataItem> itemPool;

    private final ServiceRegistration<?> itemPoolHandle;

    public DataItemTargetFactoryImpl ( final BundleContext context ) throws InvalidSyntaxException
    {
        super ( context );
        this.itemPool = new ObjectPoolImpl<DataItem> ();

        this.itemPoolHandle = ObjectPoolHelper.registerObjectPool ( context, this.itemPool, DataItem.class );

        this.context = context;
        this.poolTracker = new ObjectPoolTracker<DataSource> ( context, DataSource.class );
        this.poolTracker.open ();
    }

    @Override
    public synchronized void dispose ()
    {
        this.itemPoolHandle.unregister ();
        this.itemPool.dispose ();

        this.poolTracker.close ();

        super.dispose ();
    }

    @Override
    protected Entry<DataItemTargetImpl> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        return createDataItem ( configurationId, context, parameters );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String id, final DataItemTargetImpl service )
    {
        this.itemPool.removeService ( id, service );
        service.dispose ();
    }

    @Override
    protected Entry<DataItemTargetImpl> updateService ( final UserInformation userInformation, final String configurationId, final Entry<DataItemTargetImpl> entry, final Map<String, String> parameters ) throws Exception
    {
        this.itemPool.removeService ( configurationId, entry.getService () );
        entry.getService ().dispose ();

        return createDataItem ( configurationId, this.context, parameters );
    }

    protected Entry<DataItemTargetImpl> createDataItem ( final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws InvalidSyntaxException
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        final String itemId = cfg.getStringChecked ( "item.id", "'item.id' must be set" );

        final String io = cfg.getString ( "io.directions" );
        final Set<IODirection> ioDirection;
        if ( io != null )
        {
            ioDirection = EnumSet.noneOf ( IODirection.class );
            for ( final String tok : io.split ( "," ) )
            {
                ioDirection.add ( IODirection.valueOf ( tok ) );
            }
        }
        else
        {
            ioDirection = EnumSet.allOf ( IODirection.class );
        }

        final String datasourceId = parameters.get ( "datasource.id" );
        final DataItemTargetImpl item = new DataItemTargetImpl ( this.poolTracker, new DataItemInformationBase ( itemId, ioDirection ), datasourceId );

        final Dictionary<String, String> properties = new Hashtable<String, String> ( 1 );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );

        final String description = parameters.get ( "description" );
        if ( description != null )
        {
            properties.put ( Constants.SERVICE_DESCRIPTION, description );
        }

        // register
        this.itemPool.addService ( configurationId, item, properties );

        return new Entry<DataItemTargetImpl> ( configurationId, item );
    }
}
