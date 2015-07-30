/*******************************************************************************
 * Copyright (c) 2010, 2015 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - use exported executors
 *******************************************************************************/
package org.eclipse.scada.core.client.common;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.utils.concurrent.ScheduledExportedExecutorService;
import org.eclipse.scada.utils.stats.StatisticEntry;
import org.eclipse.scada.utils.stats.StatisticsImpl;
import org.eclipse.scada.utils.stats.StatisticsProvider;

public class BaseConnection implements StatisticsProvider
{
    protected final ConnectionInformation connectionInformation;

    protected final ScheduledExecutorService executor;

    private volatile Map<String, String> sessionProperties = Collections.emptyMap ();

    protected final StatisticsImpl statistics;

    public BaseConnection ( final ConnectionInformation connectionInformation )
    {
        this.connectionInformation = connectionInformation;
        this.executor = ScheduledExportedExecutorService.newSingleThreadExportedScheduledExecutor ( connectionInformation.toMaskedString () );

        this.statistics = new StatisticsImpl ();
    }

    public void dispose ()
    {
        this.executor.shutdown ();
    }

    public ConnectionInformation getConnectionInformation ()
    {
        return this.connectionInformation;
    }

    protected void setSessionProperties ( final Map<String, String> sessionProperties )
    {
        this.sessionProperties = sessionProperties;
    }

    public Map<String, String> getSessionProperties ()
    {
        return this.sessionProperties;
    }

    @Override
    public Collection<StatisticEntry> getStatistics ()
    {
        return this.statistics.getEntries ();
    }
}
