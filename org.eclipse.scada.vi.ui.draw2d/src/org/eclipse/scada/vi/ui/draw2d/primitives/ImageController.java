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
 *     IBH SYSTEMS - extend image alignment
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d.primitives;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.vi.model.Image;
import org.eclipse.scada.vi.ui.draw2d.FactoryContext;
import org.eclipse.scada.vi.ui.draw2d.SymbolController;
import org.eclipse.scada.vi.ui.draw2d.loader.SymbolLoader;

public class ImageController extends FigureController
{
    private final Label figure;

    private ImageDescriptor currentImage;

    private final SymbolLoader symbolLoader;

    private final FactoryContext factoryContext;

    public ImageController ( final FigureCanvas canvas, final SymbolController controller, final Image element, final SymbolLoader symbolLoader, final ResourceManager manager, final FactoryContext factoryContext )
    {
        super ( controller, manager );
        this.factoryContext = factoryContext;

        this.symbolLoader = symbolLoader;

        this.figure = new Label () {
            @Override
            public void addNotify ()
            {
                super.addNotify ();
                start ();
            }

            @Override
            public void removeNotify ()
            {
                stop ();
                super.removeNotify ();
            }
        };
        controller.addElement ( element, this );

        applyCommon ( element );
        setImage ( element.getUri () );
    }

    protected void applyCommon ( final Image image )
    {
        super.applyCommon ( image );

        this.figure.setLabelAlignment ( Helper.convertAlignment ( image.getImageAlignment (), PositionConstants.CENTER ) );
    }

    @Override
    public void setOpaque ( final Boolean flag )
    {
        setOpaque ( flag, true );
    }

    public void setImage ( final String uri )
    {
        if ( this.currentImage != null )
        {
            this.manager.destroyImage ( this.currentImage );
            this.currentImage = null;
        }

        if ( uri == null || uri.isEmpty () )
        {
            this.figure.setIcon ( null );
        }
        else
        {
            try
            {
                final URL url = new URL ( this.symbolLoader.resolveUri ( uri ) );
                this.figure.setIcon ( this.manager.createImageWithDefault ( this.currentImage = ImageDescriptor.createFromURL ( url ) ) );
                this.factoryContext.loadedResource ( URI.createURI ( url.toString () ) );
            }
            catch ( final MalformedURLException e )
            {
                this.figure.setIcon ( this.manager.createImageWithDefault ( ImageDescriptor.getMissingImageDescriptor () ) );
            }
        }
    }

    @Override
    protected IFigure getPropertyFigure ()
    {
        return this.figure;
    }
}
