/*******************************************************************************
 * Copyright (c) 2006, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.osgi.pool;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ObjectPoolHelper
{
    /**
     * Register the object pool with the OSGi service bus
     * <p>
     * The caller must ensure that the service is unregistered using the service
     * registration object returned.
     * </p>
     * 
     * @param context
     *            the context used for registering
     * @param pool
     *            the pool to register
     * @param poolClass
     *            the service class provided by this pool
     * @return the service registration
     */
    public static ServiceRegistration<?> registerObjectPool ( final BundleContext context, final ObjectPool<?> pool, final String poolClass )
    {
        final Dictionary<String, Object> properties = new Hashtable<String, Object> ( 1 );
        properties.put ( ObjectPool.OBJECT_POOL_CLASS, poolClass );
        return context.registerService ( ObjectPool.class.getName (), pool, properties );
    }

    /**
     * Register the object pool with the OSGi service bus
     * <p>
     * This method actually calls
     * {@link #registerObjectPool(BundleContext, ObjectPool, String)} with
     * {@link Class#getName()} from poolClass.
     * </p>
     * 
     * @param context
     *            the context used for registering
     * @param pool
     *            the pool to register
     * @param poolClass
     *            the service class provided by this pool
     * @return the service registration
     */
    public static <S> ServiceRegistration<?> registerObjectPool ( final BundleContext context, final ObjectPool<S> pool, final Class<? extends S> poolClass )
    {
        return registerObjectPool ( context, pool, poolClass.getName () );
    }
}
