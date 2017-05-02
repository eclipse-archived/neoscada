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

import java.util.Hashtable;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.scada.vi.ui.user.viewer.ViewManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

public class SeparatorExtension implements ViewerExtension, IExecutableExtension
{

    private boolean visibile = true;

    @Override
    public Control create ( final Composite parent, final ViewManager viewManager, final boolean horizontal )
    {
        return new Label ( parent, this.visibile ? SWT.SEPARATOR : SWT.NONE );
    }

    @Override
    public void setInitializationData ( final IConfigurationElement config, final String propertyName, final Object data ) throws CoreException
    {
        if ( data instanceof Hashtable<?, ?> )
        {
            this.visibile = ! ( (Hashtable<?, ?>)data ).containsKey ( "invisible" );
        }
    }

}
