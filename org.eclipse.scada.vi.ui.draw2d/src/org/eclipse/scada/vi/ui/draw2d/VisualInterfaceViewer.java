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
 *     IBH SYSTEMS GmbH - add factory context
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.ScalableLayeredPane;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionDimension;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.data.SummaryListener;
import org.eclipse.scada.vi.data.SummaryProvider;
import org.eclipse.scada.vi.model.Primitive;
import org.eclipse.scada.vi.model.Symbol;
import org.eclipse.scada.vi.ui.draw2d.loader.StaticSymbolLoader;
import org.eclipse.scada.vi.ui.draw2d.loader.SymbolLoader;
import org.eclipse.scada.vi.ui.draw2d.loader.XMISymbolLoader;
import org.eclipse.scada.vi.ui.draw2d.preferences.PreferenceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.statushandlers.StatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

public class VisualInterfaceViewer extends Composite implements SummaryProvider
{

    private final static Logger logger = LoggerFactory.getLogger ( VisualInterfaceViewer.class );

    private final BasicViewElementFactory factory;

    private final FigureCanvas canvas;

    private final LocalResourceManager manager;

    private SymbolController controller;

    private final Map<String, Object> scriptObjects;

    private final Map<String, String> initialProperties;

    private Boolean zooming;

    private ScalableLayeredPane pane;

    private IFigure figure;

    private Symbol symbol;

    private Layer layer;

    private ConnectionLayer connectionLayer;

    private final Set<org.eclipse.emf.common.util.URI> loadedResources = new HashSet<> ();

    private final FactoryContext factoryContext;

    /**
     * Create a new viewer
     *
     * @param parent
     *            the parent composite
     * @param style
     *            the composite style
     * @param uri
     *            the URI from which the root symbol should be loaded
     * @param scriptObjects
     *            optionally some script objects that get injected into the
     *            script context. May be <code>null</code>.
     * @param properties
     *            additional properties for symbol creation. May be
     *            <code>null</code>. These properties override the symbols
     *            properties.
     */
    public VisualInterfaceViewer ( final Composite parent, final int style, final URI uri, final Map<String, Object> scriptObjects, final Map<String, String> properties )
    {
        this ( parent, style, uri.toString (), scriptObjects, properties );
    }

    /**
     * Create a new viewer
     *
     * @param parent
     *            the parent composite
     * @param style
     *            the composite style
     * @param uri
     *            the URI from which the root symbol should be loaded
     * @param scriptObjects
     *            optionally some script objects that get injected into the
     *            script context. May be <code>null</code>
     * @param properties
     *            additional properties for symbol creation. May be
     *            <code>null</code>. These properties override the symbols
     *            properties.
     */
    public VisualInterfaceViewer ( final Composite parent, final int style, final String uri, final Map<String, Object> scriptObjects, final Map<String, String> properties )
    {
        this ( parent, style, new XMISymbolLoader ( uri ), scriptObjects, properties );
    }

    public VisualInterfaceViewer ( final Composite parent, final int style, final Symbol symbol, final Map<String, Object> scriptObjects, final Map<String, String> properties )
    {
        this ( parent, style, new StaticSymbolLoader ( symbol ), scriptObjects, properties );
    }

    public VisualInterfaceViewer ( final Composite parent, final int style, final SymbolLoader symbolLoader, final Map<String, Object> scriptObjects, final Map<String, String> properties )
    {
        this ( parent, style, symbolLoader, scriptObjects, properties, null );
    }

