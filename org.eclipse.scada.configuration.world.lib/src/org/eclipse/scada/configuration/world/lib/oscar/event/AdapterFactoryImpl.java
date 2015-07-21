/*******************************************************************************
 * Copyright (c) 2014, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.lib.oscar.event;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.configuration.world.osgi.DefaultStorageHandler;
import org.eclipse.scada.configuration.world.osgi.ExcludeEventFilter;
import org.eclipse.scada.configuration.world.osgi.IncludeEventFilter;
import org.eclipse.scada.configuration.world.osgi.MailEventHandler;
import org.eclipse.scada.configuration.world.osgi.ScriptEventHandler;

public class AdapterFactoryImpl implements IAdapterFactory
{

    @Override
    public <T> T getAdapter ( final Object adaptableObject, final Class<T> adapterType )
    {
        if ( adapterType.equals ( EventHandlerProcessor.class ) )
        {
            if ( adaptableObject instanceof DefaultStorageHandler )
            {
                return adapterType.cast ( new DefaultStorageHandlerProcessor () );
            }
            else if ( adaptableObject instanceof MailEventHandler )
            {
                return adapterType.cast ( new MailHandlerProcessor () );
            }
            else if ( adaptableObject instanceof IncludeEventFilter )
            {
                return adapterType.cast ( new IncludeFilterHandlerProcessor () );
            }
            else if ( adaptableObject instanceof ExcludeEventFilter )
            {
                return adapterType.cast ( new ExcludeFilterHandlerProcessor () );
            }
            else if ( adaptableObject instanceof ScriptEventHandler )
            {
                return adapterType.cast ( new ScriptHandlerProcessor () );
            }
        }

        return null;
    }

    @Override
    public Class<?>[] getAdapterList ()
    {
        return new Class[] { EventHandlerProcessor.class };
    }

}
