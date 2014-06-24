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
package org.eclipse.scada.configuration.component.exec.lib;

import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.configuration.world.ExecDriver;
import org.eclipse.scada.configuration.world.WorldFactory;
import org.eclipse.scada.configuration.infrastructure.lib.AbstractCommonDriverFactory;

public class ExecDriverFactory extends AbstractCommonDriverFactory<ExecDriver>
{

    @Override
    protected ExecDriver createDriver ()
    {
        final ExecDriver driver = WorldFactory.eINSTANCE.createExecDriver ();
        driver.setRoot ( org.eclipse.scada.da.exec.configuration.ConfigurationFactory.eINSTANCE.createRootType () );
        return driver;
    }

    @Override
    protected void configureDriver ( final World world, final AbstractFactoryDriver infraDriver, final ExecDriver driver )
    {
    }
}
