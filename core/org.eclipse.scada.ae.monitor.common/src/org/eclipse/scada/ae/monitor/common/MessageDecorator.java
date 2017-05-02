/*******************************************************************************
 * Copyright (c) 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.monitor.common;

import java.util.Map;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Event.EventBuilder;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.utils.lang.Immutable;

@Immutable
public class MessageDecorator implements MonitorDecorator
{
    private final Variant message;

    public MessageDecorator ( final Variant message )
    {
        this.message = message;
    }

    @Override
    public void decorateEvent ( final EventBuilder builder )
    {
        if ( this.message != null )
        {
            builder.attribute ( Event.Fields.MESSAGE, this.message );
        }
    }

    @Override
    public void decorateMonitorAttributes ( final Map<String, Variant> attributes )
    {
        if ( this.message != null )
        {
            attributes.put ( Event.Fields.MESSAGE.getName (), this.message );
        }
    }

}
