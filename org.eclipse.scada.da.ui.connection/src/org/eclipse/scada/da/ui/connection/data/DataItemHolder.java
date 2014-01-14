/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - extend for more use cases
 *******************************************************************************/
package org.eclipse.scada.da.ui.connection.data;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.scada.da.client.DataItem;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.connection.provider.ConnectionService;
import org.osgi.framework.BundleContext;

/**
 * An item holder providing changes by {@link DataItemValue}
 * 
 * @author Jens Reimann
 */
public class DataItemHolder extends AbstractItemHolder
{
    private DataItem dataItem;

    private final Observer observer;

    private final DataSourceListener listener;

    public DataItemHolder ( final BundleContext context, final Item item, final DataSourceListener listener )
    {
        super ( context, item );
        this.listener = listener;

        this.observer = new Observer () {

            @Override
            public void update ( final Observable o, final Object arg )
            {
                DataItemHolder.this.update ( o, arg );
            }
        };

        init ();
    }

    protected void update ( final Observable o, final Object arg )
    {
        if ( o != this.dataItem )
        {
            return;
        }
        if ( ! ( arg instanceof DataItemValue ) )
        {
            return;
        }
        fireListenerChange ( (DataItemValue)arg );
    }

    protected void fireListenerChange ( final DataItemValue value )
    {
        if ( this.listener != null )
        {
            this.listener.updateData ( value );
        }
    }

    @Override
    protected synchronized void bindConnection ( final ConnectionService connectionService )
    {
        super.bindConnection ( connectionService );
        if ( connectionService != null )
        {
            this.dataItem = new DataItem ( this.item.getId () );
            this.dataItem.addObserver ( this.observer );
            this.dataItem.register ( connectionService.getItemManager () );
        }
    }

    @Override
    protected synchronized void unbindConnection ()
    {
        super.unbindConnection ();

        if ( this.dataItem != null )
        {
            this.dataItem.deleteObserver ( this.observer );
            this.dataItem.unregister ();
            this.dataItem = null;
        }
        fireListenerChange ( null );
    }

}
