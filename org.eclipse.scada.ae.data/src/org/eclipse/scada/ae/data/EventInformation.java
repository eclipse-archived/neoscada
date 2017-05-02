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
package org.eclipse.scada.ae.data;

public class EventInformation implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public EventInformation ( final String id, final long sourceTimestamp, final long entryTimestamp, final java.util.Map<String, org.eclipse.scada.core.Variant> attributes )
    {
        this.id = id;
        this.sourceTimestamp = sourceTimestamp;
        this.entryTimestamp = entryTimestamp;
        this.attributes = attributes;
    }

    private final String id;

    public String getId ()
    {
        return this.id;
    }

    private final long sourceTimestamp;

    public long getSourceTimestamp ()
    {
        return this.sourceTimestamp;
    }

    private final long entryTimestamp;

    public long getEntryTimestamp ()
    {
        return this.entryTimestamp;
    }

    private final java.util.Map<String, org.eclipse.scada.core.Variant> attributes;

    public java.util.Map<String, org.eclipse.scada.core.Variant> getAttributes ()
    {
        return this.attributes;
    }

    @Override
    public String toString ()
    {
        return "[EventInformation - " + "id: " + this.id + ", " + "sourceTimestamp: " + this.sourceTimestamp + ", " + "entryTimestamp: " + this.entryTimestamp + ", " + "attributes: " + this.attributes + "]";
    }
}
