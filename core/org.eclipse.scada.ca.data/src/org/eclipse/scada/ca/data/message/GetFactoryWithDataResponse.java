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

public class GetFactoryWithDataResponse implements java.io.Serializable, org.eclipse.scada.core.data.ResponseMessage
{
    private static final long serialVersionUID = 1L;

    public GetFactoryWithDataResponse ( final org.eclipse.scada.core.data.Response response, final org.eclipse.scada.ca.data.FactoryInformation factory )
    {
        this.response = response;
        this.factory = factory;
    }

    private final org.eclipse.scada.core.data.Response response;

    @Override
    public org.eclipse.scada.core.data.Response getResponse ()
    {
        return this.response;
    }

    private final org.eclipse.scada.ca.data.FactoryInformation factory;

    public org.eclipse.scada.ca.data.FactoryInformation getFactory ()
    {
        return this.factory;
    }

    @Override
    public String toString ()
    {
        return "[GetFactoryWithDataResponse - " + "response: " + this.response + ", " + "factory: " + this.factory + "]";
    }
}
