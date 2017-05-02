/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.ngp;

import java.util.List;
import java.util.Set;

import org.eclipse.scada.ae.BrowserListener;
import org.eclipse.scada.ae.data.BrowserEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserListenerManager implements BrowserListener
{

    private final static Logger logger = LoggerFactory.getLogger ( BrowserListenerManager.class );

    private final ServerConnectionImpl connection;

    public BrowserListenerManager ( final ServerConnectionImpl connection )
    {
        this.connection = connection;
    }

    @Override
    public void dataChanged ( final List<BrowserEntry> addedOrUpdated, final Set<String> removed, final boolean full )
    {
        logger.debug ( "Browser data changed: {}, {}, {}", new Object[] { addedOrUpdated, removed, full } );

        this.connection.handleBrowseDataChanged ( this, addedOrUpdated, removed, full );
    }

}
