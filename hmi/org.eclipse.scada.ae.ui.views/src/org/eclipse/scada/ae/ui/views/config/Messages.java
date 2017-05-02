/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.config;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
    private static final String BUNDLE_NAME = "org.eclipse.scada.ae.ui.views.config.messages"; //$NON-NLS-1$

    public static String EventPoolViewConfiguration_IllegalArgument_connectionString;

    public static String EventPoolViewConfiguration_IllegalArgument_connectionType;

    public static String EventPoolViewConfiguration_IllegalArgument_eventPoolQueryId;

    public static String EventPoolViewConfiguration_IllegalArgument_id;

    public static String EventPoolViewConfiguration_IllegalArgument_monitorQueryId;

    public static String MonitorViewConfiguration_IllegalArgument_connectionString;

    public static String MonitorViewConfiguration_IllegalArgument_connectionType;

    public static String MonitorViewConfiguration_IllegalArgument_id;

    public static String MonitorViewConfiguration_IllegalArgument_monitorQueryId;

    public static String EventHistoryViewConfiguration_IllegalArgument_id;

    public static String EventHistoryViewConfiguration_IllegalArgument_connectionString;

    public static String EventHistoryViewConfiguration_IllegalArgument_connectionType;

    static
    {
        // initialize resource bundle
        NLS.initializeMessages ( BUNDLE_NAME, Messages.class );
    }

    private Messages ()
    {
    }
}
