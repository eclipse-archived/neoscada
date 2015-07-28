/*******************************************************************************
 * Copyright (c) 2009, 2015 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - cleanup and add item id to message
 *******************************************************************************/
package org.eclipse.scada.da.core.server;

public class InvalidItemException extends Exception
{
    private final String itemName;

    private static final long serialVersionUID = 898848351108459646L;

    public InvalidItemException ( final String itemName )
    {
        super ( String.format ( "Invalid item: '%s'", itemName ) );

        this.itemName = itemName;
    }

    public String getItemName ()
    {
        return this.itemName;
    }
}
