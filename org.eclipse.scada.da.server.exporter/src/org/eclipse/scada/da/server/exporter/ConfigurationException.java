/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter;

public class ConfigurationException extends Exception
{

    public ConfigurationException ( final String message, final Throwable error )
    {
        super ( message, error );
    }

    /**
     * @since 1.2.0
     */
    public ConfigurationException ( final String message )
    {
        super ( message );
    }

    private static final long serialVersionUID = -2137575087199654459L;

}
