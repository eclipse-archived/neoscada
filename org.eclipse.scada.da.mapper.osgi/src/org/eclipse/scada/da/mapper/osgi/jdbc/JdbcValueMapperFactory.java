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
package org.eclipse.scada.da.mapper.osgi.jdbc;

import java.util.Map;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.mapper.ValueMapper;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ManageableObjectPool;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.da.server.common.DataItem;
import org.osgi.framework.BundleContext;

public class JdbcValueMapperFactory extends AbstractServiceConfigurationFactory<JdbcValueMapper>
{

    public static final String FACTORY_ID = "org.eclipse.scada.da.mapper.osgi.jdbcMapper";

    private final ManageableObjectPool<ValueMapper> pool;

    private final BundleContext context;

    private final ObjectPoolImpl<DataItem> itemPool;

    public JdbcValueMapperFactory ( final BundleContext context, final ManageableObjectPool<ValueMapper> pool, final ObjectPoolImpl<DataItem> itemPool )
    {
        super ( context );
        this.context = context;
        this.pool = pool;
        this.itemPool = itemPool;
    }

    @Override
    protected Entry<JdbcValueMapper> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final JdbcValueMapper service = new JdbcValueMapper ( this.context, configurationId, this.itemPool );
        service.update ( parameters );

        this.pool.addService ( configurationId, service, null );

        return new Entry<JdbcValueMapper> ( configurationId, service );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final JdbcValueMapper service )
    {
        this.pool.removeService ( configurationId, service );
        service.dispose ();
    }

    @Override
    protected Entry<JdbcValueMapper> updateService ( final UserInformation userInformation, final String configurationId, final Entry<JdbcValueMapper> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( parameters );
        return null;
    }

}
