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

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class ModelLoader<T>
{
    private final Class<? extends T> clazz;

    public ModelLoader ( final Class<? extends T> clazz )
    {
        this.clazz = clazz;
    }

    public T load ( final URI uri ) throws IOException
    {
        final ResourceSet rs = new ResourceSetImpl ();
        final Resource r = rs.createResource ( uri );
        r.load ( null );

        for ( final Object o : r.getContents () )
        {
            if ( this.clazz.isAssignableFrom ( o.getClass () ) )
            {
                return this.clazz.cast ( o );
            }
        }

        throw new IllegalStateException ( String.format ( "Model %s does not contain an object of type %s", uri, this.clazz ) );
    }
}
