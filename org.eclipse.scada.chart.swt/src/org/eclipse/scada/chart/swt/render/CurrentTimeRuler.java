/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - enhancements
 *******************************************************************************/
package org.eclipse.scada.chart.swt.render;

import org.eclipse.scada.chart.XAxis;

public class CurrentTimeRuler extends AbstractPositionXRuler
{

    public CurrentTimeRuler ( final XAxis axis )
    {
        super ( axis );
    }

    @Override
    public Long getPosition ()
    {
        return System.currentTimeMillis ();
    }

    /**
     * Check if the time rule is in the visible chart area
     * 
     * @return <code>true</code> if the time ruler is in the currently visible
     *         chart area, <code>false</code> otherwise
     */
    public boolean showingCurrentTime ()
    {
        final long min = this.axis.getMin ();
        final long max = this.axis.getMax ();
        final long now = System.currentTimeMillis ();

        return now > min && now < max;
    }

}
