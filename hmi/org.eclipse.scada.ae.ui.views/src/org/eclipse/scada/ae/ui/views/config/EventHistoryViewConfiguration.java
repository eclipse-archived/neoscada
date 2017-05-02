/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.config;

import java.util.List;

import org.eclipse.scada.utils.lang.Immutable;

@Immutable
public class EventHistoryViewConfiguration
{
    private final String connectionString;

    private final ConnectionType connectionType;

    private final String id;

    private final String label;

    private final List<ColumnLabelProviderInformation> columnInformation;

    public EventHistoryViewConfiguration ( final String id, final String connectionString, final ConnectionType connectionType, final String label, final List<ColumnLabelProviderInformation> columnInformation )
    {
        super ();
        this.id = id;
        this.connectionString = connectionString;
        this.connectionType = connectionType;
        this.label = label;
        this.columnInformation = columnInformation;

        if ( this.id == null )
        {
            throw new IllegalArgumentException ( Messages.EventHistoryViewConfiguration_IllegalArgument_id );
        }
        if ( this.connectionString == null )
        {
            throw new IllegalArgumentException ( Messages.EventHistoryViewConfiguration_IllegalArgument_connectionString );
        }
        if ( this.connectionType == null )
        {
            throw new IllegalArgumentException ( Messages.EventHistoryViewConfiguration_IllegalArgument_connectionType );
        }
    }

    public List<ColumnLabelProviderInformation> getColumnInformation ()
    {
        return this.columnInformation;
    }

    public String getConnectionString ()
    {
        return this.connectionString;
    }

    public ConnectionType getConnectionType ()
    {
        return this.connectionType;
    }

    public String getId ()
    {
        return this.id;
    }

    public String getLabel ()
    {
        return this.label;
    }
}
