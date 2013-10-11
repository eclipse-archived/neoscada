/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.dataitem.details.part.flags;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
    private static final String BUNDLE_NAME = "org.eclipse.scada.da.client.dataitem.details.part.flags.messages"; //$NON-NLS-1$

    public static String FlagsDetailsPart_ActiveMarker;

    public static String FlagsDetailsPart_ColFlagLabel;

    public static String FlagsDetailsPart_ColStateLabel;

    public static String FlagsDetailsPart_GroupAknLabel;

    public static String FlagsDetailsPart_GroupAlarmLabel;

    public static String FlagsDetailsPart_GroupBlockingLabel;

    public static String FlagsDetailsPart_GroupErrorLabel;

    public static String FlagsDetailsPart_GroupSumFormat;

    public static String FlagsDetailsPart_GroupWarningLabel;

    public static String FlagsDetailsPart_InactiveMarker;

    public static String FlagsDetailsPart_ManualLabel;

    static
    {
        // initialize resource bundle
        NLS.initializeMessages ( BUNDLE_NAME, Messages.class );
    }

    private Messages ()
    {
    }
}
