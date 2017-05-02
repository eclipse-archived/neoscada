/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec;

import org.eclipse.scada.utils.statuscodes.SeverityLevel;
import org.eclipse.scada.utils.statuscodes.StatusCode;

public interface StatusCodes
{
    public static final StatusCode UNKNOWN_STATUS_CODE = new StatusCode ( "OSSEC", "CORE", 1, SeverityLevel.ERROR );

    public static final StatusCode INVALID_USER_OR_PASSWORD = new StatusCode ( "OSSEC", "CORE", 2, SeverityLevel.ERROR );

    public static final StatusCode AUTHENTICATION_FAILED = new StatusCode ( "OSSEC", "AUTH", 1, SeverityLevel.ERROR );

    public static final StatusCode AUTHORIZATION_FAILED = new StatusCode ( "OSSEC", "AUTH", 2, SeverityLevel.ERROR );

}
