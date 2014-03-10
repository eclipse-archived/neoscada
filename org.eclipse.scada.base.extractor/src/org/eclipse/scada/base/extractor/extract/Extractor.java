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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.base.extractor.input.Data;

public interface Extractor
{
    public static class Result
    {
        private final Map<ItemDescriptor, ItemValue> itemValues;

        private final Throwable error;

        public Result ( final Throwable error )
        {
            this ( null, error );
        }

        public Result ( final Map<ItemDescriptor, ItemValue> itemValues )
        {
            this.itemValues = itemValues;
            this.error = null;
        }

        public Result ( final ItemDescriptor descriptor, final ItemValue value )
        {
            this.itemValues = new HashMap<> ( 1 );
            itemValues.put ( descriptor, value );
            this.error = null;
        }

        public Result ( final Map<ItemDescriptor, ItemValue> itemValues, final Throwable error )
        {
            this.itemValues = itemValues;
            this.error = error;
        }

        public Map<ItemDescriptor, ItemValue> getItemValues ()
        {
            return itemValues;
        }

        public Throwable getError ()
        {
            return error;
        }
    }

    public Result processData ( Data data );
}
