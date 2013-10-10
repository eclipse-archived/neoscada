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
package org.eclipse.scada.sec.authz.signature;

import org.eclipse.scada.utils.statuscodes.SeverityLevel;
import org.eclipse.scada.utils.statuscodes.StatusCode;

public interface StatusCodes
{

    public static StatusCode VERIFY_NO_SIGNATURE = new StatusCode ( "OSSEC", "XMLSIG", 1, SeverityLevel.ERROR );

    public static StatusCode VERIFY_SIGNATURE_INVALID = new StatusCode ( "OSSEC", "XMLSIG", 2, SeverityLevel.ERROR );

    public static StatusCode VALIDATE_NO_SIGNATURE_DATA = new StatusCode ( "OSSEC", "XMLSIG", 3, SeverityLevel.ERROR );

}
