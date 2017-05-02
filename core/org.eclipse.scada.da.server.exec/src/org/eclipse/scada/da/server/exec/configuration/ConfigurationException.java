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
package org.eclipse.scada.da.server.exec.configuration;

import org.eclipse.scada.utils.statuscodes.CodedException;

public class ConfigurationException extends CodedException
{

    public ConfigurationException ( final String message )
    {
        super ( StatusCodes.CONFIGURATION_ERROR, message );
    }

    public ConfigurationException ( final Throwable e )
    {
        super ( StatusCodes.CONFIGURATION_ERROR, e );
    }

    public ConfigurationException ( final String message, final Throwable e )
    {
        super ( StatusCodes.CONFIGURATION_ERROR, message, e );
    }

    /**
     * 
     */
    private static final long serialVersionUID = -5182346209934896403L;

}
