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
package org.eclipse.scada.configuration.generator.component.internal;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.scada.configuration.generator.component.SystemRunner;

public class Application implements IApplication
{

    @Override
    public Object start ( final IApplicationContext context ) throws Exception
    {
        final String[] args = (String[])context.getArguments ().get ( IApplicationContext.APPLICATION_ARGS );
        if ( args == null )
        {
            return null;
        }

        for ( final String uri : args )
        {
            new SystemRunner ().process ( URI.createURI ( uri ), URI.createURI ( uri + ".eswm" ), new NullProgressMonitor () );
        }

        return null;
    }

    @Override
    public void stop ()
    {
    }

}
