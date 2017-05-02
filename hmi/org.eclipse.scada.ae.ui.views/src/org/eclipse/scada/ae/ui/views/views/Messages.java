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
package org.eclipse.scada.ae.ui.views.views;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
    private static final String BUNDLE_NAME = "org.eclipse.scada.ae.ui.views.views.messages"; //$NON-NLS-1$

    public static String AbstractAlarmsEventsView_IllegalArgument_changedConnection;

    public static String AbstractAlarmsEventsView_IllegalArgument_changedConnection_Type;

    public static String AbstractAlarmsEventsView_Label_Format_Connected;

    public static String AbstractAlarmsEventsView_Label_Format_Disconnected;

    public static String AbstractAlarmsEventsView_Label_Format_NoConnection;

    public static String AbstractAlarmsEventsView_Label_Format_NoConnection_String;

    public static String AbstractAlarmsEventsView_SetCommentAction_Description;

    public static String AbstractAlarmsEventsView_SetCommentAction_Text;

    public static String AbstractAlarmsEventsView_SetCommentAction_ToolTip;

    public static String EventHistoryView_Action_Clear_Text;

    public static String EventHistoryView_Action_Clear_ToolTip;

    public static String EventHistoryView_Action_Resume_Text;

    public static String EventHistoryView_Action_Resume_ToolTop;

    public static String EventHistoryView_Action_Search_Text;

    public static String EventHistoryView_Action_Search_ToolTip;

    public static String EventHistoryView_Label_Format_CountEvents;

    public static String EventHistoryView_Label_Format_Filter;

    public static String EventHistoryView_Label_Format_IsLoading;

    public static String EventHistoryView_Sep;

    // public static String EventLabelProvider_EmptyString;

    // public static String EventLabelProvider_Error;

    public static String EventPoolView_Action_Filter_Name;

    public static String EventPoolView_Action_Filter_ToolTip;

    public static String EventPoolView_Action_RemoveFilter_Name;

    public static String EventPoolView_Action_RemoveFilter_ToolTip;

    public static String EventPoolView_Action_ScrollLock_Name;

    public static String EventPoolView_Action_ScrollLock_ToolTip;

    public static String EventPoolView_Label_Format_CountEvents;

    public static String EventPoolView_Label_Format_Filter;

    public static String EventPoolView_Label_Format_Monitors;

    public static String EventPoolView_Label_Format_NoMonitors;

    public static String EventPoolView_Label_Format_NoPool;

    public static String EventPoolView_Label_Format_Pool;

    public static String EventPoolView_Sep;

    public static String EventPoolView_Status_Error_RemoveElement;

    public static String LabelProviderSupport_DateTimeFormat;

    public static String LabelProviderSupport_Format_NF3;

    public static String LabelProviderSupport_Format_NF6;

    public static String LabelProviderSupport_SpecialFormat_Today;

    public static String LabelProviderSupport_SpecialFormat_Yesterday;

    public static String LabelProviderSupport_TimeFormat;

    public static String MonitorsView_Label_Format_CountMonitors;

    public static String MonitorsView_Label_Format_Monitors;

    public static String MonitorsView_Label_Format_NoMonitors;

    public static String MonitorsView_Sep;

    public static String MonitorTableLabelProvider_EmptyString;
    static
    {
        // initialize resource bundle
        NLS.initializeMessages ( BUNDLE_NAME, Messages.class );
    }

    private Messages ()
    {
    }
}
