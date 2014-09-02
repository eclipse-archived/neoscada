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
package org.eclipse.scada.ae.server.handler;

import org.eclipse.scada.ae.Event;

public interface EventHandler
{
    /**
     * Handle an event
     *
     * @param event
     *            the event to handle
     * @param context
     *            the context
     * @return return the event that goes to the next handler. Or
     *         <code>null</code> if the event
     *         should not be passed to the next handler.
     */
    public Event handleEvent ( Event event, InjectionContext context );

    public void dispose ();
}
