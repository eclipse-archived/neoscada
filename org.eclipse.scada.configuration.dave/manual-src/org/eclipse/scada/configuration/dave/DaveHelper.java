/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.dave;

public final class DaveHelper
{
    private DaveHelper ()
    {
    }

    public static String makeBlockName ( final DaveBlockDefinition block )
    {
        if ( block.getName () != null && !block.getName ().isEmpty () )
        {
            return block.getName ();
        }
        else
        {
            return String.format ( "DB%s", block.getBlock () );
        }
    }
}
