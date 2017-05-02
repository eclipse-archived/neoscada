/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.common;

import java.util.Map;

import org.eclipse.scada.core.InvalidOperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.core.DataItemInformation;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public class DataItemInputCommon extends DataItemInput
{
    private volatile Variant value = Variant.NULL;

    private AttributeManager attributes = null;

    public DataItemInputCommon ( final DataItemInformation info )
    {
        super ( info );
        this.attributes = new AttributeManager ( this );
    }

    public DataItemInputCommon ( final String name )
    {
        super ( name );
        this.attributes = new AttributeManager ( this );
    }

    @Override
    public NotifyFuture<Variant> readValue () throws InvalidOperationException
    {
        return new InstantFuture<Variant> ( this.value );
    }

    @Override
    public Map<String, Variant> getAttributes ()
    {
        return this.attributes.get ();
    }

    /**
     * Perform requests from the hive to update the items attributes <br>
     * This method actually. Reacting to attribute set requests is
     * implementation dependent. So you will need to subclass from
     * DataItemInputCommon and override this method. <br>
     * If you simple need a memory container that simply stores what you write
     * into it consider using the MemoryDataItem. <br>
     * If you are implementing a data item based on this item and wish to change
     * the data items attributes use {@link #getAttributeManager()} to get the
     * attribute manager which allows you so tweak the
     * items attributes from the side of the item implementation.
     */
    @Override
    public NotifyFuture<WriteAttributeResults> startSetAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        return new InstantFuture<WriteAttributeResults> ( WriteAttributesHelper.errorUnhandled ( null, attributes ) );
    }

    /**
     * Update the value of this data item
     * 
     * @param value
     *            the new value
     */
    public synchronized void updateData ( Variant value, final Map<String, Variant> attributes, final AttributeMode mode )
    {
        if ( this.value == null || !this.value.equals ( value ) )
        {
            this.value = value;
        }
        else
        {
            value = null;
        }

        this.attributes.update ( value, attributes, mode );
    }

    @Override
    protected Map<String, Variant> getCacheAttributes ()
    {
        return this.attributes.get ();
    }

    @Override
    protected Variant getCacheValue ()
    {
        return this.value;
    }
}
