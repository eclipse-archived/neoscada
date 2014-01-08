/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.lib.create;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.lib.Components;
import org.eclipse.scada.configuration.item.CustomizationRequest;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CaptureItemCreator extends AbstractComponentItemCreator
{

    private final static Logger logger = LoggerFactory.getLogger ( CaptureItemCreator.class );

    public static class ItemCreation
    {
        private final Item item;

        private final CustomizationRequest customizationRequest;

        public ItemCreation ( final Item item, final CustomizationRequest customizationRequest )
        {
            this.item = item;
            this.customizationRequest = customizationRequest;
        }

        public Item getItem ()
        {
            return this.item;
        }

        public CustomizationRequest getCustomizationRequest ()
        {
            return this.customizationRequest;
        }
    }

    private final Map<List<String>, ItemCreation> entries;

    public CaptureItemCreator ( final Component component, final Map<List<String>, ItemCreation> entries )
    {
        super ( component );
        this.entries = entries;
    }

    @Override
    public void createMarker ( final IStatus status )
    {
        // TODO: add real UI marker
    }

    @Override
    protected <T extends Item> void itemAdded ( final T item, final CustomizationRequest customizationRequest, final List<String> originalLocalTags, final Set<MasterListener<T>> masterListeners )
    {
        logger.debug ( "Adding item: {}", item );
        this.entries.put ( new ArrayList<String> ( originalLocalTags ), new ItemCreation ( item, customizationRequest ) );
    }

    @Override
    protected void customizeItem ( final Item item, final CustomizationRequest customizationRequest )
    {
        Components.customizeItem ( this.component, item, customizationRequest );
    }
}