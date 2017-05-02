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
package org.eclipse.scada.da.mapper.osgi.ca;

import java.util.Map;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.mapper.ValueMapper;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ManageableObjectPool;
import org.osgi.framework.BundleContext;

public class ConfiguredValueMapperFactory extends AbstractServiceConfigurationFactory<ConfiguredValueMapper>
{

    public static final String FACTORY_ID = "org.eclipse.scada.da.mapper.osgi.configuredMapper";

    private final ManageableObjectPool<ValueMapper> pool;

    public ConfiguredValueMapperFactory ( final BundleContext context, final ManageableObjectPool<ValueMapper> pool )
    {
        super ( context );
        this.pool = pool;
    }

    @Override
    protected Entry<ConfiguredValueMapper> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final ConfiguredValueMapper service = new ConfiguredValueMapper ();
        service.update ( parameters );

        this.pool.addService ( configurationId, service, null );

        return new Entry<ConfiguredValueMapper> ( configurationId, service );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final ConfiguredValueMapper service )
    {
        this.pool.removeService ( configurationId, service );
        service.dispose ();
    }

    @Override
    protected Entry<ConfiguredValueMapper> updateService ( final UserInformation userInformation, final String configurationId, final Entry<ConfiguredValueMapper> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( parameters );
        return null;
    }

}
