/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - adding a connection store selector
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.views;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.scada.core.ui.connection.Activator;
import org.eclipse.scada.core.ui.connection.data.ConnectionDiscovererBean;

final class ConnectionObservableFactory implements IObservableFactory
{
    @Override
    public IObservable createObservable ( final Object target )
    {
        if ( target == Activator.ROOT )
        {
            return Activator.getDefault ().createDiscovererSet ();
        }
        else if ( target instanceof ConnectionDiscovererBean )
        {
            final ConnectionDiscovererBean element = (ConnectionDiscovererBean)target;
            return element.getKnownConnections ();
        }
        return null;
    }
}