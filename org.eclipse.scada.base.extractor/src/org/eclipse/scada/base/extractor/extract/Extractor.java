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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.base.extractor.input.Data;
import org.eclipse.scada.utils.ExceptionHelper;

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
            this.itemValues = itemValues == null ? Collections.<ItemDescriptor, ItemValue> emptyMap () : itemValues;
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

        @Override
        public String toString ()
        {
            final StringBuilder sb = new StringBuilder ();

            sb.append ( "[Result - " );

            if ( error != null )
            {
                sb.append ( "[Error - " );
                sb.append ( ExceptionHelper.extractMessage ( error ) );
                sb.append ( "]" );
            }

            if ( itemValues != null )
            {
                final int len = itemValues.size ();

                for ( final Map.Entry<ItemDescriptor, ItemValue> entry : itemValues.entrySet () )
                {
                    if ( len > 1 )
                    {
                        sb.append ( System.lineSeparator () ).append ( '\t' );
                        sb.append ( "\t" );
                    }
                    sb.append ( entry.getKey () ).append ( " => " ).append ( entry.getValue () );
                }

                if ( len > 1 )
                {
                    sb.append ( System.lineSeparator () );
                }
            }

            if ( error != null )
            {
                sb.append ( System.lineSeparator () );
                sb.append ( ExceptionHelper.formatted ( error ) );
            }

            sb.append ( "]" );

            return sb.toString ();
        }
    }

    public Result processData ( Data data );
}
