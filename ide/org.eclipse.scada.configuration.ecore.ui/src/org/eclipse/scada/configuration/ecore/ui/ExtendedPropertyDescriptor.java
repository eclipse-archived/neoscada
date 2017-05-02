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
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;

public class ExtendedPropertyDescriptor extends PropertyDescriptor implements ISortedPropertyDescriptor
{
    public ExtendedPropertyDescriptor ( final Object object, final IItemPropertyDescriptor itemPropertyDescriptor )
    {
        super ( object, itemPropertyDescriptor );
    }

    @Override
    public CellEditor createPropertyEditor ( final Composite composite )
    {
        if ( this.itemPropertyDescriptor instanceof IItemPropertyDescriptor2 )
        {
            final CellEditor editor = ( (IItemPropertyDescriptor2)this.itemPropertyDescriptor ).createPropertyEditor ( composite, this.object );
            if ( editor != null )
            {
                return editor;
            }
        }
        return super.createPropertyEditor ( composite );
    }

    @Override
    public int getSortKey ()
    {
        if ( this.itemPropertyDescriptor instanceof ISortedPropertyDescriptor )
        {
            return ( (ISortedPropertyDescriptor)this.itemPropertyDescriptor ).getSortKey ();
        }
        else
        {
            return 0;
        }
    }
}
