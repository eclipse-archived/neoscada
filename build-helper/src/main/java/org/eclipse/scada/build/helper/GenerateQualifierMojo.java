/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.build.helper;

import java.io.StringReader;
import java.util.Map;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3DomBuilder;
import org.eclipse.scada.build.helper.name.QualifierNameProvider;
import org.eclipse.scada.build.helper.name.QualifierNameProvider.Configuration;

/**
 * Generate qualifier
 * 
 * @author Jens Reimann
 * @since 0.0.1
 */
@Mojo (
        name = "generate-qualifier",
        aggregator = true,
        requiresProject = true,
        requiresDirectInvocation = true )
public class GenerateQualifierMojo extends AbstractSetQualifierMojo
{
    @Parameter ( property = "defaultNameProvider", defaultValue = "timestamp" )
    protected String defaultNameProvider;

    @Component ( role = QualifierNameProvider.class )
    protected Map<String, QualifierNameProvider> nameProviders;

    @Parameter ( property = "nameProviderMap" )
    private Map<String, String> nameProviderMap;

    @Parameter ( property = "nameProviderProperties" )
    private Map<String, String> nameProviderProperties;

    @Override
    protected synchronized String getQualifier ( final MavenProject project ) throws MojoExecutionException
    {
        String providerType = this.nameProviderMap.get ( project.getPackaging () );
        if ( providerType == null )
        {
            providerType = this.defaultNameProvider;
        }

        getLog ().debug ( String.format ( "Using provider '%s' for project: %s", providerType, project.getId () ) );

        final QualifierNameProvider nameProvider = this.nameProviders.get ( providerType );
        if ( nameProvider == null )
        {
            throw new MojoExecutionException ( String.format ( "Unable to find name provider with hint '%s'", providerType ) );
        }

        return nameProvider.createName ( new Configuration ( this.session, this.execution, project, this.nameProviderProperties ) );
    }

    @Override
    public synchronized void execute () throws MojoExecutionException
    {
        fillFromProperties ( "nameProviderMap", this.nameProviderMap );
        fillFromProperties ( "nameProviderProperties", this.nameProviderProperties );

        getLog ().info ( "Name provider properties: " + this.nameProviderProperties );
        getLog ().info ( "Name provider mappings: " + this.nameProviderMap );

        if ( this.execution.getPlugin ().getConfiguration () == null )
        {
            // inject dummy configuration, otherwise the jgit provider will fail with a NPE
            try
            {
                this.execution.getPlugin ().setConfiguration ( Xpp3DomBuilder.build ( new StringReader ( "<configuration/>" ) ) );
            }
            catch ( final Exception e )
            {
                throw new RuntimeException ( e );
            }
        }

        super.execute ();
    }
}
