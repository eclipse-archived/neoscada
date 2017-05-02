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

public class OpenResponse extends AbstractGenericResponse
{
    private final Map<String, String> offers;

    public OpenResponse ( final long transactionId, final Map<String, String> offers )
    {
        super ( transactionId, 200, "OK" );
        this.offers = offers;
    }

    public Map<String, String> getOffers ()
    {
        return this.offers;
    }
}
