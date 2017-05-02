/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.ui.providers.internal;

import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.scada.sec.ui.providers.KeyProvider;
import org.eclipse.scada.sec.ui.providers.KeyProviderFactory;
import org.eclipse.scada.sec.ui.providers.Locked;
import org.eclipse.scada.ui.databinding.ListeningStyledCellLabelProvider;
import org.eclipse.swt.graphics.Image;

public final class LabelProviderImpl extends ListeningStyledCellLabelProvider
{
    private final ResourceManager manager;

    private final Image locked;

    public LabelProviderImpl ( final ResourceManager manager, final IObservableSet itemsThatNeedLabels )
    {
        super ( itemsThatNeedLabels );
        this.manager = manager;
        this.locked = this.manager.createImageWithDefault ( ImageDescriptor.createFromFile ( LabelProviderImpl.class, "icons/blocked.gif" ) );
     }

    @Override
    public void update ( final ViewerCell cell )
    {
        final Object ele = cell.getElement ();
        if ( ele instanceof KeyProviderFactory )
        {
            cell.setText ( ele.toString () );
        }
        else if ( ele instanceof KeyProvider )
        {
            final KeyProvider keyProvider = (KeyProvider)ele;
            cell.setText ( keyProvider.toString () );
            cell.setImage ( keyProvider.isLocked () ? this.locked : null );
        }
        else if ( ele instanceof org.eclipse.scada.sec.ui.providers.Key )
        {
            final org.eclipse.scada.sec.ui.providers.Key key = (org.eclipse.scada.sec.ui.providers.Key)ele;
            cell.setText ( key.toString () );
            cell.setImage ( key.isLocked () ? this.locked : null );
        }
    }

    @Override
    protected void addListenerTo ( final Object next )
    {
        if ( next instanceof KeyProvider )
        {
            listenTo ( next, BeanProperties.value ( KeyProvider.class, Locked.PROP_LOCKED ) );
        }
        else if ( next instanceof org.eclipse.scada.sec.ui.providers.Key )
        {
            listenTo ( next, BeanProperties.value ( org.eclipse.scada.sec.ui.providers.Key.class, Locked.PROP_LOCKED ) );
        }
    }

    @Override
    protected void removeListenerFrom ( final Object element )
    {
    }

}