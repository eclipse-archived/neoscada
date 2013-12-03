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
package org.eclipse.scada.configuration.generator.component.app;

import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.component.System;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.infrastructure.lib.WorldGenerator;

public abstract class MasterApplicationProcessor extends EquinoxApplicationProcessor<MasterServer>
{

    @Inject
    protected WorldGenerator worldGenerator;

    public MasterApplicationProcessor ()
    {
        super ( MasterServer.class );
    }

    public MasterApplicationProcessor ( final System system, final WorldGenerator worldGenerator )
    {
        super ( MasterServer.class, system );
        this.worldGenerator = worldGenerator;
    }

    @Override
    protected void process ( final MasterServer app, final IProgressMonitor monitor ) throws Exception
    {
        processContext ( this.worldGenerator.getMasterContext ( app ), monitor );
    }

    protected abstract void processContext ( MasterContext masterContext, IProgressMonitor monitor ) throws Exception;

}
