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

public class ExtensionDescriptor
{
    private final IConfigurationElement element;

    public ExtensionDescriptor ( final IConfigurationElement element )
    {
        this.element = element;
    }

    public String getLocation ()
    {
        return this.element.getAttribute ( "location" );
    }

    public String getAlign ()
    {
        return this.element.getAttribute ( "align" );
    }

    public ViewerExtension createExtension () throws CoreException
    {
        final Object result = this.element.createExecutableExtension ( "class" );
        if ( result instanceof ViewerExtension )
        {
            return (ViewerExtension)result;
        }
        return null;
    }
}
