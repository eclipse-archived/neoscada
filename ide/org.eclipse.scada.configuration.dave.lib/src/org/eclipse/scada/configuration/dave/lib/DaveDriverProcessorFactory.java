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
package org.eclipse.scada.configuration.dave.lib;

import org.eclipse.scada.configuration.dave.DaveDriver;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.World;
import org.eclipse.scada.configuration.world.lib.NodeElementProcessor;
import org.eclipse.scada.configuration.world.lib.NodeElementProcessorFactory;

public class DaveDriverProcessorFactory implements NodeElementProcessorFactory
{

    @Override
    public NodeElementProcessor createProcessor ( final Object element, final World world, final ApplicationNode applicationNode )
    {
        return new DaveDriverProcessor ( (DaveDriver)element );
    }

}
