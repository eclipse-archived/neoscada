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
package org.eclipse.scada.ae.server.storage;

import java.util.UUID;

import org.eclipse.scada.ae.Event;

public interface Storage
{
    public Event store ( final Event event );

    public Event store ( final Event event, final StoreListener listener );

    public Query query ( final String filter ) throws Exception;

    public Event update ( final UUID id, final String comment ) throws Exception;

    public Event update ( final UUID id, final String comment, final StoreListener listener ) throws Exception;
}
