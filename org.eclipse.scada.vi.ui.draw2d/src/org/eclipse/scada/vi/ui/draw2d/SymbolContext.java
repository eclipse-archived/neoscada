/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jürgen Rose - additional work
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.Parameterization;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantEditor;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.ui.draw2d.primitives.FigureContainerController;
import org.eclipse.scada.vi.ui.draw2d.primitives.ImageController;
import org.eclipse.scada.vi.ui.draw2d.primitives.RectangleController;
import org.eclipse.scada.vi.ui.draw2d.primitives.ShapeController;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.statushandlers.StatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The context object that is exported to the script context
 * 
 * @author Jens Reimann
 * @since 0.17.0
 */
public class SymbolContext
{

    private final static Logger logger = LoggerFactory.getLogger ( SymbolContext.class );

    private final SymbolController controller;

    public SymbolContext ( final SymbolController controller )
    {
        this.controller = controller;
    }

    public Properties getProperties ()
    {
        return this.controller.getProperties ();
    }

    public Map<String, String> getPropertiesAsMap ()
    {
        final Map<String, String> r = new HashMap<String, String> ();
        for ( final Object key : Collections.list ( this.controller.getProperties ().propertyNames () ) )
        {
            r.put ( (String)key, (String)this.controller.getProperties ().getProperty ( (String)key ) );
        }
        return r;
    }

    /**
     * Get an element from this symbol by name
     * 
     * @param name
     *            the name of the symbol to fetch
     * @return returns either a reference to the element controller of
     *         <code>null</code> if the element could not be found.
     * @see org.eclipse.scada.vi.ui.draw2d.primitives
     * @see FigureContainerController
     * @see ImageController
     * @see ShapeController
     * @see RectangleController
     */
    public Object getElement ( final String name )
    {
        return this.controller.getElement ( name );
    }

    public Object getProperty ( final String name )
    {
        return this.controller.getProperties ().getProperty ( name );
    }

    public Object getProperty ( final String name, final String defaultValue )
    {
        return this.controller.getProperties ().getProperty ( name, defaultValue );
    }

    public void registerItem ( final String name, final String itemId, final String connectionId )
    {
        registerItem ( name, itemId, connectionId, false, true );
    }

    public void registerItem ( final String name, final String itemId, final String connectionId, final boolean ignoreSummary, final boolean nullInvalid )
    {
        this.controller.registerItem ( name, itemId, connectionId, ignoreSummary, nullInvalid );
    }

    /**
     * Unregister item for symbol
     * <p>
     * There is no need to unregister items when the symbol is disposed. This
     * will be performed automatically.
     * </p>
     * 
     * @param name
     *            the name of the item (not the id) to unregister
     */
    public void unregisterItem ( final String name )
    {
        this.controller.unregisterItem ( name );
    }

    public void startWrite ( final String connectionId, final String itemId, final Object value ) throws InterruptedException
    {
        this.controller.startWrite ( connectionId, itemId, Variant.valueOf ( value ) );
    }

    public void startWriteString ( final String connectionId, final String itemId, final String value ) throws InterruptedException
    {
        this.controller.startWrite ( connectionId, itemId, VariantEditor.toVariant ( value ) );
    }

    public void startWriteAttributeString ( final String connectionId, final String itemId, final String key, final String value ) throws InterruptedException
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ( 1 );

        attributes.put ( key, VariantEditor.toVariant ( value ) );

        this.controller.startWriteAttributes ( connectionId, itemId, attributes );
    }

    public void startWriteAttribute ( final String connectionId, final String itemId, final String key, final Object value ) throws InterruptedException
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ( 1 );

        attributes.put ( key, Variant.valueOf ( value ) );

        this.controller.startWriteAttributes ( connectionId, itemId, attributes );
    }

    public void startWriteAttributes ( final String connectionId, final String itemId, final Map<String, Variant> attributes ) throws InterruptedException
    {
        this.controller.startWriteAttributes ( connectionId, itemId, attributes );
    }

    public SymbolContext getParent ()
    {
        return this.controller.getParentContext ();
    }

    public SummaryInformation getSummary ()
    {
        return this.controller.getSummaryInformation ();
    }

    /**
     * Execute an Eclipse command
     * 
     * @param commandId
     *            the command to execute
     * @param eventData
     *            the parameter event data (depends on the command)
     */
    public void executeCommand ( final String commandId, final Map<String, String> eventData )
    {
        try
        {
            final ICommandService commandService = (ICommandService)PlatformUI.getWorkbench ().getService ( ICommandService.class );
            final IHandlerService handlerService = (IHandlerService)PlatformUI.getWorkbench ().getService ( IHandlerService.class );

            final Command command = commandService.getCommand ( commandId );

            final Parameterization[] parameterizations = new Parameterization[eventData.size ()];

            int i = 0;
            for ( final Map.Entry<String, String> entry : eventData.entrySet () )
            {
                parameterizations[i] = new Parameterization ( command.getParameter ( entry.getKey () ), entry.getValue () );
                i++;
            }
            final ParameterizedCommand parameterCommand = new ParameterizedCommand ( command, parameterizations );

            handlerService.executeCommand ( parameterCommand, null );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to execute command", e );
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.BLOCK );
        }
    }
}
