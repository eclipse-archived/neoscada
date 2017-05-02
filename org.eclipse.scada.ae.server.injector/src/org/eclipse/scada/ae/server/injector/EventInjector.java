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
package org.eclipse.scada.ae.server.injector;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.server.handler.InjectionContext;

/**
 * A service interface to inject events from external sources into the AE system
 */
public interface EventInjector
{
    /**
     * Inject an event entry from an external source into the AE system
     *
     * @param event
     *            the event to inject
     * @param context
     *            an optional (may be <code>null</code>) context were the event
     *            came from
     */
    public void injectEvent ( Event event, InjectionContext context );
}
