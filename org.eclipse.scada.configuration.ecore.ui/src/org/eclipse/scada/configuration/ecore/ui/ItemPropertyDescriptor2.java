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
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

public class ItemPropertyDescriptor2 extends ItemPropertyDescriptor implements IItemPropertyDescriptor2
{

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final ResourceLocator resourceLocator, final String displayName, final String description, final EReference[] parentReferences, final boolean isSettable, final String category, final String[] filterFlags )
    {
        super ( adapterFactory, resourceLocator, displayName, description, parentReferences, isSettable, category, filterFlags );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final ResourceLocator resourceLocator, final String displayName, final String description, final EReference[] parentReferences, final boolean isSettable, final String category )
    {
        super ( adapterFactory, resourceLocator, displayName, description, parentReferences, isSettable, category );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final ResourceLocator resourceLocator, final String displayName, final String description, final EReference[] parentReferences, final boolean isSettable )
    {
        super ( adapterFactory, resourceLocator, displayName, description, parentReferences, isSettable );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final ResourceLocator resourceLocator, final String displayName, final String description, final EReference[] parentReferences )
    {
        super ( adapterFactory, resourceLocator, displayName, description, parentReferences );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final ResourceLocator resourceLocator, final String displayName, final String description, final EStructuralFeature feature, final boolean isSettable, final boolean multiLine, final boolean sortChoices, final Object staticImage, final String category, final String[] filterFlags )
    {
        super ( adapterFactory, resourceLocator, displayName, description, feature, isSettable, multiLine, sortChoices, staticImage, category, filterFlags );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final ResourceLocator resourceLocator, final String displayName, final String description, final EStructuralFeature feature, final boolean isSettable, final Object staticImage, final String category, final String[] filterFlags )
    {
        super ( adapterFactory, resourceLocator, displayName, description, feature, isSettable, staticImage, category, filterFlags );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final ResourceLocator resourceLocator, final String displayName, final String description, final EStructuralFeature feature, final boolean isSettable, final Object staticImage, final String category )
    {
        super ( adapterFactory, resourceLocator, displayName, description, feature, isSettable, staticImage, category );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final ResourceLocator resourceLocator, final String displayName, final String description, final EStructuralFeature feature, final boolean isSettable, final Object staticImage )
    {
        super ( adapterFactory, resourceLocator, displayName, description, feature, isSettable, staticImage );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final ResourceLocator resourceLocator, final String displayName, final String description, final EStructuralFeature feature, final boolean isSettable, final String category, final String[] filterFlags )
    {
        super ( adapterFactory, resourceLocator, displayName, description, feature, isSettable, category, filterFlags );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final ResourceLocator resourceLocator, final String displayName, final String description, final EStructuralFeature feature, final boolean isSettable, final String category )
    {
        super ( adapterFactory, resourceLocator, displayName, description, feature, isSettable, category );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final ResourceLocator resourceLocator, final String displayName, final String description, final EStructuralFeature feature, final boolean isSettable )
    {
        super ( adapterFactory, resourceLocator, displayName, description, feature, isSettable );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final ResourceLocator resourceLocator, final String displayName, final String description, final EStructuralFeature feature )
    {
        super ( adapterFactory, resourceLocator, displayName, description, feature );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final String displayName, final String description, final EReference[] parentReferences, final boolean isSettable, final String category, final String[] filterFlags )
    {
        super ( adapterFactory, displayName, description, parentReferences, isSettable, category, filterFlags );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final String displayName, final String description, final EReference[] parentReferences, final boolean isSettable, final String category )
    {
        super ( adapterFactory, displayName, description, parentReferences, isSettable, category );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final String displayName, final String description, final EReference[] parentReferences, final boolean isSettable )
    {
        super ( adapterFactory, displayName, description, parentReferences, isSettable );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final String displayName, final String description, final EReference[] parentReferences )
    {
        super ( adapterFactory, displayName, description, parentReferences );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final String displayName, final String description, final EStructuralFeature feature, final boolean isSettable, final Object staticImage, final String category, final String[] filterFlags )
    {
        super ( adapterFactory, displayName, description, feature, isSettable, staticImage, category, filterFlags );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final String displayName, final String description, final EStructuralFeature feature, final boolean isSettable, final Object staticImage, final String category )
    {
        super ( adapterFactory, displayName, description, feature, isSettable, staticImage, category );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final String displayName, final String description, final EStructuralFeature feature, final boolean isSettable, final Object staticImage )
    {
        super ( adapterFactory, displayName, description, feature, isSettable, staticImage );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final String displayName, final String description, final EStructuralFeature feature, final boolean isSettable, final String category, final String[] filterFlags )
    {
        super ( adapterFactory, displayName, description, feature, isSettable, category, filterFlags );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final String displayName, final String description, final EStructuralFeature feature, final boolean isSettable, final String category )
    {
        super ( adapterFactory, displayName, description, feature, isSettable, category );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final String displayName, final String description, final EStructuralFeature feature, final boolean isSettable )
    {
        super ( adapterFactory, displayName, description, feature, isSettable );
    }

    public ItemPropertyDescriptor2 ( final AdapterFactory adapterFactory, final String displayName, final String description, final EStructuralFeature feature )
    {
        super ( adapterFactory, displayName, description, feature );
    }

    @Override
    public CellEditor createPropertyEditor ( final Composite composite, final Object object )
    {
        return null;
    }

    public ILabelProvider createLabelProvider ( final Object object )
    {
        final IItemLabelProvider itemLabelProvider = getLabelProvider ( object );
        return new LabelProvider () {
            @Override
            public String getText ( final Object object )
            {
                return itemLabelProvider.getText ( object );
            }

            @Override
            public Image getImage ( final Object object )
            {
                return ExtendedImageRegistry.getInstance ().getImage ( itemLabelProvider.getImage ( object ) );
            }
        };
    }
}
