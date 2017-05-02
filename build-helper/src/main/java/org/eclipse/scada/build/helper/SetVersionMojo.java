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

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.stream.XMLStreamException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.eclipse.scada.build.helper.PomWalker.Visitor;
import org.eclipse.scada.build.helper.mod.XmlModifier;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @since 0.0.15
 */
@Mojo (
        name = "set-version",
        aggregator = false,
        requiresProject = false,
        requiresDirectInvocation = true )
public class SetVersionMojo extends AbstractHelperMojo
{
    @Parameter ( property = "poms", required = true )
    private Set<File> poms;

    @Parameter ( property = "newVersion", required = true )
    private String newVersion;

    @Parameter ( property = "packagings" )
    private final Set<String> packagings = new HashSet<> ();

    @Parameter ( property = "providedVersions" )
    private final Set<String> providedVersions = new HashSet<> ();

    @Parameter ( property = "ignoredModules" )
    private final Set<String> ignoredModules = new HashSet<> ();

    private final Set<PomId> ignoredModulesParsed = new HashSet<> ();

    private final Map<PomId, String> versions = new HashMap<> ();

    @Override
    public void execute () throws MojoExecutionException, MojoFailureException
    {
        getLog ().info ( "Setting version: " + this.newVersion );

        parseProvidedVersions ();
        parseIgnoredModules ();

        final Set<File> pomFiles = new HashSet<> ();

        try
        {
            for ( final File pom : this.poms )
            {
                final PomWalker walker = new PomWalker ( pom );
                walker.visit ( new Visitor () {

                    @Override
                    public void visit ( final File pom )
                    {
                        getLog ().info ( "Checking: " + pom );
                        pomFiles.add ( pom );
                    }
                } );
            }
            for ( final File pom : pomFiles )
            {
                preparePomFile ( pom );
            }
            for ( final File pom : pomFiles )
            {
                processPomFile ( pom );
            }
        }
        catch ( final MojoFailureException e )
        {
            throw e;
        }
        catch ( final Exception e )
        {
            throw new MojoExecutionException ( "Failed to process", e );
        }
    }

    private void parseIgnoredModules ()
    {
        for ( final String entry : this.ignoredModules )
        {
            final String[] tok = entry.split ( ":", 2 );
            final String groupId = tok[0].isEmpty () ? null : tok[0];
            final String artifactId = tok.length < 2 || tok[1].isEmpty () ? null : tok[1];
            this.ignoredModulesParsed.add ( new PomId ( groupId, artifactId ) );
        }
    }

    private void parseProvidedVersions () throws MojoFailureException
    {
        for ( final String v : this.providedVersions )
        {
            final String toks[] = v.split ( ":" );
            if ( toks.length != 3 )
            {
                throw new MojoFailureException ( this.providedVersions, "Wrong provided version syntax", "The syntax of the provided versions is <groupId>:<artifactId>:<version>. Multiple entries must be comma seperated." );
            }
            getLog ().info ( String.format ( "Recording provided version - %s:%s -> %s", toks[0], toks[1], toks[2] ) );
            this.versions.put ( new PomId ( toks[0], toks[1] ), toks[2] );
        }
    }

    private void preparePomFile ( final File localPom ) throws Exception
    {
        final Document doc = XmlHelper.parse ( localPom );

        if ( isSelected ( doc ) )
        {
            String groupId = XmlHelper.getText ( doc, "/project/groupId" );
            final String artifactId = XmlHelper.getText ( doc, "/project/artifactId" );
            if ( groupId == null )
            {
                groupId = XmlHelper.getText ( doc, "/project/parent/groupId" );
            }

            this.versions.put ( new PomId ( groupId, artifactId ), this.newVersion );
        }
    }

    private boolean isSelected ( final Document doc ) throws XPathExpressionException
    {
        String pkg = XmlHelper.getText ( doc, "/project/packaging" );
        if ( pkg == null )
        {
            pkg = "pom";
        }
        return this.packagings.contains ( pkg );
    }

