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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.generator.world.oscar.Factories;
import org.eclipse.scada.configuration.generator.world.oscar.MasterHandlerPriorities;
import org.eclipse.scada.configuration.generator.world.oscar.OscarContext;
import org.eclipse.scada.configuration.world.osgi.ConstantItem;

public class ConstantItemGenerator extends ItemGenerator
{
    private final ConstantItem item;

    public ConstantItemGenerator ( final ConstantItem item, final OscarContext ctx, final MasterHandlerPriorities priorities )
    {
        super ( item, ctx, priorities );
        this.item = item;
    }

    @Override
    public void generate ()
    {
        super.generate ();
        addConstantSource ( makeSourceId (), this.item.getValue () );
    }

    @Override
    protected String makeSourceId ()
    {
        return makeId ( "const" );
    }

    private void addConstantSource ( final String id, final String valueString )
    {
        final Map<String, String> data = new HashMap<String, String> ();

        data.put ( "value", valueString ); //$NON-NLS-1$

        addData ( Factories.FACTORY_DA_CONST_SOURCE, id, data );
    }

}
