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
 *     IBH SYSTEMS GmbH - fix click issue
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d.primitives;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.scada.vi.model.SymbolReference;
import org.eclipse.scada.vi.ui.draw2d.Activator;
import org.eclipse.scada.vi.ui.draw2d.BasicViewElementFactory;
import org.eclipse.scada.vi.ui.draw2d.Controller;
import org.eclipse.scada.vi.ui.draw2d.FactoryContext;
import org.eclipse.scada.vi.ui.draw2d.Helper;
import org.eclipse.scada.vi.ui.draw2d.SymbolController;
import org.eclipse.scada.vi.ui.draw2d.loader.SymbolLoader;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.statushandlers.StatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SymbolReferenceController implements Controller
{

    private final static Logger logger = LoggerFactory.getLogger ( SymbolReferenceController.class );

    private final LayeredPane figure;

    public SymbolReferenceController ( final SymbolController controller, final SymbolReference symbolReference, final BasicViewElementFactory factory, final ResourceManager manager, final FactoryContext factoryContext )
    {
        if ( symbolReference.getZoom () != null )
        {
            this.figure = new org.eclipse.draw2d.ScalableLayeredPane ();
            ( (org.eclipse.draw2d.ScalableLayeredPane)this.figure ).setScale ( symbolReference.getZoom () );
        }
        else
        {
            this.figure = new LayeredPane ();
        }

        final Layer layer = new Layer ();
        layer.setLayoutManager ( new StackLayout () );

        layer.setOpaque ( false );
        this.figure.setOpaque ( false );

        this.figure.add ( layer );

        try
        {
            final SymbolLoader symbolLoader = factory.getRoot ();

            final Map<String, String> properties = new HashMap<String, String> ( convert ( symbolReference.getProperties () ) );
            createProperties ( controller, symbolReference, properties );

            final SymbolController childController = new SymbolController ( controller.getShell (), controller, symbolLoader, properties, controller.getScriptObjects (), factoryContext );

            final Controller elementController = factory.create ( childController, symbolLoader.loadSymbol ().getRoot () );
            final IFigure rootFigure = elementController.getFigure ();
            layer.add ( rootFigure );

            final RGB color = org.eclipse.scada.vi.ui.draw2d.primitives.Helper.makeColor ( symbolLoader.loadSymbol ().getBackgroundColor () );
            if ( color != null )
            {
                layer.setBackgroundColor ( manager.createColor ( color ) );
            }

            // register the symbol element controller
            controller.addElement ( symbolReference, elementController );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to create symbol", e ); //$NON-NLS-1$
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.LOG );
            layer.add ( Helper.createErrorFigure ( e ) );
        }
    }

    private void createProperties ( final SymbolController controller, final SymbolReference symbolReference, final Map<String, String> currentProperties ) throws Exception
    {
        controller.createProperties ( "JavaScript", symbolReference.getOnCreateProperties (), currentProperties ); //$NON-NLS-1$
    }

    @Override
    public IFigure getFigure ()
    {
        return this.figure;
    }

    private Map<? extends String, ? extends String> convert ( final EMap<String, String> properties )
    {
        final Map<String, String> p = new HashMap<String, String> ();
        if ( properties != null )
        {
            for ( final Map.Entry<String, String> entry : properties.entrySet () )
            {
                p.put ( entry.getKey (), entry.getValue () );
            }
        }
        return p;
    }

}
