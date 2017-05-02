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
package org.eclipse.scada.build.helper;

public class PomId
{
    private final String groupId;

    private final String artifactId;

    public PomId ( final String groupId, final String artifactId )
    {
        this.groupId = groupId;
        this.artifactId = artifactId;
    }

    public String getArtifactId ()
    {
        return this.artifactId;
    }

    public String getGroupId ()
    {
        return this.groupId;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.artifactId == null ? 0 : this.artifactId.hashCode () );
        result = prime * result + ( this.groupId == null ? 0 : this.groupId.hashCode () );
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
        final PomId other = (PomId)obj;
        if ( this.artifactId == null )
        {
            if ( other.artifactId != null )
            {
                return false;
            }
        }
        else if ( !this.artifactId.equals ( other.artifactId ) )
        {
            return false;
        }
        if ( this.groupId == null )
        {
            if ( other.groupId != null )
            {
                return false;
            }
        }
        else if ( !this.groupId.equals ( other.groupId ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString ()
    {
        return this.groupId + ":" + this.artifactId;
    }

}
