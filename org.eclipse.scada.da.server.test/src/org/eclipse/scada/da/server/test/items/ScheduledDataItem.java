/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
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
import java.util.TimerTask;

import org.eclipse.scada.da.server.common.DataItemInputCommon;

public abstract class ScheduledDataItem extends DataItemInputCommon implements Runnable
{
    private final Timer timer;

    public ScheduledDataItem ( final String name, final Timer timer, final int period )
    {
        super ( name );
        this.timer = timer;
        this.timer.scheduleAtFixedRate ( new TimerTask () {

            @Override
            public void run ()
            {
                ScheduledDataItem.this.run ();
            }
        }, 0, period );
    }
}
