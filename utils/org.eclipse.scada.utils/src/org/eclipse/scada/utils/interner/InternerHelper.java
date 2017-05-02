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
import com.google.common.collect.Interners;

public final class InternerHelper
{
    private InternerHelper ()
    {
    }

    private static class NullSafeInterner implements Interner<String>
    {
        private final Interner<String> interner;

        private NullSafeInterner ( final Interner<String> interner )
        {
            this.interner = interner;
        }

        @Override
        public String intern ( final String string )
        {
            if ( string == null )
            {
                return null;
            }
            return this.interner.intern ( string );
        };
    }

    public static Interner<String> makeInterner ( final String specificPropertyName, final String defaultType )
    {
        final String type = System.getProperty ( specificPropertyName, System.getProperty ( "org.eclipse.scada.defaultStringInterner", defaultType ) );
        if ( "weak".equals ( type ) )
        {
            return new NullSafeInterner ( Interners.<String> newWeakInterner () );
        }
        else if ( "strong".equals ( type ) )
        {
            return new NullSafeInterner ( Interners.<String> newStrongInterner () );
        }
        else if ( "java".equals ( type ) )
        {
            return new JavaStringInterner ();
        }
        else
        {
            return makeNoOpInterner ();
        }
    }

    public static Interner<String> makeNoOpInterner ()
    {
        return new Interner<String> () {

            @Override
            public String intern ( final String string )
            {
                return string;
            }
        };
    }
}
