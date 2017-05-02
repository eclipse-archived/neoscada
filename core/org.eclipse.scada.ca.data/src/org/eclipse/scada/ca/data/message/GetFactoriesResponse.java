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
package org.eclipse.scada.ca.data.message;

public class GetFactoriesResponse implements java.io.Serializable, org.eclipse.scada.core.data.ResponseMessage
{
    private static final long serialVersionUID = 1L;

    public GetFactoriesResponse ( final org.eclipse.scada.core.data.Response response, final java.util.List<org.eclipse.scada.ca.data.FactoryInformation> factories )
    {
        this.response = response;
        this.factories = factories;
    }

    private final org.eclipse.scada.core.data.Response response;

    @Override
    public org.eclipse.scada.core.data.Response getResponse ()
    {
        return this.response;
    }

    private final java.util.List<org.eclipse.scada.ca.data.FactoryInformation> factories;

    public java.util.List<org.eclipse.scada.ca.data.FactoryInformation> getFactories ()
    {
        return this.factories;
    }

    @Override
    public String toString ()
    {
        return "[GetFactoriesResponse - " + "response: " + this.response + ", " + "factories: " + this.factories + "]";
    }
}
