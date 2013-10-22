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
package org.eclipse.scada.da.server.ui.launcher;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public class DriverTabGroup extends AbstractLaunchConfigurationTabGroup
{

    public DriverTabGroup ()
    {
    }

    @Override
    public void createTabs ( final ILaunchConfigurationDialog dialog, final String mode )
    {
        ILaunchConfigurationTab[] tabs;
        tabs = new ILaunchConfigurationTab[] { new HiveTab () };
        setTabs ( tabs );
    }

}
