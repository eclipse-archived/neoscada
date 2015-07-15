/*******************************************************************************
 * Copyright (c) 2013, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.generator.internal;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.configuration.component.RestInterceptor;
import org.eclipse.scada.configuration.component.generator.interceptor.internal.RestItemInterceptorHandler;
import org.eclipse.scada.configuration.component.lib.ItemInterceptorHandler;

public class InterceptorAdapterFactory implements IAdapterFactory
{

    @SuppressWarnings ( { "unchecked" } )
    @Override
    public <T> T getAdapter ( final Object adaptableObject, final Class<T> adapterType )
    {
        if ( !ItemInterceptorHandler.class.equals ( adapterType ) )
        {
            return null;
        }
        if ( adaptableObject instanceof RestInterceptor )
        {
            return (T)new RestItemInterceptorHandler ();
        }
        return null;
    }

    @Override
    public Class<?>[] getAdapterList ()
    {
        return new Class<?>[] { ItemInterceptorHandler.class };
    }

}
