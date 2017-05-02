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
package org.eclipse.scada.base.extractor.input.file;

import java.io.File;
import java.io.FileReader;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.base.extractor.input.AbstractScheduledInput;
import org.eclipse.scada.base.extractor.input.Data;

public class FileInput extends AbstractScheduledInput
{

    private final File file;

    public FileInput ( final ScheduledExecutorService executor, final File file, final long period )
    {
        super ( executor, period );
        this.file = file;
    }

    @Override
    protected Data makeData () throws Exception
    {
        try ( final FileReader reader = new FileReader ( this.file ) )
        {
            final StringBuilder sb = new StringBuilder ();

            final char[] buffer = new char[4096];
            int rc;
            while ( ( rc = reader.read ( buffer ) ) > 0 )
            {
                sb.append ( buffer, 0, rc );
            }

            return new Data ( sb.toString (), null );
        }
    }
}