    public VisualInterfaceViewer ( final Composite parent, final int style, final SymbolLoader symbolLoader, final Map<String, Object> scriptObjects, final Map<String, String> properties, final FactoryContext factoryContext )
    {
        super ( parent, style );

        final Profiler p = new Profiler ( "VisualInterfaceViewer" );

        p.start ( "init" );

        this.initialProperties = properties == null ? Collections.<String, String> emptyMap () : properties;
        this.scriptObjects = scriptObjects;

        this.factoryContext = factoryContext;

        p.start ( "rm" );

        this.manager = new LocalResourceManager ( JFaceResources.getResources () );

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                internalDispose ();
            }
        } );

        setLayout ( new FillLayout () );
        this.canvas = createCanvas ();
        setZooming ( null );

        p.start ( "new factory" );

        this.factory = new BasicViewElementFactory ( this.canvas, this.manager, symbolLoader, this.factoryContext );

        try
        {
            p.start ( "create pane" );
            this.pane = createPane ();
            this.layer = new Layer ();
            this.connectionLayer = new ConnectionLayer ();
            this.connectionLayer.setConnectionRouter ( new ManhattanConnectionRouter () );
            this.layer.setLayoutManager ( new StackLayout () );
            this.pane.add ( this.connectionLayer );
            this.pane.add ( this.layer );

            p.start ( "load" );
            this.symbol = symbolLoader.loadSymbol ();
            p.start ( "create" );
            create ( symbolLoader );
            p.start ( "apply" );
            applyColor ( this.symbol );
            applyImage ( this.symbol, symbolLoader );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to create view", e );
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );

            this.canvas.setContents ( Helper.createErrorFigure ( e ) );
        }
        p.stop ().print ();
    }

    /**
     * Gets the loaded resources <br/>
     * Note that this method does not return the symbol resource which was
     * passed to the constructor. Only the resources loaded by building up that
     * symbol. <br/>
     * Also if the process of loading and building the symbol fails, the list if
     * resources may be incomplete.
     *
     * @return the loaded resources
     */
    public Set<org.eclipse.emf.common.util.URI> getResources ()
    {
        return this.loadedResources;
    }

    private ScalableLayeredPane createPane ()
    {
        return new org.eclipse.draw2d.ScalableLayeredPane ();
    }

    public boolean isZooming ()
    {
        if ( this.zooming == null )
        {
            return Activator.getDefault ().getPreferenceStore ().getBoolean ( PreferenceConstants.P_DEFAULT_ZOOMING );
        }
        else
        {
            return this.zooming;
        }
    }

    public void setZooming ( final Boolean zooming )
    {
        this.zooming = zooming;
        this.canvas.setScrollBarVisibility ( isZooming () ? FigureCanvas.NEVER : FigureCanvas.AUTOMATIC );
    }

    private void applyColor ( final Symbol symbol )
    {
        final RGB color = org.eclipse.scada.vi.ui.draw2d.primitives.Helper.makeColor ( symbol.getBackgroundColor () );
        if ( color != null )
        {
            this.canvas.setBackground ( this.manager.createColor ( color ) );
        }
    }

    private void applyImage ( final Symbol symbol, final SymbolLoader symbolLoader )
    {
        if ( symbol.getBackgroundImage () == null || symbol.getBackgroundImage ().isEmpty () )
        {
            return;
        }

        logInfo ( "Trying to load background image: " + symbol.getBackgroundImage () );
        final String uriString = symbolLoader.resolveUri ( symbol.getBackgroundImage () );

        final org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createURI ( uriString );
        this.loadedResources.add ( uri );
        try
        {
            final Image img = this.manager.createImageWithDefault ( ImageDescriptor.createFromURL ( new URL ( uriString ) ) );
            this.canvas.setBackgroundImage ( img );
        }
        catch ( final MalformedURLException e )
        {
            logError ( "Loading background image: " + uriString, e ); //$NON-NLS-1$
        }
    }

    private void logInfo ( final String string )
    {
        if ( this.controller != null )
        {
            this.controller.debugLog ( string );
        }
    }

    private void logError ( final String string, final Throwable e )
    {
        if ( this.controller != null )
        {
            this.controller.errorLog ( string, e );
        }
    }

    protected FigureCanvas createCanvas ()
    {
        final FigureCanvas canvas = new FigureCanvas ( this, SWT.H_SCROLL | SWT.V_SCROLL | SWT.NO_REDRAW_RESIZE );

        addControlListener ( new ControlAdapter () {
            @Override
            public void controlResized ( final ControlEvent e )
            {
                handleResize ( getBounds () );
            }
        } );

        return canvas;
    }

    protected void handleResize ( final Rectangle bounds )
    {
        if ( !isZooming () )
        {
            final org.eclipse.draw2d.geometry.Rectangle r = new org.eclipse.draw2d.geometry.Rectangle ( bounds.x, bounds.y, bounds.width, bounds.height );
            this.connectionLayer.setPreferredSize ( r.getSize () );

            setZoom ( 1.0 );
            return;
        }

        final Dimension prefSize = getPreferredSize ( bounds );

        final double ar = prefSize.preciseWidth () / prefSize.preciseHeight ();

        double newHeight = bounds.width / ar;
        final double zoom;

        if ( newHeight > bounds.height )
        {
            newHeight = bounds.height;
        }

        zoom = newHeight / prefSize.preciseHeight ();
        setZoom ( zoom );
    }

    private Dimension getPreferredSize ( final Rectangle bounds )
    {
        if ( this.symbol != null && this.symbol.getDesignSize () != null )
        {
            return new PrecisionDimension ( this.symbol.getDesignSize ().getWidth (), this.symbol.getDesignSize ().getHeight () );
        }
        else if ( this.figure != null )
        {
            return this.figure.getPreferredSize ( bounds.width, bounds.height );
        }
        else
        {
            return new PrecisionDimension ( bounds.width, bounds.height );
        }
    }

    private void setZoom ( final double newZoom )
    {
        if ( this.pane instanceof org.eclipse.draw2d.ScalableLayeredPane )
        {
            this.pane.setScale ( newZoom );
        }
    }

    protected void create ( final SymbolLoader symbolLoader )
    {
        try
        {
            final Map<String, String> properties = new HashMap<String, String> ( this.symbol.getProperties ().size () );
            for ( final Map.Entry<String, String> entry : this.symbol.getProperties ().entrySet () )
            {
                properties.put ( entry.getKey (), entry.getValue () );
            }
            properties.putAll ( this.initialProperties );

            this.controller = new SymbolController ( getShell (), symbolLoader, properties, this.scriptObjects, this.factoryContext );

            final Controller controller = create ( this.symbol.getRoot () );

            this.controller.init ();

            this.layer.add ( this.figure = controller.getFigure () );

            this.factory.createConnections ( this.connectionLayer, this.controller, this.symbol.getConnections () );

        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.LOG );
            this.layer.add ( this.figure = Helper.createErrorFigure ( e ) );
        }

        this.canvas.setContents ( this.pane );
    }

    protected Controller create ( final Primitive element ) throws Exception
    {
        return this.factory.create ( this.controller, element );
    }

    private void internalDispose ()
    {
        this.canvas.setContents ( null );
        if ( this.controller != null )
        {
            this.controller.dispose ();
        }
        if ( this.manager != null )
        {
            this.manager.dispose ();
        }
    }

    @Override
    public void addSummaryListener ( final SummaryListener listener )
    {
        if ( this.controller != null )
        {
            this.controller.addSummaryListener ( listener );
        }
    }

    @Override
    public void removeSummaryListener ( final SummaryListener listener )
    {
        if ( this.controller != null )
        {
            this.controller.removeSummaryListener ( listener );
        }
    }

    @Override
    public SummaryInformation getSummary ()
    {
        return this.controller.getSummaryInformation ();
    }

}
