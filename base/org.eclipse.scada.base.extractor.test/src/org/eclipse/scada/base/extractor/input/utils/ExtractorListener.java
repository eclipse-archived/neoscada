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
package org.eclipse.scada.base.extractor.input.utils;

import org.eclipse.scada.base.extractor.extract.Extractor;
import org.eclipse.scada.base.extractor.extract.Extractor.Result;
import org.eclipse.scada.base.extractor.input.Data;
import org.eclipse.scada.base.extractor.input.Input.Listener;

public class ExtractorListener implements Listener
{

    private final Extractor extractor;

    public ExtractorListener ( final Extractor extractor )
    {
        this.extractor = extractor;
    }

    @Override
    public void processInput ( final Data data )
    {
        fireUpdate ( this.extractor.processData ( data ) );
    }

    private void fireUpdate ( final Result result )
    {
        AbstractExtractTest.dump ( result );
    }

}
