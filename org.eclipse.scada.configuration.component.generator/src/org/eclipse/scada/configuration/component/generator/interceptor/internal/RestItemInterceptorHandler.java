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
package org.eclipse.scada.configuration.component.generator.interceptor.internal;

import org.eclipse.scada.configuration.component.ItemInterceptor;
import org.eclipse.scada.configuration.component.RestInterceptor;
import org.eclipse.scada.configuration.component.generator.interceptor.AbstractItemInterceptorHandler;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.world.osgi.ApplicationModule;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.RestExporter;

public class RestItemInterceptorHandler extends AbstractItemInterceptorHandler
{
    @Override
    protected boolean processInterceptItem ( final Item item, final ItemInterceptor interceptorElement, final MasterContext masterContext )
    {
        final RestInterceptor interceptor = (RestInterceptor)interceptorElement;
        final String contextId = interceptor.getDefinition ().getContextId ();

        for ( final ApplicationModule a : masterContext.getImplementation ().getModules () )
        {
            if ( a instanceof RestExporter )
            {
                if ( ( (RestExporter)a ).getContextId ().equals ( contextId ) )
                {
                    // found context -> insert
                    ( (RestExporter)a ).getItems ().add ( item );
                    return true;
                }
            }
        }

        throw new IllegalStateException ( String.format ( "Unable to find REST exporter: %s", contextId ) );
    }

}
