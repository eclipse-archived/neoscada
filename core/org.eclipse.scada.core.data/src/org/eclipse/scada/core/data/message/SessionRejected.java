/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.core.data.message;

public class SessionRejected implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public SessionRejected ( final String errorReason )
    {
        this.errorReason = errorReason;
    }

    private final String errorReason;

    public String getErrorReason ()
    {
        return this.errorReason;
    }

    @Override
    public String toString ()
    {
        return "[SessionRejected - " + "errorReason: " + this.errorReason + "]";
    }
}
