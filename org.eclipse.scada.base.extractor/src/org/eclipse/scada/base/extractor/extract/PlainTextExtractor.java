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

/**
 * An extractor that simply takes the whole string
 */
public class PlainTextExtractor extends AbstractStringExtractor
{
    private final ItemDescriptor value;

    private final boolean trim;

    public PlainTextExtractor ( final ItemDescriptor value, final boolean trim )
    {
        this.value = value;
        this.trim = trim;
    }

    @Override
    protected Map<ItemDescriptor, ItemValue> processData ( final String data ) throws Exception
    {
        return Collections.singletonMap ( this.value, new ItemValue ( Variant.valueOf ( this.trim ? data.trim () : data ), null ) );
    }

}
