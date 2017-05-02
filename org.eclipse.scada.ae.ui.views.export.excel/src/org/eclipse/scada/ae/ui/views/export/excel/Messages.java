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
package org.eclipse.scada.ae.ui.views.export.excel;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
    private static final String BUNDLE_NAME = "org.eclipse.scada.ae.ui.views.export.excel.messages"; //$NON-NLS-1$

    public static String ExportWizard_ErrorMessage;

    public static String ExportWizard_WindowTitle;
    public static String FileSelectionPage_Button_Browse;

    public static String FileSelectionPage_Description;

    public static String FileSelectionPage_FileDialog_Text;

    public static String FileSelectionPage_FilterExtension;

    public static String FileSelectionPage_FilterName;

    public static String FileSelectionPage_Label_OutputFile;

    public static String FileSelectionPage_Message_NoFileSelected;

    public static String FileSelectionPage_Message_Ok;

    public static String FileSelectionPage_Title;
    static
    {
        // initialize resource bundle
        NLS.initializeMessages ( BUNDLE_NAME, Messages.class );
    }

    private Messages ()
    {
    }
}
