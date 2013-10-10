/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.browser.common.query;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternNameProvider implements NameProvider
{
    private final NameProvider provider;

    private final Pattern pattern;

    private final int groupNumber;

    public PatternNameProvider ( final NameProvider provider, final Pattern pattern, final int groupNumber )
    {
        this.pattern = pattern;
        this.provider = provider;
        this.groupNumber = groupNumber;
    }

    public String getName ( final ItemDescriptor descriptor )
    {
        try
        {
            final String name = this.provider.getName ( descriptor );

            final Matcher m = this.pattern.matcher ( this.provider.getName ( descriptor ) );
            if ( m.matches () )
            {
                return m.group ( this.groupNumber );
            }
            return name;
        }
        catch ( final Throwable e )
        {
            return null;
        }
    }

}
