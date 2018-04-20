/*******************************************************************************
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     Red Hat Inc - Minor enhancements
 *******************************************************************************/
package org.eclipse.neoscada.releng.p2.to.maven;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IVersionFormat;
import org.eclipse.equinox.p2.metadata.Version;

public class DefaultMavenMapping implements MavenMapping
{
    private static final boolean IGNORE_TYCHO = !Boolean.getBoolean ( "useTychoVersion" );

    private static final boolean STRIP_QUALIFIER = Boolean.getBoolean ( "stripQualifier" );

    private static final String REPLACE_GROUP_ID_PREFIX;

    private static final String REPLACE_GROUP_ID_VALUE;

    private final Properties properties;

    private final Set<String> defaultIgnores = new HashSet<> ();

    static
    {
        final String replace = System.getProperty ( "groupIdPrefix" );
        if ( replace == null )
        {
            REPLACE_GROUP_ID_PREFIX = null;
            REPLACE_GROUP_ID_VALUE = null;
        }
        else
        {
            final String[] toks = replace.split ( ":" );
            if ( toks.length == 2 )
            {
                REPLACE_GROUP_ID_PREFIX = toks[0] + ".";
                REPLACE_GROUP_ID_VALUE = toks[1] + ".";
            }
            else
            {
                REPLACE_GROUP_ID_PREFIX = null;
                REPLACE_GROUP_ID_VALUE = null;
            }
        }
    }

    public DefaultMavenMapping ( final Properties properties )
    {
        this.properties = properties;
        this.defaultIgnores.add ( "a.jre.javase" );
    }

    @Override
    public List<MavenReference> makeReference ( final IInstallableUnit iu ) throws Exception
    {
        if ( this.defaultIgnores.contains ( iu.getId () ) )
        {
            return null;
        }

        String value = this.properties.getProperty ( "mapping." + iu.getId () );
        if ( value != null )
        {
            if ( value.isEmpty () )
            {
                return null; // ignore
            }
            return fromValue ( iu, value );
        }

        value = this.properties.getProperty ( "external." + iu.getId () );
        if ( value != null )
        {
            if ( value.isEmpty () )
            {
                return null; // ignore
            }
            return fromValue ( iu, value );
        }

        final MavenReference result = new MavenReference ();

        result.setGroupId ( makeGroupId ( iu ) );
        result.setArtifactId ( makeArtifactId ( iu ) );
        result.setVersion ( makeVersion ( iu, !STRIP_QUALIFIER ) );
        result.setClassifier ( makeClassifier ( iu ) );

        return Collections.singletonList ( result );
    }

    private String makeClassifier ( final IInstallableUnit iu )
    {
        return iu.getProperty ( "maven-classifier" );
    }

    private List<MavenReference> fromValue ( final IInstallableUnit iu, final String value ) throws Exception
    {
        final String[] segs = value.split ( "," );

        final List<MavenReference> result = new ArrayList<> ( segs.length );

        for ( final String seg : segs )
        {
            final String[] toks = seg.split ( "\\:" );
            if ( toks.length == 3 )
            {
                final String version = MessageFormat.format ( toks[2], getSegments ( iu.getVersion () ) );
                result.add ( new MavenReference ( toks[0], toks[1], version ) );
            }
            else if ( toks.length == 2 )
            {
                // automatic version
                result.add ( new MavenReference ( toks[0], toks[1], makeVersion ( iu, false ) ) );
            }
            else
            {
                throw new IllegalArgumentException ( String.format ( "Maven reference has invalid syntax: %s", value ) );
            }
        }
        return result;
    }

    private Object[] getSegments ( final Version version )
    {
        final Object[] result = new Object[version.getSegmentCount ()];

        for ( int i = 0; i < version.getSegmentCount (); i++ )
        {
            result[i] = version.getSegment ( i );
        }
        return result;
    }

    private String getName ( final IInstallableUnit iu )
    {
        return iu.getId ();
    }

    public String makeGroupId ( final IInstallableUnit iu )
    {
        final String groupId = makeGroupIdFromTycho ( iu );
        if ( groupId != null )
        {
            return prefixGroupId ( iu, groupId );
        }
        return prefixGroupId ( iu, makeGroupIdFromIU ( iu ) );
    }

    private String prefixGroupId ( final IInstallableUnit iu, String groupId )
    {
        final String replacementGroupId = this.properties.getProperty ( String.format ( "map.group.id.by.iu.%s", iu.getId () ) );
        if ( replacementGroupId != null )
        {
            // we still need to apply the global mapping
            groupId = replacementGroupId;
        }

        if ( groupId == null || REPLACE_GROUP_ID_PREFIX == null )
        {
            return groupId;
        }

        if ( groupId.startsWith ( REPLACE_GROUP_ID_PREFIX ) )
        {
            return REPLACE_GROUP_ID_VALUE + groupId.substring ( REPLACE_GROUP_ID_PREFIX.length () );
        }

        return groupId;
    }

    private String makeGroupIdFromTycho ( final IInstallableUnit iu )
    {
        return iu.getProperty ( "maven-groupId" );
    }

    private String makeGroupIdFromIU ( final IInstallableUnit iu )
    {
        final String name = getName ( iu );

        final String toks[] = name.split ( "\\.", 3 );

        final StringBuilder sb = new StringBuilder ();
        for ( int i = 0; i < toks.length; i++ )
        {
            if ( i > 0 )
            {
                sb.append ( '.' );
            }
            sb.append ( toks[i] );
        }

        return sb.toString ();
    }

    public String makeArtifactId ( final IInstallableUnit iu )
    {
        final String name = iu.getProperty ( "maven-artifactId" );
        if ( name != null )
        {
            return name;
        }
        return getName ( iu );
    }

    public String makeVersion ( final IInstallableUnit iu, final boolean withQualifier ) throws Exception
    {
        Version version;

        final String tychoVersion = iu.getProperty ( "maven-version" );
        if ( !IGNORE_TYCHO && tychoVersion != null )
        {
            final IVersionFormat format = Version.compile ( "n[.n=0;[.n=0;[.n=0;]]][[-.]S='';]" );
            version = format.parse ( tychoVersion );
        }
        else
        {
            version = iu.getVersion ();
        }

        if ( withQualifier )
        {
            return toString ( version );
        }
        else
        {
            return withoutQualifier ( version );
        }

    }

    protected String withoutQualifier ( final Version version )
    {
        if ( version.getSegmentCount () >= 4 )
        {
            return String.format ( "%s.%s.%s", version.getSegment ( 0 ), version.getSegment ( 1 ), version.getSegment ( 2 ) );
        }
        else
        {
            return toString ( version );
        }
    }

    private String toString ( final Version version )
    {
        return version.getOriginal ();
    }
}
