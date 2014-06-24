/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.driver.jdbc.lib;

import org.eclipse.scada.configuration.driver.jdbc.JdbcDriverInstance;
import org.eclipse.scada.configuration.world.lib.CommonDriverProcessor;
import org.eclipse.scada.da.server.exporter.HiveConfigurationType;
import org.eclipse.scada.da.server.jdbc.configuration.ConfigurationPackage;

public class DriverProcessor extends CommonDriverProcessor
{
    private final JdbcDriverInstance jdbcDriver;

    public DriverProcessor ( final JdbcDriverInstance jdbcDriver )
    {
        super ( jdbcDriver );
        this.jdbcDriver = jdbcDriver;
    }

    @Override
    protected void addConfiguration ( final HiveConfigurationType hiveCfg )
    {
        hiveCfg.getAny ().add ( ConfigurationPackage.Literals.DOCUMENT_ROOT__ROOT, this.jdbcDriver.getRoot () );
    }

    @Override
    protected String getHiveId ()
    {
        return "org.eclipse.scada.da.server.jdbc.Hive"; //$NON-NLS-1$
    }

}
