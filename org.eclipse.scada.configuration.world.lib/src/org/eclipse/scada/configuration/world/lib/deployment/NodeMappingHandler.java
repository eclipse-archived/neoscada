/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
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
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.deployment.Mappings;

public class NodeMappingHandler extends AbstractMapper
{
    @Inject
    private World worldModel;

    @Inject
    private Mappings nodeMappings;

    @Override
    protected Mappings getMappings ()
    {
        return this.nodeMappings;
    }

    public void execute ( final IProgressMonitor monitor ) throws Exception
    {
        monitor.setTaskName ( "Mapping nodes" );

        new TypeWalker<Node> ( Node.class ).walk ( this.worldModel, new TypeVisitor<Node> () {

            @Override
            public void visit ( final Node node ) throws Exception
            {
                replaceName ( node, WorldPackage.Literals.NODE__HOST_NAME );
            }
        } );
    }
}
