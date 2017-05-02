/*******************************************************************************
 * Copyright (c) 2006, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.osgi;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

import org.osgi.framework.Bundle;

/**
 * An object input stream which loads its classes from the provided bundle.
 * 
 * @author Jens Reimann
 */
public class BundleObjectInputStream extends ObjectInputStream
{
    private final Bundle bundle;

    public BundleObjectInputStream ( final InputStream in, final Bundle bundle ) throws IOException
    {
        super ( in );
        this.bundle = bundle;
    }

    @Override
    protected Class<?> resolveClass ( final ObjectStreamClass desc ) throws IOException, ClassNotFoundException
    {
        return this.bundle.loadClass ( desc.getName () );
    }

}
