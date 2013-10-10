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
package org.eclipse.scada.ae.monitor.script;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.monitor.common.AbstractPersistentStateMonitor;
import org.eclipse.scada.ae.monitor.common.DemoteImpl;
import org.eclipse.scada.ae.monitor.common.PersistentInformation;
import org.eclipse.scada.ae.monitor.datasource.MonitorStateInjector;
import org.eclipse.scada.ae.monitor.script.ScriptMonitorResult.FailureBuilder;
import org.eclipse.scada.ae.monitor.script.ScriptMonitorResult.OkBuilder;
import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.datasource.DataSourceHandler;
import org.eclipse.scada.da.datasource.MultiDataSourceListener;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.eclipse.scada.utils.script.ScriptExecutor;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Interner;

public class ScriptMonitor extends AbstractPersistentStateMonitor
{

    private final static Logger logger = LoggerFactory.getLogger ( ScriptMonitor.class );

    public class InjectMasterHandler extends MultiMasterHandler
    {
        public InjectMasterHandler ( final String configurationId, final ObjectPoolTracker<MasterItem> poolTracker, final int priority, final ServiceTracker<ConfigurationAdministrator, ConfigurationAdministrator> caTracker, final String prefix, final String factoryId )
        {
            super ( configurationId, poolTracker, priority, caTracker, prefix, factoryId );
        }

        @Override
        public void dataUpdate ( final Map<String, Object> context, final DataItemValue.Builder value )
        {
            ScriptMonitor.this.dataUpdate ( context, value );
        }

        @Override
        protected WriteAttributeResults handleUpdate ( final Map<String, Variant> attributes, final OperationParameters operationParameters ) throws Exception
        {
            return null;
        }

        @Override
        protected void reprocess ()
        {
            super.reprocess ();
        }
    }

    private static final String DEFAULT_ENGINE_NAME = "JavaScript"; //$NON-NLS-1$

    private final InjectMasterHandler handler;

    private final DemoteImpl demoteImpl = new DemoteImpl ();

    private final MultiDataSourceListener listener;

    private final MonitorStateInjector monitorStateInjector;

    private final ClassLoader classLoader;

    private final ScriptEngineManager manager;

    private SimpleScriptContext scriptContext;

    private ScriptEngine scriptEngine;

    private ScriptExecutor updateCommand;

    private final ScriptMonitorResult lastResult = new ScriptMonitorResult ();

    private final String prefix;

    private final Executor executor;

    public ScriptMonitor ( final String id, final String factoryId, final Executor executor, final BundleContext context, final Interner<String> stringInterner, final EventProcessor eventProcessor, final ObjectPoolTracker<DataSource> dataSourcePoolTracker, final ObjectPoolTracker<MasterItem> masterItemPoolTracker, final ServiceTracker<ConfigurationAdministrator, ConfigurationAdministrator> caTracker )
    {
        super ( id, factoryId, executor, context, stringInterner, eventProcessor );
        this.executor = executor;

        this.prefix = stringInterner.intern ( factoryId + ". " + id ); //$NON-NLS-1$

        this.classLoader = getClass ().getClassLoader ();

        this.monitorStateInjector = new MonitorStateInjector ( stringInterner );
        this.monitorStateInjector.setPrefix ( this.prefix );

        final ClassLoader currentClassLoader = Thread.currentThread ().getContextClassLoader ();
        try
        {
            Thread.currentThread ().setContextClassLoader ( this.classLoader );
            this.manager = new ScriptEngineManager ( this.classLoader );
        }
        finally
        {
            Thread.currentThread ().setContextClassLoader ( currentClassLoader );
        }

        this.handler = new InjectMasterHandler ( id, masterItemPoolTracker, 0, caTracker, this.prefix, factoryId );
        this.listener = new MultiDataSourceListener ( dataSourcePoolTracker ) {

            @Override
            protected void handleChange ( final Map<String, DataSourceHandler> sources )
            {
                ScriptMonitor.this.handleChange ( sources );
            }
        };
    }

    @Override
    public void dispose ()
    {
        this.handler.dispose ();
        this.listener.dispose ();
        super.dispose ();
    }

    @Override
    protected synchronized void notifyStateChange ( final MonitorStatusInformation state )
    {
        super.notifyStateChange ( state );
        this.monitorStateInjector.notifyStateChange ( state );

        this.handler.reprocess ();
    }

    @Override
    protected synchronized void applyPersistentInformation ( final PersistentInformation persistentInformation )
    {
        super.applyPersistentInformation ( persistentInformation );

        // information was updated .. now we need to update the DA attributes
        handleChange ( this.listener.getSourcesCopy () );
    }

    @Override
    public void update ( final UserInformation userInformation, final Map<String, String> properties ) throws Exception
    {
        logger.info ( "Changing configuration - {}", properties ); //$NON-NLS-1$

        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        setScript ( cfg );

        this.demoteImpl.update ( userInformation, properties );
        this.handler.update ( userInformation, properties );

        this.listener.setDataSources ( properties );

        setSuppressEvents ( cfg.getBoolean ( "suppressEvents", false ) ); //$NON-NLS-1$
        setStringAttributes ( cfg.getPrefixed ( "info." ) ); //$NON-NLS-1$

        handleChange ( this.listener.getSourcesCopy () );
    }

