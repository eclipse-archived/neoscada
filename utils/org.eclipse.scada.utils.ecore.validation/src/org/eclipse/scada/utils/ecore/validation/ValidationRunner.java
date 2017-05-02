/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.ecore.validation;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

public class ValidationRunner
{
    private final BundleContext context;

    private static Object KEY_CACHE = new Object ();

    public ValidationRunner ()
    {
        this.context = FrameworkUtil.getBundle ( ValidationRunner.class ).getBundleContext ();
    }

    public boolean run ( final EObject element, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        if ( element == null )
        {
            return true;
        }

        boolean result = runElement ( element, diagnostics, context );

        final TreeIterator<EObject> it = element.eAllContents ();
        while ( it.hasNext () )
        {
            if ( !runElement ( it.next (), diagnostics, context ) )
            {
                result = false;
            }
        }

        return result;
    }

    protected boolean runElement ( final EObject element, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        if ( element == null )
        {
            return true;
        }

        if ( isCached ( element, context ) )
        {
            return true;
        }

        final String packageUri = element.eClass ().getEPackage ().getNsURI ();
        if ( packageUri == null )
        {
            return false;
        }

        boolean result = true;

        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( "org.eclipse.scada.utils.ecore.validation.handler" ) )
        {
            if ( !ele.getName ().equals ( "validationContext" ) )
            {
                continue;
            }

            final String uri = ele.getAttribute ( "packageUri" );
            if ( !packageUri.equals ( uri ) )
            {
                continue;
            }

            final String contextId = ele.getAttribute ( "contextId" );

            for ( final IConfigurationElement child : ele.getChildren ( "validator" ) )
            {
                if ( !child.getName ().equals ( "validator" ) )
                {
                    continue;
                }

                if ( !isTargetMatch ( element.getClass (), child ) )
                {
                    continue;
                }

                try
                {
                    final Object o = child.createExecutableExtension ( "class" );
                    if ( o instanceof Validator )
                    {
                        final Validator v = (Validator)o;
                        final ValidationContextImpl validationContext = new ValidationContextImpl ( contextId, element );
                        v.validate ( validationContext );
                        if ( !validationContext.apply ( diagnostics ) )
                        {
                            result = false;
                        }
                    }
                }
                catch ( final CoreException e )
                {
                    ValidationPlugin.getDefault ().getLog ().log ( e.getStatus () );
                    throw new IllegalStateException ( e );
                }
            }
        }

        return result;
    }

    private boolean isCached ( final EObject element, final Map<Object, Object> context )
    {
        final Object o = context.get ( KEY_CACHE );
        if ( o == null )
        {
            final Set<EObject> cache = new HashSet<> ();
            cache.add ( element );
            context.put ( KEY_CACHE, cache );
            return false;
        }

        @SuppressWarnings ( "unchecked" )
        final Set<EObject> cache = (Set<EObject>)o;
        if ( cache.contains ( element ) )
        {
            return true;
        }
        else
        {
            cache.add ( element );
            return false;
        }
    }

    private boolean isTargetMatch ( final Class<? extends EObject> clazz, final IConfigurationElement ele )
    {
        if ( isTargetClass ( ele.getAttribute ( "filterClass" ), ele.getContributor (), clazz ) )
        {
            return true;
        }

        for ( final IConfigurationElement child : ele.getChildren ( "filterClass" ) )
        {
            if ( isTargetClass ( child.getAttribute ( "class" ), ele.getContributor (), clazz ) )
            {
                return true;
            }
        }

        return false;
    }

    private boolean isTargetClass ( final String className, final IContributor contributor, final Class<? extends EObject> clazz )
    {
        if ( className == null )
        {
            return false;
        }

        final Bundle bundle = findBundle ( contributor );
        if ( bundle == null )
        {
            throw new IllegalStateException ( String.format ( "Unable to find bundle '%s'", contributor.getName () ) );
        }

        try
        {
            final Class<?> targetClazz = bundle.loadClass ( className );
            if ( targetClazz.isAssignableFrom ( clazz ) )
            {
                return true;
            }
        }
        catch ( final ClassNotFoundException e )
        {
            throw new IllegalStateException ( String.format ( "Unable to find target class '%s'", className ), e );
        }

        return false;
    }

    private Bundle findBundle ( final IContributor contributor )
    {
        final String cid = contributor.getName ();

        for ( final Bundle bundle : this.context.getBundles () )
        {
            if ( bundle.getSymbolicName ().equals ( cid ) )
            {
                return bundle;
            }
        }
        return null;
    }
}
