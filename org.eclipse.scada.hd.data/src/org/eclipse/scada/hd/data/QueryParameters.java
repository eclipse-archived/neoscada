/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.hd.data;

public class QueryParameters implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public QueryParameters ( final long startTimestamp, final long endTimestamp, final int numberOfEntries )
    {
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
        this.numberOfEntries = numberOfEntries;
    }

    private final long startTimestamp;

    public long getStartTimestamp ()
    {
        return this.startTimestamp;
    }

    private final long endTimestamp;

    public long getEndTimestamp ()
    {
        return this.endTimestamp;
    }

    private final int numberOfEntries;

    public int getNumberOfEntries ()
    {
        return this.numberOfEntries;
    }

    @Override
    public String toString ()
    {
        return "[QueryParameters - " + "startTimestamp: " + this.startTimestamp + ", " + "endTimestamp: " + this.endTimestamp + ", " + "numberOfEntries: " + this.numberOfEntries + "]";
    }
}
