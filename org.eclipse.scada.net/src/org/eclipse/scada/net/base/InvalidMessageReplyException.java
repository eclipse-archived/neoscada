/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.net.base;

public class InvalidMessageReplyException extends Exception
{

    private static final long serialVersionUID = 5383513193481537280L;

    public InvalidMessageReplyException ()
    {
        super ( "Invalid message reply" );
    }

    public InvalidMessageReplyException ( final String message )
    {
        super ( "Invalid message reply: " + message );
    }
}
