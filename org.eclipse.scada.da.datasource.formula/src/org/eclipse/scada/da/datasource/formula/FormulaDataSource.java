/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.datasource.formula;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.NotConvertableException;
import org.eclipse.scada.core.NullValueException;
import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantType;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.datasource.DataSourceHandler;
import org.eclipse.scada.da.datasource.SingleDataSourceTracker;
import org.eclipse.scada.da.datasource.SingleDataSourceTracker.ServiceListener;
import org.eclipse.scada.da.datasource.base.AbstractMultiSourceDataSource;
import org.eclipse.scada.utils.concurrent.AbstractFuture;
import org.eclipse.scada.utils.concurrent.FutureListener;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A datasource that calculates based on input and/or output formula
 * 
 * @author Jens Reimann
 */
public class FormulaDataSource extends AbstractMultiSourceDataSource
{
    private static final String DEFAULT_ENGINE_NAME = System.getProperty ( "org.eclipse.scada.da.datasource.formula.defaultScriptEngine", "JavaScript" );

    final static Logger logger = LoggerFactory.getLogger ( FormulaDataSource.class );

    private final ScheduledExecutorService executor;

    private final ScriptEngineManager manager;

    private SimpleScriptContext scriptContext;

    private String inputFormula;

    private volatile String outputFormula;

    private ScriptEngine scriptEngine;

    private final ClassLoader classLoader;

    private volatile DataSource outputDataSource;

    private SingleDataSourceTracker outputItemTracker;

    private final ServiceListener outputListener;

    private String writeValueName;

    private CompiledScript inputScript;

    private CompiledScript outputScript;

    private boolean precompile;

    private VariantType outputDatasourceType;

    private final ObjectPoolTracker<DataSource> poolTracker;

    public FormulaDataSource ( final BundleContext context, final ObjectPoolTracker<DataSource> poolTracker, final ScheduledExecutorService executor )
    {
        super ( poolTracker );
        this.poolTracker = poolTracker;

        this.outputListener = new ServiceListener () {

            @Override
            public void dataSourceChanged ( final DataSource dataSource )
            {
                setOutputDataSource ( dataSource );
            }
        };

        this.executor = executor;

        this.classLoader = getClass ().getClassLoader ();

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

    }

    protected void setOutputDataSource ( final DataSource dataSource )
    {
        this.outputDataSource = dataSource;
    }

    @Override
    protected Executor getExecutor ()
    {
        return this.executor;
    }

