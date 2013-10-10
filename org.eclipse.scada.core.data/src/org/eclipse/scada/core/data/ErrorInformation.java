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
package org.eclipse.scada.core.data;

public class ErrorInformation implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public ErrorInformation ( final Long code, final String message, final String diagnosticInformation )
    {
        this.code = code;
        this.message = message;
        this.diagnosticInformation = diagnosticInformation;
    }

    private final Long code;

    public Long getCode ()
    {
        return this.code;
    }

    private final String message;

    public String getMessage ()
    {
        return this.message;
    }

    private final String diagnosticInformation;

    public String getDiagnosticInformation ()
    {
        return this.diagnosticInformation;
    }

    @Override
    public String toString ()
    {
        return "[ErrorInformation - " + "code: " + this.code + ", " + "message: " + this.message + ", " + "diagnosticInformation: " + this.diagnosticInformation + "]";
    }
}
