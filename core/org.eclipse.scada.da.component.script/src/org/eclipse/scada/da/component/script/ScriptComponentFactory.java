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
package org.eclipse.scada.da.component.script;

import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.da.server.common.DataItem;
import org.osgi.framework.BundleContext;

public class ScriptComponentFactory extends AbstractServiceConfigurationFactory<ScriptComponent>
{
    private final BundleContext context;

    private final Executor executor;

    private final ObjectPoolImpl<DataItem> objectPool;

    public ScriptComponentFactory ( final Executor executor, final ObjectPoolImpl<DataItem> objectPool, final BundleContext context )
    {
        super ( context );
        this.executor = executor;
        this.objectPool = objectPool;
        this.context = context;
    }

    @Override
    protected Entry<ScriptComponent> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        return new Entry<ScriptComponent> ( configurationId, new ScriptComponent ( this.executor, this.objectPool, configurationId, context, parameters ) );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final ScriptComponent service )
    {
        service.dispose ();
    }

    @Override
    protected Entry<ScriptComponent> updateService ( final UserInformation userInformation, final String configurationId, final Entry<ScriptComponent> entry, final Map<String, String> parameters ) throws Exception
    {
        return createService ( userInformation, configurationId, this.context, parameters );
    }

}
