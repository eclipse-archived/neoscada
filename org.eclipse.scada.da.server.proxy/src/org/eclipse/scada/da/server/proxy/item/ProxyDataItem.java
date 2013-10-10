/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.proxy.item;

import java.util.EnumSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.InvalidOperationException;
import org.eclipse.scada.core.NotConvertableException;
import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.client.NoConnectionException;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.client.ItemUpdateListener;
import org.eclipse.scada.da.core.WriteAttributeResult;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.DataItemInformationBase;
import org.eclipse.scada.da.server.common.chain.DataItemInputOutputChained;
import org.eclipse.scada.utils.concurrent.FutureTask;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

/**
 * @author Juergen Rose &lt;juergen.rose@th4-systems.com&gt;
 */
public class ProxyDataItem extends DataItemInputOutputChained
{
    private final ProxyValueHolder proxyValueHolder;

    private final ProxyWriteHandler writeHandler;

    /**
     * @param id
     * @param proxyValueHolder
     * @param executor
     *            the executor to use for write calls
     */
    public ProxyDataItem ( final String id, final ProxyValueHolder proxyValueHolder, final ProxyWriteHandler writeHandler, final Executor executor )
    {
        super ( new DataItemInformationBase ( id, EnumSet.allOf ( IODirection.class ) ), executor );
        this.proxyValueHolder = proxyValueHolder;
        this.proxyValueHolder.setListener ( new ItemUpdateListener () {
            @Override
            public void notifyDataChange ( final Variant value, final Map<String, Variant> attributes, final boolean cache )
            {
                ProxyDataItem.this.updateData ( value, attributes, cache ? AttributeMode.SET : AttributeMode.UPDATE );
            }

            @Override
            public void notifySubscriptionChange ( final SubscriptionState subscriptionState, final Throwable subscriptionError )
            {
                // TODO: (jr2) is there something which is to be done?
            }
        } );

        this.writeHandler = writeHandler;
    }

    /**
     * @return object which holds the actual data
     */
    public ProxyValueHolder getProxyValueHolder ()
    {
        return this.proxyValueHolder;
    }

    @Override
    public NotifyFuture<WriteAttributeResults> startSetAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        final FutureTask<WriteAttributeResults> task = new FutureTask<WriteAttributeResults> ( new Callable<WriteAttributeResults> () {

            @Override
            public WriteAttributeResults call () throws Exception
            {
                return processSetAttributes ( attributes, operationParameters );
            }
        } );
        this.executor.execute ( task );
        return task;
    }

    @Override
    protected WriteAttributeResults processSetAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        final WriteAttributeResults writeAttributeResults = super.processSetAttributes ( attributes, operationParameters );
        // all attributes which could be successfully processed by chain must be ignored
        for ( final Entry<String, WriteAttributeResult> entry : writeAttributeResults.entrySet () )
        {
            if ( entry.getValue ().isSuccess () )
            {
                attributes.remove ( entry.getKey () );
            }
        }
        this.writeHandler.writeAttributes ( getInformation ().getName (), attributes, writeAttributeResults, operationParameters );
        return writeAttributeResults;
    }

    /**
     * @param attributes
     */
    public void setTemplateAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        super.processSetAttributes ( attributes, operationParameters );
    }

    @Override
    protected NotifyFuture<WriteResult> startWriteCalculatedValue ( final Variant value, final OperationParameters operationParameters )
    {
        final FutureTask<WriteResult> task = new FutureTask<WriteResult> ( new Callable<WriteResult> () {

            @Override
            public WriteResult call () throws Exception
            {
                processWriteCalculatedValue ( value, operationParameters );
                return new WriteResult ();
            }
        } );
        this.executor.execute ( task );
        return task;
    }

    protected void processWriteCalculatedValue ( final Variant value, final OperationParameters operationParameters ) throws NotConvertableException, InvalidOperationException
    {
        try
        {
            this.writeHandler.write ( getInformation ().getName (), value, operationParameters );
        }
        catch ( final NoConnectionException e )
        {
            throw new InvalidOperationException ();
        }
        catch ( final OperationException e )
        {
            throw new InvalidOperationException ();
        }
    }
}
