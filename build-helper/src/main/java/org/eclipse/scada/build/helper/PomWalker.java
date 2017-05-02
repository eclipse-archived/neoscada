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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.maven.plugin.MojoFailureException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class PomWalker
{
    public interface Visitor
    {
        public void visit ( File pom ) throws Exception;
    }

    private final Set<File> context = new HashSet<> ();

    private final File pom;

    public PomWalker ( final File pom )
    {
        this.pom = pom;
    }

    public void visit ( final Visitor visitor ) throws Exception
    {
        this.context.clear ();
        process ( this.pom, visitor );
    }

    private void process ( final File pom, final Visitor visitor ) throws Exception
    {
        if ( this.context.contains ( pom ) )
        {
            return;
        }

        this.context.add ( pom );

        final Document doc = XmlHelper.parse ( pom );

        processModules ( pom, visitor, XmlHelper.findNodes ( doc, "/project/parent/relativePath" ) );

        visitor.visit ( pom );

        processModules ( pom, visitor, XmlHelper.findNodes ( doc, "/project/modules/module" ) );
        processModules ( pom, visitor, XmlHelper.findNodes ( doc, "/project/profiles/profile/modules/module" ) );
    }

    private void processModules ( final File pom, final Visitor visitor, final List<Node> modules ) throws MojoFailureException, IOException, Exception
    {
        for ( final Node node : modules )
        {
            final String text = node.getTextContent ();
            File file = new File ( pom.getParentFile (), text );
            if ( file.isDirectory () )
            {
                file = new File ( file, "pom.xml" );
            }
            if ( !file.isFile () )
            {
                throw new MojoFailureException ( pom, String.format ( "Unable to find project model: " + file ), String.format ( "The file '%s' is expected to be a readable pom file", file ) );
            }
            file = file.getCanonicalFile ();
            process ( file, visitor );
        }
    }
}
