/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.monitor.datasource;

import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Event.EventBuilder;
import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.monitor.common.AbstractConfiguration;
import org.eclipse.scada.ae.monitor.common.AbstractPersistentStateMonitor;
import org.eclipse.scada.ae.monitor.common.DataItemMonitor;
import org.eclipse.scada.ae.monitor.common.PersistentInformation;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.da.core.WriteAttributeResult;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.da.master.MasterItemHandler;
import org.eclipse.scada.da.master.WriteRequest;
import org.eclipse.scada.da.master.WriteRequestResult;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.eclipse.scada.utils.osgi.pool.SingleObjectPoolServiceTracker;
import org.eclipse.scada.utils.osgi.pool.SingleObjectPoolServiceTracker.ServiceListener;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Interner;

public abstract class AbstractMasterItemMonitor extends AbstractPersistentStateMonitor implements DataItemMonitor
{
    private final static Logger logger = LoggerFactory.getLogger ( AbstractMasterItemMonitor.class );

    private SingleObjectPoolServiceTracker<MasterItem> tracker;

    protected MasterItem masterItem;

    private MasterItemHandler handler;

    private String prefix;

    private final String defaultMonitorType;

    private final ObjectPoolTracker<MasterItem> poolTracker;

    private final Executor executor;

    private Configuration configuration;

    private final String factoryId;

    private final MonitorStateInjector monitorStateInjector;

    private static class Configuration extends AbstractConfiguration
    {

        private String masterId;

        private int handlerPriority;

        private String monitorType;

        private boolean activeState;

        private boolean suppressEvents;

        public Configuration ( final Configuration configuration, final AbstractMasterItemMonitor monitor )
        {
            super ( configuration, monitor );

            if ( configuration != null )
            {
                this.masterId = configuration.masterId;
                this.handlerPriority = configuration.handlerPriority;
                this.monitorType = configuration.monitorType;
                this.activeState = configuration.activeState;
                this.suppressEvents = configuration.suppressEvents;
            }
        }

        public void setMasterId ( final String masterId )
        {
            this.masterId = masterId;
        }

        public void setHandlerPriority ( final int handlerPriority )
        {
            this.handlerPriority = handlerPriority;
        }

        public void setMonitorType ( final String monitorType )
        {
            this.monitorType = monitorType;
        }

        public void setSuppressEvents ( final UserInformation userInformation, final boolean suppressEvents )
        {
            this.suppressEvents = update ( userInformation, this.suppressEvents, suppressEvents );
        }

        public void setActiveState ( final UserInformation userInformation, final boolean activeState )
        {
            this.activeState = update ( userInformation, this.activeState, activeState );
        }

    }

    public AbstractMasterItemMonitor ( final BundleContext context, final Executor executor, final Interner<String> stringInterner, final ObjectPoolTracker<MasterItem> poolTracker, final EventProcessor eventProcessor, final String id, final String factoryId, final String prefix, final String defaultMonitorType )
    {
        super ( id, factoryId, executor, context, stringInterner, eventProcessor );
        this.factoryId = factoryId;
        this.executor = executor;
        this.poolTracker = poolTracker;

        this.defaultMonitorType = defaultMonitorType;

        this.monitorStateInjector = new MonitorStateInjector ( stringInterner );

        setPrefix ( prefix );
    }

    protected void setPrefix ( final String prefix )
    {
        this.prefix = prefix;
        this.monitorStateInjector.setPrefix ( prefix );
    }

    protected String getPrefix ()
    {
        return this.prefix;
    }

    @Override
    public synchronized void dispose ()
    {
        super.dispose ();
        disconnect ();
    }

    @Override
    public synchronized void akn ( final UserInformation userInformation, final Date aknTimestamp )
    {
        super.akn ( userInformation, aknTimestamp );
        reprocess ();
    }

    @Override
    protected synchronized void applyPersistentInformation ( final PersistentInformation persistentInformation )
    {
        super.applyPersistentInformation ( persistentInformation );

        // information was updated .. now we need to update the DA attributes
        reprocess ();
    }

    @Override
    public synchronized void update ( final UserInformation userInformation, final Map<String, String> properties ) throws Exception
    {
        disconnect ();

        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        final Configuration c = new Configuration ( this.configuration, this );
        c.setMasterId ( intern ( cfg.getStringChecked ( MasterItem.MASTER_ID, String.format ( "'%s' must be set", MasterItem.MASTER_ID ) ) ) );
        c.setHandlerPriority ( cfg.getInteger ( "handlerPriority", getDefaultHandlerPriority () ) ); //$NON-NLS-1$
        c.setMonitorType ( intern ( cfg.getString ( "monitorType", this.defaultMonitorType ) ) ); //$NON-NLS-1$

        c.setActiveState ( userInformation, cfg.getBoolean ( "active", true ) ); //$NON-NLS-1$
        c.setSuppressEvents ( userInformation, cfg.getBoolean ( "suppressEvents", false ) ); //$NON-NLS-1$

        this.configuration = c;
        c.sendEvents ();

        setSuppressEvents ( c.suppressEvents );
        setStringAttributes ( cfg.getPrefixed ( "info." ) ); //$NON-NLS-1$

        connect ();
    }

    protected int getDefaultHandlerPriority ()
    {
        return 0;
    }

    private synchronized void connect () throws InvalidSyntaxException
    {
        if ( this.configuration.masterId == null )
        {
            setUnsafe ();
            throw new RuntimeException ( String.format ( "'%s' is not set", MasterItem.MASTER_ID ) );
        }

        logger.debug ( "Setting up for master item: {}", this.configuration.masterId );

        this.tracker = new SingleObjectPoolServiceTracker<MasterItem> ( this.poolTracker, this.configuration.masterId, new ServiceListener<MasterItem> () {

            @Override
            public void serviceChange ( final MasterItem service, final Dictionary<?, ?> properties )
            {
                AbstractMasterItemMonitor.this.setMasterItem ( service );
            }
        } );

        this.tracker.open ();
    }

