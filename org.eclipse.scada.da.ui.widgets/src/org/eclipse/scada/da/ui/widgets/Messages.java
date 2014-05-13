/*******************************************************************************
 * Copyright (c) 2010, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - extract common data item header label
 *******************************************************************************/
package org.eclipse.scada.da.ui.widgets;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
    private static final String BUNDLE_NAME = "org.eclipse.scada.da.ui.widgets.messages"; //$NON-NLS-1$

    public static String DataItemHeaderLabel_DataItemFormat;

    public static String DataItemHeaderLabel_EmptyDataItem;

    public static String DataItemHeaderLabel_NoValueText;

    static
    {
        // initialize resource bundle
        NLS.initializeMessages ( BUNDLE_NAME, Messages.class );
    }

    private Messages ()
    {
    }
}
