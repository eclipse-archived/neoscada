/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.lib.oscar.event;

import java.util.Collections;
import java.util.Map;

import org.eclipse.scada.configuration.world.osgi.EventHandler;

public class DefaultStorageHandlerProcessor extends BasicEventHandlerProcessor implements EventHandlerProcessor
{

    public DefaultStorageHandlerProcessor ()
    {
        super ( "defaultStorage" );
    }

    @Override
    protected Map<String, String> makeData ( final EventHandler eventHandler, final String id )
    {
        return Collections.emptyMap ();
    }

}
