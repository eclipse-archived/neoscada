/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common.chain;

import org.eclipse.scada.core.Variant;

public class BooleanBinder implements AttributeBinder
{
    private Boolean value = null;

    @Override
    public void bind ( final Variant value ) throws Exception
    {
        if ( value == null )
        {
            this.value = null;
        }
        else
        {
            this.value = value.asBoolean ();
        }
    }

    public Boolean getValue ()
    {
        return this.value;
    }

    public boolean getSafeValue ( final boolean defaultValue )
    {
        final Boolean result = this.value;
        if ( result == null )
        {
            return defaultValue;
        }
        else
        {
            return result;
        }
    }

    @Override
    public Variant getAttributeValue ()
    {
        return Variant.valueOf ( getValue () );
    }

}
