/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.dataitem.details.part.overview;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
    private static final String BUNDLE_NAME = "org.eclipse.scada.da.client.dataitem.details.part.overview.messages"; //$NON-NLS-1$

    public static String OverviewDetailsPart_AlarmActiveText;

    public static String OverviewDetailsPart_AlarmInactiveText;

    public static String OverviewDetailsPart_AlarmLabel;

    public static String OverviewDetailsPart_WarningActiveText;

    public static String OverviewDetailsPart_WarningInactiveText;

    public static String OverviewDetailsPart_WarningLabel;

    public static String OverviewDetailsPart_ConnectionLabel;

    public static String OverviewDetailsPart_ErrorActiveText;

    public static String OverviewDetailsPart_ErrorInactiveText;

    public static String OverviewDetailsPart_ErrorLabel;

    public static String OverviewDetailsPart_ItemIdLabel;

    public static String OverviewDetailsPart_ManualActiveText;

    public static String OverviewDetailsPart_ManualInactiveText;

    public static String OverviewDetailsPart_ManualLabel;

    public static String OverviewDetailsPart_BlockedActiveText;

    public static String OverviewDetailsPart_BlockedInactiveText;

    public static String OverviewDetailsPart_BlockedLabel;

    public static String OverviewDetailsPart_NullText;

    public static String OverviewDetailsPart_SubscriptionStateFormat;

    public static String OverviewDetailsPart_SubscriptionStateLabel;

    public static String OverviewDetailsPart_TimeFormat;

    public static String OverviewDetailsPart_TimestampLabel;

    public static String OverviewDetailsPart_ValueLabel;
    static
    {
        // initialize resource bundle
        NLS.initializeMessages ( BUNDLE_NAME, Messages.class );
    }

    private Messages ()
    {
    }
}
