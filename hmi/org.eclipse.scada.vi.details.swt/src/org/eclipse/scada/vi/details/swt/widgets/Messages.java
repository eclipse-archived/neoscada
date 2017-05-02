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
package org.eclipse.scada.vi.details.swt.widgets;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
    private static final String BUNDLE_NAME = "org.eclipse.scada.vi.details.swt.widgets.messages"; //$NON-NLS-1$

    public static String TrendControlImage_TrendError;

    public static String BlockControllerImage_ConfirmDialog_Message_Format;

    public static String BlockControllerImage_ConfirmDialog_Title;

    public static String BlockControllerImage_String_Timestamp;

    public static String BlockControllerImage_String_BlockedBy;

    public static String BlockControllerImage_String_BlockNote_None;

    public static String BlockControllerImage_String_None;

    public static String BlockControllerImage_String_Reason;

    public static String BlockControllerImage_String_Unknown;

    public static String TextInputMultiComposite_clear;

    public static String TextInputMultiComposite_send;

    public static String ValueSetComposite_reset;

    public static String ValueSetComposite_resetDescriptor;

    public static String ValueSetComposite_set;

    public static String ValueSetComposite_setDescriptor;

    public static String ValueSetComposite_valueDescriptor;

    public static String WriteableComposite_invalidInput;

    public static String WriteableComposite_requiredInput;

    public static String WriteableComposite_wrongInput;

    static
    {
        // initialize resource bundle
        NLS.initializeMessages ( BUNDLE_NAME, Messages.class );
    }

    private Messages ()
    {
    }
}
