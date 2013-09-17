/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.interner;

import com.google.common.collect.Interner;

public class JavaStringInterner implements Interner<String>
{

    @Override
    public String intern ( final String string )
    {
        if ( string == null )
        {
            return null;
        }
        return string.intern ();
    }

}
