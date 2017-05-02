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

package org.eclipse.scada.configuration.security.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.scada.configuration.security.JavaScript;
import org.eclipse.scada.configuration.security.SecurityFactory;

import com.google.common.io.CharStreams;

public class JSScriptParser implements Resource.Factory
{

    @Override
    public Resource createResource ( final URI uri )
    {
        return new ResourceImpl ( uri ) {
            @Override
            protected void doLoad ( final InputStream inputStream, final Map<?, ?> options ) throws IOException
            {
                final InputStreamReader stream = new InputStreamReader ( inputStream );
                try
                {
                    getContents ().add ( parseContent ( stream ) );
                }
                finally
                {
                    stream.close ();
                }
            }

            @Override
            protected void doSave ( final OutputStream outputStream, final Map<?, ?> options ) throws IOException
            {
                final PrintStream ps = new PrintStream ( outputStream );
                try
                {
                    ps.print ( ( (JavaScript)getContents ().get ( 0 ) ).getSource () );
                }
                finally
                {
                    ps.close ();
                }
            }
        };
    }

    protected EObject parseContent ( final InputStreamReader stream ) throws IOException
    {
        final String value = CharStreams.toString ( stream );

        final JavaScript script = SecurityFactory.eINSTANCE.createJavaScript ();
        script.setSource ( value );

        return script;
    }

}
