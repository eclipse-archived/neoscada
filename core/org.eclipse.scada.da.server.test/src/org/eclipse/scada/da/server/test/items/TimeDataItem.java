/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.test.items;

import java.util.Timer;

import org.eclipse.scada.core.Variant;

public class TimeDataItem extends ScheduledDataItem
{

    public TimeDataItem ( final String name, final Timer timer )
    {
        super ( name, timer, 1000 );
    }

    @Override
    public void run ()
    {
        updateData ( Variant.valueOf ( System.currentTimeMillis () ), null, null );
    }
}
