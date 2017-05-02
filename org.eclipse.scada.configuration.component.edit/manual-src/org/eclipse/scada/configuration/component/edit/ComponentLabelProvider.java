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
package org.eclipse.scada.configuration.component.edit;

import java.util.LinkedList;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.scada.configuration.component.Level;
import org.eclipse.scada.utils.str.StringHelper;
import org.eclipse.swt.graphics.Image;

public class ComponentLabelProvider extends LabelProvider
{
    private final AdapterFactory adapterFactory;

    public ComponentLabelProvider ( final AdapterFactory adapterFactory )
    {
        this.adapterFactory = adapterFactory;
    }

    @Override
    public Image getImage ( final Object element )
    {
        final IItemLabelProvider labelProvider = (IItemLabelProvider)this.adapterFactory.adapt ( element, IItemLabelProvider.class );
        if ( labelProvider != null )
        {
            return ExtendedImageRegistry.getInstance ().getImage ( labelProvider.getImage ( element ) );
        }
        else
        {
            return super.getImage ( element );
        }
    }

    @Override
    public String getText ( final Object element )
    {
        final IItemLabelProvider labelProvider = (IItemLabelProvider)this.adapterFactory.adapt ( element, IItemLabelProvider.class );
        if ( labelProvider != null )
        {
            final String label = labelProvider.getText ( element );
            final String parents = makeParents ( element );
            if ( parents != null && !parents.isEmpty () )
            {
                return label + " - " + parents;
            }
            else
            {
                return label;
            }

        }
        else
        {
            return super.getText ( element );
        }
    }

    private String makeParents ( final Object element )
    {
        if ( ! ( element instanceof EObject ) )
        {
            return null;
        }

        final LinkedList<String> hierarchy = new LinkedList<> ();

        EObject current = ( (EObject)element ).eContainer ();
        while ( current instanceof Level )
        {
            hierarchy.add ( 0, ( (Level)current ).getName () );

            current = current.eContainer ();
        }

        return StringHelper.join ( hierarchy, "." );
    }
}
