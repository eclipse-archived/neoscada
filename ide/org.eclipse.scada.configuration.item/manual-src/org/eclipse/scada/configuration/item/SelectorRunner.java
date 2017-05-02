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
package org.eclipse.scada.configuration.item;

import java.util.List;

import org.eclipse.scada.configuration.item.Selector;
import org.eclipse.scada.configuration.world.osgi.Item;

public class SelectorRunner
{
    private final List<Selector> selectors;

    public SelectorRunner ( final List<Selector> selectors )
    {
        this.selectors = selectors;
    }

    public Boolean run ( final Item item, final CustomizationRequest request, final Boolean defaultValue )
    {
        // execute all that are not null
        for ( final Selector selector : this.selectors )
        {
            if ( selector != null )
            {
                final Boolean result = selector.selected ( request );
                if ( result != null )
                {
                    return result;
                }
            }
        }
        return defaultValue;
    }
}
