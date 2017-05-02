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

import java.util.List;

import org.eclipse.emf.common.ui.celleditor.ExtendedComboBoxCellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;

public abstract class TextComboBoxCellEditor extends ExtendedComboBoxCellEditor
{

    public TextComboBoxCellEditor ( final Composite composite, final List<?> list, final ILabelProvider labelProvider, final boolean sorted, final int style )
    {
        super ( composite, list, labelProvider, sorted, style );
    }

    public TextComboBoxCellEditor ( final Composite composite, final List<?> list, final ILabelProvider labelProvider, final boolean sorted )
    {
        super ( composite, list, labelProvider, sorted );
    }

    public TextComboBoxCellEditor ( final Composite composite, final List<?> list, final ILabelProvider labelProvider, final int style )
    {
        super ( composite, list, labelProvider, style );
    }

    public TextComboBoxCellEditor ( final Composite composite, final List<?> list, final ILabelProvider labelProvider )
    {
        super ( composite, list, labelProvider );
    }

    @Override
    public Object doGetValue ()
    {
        final int sel = ( (CCombo)getControl () ).getSelectionIndex ();
        if ( sel < 0 )
        {
            return ( (CCombo)getControl () ).getText ();
        }
        else
        {
            return toString ( this.list.get ( sel ) );
        }
    }

    protected abstract String toString ( Object object );

    @Override
    public void doSetValue ( Object value )
    {
        if ( value == null )
        {
            // clear selection
            ( (CCombo)getControl () ).select ( -1 );
            ( (CCombo)getControl () ).setText ( "" );
            return;
        }

        if ( value instanceof String )
        {
            value = fromString ( (String)value );
        }

        final int idx = this.list.indexOf ( value );
        if ( idx < 0 )
        {
            // not found
            ( (CCombo)getControl () ).setText ( value.toString () );
        }
        else
        {
            ( (CCombo)getControl () ).select ( idx );
        }
    }

    protected abstract Object fromString ( String value );
}