/*******************************************************************************
 * Copyright (c) 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d.primitives;

import org.eclipse.swt.graphics.RGB;

public final class Helper
{
    private Helper ()
    {
    }

    public static RGB makeColor ( final String color )
    {
        if ( color == null )
        {
            return null;
        }

        if ( color.startsWith ( "#" ) )
        {
            if ( color.length () == 1 + 3 )
            {
                return makeRGB ( color.substring ( 1, 2 ) + "0", color.substring ( 2, 3 ) + "0", color.substring ( 3, 4 ) + "0" );
            }
            else if ( color.length () >= 1 + 6 )
            {
                return makeRGB ( color.substring ( 1, 3 ), color.substring ( 3, 5 ), color.substring ( 5, 7 ) );
            }
        }
        return null;
    }

    protected static RGB makeRGB ( final String r, final String g, final String b )
    {
        return new RGB ( Integer.parseInt ( r, 16 ), Integer.parseInt ( g, 16 ), Integer.parseInt ( b, 16 ) );
    }

}
