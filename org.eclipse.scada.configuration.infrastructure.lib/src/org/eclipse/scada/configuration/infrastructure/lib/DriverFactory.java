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
package org.eclipse.scada.configuration.infrastructure.lib;

import java.util.Map;

import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.Node;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.configuration.world.Driver;
import org.eclipse.scada.ide.validation.ValidationContext;

public interface DriverFactory
{
    public Driver createDriver ( World world, AbstractFactoryDriver driver, Map<Node, org.eclipse.scada.configuration.world.Node> nodes );

    public void validate ( ValidationContext context, AbstractFactoryDriver driver );
}
