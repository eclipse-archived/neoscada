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
package org.eclipse.scada.da.datasource.changecounter;

import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.datasource.DataSourceListener;
import org.eclipse.scada.da.datasource.base.AbstractDataSource;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChangeCounterDataSource extends AbstractDataSource implements DataSourceListener
{
    private final static Logger logger = LoggerFactory.getLogger ( ChangeCounterDataSource.class );

    public ChangeCounterDataSource ( final ExecutorService executor )
    {
        // TODO Auto-generated constructor stub
    }

    @Override
    public NotifyFuture<WriteResult> startWriteValue ( final Variant value, final OperationParameters operationParameters )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NotifyFuture<WriteAttributeResults> startWriteAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void stateChanged ( final DataItemValue value )
    {
        // TODO Auto-generated method stub

    }

    @Override
    protected Executor getExecutor ()
    {
        // TODO Auto-generated method stub
        return null;
    }

    public void update ( final Map<String, String> parameters )
    {
        // TODO Auto-generated method stub

    }

    public void dispose ()
    {
        // TODO Auto-generated method stub

    }
}
