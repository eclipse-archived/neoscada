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
package org.eclipse.scada.configuration.component.generator.global;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.GlobalizeComponent;
import org.eclipse.scada.configuration.component.generator.ComponentGenerator;
import org.eclipse.scada.configuration.component.generator.ItemCreatorImpl;
import org.eclipse.scada.configuration.component.generator.global.CaptureItemCreatorImpl.ItemCreation;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.component.lib.create.ItemSource;
import org.eclipse.scada.configuration.component.lib.create.ItemSources;
import org.eclipse.scada.configuration.generator.GenerationContext;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.world.osgi.SourceItem;

public class GlobalizeGenerator extends ComponentGenerator implements ItemSource
{
    private final GlobalizeComponent globalize;

    public GlobalizeGenerator ( final GlobalizeComponent component )
    {
        super ( component );
        this.globalize = component;
    }

    @Override
    public void createItems ( final ItemCreator itemCreator )
    {
        for ( final DataComponent component : this.globalize.getComponents () )
        {
            final Map<List<String>, ItemCreation> items = createItems ( component );
            for ( final Map.Entry<List<String>, ItemCreation> entry : items.entrySet () )
            {
                final CreationRequest<SourceItem> req = itemCreator.createImportItem ( this.globalize.getSourceMaster (), entry.getValue ().getItem ().getName () );
                req.request ( entry.getValue ().getCustomizationRequest () );
                req.addCustomizationTags ( "globalized" );
                req.incrementGlobalizationLevel ();

                // override the local tags with the original local tags, not the modified ones
                req.localTags ( entry.getKey () );

                // now create the item
                req.create ();
            }
        }
    }

    private Map<List<String>, ItemCreation> createItems ( final DataComponent component )
    {
        final Map<List<String>, ItemCreation> result = new HashMap<> ();
        final ItemSource source = ItemSources.createItemSource ( component );
        final CaptureItemCreatorImpl creator = new CaptureItemCreatorImpl ( component, result );
        source.createItems ( creator );
        return result;
    }

    @Override
    public void generate ( final GenerationContext context )
    {
        final MasterServer master = this.globalize.getSourceMaster ().getMaster ();
        final MasterContext mappedMaster = this.context.getMasterContext ( master );
        if ( mappedMaster == null )
        {
            throw new IllegalStateException ( String.format ( "No mapped master found for: %s", master ) );
        }

        createItems ( createItemCreator ( mappedMaster ) );
    }

    protected ItemCreator createItemCreator ( final MasterContext master )
    {
        return new ItemCreatorImpl ( this.context, master, this.globalize );
    }
}
