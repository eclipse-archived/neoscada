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

import org.eclipse.ui.views.properties.IPropertySheetEntry;
import org.eclipse.ui.views.properties.PropertySheetSorter;

public class ExtendedPropertiesSheetSorter extends PropertySheetSorter
{
    @Override
    public int compare ( final IPropertySheetEntry entryA, final IPropertySheetEntry entryB )
    {
        final int sortKeyA = getSortKey ( entryA );
        final int sortKeyB = getSortKey ( entryB );

        final int result = Integer.compare ( sortKeyA, sortKeyB );
        if ( result == 0 )
        {
            return super.compare ( entryA, entryB );
        }
        else
        {
            return result;
        }
    }

    private int getSortKey ( final IPropertySheetEntry entry )
    {
        if ( entry instanceof ISortedPropertyDescriptor )
        {
            return ( (ISortedPropertyDescriptor)entry ).getSortKey ();
        }
        else
        {
            return 0;
        }
    }
}
