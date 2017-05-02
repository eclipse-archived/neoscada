/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.information.details;

import java.util.Set;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.DisposeEvent;
import org.eclipse.core.databinding.observable.IDisposeListener;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.scada.core.client.Connection;
import org.eclipse.scada.core.client.PrivilegeListener;

public class PrivilegeSet extends WritableSet
{

    private final Connection connection;

    private final PrivilegeListener listener = new PrivilegeListener () {

        @Override
        public void privilegesChanged ( final Set<String> granted )
        {
            PrivilegeSet.this.privilegesChanged ( granted );
        }
    };

    public PrivilegeSet ( final Connection connection, final Realm realm )
    {
        super ( realm );

        this.connection = connection;
        addDisposeListener ( new IDisposeListener () {

            @Override
            public void handleDispose ( final DisposeEvent event )
            {
                PrivilegeSet.this.handleDispose ();
            }
        } );
        connection.addPrivilegeListener ( this.listener );
    }

    private void handleDispose ()
    {
        this.connection.removePrivilegeListener ( this.listener );
    }

    private void privilegesChanged ( final Set<String> granted )
    {
        if ( isDisposed () )
        {
            return;
        }

        getRealm ().asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                handleChange ( granted );
            }
        } );
    }

    private void handleChange ( final Set<String> granted )
    {
        if ( isDisposed () )
        {
            return;
        }

        try
        {
            setStale ( false );

            if ( granted == null )
            {
                clear ();
            }
            else
            {
                Diffs.computeSetDiff ( this, granted ).applyTo ( this );
            }
        }
        finally
        {
            setStale ( false );
        }
    }
}
