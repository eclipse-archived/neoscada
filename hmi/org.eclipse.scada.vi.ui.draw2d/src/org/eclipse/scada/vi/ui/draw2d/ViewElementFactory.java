/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - add factory context
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d;

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.vi.model.Primitive;
import org.eclipse.scada.vi.ui.draw2d.loader.SymbolLoader;

public interface ViewElementFactory
{
    public Controller create ( SymbolController controller, Primitive element, SymbolLoader symbolLoader, ResourceManager manager, BasicViewElementFactory basicViewElementFactory, FactoryContext factoryContext );
}
