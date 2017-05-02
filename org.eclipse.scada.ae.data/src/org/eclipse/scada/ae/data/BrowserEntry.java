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
package org.eclipse.scada.ae.data;

public class BrowserEntry implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public BrowserEntry ( final String id, final java.util.Set<org.eclipse.scada.ae.data.BrowserType> types, final java.util.Map<String, org.eclipse.scada.core.Variant> attributes )
    {
        this.id = id;
        this.types = types;
        this.attributes = attributes;
    }

    private final String id;

    public String getId ()
    {
        return this.id;
    }

    private final java.util.Set<org.eclipse.scada.ae.data.BrowserType> types;

    public java.util.Set<org.eclipse.scada.ae.data.BrowserType> getTypes ()
    {
        return this.types;
    }

    private final java.util.Map<String, org.eclipse.scada.core.Variant> attributes;

    public java.util.Map<String, org.eclipse.scada.core.Variant> getAttributes ()
    {
        return this.attributes;
    }

    @Override
    public String toString ()
    {
        return "[BrowserEntry - " + "id: " + this.id + ", " + "types: " + this.types + ", " + "attributes: " + this.attributes + "]";
    }
}
