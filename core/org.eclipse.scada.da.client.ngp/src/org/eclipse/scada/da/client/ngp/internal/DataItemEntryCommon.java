/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.ngp.internal;

import java.util.Map;
import java.util.Set;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.core.browser.DataItemEntry;
import org.eclipse.scada.da.data.IODirection;

public class DataItemEntryCommon extends EntryCommon implements DataItemEntry
{
    private final String id;

    private final Set<IODirection> directions;

    public DataItemEntryCommon ( final String name, final Set<IODirection> directions, final Map<String, Variant> attributes, final String id )
    {
        super ( name, attributes );
        this.directions = directions;
        this.id = id;
    }

    @Override
    public String getId ()
    {
        return this.id;
    }

    @Override
    public Set<IODirection> getIODirections ()
    {
        return this.directions;
    }
}