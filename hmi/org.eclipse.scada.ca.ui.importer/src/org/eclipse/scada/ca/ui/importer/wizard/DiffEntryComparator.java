/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.ui.importer.wizard;

import java.util.Comparator;

import org.eclipse.scada.ca.data.DiffEntry;

public class DiffEntryComparator implements Comparator<DiffEntry>
{
    @Override
    public int compare ( final DiffEntry o1, final DiffEntry o2 )
    {
        final int rc = o1.getFactoryId ().compareTo ( o2.getFactoryId () );
        if ( rc != 0 )
        {
            return rc;
        }
        return o1.getConfigurationId ().compareTo ( o2.getConfigurationId () );
    }
}