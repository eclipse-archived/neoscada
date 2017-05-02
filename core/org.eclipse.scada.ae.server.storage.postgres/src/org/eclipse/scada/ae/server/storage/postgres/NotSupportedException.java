/*******************************************************************************
 * Copyright (c) 2013 Jürgen Rose and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jürgen Rose - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.storage.postgres;

public class NotSupportedException extends Exception
{

    private static final long serialVersionUID = -530194790629785166L;

    public NotSupportedException ()
    {
        super ();
    }

    public NotSupportedException ( final String message, final Throwable cause )
    {
        super ( message, cause );
    }

    public NotSupportedException ( final String message )
    {
        super ( message );
    }

    public NotSupportedException ( final Throwable cause )
    {
        super ( cause );
    }
}
