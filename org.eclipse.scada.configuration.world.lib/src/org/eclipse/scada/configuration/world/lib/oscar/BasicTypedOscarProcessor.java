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

public abstract class BasicTypedOscarProcessor<T> extends BasicOscarProcessor
{

    private final Class<T> clazz;

    private final EquinoxApplication app;

    public BasicTypedOscarProcessor ( final EquinoxApplication app, final OscarContext ctx, final Class<T> clazz )
    {
        super ( app, ctx );
        this.app = app;
        this.clazz = clazz;
    }

    public void process ( final IProgressMonitor monitor )
    {
        try
        {
            new TypeWalker<> ( this.clazz ).walk ( this.app, new TypeVisitor<T> () {

                @Override
                public void visit ( final T item ) throws Exception
                {
                    process ( item );
                }
            } );
        }
        catch ( final Exception e )
        {
            throw new RuntimeException ( e );
        }
        finally
        {
            monitor.done ();
        }
    }

    protected abstract void process ( final T item );
}
