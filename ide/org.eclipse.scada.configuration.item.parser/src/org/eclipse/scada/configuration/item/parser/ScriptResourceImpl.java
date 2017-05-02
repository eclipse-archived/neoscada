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
package org.eclipse.scada.configuration.item.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import com.google.common.io.CharStreams;

public abstract class ScriptResourceImpl extends ResourceImpl
{
    protected final String fileExtension;

    protected final String defaultCharacterSet;

    protected final String scriptEngine;

    public ScriptResourceImpl ( final URI uri, final String scriptEngine, final String fileExtension, final String defaultCharacterSet )
    {
        super ( uri );

        this.scriptEngine = scriptEngine;
        this.fileExtension = fileExtension;
        this.defaultCharacterSet = defaultCharacterSet;
    }

    protected abstract void write ( final OutputStreamWriter writer ) throws IOException;

    protected abstract EObject parse ( final String data );

    @Override
    protected void doLoad ( final InputStream inputStream, final Map<?, ?> options ) throws IOException
    {
        try
        {
            final String data = CharStreams.toString ( new InputStreamReader ( inputStream, this.defaultCharacterSet ) );
            getContents ().add ( parse ( data ) );
        }
        finally
        {
            inputStream.close ();
        }
    }

    @Override
    protected void doSave ( final OutputStream outputStream, final Map<?, ?> options ) throws IOException
    {
        try
        {
            try (final OutputStreamWriter writer = new OutputStreamWriter ( outputStream, this.defaultCharacterSet ))
            {
                write ( writer );
            }
        }
        finally
        {
            outputStream.close ();
        }
    }

}