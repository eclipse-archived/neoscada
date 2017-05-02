/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.proxy.connection;

import org.eclipse.scada.da.server.common.factory.DataItemFactory;
import org.eclipse.scada.da.server.proxy.Hive;
import org.eclipse.scada.da.server.proxy.item.ProxyDataItem;
import org.eclipse.scada.da.server.proxy.utils.ProxyPrefixName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Juergen Rose &lt;juergen.rose@th4-systems.com&gt;
 *
 */
public class ProxyDataItemFactory implements DataItemFactory
{

    private final static Logger logger = LoggerFactory.getLogger ( ProxyDataItemFactory.class );

    private final String separator;

    private final ProxyPrefixName prefix;

    private final ProxyConnection connection;

    private final Hive hive;

    public ProxyDataItemFactory ( final ProxyPrefixName prefix, final ProxyConnection connection, final Hive hive, final String separator )
    {
        this.separator = separator;
        this.prefix = prefix;
        this.connection = connection;
        this.hive = hive;
    }

    @Override
    public boolean canCreate ( final String requestItemId )
    {
        logger.info ( "Checking request: {} for {}", requestItemId, this.prefix );

        return requestItemId.startsWith ( this.prefix.getName () + this.separator );
    }

    @Override
    public void create ( final String requestItemId )
    {
        if ( !canCreate ( requestItemId ) )
        {
            return;
        }

        final ProxyDataItem item = this.connection.realizeItem ( requestItemId );
        this.hive.registerItem ( item );
    }
}
