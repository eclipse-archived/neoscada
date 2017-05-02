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
package org.eclipse.scada.configuration.generator.component.app;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.generator.GenerationContext;
import org.eclipse.scada.configuration.generator.Generator;
import org.eclipse.scada.configuration.generator.GeneratorContext;
import org.eclipse.scada.configuration.generator.GeneratorPlugin;
import org.eclipse.scada.configuration.generator.PreparationContext;
import org.eclipse.scada.configuration.infrastructure.lib.WorldGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeneratorProcessor
{

    private class LocalGenerationContextImpl extends GenerationContextImpl
    {
        private final Set<Generator> remainingGenerators;

        private final Map<Object, Set<Generator>> generatorMap;

        private LocalGenerationContextImpl ( final GeneratorContext generatorContext, final Set<Generator> remainingGenerators, final Map<Object, Set<Generator>> generatorMap )
        {
            super ( generatorContext );
            this.remainingGenerators = remainingGenerators;
            this.generatorMap = generatorMap;
        }

        @Override
        protected void processFor ( final Object source )
        {
            runGeneratorFor ( source, this, this.remainingGenerators, this.generatorMap );
        }
    }

    private final static Logger logger = LoggerFactory.getLogger ( GeneratorProcessor.class );

    @Inject
    private EObject content;

    @Inject
    private WorldGenerator worldGenerator;

    public GeneratorProcessor ()
    {
    }

    public GeneratorProcessor ( final EObject content, final WorldGenerator worldGenerator )
    {
        this.content = content;
        this.worldGenerator = worldGenerator;
    }

    public void setContent ( final EObject content )
    {
        this.content = content;
    }

    public void setWorldGenerator ( final WorldGenerator worldGenerator )
    {
        this.worldGenerator = worldGenerator;
    }

    private static final int STEP_COUNT = 10;

    private static final int RUN_MULTI = 10;

    public void process ( final IProgressMonitor monitor )
    {
        final Map<Object, Set<Generator>> generatorMap = new HashMap<> ();
        final List<Generator> generators = new LinkedList<> ();

        final TreeIterator<Object> ti = EcoreUtil.getAllContents ( Collections.singleton ( this.content ), true );
        while ( ti.hasNext () )
        {
            final Object source = ti.next ();
            final Set<Generator> gens = GeneratorPlugin.createGeneratorsFor ( source );
            if ( !gens.isEmpty () )
            {
                generatorMap.put ( source, gens );
                generators.addAll ( gens );
            }
            else
            {
                // TODO: warn, or not
            }
        }

        final Set<Generator> remainingGenerators = new HashSet<> ( generators );

        final GeneratorContextImpl ctx = new GeneratorContextImpl ( this.worldGenerator );
        final PreparationContext pctx = new PreparationContext () {};
        final LocalGenerationContextImpl gctx = new LocalGenerationContextImpl ( ctx, remainingGenerators, generatorMap );

        monitor.beginTask ( "Generating world model", ( 3 + RUN_MULTI ) * generators.size () * STEP_COUNT + 1 );

        monitor.setTaskName ( "Initializing generators" );
        logger.debug ( "Initializing {} generators", generators.size () );
        for ( final Generator generator : generators )
        {
            generator.initialize ( ctx );
            monitor.worked ( STEP_COUNT ); // COUNT:STEP_COUNT*generators.size()
        }

        monitor.setTaskName ( "Preparing generators" );
        logger.debug ( "Preparing {} generators", generators.size () );
        for ( final Generator generator : generators )
        {
            generator.prepare ( pctx );
            monitor.worked ( STEP_COUNT ); // COUNT:STEP_COUNT*generators.size()
        }

        monitor.setTaskName ( "Running generators" );
        logger.debug ( "Running {} generators", generators.size () );
        for ( final Generator generator : generators )
        {
            monitor.subTask ( String.format ( "Running generator (%s)", generator.getClass ().getSimpleName () ) );
            runGenerator ( remainingGenerators, gctx, generator );
            monitor.worked ( STEP_COUNT * RUN_MULTI ); // COUNT:STEP_COUNT*RUN_MULTI*generators.size()
        }

        monitor.setTaskName ( "Finishing generators" );
        logger.debug ( "Finishing {} generators", generators.size () );
        for ( final Generator generator : generators )
        {
            generator.finish ( gctx.createFinishContext () );
            monitor.worked ( STEP_COUNT ); // COUNT:STEP_COUNT*generators.size()
        }

        monitor.setTaskName ( "Processing post triggers" );
        logger.debug ( "Processing post triggers" );
        ctx.processPostTriggers ();
        monitor.worked ( 1 ); // COUNT:1

        monitor.done ();
    }

    private void runGenerator ( final Set<Generator> remainingGenerators, final GenerationContext gctx, final Generator generator )
    {
        logger.debug ( "Running generator: {}", generator );

        final boolean needRun = remainingGenerators.contains ( generator );
        logger.trace ( "Need to run: {}", needRun );

        if ( needRun )
        {
            remainingGenerators.remove ( generator );
            generator.generate ( gctx );
        }

        logger.trace ( "Did run" );
    }

    public void runGeneratorFor ( final Object source, final LocalGenerationContextImpl ctx, final Set<Generator> remainingGenerators, final Map<Object, Set<Generator>> generatorMap )
    {
        logger.debug ( "Running generators for: {}", source );

        final Set<Generator> set = generatorMap.get ( source );
        if ( set == null )
        {
            logger.debug ( "No generators" );
            return;
        }

        for ( final Generator generator : set )
        {
            runGenerator ( remainingGenerators, ctx, generator );
        }
    }

}
