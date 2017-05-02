/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.ecore.ui;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

public class ExtendedPropertySource extends PropertySource
{
    public ExtendedPropertySource ( final Object object, final IItemPropertySource itemPropertySource )
    {
        super ( object, itemPropertySource );
    }

    @Override
    protected IPropertyDescriptor createPropertyDescriptor ( final IItemPropertyDescriptor itemPropertyDescriptor )
    {
        return new ExtendedPropertyDescriptor ( this.object, itemPropertyDescriptor );
    }
}