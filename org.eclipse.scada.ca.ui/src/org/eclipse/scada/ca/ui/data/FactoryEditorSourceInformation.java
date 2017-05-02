/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.ui.data;

import org.eclipse.scada.ca.connection.provider.ConnectionService;

public class FactoryEditorSourceInformation
{
    private final ConnectionService connection;

    private final String factoryId;

    public FactoryEditorSourceInformation ( final ConnectionService connection, final String factoryId )
    {
        this.connection = connection;
        this.factoryId = factoryId;
    }

    public ConnectionService getConnection ()
    {
        return this.connection;
    }

    public String getFactoryId ()
    {
        return this.factoryId;
    }
}
