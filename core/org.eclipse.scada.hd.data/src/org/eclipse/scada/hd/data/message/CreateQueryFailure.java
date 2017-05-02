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
package org.eclipse.scada.hd.data.message;

public class CreateQueryFailure implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public CreateQueryFailure ( final org.eclipse.scada.core.data.Response response, final org.eclipse.scada.core.data.ErrorInformation errorInformation )
    {
        this.response = response;
        this.errorInformation = errorInformation;
    }

    private final org.eclipse.scada.core.data.Response response;

    public org.eclipse.scada.core.data.Response getResponse ()
    {
        return this.response;
    }

    private final org.eclipse.scada.core.data.ErrorInformation errorInformation;

    public org.eclipse.scada.core.data.ErrorInformation getErrorInformation ()
    {
        return this.errorInformation;
    }

    @Override
    public String toString ()
    {
        return "[CreateQueryFailure - " + "response: " + this.response + ", " + "errorInformation: " + this.errorInformation + "]";
    }
}
