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
package org.eclipse.scada.ui.databinding.observable;

import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;

public class InvertedObserableValue extends ComputedValue
{
    private final IObservableValue value;

    public InvertedObserableValue ( final IObservableValue value )
    {
        this.value = value;
    }

    @Override
    protected Object calculate ()
    {
        return ! ( (Boolean)this.value.getValue () );
    }
}