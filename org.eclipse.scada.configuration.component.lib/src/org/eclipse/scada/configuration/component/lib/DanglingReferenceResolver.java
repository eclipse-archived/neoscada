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
package org.eclipse.scada.configuration.component.lib;

import org.eclipse.scada.configuration.component.DanglingItemReference;
import org.eclipse.scada.configuration.generator.GeneratorContext;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.MasterServer;

public interface DanglingReferenceResolver
{
    public Item resolveReference ( GeneratorContext ctx, MasterServer master, DanglingItemReference ref );
}
