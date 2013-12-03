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
package org.eclipse.scada.configuration.generator.component.app;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.lib.create.AbstractComponentItemCreator;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.MasterItemCreatorImpl;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.infrastructure.lib.WorldGenerator;
import org.eclipse.scada.configuration.item.CustomizationPipeline;
import org.eclipse.scada.configuration.item.CustomizationRequest;
import org.eclipse.scada.configuration.item.CustomizationRunner;
import org.eclipse.scada.configuration.lib.Names;
import org.eclipse.scada.configuration.utils.TypeVisitor;
import org.eclipse.scada.configuration.utils.TypeWalker;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.SummaryGroup;
import org.eclipse.scada.configuration.world.osgi.SummaryItem;

public class SummariesItemsGenerator extends MasterApplicationProcessor
{
    private final class SummariesItemCreatorImpl extends MasterItemCreatorImpl
    {
        private SummariesItemCreatorImpl ( final MasterContext master, final Component component )
        {
            super ( master, component );
        }

        @Override
        protected void customizeItem ( final Item item, final CustomizationRequest customizationRequest )
        {
            final List<CustomizationPipeline> pipelines = findPipelines ();
            new CustomizationRunner ( pipelines ).run ( item, customizationRequest );
        }
    }

    public SummariesItemsGenerator ()
    {
    }

    public SummariesItemsGenerator ( final org.eclipse.scada.configuration.component.System system, final WorldGenerator worldGenerator )
    {
        super ( system, worldGenerator );
    }

    @Override
    public void processContext ( final MasterContext app, final IProgressMonitor monitor ) throws Exception
    {
        final AbstractComponentItemCreator creator = new SummariesItemCreatorImpl ( app, null );
        new TypeWalker<> ( SummaryGroup.class ).walk ( app.getImplementation (), new TypeVisitor<SummaryGroup> () {

            @Override
            public void visit ( final SummaryGroup group ) throws Exception
            {
                processGroup ( app.getImplementation (), group, creator );
            }
        } );
    }

    protected List<CustomizationPipeline> findPipelines ()
    {
        return Arrays.asList ( this.system.getDefaultCustomizationPipeline () );
    }

    protected void processGroup ( final MasterServer app, final SummaryGroup group, final AbstractComponentItemCreator creator )
    {
        final SummaryItem item = OsgiFactory.eINSTANCE.createSummaryItem ();
        item.setGroup ( group );

        item.setInformation ( OsgiFactory.eINSTANCE.createItemInformation () );
        item.getInformation ().setDescription ( String.format ( "Summary group information: %s", Names.makeId ( group ) ) );
        item.getInformation ().getHierarchy ().addAll ( Names.makeHierarchy ( group ) );
        item.getInformation ().setSystem ( "SCADA" );

        final CreationRequest<SummaryItem> c = creator.addItem ( item );
        c.localTags ( "SUMMARY" );
        c.customizationTags ( "summary" );

        final SummaryItem sumItem = c.create ();
        /* 
         * FIXME: next thing is a bit wonky
         * actually the summary group should be used for generating sub items
         * but since the customization process can rename the item, the generator
         * cannot create a name for this later on. So for now all items
         * that are SummaryItem will be treated as sub-summary items.
         */
        if ( group.eContainer () instanceof SummaryGroup )
        {
            ( (SummaryGroup)group.eContainer () ).getItems ().add ( sumItem );
        }
    }

}
