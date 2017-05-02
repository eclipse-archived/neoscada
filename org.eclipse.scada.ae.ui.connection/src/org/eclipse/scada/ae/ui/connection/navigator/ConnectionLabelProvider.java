/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - add images
 *******************************************************************************/
package org.eclipse.scada.ae.ui.connection.navigator;

import java.util.Set;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.scada.ae.data.BrowserType;
import org.eclipse.scada.ae.ui.connection.Activator;
import org.eclipse.scada.ae.ui.connection.ImageConstants;
import org.eclipse.scada.ae.ui.connection.data.BrowserEntryBean;
import org.eclipse.scada.ui.databinding.CommonListeningLabelProvider;
import org.eclipse.scada.ui.databinding.StyledViewerLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionLabelProvider extends CommonListeningLabelProvider
{

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionLabelProvider.class );

    private final ResourceManager resource = new LocalResourceManager ( JFaceResources.getResources () );

    public ConnectionLabelProvider ()
    {
        super ( "org.eclipse.scada.ae.ui.connection.provider" ); //$NON-NLS-1$
    }

    @Override
    public void dispose ()
    {
        this.resource.dispose ();
        super.dispose ();
    }

    @Override
    public void updateLabel ( final StyledViewerLabel label, final Object element )
    {
        logger.debug ( "Update label: {}", element ); //$NON-NLS-1$

        if ( element instanceof BrowserEntryBean )
        {
            final BrowserEntryBean entry = (BrowserEntryBean)element;
            final StyledString string = new StyledString ( entry.getEntry ().getId () );
            label.setStyledText ( string );

            final Set<BrowserType> types = entry.getEntry ().getTypes ();
            if ( types.contains ( BrowserType.EVENTS ) )
            {
                label.setImage ( Activator.getDefault ().getImageRegistry ().get ( ImageConstants.IMG_EVENTS ) );
            }
            else if ( types.contains ( BrowserType.MONITORS ) )
            {
                label.setImage ( Activator.getDefault ().getImageRegistry ().get ( ImageConstants.IMG_MONITORS ) );
            }
        }
        else
        {
            super.updateLabel ( label, element );
        }
    }

    @Override
    protected void addListenerTo ( final Object next )
    {
        super.addListenerTo ( next );
    }

    @Override
    protected void removeListenerFrom ( final Object next )
    {
        super.removeListenerFrom ( next );
    }

}
