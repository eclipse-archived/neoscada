/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.handler.filter;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.filter.EventMatcher;
import org.eclipse.scada.ae.filter.internal.EventMatcherImpl;
import org.eclipse.scada.ae.server.handler.AbstractEventHandler;
import org.eclipse.scada.ae.server.handler.InjectionContext;
import org.eclipse.scada.utils.filter.Filter;

public class FilterEventHandler extends AbstractEventHandler
{
    private final EventMatcher matcher;

    private final boolean pass;

    public FilterEventHandler ( final Filter filter, final boolean pass )
    {
        this.matcher = new EventMatcherImpl ( filter );
        this.pass = pass;
    }

    @Override
    public Event handleEvent ( final Event event, final InjectionContext context )
    {
        if ( this.matcher.matches ( event ) )
        {
            if ( this.pass )
            {
                return event;
            }
            else
            {
                return null;
            }
        }
        else
        {
            if ( this.pass )
            {
                return null;
            }
            else
            {
                return event;
            }
        }
    }

}
