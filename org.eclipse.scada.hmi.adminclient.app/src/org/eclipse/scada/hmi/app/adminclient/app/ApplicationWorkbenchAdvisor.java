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

import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor
{

    private static final String PERSPECTIVE_ID = "org.eclipse.scada.hmi.app.adminclient.app.perspective"; //$NON-NLS-1$

    @Override
    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor ( final IWorkbenchWindowConfigurer configurer )
    {
        return new ApplicationWorkbenchWindowAdvisor ( configurer );
    }

    @Override
    public void initialize ( final IWorkbenchConfigurer configurer )
    {
        super.initialize ( configurer );
        configurer.setSaveAndRestore ( true );
    }

    @Override
    public String getInitialWindowPerspectiveId ()
    {
        return PERSPECTIVE_ID;
    }
}
