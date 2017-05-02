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
package org.eclipse.scada.da.server.proxy.utils;

import java.util.regex.Pattern;

/**
 * @author Juergen Rose &lt;juergen.rose@th4-systems.com&gt;
 *
 */
public class ProxyUtils
{
    /**
     * @param itemId
     * @param separator
     * @param proxyPrefix
     * @param originalPrefix
     * @return name of original item
     */
    public static String originalItemId ( final String itemId, final String separator, final ProxyPrefixName proxyPrefix, final ProxyPrefixName originalPrefix )
    {
        if ( originalPrefix == null || "".equals ( originalPrefix.getName () ) )
        {
            return itemId.replaceFirst ( Pattern.quote ( proxyPrefix.getName () + separator ), "" );
        }
        return itemId.replaceFirst ( Pattern.quote ( proxyPrefix.getName () + separator ), originalPrefix.getName () + separator );
    }

    /**
     * @param itemId
     * @param separator
     * @param proxyPrefix
     * @param originalPrefix
     * @return name of item the way it is named in proxyserver
     */
    public static String proxyItemId ( final String itemId, final String separator, final ProxyPrefixName proxyPrefix, final ProxyPrefixName originalPrefix )
    {
        if ( originalPrefix == null || "".equals ( originalPrefix.getName () ) )
        {
            return proxyPrefix.getName () + separator + itemId;
        }
        return itemId.replaceFirst ( Pattern.quote ( originalPrefix.getName () + separator ), proxyPrefix.getName () + separator );
    }

    /**
     * checks if an item id matches the sub connection prefix and may be put into the proxy group
     * @param itemId
     * @param separator
     * @param originalPrefix
     * @return
     */
    public static boolean isOriginalItemForProxyGroup ( final String itemId, final String separator, final ProxyPrefixName originalPrefix )
    {
        if ( originalPrefix == null || "".equals ( originalPrefix.getName () ) )
        {
            return true;
        }
        return itemId.startsWith ( originalPrefix.getName () + separator );
    }
}
