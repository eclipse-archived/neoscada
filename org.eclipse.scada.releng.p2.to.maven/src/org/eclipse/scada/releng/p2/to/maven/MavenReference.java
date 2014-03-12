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
package org.eclipse.scada.releng.p2.to.maven;

public class MavenReference
{
    private String groupId;

    private String artifactId;

    private String version;

    private String classifier;

    public MavenReference ( final String groupId, final String artifactId, final String version )
    {
        this ( groupId, artifactId, version, null );
    }

    public MavenReference ( final String groupId, final String artifactId, final String version, final String classifier )
    {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.classifier = classifier;
    }

    public MavenReference ()
    {
    }

    public String getGroupId ()
    {
        return this.groupId;
    }

    public void setGroupId ( final String groupId )
    {
        this.groupId = groupId;
    }

    public String getArtifactId ()
    {
        return this.artifactId;
    }

    public void setArtifactId ( final String artifactId )
    {
        this.artifactId = artifactId;
    }

    public String getVersion ()
    {
        return this.version;
    }

    public void setVersion ( final String version )
    {
        this.version = version;
    }

    @Override
    public String toString ()
    {
        return this.groupId + ":" + this.artifactId + ":" + this.version + ":" + this.classifier;
    }

    public String getClassifier ()
    {
        return this.classifier;
    }

    public void setClassifier ( final String classifier )
    {
        this.classifier = classifier;
    }

    public String toFileName ()
    {
        return toFileName ( null );
    }

    public String toFileName ( final String suffix )
    {
        final StringBuilder sb = new StringBuilder ();

        sb.append ( this.artifactId );
        sb.append ( '-' );
        sb.append ( this.version );
        if ( this.classifier != null )
        {
            sb.append ( '-' );
            sb.append ( this.classifier );
        }
        sb.append ( ".jar" );
        if ( suffix != null )
        {
            sb.append ( '.' );
            sb.append ( suffix );
        }

        return sb.toString ();
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.artifactId == null ? 0 : this.artifactId.hashCode () );
        result = prime * result + ( this.classifier == null ? 0 : this.classifier.hashCode () );
        result = prime * result + ( this.groupId == null ? 0 : this.groupId.hashCode () );
        result = prime * result + ( this.version == null ? 0 : this.version.hashCode () );
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
        final MavenReference other = (MavenReference)obj;
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
        if ( this.classifier == null )
        {
            if ( other.classifier != null )
            {
                return false;
            }
        }
        else if ( !this.classifier.equals ( other.classifier ) )
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
        if ( this.version == null )
        {
            if ( other.version != null )
            {
                return false;
            }
        }
        else if ( !this.version.equals ( other.version ) )
        {
            return false;
        }
        return true;
    }
}
