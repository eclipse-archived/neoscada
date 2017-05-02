/*******************************************************************************
 * Copyright (c) 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.edit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.ui.celleditor.ExtendedComboBoxCellEditor;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.ecore.ui.ItemPropertyDescriptor2;
import org.eclipse.swt.widgets.Composite;

public final class ComponentHelper
{
    private ComponentHelper ()
    {
    }

    public static void addComponentProperty ( final List<IItemPropertyDescriptor> itemPropertyDescriptors, final AdapterFactory adapterFactory, final ResourceLocator resourceLocator, final String displayName, final String description, final EStructuralFeature feature )
    {
        itemPropertyDescriptors.add ( new ItemPropertyDescriptor2 ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), resourceLocator, displayName, description, feature, true, false, true, null, null, null) {

            @Override
            public CellEditor createPropertyEditor ( final Composite composite, final Object object )
            {
                return new ExtendedComboBoxCellEditor ( composite, new ArrayList<> ( getChoiceOfValues ( object ) ), new ComponentLabelProvider ( this.adapterFactory ), true );
            }

            @Override
            public Collection<?> getChoiceOfValues ( final Object object )
            {
                final EObject ref = (EObject)object;
                if ( ! ( ref.eContainer () instanceof DataComponent ) )
                {
                    return super.getChoiceOfValues ( object );
                }

                final Collection<Object> result = new HashSet<> ();
                final DataComponent container = (DataComponent)ref.eContainer ();
                for ( final Object o : super.getChoiceOfValues ( object ) )
                {
                    if ( o == container )
                    {
                        // remove self
                        continue;
                    }

                    if ( ! ( o instanceof DataComponent ) )
                    {
                        result.add ( o );
                        continue;
                    }
                    final DataComponent dc = (DataComponent)o;
                    if ( dc.getMasterOn ().containsAll ( container.getMasterOn () ) )
                    {
                        result.add ( dc );
                    }
                }
                return result;
            }
        } );
    }

}
