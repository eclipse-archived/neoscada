/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.monitor.common;

import java.util.concurrent.Executor;

import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ds.DataListener;
import org.eclipse.scada.ds.DataNode;
import org.eclipse.scada.ds.DataStore;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Interner;

public abstract class AbstractPersistentStateMonitor extends AbstractStateMonitor implements DataItemMonitor
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractPersistentStateMonitor.class );

    private final SingleServiceListener<DataStore> listener = new SingleServiceListener<DataStore> () {

        @Override
        public void serviceChange ( final ServiceReference<DataStore> reference, final DataStore service )
        {
            AbstractPersistentStateMonitor.this.setDataStore ( service );
        }
    };

    private final SingleServiceTracker<DataStore> tracker;

    private DataStore dataStore;

    private final String nodeId;

    private final DataListener nodeListener = new DataListener () {

        @Override
        public void nodeChanged ( final DataNode node )
        {
            AbstractPersistentStateMonitor.this.nodeChanged ( node );
        }
    };

    private PersistentInformation lastStore;

    private final BundleContext context;

    public AbstractPersistentStateMonitor ( final String id, final String factoryId, final Executor executor, final BundleContext context, final Interner<String> stringInterner, final EventProcessor eventProcessor )
    {
        super ( id, executor, stringInterner, eventProcessor );

        this.context = context;

        this.tracker = new SingleServiceTracker<DataStore> ( context, DataStore.class, this.listener );

        this.nodeId = factoryId + "/" + id;

        this.tracker.open ();
    }

    protected synchronized void setDataStore ( final DataStore dataStore )
    {
        if ( this.dataStore != null )
        {
            this.dataStore.detachListener ( this.nodeId, this.nodeListener );
        }

        this.dataStore = dataStore;

        if ( this.dataStore != null )
        {
            this.dataStore.attachListener ( this.nodeId, this.nodeListener );
        }
    }

    @Override
    public void dispose ()
    {
        this.tracker.close ();
    }

    protected void nodeChanged ( final DataNode node )
    {
        logger.debug ( "Node changed: {}", node );

        if ( node == null )
        {
            return;
        }

        applyPersistentInformation ( (PersistentInformation)node.getDataAsObject ( this.context.getBundle (), null ) );

        // we can detach after the first update ... so actually we had an async-read
        this.dataStore.detachListener ( this.nodeId, this.nodeListener );

        // now, after we read what was we can overwrite with our current state
        if ( this.lastStore != null )
        {
            // write remembered store request
            logger.debug ( "Write remembered store request: {}", this.lastStore );
            this.dataStore.writeNode ( new DataNode ( this.nodeId, this.lastStore ) );
            this.lastStore = null;
        }
    }

    @Override
    protected synchronized void storePersistentInformation ( final PersistentInformation persistentInformation )
    {
        logger.debug ( "Request to store persistent information: {}", persistentInformation );

        if ( this.dataStore == null )
        {
            logger.debug ( "Remember store request for later" );
            this.lastStore = persistentInformation;
        }
        else
        {
            this.dataStore.writeNode ( new DataNode ( this.nodeId, persistentInformation ) );
        }
    }

}
