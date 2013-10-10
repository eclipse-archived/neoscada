/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.master.mapper;

import java.util.Map;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.mapper.ValueMapper;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;

public class MapperHandlerFactoryImpl extends AbstractServiceConfigurationFactory<MapperMasterHandler>
{
    public static final String FACTORY_ID = "org.eclipse.scada.da.master.mapper";

    private final ObjectPoolTracker<MasterItem> poolTracker;

    private final ObjectPoolTracker<ValueMapper> mapperPoolTracker;

    private final int defaultPriority;

    public MapperHandlerFactoryImpl ( final BundleContext context, final ObjectPoolTracker<MasterItem> poolTracker, final ObjectPoolTracker<ValueMapper> mapperPoolTracker, final int defaultPriority ) throws InvalidSyntaxException
    {
        super ( context );
        this.poolTracker = poolTracker;
        this.mapperPoolTracker = mapperPoolTracker;
        this.defaultPriority = defaultPriority;
    }

    @Override
    public synchronized void dispose ()
    {
        this.poolTracker.close ();
        super.dispose ();
    }

    @Override
    protected Entry<MapperMasterHandler> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final MapperMasterHandler handler = new MapperMasterHandler ( configurationId, this.poolTracker, this.mapperPoolTracker, this.defaultPriority );
        handler.update ( userInformation, parameters );
        return new Entry<MapperMasterHandler> ( configurationId, handler );
    }

    @Override
    protected Entry<MapperMasterHandler> updateService ( final UserInformation userInformation, final String configurationId, final Entry<MapperMasterHandler> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( userInformation, parameters );
        return null;
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String id, final MapperMasterHandler service )
    {
        service.dispose ();
    }

}
