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

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.ui.views.properties.IPropertySource;

public class ExtendedAdapterFactoryContentProvider extends AdapterFactoryContentProvider
{

    public ExtendedAdapterFactoryContentProvider ( final AdapterFactory adapterFactory )
    {
        super ( adapterFactory );
    }

    @Override
    public IPropertySource getPropertySource ( final Object object )
    {
        // this one has priority in super class
        if ( object instanceof IPropertySource )
        {
            return (IPropertySource)object;
        }

        // allow the object to adapt to IPropertySource
        if ( object instanceof EObject && ( (EObject)object ).eClass () != null )
        {
            final IPropertySource propertySource = (IPropertySource)this.adapterFactory.adapt ( object, IPropertySource.class );
            if ( propertySource != null )
            {
                return propertySource;
            }
        }

        // fall back to default behavior
        return super.getPropertySource ( object );
    }

    @Override
    protected IPropertySource createPropertySource ( final Object object, final IItemPropertySource itemPropertySource )
    {
        return new ExtendedPropertySource ( object, itemPropertySource );
    }
}
