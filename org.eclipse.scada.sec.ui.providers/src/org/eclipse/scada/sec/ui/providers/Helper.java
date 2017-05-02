/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.ui.providers;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.scada.sec.ui.providers.internal.Activator;
import org.eclipse.ui.statushandlers.StatusManager;

public class Helper
{
    private static final String ELE_FACTORY = "factory";

    private static final String EXTP_KEY_PROVIDER_FACTORY = "org.eclipse.scada.sec.ui.providers.key";

    private static final String ATTR_CLASS = "class";

    public static KeyProviderFactory findFactory ( final String id )
    {
        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_KEY_PROVIDER_FACTORY ) )
        {
            if ( !ELE_FACTORY.equals ( ele.getName () ) )
            {
                continue;
            }

            try
            {
                return (KeyProviderFactory)ele.createExecutableExtension ( ATTR_CLASS );
            }
            catch ( final CoreException e )
            {
                StatusManager.getManager ().handle ( e, Activator.PLUGIN_ID );
            }
        }

        return null;
    }

    public static Collection<KeyProviderFactory> createFactories ()
    {
        final Collection<KeyProviderFactory> result = new LinkedList<KeyProviderFactory> ();

        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_KEY_PROVIDER_FACTORY ) )
        {
            if ( !ELE_FACTORY.equals ( ele.getName () ) )
            {
                continue;
            }

            try
            {
                result.add ( (KeyProviderFactory)ele.createExecutableExtension ( ATTR_CLASS ) );
            }
            catch ( final CoreException e )
            {
                StatusManager.getManager ().handle ( e, Activator.PLUGIN_ID );
            }
        }

        return result;
    }
}
