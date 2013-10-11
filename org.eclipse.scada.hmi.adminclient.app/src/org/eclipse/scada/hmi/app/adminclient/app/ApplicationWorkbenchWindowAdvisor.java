/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hmi.app.adminclient.app;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor
{

    public ApplicationWorkbenchWindowAdvisor ( final IWorkbenchWindowConfigurer configurer )
    {
        super ( configurer );
    }

    @Override
    public ActionBarAdvisor createActionBarAdvisor ( final IActionBarConfigurer configurer )
    {
        return new ApplicationActionBarAdvisor ( configurer );
    }

    @Override
    public void preWindowOpen ()
    {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer ();
        configurer.setInitialSize ( new Point ( 400 * 3, 300 * 3 ) );
        configurer.setShowFastViewBars ( false );
        configurer.setShowProgressIndicator ( true );
        configurer.setShowMenuBar ( true );
        configurer.setShowCoolBar ( true );
        configurer.setShowStatusLine ( true );
        configurer.setTitle ( "Eclipse SCADA Admin Client" );
    }
}
