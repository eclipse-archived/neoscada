/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.proxy.item;

import org.eclipse.scada.da.server.proxy.utils.ProxyPrefixName;
import org.eclipse.scada.da.server.proxy.utils.ProxySubConnectionId;

public class ProxyItemSupport
{
    protected volatile ProxySubConnectionId currentConnection;

    protected String separator = ".";

    protected final ProxyPrefixName prefix;

    /**
     * This is the item Id of the proxy item
     */
    protected final String proxyItemId;

    public ProxyItemSupport ( final String separator, final ProxyPrefixName prefix, final ProxySubConnectionId currentConnection, final String proxyItemId )
    {
        this.separator = separator;
        this.prefix = prefix;
        this.currentConnection = currentConnection;
        this.proxyItemId = proxyItemId;
    }

    /**
     * Switch between connections
     * @param newConnection
     */
    public void switchTo ( final ProxySubConnectionId newConnection )
    {
        this.currentConnection = newConnection;
    }

    /**
     * @return id of proxy item
     */
    public String getItemId ()
    {
        return this.proxyItemId;
    }

}