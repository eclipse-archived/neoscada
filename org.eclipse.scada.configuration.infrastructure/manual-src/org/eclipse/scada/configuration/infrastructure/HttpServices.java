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
package org.eclipse.scada.configuration.infrastructure;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

public final class HttpServices
{
    private HttpServices ()
    {
    }

    public static Set<HttpServiceModule> extract ( final Collection<? extends Module> elements )
    {
        final Set<HttpServiceModule> result = new HashSet<> ();

        for ( final Module o : elements )
        {
            if ( o instanceof HttpServiceModule )
            {
                result.add ( (HttpServiceModule)o );
            }
        }

        return result;
    }

    public static boolean isValid ( final Object container, final HttpServiceModule hsm )
    {
        return findLocal ( container ).contains ( hsm );
    }

    public static Set<HttpServiceModule> findLocal ( final Object o )
    {
        if ( ! ( o instanceof EObject ) )
        {
            return Collections.emptySet ();
        }

        final EObject c = ( (EObject)o ).eContainer ();
        if ( c == null )
        {
            return Collections.emptySet ();
        }

        final Set<HttpServiceModule> result = new HashSet<> ();

        if ( c instanceof EquinoxApplication )
        {
            result.addAll ( extract ( ( (EquinoxApplication)c ).getModules () ) );
            final ApplicationConfiguration cfg = ( (EquinoxApplication)c ).getConfiguration ();
            if ( cfg != null )
            {
                result.addAll ( extract ( cfg.getModules () ) );
            }
        }
        else if ( c instanceof ApplicationConfiguration )
        {
            result.addAll ( extract ( ( (ApplicationConfiguration)c ).getModules () ) );
        }

        return result;
    }
}
