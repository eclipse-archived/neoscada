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

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.core.browser.FolderEntry;

public class FolderEntryCommon implements FolderEntry
{
    private final String name;

    private final Folder folder;

    private Map<String, Variant> attributes;

    public FolderEntryCommon ( final String name, final Folder folder, final Map<String, Variant> attributes )
    {
        this.name = name;
        this.folder = folder;
        this.attributes = attributes;
        if ( this.attributes == null )
        {
            this.attributes = Collections.emptyMap ();
        }
    }

    @Override
    public String getName ()
    {
        return this.name;
    }

    public Folder getFolder ()
    {
        return this.folder;
    }

    @Override
    public Map<String, Variant> getAttributes ()
    {
        return this.attributes;
    }
}
