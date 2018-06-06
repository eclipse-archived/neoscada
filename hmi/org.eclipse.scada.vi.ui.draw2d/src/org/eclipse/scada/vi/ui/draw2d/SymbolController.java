/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - fix bug 433409, 437536
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d;

import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.script.ScriptContext;
import javax.script.SimpleScriptContext;

import org.eclipse.emf.common.util.URI;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.ui.styles.StyleGenerator;
import org.eclipse.scada.core.ui.styles.StyleGenerator.GeneratorListener;
import org.eclipse.scada.sec.ui.DisplayCallbackHandler;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.scada.utils.script.ScriptExecutor;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.RegistrationManager;
import org.eclipse.scada.vi.data.RegistrationManager.Listener;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.data.SummaryListener;
import org.eclipse.scada.vi.model.Primitive;
import org.eclipse.scada.vi.model.Symbol;
import org.eclipse.scada.vi.model.TimeTrigger;
import org.eclipse.scada.vi.ui.draw2d.loader.SymbolLoader;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.statushandlers.StatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SymbolController implements Listener
{

    private final static Logger logger = LoggerFactory.getLogger ( SymbolController.class );

    private final SymbolController parentController;

    private final Set<SymbolController> controllers = new LinkedHashSet<SymbolController> ();

    private final ScriptExecutor onInit;

    private final ScriptExecutor onDispose;

    private final ScriptExecutor onUpdate;

    private final Properties properties;

    private final SymbolContext context;

    private final ScriptContext scriptContext;

    private final Map<String, Object> elements = new HashMap<String, Object> ();

    private final Map<Primitive, Object> primitives = new HashMap<Primitive, Object> ();

    private RegistrationManager registrationManager;

    private final SymbolData symbolData;

    private Map<String, DataValue> lastData;

    private final Set<SummaryListener> summaryListeners = new LinkedHashSet<SummaryListener> ( 1 );

    private final Map<String, Object> scriptObjects;

    private ConsoleContext console;

    private MessageConsole createdConsole;

    private final String symbolInfoName;

    private final List<String> nameHierarchy;

    private final GeneratorListener generatorListener = new GeneratorListener () {

        @Override
        public void configurationChanged ()
        {
            generatorConfigurationChanged ();
        }
    };

    private final StyleGenerator generator;

    private final Shell shell;

    private final SymbolLoader symbolLoader;

    private final FactoryContext factoryContext;

    private final ScriptManager scriptManager;

    private ScheduledExecutorService timeTriggerExecutor;

    public SymbolController ( final Shell shell, final SymbolLoader symbolLoader, final Map<String, String> properties, final Map<String, Object> scriptObjects, final FactoryContext factoryContext ) throws Exception
    {
        this ( shell, null, symbolLoader, properties, scriptObjects, factoryContext, new ScriptManager () );
    }

    public SymbolController ( final Shell shell, final SymbolController parentController, final SymbolLoader symbolLoader, final Map<String, String> properties, final Map<String, Object> scriptObjects, final FactoryContext factoryContext ) throws Exception
    {
        this ( shell, parentController, symbolLoader, properties, scriptObjects, factoryContext, parentController.scriptManager );
    }

    private SymbolController ( final Shell shell, final SymbolController parentController, final SymbolLoader symbolLoader, final Map<String, String> properties, final Map<String, Object> scriptObjects, final FactoryContext factoryContext, final ScriptManager scriptManager ) throws Exception
    {
        final Profiler p = new Profiler ( "SymbolController" );

        p.start ( "init" );
        this.shell = shell;
        this.symbolLoader = symbolLoader;
        this.symbolInfoName = symbolLoader.getSourceName ();
        this.parentController = parentController;

        this.factoryContext = factoryContext;

        this.scriptManager = scriptManager;

        this.generator = org.eclipse.scada.core.ui.styles.Activator.getDefaultStyleGenerator ();

        this.nameHierarchy = makeNameHierarchy ();

        p.start ( "data" );
        this.symbolData = new SymbolData ( this );
        this.registrationManager = new RegistrationManager ( Activator.getDefault ().getBundle ().getBundleContext (), this.symbolInfoName );
        this.registrationManager.addListener ( this );
        this.registrationManager.open ();

        p.start ( "load" );
        final Symbol symbol = symbolLoader.loadSymbol ();

        if ( parentController != null )
        {
            this.properties = new Properties ( parentController.getProperties () );
        }
        else
        {
            this.properties = new Properties ();
            this.timeTriggerExecutor = Executors.newSingleThreadScheduledExecutor ();
        }

        for ( final Map.Entry<String, String> entry : symbol.getProperties ().entrySet () )
        {
            if ( entry.getValue () != null )
            {
                this.properties.put ( entry.getKey (), entry.getValue () );
            }
        }

        for ( final Map.Entry<String, String> entry : properties.entrySet () )
        {
            if ( entry.getValue () != null )
            {
                this.properties.put ( entry.getKey (), entry.getValue () );
            }
        }

        p.start ( "ctx" );
        this.context = new SymbolContext ( this );

        if ( parentController != null )
        {
            parentController.addChild ( this );
        }

        p.start ( "console" );
        this.scriptContext = new SimpleScriptContext ();
        assignConsole ( this.scriptContext );

        p.start ( "add scripts" );

        this.scriptContext.setAttribute ( "controller", this.context, ScriptContext.ENGINE_SCOPE ); //$NON-NLS-1$
        this.scriptContext.setAttribute ( "data", this.symbolData, ScriptContext.ENGINE_SCOPE ); //$NON-NLS-1$
        this.scriptContext.setAttribute ( "GSON", createJson (), ScriptContext.ENGINE_SCOPE ); //$NON-NLS-1$
        this.scriptContext.setAttribute ( "styleGenerator", this.generator, ScriptContext.ENGINE_SCOPE ); //$NON-NLS-1$
        // this.scriptContext.setAttribute ( "TimedCountdownCallback", TimedCountdownCallback.class, ScriptContext.ENGINE_SCOPE ); //$NON-NLS-1$
        this.scriptObjects = scriptObjects;
        addScriptObjects ( scriptObjects );
        if ( parentController != null )
        {
            addScriptObjects ( parentController.getScriptObjects () );
        }

        p.start ( "load scripts" );

        for ( final String module : symbol.getScriptModules () )
        {
            loadScript ( module );
        }

        p.start ( "parse" );

        this.onInit = this.scriptManager.parse ( symbol.getOnInit (), "onInit" ); //$NON-NLS-1$
        this.onDispose = this.scriptManager.parse ( symbol.getOnDispose (), "onDispose" ); //$NON-NLS-1$
        this.onUpdate = this.scriptManager.parse ( symbol.getOnUpdate (), "onUpdate" ); //$NON-NLS-1$
        int i = 1;
        for ( final TimeTrigger timeTrigger : symbol.getTimeTriggers () )
        {
            final ScriptExecutor timerScript = this.scriptManager.parse ( timeTrigger.getOnTrigger (), "onTimeTrigger" + ( i++ ) );
            addTimeTrigger ( timeTrigger.getPeriod (), timerScript );
        }

        p.start ( "add listener" );
        this.generator.addListener ( this.generatorListener );
        // p.stop ().print ();
    }

    public Shell getShell ()
    {
        return this.shell;
    }

    protected void generatorConfigurationChanged ()
    {
        runUpdate ( true );
    }

    private List<String> makeNameHierarchy ()
    {
        final List<String> result = new LinkedList<String> ();
        SymbolController current = this;
        while ( current != null )
        {
            result.add ( 0, current.symbolInfoName );
            current = current.parentController;
        }
        return Collections.unmodifiableList ( result );
    }

    private void assignConsole ( final ScriptContext scriptContext )
    {
        this.console = createOrGetConsole ();

        // scriptContext.setReader ( new InputStreamReader ( this.console.getInputStream () ) );

        /* wrapping into a PrintWriter is necessary due to
         * http://bugs.sun.com/view_bug.do?bug_id=6759414
         * */

        this.console.applyTo ( scriptContext );
    }

    private ConsoleContext createOrGetConsole ()
    {
        if ( this.parentController != null && this.parentController.getConsole () != null )
        {
            return this.parentController.getConsole ();
        }

        final IConsoleManager manager = ConsolePlugin.getDefault ().getConsoleManager ();
        final MessageConsole messageConsole = new MessageConsole ( String.format ( "Symbol Debug Console: %s", this.symbolInfoName ), null, null, true );
        manager.addConsoles ( new IConsole[] { messageConsole } );
        this.createdConsole = messageConsole;
        return new ConsoleContext ( messageConsole );
    }

    protected ConsoleContext getConsole ()
    {
        if ( this.console != null )
        {
            return this.console;
        }
        else
        {
            return null;
        }
    }

    private Gson createJson ()
    {
        return new GsonBuilder ().serializeNulls ().setDateFormat ( "yyyy-MM-dd hh:mm:ss.SSS" ).create ();
    }

    private void addScriptObjects ( final Map<String, Object> scriptObjects )
    {
        if ( scriptObjects != null )
        {
            for ( final Map.Entry<String, Object> entry : scriptObjects.entrySet () )
            {
                this.scriptContext.setAttribute ( entry.getKey (), entry.getValue (), ScriptContext.ENGINE_SCOPE );
            }
        }
    }

    public Map<String, Object> getScriptObjects ()
    {
        return this.scriptObjects;
    }

    private void loadScript ( final String module ) throws Exception
    {
        this.console.getLogStream ().println ( String.format ( "Loading script module: %s", module ) );

        // fire load event

        try
        {
            final String uri = this.symbolLoader.resolveUri ( module );
            this.factoryContext.loadedResource ( URI.createURI ( uri ) );
        }
        catch ( final Exception e )
        {
        }

        // load

        final String moduleSource = this.symbolLoader.loadStringResource ( module );
        final ScriptExecutor s = this.scriptManager.parse ( moduleSource, module );
        if ( s != null )
        {
            s.execute ( this.scriptContext );
        }
    }

    private void addTimeTrigger ( final long period, final ScriptExecutor script )
    {
        SymbolController root = this.getRootController ();
        if ( root == null || root.timeTriggerExecutor == null )
        {
            return;
        }
        root.timeTriggerExecutor.scheduleAtFixedRate ( new Runnable () {
            @Override
            public void run ()
            {
                executeTimeTrigger ( script );
            }
        }, period, period, TimeUnit.MILLISECONDS );
    }

    protected void executeTimeTrigger ( final ScriptExecutor script )
    {
        logger.trace ( "Schedule time trigger: {}", this.nameHierarchy );
        try
        {
            Display.getDefault ().asyncExec ( new Runnable () {
                @Override
                public void run ()
                {
                    handleTimeTrigger ( script );
                };
            } );
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }
    }

    protected void handleTimeTrigger ( final ScriptExecutor script )
    {
        logger.trace ( "Running time trigger: {}", this.nameHierarchy );
        try
        {
            if ( script != null )
            {
                script.execute ( this.scriptContext );
            }
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.LOG );
            errorLog ( "Failed to run update", e );
        }
    }

    public void init () throws Exception
    {
        if ( this.onInit != null )
        {
            try
            {
                this.onInit.execute ( this.scriptContext );
            }
            catch ( final Exception e )
            {
                errorLog ( "Failed to run init", e );
                throw new InvocationTargetException ( e );
            }
        }
        for ( final SymbolController controller : this.controllers )
        {
            controller.init ();
        }
    }

    public Properties getProperties ()
    {
        return this.properties;
    }

    protected void addChild ( final SymbolController controller )
    {
        this.controllers.add ( controller );
    }

    protected void removeChild ( final SymbolController controller )
    {
        this.controllers.remove ( controller );
    }

    public void dispose ()
    {
        if ( this.timeTriggerExecutor != null )
        {
            try
            {
                this.timeTriggerExecutor.shutdownNow ();
            }
            catch ( Exception e )
            {
                logger.warn ( "Shutdown of scheduler failed", e );
            }
        }
        // run onDispose ... when requested
        try
        {
            if ( this.onDispose != null )
            {
                this.onDispose.execute ( this.scriptContext );
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to dispose", e );
        }

        // unregister from generator
        this.generator.removeListener ( this.generatorListener );
        this.generator.dispose ();

        // close console

        if ( this.createdConsole != null )
        {
            ConsolePlugin.getDefault ().getConsoleManager ().removeConsoles ( new IConsole[] { this.createdConsole } );
            this.createdConsole = null;

            this.console.dispose ();
        }

        // close log stream

        if ( this.parentController != null )
        {
            this.parentController.removeChild ( this );
        }

        // dispose childs
        final ArrayList<SymbolController> controllers = new ArrayList<SymbolController> ( this.controllers );
        for ( final SymbolController controller : controllers )
        {
            controller.dispose ();
        }
        this.controllers.clear ();

        // dispose registration manager

        if ( this.registrationManager != null )
        {
            this.registrationManager.dispose ();
            this.registrationManager = null;
        }
    }

    public void createProperties ( final String command, final String onCreateProperties, final Map<String, String> currentProperties ) throws Exception
    {
        final ScriptExecutor executor = this.scriptManager.parse ( onCreateProperties, "onCreateProperties" );
        if ( executor == null )
        {
            return;
        }

        final Map<String, Object> localProperties = new HashMap<String, Object> ( 1 );
        localProperties.put ( "properties", currentProperties );
        executor.execute ( this.scriptContext, localProperties );
    }

    public Object getElement ( final String name )
    {
        return this.elements.get ( name );
    }

    public Object getElement ( final Primitive primitive )
    {
        return this.primitives.get ( primitive );
    }

    public void addRawElement ( final String name, final Object element )
    {
        if ( name == null )
        {
            return;
        }
        this.elements.put ( name, element );
    }

    public void addElement ( final Primitive primitive, final Object element )
    {
        if ( primitive == null )
        {
            return;
        }

        if ( primitive.getName () != null )
        {
            this.elements.put ( primitive.getName (), element );
        }
        this.primitives.put ( primitive, element );
    }

    public void removeElement ( final Primitive primitive )
    {
        if ( primitive == null )
        {
            return;
        }
        this.primitives.remove ( primitive );
        this.elements.remove ( primitive.getName () );
    }

    public void unregisterItem ( final String name )
    {
        this.registrationManager.unregisterItem ( name );
    }

    public void registerItem ( final String name, final String itemId, final String connectionId, final boolean ignoreSummary, final boolean nullInvalid )
    {
        this.registrationManager.registerItem ( name, itemId, connectionId, ignoreSummary, nullInvalid );
    }

    /**
     * Trigger the controller to update the data from the registration manager
     * <p>
     * This method can be called from any thread and must synchronized to the UI
     * </p>
     */
    @Override
    public void triggerDataUpdate ()
    {
        try
        {
            Display.getDefault ().asyncExec ( new Runnable () {
                @Override
                public void run ()
                {
                    handleDataUpdate ();
                };
            } );
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }
    }

    public Map<String, DataValue> getRegistrationManagerData ()
    {
        return this.registrationManager.getData ();
    }

    public SummaryInformation getSummaryInformation ()
    {
        return new SummaryInformation ( this.nameHierarchy, this.registrationManager.getData (), collectChildrenData () );
    }

    private SymbolController getRootController ()
    {
        SymbolController result = this;
        for ( ;; )
        {
            if ( result.parentController == null || result.parentController == result )
            {
                break;
            }
            result = result.parentController;
        }
        return result;
    }

    private Collection<SummaryInformation> collectChildrenData ()
    {
        final Collection<SummaryInformation> result = new LinkedList<SummaryInformation> ();

        for ( final SymbolController controller : this.controllers )
        {
            result.add ( controller.getSummaryInformation () );
        }

        return result;
    }

    protected void handleDataUpdate ()
    {
        if ( this.registrationManager == null )
        {
            // dispose?
            return;
        }

        final Map<String, DataValue> currentData = this.registrationManager.getData ();
        if ( currentData == this.lastData )
        {
            return;
        }
        this.lastData = currentData;

        runUpdate ( false );
    }

    private void runUpdate ( final boolean ignoreParents )
    {
        logger.debug ( "Running update: {}", this.nameHierarchy );
        try
        {
            if ( this.onUpdate != null )
            {
                this.onUpdate.execute ( this.scriptContext );
            }
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.LOG );
            errorLog ( "Failed to run update", e );
        }
        notifySummaryListeners ();

        // propagate update
        if ( !ignoreParents && this.parentController != null )
        {
            this.parentController.runUpdate ( false );
        }
    }

    protected void notifySummaryListeners ()
    {
        if ( this.summaryListeners.isEmpty () )
        {
            return;
        }

        final SummaryInformation info = getSummaryInformation ();

        logger.debug ( "notify summary: {}", info );

        for ( final SummaryListener listener : this.summaryListeners )
        {
            logger.debug ( "notify to: {}", listener );
            listener.summaryChanged ( info );
        }
    }

    public void addSummaryListener ( final SummaryListener listener )
    {
        if ( this.summaryListeners.add ( listener ) )
        {
            listener.summaryChanged ( getSummaryInformation () );
        }
    }

    public void removeSummaryListener ( final SummaryListener listener )
    {
        this.summaryListeners.remove ( listener );
    }

    public ScriptExecutor createScriptExecutor ( final String command, final String sourceName ) throws Exception
    {
        if ( command == null || command.isEmpty () )
        {
            return null;
        }

        return this.scriptManager.parse ( command, sourceName );
    }

    public void execute ( final ScriptExecutor scriptExecutor, final Map<String, Object> scriptObjects ) throws Exception
    {
        if ( scriptExecutor == null )
        {
            return;
        }

        try
        {
            scriptExecutor.execute ( this.scriptContext, scriptObjects );
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.LOG );
            throw new InvocationTargetException ( e );
        }
    }

    public void startWrite ( final String connectionId, final String itemId, final Variant value ) throws InterruptedException
    {
        this.registrationManager.startWrite ( connectionId, itemId, value, new DisplayCallbackHandler ( this.shell, "Confirm", "Confirm write operation" ) );
    }

    public void startWriteAttributes ( final String connectionId, final String itemId, final Map<String, Variant> attributes ) throws InterruptedException
    {
        this.registrationManager.startWriteAttributes ( connectionId, itemId, attributes, new DisplayCallbackHandler ( this.shell, "Confirm", "Confirm write operation" ) );
    }

    public void debugLog ( final String string )
    {
        this.console.getLogStream ().println ( string );
    }

    public void errorLog ( final String string )
    {
        errorLog ( string, null );
    }

    public void errorLog ( final String string, final Throwable e )
    {
        final PrintWriter epw = this.console.getErrorPrintWriter ();

        epw.println ( string );
        if ( e != null )
        {
            e.printStackTrace ( epw );
        }
        epw.flush ();
    }

    protected SymbolContext getContext ()
    {
        return this.context;
    }

    public SymbolContext getParentContext ()
    {
        if ( this.parentController != null )
        {
            return this.parentController.getContext ();
        }
        else
        {
            return null;
        }
    }

}
