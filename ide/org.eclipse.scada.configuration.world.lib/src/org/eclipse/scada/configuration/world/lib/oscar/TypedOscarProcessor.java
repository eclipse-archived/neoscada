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
package org.eclipse.scada.configuration.world.lib.oscar;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.utils.TypeVisitor;
import org.eclipse.scada.configuration.utils.TypeWalker;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;

public abstract class TypedOscarProcessor<T> implements OscarProcessor
{

    private final Class<T> clazz;

    public TypedOscarProcessor ( final Class<T> clazz )
    {
        this.clazz = clazz;
    }

    protected abstract void process ( final T item, final EquinoxApplication app, final OscarContext ctx, final IProgressMonitor monitor );

    @Override
    public void process ( final OscarContext ctx, final EquinoxApplication application, final IProgressMonitor monitor ) throws Exception
    {
        new TypeWalker<> ( this.clazz ).walk ( application.getModules (), new TypeVisitor<T> () {

            @Override
            public void visit ( final T item ) throws Exception
            {
                process ( item, application, ctx, monitor );
            }
        } );
    }

}