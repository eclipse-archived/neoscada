/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.datasource.script;

import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue;

/**
 * A class that renames the original {@link DataItemValue.Builder} since some
 * script languages might have problems accessing a nested class or enums.
 * @author Jens Reimann
 *
 */
public class DataItemValueBuilder extends DataItemValue.Builder
{
    public static SubscriptionState CONNECTED = SubscriptionState.CONNECTED;

    public static SubscriptionState GRANTED = SubscriptionState.GRANTED;

    public static SubscriptionState DISCONNECTED = SubscriptionState.DISCONNECTED;

    public void setConnected ( final boolean flag )
    {
        setSubscriptionState ( flag ? SubscriptionState.CONNECTED : SubscriptionState.DISCONNECTED );
    }
}
