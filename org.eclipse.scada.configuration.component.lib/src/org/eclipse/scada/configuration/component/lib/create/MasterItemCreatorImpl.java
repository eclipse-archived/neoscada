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
package org.eclipse.scada.configuration.component.lib.create;

import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.Container;
import org.eclipse.scada.configuration.component.ItemInterceptor;
import org.eclipse.scada.configuration.component.lib.ItemInterceptorHandler;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.item.CustomizationRequest;
import org.eclipse.scada.configuration.lib.Items;
import org.eclipse.scada.configuration.lib.Locator;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.SourceItem;
import org.eclipse.scada.ui.databinding.AdapterHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class MasterItemCreatorImpl extends AbstractComponentItemCreator
{

    final static Logger logger = LoggerFactory.getLogger ( MasterItemCreatorImpl.class );

    protected final MasterContext master;

    private final Container container;

    public MasterItemCreatorImpl ( final MasterContext master, final Component component, final Container container )
    {
        super ( component );
        this.master = master;
        this.container = container;
    }

    @Override
    public CreationRequest<SourceItem> createSelfItem ( final String sourceName )
    {
        final CreationRequest<SourceItem> req = createSourceItem ( null, sourceName );
        req.addMasterListener ( new MasterListener<SourceItem> () {

            @Override
            public void setMaster ( final SourceItem item, final MasterContext master )
            {
                Helper.setSourceConnectionFromEndpoints ( item, master.getImplementation (), Locator.getSelfEndpoints ( master.getImplementation () ) );
            }
        } );

        return req;
    }

    @Override
    public void createMarker ( final IStatus status )
    {
        // this is a no-op for this implementation
    }

    @Override
    protected <T extends Item> void itemAdded ( final T item, final CustomizationRequest customizationRequest, final List<String> originalLocalTags, final Set<MasterListener<T>> masterListeners )
    {
        Items.addItem ( this.master.getImplementation (), item );

        for ( final MasterListener<T> listener : masterListeners )
        {
            listener.setMaster ( item, this.master );
        }

        Container c = this.container;

        while ( c != null )
        {
            callItemInterceptors ( item, c.getItemInterceptors (), this.master );
            if ( c.eContainer () instanceof Container )
            {
                c = (Container)c.eContainer ();
            }
            else
            {
                c = null;
            }
        }
    }

    /**
     * Call all registered item interceptors in this level
     * 
     * @param itemInterceptors
     *            the item interceptors
     * @param masterContext
     *            the master context
     */
    protected void callItemInterceptors ( final Item item, final List<ItemInterceptor> itemInterceptors, final MasterContext masterContext )
    {
        for ( final ItemInterceptor i : itemInterceptors )
        {
            final ItemInterceptorHandler handler = AdapterHelper.adapt ( i, ItemInterceptorHandler.class );
            if ( handler == null )
            {
                throw new IllegalStateException ( String.format ( "Interceptor '%s' does not adapt to '%s'", i.eClass ().getName (), ItemInterceptorHandler.class.getName () ) );
            }
            handler.interceptItem ( item, i, masterContext );
        }
    }

}