/*******************************************************************************
 * Copyright (c) 2006, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.osgi.jdbc.data;

public class RowMapperException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public RowMapperException ()
    {
        super ();
    }

    public RowMapperException ( final String message, final Throwable cause )
    {
        super ( message, cause );
    }

    public RowMapperException ( final String message )
    {
        super ( message );
    }

    public RowMapperException ( final Throwable cause )
    {
        super ( cause );
    }

}