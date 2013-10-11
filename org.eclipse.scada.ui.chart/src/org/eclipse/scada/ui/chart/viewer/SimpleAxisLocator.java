/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer;

import java.util.LinkedList;
import java.util.List;

public class SimpleAxisLocator<Key, Value> implements AxisLocator<Key, Value>
{
    private final AbstractAxisManager<Key, Value> first;

    private final AbstractAxisManager<Key, Value> second;

    public SimpleAxisLocator ( final AbstractAxisManager<Key, Value> first, final AbstractAxisManager<Key, Value> second )
    {
        this.first = first;
        this.second = second;
    }

    @Override
    public List<Value> getAll ()
    {
        final List<Value> result = new LinkedList<Value> ();

        result.addAll ( this.first.getAll () );
        result.addAll ( this.second.getAll () );

        return result;
    }

    @Override
    public Value findAxis ( final Key key )
    {
        final Value result = this.first.getAxis ( key );
        if ( result != null )
        {
            return result;
        }
        return this.second.getAxis ( key );
    }

}
