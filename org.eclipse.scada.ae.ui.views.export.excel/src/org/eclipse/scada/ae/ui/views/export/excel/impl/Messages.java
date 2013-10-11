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
package org.eclipse.scada.ae.ui.views.export.excel.impl;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
    private static final String BUNDLE_NAME = "org.eclipse.scada.ae.ui.views.export.excel.impl.messages"; //$NON-NLS-1$

    public static String ExportImpl_ErrorMessage_FailedToDeleteFile;

    public static String ExportImpl_ErrorMessage_FailedToExport;

    public static String ExportImpl_ErrorMessage_NoEventsSelected;

    public static String ExportImpl_ErrorMessage_NoFileSelected;

    public static String ExportImpl_ExcelSheet_Footer_1;

    public static String ExportImpl_ExcelSheet_Footer_2;

    public static String ExportImpl_ExcelSheet_Footer_3;

    public static String ExportImpl_ExcelSheet_Header;

    public static String ExportImpl_ExcelSheet_Name;

    public static String ExportImpl_Progress_CloseFile;

    public static String ExportImpl_Progress_CreateWorkbook;

    public static String ExportImpl_Progress_ExportEvents;

    public static String ExportImpl_Progress_ExportingEvents;
    static
    {
        // initialize resource bundle
        NLS.initializeMessages ( BUNDLE_NAME, Messages.class );
    }

    private Messages ()
    {
    }
}
