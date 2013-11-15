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

import org.eclipse.core.runtime.Status;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.item.CustomizationRequest;
import org.eclipse.scada.configuration.lib.Items;
import org.eclipse.scada.configuration.lib.Locator;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.SourceItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class MasterItemCreatorImpl extends AbstractComponentItemCreator
{

    final static Logger logger = LoggerFactory.getLogger ( MasterItemCreatorImpl.class );

    protected final MasterContext master;

    public MasterItemCreatorImpl ( final MasterContext master, final Component component )
    {
        super ( component );
        this.master = master;
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
    public void createMarker ( final Status status )
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
    }
}