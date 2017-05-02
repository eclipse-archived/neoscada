/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.generator.interceptor;

import java.util.Properties;

import org.eclipse.scada.configuration.component.ItemInterceptor;
import org.eclipse.scada.configuration.component.lib.ItemInterceptorHandler;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.world.osgi.Item;

public abstract class AbstractItemInterceptorHandler implements ItemInterceptorHandler
{

    /**
     * @return <code>true</code> if the even should be passed to other
     *         interceptors
     */
    protected abstract boolean processInterceptItem ( final Item item, final ItemInterceptor interceptorElement, final MasterContext masterContext, Properties properties );

    @Override
    public boolean interceptItem ( final Item item, final ItemInterceptor interceptorElement, final MasterContext masterContext, final Properties properties )
    {
        if ( !interceptorElement.getMasterOn ().contains ( masterContext.getDefinition () ) )
        {
            // interceptor is not for this master
            return true;
        }

        return processInterceptItem ( item, interceptorElement, masterContext, properties );
    }

}