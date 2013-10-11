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
package org.eclipse.scada.core.ui.connection.views.tree;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.UnionSet;
import org.eclipse.scada.core.ui.connection.Activator;

final class ConnectionTreeObservableFactory implements IObservableFactory
{
    @Override
    public IObservable createObservable ( final Object target )
    {
        if ( target == Activator.ROOT )
        {
            return Observables.proxyObservableSet ( Activator.getDefault ().getTreeRoot () );
        }
        else if ( target instanceof TreeNode )
        {
            return new UnionSet ( new IObservableSet[] { ( (TreeNode)target ).getChildren (), ( (TreeNode)target ).getConnections () } );
        }
        return null;
    }
}