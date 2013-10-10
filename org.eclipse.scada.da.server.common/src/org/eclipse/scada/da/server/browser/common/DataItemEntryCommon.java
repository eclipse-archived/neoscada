/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.browser.common;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.core.DataItemInformation;
import org.eclipse.scada.da.core.browser.DataItemEntry;
import org.eclipse.scada.da.data.IODirection;

public class DataItemEntryCommon implements DataItemEntry
{

    private final String name;

    private final DataItemInformation itemInformation;

    private final Map<String, Variant> attributes;

    public DataItemEntryCommon ( final String name, final DataItemInformation itemInformation, final Map<String, Variant> attributes )
    {
        this.name = name;
        this.itemInformation = itemInformation;

        if ( attributes == null )
        {
            this.attributes = Collections.emptyMap ();
        }
        else
        {
            this.attributes = attributes;
        }
    }

    @Override
    public String getId ()
    {
        return this.itemInformation.getName ();
    }

    @Override
    public String getName ()
    {
        return this.name;
    }

    @Override
    public Map<String, Variant> getAttributes ()
    {
        return this.attributes;
    }

    @Override
    public Set<IODirection> getIODirections ()
    {
        return Collections.unmodifiableSet ( this.itemInformation.getIODirection () );
    }

}
