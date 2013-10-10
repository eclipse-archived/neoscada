/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.client.net;

public class DisconnectReason extends Exception
{
    private static final long serialVersionUID = 1L;

    private final String reason;

    public DisconnectReason ()
    {
        super ( Messages.getString("DisconnectReason.Message") ); //$NON-NLS-1$
        this.reason = ""; //$NON-NLS-1$
    }

    public DisconnectReason ( final String reason )
    {
        super ( String.format ( Messages.getString("DisconnectReason.MessageWithDetails"), reason ) ); //$NON-NLS-1$
        this.reason = reason;
    }

    public String getReason ()
    {
        return this.reason;
    }
}
