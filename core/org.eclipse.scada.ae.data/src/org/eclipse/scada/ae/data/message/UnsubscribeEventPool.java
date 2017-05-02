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
package org.eclipse.scada.ae.data.message;

public class UnsubscribeEventPool implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public UnsubscribeEventPool ( final String eventPoolId )
    {
        this.eventPoolId = eventPoolId;
    }

    private final String eventPoolId;

    public String getEventPoolId ()
    {
        return this.eventPoolId;
    }

    @Override
    public String toString ()
    {
        return "[UnsubscribeEventPool - " + "eventPoolId: " + this.eventPoolId + "]";
    }
}
