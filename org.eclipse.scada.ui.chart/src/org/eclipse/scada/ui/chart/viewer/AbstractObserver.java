/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.databinding.Binding;
import org.eclipse.scada.utils.beans.AbstractPropertyChange;

public class AbstractObserver extends AbstractPropertyChange
{
    private final Collection<Binding> bindings = new LinkedList<Binding> ();

    protected Binding addBinding ( final Binding binding )
    {
        this.bindings.add ( binding );
        return binding;
    }

    protected void addBindings ( final Collection<Binding> bindings )
    {
        this.bindings.addAll ( bindings );
    }

    public void dispose ()
    {
        for ( final Binding binding : this.bindings )
        {
            binding.dispose ();
        }
        this.bindings.clear ();
    }
}
