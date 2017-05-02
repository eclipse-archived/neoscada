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
package org.eclipse.scada.core.ui.connection.login.dialog;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
    private static final String BUNDLE_NAME = "org.eclipse.scada.core.ui.connection.login.dialog.messages"; //$NON-NLS-1$

    public static String ConnectionAnalyzer_Column_Text_Error;

    public static String ConnectionAnalyzer_Column_Text_State;

    public static String ConnectionAnalyzer_Column_Text_Uri;

    public static String ConnectionAnalyzer_Error_BadCredentials;

    public static String ConnectionAnalyzer_Error_ConnectException;

    public static String ContextCreator_ErrorConnectionService;

    public static String LoginDialog_AdvancedButton_Text;

    public static String LoginDialog_CredentialsButtons_Text;

    public static String LoginDialog_CredentialsButtons_ToolTip;

    public static String LoginDialog_DefaultMessage;

    public static String LoginDialog_Dlg_Title;

    public static String LoginDialog_Error_NoLoginContext;

    public static String LoginDialog_Label_Context_Text;

    public static String LoginDialog_Label_Password_Text;

    public static String LoginDialog_Label_User_Text;

    public static String LoginDialog_Message_EmptyPassword;

    public static String LoginDialog_Message_EmptyUsername;

    public static String LoginDialog_Shell_Text;

    public static String LoginDialog_Text_Password_Message;

    public static String LoginDialog_Text_User_Message;
    static
    {
        // initialize resource bundle
        NLS.initializeMessages ( BUNDLE_NAME, Messages.class );
    }

    private Messages ()
    {
    }
}
