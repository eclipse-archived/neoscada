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

import java.util.EnumSet;
import java.util.Map;

import org.eclipse.scada.core.InvalidOperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.core.WriteAttributeResult;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public class MemoryDataItem extends DataItemBase
{
    private volatile Variant value = Variant.NULL;

    private AttributeManager attributes = null;

    public MemoryDataItem ( final String name )
    {
        this ( name, EnumSet.of ( IODirection.INPUT, IODirection.OUTPUT ) );
    }

    protected MemoryDataItem ( final String name, final EnumSet<IODirection> ioDirection )
    {
        super ( new DataItemInformationBase ( name, ioDirection ) );
        this.attributes = new AttributeManager ( this );
    }

    @Override
    public NotifyFuture<Variant> readValue () throws InvalidOperationException
    {
        return new InstantFuture<Variant> ( this.value );
    }

    @Override
    public NotifyFuture<WriteResult> startWriteValue ( final Variant value, final OperationParameters operationParameters )
    {
        if ( !this.value.equals ( value ) )
        {
            this.value = value;
            notifyData ( value, null );
        }

        // we can handle this directly
        return new InstantFuture<WriteResult> ( new WriteResult () );
    }

    @Override
    public Map<String, Variant> getAttributes ()
    {
        return this.attributes.get ();
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

    @Override
    public NotifyFuture<WriteAttributeResults> startSetAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        final WriteAttributeResults writeAttributeResults = new WriteAttributeResults ();

        this.attributes.update ( null, attributes );

        for ( final Map.Entry<String, Variant> entry : attributes.entrySet () )
        {
            writeAttributeResults.put ( entry.getKey (), WriteAttributeResult.OK );
        }

        return new InstantFuture<WriteAttributeResults> ( writeAttributeResults );
    }

}
