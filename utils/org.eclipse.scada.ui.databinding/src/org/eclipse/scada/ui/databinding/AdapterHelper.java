/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - deprecated and moved to
 *          org.eclipse.scada.utils.core.runtime
 *******************************************************************************/
package org.eclipse.scada.ui.databinding;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;

/**
 * @deprecated use {@link org.eclipse.scada.utils.core.runtime.AdapterHelper}
 *             instead.
 */
@Deprecated
public class AdapterHelper
{
    /**
     * Adapt an object to the requested target class if possible
     * <p>
     * The following order is tried:
     * <ul>
     * <li>via casting</li>
     * <li>via {@link IAdaptable}</li>
     * <li>via {@link IAdapterManager#getAdapter(Object, Class)}</li>
     * </p>
     * 
     * @param target
     *            the object to convert
     * @param adapterClass
     *            the target class
     * @return an instance of the target class or <code>null</code> if the
     *         object cannot be adapted to the target class
     */
    public static <T> T adapt ( final Object target, final Class<T> adapterClass )
    {
        return adapt ( target, adapterClass, false );
    }

    /**
     * Adapt an object to the requested target class if possible
     * <p>
     * The following order is tried:
     * <ul>
     * <li>via casting</li>
     * <li>via {@link IAdaptable}</li>
     * <li>via {@link IAdapterManager#getAdapter(Object, Class)} if the
     * parameter
     * <q>load</q> is <code>false</code></li>
     * <li>via {@link IAdapterManager#loadAdapter(Object, String)} if the
     * parameter
     * <q>load</q> is <code>true</code></li>
     * </p>
     * 
     * @since 1.2
     * @param target
     *            the object to convert
     * @param adapterClass
     *            the target class
     * @param load
     *            a flag allowing to control if the adapter manager should also
     *            try loading bundles. See
     *            {@link IAdapterManager#loadAdapter(Object, String)}
     * @return an instance of the target class or <code>null</code> if the
     *         object cannot be adapted to the target class
     */
    @SuppressWarnings ( "unchecked" )
    public static <T> T adapt ( final Object target, final Class<T> adapterClass, final boolean load )
    {
        if ( target == null )
        {
            return null;
        }

        if ( adapterClass.isAssignableFrom ( target.getClass () ) )
        {
            return adapterClass.cast ( target );
        }

        if ( target instanceof IAdaptable )
        {
            return (T) ( (IAdaptable)target ).getAdapter ( adapterClass );
        }

        if ( load )
        {
            return (T)Platform.getAdapterManager ().loadAdapter ( target, adapterClass.getName () );
        }
        else
        {
            return (T)Platform.getAdapterManager ().getAdapter ( target, adapterClass );
        }
    }
}
