/*******************************************************************************
 * Copyright (c) 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.configuration.iec62541.lib;

import org.eclipse.neoscada.configuration.iec62541.DriverApplication;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.World;
import org.eclipse.scada.configuration.world.lib.NodeElementProcessor;
import org.eclipse.scada.configuration.world.lib.NodeElementProcessorFactory;

public class DriverProcessorFactory implements NodeElementProcessorFactory
{

    @Override
    public NodeElementProcessor createProcessor ( final Object element, final World world, final ApplicationNode applicationNode )
    {
        return new DriverProcessor ( (DriverApplication)element );
    }

}