    private String getParentVersion ( final Document doc ) throws XPathExpressionException
    {
        final String groupId = XmlHelper.getText ( doc, "/project/parent/groupId" );
        final String artifactId = XmlHelper.getText ( doc, "/project/parent/artifactId" );

        getLog ().debug ( String.format ( "Checking parent version: %s:%s", groupId, artifactId ) );

        if ( artifactId == null || groupId == null )
        {
            return null;
        }

        return this.versions.get ( new PomId ( groupId, artifactId ) );
    }

    private void processPomFile ( final File localPom ) throws Exception
    {
        getLog ().info ( "Processing: " + localPom );

        final Document doc = XmlHelper.parse ( localPom );

        final XmlModifier mod = new XmlModifier ( localPom );

        // check parent version
        final String parentVersion = getParentVersion ( doc );
        if ( parentVersion != null )
        {
            mod.set ( "/project/parent/version", parentVersion );
            getLog ().info ( String.format ( "Setting parent version of %s to %s", localPom, parentVersion ) );
        }

        final String version = XmlHelper.getText ( doc, "/project/version" );
        if ( version != null ) // only if plugin has a version
        {
            final PomId pomId = getPomId ( "/project/", doc );

            if ( !isIgnored ( pomId ) && isSelected ( doc ) )
            {
                mod.set ( "/project/version", this.newVersion );
                getLog ().info ( String.format ( "Setting version of %s to %s", localPom, this.newVersion ) );
            }
        }

        processDependencies ( doc, mod, "/project/dependencies/dependency" );
        processDependencies ( doc, mod, "/project/profiles/profile/dependencies/dependency" );

        mod.write ( localPom );
    }

    private boolean isIgnored ( final PomId pomId )
    {
        for ( final PomId entry : this.ignoredModulesParsed )
        {
            if ( entry.equals ( pomId ) )
            {
                getLog ().info ( "Ignore: direct match: " + pomId );
                return true;
            }

            if ( entry.getGroupId () != null )
            {
                if ( pomId.getGroupId ().matches ( entry.getGroupId () ) )
                {
                    getLog ().info ( String.format ( "Ignore: groupId %s matches pattern %s ", pomId.getGroupId (), entry.getGroupId () ) );
                    return true;
                }
            }

            if ( entry.getArtifactId () != null )
            {
                if ( pomId.getArtifactId ().matches ( entry.getArtifactId () ) )
                {
                    getLog ().info ( String.format ( "Ignore: artifactId %s matches pattern %s ", pomId.getArtifactId (), entry.getArtifactId () ) );
                    return true;
                }
            }
        }
        return false;
    }

    public PomId getPomId ( final Node node ) throws XPathExpressionException
    {
        return getPomId ( "", node );
    }

    public PomId getPomId ( final String prefix, final Node node ) throws XPathExpressionException
    {
        final String groupId = XmlHelper.getText ( node, prefix + "groupId" );
        final String artifactId = XmlHelper.getText ( node, prefix + "artifactId" );
        return new PomId ( groupId, artifactId );
    }

    private void processDependencies ( final Document doc, final XmlModifier mod, final String expression ) throws XPathExpressionException, IOException, XMLStreamException
    {
        int pos = 0;
        for ( final Node node : XmlHelper.findNodes ( doc, expression ) )
        {
            if ( ! ( node instanceof Element ) )
            {
                continue;
            }

            pos++;

            final PomId id = getPomId ( node );

            final String currentVersion = XmlHelper.getText ( node, "version" );
            if ( isPropertyOrNull ( currentVersion ) )
            {
                getLog ().info ( String.format ( "Skipping %s since version is a property or null: %s", id, currentVersion ) );
                continue;
            }

            final String version = this.versions.get ( id );

            if ( version == null )
            {
                continue;
            }
            getLog ().info ( String.format ( "Processing dependency #%d - %s -> %s", pos - 1, id, version ) );
            mod.set ( expression + "/version", pos - 1, version );
        }
    }

    private boolean isPropertyOrNull ( final String currentVersion )
    {
        if ( currentVersion == null )
        {
            return true;
        }
        return currentVersion.matches ( "^\\$\\{.*\\}$" );
    }

}
