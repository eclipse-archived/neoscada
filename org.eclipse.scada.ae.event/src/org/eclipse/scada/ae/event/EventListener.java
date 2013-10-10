/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.event;

import java.util.List;

import org.eclipse.scada.ae.Event;

/**
 * An interface to listen for AE events
 * 
 * @author Jens Reimann
 */
public interface EventListener
{
    /**
     * Handle the provided events
     * 
     * @param event
     *            the events to handle
     */
    public void handleEvent ( List<Event> event );
}
