/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.dataitem.details.extra.part;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
    private static final String BUNDLE_NAME = "org.eclipse.scada.da.client.dataitem.details.extra.part.messages"; //$NON-NLS-1$

    public static String GenericLevelPresets_ErrorMessage_Dialog;

    public static String AbstractBaseDraw2DDetailsPart_Label_NotAvail_Text;

    public static String BooleanAlarmDetails_active;

    public static String BooleanAlarmDetails_trigger_alarm_if_value_is;

    public static String InputScaleDetails_Add;

    public static String InputScaleDetails_Multiply;

    public static String LevelPresets_EmtyNum;

    public static String LevelPresets_NumFormat;

    public static String ManualOverride_LocalManualValue_Label;

    public static String ManualOverride_None;

    public static String ManualOverride_ProcessValue_Label;

    public static String ManualOverride_RemoteManualvalue_Label;

    public static String ManualOverride_RemoteProcessValue_Label;

    public static String ManualOverride_ResetValue_Label;

    public static String VariantEntryDialog_Dialog_Message;

    public static String VariantEntryDialog_Dialog_Title;

    public static String VariantEntryDialog_ErrorMessage;

    public static String VariantEntryDialog_NoConverter;

    public static String VariantEntryDialog_NoValue;

    public static String VariantEntryDialog_Text_Value;

    public static String VariantEntryDialog_Type_Label;

    public static String VariantEntryDialog_Value_Label;
    static
    {
        // initialize resource bundle
        NLS.initializeMessages ( BUNDLE_NAME, Messages.class );
    }

    private Messages ()
    {
    }
}
