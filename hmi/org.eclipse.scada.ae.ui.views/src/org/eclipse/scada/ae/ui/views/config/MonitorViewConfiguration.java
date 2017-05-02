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

import java.util.Collections;
import java.util.List;

import org.eclipse.scada.ae.ui.views.views.ColumnProperties;
import org.eclipse.scada.utils.lang.Immutable;

@Immutable
public class MonitorViewConfiguration
{
    private final String id;

    private final String label;

    private final String monitorQueryId;

    private final String connectionString;

    private final ConnectionType connectionType;

    private final List<ColumnProperties> columns;

    public MonitorViewConfiguration ( final String id, final String monitorQueryId, final String connectionString, final ConnectionType connectionType, final String label, final List<ColumnProperties> columns )
    {
        super ();
        this.id = id;
        this.monitorQueryId = monitorQueryId;
        this.connectionString = connectionString;
        this.connectionType = connectionType;
        this.label = label;
        this.columns = columns;

        if ( this.id == null )
        {
            throw new IllegalArgumentException ( Messages.MonitorViewConfiguration_IllegalArgument_id );
        }
        if ( this.monitorQueryId == null )
        {
            throw new IllegalArgumentException ( Messages.MonitorViewConfiguration_IllegalArgument_monitorQueryId );
        }
        if ( this.connectionString == null )
        {
            throw new IllegalArgumentException ( Messages.MonitorViewConfiguration_IllegalArgument_connectionString );
        }
        if ( this.connectionType == null )
        {
            throw new IllegalArgumentException ( Messages.MonitorViewConfiguration_IllegalArgument_connectionType );
        }
    }

    public String getConnectionString ()
    {
        return this.connectionString;
    }

    public ConnectionType getConnectionType ()
    {
        return this.connectionType;
    }

    public String getMonitorQueryId ()
    {
        return this.monitorQueryId;
    }

    public String getId ()
    {
        return this.id;
    }

    public String getLabel ()
    {
        return this.label;
    }

    @SuppressWarnings ( "unchecked" )
    public List<ColumnProperties> getColumns ()
    {
        return Collections.unmodifiableList ( columns == null ? Collections.EMPTY_LIST : columns );
    }
}
