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
package org.eclipse.scada.base.extractor.extract;

import java.util.Collections;
import java.util.Map;

import org.eclipse.scada.core.Variant;

public class ItemValue
{
    private final Variant value;

    private final Map<String, Variant> attributes;

    public ItemValue ( final Variant value, final Map<String, Variant> attributes )
    {
        this.value = value;
        this.attributes = attributes == null ? Collections.<String, Variant> emptyMap () : attributes;
    }

    public Variant getValue ()
    {
        return this.value;
    }

    public Map<String, Variant> getAttributes ()
    {
        return this.attributes;
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder ();

        sb.append ( "[" ).append ( this.value ).append ( "]" );

        return sb.toString ();
    }

}
