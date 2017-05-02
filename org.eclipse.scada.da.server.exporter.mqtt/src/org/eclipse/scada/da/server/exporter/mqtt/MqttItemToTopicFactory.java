/*******************************************************************************
 * Copyright (c) 2013 Jürgen Rose and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jürgen Rose - initial API and implementation
 *******************************************************************************/

package org.eclipse.scada.da.server.exporter.mqtt;

import java.util.Map;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class MqttItemToTopicFactory extends AbstractServiceConfigurationFactory<MqttItemToTopic>
{

    private final ObjectPoolImpl<MqttItemToTopic> objectPool;

    private final ServiceRegistration<?> poolRegistration;

    private final BundleContext context;

    public MqttItemToTopicFactory ( final BundleContext context )
    {
        super ( context );
        this.context = context;
        this.objectPool = new ObjectPoolImpl<MqttItemToTopic> ();
        this.poolRegistration = ObjectPoolHelper.registerObjectPool ( context, this.objectPool, MqttItemToTopic.class );
    }

    @Override
    protected Entry<MqttItemToTopic> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final MqttItemToTopic service = new MqttItemToTopic ();
        service.update ( parameters );

        this.objectPool.addService ( configurationId, service, null );

        return new Entry<MqttItemToTopic> ( configurationId, service );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final MqttItemToTopic service )
    {
        this.objectPool.removeService ( configurationId, service );
    }

    @Override
    protected Entry<MqttItemToTopic> updateService ( final UserInformation userInformation, final String configurationId, final Entry<MqttItemToTopic> entry, final Map<String, String> parameters ) throws Exception
    {
        disposeService ( userInformation, configurationId, entry.getService () );
        return createService ( userInformation, configurationId, this.context, parameters );
    }

    @Override
    public synchronized void dispose ()
    {
        this.poolRegistration.unregister ();
        this.objectPool.dispose ();
        super.dispose ();
    }
}
