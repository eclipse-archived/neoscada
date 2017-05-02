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

public class CreateSession implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public CreateSession ( final java.util.Map<String, String> properties, final Long callbackHandlerId )
    {
        this.properties = properties;
        this.callbackHandlerId = callbackHandlerId;
    }

    private final java.util.Map<String, String> properties;

    public java.util.Map<String, String> getProperties ()
    {
        return this.properties;
    }

    private final Long callbackHandlerId;

    public Long getCallbackHandlerId ()
    {
        return this.callbackHandlerId;
    }

    @Override
    public String toString ()
    {
        return "[CreateSession - " + "properties: " + this.properties + ", " + "callbackHandlerId: " + this.callbackHandlerId + "]";
    }
}
