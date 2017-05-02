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
package org.eclipse.scada.vi.details.swt.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.details.swt.source.ValueSourceController;

public abstract class CompositeTransformerController implements ValueSourceController
{

    private static final String[] SEVERITIES = new String[] { "error", "alarm", "warning" };

    protected final List<ValueSourceController> values;

    protected SummaryInformation state;

    public CompositeTransformerController ( final List<ValueSourceController> values )
    {
        this.values = values;
    }

    @Override
    public abstract DataItemValue value ();

    @Override
    public void updateData ( final Map<String, DataValue> values, final SummaryInformation state )
    {
        for ( final ValueSourceController controller : this.values )
        {
            controller.updateData ( values, state );
        }
        this.state = state;
    }

    protected SubscriptionState createState ()
    {
        final SubscriptionState state = !this.state.isConnected () ? SubscriptionState.DISCONNECTED : SubscriptionState.CONNECTED;
        return state;
    }

    protected Map<String, Variant> createAttributes ()
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ();
        attributes.put ( "error", Variant.valueOf ( this.state.isError () ) ); //$NON-NLS-1$
        attributes.put ( "manual", Variant.valueOf ( this.state.isManual () ) ); //$NON-NLS-1$
        attributes.put ( "alarm", Variant.valueOf ( this.state.isAlarm () ) ); //$NON-NLS-1$

        for ( final String severity : SEVERITIES )
        {
            attributes.put ( severity + ".ackRequired", Variant.valueOf ( this.state.isAckRequired ( severity ) ) ); //$NON-NLS-1$    
        }

        return attributes;
    }

}