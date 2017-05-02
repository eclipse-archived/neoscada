/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.ui.summary.explorer;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.set.IObservableSet;

public class FactoryImpl implements IObservableFactory
{
    @Override
    public IObservable createObservable ( final Object target )
    {
        if ( target instanceof IObservableSet )
        {
            return (IObservable)target;
        }
        else if ( target instanceof TreeNode )
        {
            return ( (TreeNode)target ).createObservable ();
        }
        else
        {
            return null;
        }
    }
}