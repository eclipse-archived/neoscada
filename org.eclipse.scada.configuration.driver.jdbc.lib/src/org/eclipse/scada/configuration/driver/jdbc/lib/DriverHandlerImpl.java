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

import org.eclipse.scada.configuration.driver.jdbc.JdbcDriver;
import org.eclipse.scada.configuration.driver.jdbc.JdbcDriverInstance;
import org.eclipse.scada.configuration.driver.jdbc.JdbcFactory;
import org.eclipse.scada.configuration.infrastructure.lib.AbstractCommonDriverHandler;

public class DriverHandlerImpl extends AbstractCommonDriverHandler<JdbcDriver, JdbcDriverInstance>
{
    @Override
    protected JdbcDriverInstance createDriver ( final JdbcDriver driver )
    {
        return JdbcFactory.eINSTANCE.createJdbcDriverInstance ();
    }
}
