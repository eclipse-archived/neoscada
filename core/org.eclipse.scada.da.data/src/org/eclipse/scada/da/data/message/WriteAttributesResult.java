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

public class WriteAttributesResult implements java.io.Serializable, org.eclipse.scada.core.data.ResponseMessage
{
    private static final long serialVersionUID = 1L;

    public WriteAttributesResult ( final org.eclipse.scada.core.data.Response response, final java.util.List<org.eclipse.scada.da.data.AttributeWriteResultEntry> attributeResults, final org.eclipse.scada.core.data.ErrorInformation errorInformation )
    {
        this.response = response;
        this.attributeResults = attributeResults;
        this.errorInformation = errorInformation;
    }

    private final org.eclipse.scada.core.data.Response response;

    @Override
    public org.eclipse.scada.core.data.Response getResponse ()
    {
        return this.response;
    }

    private final java.util.List<org.eclipse.scada.da.data.AttributeWriteResultEntry> attributeResults;

    public java.util.List<org.eclipse.scada.da.data.AttributeWriteResultEntry> getAttributeResults ()
    {
        return this.attributeResults;
    }

    private final org.eclipse.scada.core.data.ErrorInformation errorInformation;

    public org.eclipse.scada.core.data.ErrorInformation getErrorInformation ()
    {
        return this.errorInformation;
    }

    @Override
    public String toString ()
    {
        return "[WriteAttributesResult - " + "response: " + this.response + ", " + "attributeResults: " + this.attributeResults + ", " + "errorInformation: " + this.errorInformation + "]";
    }
}
