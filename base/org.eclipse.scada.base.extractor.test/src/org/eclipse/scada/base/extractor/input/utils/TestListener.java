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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.base.extractor.input.Data;
import org.eclipse.scada.base.extractor.input.Input.Listener;

public class TestListener implements Listener
{
    private final List<Data> data = new LinkedList<> ();

    @Override
    public void processInput ( final Data data )
    {
        this.data.add ( data );
    }

    public List<Data> getData ()
    {
        return this.data;
    }

}
