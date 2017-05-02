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
package org.eclipse.scada.protocol.relp.data;

import java.util.Map;

public class OpenRequest
{
    private final long transactionId;

    private final Map<String, String> offers;

    public OpenRequest ( final long transactionId, final Map<String, String> offers )
    {
        this.transactionId = transactionId;
        this.offers = offers;
    }

    public long getTransactionId ()
    {
        return this.transactionId;
    }

    public Map<String, String> getOffers ()
    {
        return this.offers;
    }

    public OpenResponse replyOk ( final Map<String, String> offers )
    {
        return new OpenResponse ( this.transactionId, offers );
    }
}
