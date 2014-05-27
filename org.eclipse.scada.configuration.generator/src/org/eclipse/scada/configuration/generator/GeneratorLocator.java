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
package org.eclipse.scada.configuration.generator;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IRegistryChangeEvent;
import org.eclipse.core.runtime.IRegistryChangeListener;
import org.eclipse.core.runtime.Platform;
import org.eclipse.scada.configuration.generator.text.AnnotationMessageProcessor;
import org.eclipse.scada.configuration.utils.Factories;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeneratorLocator
{
    private static final String ELE_GENERATE_FOR = "generateForType";

    private static final String ATTR_CLASS = "class";

    private static final String EXTP_GENERATOR_FACTORY = "org.eclipse.scada.configuration.generator.component.generator";

    private static final Object ELE_FACTORY = "factory";

    private final static Logger logger = LoggerFactory.getLogger ( GeneratorLocator.class );

    private Map<Class<?>, Set<GeneratorFactory>> cache;

    private final IRegistryChangeListener changeListener = new IRegistryChangeListener () {

        @Override
        public void registryChanged ( final IRegistryChangeEvent event )
        {
            clearCache ();
        }
    };

    private final BundleContext context;

    private final ILog log;

    public GeneratorLocator ( final BundleContext context, final ILog log )
    {
        this.context = context;
        this.log = log;
    }

    protected void clearCache ()
    {
        this.cache = null;
    }

    public Map<Class<?>, Set<GeneratorFactory>> getFactories ()
    {
        if ( this.cache == null )
        {
            logger.info ( "Rebuild factory cache" );

            this.cache = new HashMap<> ();
            for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_GENERATOR_FACTORY ) )
            {
                if ( !ELE_FACTORY.equals ( ele.getName () ) )
                {
                    continue;
                }

                logger.debug ( "Checking factory - factory: {}", ele.getAttribute ( ATTR_CLASS ) );

                GeneratorFactory factory;
                try
                {
                    factory = (GeneratorFactory)ele.createExecutableExtension ( ATTR_CLASS );
                }
                catch ( final CoreException e )
                {
                    this.log.log ( e.getStatus () );
                    logger.warn ( "Failed to create factory", e );
                    continue;
                }

                for ( final IConfigurationElement child : ele.getChildren ( ELE_GENERATE_FOR ) )
                {
                    logger.debug ( "Checking for -> {}", child.getAttribute ( ATTR_CLASS ) );

                    final Class<?> sourceClass = makeSourceClass ( child );
                    if ( sourceClass != null )
                    {
                        addCacheEntry ( sourceClass, factory );
                    }
                }
            }
        }
        return this.cache;
    }

    private Class<?> makeSourceClass ( final IConfigurationElement ele )
    {
        return Factories.loadClass ( this.context, ele, ATTR_CLASS );
    }

    private void addCacheEntry ( final Class<?> sourceClass, final GeneratorFactory factory )
    {
        logger.debug ( "Adding cache entry - sourceClass: {}, factory: {}", sourceClass, factory );

        Set<GeneratorFactory> factories = this.cache.get ( sourceClass );
        if ( factories == null )
        {
            factories = new HashSet<> ();
            this.cache.put ( sourceClass, factories );
        }
        factories.add ( factory );
    }

    public Set<GeneratorFactory> getFactoriesFor ( final Object element )
    {
        final Map<Class<?>, Set<GeneratorFactory>> factories = getFactories ();

        final Set<GeneratorFactory> result = new HashSet<> ();

        for ( final Map.Entry<Class<?>, Set<GeneratorFactory>> entry : factories.entrySet () )
        {
            final Class<?> clazz = entry.getKey ();
            if ( clazz.isAssignableFrom ( element.getClass () ) )
            {
                result.addAll ( entry.getValue () );
            }
        }

        return result;
    }

    public Set<Generator> createGeneratorsFor ( final Object element )
    {
        final Set<Generator> result = new HashSet<> ();

        final Generator generator = AdapterHelper.adapt ( element, Generator.class, true );
        if ( generator != null )
        {
            result.add ( generator );
            new AnnotationMessageProcessor ( generator ).setMessages ( null );
        }

        for ( final GeneratorFactory factory : getFactoriesFor ( element ) )
        {
            final Collection<Generator> generators = factory.createGenerators ( element );
            result.addAll ( generators );
            for ( final Generator gen : generators )
            {
                new AnnotationMessageProcessor ( gen ).setMessages ( null );
            }
        }

        logger.debug ( "{} generators found for {}", result.size (), element.getClass () );

        return result;
    }

    public void start ()
    {
        Platform.getExtensionRegistry ().addRegistryChangeListener ( this.changeListener );
    }

    public void stop ()
    {
        Platform.getExtensionRegistry ().removeRegistryChangeListener ( this.changeListener );
    }
}
