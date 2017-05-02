/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.ui.internal;

import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.scada.da.server.ui.HivesPlugin;
import org.eclipse.scada.da.server.ui.ImageConstants;
import org.eclipse.scada.da.server.ui.ServerDescriptor;
import org.eclipse.scada.da.server.ui.ServerEndpoint;
import org.eclipse.scada.ui.databinding.ObservableMapStyledCellLabelProvider;
import org.eclipse.scada.utils.ExceptionHelper;
import org.eclipse.swt.graphics.Image;

public class ServerLabelProvider extends ObservableMapStyledCellLabelProvider
{

    private final Image errorImage;

    private final Image runningImage;

    private final Image stoppedImage;

    public ServerLabelProvider ( final IObservableSet knownElements )
    {
        super ( new IObservableMap[] { //
        BeanProperties.value ( "running" ).observeDetail ( knownElements ), //
        BeanProperties.value ( "error" ).observeDetail ( knownElements ) //
        } );
        this.errorImage = HivesPlugin.getDefault ().getImageRegistry ().get ( ImageConstants.IMG_ERROR );
        this.runningImage = HivesPlugin.getDefault ().getImageRegistry ().get ( ImageConstants.IMG_RUNNING );
        this.stoppedImage = HivesPlugin.getDefault ().getImageRegistry ().get ( ImageConstants.IMG_STOPPED );
    }

    @Override
    public void update ( final ViewerCell cell )
    {
        final Object ele = cell.getElement ();
        if ( ele instanceof ServerDescriptor )
        {
            update ( cell, (ServerDescriptor)ele );
        }
        else if ( ele instanceof ServerEndpoint )
        {
            update ( cell, (ServerEndpoint)ele );
        }
    }

    protected void update ( final ViewerCell cell, final ServerDescriptor element )
    {
        final StyledString str = new StyledString ();

        final boolean running = element.isRunning ();

        str.append ( element.getLabel () );

        final String add = element.getAdditionalLabel ();
        if ( add != null )
        {
            str.append ( ' ' );
            str.append ( add, StyledString.QUALIFIER_STYLER );
        }

        cell.setText ( str.getString () );
        cell.setStyleRanges ( str.getStyleRanges () );

        if ( element.getError () != null )
        {
            cell.setImage ( this.errorImage );
        }
        else
        {
            cell.setImage ( running ? this.runningImage : this.stoppedImage );
        }
    }

    protected void update ( final ViewerCell cell, final ServerEndpoint element )
    {
        final StyledString str = new StyledString ();

        final boolean running = element.isRunning ();

        str.append ( element.getLabel () );

        cell.setText ( str.getString () );
        cell.setStyleRanges ( str.getStyleRanges () );

        if ( element.getError () != null )
        {
            cell.setImage ( this.errorImage );
        }
        else
        {
            cell.setImage ( running ? this.runningImage : this.stoppedImage );
        }
    }

    @Override
    public String getToolTipText ( final Object element )
    {
        if ( element instanceof ServerDescriptor )
        {
            return ExceptionHelper.formatted ( ( (ServerDescriptor)element ).getError () );
        }
        else if ( element instanceof ServerEndpoint )
        {
            return ExceptionHelper.formatted ( ( (ServerEndpoint)element ).getError () );
        }
        return super.getToolTipText ( element );
    }

    @Override
    public Image getToolTipImage ( final Object element )
    {
        if ( element instanceof ServerDescriptor )
        {
            return ( (ServerDescriptor)element ).getError () == null ? null : this.errorImage;
        }
        else if ( element instanceof ServerEndpoint )
        {
            return ( (ServerEndpoint)element ).getError () == null ? null : this.errorImage;
        }
        return super.getToolTipImage ( element );
    }

}
