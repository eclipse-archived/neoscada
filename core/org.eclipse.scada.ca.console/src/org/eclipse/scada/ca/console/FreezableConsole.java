/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.console;

import org.eclipse.scada.ca.FreezableConfigurationAdministrator;

public class FreezableConsole
{
    private FreezableConfigurationAdministrator admin;

    public void setAdmin ( final FreezableConfigurationAdministrator admin )
    {
        this.admin = admin;
    }

    public void freeze () throws Exception
    {
        System.out.print ( "Freezing..." );
        System.out.flush ();

        this.admin.freeze ();

        System.out.println ( "done!" );
    }

    public void thaw () throws Exception
    {
        System.out.print ( "Thawing..." );
        System.out.flush ();

        this.admin.thaw ();

        System.out.println ( "done!" );
    }
}
