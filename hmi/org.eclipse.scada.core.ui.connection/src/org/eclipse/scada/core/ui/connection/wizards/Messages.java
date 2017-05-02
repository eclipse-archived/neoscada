/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.wizards;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
    private static final String BUNDLE_NAME = "org.eclipse.scada.core.ui.connection.wizards.messages"; //$NON-NLS-1$

    public static String AddConnectionWizardPage1_ConnectionIdLabel;

    public static String AddConnectionWizardPage1_ConnectionIdMessage;

    public static String AddConnectionWizardPage1_ConnectionUriLabel;

    public static String AddConnectionWizardPage1_ConnectionUriMessage;

    public static String AddConnectionWizardPage1_InformationMessage;

    public static String AddConnectionWizardPage1_PageDescription;

    public static String AddConnectionWizardPage1_PageTitle;
    static
    {
        // initialize resource bundle
        NLS.initializeMessages ( BUNDLE_NAME, Messages.class );
    }

    private Messages ()
    {
    }
}
