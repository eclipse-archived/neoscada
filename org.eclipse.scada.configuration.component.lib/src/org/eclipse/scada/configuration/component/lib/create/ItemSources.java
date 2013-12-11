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
package org.eclipse.scada.configuration.component.lib.create;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.generator.Generator;
import org.eclipse.scada.configuration.generator.GeneratorPlugin;
import org.eclipse.scada.ui.databinding.AdapterHelper;

public final class ItemSources
{
    private ItemSources ()
    {
    }

    public static ItemSource createItemSource ( final Component dc )
    {
        final ItemSource itemSource = AdapterHelper.adapt ( dc, ItemSource.class );
        if ( itemSource != null )
        {
            return itemSource;
        }

        final Set<Generator> generators = GeneratorPlugin.createGeneratorsFor ( dc );
        final Set<ItemSource> sources = new HashSet<> ();

        for ( final Generator generator : generators )
        {
            final ItemSource source = AdapterHelper.adapt ( generator, ItemSource.class );
            if ( source != null )
            {
                sources.add ( source );
            }
        }

        if ( sources.isEmpty () )
        {
            return null;
        }
        return new CompositeItemSource ( sources );
    }
}
