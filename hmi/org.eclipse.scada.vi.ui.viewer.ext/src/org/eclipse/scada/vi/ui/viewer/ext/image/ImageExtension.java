/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.viewer.ext.image;

import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.scada.vi.ui.user.viewer.ViewManager;
import org.eclipse.scada.vi.ui.user.viewer.ext.ViewerExtension;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageExtension implements ViewerExtension, IExecutableExtension
{

    private final static Logger logger = LoggerFactory.getLogger ( ImageExtension.class );

    private URL imageUrl;

    private Image image;

    @Override
    public Control create ( final Composite composite, final ViewManager viewManager, final boolean horizontal )
    {
        final Label label = new Label ( composite, SWT.NONE );

        try
        {
            this.image = new Image ( label.getDisplay (), this.imageUrl.openStream () );
            label.setImage ( this.image );
        }
        catch ( final IOException e )
        {
            label.setText ( "Failed to load image: " + e );
        }

        label.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                if ( ImageExtension.this.image != null )
                {
                    ImageExtension.this.image.dispose ();
                }
            }
        } );

        return label;
    }

    @Override
    public void setInitializationData ( final IConfigurationElement config, final String propertyName, final Object data ) throws CoreException
    {
        try
        {
            if ( data instanceof String )
            {
                this.imageUrl = new URL ( (String)data );
            }
            if ( data instanceof Hashtable<?, ?> )
            {
                this.imageUrl = new URL ( (String) ( (Hashtable<?, ?>)data ).get ( "url" ) );
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to parse URL", e );
        }
    }
}
