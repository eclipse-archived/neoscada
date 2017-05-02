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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.component.DataMapperService;
import org.eclipse.scada.configuration.generator.FinishContext;
import org.eclipse.scada.configuration.generator.GenerationContext;
import org.eclipse.scada.configuration.generator.Generator;
import org.eclipse.scada.configuration.generator.GeneratorContext;
import org.eclipse.scada.configuration.generator.PreparationContext;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.world.osgi.DataMapper;

public class DataMapperServiceGenerator implements Generator
{

    private GeneratorContext context;

    private final DataMapperService service;

    public DataMapperServiceGenerator ( final DataMapperService service )
    {
        this.service = service;
    }

    @Override
    public void initialize ( final GeneratorContext context )
    {
        this.context = context;
    }

    @Override
    public void generate ( final GenerationContext context )
    {
        for ( final MasterServer master : this.service.getMasterOn () )
        {
            generateFor ( context, master );
        }
    }

    private void generateFor ( final GenerationContext context, final MasterServer master )
    {
        final org.eclipse.scada.configuration.world.osgi.MasterServer mapped = this.context.getEquinoxApplication ( master );
        final DataMapper result = EcoreUtil.copy ( this.service.getDataMapper () );
        mapped.getDataMapper ().add ( result );
        context.addMapping ( this.service, result );
    }

    @Override
    public void prepare ( final PreparationContext context )
    {
    }

    @Override
    public void finish ( final FinishContext context )
    {
    }

}
