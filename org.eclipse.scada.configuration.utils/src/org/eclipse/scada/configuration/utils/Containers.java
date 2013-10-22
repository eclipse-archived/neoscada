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
package org.eclipse.scada.configuration.utils;

import org.eclipse.emf.ecore.EObject;

public final class Containers
{
    private Containers ()
    {
    }

    public static <T> T findContainer ( EObject current, final Class<T> clazz )
    {
        while ( current != null && !clazz.isAssignableFrom ( current.getClass () ) )
        {
            current = current.eContainer ();
        }
        if ( current == null )
        {
            return null;
        }
        return clazz.cast ( current );
    }
}
