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
package org.eclipse.scada.configuration.ui.component;

import java.net.URL;

import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.ui.component.Helper.ItemEntry;
import org.eclipse.scada.configuration.ui.component.Helper.Master;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.ui.databinding.ObservableMapStyledCellLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class NameLabelProvider extends ObservableMapStyledCellLabelProvider
{
    private final ComposedAdapterFactory adapterFactory;

    private final LocalResourceManager resourceManager;

    public NameLabelProvider ( final Display display, final IObservableSet elements )
    {
        super ( EMFProperties.value ( InfrastructurePackage.Literals.EQUINOX_APPLICATION__NAME ).observeDetail ( PojoProperties.value ( "master" ).observeDetail ( elements ) ) );
        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources ( display ) );
        this.adapterFactory = new ComposedAdapterFactory ( ComposedAdapterFactory.Descriptor.Registry.INSTANCE );
    }

    @Override
    public void dispose ()
    {
        this.adapterFactory.dispose ();
        super.dispose ();
        this.resourceManager.dispose ();
    }

    @Override
    public void update ( final ViewerCell cell )
    {
        final Object ele = cell.getElement ();
        if ( ele instanceof Master )
        {
            final MasterServer master = ( (Master)ele ).getMaster ();
            final IItemLabelProvider itemLabelProvider = (IItemLabelProvider)this.adapterFactory.adapt ( master, IItemLabelProvider.class );
            cell.setText ( itemLabelProvider.getText ( master ) );

            cell.setImage ( makeImage ( itemLabelProvider.getImage ( master ) ) );
        }
        else if ( ele instanceof ItemEntry )
        {
            final Item item = ( (ItemEntry)ele ).getItem ();
            cell.setText ( "" + ( (ItemEntry)ele ).getLocal () );
            final IItemLabelProvider itemLabelProvider = (IItemLabelProvider)this.adapterFactory.adapt ( item, IItemLabelProvider.class );
            cell.setImage ( makeImage ( itemLabelProvider.getImage ( item ) ) );
        }
        else if ( ele instanceof ClassInformationProvider )
        {
            final ClassInformationProvider cip = (ClassInformationProvider)ele;
            cell.setText ( String.format ( "%s (%s)", cip.getSimpleName (), cip.getPackageName () ) );
        }
        else
        {
            cell.setText ( "" + ele );
        }
    }

    private Image makeImage ( final Object image )
    {
        if ( image == null )
        {
            return null;
        }

        if ( image instanceof URL )
        {
            return this.resourceManager.createImage ( ImageDescriptor.createFromURL ( (URL)image ) );
        }

        return null;
    }

}
