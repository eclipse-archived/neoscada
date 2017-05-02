/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.modbus.internal;

import java.util.concurrent.atomic.AtomicLong;

import org.eclipse.scada.utils.beans.AbstractPropertyChange;

public class InformationBean extends AbstractPropertyChange
{
    public static final String PROP_ACTIVE_SESSIONS = "activeSessions";

    public static final String PROP_MESSAGES_RECEIVED = "messagesReceived";

    public static final String PROP_READ_REQUESTS_RECEIVED = "readRequestsReceived";

    public static final String PROP_READ_HOLDING_REQUESTS_RECEIVED = "readHoldingRequestsReceived";

    public static final String PROP_READ_INPUT_REQUESTS_RECEIVED = "readInputRequestsReceived";

    public static final String PROP_ERROR_REPLIES = "errorReplies";

    public static final String PROP_WRITE_REQUESTS_SINGLE_RECEIVED = "writeRequestsSingleReceived";

    public static final String PROP_WRITE_REQUESTS_MULTI_RECEIVED = "writeRequestsMultiReceived";

    private final AtomicLong activeSessions = new AtomicLong ();

    private final AtomicLong messagesReceived = new AtomicLong ();

    private final AtomicLong readRequestsReceived = new AtomicLong ();

    private final AtomicLong readHoldingRequestsReceived = new AtomicLong ();

    private final AtomicLong readInputRequestsReceived = new AtomicLong ();

    private final AtomicLong writeRequestsSingleReceived = new AtomicLong ();

    private final AtomicLong writeRequestsMultiReceived = new AtomicLong ();

    private final AtomicLong errorReplies = new AtomicLong ();

    public long getActiveSessions ()
    {
        return this.activeSessions.get ();
    }

    public long getMessagesReceived ()
    {
        return this.messagesReceived.get ();
    }

    public long getReadRequestsReceived ()
    {
        return this.readRequestsReceived.get ();
    }

    public long getReadHoldingRequestsReceived ()
    {
        return this.readHoldingRequestsReceived.get ();
    }

    public long getReadInputRequestsReceived ()
    {
        return this.readInputRequestsReceived.get ();
    }

    public long getErrorReplies ()
    {
        return this.errorReplies.get ();
    }

    public long getWriteRequestsSingleReceived ()
    {
        return this.writeRequestsSingleReceived.get ();
    }

    public long getWriteRequestsMultiReceived ()
    {
        return this.writeRequestsMultiReceived.get ();
    }

    public void incrementActiveSessions ()
    {
        final long newValue = this.activeSessions.incrementAndGet ();
        firePropertyChange ( PROP_ACTIVE_SESSIONS, null, newValue );
    }

    public void decrementActiveSessions ()
    {
        final long newValue = this.activeSessions.decrementAndGet ();
        firePropertyChange ( PROP_ACTIVE_SESSIONS, null, newValue );
    }

    public void incrementMessagesReceived ()
    {
        final long newValue = this.messagesReceived.incrementAndGet ();
        firePropertyChange ( PROP_MESSAGES_RECEIVED, null, newValue );
    }

    public void incrementReadRequestReceived ()
    {
        final long newValue = this.readRequestsReceived.incrementAndGet ();
        firePropertyChange ( PROP_READ_REQUESTS_RECEIVED, null, newValue );
    }

    public void incrementWriteRequestSingleReceived ()
    {
        final long newValue = this.writeRequestsSingleReceived.incrementAndGet ();
        firePropertyChange ( PROP_WRITE_REQUESTS_SINGLE_RECEIVED, null, newValue );
    }

    public void incrementWriteRequestMultiReceived ()
    {
        final long newValue = this.writeRequestsMultiReceived.incrementAndGet ();
        firePropertyChange ( PROP_WRITE_REQUESTS_MULTI_RECEIVED, null, newValue );
    }

    public void incrementReadHoldingRequestReceived ()
    {
        final long newValue = this.readHoldingRequestsReceived.incrementAndGet ();
        firePropertyChange ( PROP_READ_HOLDING_REQUESTS_RECEIVED, null, newValue );
    }

    public void incrementReadInputRequestReceived ()
    {
        final long newValue = this.readInputRequestsReceived.incrementAndGet ();
        firePropertyChange ( PROP_READ_INPUT_REQUESTS_RECEIVED, null, newValue );
    }

    public void incrementErrorReplies ()
    {
        final long newValue = this.errorReplies.incrementAndGet ();
        firePropertyChange ( PROP_ERROR_REPLIES, null, newValue );
    }

}
