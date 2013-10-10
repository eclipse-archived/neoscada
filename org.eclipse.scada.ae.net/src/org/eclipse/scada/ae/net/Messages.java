/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.net;

public class Messages
{
    /**
     * Base command code for all A&E messages
     */
    public static final int CC_AE_BASE = 0x00030000;

    public static final int CC_SUBSCRIBE_EVENT_POOL = CC_AE_BASE + 0x0001;

    public static final int CC_UNSUBSCRIBE_EVENT_POOL = CC_AE_BASE + 0x0002;

    public static final int CC_EVENT_POOL_STATUS = CC_AE_BASE + 0x0003;

    public static final int CC_EVENT_POOL_DATA = CC_AE_BASE + 0x0004;

    public static final int CC_SUBSCRIBE_CONDITIONS = CC_AE_BASE + 0x0011;

    public static final int CC_UNSUBSCRIBE_CONDITIONS = CC_AE_BASE + 0x0012;

    public static final int CC_CONDITIONS_STATUS = CC_AE_BASE + 0x0013;

    public static final int CC_CONDITIONS_DATA = CC_AE_BASE + 0x0014;

    public static final int CC_CONDITION_AKN = CC_AE_BASE + 0x0015;

    public static final int CC_BROWSER_UPDATE = CC_AE_BASE + 0x0021;

    public static final int CC_QUERY_CREATE = CC_AE_BASE + 0x0031;

    public static final int CC_QUERY_CLOSE = CC_AE_BASE + 0x0032;

    public static final int CC_QUERY_STATUS_CHANGED = CC_AE_BASE + 0x0033;

    public static final int CC_QUERY_DATA = CC_AE_BASE + 0x0034;

    public static final int CC_QUERY_LOAD_MORE = CC_AE_BASE + 0x0035;

}
