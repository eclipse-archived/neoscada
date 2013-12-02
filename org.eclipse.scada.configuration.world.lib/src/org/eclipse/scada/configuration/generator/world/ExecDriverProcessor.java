/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.generator.world;

import org.eclipse.scada.configuration.world.ExecDriver;
import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;
import org.eclipse.scada.da.server.exporter.HiveConfigurationType;

public class ExecDriverProcessor extends CommonDriverProcessor
{
    private final ExecDriver execDriver;

    public ExecDriverProcessor ( final ExecDriver execDriver )
    {
        super ( execDriver );
        this.execDriver = execDriver;
    }

    @Override
    protected void addConfiguration ( final HiveConfigurationType hiveCfg )
    {
        hiveCfg.getAny ().add ( ConfigurationPackage.Literals.DOCUMENT_ROOT__ROOT, this.execDriver.getRoot () );
    }

    @Override
    protected String getHiveId ()
    {
        return "org.eclipse.scada.da.server.exec.Hive";
    }

}
