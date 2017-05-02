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
package org.eclipse.scada.vi.ui.user.navigation;

import java.util.EnumSet;
import java.util.Set;

import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.ui.connection.data.DataItemHolder;
import org.eclipse.scada.da.ui.connection.data.DataSourceListener;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.styles.DataItemValueStateExtractor;
import org.eclipse.scada.core.ui.styles.StateInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemSummaryProvider implements StateProvider
{

    private final static Logger logger = LoggerFactory.getLogger ( ItemSummaryProvider.class );

    private final StateListener stateListener;

    private final DataSourceListener listener = new DataSourceListener () {

        @Override
        public void updateData ( final DataItemValue value )
        {
            handleValueChange ( value );
        }
    };

    private final DataItemHolder itemHolder;

    public ItemSummaryProvider ( final StateListener stateListener, final Item item )
    {
        this.stateListener = stateListener;

        // initialize with DISCONNECTED
        stateListener.stateChange ( new StateInformation () {

            @Override
            public Set<State> getStates ()
            {
                return EnumSet.of ( State.DISCONNECTED );
            }
        } );
        this.itemHolder = new DataItemHolder ( org.eclipse.scada.vi.ui.user.Activator.getDefault ().getBundle ().getBundleContext (), item, this.listener );
    }

    protected void handleValueChange ( final DataItemValue value )
    {
        logger.debug ( "Summary item value changed: {}", value );

        if ( this.listener == null )
        {
            return;
        }
        this.stateListener.stateChange ( new DataItemValueStateExtractor ( value ) );
    }

    @Override
    public void dispose ()
    {
        this.itemHolder.dispose ();
    }

}
