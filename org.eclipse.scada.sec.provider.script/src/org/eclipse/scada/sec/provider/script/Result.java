/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.provider.script;

import org.eclipse.scada.utils.lang.Immutable;
import org.eclipse.scada.utils.statuscodes.StatusCode;

@Immutable
public class Result
{
    private final StatusCode code;

    private final String message;

    public Result ( final StatusCode code, final String message )
    {
        this.code = code;
        this.message = message;
    }

    public StatusCode getCode ()
    {
        return this.code;
    }

    public String getMessage ()
    {
        return this.message;
    }
}
