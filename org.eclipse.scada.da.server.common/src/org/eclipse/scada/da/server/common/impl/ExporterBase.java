/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common.impl;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.da.core.server.Hive;

public abstract class ExporterBase implements HiveExporter
{
    protected Hive hive = null;

    protected ConnectionInformation connectionInformation;

    public ExporterBase ( final Hive hive, final ConnectionInformation connectionInformation ) throws Exception
    {
        this.hive = hive;
        this.connectionInformation = connectionInformation;
    }

    @Deprecated
    public ExporterBase ( final Class<?> hiveClass, final ConnectionInformation connectionInformation ) throws Exception
    {
        this ( createInstance ( hiveClass ), connectionInformation );
    }

    @Deprecated
    public ExporterBase ( final String hiveClassName, final ConnectionInformation connectionInformation ) throws Exception
    {
        this ( createInstance ( Class.forName ( hiveClassName ) ), connectionInformation );
    }

    @Deprecated
    private static Hive createInstance ( final Class<?> hiveClass ) throws Exception
    {
        return (Hive)hiveClass.newInstance ();
    }

    public Class<?> getHiveClass ()
    {
        return this.hive.getClass ();
    }

    public ConnectionInformation getConnectionInformation ()
    {
        return this.connectionInformation;
    }
}
