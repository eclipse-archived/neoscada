/*******************************************************************************
 * Copyright (c) 2011, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ds.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class ClassLoaderObjectInputStream extends ObjectInputStream
{
    private final ClassLoader classLoader;

    public ClassLoaderObjectInputStream ( final InputStream in, final ClassLoader classLoader ) throws IOException
    {
        super ( in );
        this.classLoader = classLoader;
    }

    @Override
    protected Class<?> resolveClass ( final ObjectStreamClass desc ) throws IOException, ClassNotFoundException
    {
        return this.classLoader.loadClass ( desc.getName () );
    }

}
