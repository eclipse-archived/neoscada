/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.lib.deployment;

import java.util.Comparator;
import java.util.Date;

import org.eclipse.scada.configuration.world.deployment.ChangeEntry;

public class ChangeEntryComparator implements Comparator<ChangeEntry>
{

    private final boolean invert;

    public ChangeEntryComparator ( final boolean invert )
    {
        this.invert = invert;
    }

    @Override
    public int compare ( final ChangeEntry o1, final ChangeEntry o2 )
    {
        final Date d1 = o1.getDate ();
        final Date d2 = o2.getDate ();
        if ( !this.invert )
        {
            return d1.compareTo ( d2 );
        }
        else
        {
            return -d1.compareTo ( d2 );
        }
    }
}