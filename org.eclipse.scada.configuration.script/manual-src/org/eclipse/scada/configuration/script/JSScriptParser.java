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

package org.eclipse.scada.configuration.script;

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
                try ( final InputStreamReader stream = new InputStreamReader ( inputStream ) )
                {
                    getContents ().add ( parseContent ( stream ) );
                }
            }

            @Override
            protected void doSave ( final OutputStream outputStream, final Map<?, ?> options ) throws IOException
            {
                try ( PrintStream ps = new PrintStream ( outputStream ) )
                {
                    ps.print ( ( (JavaScript)getContents ().get ( 0 ) ).getSource () );
                }
            }
        };
    }

    protected EObject parseContent ( final InputStreamReader stream ) throws IOException
    {
        final String value = CharStreams.toString ( stream );

        final JavaScript script = ScriptFactory.eINSTANCE.createJavaScript ();
        script.setSource ( value );

        return script;
    }

}
