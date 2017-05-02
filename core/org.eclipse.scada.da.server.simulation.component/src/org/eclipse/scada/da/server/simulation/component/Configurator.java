/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.simulation.component;

import org.eclipse.scada.da.server.simulation.component.modules.SimpleMOV;

public class Configurator
{
    private Hive hive = null;

    public Configurator ( final Hive hive )
    {
        this.hive = hive;
    }

    public void configure ()
    {
        this.hive.addModule ( new SimpleMOV ( this.hive, "1000" ) );
    }
}
