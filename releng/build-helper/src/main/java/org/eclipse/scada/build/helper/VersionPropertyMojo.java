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

import java.util.Arrays;
import java.util.LinkedList;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * @since 0.0.11
 * @author Jens Reimann
 */
@Mojo ( name = "version-property",
        requiresProject = true,
        defaultPhase = LifecyclePhase.VALIDATE )
public class VersionPropertyMojo extends AbstractHelperMojo
{

    private static final String UNQUALIFIED_VERSION_PROPERTY = "unqualifiedVersion";

    @Override
    public synchronized void execute () throws MojoExecutionException, MojoFailureException
    {
        if ( !this.project.getProperties ().containsKey ( UNQUALIFIED_VERSION_PROPERTY ) )
        {
            final String result = makeVersion ( this.project.getVersion () );
            getLog ().debug ( "Setting unqualified version to: " + result );
            if ( result != null )
            {
                this.project.getProperties ().put ( UNQUALIFIED_VERSION_PROPERTY, result );
            }
        }
    }

    static String makeVersion ( String version )
    {
        if ( version == null )
        {
            return null;
        }

        //  remove trailing -SNAPSHOT
        version = version.replaceAll ( "-SNAPSHOT$", "" );
        final LinkedList<String> toks = new LinkedList<String> ( Arrays.asList ( version.split ( "\\.", 4 ) ) );

        while ( toks.size () > 3 )
        {
            toks.removeLast ();
        }
        while ( toks.size () < 3 )
        {
            toks.addLast ( "0" );
        }

        final StringBuilder sb = new StringBuilder ();

        while ( !toks.isEmpty () )
        {
            if ( sb.length () > 0 )
            {
                sb.append ( '.' );
            }
            sb.append ( toks.pollFirst () );
        }

        return sb.toString ();
    }

}
