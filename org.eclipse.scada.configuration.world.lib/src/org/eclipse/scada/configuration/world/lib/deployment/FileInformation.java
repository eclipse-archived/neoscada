/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.lib.deployment;

public class FileInformation
{
    private final Integer mode;

    private final String owner;

    private final String group;

    private final FileOptions[] options;

    public FileInformation ( final Integer mode, final String owner, final String group, final FileOptions... options )
    {
        this.mode = mode;
        this.owner = owner;
        this.group = group;
        this.options = options;
    }

    public FileInformation ()
    {
        this ( null, null, null );
    }

    public FileInformation ( final int mode )
    {
        this ( mode, null, null );
    }

    public String getGroup ()
    {
        return this.group;
    }

    public Integer getMode ()
    {
        return this.mode;
    }

    public FileOptions[] getOptions ()
    {
        return this.options;
    }

    public String getOwner ()
    {
        return this.owner;
    }
}
