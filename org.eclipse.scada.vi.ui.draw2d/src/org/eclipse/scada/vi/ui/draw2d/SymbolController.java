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

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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

import javax.script.ScriptContext;
import javax.script.SimpleScriptContext;

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
import org.eclipse.scada.vi.ui.draw2d.loader.SymbolLoader;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.statushandlers.StatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private final ClassLoader classLoader;

    private final Map<String, Object> elements = new HashMap<String, Object> ();

    private final Map<Primitive, Object> primitives = new HashMap<Primitive, Object> ();

    private RegistrationManager registrationManager;

    private final SymbolData symbolData;

    private Map<String, DataValue> lastData;

    private final Set<SummaryListener> summaryListeners = new LinkedHashSet<SummaryListener> ( 1 );

    private final Map<String, Object> scriptObjects;

    private MessageConsole console;

    private MessageConsole createdConsole;

    private MessageConsoleStream logStream;

    private MessageConsoleStream errorStream;

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

    public SymbolController ( final Shell shell, final SymbolLoader symbolLoader, final Map<String, String> properties, final Map<String, Object> scriptObjects ) throws Exception
    {
        this ( shell, null, symbolLoader, properties, scriptObjects );
    }

    public SymbolController ( final Shell shell, final SymbolController parentController, final SymbolLoader symbolLoader, final Map<String, String> properties, final Map<String, Object> scriptObjects ) throws Exception
    {
        this.shell = shell;
        this.symbolLoader = symbolLoader;
        this.symbolInfoName = symbolLoader.getSourceName ();
        this.parentController = parentController;
        this.classLoader = symbolLoader.getClassLoader ();

        this.generator = org.eclipse.scada.core.ui.styles.Activator.getDefaultStyleGenerator ();

        this.nameHierarchy = makeNameHierarchy ();

        this.symbolData = new SymbolData ( this );
        this.registrationManager = new RegistrationManager ( Activator.getDefault ().getBundle ().getBundleContext (), this.symbolInfoName );
        this.registrationManager.addListener ( this );
        this.registrationManager.open ();

        final Symbol symbol = symbolLoader.loadSymbol ();

        if ( parentController != null )
        {
            this.properties = new Properties ( parentController.getProperties () );
        }
        else
        {
            this.properties = new Properties ();
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

        this.context = new SymbolContext ( this );

        if ( parentController != null )
        {
            parentController.addChild ( this );
        }

        this.scriptContext = new SimpleScriptContext ();
        assignConsole ( this.scriptContext );

        this.scriptContext.setAttribute ( "controller", this.context, ScriptContext.ENGINE_SCOPE ); //$NON-NLS-1$
        this.scriptContext.setAttribute ( "data", this.symbolData, ScriptContext.ENGINE_SCOPE ); //$NON-NLS-1$
        this.scriptContext.setAttribute ( "GSON", createJson (), ScriptContext.ENGINE_SCOPE ); //$NON-NLS-1$
        this.scriptContext.setAttribute ( "styleGenerator", this.generator, ScriptContext.ENGINE_SCOPE ); //$NON-NLS-1$
        this.scriptObjects = scriptObjects;
        addScriptObjects ( scriptObjects );
        if ( parentController != null )
        {
            addScriptObjects ( parentController.getScriptObjects () );
        }

        for ( final String module : symbol.getScriptModules () )
        {
            loadScript ( module );
        }

        this.onInit = new ScriptExecutor ( "JavaScript", symbol.getOnInit (), this.classLoader, "onInit" ); //$NON-NLS-1$
        this.onDispose = new ScriptExecutor ( "JavaScript", symbol.getOnDispose (), this.classLoader, "onDispose" ); //$NON-NLS-1$
        this.onUpdate = new ScriptExecutor ( "JavaScript", symbol.getOnUpdate (), this.classLoader, "onUpdate" ); //$NON-NLS-1$

        this.generator.addListener ( this.generatorListener );
    }

    /**
     * @since 1.1
     */
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

        final MessageConsoleStream writerStream = this.console.newMessageStream ();
        scriptContext.setWriter ( new PrintWriter ( new OutputStreamWriter ( writerStream ) ) );

        this.errorStream = this.console.newMessageStream ();
        this.errorStream.setColor ( Display.getDefault ().getSystemColor ( SWT.COLOR_RED ) );
        scriptContext.setErrorWriter ( new PrintWriter ( new OutputStreamWriter ( this.errorStream ) ) );

        this.logStream = this.console.newMessageStream ();
        this.logStream.setColor ( Display.getDefault ().getSystemColor ( SWT.COLOR_GRAY ) );
    }

    private MessageConsole createOrGetConsole ()
    {
        if ( this.parentController != null && this.parentController.getConsole () != null )
        {
            return this.parentController.getConsole ();
        }

        final IConsoleManager manager = ConsolePlugin.getDefault ().getConsoleManager ();
        final MessageConsole console = new MessageConsole ( String.format ( "Symbol Debug Console: %s", this.symbolInfoName ), null, null, true );
        manager.addConsoles ( new IConsole[] { console } );
        this.createdConsole = console;
        return console;
    }

    protected MessageConsole getConsole ()
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
        this.logStream.println ( String.format ( "Loading script module: %s", module ) );

        final String moduleSource = this.symbolLoader.loadStringResource ( module );

        new ScriptExecutor ( "JavaScript", moduleSource, this.classLoader, module ).execute ( this.scriptContext );
    }

    public void init () throws Exception
    {
        this.onInit.execute ( this.scriptContext );
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
        }

        // close log stream

        if ( this.logStream != null && !this.logStream.isClosed () )
        {
            try
            {
                this.logStream.close ();
            }
            catch ( final IOException e )
            {
                logger.warn ( "Failed to close log stream", e );
            }
            finally
            {
                this.logStream = null;
            }
        }

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

    public Object createProperties ( final String command, final String onCreateProperties, final Map<String, String> currentProperties ) throws Exception
    {
        final ScriptExecutor executor = new ScriptExecutor ( "JavaScript", onCreateProperties, this.classLoader, "onCreateProperties" );
        final Map<String, Object> localProperties = new HashMap<String, Object> ( 1 );
        localProperties.put ( "properties", currentProperties );
        return executor.execute ( this.scriptContext, localProperties );
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
            this.onUpdate.execute ( this.scriptContext );
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.LOG );
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

        return new ScriptExecutor ( "JavaScript", command, this.classLoader, sourceName );
    }

    public void execute ( final ScriptExecutor scriptExecutor, final Map<String, Object> scriptObjects )
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
        final MessageConsoleStream stream = this.console.newMessageStream ();
        final PrintWriter ps = new PrintWriter ( stream );
        ps.println ( string );

        try
        {
            ps.close ();
            stream.close ();
        }
        catch ( final IOException e )
        {
        }
    }

    public void errorLog ( final String string )
    {
        errorLog ( string, null );
    }

    public void errorLog ( final String string, final Exception e )
    {
        final PrintWriter pw = new PrintWriter ( this.errorStream );
        pw.println ( string );
        e.printStackTrace ( pw );
        pw.flush ();
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
