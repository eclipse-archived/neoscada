/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.views.tree;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.ui.databinding.CommonListeningLabelProvider;
import org.eclipse.scada.ui.databinding.StyledViewerLabel;
import org.eclipse.ui.navigator.IDescriptionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionTreeLabelProvider extends CommonListeningLabelProvider implements PropertyChangeListener, IDescriptionProvider
{
    private final static Logger logger = LoggerFactory.getLogger ( ConnectionTreeLabelProvider.class );

    private final ResourceManager resource = new LocalResourceManager ( JFaceResources.getResources () );

    public ConnectionTreeLabelProvider ()
    {
        super ( "org.eclipse.scada.core.tree.ui.connection.provider" ); //$NON-NLS-1$
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
        if ( element instanceof TreeNode )
        {
            final TreeNode node = (TreeNode)element;
            label.setText ( node.getName () );
        }
    }

    @Override
    public String getDescription ( final Object element )
    {
        if ( element instanceof TreeNode )
        {
            return null;
        }
        return super.getDescription ( element );
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

    @Override
    public void propertyChange ( final PropertyChangeEvent evt )
    {
        logger.debug ( "Detected a property change: {}", evt ); //$NON-NLS-1$
        fireChangeEvent ( Arrays.asList ( evt.getSource () ) );
    }

}
