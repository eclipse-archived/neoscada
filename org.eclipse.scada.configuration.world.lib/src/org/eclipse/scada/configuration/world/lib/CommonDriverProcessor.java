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
package org.eclipse.scada.configuration.world.lib;

import java.util.Properties;

import org.eclipse.scada.configuration.world.CommonDriver;
import org.eclipse.scada.configuration.world.PasswordCredentials;

public abstract class CommonDriverProcessor extends DriverProcessor
{
    private final CommonDriver driver;

    public CommonDriverProcessor ( final CommonDriver driver )
    {
        super ( driver );
        this.driver = driver;
    }

    @Override
    protected void fillProperties ( final Properties p )
    {
        final PasswordCredentials password = this.driver.getPassword ();

        if ( password != null && password.getPassword () != null && !password.getPassword ().isEmpty () )
        {
            p.put ( "org.eclipse.scada.core.server.common.ServiceCommon.password", password.getPassword () ); //$NON-NLS-1$
        }
    }

}