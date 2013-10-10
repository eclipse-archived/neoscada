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
package org.eclipse.scada.da.core.server;

public class InvalidItemException extends Exception
{
    private String itemName = "";

    private static final long serialVersionUID = 898848351108459646L;

    public InvalidItemException ( final String itemName )
    {
        super ( "Invalid item" );

        this.itemName = itemName;
    }

    public String getItemName ()
    {
        return this.itemName;
    }

    public void setItemName ( final String itemName )
    {
        this.itemName = itemName;
    }
}
