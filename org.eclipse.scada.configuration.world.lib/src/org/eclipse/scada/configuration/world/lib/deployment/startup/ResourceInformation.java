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
package org.eclipse.scada.configuration.world.lib.deployment.startup;

public class ResourceInformation
{
    private final String targetFilename;

    private final Type type;

    public static enum Type
    {
        FILE,
        EXECUTABLE,
        DIRECTORY;
    }

    public ResourceInformation ( final String targetFilename, final Type type )
    {
        this.targetFilename = targetFilename;
        this.type = type;
    }

    public Type getType ()
    {
        return this.type;
    }

    public String getTargetFilename ()
    {
        return this.targetFilename;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.targetFilename == null ? 0 : this.targetFilename.hashCode () );
        return result;
    }

    @Override
    public boolean equals ( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( getClass () != obj.getClass () )
        {
            return false;
        }
        final ResourceInformation other = (ResourceInformation)obj;
        if ( this.targetFilename == null )
        {
            if ( other.targetFilename != null )
            {
                return false;
            }
        }
        else if ( !this.targetFilename.equals ( other.targetFilename ) )
        {
            return false;
        }
        return true;
    }

}
