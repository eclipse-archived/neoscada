/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - use new Adapter and Selection Helper
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.tester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.scada.core.ui.connection.ConnectionDiscoverer;
import org.eclipse.scada.core.ui.connection.ConnectionStore;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionDiscovererBeanTester extends PropertyTester
{

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionDiscovererBeanTester.class );

    @Override
    public boolean test ( final Object receiver, final String property, final Object[] args, final Object expectedValue )
    {
        logger.debug ( "Testing {} for {}", receiver, property );

        final ConnectionDiscoverer discoverer = AdapterHelper.adapt ( receiver, ConnectionDiscoverer.class );
        if ( discoverer == null )
        {
            return false;
        }

        if ( "isStore".equals ( property ) && expectedValue instanceof Boolean )
        {
            final boolean isStore = AdapterHelper.adapt ( receiver, ConnectionStore.class ) != null;
            return isStore == (Boolean)expectedValue;
        }

        return false;
    }

}
