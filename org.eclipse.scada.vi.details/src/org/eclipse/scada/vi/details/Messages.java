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
package org.eclipse.scada.vi.details;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
    private static final String BUNDLE_NAME = "org.eclipse.scada.vi.details.messages"; //$NON-NLS-1$

    public static String DetailViewDialog_ErrorDialog_Message_NotFound;

    public static String DetailViewDialog_ErrorDialog_NoSession;

    public static String DetailViewDialog_ErrorDialog_Title;

    public static String DetailViewDialog_ErrorMessage_NoSession;

    public static String DetailViewDialog_ErrorMessage_NotFound;

    public static String DetailViewDialog_ExceptionDialog_Message;
    static
    {
        // initialize resource bundle
        NLS.initializeMessages ( BUNDLE_NAME, Messages.class );
    }

    private Messages ()
    {
    }
}
