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
package org.eclipse.scada.configuration.recipe.lib.internal;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.commons.beanutils.PropertyUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.recipe.CaptureOutput;
import org.eclipse.scada.configuration.recipe.Execute;
import org.eclipse.scada.configuration.recipe.InputReference;
import org.eclipse.scada.configuration.recipe.InputValue;
import org.eclipse.scada.configuration.recipe.MapInput;
import org.eclipse.scada.configuration.recipe.lib.Executable;
import org.eclipse.scada.configuration.recipe.lib.ExecutableFactory;
import org.eclipse.scada.configuration.recipe.lib.Output;
import org.eclipse.scada.utils.inject.InjectHelper;
import org.eclipse.scada.utils.inject.Optional;
import org.eclipse.scada.utils.reflect.Reflections;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultExecutableFactory implements ExecutableFactory
{

    private final static Logger logger = LoggerFactory.getLogger ( DefaultExecutableFactory.class );

    @Override
    public Executable create ( final Execute execute, final RunnerContext ctx )
    {
        if ( execute == null )
        {
            return null;
        }

        final String name = execute.getName ();

        // lookup by URI

        Executable exec;

        exec = lookupByUri ( name, execute, ctx );

        if ( exec != null )
        {
            return exec;
        }

        throw new IllegalArgumentException ( String.format ( "Executable '%s' is not registered", name ) );
    }

    private Executable lookupByUri ( final String name, final Execute execute, final RunnerContext ctx )
    {
        logger.debug ( "Looking up by uri - name: {}, execute: {}", name, execute );

        try
        {
            final URI uri = new URI ( name );
            if ( !"bundle-class".equals ( uri.getScheme () ) )
            {
                logger.debug ( "Wrong URI scheme: {}", uri.getScheme () );
                return null;
            }

            final String host = uri.getHost ();

            String clazzName = uri.getPath ();
            if ( clazzName.startsWith ( "/" ) )
            {
                // cut of first slash
                clazzName = clazzName.substring ( 1 );
            }

            if ( clazzName.startsWith ( "." ) )
            {
                clazzName = host + clazzName;
            }

            final Class<?> clazz = findBundle ( host, clazzName );

            if ( Executable.class.isAssignableFrom ( clazz ) )
            {
                logger.debug ( "Return by Executable interface" );
                if ( clazz.isAnnotationPresent ( Singleton.class ) )
                {
                    if ( !ctx.getSingletons ().containsKey ( clazz ) )
                    {
                        ctx.getSingletons ().put ( clazz, clazz.newInstance () );
                    }
                    return (Executable)ctx.getSingletons ().get ( clazz );
                }
                else
                {
                    return (Executable)clazz.newInstance ();
                }
            }
            else
            {
                String fragment = uri.getFragment ();
                if ( fragment == null )
                {
                    fragment = "execute";
                }

                logger.debug ( "Return by call wrapper: #{}", fragment );
                return createCallWrapper ( name, clazz, fragment, execute, ctx );
            }
        }
        catch ( final Exception e )
        {
            logger.info ( "Failed to lookup", e );
            return null;
        }
    }

    private Executable createCallWrapper ( final String name, final Class<?> clazz, final String methodName, final Execute execute, final RunnerContext ctx ) throws Exception
    {
        logger.debug ( "Creating call wrapper for class: {}, method: {}", clazz, methodName );

        final Object o;

        if ( clazz.isAnnotationPresent ( Singleton.class ) )
        {
            if ( !ctx.getSingletons ().containsKey ( clazz ) )
            {
                ctx.getSingletons ().put ( clazz, clazz.newInstance () );
            }
            o = ctx.getSingletons ().get ( clazz );
        }
        else
        {
            o = clazz.newInstance ();
        }

        final Method m = gatherMethods ( clazz, methodName );

        return new Executable () {

            @Override
            public void run ( final RunnerContext ctx )
            {
                try
                {
                    final RunnerContext localContext = makeLocalContext ( ctx, execute );
                    applyContext ( o, localContext );
                    final Object[] args = makeArgs ( m, localContext );
                    m.invoke ( o, args );
                    captureOutput ( o, ctx, execute.getOutput () );
                }
                catch ( final Throwable e )
                {
                    logger.info ( "Method call failed", e );
                    throw new RuntimeException ( String.format ( "Failed to call method: %s", methodName ), e );
                }
            }
        };
    }

    private Method gatherMethods ( final Class<?> clazz, final String methodName )
    {
        final LinkedList<Method> methods = new LinkedList<> ();
        for ( final Method m : clazz.getMethods () )
        {
            if ( m.getName ().equals ( methodName ) )
            {
                methods.add ( m );
            }
        }
        if ( methods.size () == 1 )
        {
            return methods.peek ();
        }
        else if ( methods.isEmpty () )
        {
            throw new IllegalStateException ( String.format ( "Method '%s' not found on class '%s'", methodName, clazz.getName () ) );
        }
        else
        {
            throw new IllegalStateException ( String.format ( "Method '%s' of class '%s' is polymorphic. This is now allowed for the recipe target classes.", methodName, clazz.getName () ) );
        }
    }

    protected void captureOutput ( final Object o, final RunnerContext ctx, final EList<CaptureOutput> outputs ) throws Exception
    {
        here: for ( final CaptureOutput output : outputs )
        {
            final String name = output.getLocalName ();
            final String storeName = output.getContextName () == null ? name : output.getContextName ();

            logger.debug ( "Capture output: {} -> {}", name, storeName );

            final BeanInfo bi = Introspector.getBeanInfo ( o.getClass () );
            for ( final PropertyDescriptor pd : bi.getPropertyDescriptors () )
            {
                if ( pd.getName ().equals ( name ) )
                {
                    final Object value = pd.getReadMethod ().invoke ( o );
                    ctx.getMap ().put ( storeName, value );
                    logger.debug ( "By BeanInfo - value: {}", value );
                    continue here;
                }
            }

            final Field field = Reflections.findField ( o.getClass (), name );
            if ( field != null && field.getAnnotation ( Output.class ) != null )
            {
                final Object value = InjectHelper.getField ( o, field );
                ctx.getMap ().put ( storeName, value );
                logger.debug ( "By field - value: {}", value );
                continue;
            }
            if ( field != null )
            {
                throw new IllegalStateException ( String.format ( "Unable to capture output. Field '%s' of class '%s' is not marked with @Output and is not accessible using a getter." ) );
            }

            throw new IllegalStateException ( String.format ( "Unable to capture output '%s' of class '%s'", name, o.getClass () ) );
        }
    }

    protected static RunnerContext makeLocalContext ( final RunnerContext ctx, final Execute execute )
    {
        final Map<String, Object> map = new HashMap<> ( ctx.getMap () );

        // apply all mappings (from context to local)

        for ( final MapInput mapInput : execute.getMapInput () )
        {
            if ( !map.containsKey ( mapInput.getContextName () ) )
            {
                throw new IllegalStateException ( String.format ( "Invalid input mapping - context entry '%s' does not exists", mapInput.getContextName () ) );
            }
            map.put ( mapInput.getLocalName (), map.remove ( mapInput.getContextName () ) );
        }

        // set all plain values

        for ( final InputValue value : execute.getInputValue () )
        {
            map.put ( value.getName (), value.getValue () );
        }

        for ( final InputReference ref : execute.getInputReference () )
        {
            map.put ( ref.getName (), getReference ( ctx.getMap (), ref.getExpression () ) );
        }

        final RunnerContext result = new RunnerContext ( ctx.getProperties () );
        result.getMap ().putAll ( map );
        return result;
    }

    private static Object getReference ( final Map<String, Object> map, final String expression )
    {
        try
        {
            return PropertyUtils.getProperty ( map, expression );
        }
        catch ( IllegalAccessException | InvocationTargetException | NoSuchMethodException e )
        {
            throw new RuntimeException ( e );
        }
    }

    protected Object[] makeArgs ( final Method m, final RunnerContext localContext )
    {
        final Object[] args = new Object[m.getParameterTypes ().length];

        for ( int i = 0; i < m.getParameterTypes ().length; i++ )
        {
            final Annotation[] an = m.getParameterAnnotations ()[i];

            final boolean optional = isOptional ( an );

            final String name = makeName ( an );
            if ( name != null )
            {
                args[i] = localContext.getMap ().get ( name );
            }
            else
            {
                final Set<Object> values = new HashSet<> ( localContext.getMap ().values () );
                values.add ( localContext );

                final Class<?> type = m.getParameterTypes ()[i];
                args[i] = findForType ( values, type, i, m.getName (), m.getDeclaringClass (), optional );
            }
        }

        return args;
    }

    private boolean isOptional ( final Annotation[] an )
    {
        for ( final Annotation a : an )
        {
            if ( a instanceof Optional )
            {
                return true;
            }
        }
        return false;
    }

    private Object findForType ( final Set<Object> values, final Class<?> type, final int index, final String methodName, final Class<?> clazz, final boolean optional )
    {
        for ( final Object value : values )
        {
            if ( type.isAssignableFrom ( value.getClass () ) )
            {
                return value;
            }
        }
        if ( !optional )
        {
            throw new IllegalStateException ( String.format ( "Unable to find context value for parameter #%s (type: %s) of method '%s' on class '%s'", index, type.getName (), methodName, clazz.getName () ) );
        }
        else
        {
            return null;
        }
    }

    private String makeName ( final Annotation[] an )
    {
        for ( final Annotation a : an )
        {
            if ( a instanceof Named )
            {
                return ( (Named)a ).value ();
            }
        }
        return null;
    }

    protected static void applyContext ( final Object o, final RunnerContext ctx )
    {
        final Collection<Field> fields = Reflections.findAllFields ( o.getClass () );
        InjectHelper.injectFields ( o, fields, ctx.getMap (), Arrays.<Object> asList ( ctx ) );
    }

    private Class<?> findBundle ( final String symbolicName, final String clazzName )
    {
        logger.debug ( "Find bundle with class - symbolicName: {}, className: {}", symbolicName, clazzName );

        final BundleContext context = FrameworkUtil.getBundle ( DefaultExecutableFactory.class ).getBundleContext ();

        for ( final Bundle bundle : context.getBundles () )
        {
            if ( !symbolicName.equals ( bundle.getSymbolicName () ) )
            {
                continue;
            }

            logger.debug ( "Checking bundle: {}", bundle.getSymbolicName () );

            Class<?> clazz;
            try
            {
                clazz = bundle.loadClass ( clazzName );
            }
            catch ( final ClassNotFoundException e )
            {
                logger.debug ( "Class could not be loaded", e );
                // we continue, since we might have multiple versions
                continue;
            }

            logger.debug ( "Success" );
            return clazz;
        }

        return null;
    }
}
