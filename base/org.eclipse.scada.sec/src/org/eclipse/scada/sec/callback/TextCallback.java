/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.callback;

import java.util.Map;

/**
 * @since 1.1
 */
public class TextCallback extends LabelCallback
{
    public static final String TYPE = "text";

    public static final String PROP_VALUE = "value";

    private String value;

    public TextCallback ()
    {
    }

    public TextCallback ( final String label, final int order )
    {
        super ( label, order );
    }

    @Override
    public String getType ()
    {
        return TYPE;
    }

    public void setValue ( final String value )
    {
        this.value = value;
    }

    public String getValue ()
    {
        return this.value;
    }

    @Override
    public void parseResponseAttributes ( final Map<String, String> attributes )
    {
        this.value = attributes.get ( PROP_VALUE );
    }

    @Override
    protected void injectResponseAttributes ( final Map<String, String> result )
    {
        super.injectResponseAttributes ( result );
        if ( this.value != null )
        {
            result.put ( PROP_VALUE, this.value );
        }
    }
}