    private void setMasterItem ( final MasterItem masterItem )
    {
        logger.info ( "Setting master item: {}", masterItem );

        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                performSet ( masterItem );
            }
        } );
    }

    private synchronized void performSet ( final MasterItem masterItem )
    {
        logger.info ( "Perform set item: {}", masterItem );

        disconnectItem ();
        connectItem ( masterItem );
    }

    private synchronized void connectItem ( final MasterItem masterItem )
    {
        logger.debug ( "Connecting to master item: {}", masterItem );

        this.masterItem = masterItem;
        if ( this.masterItem != null )
        {
            this.masterItem.addHandler ( this.handler = new MasterItemHandler () {

                @Override
                public WriteRequestResult processWrite ( final WriteRequest request )
                {
                    return AbstractMasterItemMonitor.this.handleProcessWrite ( request );
                }

                @Override
                public void dataUpdate ( final Map<String, Object> context, final DataItemValue.Builder value )
                {
                    logger.debug ( "Handle data update: {}", value );
                    AbstractMasterItemMonitor.this.handleDataUpdate ( context, value );
                }
            }, this.configuration.handlerPriority );
        }
    }

    private synchronized void disconnectItem ()
    {
        logger.debug ( "Disconnect from master item: {}", this.masterItem );

        if ( this.masterItem != null )
        {
            this.masterItem.removeHandler ( this.handler );
            this.masterItem = null;
            this.handler = null;
        }
    }

    private synchronized void disconnect ()
    {
        if ( this.tracker != null )
        {
            this.tracker.close ();
            this.tracker = null;
        }
    }

    protected void handleDataUpdate ( final Map<String, Object> context, final DataItemValue.Builder builder )
    {
        if ( !this.configuration.activeState )
        {
            setInactive ();
        }
        else
        {
            performDataUpdate ( context, builder );
        }

        injectAttributes ( builder );

        logger.debug ( "Setting new value: {}", builder );
    }

    protected abstract void performDataUpdate ( Map<String, Object> context, Builder builder );

    /**
     * Return the factory id that configured this instance
     * 
     * @return the factory id
     */
    protected String getFactoryId ()
    {
        return this.factoryId;
    }

    /**
     * Return the configuration id that is assigned to this instance
     * 
     * @return the configuration id
     */
    protected String getConfigurationId ()
    {
        return getId ();
    }

    @Override
    protected synchronized void notifyStateChange ( final MonitorStatusInformation status )
    {
        super.notifyStateChange ( status );

        this.monitorStateInjector.notifyStateChange ( status );
    }

    /**
     * Inject attributes to the value after the value update has been performed
     * using {@link #performDataUpdate(Builder)}
     * 
     * @param builder
     *            the builder to use for changing information
     */
    protected void injectAttributes ( final Builder builder )
    {
        this.monitorStateInjector.injectAttributes ( builder );
    }

    private WriteRequestResult handleProcessWrite ( final WriteRequest request )
    {
        if ( request.getAttributes () != null )
        {
            return handleAttributesWrite ( request );
        }
        return null;
    }

    private WriteRequestResult handleAttributesWrite ( final WriteRequest request )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ( request.getAttributes () );
        final WriteAttributeResults result = new WriteAttributeResults ();

        simpleHandleAttributes ( attributes, result, request.getOperationParameters () );

        // remove result keys from request
        for ( final String attr : result.keySet () )
        {
            attributes.remove ( attr );
        }

        return new WriteRequestResult ( request.getValue (), attributes, result );
    }

    private void simpleHandleAttributes ( final Map<String, Variant> attributes, final WriteAttributeResults result, final OperationParameters operationParameters )
    {
        final Map<String, String> configUpdate = new HashMap<String, String> ();

        handleConfigUpdate ( configUpdate, attributes, result );

        if ( !configUpdate.isEmpty () )
        {
            updateConfiguration ( configUpdate, operationParameters );
        }
    }

    private void updateConfiguration ( final Map<String, String> configUpdate, final OperationParameters operationParameters )
    {
        logger.info ( "Request to update configuration: {}", configUpdate );

        final String factoryId = getFactoryId ();
        final String configurationId = getConfigurationId ();

        logger.info ( "Directing update to: {}/{}", new Object[] { factoryId, configurationId } );

        if ( factoryId != null && configurationId != null )
        {
            try
            {
                Activator.getConfigAdmin ().updateConfiguration ( operationParameters.getUserInformation (), factoryId, configurationId, configUpdate, false );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to update configuration", e );
                throw new RuntimeException ( "Unable to update configuration", e );
            }
        }
    }

    protected void reprocess ()
    {
        final MasterItem item = this.masterItem;
        if ( item != null )
        {
            item.reprocess ();
        }
    }

    protected void handleConfigUpdate ( final Map<String, String> configUpdate, final Map<String, Variant> attributes, final WriteAttributeResults result )
    {
        final Variant active = attributes.get ( this.prefix + ".active" );
        if ( active != null )
        {
            configUpdate.put ( "active", active.asBoolean () ? "true" : "false" );
            result.put ( intern ( this.prefix + ".active" ), WriteAttributeResult.OK );
        }
    }

    @Override
    protected void injectEventAttributes ( final EventBuilder builder )
    {
        super.injectEventAttributes ( builder );

        if ( this.configuration != null )
        {
            builder.attribute ( Event.Fields.MONITOR_TYPE, this.configuration.monitorType );
        }
    }

}