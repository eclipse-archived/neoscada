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
package org.eclipse.scada.da.data.message;

public class SubscribeFolder implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public SubscribeFolder ( final java.util.List<String> location )
    {
        this.location = location;
    }

    private final java.util.List<String> location;

    public java.util.List<String> getLocation ()
    {
        return this.location;
    }

    @Override
    public String toString ()
    {
        return "[SubscribeFolder - " + "location: " + this.location + "]";
    }
}
