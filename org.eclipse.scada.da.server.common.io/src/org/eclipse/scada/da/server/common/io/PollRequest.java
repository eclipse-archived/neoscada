/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common.io;

public interface PollRequest
{

    /**
     * Create poll request
     */
    public Object createPollRequest ();

    /**
     * Get the requested timeout in milliseconds
     * 
     * @return the poll request timeout in milliseconds, less then or equal to
     *         zero means no timeout handling
     */
    public long getPollRequestTimeout ();

    /**
     * Handle an incoming message while the job was active
     * 
     * @param message
     *            the incoming message
     * @return if the message as processed
     */
    public boolean handleMessage ( Object message );

    public void handleFailure ();

    public void handleDisconnect ();

    public void handleTimeout ();

    public Long updatePriority ( long now );

    public void dispose ();

}
