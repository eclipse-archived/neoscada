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
package org.eclipse.scada.configuration.arduino;

import org.eclipse.scada.configuration.arduino.ArduinoDriver;
import org.eclipse.scada.configuration.generator.world.NodeElementProcessor;
import org.eclipse.scada.configuration.generator.world.NodeElementProcessorFactory;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.World;

public class NodeElementProcessorFactoryImpl implements NodeElementProcessorFactory
{

    @Override
    public NodeElementProcessor createProcessor ( final Object element, final World world, final ApplicationNode applicationNode )
    {
        if ( element instanceof ArduinoDriver )
        {
            return new ArduinoProcessor ( (ArduinoDriver)element );
        }
        return null;
    }

}
