/*******************************************************************************
 * Copyright (c) 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.server.storage.hds;

import java.io.File;

import org.eclipse.scada.utils.lang.Immutable;

@Immutable
public class StorageInformation
{
    private final String id;

    private final File file;

    private final StorageConfiguration configuration;

    public StorageInformation ( final String id, final File file, final StorageConfiguration configuration )
    {
        this.id = id;
        this.file = file;
        this.configuration = configuration;
    }

    public File getFile ()
    {
        return this.file;
    }

    public String getId ()
    {
        return this.id;
    }

    public StorageConfiguration getConfiguration ()
    {
        return this.configuration;
    }
}
