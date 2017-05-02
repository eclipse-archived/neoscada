/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.lib.internal;

import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.ExecDriver;
import org.eclipse.scada.configuration.world.World;
import org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.RedhatDeploymentMechanism;
import org.eclipse.scada.configuration.world.lib.NodeElementProcessor;
import org.eclipse.scada.configuration.world.lib.NodeElementProcessorFactory;
import org.eclipse.scada.configuration.world.lib.deployment.MsiHandler;
import org.eclipse.scada.configuration.world.lib.deployment.debian.DebianHandler;
import org.eclipse.scada.configuration.world.lib.deployment.redhat.RedhatHandler;
import org.eclipse.scada.configuration.world.lib.oscar.DefaultEquinoxApplicationProcessor;
import org.eclipse.scada.configuration.world.lib.oscar.MasterServerProcessor;
import org.eclipse.scada.configuration.world.lib.oscar.ValueArchiveServerProcessor;
import org.eclipse.scada.configuration.world.osgi.DefaultEquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.ValueArchiveServer;

public class DefaultNodeElementProcessorFactoryImpl implements NodeElementProcessorFactory
{

    @Override
    public NodeElementProcessor createProcessor ( final Object element, final World world, final ApplicationNode applicationNode )
    {
        if ( element instanceof ExecDriver )
        {
            return new ExecDriverProcessor ( (ExecDriver)element );
        }
        else if ( element instanceof MasterServer )
        {
            return new MasterServerProcessor ( world, (MasterServer)element );
        }
        else if ( element instanceof ValueArchiveServer )
        {
            return new ValueArchiveServerProcessor ( (ValueArchiveServer)element );
        }
        else if ( element instanceof DebianDeploymentMechanism )
        {
            return new DebianHandler ( applicationNode, (DebianDeploymentMechanism)element );
        }
        else if ( element instanceof RedhatDeploymentMechanism )
        {
            return new RedhatHandler ( applicationNode, (RedhatDeploymentMechanism)element );
        }
        else if ( element instanceof MsiDeploymentMechanism )
        {
            return new MsiHandler ( applicationNode, (MsiDeploymentMechanism)element );
        }
        else if ( element instanceof DefaultEquinoxApplication )
        {
            return new DefaultEquinoxApplicationProcessor ( (DefaultEquinoxApplication)element );
        }
        return null;
    }

}
