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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.configuration.generator.FinishContext;
import org.eclipse.scada.configuration.generator.GenerationContext;
import org.eclipse.scada.configuration.generator.GeneratorContext;
import org.eclipse.scada.configuration.infrastructure.Driver;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GenerationContextImpl implements GenerationContext
{

    private final static Logger logger = LoggerFactory.getLogger ( GenerationContextImpl.class );

    private final GeneratorContext generatorContext;

    private final Map<Object, Set<Object>> map = new HashMap<> ();

    public GenerationContextImpl ( final GeneratorContext generatorContext )
    {
        this.generatorContext = generatorContext;
    }

    @Override
    public <T> T requestMapping ( final Object source, final Class<T> targetClazz )
    {
        logger.debug ( "Requesting mapping - source: {}, target: {}", source, targetClazz );

        T result = findMapping ( source, targetClazz );
        if ( result != null )
        {
            return result;
        }

        logger.debug ( "Need to process" );
        processFor ( source );

        result = findMapping ( source, targetClazz );
        if ( result != null )
        {
            return result;
        }

        throw new IllegalStateException ( String.format ( "Unable to find a mapping from %s to %s", source, targetClazz ) );
    }

    public FinishContext createFinishContext ()
    {
        return new FinishContext () {

            @Override
            public <T> T requestMapping ( final Object source, final Class<T> targetClazz )
            {
                return GenerationContextImpl.this.requestMapping ( source, targetClazz );
            }
        };
    }

    protected abstract void processFor ( Object source );

    private <T> T findMapping ( final Object source, final Class<T> targetClazz )
    {
        if ( source instanceof Driver && targetClazz.equals ( org.eclipse.scada.configuration.world.Driver.class ) )
        {
            return targetClazz.cast ( this.generatorContext.getDriverMap ().get ( source ) );
        }
        if ( source instanceof org.eclipse.scada.configuration.infrastructure.MasterServer && targetClazz.equals ( MasterServer.class ) )
        {
            return targetClazz.cast ( this.generatorContext.getEquinoxApplication ( (org.eclipse.scada.configuration.infrastructure.MasterServer)source ) );
        }

        final Set<Object> set = this.map.get ( source );
        if ( set == null )
        {
            return null;
        }

        for ( final Object o : set )
        {
            if ( targetClazz.isAssignableFrom ( o.getClass () ) )
            {
                return targetClazz.cast ( o );
            }
        }

        return null;
    }

    @Override
    public void addMapping ( final Object source, final Object target )
    {
        logger.debug ( "Adding mapping - source: {}, target: {}", source, target );

        Set<Object> set = this.map.get ( source );
        if ( set == null )
        {
            set = new HashSet<> ();
            this.map.put ( source, set );
        }
        set.add ( target );
    }
}
