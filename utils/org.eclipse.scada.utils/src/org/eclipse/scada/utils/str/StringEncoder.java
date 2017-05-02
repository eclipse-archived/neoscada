/*******************************************************************************
 * Copyright (c) 2006, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.str;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class StringEncoder
{
    private StringEncoder ()
    {
    }

    public static String encode ( final String s )
    {
        try
        {
            return URLEncoder.encode ( s, "utf-8" );
        }
        catch ( final UnsupportedEncodingException e )
        {
            return s;
        }
    }

    public static String decode ( final String s )
    {
        try
        {
            return URLDecoder.decode ( s, "utf-8" );
        }
        catch ( final UnsupportedEncodingException e )
        {
            return s;
        }
    }
}
