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
package org.eclipse.scada.configuration.component.generator.mapper;

import org.eclipse.scada.configuration.component.DataMapperAnalyzer;
import org.eclipse.scada.configuration.component.DataMapperService;
import org.eclipse.scada.configuration.component.generator.DataComponentGenerator;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.generator.GenerationContext;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.lib.Names;
import org.eclipse.scada.configuration.world.osgi.DataMapper;
import org.eclipse.scada.configuration.world.osgi.SourceItem;

public class DataMapperAnalyzerGenerator extends DataComponentGenerator
{

    private final DataMapperAnalyzer dataMapperAnalyzer;

    public DataMapperAnalyzerGenerator ( final DataMapperAnalyzer dataMapper )
    {
        super ( dataMapper );
        this.dataMapperAnalyzer = dataMapper;
    }

    @Override
    public void createItems ( final ItemCreator itemCreator )
    {
        itemCreator.markUnsupported ();
    }

    @Override
    protected void generateForMaster ( final GenerationContext context, final MasterContext master )
    {
        final DataMapperService dataMapper = this.dataMapperAnalyzer.getDataMapper ();

        if ( !dataMapper.getMasterOn ().contains ( master ) )
        {
            throw new IllegalStateException ( String.format ( "%s must run on a master server that also runs the data mapper", DataMapperAnalyzer.class.getName () ) );
        }

        final String prefix = Names.makeName ( context.requestMapping ( dataMapper, DataMapper.class ) );

        final ItemCreator creator = createItemCreator ( master );

        {
            final CreationRequest<SourceItem> c = creator.createSelfItem ( prefix + ".entries" );
            c.localTags ( "NUM" ).customizationTags ( "analog", "input" );
            c.information ( "Number of entries in data mapper", null, null );
            c.create ();
        }

        {
            final CreationRequest<SourceItem> c = creator.createSelfItem ( prefix + ".entries" );
            c.localTags ( "ERR" ).customizationTags ( "digital", "input" );
            c.information ( "Data loading error", null, null );
            c.create ();
        }

        {
            final CreationRequest<SourceItem> c = creator.createSelfItem ( prefix + ".entries" );
            c.localTags ( "LOADING" ).customizationTags ( "digital", "input" );
            c.information ( "Loading data", null, null );
            c.create ();
        }

        {
            final CreationRequest<SourceItem> c = creator.createSelfItem ( prefix + ".entries" );
            c.localTags ( "RELOAD" ).customizationTags ( "command" );
            c.information ( "Perform reload", null, null );
            c.create ();
        }
    }
}
