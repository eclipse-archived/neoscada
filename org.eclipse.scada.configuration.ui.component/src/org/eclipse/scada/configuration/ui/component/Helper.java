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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.core.runtime.Status;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.generator.util.Components;
import org.eclipse.scada.configuration.component.lib.create.AbstractComponentItemCreator;
import org.eclipse.scada.configuration.component.lib.create.ItemSource;
import org.eclipse.scada.configuration.component.lib.create.ItemSources;
import org.eclipse.scada.configuration.component.lib.create.MasterListener;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.item.CustomizationRequest;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Helper
{

    private final static Logger logger = LoggerFactory.getLogger ( Helper.class );

    private static final class SpyComponentItemCreatorImpl extends AbstractComponentItemCreator
    {
        private final Map<List<String>, Item> entries;

        private SpyComponentItemCreatorImpl ( final Component component, final Map<List<String>, Item> entries )
        {
            super ( component );
            this.entries = entries;
        }

        @Override
        public void createMarker ( final Status status )
        {
            // TODO: add real UI marker
        }

        @Override
        protected <T extends Item> void itemAdded ( final T item, final CustomizationRequest customizationRequest, final List<String> originalLocalTags, final Set<MasterListener<T>> masterListeners )
        {
            logger.debug ( "Adding item: {}", item );
            this.entries.put ( originalLocalTags, item );
        }

        @Override
        protected void customizeItem ( final Item item, final CustomizationRequest customizationRequest )
        {
            Components.customizeItem ( this.component, item, customizationRequest );
        }
    }

    public static class ItemEntry
    {
        private final Item item;

        private final List<String> local;

        public ItemEntry ( final List<String> local, final Item item )
        {
            this.local = Collections.unmodifiableList ( local );
            this.item = item;
        }

        public Item getItem ()
        {
            return this.item;
        }

        public List<String> getLocal ()
        {
            return this.local;
        }
    }

    public static class Master
    {
        private final WritableSet entries;

        private final MasterServer master;

        public Master ( final Realm realm, final MasterServer master, final Component component )
        {
            this.master = master;
            this.entries = new WritableSet ( realm );

            fillWithEntries ( component, this.entries );
        }

        public void dispose ()
        {
            this.entries.dispose ();
        }

        public IObservableSet getEntries ()
        {
            return this.entries;
        }

        @Override
        public String toString ()
        {
            return String.format ( "[Master: %s]", this.master.toString () );
        }

        public MasterServer getMaster ()
        {
            return this.master;
        }

        @Override
        public int hashCode ()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ( this.master == null ? 0 : this.master.hashCode () );
            return result;
        }

        @Override
        public boolean equals ( final Object obj )
        {
            if ( this == obj )
            {
                return true;
            }
            if ( obj == null )
            {
                return false;
            }
            if ( getClass () != obj.getClass () )
            {
                return false;
            }
            final Master other = (Master)obj;
            if ( this.master == null )
            {
                if ( other.master != null )
                {
                    return false;
                }
            }
            else if ( !this.master.equals ( other.master ) )
            {
                return false;
            }
            return true;
        }

    }

    public static IObservableSet createObversableInput ( final Realm realm, final Component component )
    {
        if ( component instanceof DataComponent )
        {
            final WritableSet result = new WritableSet ( realm ) {
                @Override
                public synchronized void dispose ()
                {
                    for ( final Object o : this.wrappedSet )
                    {
                        if ( o instanceof Master )
                        {
                            ( (Master)o ).dispose ();
                        }
                    }
                    super.dispose ();
                }
            };

            final DataComponent dc = (DataComponent)component;

            for ( final MasterServer master : dc.getMasterOn () )
            {
                result.add ( new Master ( realm, master, dc ) );
            }
            return result;
        }
        else
        {
            final WritableSet result = new WritableSet ( realm );
            fillWithEntries ( component, result );
            return result;
        }
    }

    private static void fillWithEntries ( final Component component, final WritableSet result )
    {
        logger.debug ( "Filling result with entries" );
        for ( final Map.Entry<List<String>, Item> entry : createOutputFor ( component ).entrySet () )
        {
            logger.debug ( "Adding entry for result - key: {}, value: {}", entry.getKey (), entry.getValue () );
            result.add ( new ItemEntry ( entry.getKey (), entry.getValue () ) );
        }
    }

    private static Map<List<String>, Item> createOutputFor ( final Component dc )
    {
        final ItemSource source = ItemSources.createItemSource ( dc );
        if ( source == null )
        {
            return Collections.emptyMap ();
        }

        final Map<List<String>, Item> entries = new HashMap<> ();

        final AbstractComponentItemCreator creator = new SpyComponentItemCreatorImpl ( dc, entries );

        logger.debug ( "Creating items for: {}", dc );
        source.createItems ( creator );

        return entries;
    }

}
