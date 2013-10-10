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
package org.eclipse.scada.core.client.ngp;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.info.StatisticsImpl;
import org.eclipse.scada.sec.callback.CallbackHandler;

public class CallbackHandlerManager
{
    private static final Object STAT_REGISTERED_CALLBACK_HANDLERS = new Object ();

    private final Map<Long, CallbackHandler> map = new HashMap<Long, CallbackHandler> ();

    private final StatisticsImpl statistics;

    public CallbackHandlerManager ( final StatisticsImpl statistics )
    {
        this.statistics = statistics;
        this.statistics.setLabel ( STAT_REGISTERED_CALLBACK_HANDLERS, "Registered callback handlers" );
    }

    public void registerHandler ( final long handlerId, final CallbackHandler callbackHandler )
    {
        this.map.put ( handlerId, callbackHandler );
        this.statistics.setCurrentValue ( STAT_REGISTERED_CALLBACK_HANDLERS, this.map.size () );
    }

    public void unregisterHandler ( final long handlerId )
    {
        this.map.remove ( handlerId );
        this.statistics.setCurrentValue ( STAT_REGISTERED_CALLBACK_HANDLERS, this.map.size () );
    }

    public CallbackHandler getHandler ( final long handlerId )
    {
        return this.map.get ( handlerId );
    }

}
