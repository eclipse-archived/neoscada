/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.client.dataitem.details.part.block;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
    private static final String BUNDLE_NAME = "org.eclipse.scada.da.client.dataitem.details.part.block.messages"; //$NON-NLS-1$

    public static String BlockDetailsPart_Format_Date;

    public static String BlockDetailsPart_Format_User;

    public static String BlockDetailsPart_Label_Reason;

    public static String BlockDetailsPart_Label_State;

    public static String BlockDetailsPart_Label_Timestamp;

    public static String BlockDetailsPart_Label_User;

    public static String BlockDetailsPart_NoneString;

    public static String BlockDetailsPart_Text_Block;

    public static String BlockDetailsPart_Text_Unblock;
    static
    {
        // initialize resource bundle
        NLS.initializeMessages ( BUNDLE_NAME, Messages.class );
    }

    private Messages ()
    {
    }
}
