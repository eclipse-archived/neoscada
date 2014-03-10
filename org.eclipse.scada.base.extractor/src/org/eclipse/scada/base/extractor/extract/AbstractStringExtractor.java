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

import java.util.Map;

import org.eclipse.scada.base.extractor.input.Data;

public abstract class AbstractStringExtractor implements Extractor
{

    @Override
    public Result processData ( final Data data )
    {
        final Object o = data.getData ();
        if ( o instanceof String )
        {
            try
            {
                return new Result ( processData ( (String)o ) );
            }
            catch ( final Exception e )
            {
                return new Result ( e );
            }
        }
        else
        {
            return new Result ( new IllegalArgumentException ( "This extraction only works on strings." ) );
        }
    }

    protected abstract Map<ItemDescriptor, ItemValue> processData ( final String data ) throws Exception;

}
