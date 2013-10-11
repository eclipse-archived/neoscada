/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.client.Connection;
import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.navigator.IDescriptionProvider;
import org.eclipse.scada.core.ui.connection.ConnectionDescriptor;
import org.eclipse.scada.core.ui.connection.data.ConnectionDiscovererBean;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;
import org.eclipse.scada.ui.databinding.CommonListeningLabelProvider;
import org.eclipse.scada.ui.databinding.StyledViewerLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionLabelProvider extends CommonListeningLabelProvider implements PropertyChangeListener, IDescriptionProvider
{
    private final static Logger logger = LoggerFactory.getLogger ( ConnectionLabelProvider.class );

    private final ResourceManager resource = new LocalResourceManager ( JFaceResources.getResources () );

    public ConnectionLabelProvider ()
    {
        super ( "org.eclipse.scada.core.ui.connection.provider" ); //$NON-NLS-1$
    }

    @Override
    public void dispose ()
    {
        this.resource.dispose ();
        super.dispose ();
    }

    private StyledString getConnectionString ( final ConnectionHolder holder )
    {
        final ConnectionService service = holder.getConnectionService ();

        final ConnectionDescriptor desc = holder.getConnectionInformation ();

        final StyledString str = new StyledString ( makeLabel ( desc.getConnectionInformation () ) );

        if ( service != null )
        {
            str.append ( " [", StyledString.DECORATIONS_STYLER ); //$NON-NLS-1$
            final Connection connection = service.getConnection ();
            if ( connection != null )
            {
                str.append ( String.format ( "%s", holder.getConnectionState () ), StyledString.DECORATIONS_STYLER ); //$NON-NLS-1$
            }
            str.append ( "]", StyledString.DECORATIONS_STYLER ); //$NON-NLS-1$
        }

        if ( desc.getServiceId () != null )
        {
            str.append ( String.format ( " (%s)", desc.getServiceId () ), StyledString.QUALIFIER_STYLER ); //$NON-NLS-1$ 
        }

        return str;
    }

    private String makeLabel ( final ConnectionInformation connectionInformation )
    {
        return connectionInformation.toMaskedString ();
    }

    @Override
    public void updateLabel ( final StyledViewerLabel label, final Object element )
    {
        if ( element instanceof ConnectionDiscovererBean )
        {
            final ConnectionDiscovererBean bean = (ConnectionDiscovererBean)element;
            if ( bean.getImageDescriptor () != null )
            {
                label.setImage ( this.resource.createImage ( ( (ConnectionDiscovererBean)element ).getImageDescriptor () ) );
            }
            label.setText ( bean.getName () );
        }
        else if ( element instanceof ConnectionHolder )
        {
            final Image image = this.resource.createImage ( ImageDescriptor.createFromFile ( ConnectionLabelProvider.class, "icons/connection.gif" ) ); //$NON-NLS-1$
            label.setImage ( image );

            label.setStyledText ( getConnectionString ( (ConnectionHolder)element ) );
        }
    }

    @Override
    public String getDescription ( final Object element )
    {
        if ( element instanceof ConnectionDiscovererBean )
        {
            return ( (ConnectionDiscovererBean)element ).getDescription ();
        }
        else if ( element instanceof ConnectionHolder )
        {
            return ( (ConnectionHolder)element ).getConnectionInformation ().getDescription ();
        }
        return super.getDescription ( element );
    }

    @Override
    protected void addListenerTo ( final Object next )
    {
        super.addListenerTo ( next );
        if ( next instanceof ConnectionHolder )
        {
            ( (ConnectionHolder)next ).addPropertyChangeListener ( this );
        }
    }

    @Override
    protected void removeListenerFrom ( final Object next )
    {
        if ( next instanceof ConnectionHolder )
        {
            ( (ConnectionHolder)next ).removePropertyChangeListener ( this );
        }
        super.removeListenerFrom ( next );
    }

    @Override
    public void propertyChange ( final PropertyChangeEvent evt )
    {
        logger.debug ( "Detected a property change: {}", evt ); //$NON-NLS-1$
        fireChangeEvent ( Arrays.asList ( evt.getSource () ) );
    }

}
