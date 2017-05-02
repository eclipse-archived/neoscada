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
package org.eclipse.scada.core.server.common;

/**
 * @since 1.1
 */
public class ProvidedPasswordAuthentication extends AbstractBasicAuthentication
{
    private String password;

    public ProvidedPasswordAuthentication ()
    {
    }

    public ProvidedPasswordAuthentication ( final String password )
    {
        this.password = password;
    }

    public void setPassword ( final String password )
    {
        this.password = password;
    }

    @Override
    protected String getPlainPassword ()
    {
        return this.password;
    }
}
