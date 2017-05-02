/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.lib;

import java.util.Properties;

import org.eclipse.scada.configuration.component.ItemInterceptor;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.world.osgi.Item;

public interface ItemInterceptorHandler
{
    /**
     * Intercept an item
     * <p>
     * Note that if the item is realized on multiple master servers the method
     * will be called once for each master.
     * </p>
     * 
     * @param item
     *            the item to intercept
     * @param interceptor
     *            the interceptor element
     * @param masterContext
     *            the master context
     * @param properties
     *            the aggregated component properties
     * @return <code>true</code> if the event should be passed to other
     *         interceptors
     */
    public boolean interceptItem ( Item item, ItemInterceptor interceptor, MasterContext masterContext, Properties properties );
}
