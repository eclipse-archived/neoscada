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
package org.eclipse.scada.configuration.generator.component;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.scada.configuration.component.System;
import org.eclipse.scada.configuration.generator.component.app.AlarmsInformationProcessor;
import org.eclipse.scada.configuration.generator.component.app.GeneratorProcessor;
import org.eclipse.scada.configuration.generator.component.app.MarkerGroupGeneratorProcessor;
import org.eclipse.scada.configuration.generator.component.app.SummariesCompressor;
import org.eclipse.scada.configuration.generator.component.app.SummariesItemsGenerator;
import org.eclipse.scada.configuration.generator.component.app.SummariesProcessor;
import org.eclipse.scada.configuration.globalization.Globalization;
import org.eclipse.scada.configuration.globalization.lib.GlobalizationProcessor;
import org.eclipse.scada.configuration.infrastructure.lib.WorldGenerator;
import org.eclipse.scada.configuration.utils.ModelLoader;
import org.eclipse.scada.configuration.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemRunner
{

    private final static Logger logger = LoggerFactory.getLogger ( SystemRunner.class );

    public World process ( final URI input, final URI output, final IProgressMonitor monitor ) throws Exception
    {
        logger.debug ( "Processing file: {}", input );

        monitor.setTaskName ( "Loading model" );

        final System system = new ModelLoader<System> ( System.class ).load ( input );

        final WorldGenerator gen = new WorldGenerator ( system.getInfrastructure () );
        gen.generate ( monitor );

        final GlobalizationProcessor gb = createGlobalizationProcessor ( gen.getGlobalize () );

        if ( gb != null )
        {
            gb.preProcess ( monitor );
        }

        new GeneratorProcessor ( system, gen ).process ( monitor );

        final World world = gen.getWorld ();

        new SummariesProcessor ( system, gen ).process ( monitor );
        new SummariesCompressor ( system, gen ).process ( monitor );
        new SummariesItemsGenerator ( system, gen ).process ( monitor );
        new MarkerGroupGeneratorProcessor ( system, gen ).process ( monitor );
        new AlarmsInformationProcessor ( system, gen ).process ( monitor );

        if ( gb != null )
        {
            gb.postProcess ( monitor );
        }

        if ( output != null )
        {
            monitor.subTask ( "Writing model" );

            final ResourceSet rs = new ResourceSetImpl ();

            final Resource r1 = rs.createResource ( URI.createURI ( output + "/result.eswm" ) );
            r1.getContents ().add ( world );
            final Resource r2 = rs.createResource ( URI.createURI ( output + "/result.globalize" ) );
            r2.getContents ().add ( gen.getGlobalize () );

            r1.save ( null );
            r2.save ( null );
        }

        return gen.getWorld ();
    }

    private GlobalizationProcessor createGlobalizationProcessor ( final Globalization glob )
    {
        if ( glob != null )
        {
            return new GlobalizationProcessor ( glob );
        }
        else
        {
            return null;
        }
    }
}
