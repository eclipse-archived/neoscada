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
package org.eclipse.scada.ae.server.handler.filter;

import java.util.Map;

import org.eclipse.scada.ae.server.handler.EventHandler;
import org.eclipse.scada.ae.server.handler.EventHandlerFactory;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.utils.filter.Filter;
import org.eclipse.scada.utils.filter.FilterParser;

public class IncludeFilterHandlerFactory implements EventHandlerFactory
{

    @Override
    public EventHandler createHandler ( final Map<String, String> properties ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );
        final String filterString = cfg.getStringNonEmptyChecked ( "filter", null );

        final Filter filter = new FilterParser ( filterString ).getFilter ();

        return new FilterEventHandler ( filter, true );
    }

}
