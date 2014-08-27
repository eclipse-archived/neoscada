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
package org.eclipse.scada.ae.server.injector.internal;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.server.injector.EventInjector;
import org.eclipse.scada.ae.server.injector.filter.EventFilter;
import org.eclipse.scada.ae.server.injector.monitor.EventMonitorEvaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventInjectorImpl implements EventInjector
{
    private final static Logger logger = LoggerFactory.getLogger ( EventInjectorImpl.class );

    private final EventProcessor processor;

    private final EventFilter eventFilter;

    private final EventMonitorEvaluator evaluator;

    public EventInjectorImpl ( final EventProcessor processor, final EventFilter eventFilter, final EventMonitorEvaluator evaluator )
    {
        this.processor = processor;
        this.eventFilter = eventFilter;
        this.evaluator = evaluator;
    }

    @Override
    public void injectEvent ( final Event event )
    {
        if ( this.eventFilter != null && this.eventFilter.matches ( event ) )
        {
            // filter event
            logger.trace ( "Filter discarded event: {}", event );
        }
        else
        {
            // publish event
            final Event evalEvent = this.evaluator.evaluate ( event );
            this.processor.publishEvent ( evalEvent );
        }
    }

    public void dispose ()
    {
    }
}
