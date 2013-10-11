/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.ui.providers;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
    private static final String BUNDLE_NAME = "org.eclipse.scada.sec.ui.providers.messages"; //$NON-NLS-1$

    public static String KeySelectorDialog_ButtonUnlock_Text;

    public static String KeySelectorDialog_Callback_Description;

    public static String KeySelectorDialog_Callback_Title;

    public static String KeySelectorDialog_Error_Text;

    public static String KeySelectorDialog_Error_Title;

    public static String KeySelectorDialog_Remember_Text;

    public static String KeySelectorDialog_RememberLabel_Text_Forever;

    public static String KeySelectorDialog_RememberLabel_Text_Minute;

    public static String KeySelectorDialog_RememberLabel_Text_Minutes;
    static
    {
        // initialize resource bundle
        NLS.initializeMessages ( BUNDLE_NAME, Messages.class );
    }

    private Messages ()
    {
    }
}
