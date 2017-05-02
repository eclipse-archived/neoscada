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
package org.eclipse.scada.sec;

import org.eclipse.scada.utils.statuscodes.CodedException;
import org.eclipse.scada.utils.statuscodes.StatusCode;

public class AuthenticationException extends CodedException
{

    private static final long serialVersionUID = 1320807611229839462L;

    public AuthenticationException ( final StatusCode statusCode, final String message, final Throwable cause )
    {
        super ( statusCode, message, cause );
    }

    public AuthenticationException ( final StatusCode statusCode, final String message )
    {
        super ( statusCode, message );
    }

    public AuthenticationException ( final StatusCode statusCode, final Throwable cause )
    {
        super ( statusCode, cause );
    }

    public AuthenticationException ( final StatusCode statusCode )
    {
        super ( statusCode );
    }

}
