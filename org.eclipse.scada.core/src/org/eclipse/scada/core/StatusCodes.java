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

import org.eclipse.scada.utils.statuscodes.SeverityLevel;
import org.eclipse.scada.utils.statuscodes.StatusCode;

public interface StatusCodes
{
    public static final StatusCode INVALID_SESSION = new StatusCode ( "OS", "CORE", 0x00001, SeverityLevel.ERROR );

    public static final StatusCode UNABLE_TO_CREATE_SESSION = new StatusCode ( "OS", "CORE", 0x00002, SeverityLevel.ERROR );
}
