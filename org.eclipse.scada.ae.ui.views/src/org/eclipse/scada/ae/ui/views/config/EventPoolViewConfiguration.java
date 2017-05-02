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
public class EventPoolViewConfiguration
{
    private final String monitorQueryId;

    private final String eventPoolQueryId;

    private final String connectionString;

    private final ConnectionType connectionType;

    private final String id;

    private final String label;

    private final Integer maxNumberOfEvents;

    private final int forceEventLimit;

    private final List<ColumnLabelProviderInformation> columnInformation;

    public EventPoolViewConfiguration ( final String id, final String monitorQueryId, final String eventPoolQueryId, final String connectionString, final ConnectionType connectionType, final String label, final int maxNumberOfEvents, final int forceEventLimit, final List<ColumnLabelProviderInformation> columnInformation )
    {
        super ();
        this.id = id;
        this.eventPoolQueryId = eventPoolQueryId;
        this.monitorQueryId = monitorQueryId;
        this.connectionString = connectionString;
        this.connectionType = connectionType;
        this.label = label;
        this.maxNumberOfEvents = maxNumberOfEvents;
        this.forceEventLimit = forceEventLimit;
        this.columnInformation = columnInformation;

        if ( this.id == null )
        {
            throw new IllegalArgumentException ( Messages.EventPoolViewConfiguration_IllegalArgument_id );
        }
        if ( this.monitorQueryId == null )
        {
            throw new IllegalArgumentException ( Messages.EventPoolViewConfiguration_IllegalArgument_monitorQueryId );
        }
        if ( this.connectionString == null )
        {
            throw new IllegalArgumentException ( Messages.EventPoolViewConfiguration_IllegalArgument_connectionString );
        }
        if ( this.connectionType == null )
        {
            throw new IllegalArgumentException ( Messages.EventPoolViewConfiguration_IllegalArgument_connectionType );
        }
        if ( this.eventPoolQueryId == null )
        {
            throw new IllegalArgumentException ( Messages.EventPoolViewConfiguration_IllegalArgument_eventPoolQueryId );
        }
    }

    public List<ColumnLabelProviderInformation> getColumnInformation ()
    {
        return this.columnInformation;
    }

    public int getForceEventLimit ()
    {
        return this.forceEventLimit;
    }

    public String getEventPoolQueryId ()
    {
        return this.eventPoolQueryId;
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

    public Integer getMaxNumberOfEvents ()
    {
        return this.maxNumberOfEvents;
    }
}