    @Override
    public NotifyFuture<WriteAttributeResults> startWriteAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        final DataSource outputDataSource = this.outputDataSource;
        if ( outputDataSource != null )
        {
            return outputDataSource.startWriteAttributes ( attributes, operationParameters );
        }
        else
        {
            return new InstantErrorFuture<WriteAttributeResults> ( new OperationException ( "Output not connected" ) );
        }
    }

    private final class WriteFuture extends AbstractFuture<WriteResult> implements Runnable
    {
        private final Variant value;

        private final OperationParameters operationParameters;

        public WriteFuture ( final Variant value, final OperationParameters operationParameters )
        {
            this.value = value;
            this.operationParameters = operationParameters;
        }

        @Override
        public void run ()
        {
            try
            {
                final NotifyFuture<WriteResult> future = processWrite ( this.value, this.operationParameters );
                future.addListener ( new FutureListener<WriteResult> () {

                    @Override
                    public void complete ( final Future<WriteResult> future )
                    {
                        try
                        {
                            setResult ( future.get () );
                        }
                        catch ( final Throwable e )
                        {
                            setError ( e );
                        }
                    }
                } );
            }
            catch ( final Throwable e )
            {
                setError ( e );
            }
        }

    }

    @Override
    public NotifyFuture<WriteResult> startWriteValue ( final Variant value, final OperationParameters operationParameters )
    {
        final WriteFuture write = new WriteFuture ( value, operationParameters );
        getExecutor ().execute ( write );
        return write;
    }

    protected NotifyFuture<WriteResult> processWrite ( final Variant writeValue, final OperationParameters operationParameters ) throws Exception
    {
        // first check for pre-conditions .. can be done outside the lock
        final String outputFormula = this.outputFormula;
        final DataSource outputDataSource = this.outputDataSource;

        if ( outputFormula == null || this.outputFormula.isEmpty () )
        {
            throw new OperationException ( "Output direction not supported by this item" );
        }

        if ( outputDataSource == null )
        {
            throw new OperationException ( "Output item not connected" );
        }

        if ( writeValue == null )
        {
            return new InstantFuture<WriteResult> ( WriteResult.OK );
        }

        synchronized ( this )
        {

            final Serializable writeValueObject = writeValue.as ( this.outputDatasourceType );
            logger.debug ( "Converted write value from '{}' to '{}'", writeValue, writeValueObject );

            final Map<String, DataSourceHandler> sources = getSourcesCopy ();

            final Map<String, Object> values = new HashMap<String, Object> ( sources.size () );

            int error = 0;

            // gather all data
            for ( final Map.Entry<String, DataSourceHandler> entry : sources.entrySet () )
            {
                final VariantType type = entry.getValue ().getType ();
                final DataItemValue value = entry.getValue ().getValue ();

                if ( value.isError () )
                {
                    error++;
                }

                final Variant variantValue = value.getValue ();

                if ( variantValue != null )
                {
                    values.put ( entry.getKey (), variantValue.as ( type ) );
                }
                else
                {
                    values.put ( entry.getKey (), null );
                }
            }

            if ( error > 0 )
            {
                throw new OperationException ( String.format ( "Failed to write. %s input(s) are in 'error' state", error ) );
            }

            for ( final Map.Entry<String, Object> entry : values.entrySet () )
            {
                this.scriptContext.setAttribute ( entry.getKey (), entry.getValue (), ScriptContext.ENGINE_SCOPE );
            }

            this.scriptContext.setAttribute ( this.writeValueName, writeValueObject, ScriptContext.ENGINE_SCOPE );

            // execute outputFormula
            final Object o = executeScript ( outputFormula, this.outputScript );
            logger.debug ( "Result of output script: {}", o );
            final Variant result = Variant.valueOf ( o );

            return outputDataSource.startWriteValue ( result, operationParameters );
        }
    }

    public synchronized void update ( final Map<String, String> parameters ) throws Exception
    {
        final ClassLoader currentClassLoader = Thread.currentThread ().getContextClassLoader ();
        try
        {
            final ClassLoader classLoader = getClass ().getClassLoader ();
            Thread.currentThread ().setContextClassLoader ( classLoader );

            final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

            this.precompile = cfg.getBoolean ( "precompile", true );
            setScript ( cfg );
            setDataSources ( parameters );
            this.outputDatasourceType = getType ( cfg.getString ( "outputDatasource.type", null ) );
            setOutputDataSource ( cfg.getString ( "outputDatasource.id", null ) );
            this.writeValueName = cfg.getString ( "writeValueName", "writeValue" );

            handleChange ( getSourcesCopy () );
        }
        finally
        {
            Thread.currentThread ().setContextClassLoader ( currentClassLoader );
        }
    }

    private static final class InitCode implements Comparable<InitCode>
    {
        private final int order;

        private final String code;

        public InitCode ( final int order, final String code )
        {
            super ();
            this.order = order;
            this.code = code;
        }

        public String getCode ()
        {
            return this.code;
        }

        public int getOrder ()
        {
            return this.order;
        }

        @Override
        public int compareTo ( final InitCode o )
        {
            return Integer.valueOf ( this.order ).compareTo ( o.order );
        }

    }

    private void setScript ( final ConfigurationDataHelper cfg ) throws ScriptException
    {
        String engine = cfg.getString ( "engine", DEFAULT_ENGINE_NAME );
        if ( engine.isEmpty () )
        {
            engine = DEFAULT_ENGINE_NAME;
        }

        this.scriptContext = new SimpleScriptContext ();

        this.scriptEngine = this.manager.getEngineByName ( engine );
        if ( this.scriptEngine == null )
        {
            throw new IllegalArgumentException ( String.format ( "'%s' is not a valid script engine", engine ) );
        }

        // trigger init scripts
        final Queue<InitCode> init = new PriorityQueue<FormulaDataSource.InitCode> ();
        for ( final Map.Entry<String, String> entry : cfg.getPrefixed ( "init." ).entrySet () )
        {
            init.add ( new InitCode ( Integer.valueOf ( entry.getKey () ), entry.getValue () ) );
        }

        while ( !init.isEmpty () )
        {
            final InitCode entry = init.poll ();
            logger.debug ( "Initializing #{}", entry.getOrder () );
            this.scriptEngine.eval ( entry.getCode (), this.scriptContext );
        }

        this.inputFormula = cfg.getString ( "inputFormula" );
        this.outputFormula = cfg.getString ( "outputFormula" );
        this.inputScript = null;
        this.outputScript = null;

        // pre-compile scripts if possible
        if ( this.scriptEngine instanceof Compilable && this.precompile )
        {
            logger.debug ( "Using precompiled scripts" );

            final Compilable compilable = (Compilable)this.scriptEngine;

            if ( this.inputFormula != null && this.inputFormula.isEmpty () )
            {
                this.inputScript = compilable.compile ( this.inputFormula );
            }
            if ( this.outputFormula != null && this.outputFormula.isEmpty () )
            {
                this.outputScript = compilable.compile ( this.outputFormula );
            }
        }

    }

    private static void incMap ( final String key, final Map<String, Integer> map )
    {
        Integer value = map.get ( key );
        if ( value == null )
        {
            value = 0;
        }
        value++;
        map.put ( key, value );
    }

    /**
     * Handle data change
     */
    @Override
    protected synchronized void handleChange ( final Map<String, DataSourceHandler> sources )
    {
        if ( this.inputFormula == null || this.inputFormula.isEmpty () )
        {
            updateData ( null );
            return;
        }

        try
        {
            final Map<String, Integer> flags = new HashMap<String, Integer> ( 4 );
            final Map<String, Object> values = new HashMap<String, Object> ( sources.size () );

            gatherData ( sources, flags, values );

            for ( final Map.Entry<String, Object> entry : values.entrySet () )
            {
                this.scriptContext.setAttribute ( entry.getKey (), entry.getValue (), ScriptContext.ENGINE_SCOPE );
            }

            // execute inputFormula
            executeScript ( this.inputFormula, this.inputScript, flags );
        }
        catch ( final Throwable e )
        {
            logger.info ( "Failed to evaluate", e );
            logger.debug ( "Failed script: {}", this.inputFormula );
            setError ( e );
        }
    }

    private void gatherData ( final Map<String, DataSourceHandler> sources, final Map<String, Integer> flags, final Map<String, Object> values ) throws NullValueException, NotConvertableException
    {
        // gather all data
        for ( final Map.Entry<String, DataSourceHandler> entry : sources.entrySet () )
        {
            final VariantType type = entry.getValue ().getType ();
            final DataItemValue value = entry.getValue ().getValue ();

            if ( value.isAlarm () )
            {
                incMap ( "alarm", flags );
            }
            if ( value.isError () )
            {
                incMap ( "error", flags );
            }
            if ( value.isWarning () )
            {
                incMap ( "warning", flags );
            }
            if ( value.isManual () )
            {
                incMap ( "manual", flags );
            }

            final Variant variantValue = value.getValue ();

            if ( variantValue != null )
            {
                values.put ( entry.getKey (), variantValue.as ( type ) );
            }
            else
            {
                values.put ( entry.getKey (), null );
            }
        }
    }

    protected Object executeScript ( final String command, final CompiledScript compiledScript ) throws ScriptException
    {
        if ( command == null )
        {
            return null;
        }

        final ClassLoader currentClassLoader = Thread.currentThread ().getContextClassLoader ();

        try
        {
            Thread.currentThread ().setContextClassLoader ( this.classLoader );

            if ( compiledScript != null )
            {
                return compiledScript.eval ( this.scriptContext );
            }
            else
            {
                return this.scriptEngine.eval ( command, this.scriptContext );
            }
        }
        finally
        {
            Thread.currentThread ().setContextClassLoader ( currentClassLoader );
        }
    }

    protected void executeScript ( final String command, final CompiledScript compiledScript, final Map<String, Integer> flags ) throws Exception
    {
        if ( command == null )
        {
            return;
        }

        setResult ( executeScript ( command, compiledScript ), flags );
    }

    private synchronized void setError ( final Throwable e )
    {
        final Builder builder = new DataItemValue.Builder ();
        builder.setValue ( Variant.NULL );
        builder.setTimestamp ( Calendar.getInstance () );
        builder.setAttribute ( "formula.error", Variant.TRUE );
        if ( e != null )
        {
            builder.setAttribute ( "formula.error.class", Variant.valueOf ( e.getClass ().getName () ) );
            builder.setAttribute ( "formula.error.message", Variant.valueOf ( e.getMessage () ) );
        }
        updateData ( builder.build () );
    }

    private synchronized void setResult ( final Object result, final Map<String, Integer> flags )
    {
        logger.debug ( "Setting result: {}", result );

        final Builder builder = new DataItemValue.Builder ();
        builder.setSubscriptionState ( SubscriptionState.CONNECTED );
        builder.setValue ( Variant.valueOf ( result ) );

        for ( final Map.Entry<String, Integer> entry : flags.entrySet () )
        {
            builder.setAttribute ( String.format ( "formula.source.%s", entry.getKey () ), Variant.valueOf ( entry.getValue () > 0 ) );
            builder.setAttribute ( String.format ( "formula.source.%s.count", entry.getKey () ), Variant.valueOf ( entry.getValue () ) );
        }

        updateData ( builder.build () );
    }

    protected synchronized void setOutputDataSource ( final String dataSourceId ) throws InvalidSyntaxException
    {
        // disconnect
        if ( this.outputItemTracker != null )
        {
            this.outputItemTracker.close ();
            this.outputItemTracker = null;
        }

        // connect
        this.outputItemTracker = new SingleDataSourceTracker ( this.poolTracker, dataSourceId, this.outputListener );
        this.outputItemTracker.open ();
    }

}
