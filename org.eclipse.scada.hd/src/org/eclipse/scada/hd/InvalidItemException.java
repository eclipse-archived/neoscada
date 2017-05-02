/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd;

import org.eclipse.scada.utils.statuscodes.CodedException;

public class InvalidItemException extends CodedException
{
    private static final long serialVersionUID = 1L;

    public InvalidItemException ( final String item )
    {
        super ( StatusCodes.INVALID_ITEM, String.format ( "Item '%s' is unknown", item ) );

    }
}
