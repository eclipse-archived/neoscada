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
package org.eclipse.scada.configuration.infrastructure.lib;

import java.util.Map;

import org.eclipse.scada.configuration.infrastructure.Node;
import org.eclipse.scada.configuration.world.Driver;

public interface DriverHandler
{
    public Driver process ( org.eclipse.scada.configuration.infrastructure.Driver driver, final Map<Node, org.eclipse.scada.configuration.world.Node> nodes );
}
