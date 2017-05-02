/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.event;

import org.eclipse.scada.ae.Event;

/**
 * A service which will handle events
 * @author Jens Reimann
 *
 */
public interface EventService
{
    /**
     * Publish the provided event
     * @param event the event to publish
     */
    public void publishEvent ( Event event );
}
