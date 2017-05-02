/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.datasource.base;

import java.util.concurrent.Executor;

import org.eclipse.scada.da.client.DataItemValue;

public class DataInputSource extends AbstractInputDataSource
{
    private final Executor executor;

    public DataInputSource ( final Executor executor )
    {
        this.executor = executor;
    }

    @Override
    protected Executor getExecutor ()
    {
        return this.executor;
    }

    public void setValue ( final DataItemValue value )
    {
        updateData ( value );
    }
}
