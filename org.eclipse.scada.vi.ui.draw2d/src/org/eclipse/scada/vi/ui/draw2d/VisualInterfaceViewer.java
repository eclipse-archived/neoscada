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
package org.eclipse.scada.vi.ui.draw2d;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.ScalableLayeredPane;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionDimension;
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
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.statushandlers.StatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public VisualInterfaceViewer ( final Composite parent, final int style, final Symbol symbol, final ClassLoader classLoader, final Map<String, Object> scriptObjects, final Map<String, String> properties )
    {
        this ( parent, style, new StaticSymbolLoader ( symbol, classLoader ), scriptObjects, properties );
    }

    public VisualInterfaceViewer ( final Composite parent, final int style, final SymbolLoader symbolLoader, final Map<String, Object> scriptObjects, final Map<String, String> properties )
    {
        super ( parent, style );

        this.initialProperties = properties == null ? Collections.<String, String> emptyMap () : properties;
        this.scriptObjects = scriptObjects;

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

        this.factory = new BasicViewElementFactory ( this.canvas, this.manager, symbolLoader );

        try
        {
            this.pane = createPane ();
            this.layer = new Layer ();
            this.connectionLayer = new ConnectionLayer ();
            this.connectionLayer.setConnectionRouter ( new ManhattanConnectionRouter () );
            this.layer.setLayoutManager ( new StackLayout () );
            this.pane.add ( this.connectionLayer );
            this.pane.add ( this.layer );

            this.symbol = symbolLoader.loadSymbol ();
            create ( symbolLoader );
            applyColor ( symbolLoader.loadSymbol () );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to create view", e );
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );

            this.canvas.setContents ( Helper.createErrorFigure ( e ) );
        }
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

    protected FigureCanvas createCanvas ()
    {
        final FigureCanvas canvas = new FigureCanvas ( this );

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

            this.controller = new SymbolController ( getShell (), symbolLoader, properties, this.scriptObjects );

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
