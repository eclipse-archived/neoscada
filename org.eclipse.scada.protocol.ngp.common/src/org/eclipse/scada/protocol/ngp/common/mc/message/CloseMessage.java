/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.common.mc.message;

public class CloseMessage extends ReasonMessage
{
    public CloseMessage ( final String message, final int code )
    {
        super ( message, code );
    }

    @Override
    public String toString ()
    {
        return String.format ( "[Closed - %s: %s]", this.code, this.message );
    };
}
