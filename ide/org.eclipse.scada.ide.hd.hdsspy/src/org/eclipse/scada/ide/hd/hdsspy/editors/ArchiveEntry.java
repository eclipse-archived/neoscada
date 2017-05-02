/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ide.hd.hdsspy.editors;

import java.util.Date;

public class ArchiveEntry
{
    public static final String PROP_TIMESTAMP = "timestamp";

    public static final String PROP_VALUE = "value";

    public static final String PROP_MANUAL = "manual";

    public static final String PROP_ERROR = "error";

    public static final String PROP_DELETED = "deleted";

    public static final String PROP_HEARTBEAT = "heartbeat";

    private final Date timestamp;

    private final double value;

    private final boolean error;

    private final boolean manual;

    private final boolean deleted;

    private final boolean heartbeat;

    public ArchiveEntry ( final Date timestamp, final double value, final boolean error, final boolean manual, final boolean deleted, final boolean heartbeat )
    {
        this.timestamp = timestamp;
        this.value = value;
        this.error = error;
        this.manual = manual;
        this.deleted = deleted;
        this.heartbeat = heartbeat;
    }

    public boolean isDeleted ()
    {
        return this.deleted;
    }

    public boolean isHeartbeat ()
    {
        return this.heartbeat;
    }

    public boolean isError ()
    {
        return this.error;
    }

    public boolean isManual ()
    {
        return this.manual;
    }

    public Date getTimestamp ()
    {
        return this.timestamp;
    }

    public double getValue ()
    {
        return this.value;
    }
}
