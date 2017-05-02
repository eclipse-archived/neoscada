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
package org.eclipse.scada.ca.data;

public class DiffEntry implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public DiffEntry ( final String factoryId, final String configurationId, final org.eclipse.scada.ca.data.Operation operation, final java.util.Map<String, String> oldData, final java.util.Map<String, String> addedOrUpdatedData, final java.util.Set<String> removedData )
    {
        this.factoryId = factoryId;
        this.configurationId = configurationId;
        this.operation = operation;
        this.oldData = oldData;
        this.addedOrUpdatedData = addedOrUpdatedData;
        this.removedData = removedData;
    }

    private final String factoryId;

    public String getFactoryId ()
    {
        return this.factoryId;
    }

    private final String configurationId;

    public String getConfigurationId ()
    {
        return this.configurationId;
    }

    private final org.eclipse.scada.ca.data.Operation operation;

    public org.eclipse.scada.ca.data.Operation getOperation ()
    {
        return this.operation;
    }

    private final transient java.util.Map<String, String> oldData;

    public java.util.Map<String, String> getOldData ()
    {
        return this.oldData;
    }

    private final java.util.Map<String, String> addedOrUpdatedData;

    public java.util.Map<String, String> getAddedOrUpdatedData ()
    {
        return this.addedOrUpdatedData;
    }

    private final java.util.Set<String> removedData;

    public java.util.Set<String> getRemovedData ()
    {
        return this.removedData;
    }

    @Override
    public String toString ()
    {
        return "[DiffEntry - " + "factoryId: " + this.factoryId + ", " + "configurationId: " + this.configurationId + ", " + "operation: " + this.operation + ", " + "oldData: " + this.oldData + ", " + "addedOrUpdatedData: " + this.addedOrUpdatedData + ", " + "removedData: " + this.removedData + "]";
    }
}
