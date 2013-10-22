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
package org.eclipse.scada.configuration.generator.world.oscar.item;

import org.eclipse.scada.configuration.generator.world.oscar.MasterHandlerPriorities;
import org.eclipse.scada.configuration.generator.world.oscar.OscarContext;
import org.eclipse.scada.configuration.lib.Names;
import org.eclipse.scada.configuration.world.osgi.MovingAverageItem;

public class MovingAverageItemGenerator extends ItemGenerator
{
    private final MovingAverageItem item;

    public MovingAverageItemGenerator ( final MovingAverageItem item, final OscarContext ctx, final MasterHandlerPriorities priorities )
    {
        super ( item, ctx, priorities );
        this.item = item;
    }

    @Override
    protected String makeSourceId ()
    {
        return String.format ( "%s.%s", Names.makeName ( this.item.getSource () ), this.item.getType ().getLiteral () );
    }
}
