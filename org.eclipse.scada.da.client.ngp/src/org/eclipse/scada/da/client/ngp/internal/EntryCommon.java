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

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.core.browser.Entry;

public class EntryCommon implements Entry
{
    private final String name;

    private final Map<String, Variant> attributes;

    public EntryCommon ( final String name, final Map<String, Variant> attributes )
    {
        this.name = name;
        this.attributes = attributes;
    }

    @Override
    public Map<String, Variant> getAttributes ()
    {
        return this.attributes;
    }

    @Override
    public String getName ()
    {
        return this.name;
    }

}
