/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.user.viewer.ext;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.scada.vi.ui.user.navigation.breadcrumb.BreadcrumbNavigator;
import org.eclipse.scada.vi.ui.user.viewer.ViewManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BreadcrumbNavigatorExtension implements ViewerExtension, IExecutableExtension
{

    private final static Logger logger = LoggerFactory.getLogger ( BreadcrumbNavigatorExtension.class );

    @Override
    public Control create ( final Composite parent, final ViewManager viewManager, final boolean horizontal )
    {
        logger.debug ( "Creating breadcrumb extension" );
        return new BreadcrumbNavigator ( parent, viewManager, horizontal ? SWT.HORIZONTAL : SWT.VERTICAL ).getControl ();
    }

    @Override
    public void setInitializationData ( final IConfigurationElement config, final String propertyName, final Object data ) throws CoreException
    {

    }

}