    private synchronized void setScript ( final ConfigurationDataHelper cfg ) throws ScriptException, IOException
    {
        String engine = cfg.getString ( "scriptEngine", DEFAULT_ENGINE_NAME ); //$NON-NLS-1$
        if ( "".equals ( engine ) ) // catches null
        {
            engine = DEFAULT_ENGINE_NAME;
        }

        this.scriptContext = new SimpleScriptContext ();

        this.scriptEngine = this.manager.getEngineByName ( engine );
        if ( this.scriptEngine == null )
        {
            throw new IllegalArgumentException ( String.format ( "'%s' is not a valid script engine", engine ) );
        }

        // trigger init script
        final String initScript = cfg.getString ( "init" ); //$NON-NLS-1$
        if ( initScript != null )
        {
            new ScriptExecutor ( this.scriptEngine, initScript, this.classLoader ).execute ( this.scriptContext );
        }

        this.updateCommand = makeScript ( cfg.getString ( "updateCommand" ) ); //$NON-NLS-1$
    }

    private ScriptExecutor makeScript ( final String string ) throws ScriptException
    {
        if ( string == null || string.isEmpty () )
        {
            return null;
        }

        return new ScriptExecutor ( this.scriptEngine, string, this.classLoader );
    }

    public synchronized DataItemValue dataUpdate ( final Map<String, Object> context, final DataItemValue.Builder builder )
    {
        this.demoteImpl.handleDataUpdate ( context, builder );

        this.monitorStateInjector.injectAttributes ( builder );

        return builder.build ();
    }

    protected void handleChange ( final Map<String, DataSourceHandler> sources )
    {
        final Map<String, DataItemValue> values = new HashMap<String, DataItemValue> ( sources.size () );
        for ( final Map.Entry<String, DataSourceHandler> entry : sources.entrySet () )
        {
            values.put ( entry.getKey (), entry.getValue ().getValue () );
        }

        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                evaluate ( values );
            }
        } );
    }

    protected synchronized void evaluate ( final Map<String, DataItemValue> values )
    {
        applyState ( evaluateState ( values ) );
    }

    private synchronized void applyState ( final ScriptMonitorResult evaluateState )
    {
        logger.debug ( "Apply state: {}", evaluateState ); //$NON-NLS-1$
        switch ( evaluateState.monitorStatus )
        {
            case UNSAFE:
                setUnsafe ();
                break;
            case OK:
                setOk ( evaluateState.value, evaluateState.valueTimestamp );
                break;
            case FAILURE:
                setFailure ( evaluateState.value, evaluateState.valueTimestamp, evaluateState.severity, evaluateState.requireAck == null ? true : evaluateState.requireAck );
                break;
            case INACTIVE:
                setInactive ();
                break;
        }
    }

    private ScriptMonitorResult evaluateState ( final Map<String, DataItemValue> values )
    {
        final Map<String, Object> scriptObjects = new HashMap<String, Object> ();

        scriptObjects.put ( "values", values ); //$NON-NLS-1$
        scriptObjects.put ( "UNSAFE", ScriptMonitorResult.UNSAFE ); //$NON-NLS-1$
        scriptObjects.put ( "INACTIVE", ScriptMonitorResult.INACTIVE ); //$NON-NLS-1$
        scriptObjects.put ( "OK", OkBuilder.INSTANCE ); //$NON-NLS-1$
        scriptObjects.put ( "FAILURE", FailureBuilder.INSTANCE ); //$NON-NLS-1$
        scriptObjects.put ( "result", this.lastResult ); //$NON-NLS-1$

        try
        {
            logger.debug ( "Running update command - values: {}", values ); //$NON-NLS-1$
            return convertState ( this.updateCommand.execute ( this.scriptContext, scriptObjects ) );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to evaluate monitor", e ); //$NON-NLS-1$
            return ScriptMonitorResult.UNSAFE;
        }
    }

    private ScriptMonitorResult convertState ( final Object execute )
    {
        logger.debug ( "Converting: {}", execute ); //$NON-NLS-1$

        if ( execute == null )
        {
            return ScriptMonitorResult.UNSAFE;
        }

        if ( execute instanceof ScriptMonitorResult )
        {
            return (ScriptMonitorResult)execute;
        }

        return ScriptMonitorResult.UNSAFE;
    }

    @Override
    protected void setFailure ( final Variant value, final Long valueTimestamp, final Severity severity, final boolean requireAck )
    {
        final Severity result = this.demoteImpl.demoteSeverity ( severity );
        if ( result == null )
        {
            setOk ( value, valueTimestamp );
        }
        else
        {
            super.setFailure ( value, valueTimestamp, result, this.demoteImpl.demoteAck ( requireAck ) );
        }
    }

}
