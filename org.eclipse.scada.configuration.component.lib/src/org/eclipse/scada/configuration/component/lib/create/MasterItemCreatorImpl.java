/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
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
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.Container;
import org.eclipse.scada.configuration.component.ItemInterceptor;
import org.eclipse.scada.configuration.component.lib.ItemInterceptorHandler;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.item.CustomizationRequest;
import org.eclipse.scada.configuration.lib.Items;
import org.eclipse.scada.configuration.lib.Locator;
import org.eclipse.scada.configuration.world.PropertyEntry;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.SourceItem;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;

public abstract class MasterItemCreatorImpl extends AbstractComponentItemCreator
{
    private final static Properties EMPTY_PROPERTIES = new Properties ();

    protected final MasterContext master;

    private final Container container;

    private final Properties properties;

    public MasterItemCreatorImpl ( final MasterContext master, final Component component, final Container container )
    {
        super ( component );
        this.master = master;
        this.container = container;

        this.properties = createProperties ( component );
    }

    /**
     * Create the properties hierarchy for this component
     *
     * @param component
     *            the component
     * @return the properties, never returns <code>null</code>
     */
    private static Properties createProperties ( final Component component )
    {
        if ( component == null )
        {
            return EMPTY_PROPERTIES;
        }

        final Properties parentProperties = createProperties ( component.getLevel () );
        if ( component.getProperties ().isEmpty () )
        {
            return parentProperties == null ? EMPTY_PROPERTIES : parentProperties;
        }

        Properties p;
        if ( parentProperties != null )
        {
            p = new Properties ( parentProperties );
        }
        else
        {
            p = new Properties ();
        }

        fillProperties ( p, component.getProperties () );

        return p;
    }

    private static Properties createProperties ( final Container container )
    {
        if ( container == null )
        {
            return null;
        }

        final Properties parentProperties = createProperties ( AdapterHelper.adapt ( container.eContainer (), Container.class ) );
        if ( container.getProperties ().isEmpty () )
        {
            return parentProperties;
        }

        Properties p;
        if ( parentProperties != null )
        {
            p = new Properties ( parentProperties );
        }
        else
        {
            p = new Properties ();
        }

        fillProperties ( p, container.getProperties () );

        return p;
    }

    private static void fillProperties ( final Properties properties, final EList<PropertyEntry> entries )
    {
        for ( final PropertyEntry pe : entries )
        {
            properties.put ( pe.getKey (), pe.getValue () );
        }
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

        callAllInterceptors ( item );
    }

    private <T extends Item> void callAllInterceptors ( final T item )
    {
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
            final ItemInterceptorHandler handler = AdapterHelper.adapt ( i, ItemInterceptorHandler.class, true );
            if ( handler == null )
            {
                throw new IllegalStateException ( String.format ( "Interceptor '%s' does not adapt to '%s'", i.eClass ().getName (), ItemInterceptorHandler.class.getName () ) );
            }

            final Properties p;
            if ( i.getProperties ().isEmpty () )
            {
                p = this.properties;
            }
            else
            {
                p = new Properties ( this.properties );
                fillProperties ( p, i.getProperties () );
            }

            handler.interceptItem ( item, i, masterContext, p );
        }
    }

}