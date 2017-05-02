/*******************************************************************************
 * Copyright (c) 2006, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core;

import org.eclipse.scada.utils.statuscodes.CodedException;

/**
 * An exception indicating an invalid (e.g. closed) session
 * 
 * @author Jens Reimann
 */
public class InvalidSessionException extends CodedException
{
    private static final long serialVersionUID = 1L;

    public InvalidSessionException ()
    {
        super ( StatusCodes.INVALID_SESSION, "Invalid session" );
    }
}
