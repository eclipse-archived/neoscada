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
package org.eclipse.scada.configuration.world.lib.deployment;

import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.utils.TypeVisitor;
import org.eclipse.scada.configuration.utils.TypeWalker;
import org.eclipse.scada.configuration.world.Node;
import org.eclipse.scada.configuration.world.World;
import org.eclipse.scada.configuration.world.deployment.NodeMappingEntry;
import org.eclipse.scada.configuration.world.deployment.NodeMappings;

public class NodeMappingHandler implements TypeVisitor<Node>
{
    @Inject
    private World worldModel;

    @Inject
    private NodeMappings nodeMappings;

    public void execute ( final IProgressMonitor monitor ) throws Exception
    {
        monitor.setTaskName ( "Mapping nodes" );

        new TypeWalker<Node> ( Node.class ).walk ( this.worldModel, this );
    }

    @Override
    public void visit ( final Node node ) throws Exception
    {
        for ( final NodeMappingEntry entry : this.nodeMappings.getEntries () )
        {
            if ( entry.mapNode ( node ) )
            {
                return;
            }
        }

        switch ( this.nodeMappings.getFallbackMode () )
        {
            case IGNORE:
                return;
            case FAIL:
                throw new IllegalStateException ( String.format ( "No node mapping for: %s", node ) );
        }
    }
}
