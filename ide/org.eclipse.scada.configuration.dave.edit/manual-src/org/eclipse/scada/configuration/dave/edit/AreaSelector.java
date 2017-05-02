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
package org.eclipse.scada.configuration.dave.edit;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.scada.configuration.ecore.ui.TextComboBoxCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class AreaSelector extends TextComboBoxCellEditor
{
    public AreaSelector ( final Composite composite )
    {
        super ( composite, makeAreaList (), new LabelProvider () {
            @Override
            public String getText ( final Object element )
            {
                return String.format ( "%1$d (0x%1$02X)", (Number)element );
            }
        }, true, SWT.NONE );
    }

    protected static List<Integer> makeAreaList ()
    {
        return Arrays.asList ( 0x81, 0x82, 0x83, 0x84, 0x85, 0x86, 0x87, 0x1C, 0x1D );
    }

    @Override
    protected String toString ( final Object object )
    {
        return "" + object;
    }

    @Override
    protected Object fromString ( final String value )
    {
        return Integer.parseInt ( value );
    }

    @Override
    public Object doGetValue ()
    {
        return Integer.parseInt ( (String)super.doGetValue () );
    }

    @Override
    public void doSetValue ( final Object value )
    {
        super.doSetValue ( "" + value );
    }
}
