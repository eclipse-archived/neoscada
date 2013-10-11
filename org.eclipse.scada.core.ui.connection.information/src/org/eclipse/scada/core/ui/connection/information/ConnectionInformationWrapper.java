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
package org.eclipse.scada.core.ui.connection.information;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.scada.core.connection.provider.info.ConnectionInformationProvider;
import org.eclipse.scada.core.info.StatisticEntry;

public class ConnectionInformationWrapper extends WritableSet
{

    private final ConnectionInformationProvider provider;

    private final Map<Object, InformationBean> beans = new HashMap<Object, InformationBean> ();

    public ConnectionInformationWrapper ( final ConnectionInformationProvider provider )
    {
        this.provider = provider;
        timerUpdate ();
    }

    protected void timerUpdate ()
    {
        if ( isDisposed () )
        {
            return;
        }

        update ();
        getRealm ().timerExec ( 1000, new Runnable () {

            @Override
            public void run ()
            {
                timerUpdate ();
            }
        } );
    }

    private void update ()
    {
        try
        {
            setStale ( true );

            final Collection<StatisticEntry> entries = this.provider.getStatistics ();

            @SuppressWarnings ( "unchecked" )
            final Set<InformationBean> remainingList = new HashSet<InformationBean> ( this );

            for ( final StatisticEntry entry : entries )
            {
                InformationBean bean = this.beans.get ( entry.getKey () );
                if ( bean == null )
                {
                    bean = new InformationBean ();
                    bean.setLabel ( entry.getLabel () );
                    this.beans.put ( entry.getKey (), bean );
                    add ( bean );
                }
                else
                {
                    remainingList.remove ( bean );
                }
                bean.update ( entry );
            }

            removeAll ( remainingList );
        }
        finally
        {
            setStale ( false );
        }
    }
}
