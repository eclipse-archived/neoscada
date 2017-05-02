/*******************************************************************************
 * Copyright (c) 2012, 2016 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - relocate adapter helper, add new mouse events
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;
import org.eclipse.scada.vi.model.Arc;
import org.eclipse.scada.vi.model.BorderContainer;
import org.eclipse.scada.vi.model.Connection;
import org.eclipse.scada.vi.model.Dimension;
import org.eclipse.scada.vi.model.Ellipse;
import org.eclipse.scada.vi.model.FigureContainer;
import org.eclipse.scada.vi.model.GridContainer;
import org.eclipse.scada.vi.model.Image;
import org.eclipse.scada.vi.model.Line;
import org.eclipse.scada.vi.model.Polygon;
import org.eclipse.scada.vi.model.Position;
import org.eclipse.scada.vi.model.Primitive;
import org.eclipse.scada.vi.model.Rectangle;
import org.eclipse.scada.vi.model.RoundedRectangle;
import org.eclipse.scada.vi.model.StackContainer;
import org.eclipse.scada.vi.model.SymbolReference;
import org.eclipse.scada.vi.model.Text;
import org.eclipse.scada.vi.model.XYContainer;
import org.eclipse.scada.vi.ui.draw2d.loader.SymbolLoader;
import org.eclipse.scada.vi.ui.draw2d.loader.XMISymbolLoader;
import org.eclipse.scada.vi.ui.draw2d.primitives.ArcController;
import org.eclipse.scada.vi.ui.draw2d.primitives.BorderContainerController;
import org.eclipse.scada.vi.ui.draw2d.primitives.EllipseController;
import org.eclipse.scada.vi.ui.draw2d.primitives.FigureContainerController;
import org.eclipse.scada.vi.ui.draw2d.primitives.GridContainerController;
import org.eclipse.scada.vi.ui.draw2d.primitives.ImageController;
import org.eclipse.scada.vi.ui.draw2d.primitives.LineController;
import org.eclipse.scada.vi.ui.draw2d.primitives.PolygonController;
import org.eclipse.scada.vi.ui.draw2d.primitives.RectangleController;
import org.eclipse.scada.vi.ui.draw2d.primitives.RoundedRectangleController;
import org.eclipse.scada.vi.ui.draw2d.primitives.StackContainerController;
import org.eclipse.scada.vi.ui.draw2d.primitives.SymbolReferenceController;
import org.eclipse.scada.vi.ui.draw2d.primitives.TextController;
import org.eclipse.scada.vi.ui.draw2d.primitives.XYContainerController;
import org.eclipse.swt.SWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicViewElementFactory
{
    private final static Logger logger = LoggerFactory.getLogger ( BasicViewElementFactory.class );

    private final ResourceManager manager;

    private final Map<URI, XMISymbolLoader> symbolCache;

    private final FigureCanvas canvas;

    private final SymbolLoader symbolLoader;

    private final FactoryContext factoryContext;

    public BasicViewElementFactory ( final FigureCanvas canvas, final ResourceManager manager, final SymbolLoader symbolLoader )
    {
        this ( canvas, manager, symbolLoader, null );
    }

    public BasicViewElementFactory ( final FigureCanvas canvas, final ResourceManager manager, final SymbolLoader symbolLoader, final FactoryContext factoryContext )
    {
        this.manager = manager;
        this.canvas = canvas;
        this.symbolLoader = symbolLoader;
        this.symbolCache = new HashMap<URI, XMISymbolLoader> ();

        this.factoryContext = factoryContext == null ? FactoryContext.DEFAULT : factoryContext;
    }

    public BasicViewElementFactory ( final FigureCanvas canvas, final ResourceManager manager, final SymbolLoader symbolLoader, final FactoryContext factoryContext, final Map<URI, XMISymbolLoader> symbolCache )
    {
        this.manager = manager;
        this.canvas = canvas;
        this.symbolLoader = symbolLoader;
        this.symbolCache = symbolCache;

        this.factoryContext = factoryContext == null ? FactoryContext.DEFAULT : factoryContext;
    }

    protected void fireResourceLoaded ( final URI uri )
    {
        SafeRunner.run ( new SafeRunnable () {

            @Override
            public void run () throws Exception
            {
                BasicViewElementFactory.this.factoryContext.loadedResource ( uri );
            }
        } );
    }

    public Controller create ( final SymbolController controller, final Primitive element ) throws Exception
    {
        if ( element == null )
        {
            logger.info ( "Empty element found" );
            return new Controller () {

                @Override
                public IFigure getFigure ()
                {
                    return new Label ( "" );
                }
            };
        }

        if ( element instanceof XYContainer )
        {
            return new XYContainerController ( controller, (XYContainer)element, this );
        }
        else if ( element instanceof Text )
        {
            return new TextController ( this.canvas, controller, (Text)element, this.manager );
        }
        else if ( element instanceof Line )
        {
            return new LineController ( controller, (Line)element, this.manager );
        }
        else if ( element instanceof Polygon )
        {
            return new PolygonController ( controller, (Polygon)element, this.manager );
        }
        else if ( element instanceof Arc )
        {
            return new ArcController ( controller, (Arc)element, this.manager );
        }
        else if ( element instanceof SymbolReference )
        {
            final XMISymbolLoader subLoader = load ( ( (SymbolReference)element ).getUri () );
            return new SymbolReferenceController ( controller, (SymbolReference)element, createSubFactory ( subLoader ), this.manager, this.factoryContext );
        }
        else if ( element instanceof Rectangle )
        {
            return new RectangleController ( controller, (Rectangle)element, this.manager );
        }
        else if ( element instanceof RoundedRectangle )
        {
            return new RoundedRectangleController ( controller, (RoundedRectangle)element, this.manager );
        }
        else if ( element instanceof Ellipse )
        {
            return new EllipseController ( controller, (Ellipse)element, this.manager );
        }
        else if ( element instanceof GridContainer )
        {
            return new GridContainerController ( controller, (GridContainer)element, this );
        }
        else if ( element instanceof BorderContainer )
        {
            return new BorderContainerController ( controller, (BorderContainer)element, this );
        }
        else if ( element instanceof FigureContainer )
        {
            return new FigureContainerController ( controller, (FigureContainer)element, this.manager, this );
        }
        else if ( element instanceof StackContainer )
        {
            return new StackContainerController ( controller, (StackContainer)element, this );
        }
        else if ( element instanceof Image )
        {
            return new ImageController ( this.canvas, controller, (Image)element, this.symbolLoader, this.manager, this.factoryContext );
        }

        final ViewElementFactory factory = Activator.createFactory ( element );
        if ( factory != null )
        {
            return factory.create ( controller, element, this.symbolLoader, this.manager, this, this.factoryContext );
        }

        throw new IllegalArgumentException ( String.format ( "Element type %s is unknown", element.eClass ().getName () ) );
    }

    public org.eclipse.draw2d.geometry.Rectangle create ( final Position position, final Dimension dimension )
    {
        final org.eclipse.draw2d.geometry.PrecisionRectangle rect = new org.eclipse.draw2d.geometry.PrecisionRectangle ();

        if ( position != null )
        {
            rect.setPreciseLocation ( position.getX (), position.getY () );
        }
        else
        {
            rect.setPreciseLocation ( 0.0, 0.0 );
        }

        if ( dimension == null )
        {
            rect.setPreciseSize ( -1, -1 );
        }
        else
        {
            rect.setPreciseSize ( dimension.getWidth (), dimension.getHeight () );
        }
        return rect;
    }

    /**
     * Loads a new symbol based on the current symbol/resource context
     * <p>
     * Note that the implementation caches by URI
     * </p>
     *
     * @param uri
     *            the URI from where to load the symbol
     * @return a symbol loader
     * @throws Exception
     *             if anything goes wrong
     */
    protected XMISymbolLoader load ( final String stringUri ) throws Exception
    {
        final URI uri = URI.createURI ( this.symbolLoader.resolveUri ( stringUri ) );

        final XMISymbolLoader symbol = this.symbolCache.get ( uri );
        if ( symbol != null )
        {
            return symbol;
        }

        logger.info ( "Loading: {}", uri ); //$NON-NLS-1$

        fireResourceLoaded ( uri );

        final XMISymbolLoader loader = new XMISymbolLoader ( uri );
        this.symbolCache.put ( uri, loader );
        return loader;
    }

    public SymbolLoader getRoot ()
    {
        return this.symbolLoader;
    }

    /**
     * Create a new factory with the resource root based on the provided symbol
     * loader
     * <p>
     * Since the factory holds a reference to the symbol loader, which is the
     * context for resolving resource URIs, a new factory must be created for
     * every child symbol.
     * </p>
     *
     * @param symbolLoader
     *            symbol loader, resource context for the new factory
     * @return a new factory
     */
    public BasicViewElementFactory createSubFactory ( final SymbolLoader symbolLoader )
    {
        return new BasicViewElementFactory ( this.canvas, this.manager, symbolLoader, this.factoryContext, this.symbolCache );
    }

    public void createConnections ( final Layer layer, final SymbolController controller, final EList<Connection> connections )
    {
        if ( connections == null )
        {
            return;
        }

        for ( final Connection connection : connections )
        {
            final Controller start = AdapterHelper.adapt ( controller.getElement ( connection.getStart () ), Controller.class );
            final Controller end = AdapterHelper.adapt ( controller.getElement ( connection.getEnd () ), Controller.class );

            if ( start != null && end != null )
            {
                final PolylineConnection c = new PolylineConnection ();
                c.setSourceAnchor ( new ChopboxAnchor ( start.getFigure () ) );
                c.setTargetAnchor ( new ChopboxAnchor ( end.getFigure () ) );
                c.setAntialias ( SWT.ON );
                layer.add ( c );
            }
        }
    }

}
