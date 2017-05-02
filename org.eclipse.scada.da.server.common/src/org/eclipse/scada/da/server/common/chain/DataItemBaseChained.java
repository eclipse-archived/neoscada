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
package org.eclipse.scada.da.server.common.chain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.core.DataItemInformation;
import org.eclipse.scada.da.core.WriteAttributeResult;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.da.server.common.AttributeManager;
import org.eclipse.scada.da.server.common.DataItemBase;
import org.eclipse.scada.da.server.common.WriteAttributesHelper;
import org.eclipse.scada.utils.concurrent.FutureTask;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public abstract class DataItemBaseChained extends DataItemBase
{
    protected Map<String, Variant> primaryAttributes = null;

    protected AttributeManager secondaryAttributes = null;

    /**
     * The chain if items used for calculation
     */
    protected volatile Set<ChainProcessEntry> chain = new CopyOnWriteArraySet<ChainProcessEntry> ();

    protected final Executor executor;

    public DataItemBaseChained ( final DataItemInformation dataItemInformation, final Executor executor )
    {
        super ( dataItemInformation );
        this.executor = executor;

        this.primaryAttributes = new HashMap<String, Variant> ();
        this.secondaryAttributes = new AttributeManager ( this );
    }

    @Override
    public Map<String, Variant> getAttributes ()
    {
        return this.secondaryAttributes.get ();
    }

    /**
     * This method sets the attributes.
     * <p>
     * It is intended to be overridden by subclasses that wish to handle
     * attribute writes differently. The method needs to remove attributes from
     * the parameter map that were handled and return a result for all
     * attributes that were requested.
     * 
     * @param attributes
     *            Attributes to set
     * @return status for the attribute write request
     */
    @Override
    public NotifyFuture<WriteAttributeResults> startSetAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        final FutureTask<WriteAttributeResults> task = new FutureTask<WriteAttributeResults> ( new Callable<WriteAttributeResults> () {

            @Override
            public WriteAttributeResults call () throws Exception
            {
                return DataItemBaseChained.this.processSetAttributes ( attributes, operationParameters );
            }
        } );

        this.executor.execute ( task );

        return task;
    }

    protected WriteAttributeResults processSetAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        final WriteAttributeResults writeAttributeResults = new WriteAttributeResults ();

        for ( final ChainProcessEntry chainEntry : this.chain )
        {
            final ChainItem chainItem = chainEntry.getWhat ();

            final WriteAttributeResults partialResult = chainItem.setAttributes ( attributes );
            if ( partialResult != null )
            {
                for ( final Map.Entry<String, WriteAttributeResult> entry : partialResult.entrySet () )
                {
                    if ( entry.getValue ().isError () )
                    {
                        attributes.remove ( entry.getKey () );
                    }
                    writeAttributeResults.put ( entry.getKey (), entry.getValue () );
                }
            }
        }

        process ();

        return handleUnhandledAttributes ( writeAttributeResults, attributes );
    }

    /**
     * Handle all unhandled set attribute requests
     * 
     * @param writeAttributeResults
     *            the result set
     * @param attributes
     *            the attributes to set
     * @return the final result
     */
    protected WriteAttributeResults handleUnhandledAttributes ( final WriteAttributeResults writeAttributeResults, final Map<String, Variant> attributes )
    {
        return WriteAttributesHelper.errorUnhandled ( writeAttributeResults, attributes );
    }

    protected abstract void process ();

    /**
     * Replace the current chain with the new one
     * 
     * @param chain
     *            the new chain
     */
    public void setChain ( final Collection<ChainProcessEntry> chain )
    {
        if ( chain == null )
        {
            this.chain = new CopyOnWriteArraySet<ChainProcessEntry> ();
        }
        else
        {
            final Set<ChainProcessEntry> newChain = new CopyOnWriteArraySet<ChainProcessEntry> ( chain );
            this.chain = newChain;
        }
        process ();
    }

    public void addChainElement ( final EnumSet<IODirection> when, final ChainItem item )
    {
        if ( this.chain.add ( new ChainProcessEntry ( when, item ) ) )
        {
            process ();
        }
    }

    public void addChainElement ( final IODirection when, final ChainItem item )
    {
        if ( this.chain.add ( new ChainProcessEntry ( EnumSet.of ( when ), item ) ) )
        {
            process ();
        }
    }

    public void removeChainElement ( final EnumSet<IODirection> when, final ChainItem item )
    {
        int n = 0;

        for ( final Iterator<ChainProcessEntry> i = this.chain.iterator (); i.hasNext (); )
        {
            final ChainProcessEntry entry = i.next ();

            if ( entry.getWhen ().equals ( when ) )
            {
                if ( entry.getWhat () == item )
                {
                    i.remove ();
                    n++;
                }
            }
        }

        if ( n > 0 )
        {
            process ();
        }
    }

    protected Collection<ChainProcessEntry> getChainCopy ()
    {
        return new ArrayList<ChainProcessEntry> ( this.chain );
    }

}