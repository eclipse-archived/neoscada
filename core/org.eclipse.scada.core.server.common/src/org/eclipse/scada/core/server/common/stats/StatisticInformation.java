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
package org.eclipse.scada.core.server.common.stats;

import java.beans.ConstructorProperties;

public class StatisticInformation
{
    private final String label;

    private final Double current;

    private final Double minimum;

    private final Double maximum;

    @ConstructorProperties ( { "label", "current", "minimum", "maximum" } )
    public StatisticInformation ( final String label, final Double current, final Double minimum, final Double maximum )
    {
        super ();
        this.label = label;
        this.current = current;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public String getLabel ()
    {
        return this.label;
    }

    public Double getCurrent ()
    {
        return this.current;
    }

    public Double getMinimum ()
    {
        return this.minimum;
    }

    public Double getMaximum ()
    {
        return this.maximum;
    }

}
