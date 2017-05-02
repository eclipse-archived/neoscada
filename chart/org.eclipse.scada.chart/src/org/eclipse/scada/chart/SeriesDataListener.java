/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.chart;

public interface SeriesDataListener
{
    /**
     * A data update has occurred in the provided timestamp
     * 
     * @param startTimestamp
     *            the start timestamp of the update
     * @param endTimestamp
     *            the end timestamp of the update
     */
    public void dataUpdate ( long startTimestamp, long endTimestamp );
}
