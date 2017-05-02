/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.test.items;

import java.util.Collections;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.factory.DataItemFactory;
import org.eclipse.scada.da.server.test.Hive;

public class MemoryCellFactory implements DataItemFactory
{
    private final Hive hive;

    public MemoryCellFactory ( final Hive hive )
    {
        this.hive = hive;
    }

    @Override
    public boolean canCreate ( final String itemId )
    {
        return itemId.matches ( "memory\\..*" );
    }

    @Override
    public void create ( final String itemId )
    {
        final FactoryMemoryCell item = new FactoryMemoryCell ( this.hive, itemId );

        this.hive.addMemoryFactoryItem ( item, Collections.<String, Variant> emptyMap () );
    }

}
