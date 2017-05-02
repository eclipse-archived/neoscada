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
package org.eclipse.scada.da.server.common.chain;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.AttributesHelper;
import org.eclipse.scada.core.InvalidOperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.core.DataItemInformation;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.DataItemInformationBase;
import org.eclipse.scada.da.server.common.chain.item.AutoTimestampChainItem;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public class DataItemInputChained extends DataItemBaseChained
{
    protected Variant primaryValue = Variant.NULL;

    protected Variant secondaryValue = Variant.NULL;

    public DataItemInputChained ( final DataItemInformation dataItemInformation, final Executor executor )
    {
        this ( dataItemInformation, true, executor );
    }

    public DataItemInputChained ( final DataItemInformation dataItemInformation, final boolean autoTimestamp, final Executor executor )
    {
        super ( dataItemInformation, executor );
        if ( autoTimestamp )
        {
            addChainElement ( IODirection.INPUT, new AutoTimestampChainItem () );
        }
    }

    public DataItemInputChained ( final String id, final Executor executor )
    {
        this ( new DataItemInformationBase ( id, EnumSet.of ( IODirection.INPUT ) ), true, executor );
    }

    /**
     * Update the item data
     * 
     * @param value
     *            the new value, or <code>null</code> if the value did not
     *            change
     * @param attributes
     *            the new attributes, <code>null</code> if no attribute have
     *            changed
     * @param mode
     *            The attribute change mode, <code>null</code> will use the
     *            default ( {@link AttributeMode#UPDATE} )
     */
    public synchronized void updateData ( final Variant value, final Map<String, Variant> attributes, AttributeMode mode )
    {
        boolean changed = false;

        // handle value change
        if ( value != null && !this.primaryValue.equals ( value ) )
        {
            this.primaryValue = Variant.valueOf ( value );
            changed = true;
        }

        // change attribute change
        if ( attributes != null )
        {
            if ( mode == null )
            {
                mode = AttributeMode.UPDATE;
            }

            final Map<String, Variant> diff = new HashMap<String, Variant> ();
            if ( mode == AttributeMode.SET )
            {
                AttributesHelper.set ( this.primaryAttributes, attributes, diff );
            }
            else
            {
                AttributesHelper.mergeAttributes ( this.primaryAttributes, attributes, diff );
            }
            changed = changed || !diff.isEmpty ();
        }

        if ( changed )
        {
            process ();
        }
    }

    @Override
    protected void process ()
    {
        Variant newSecondaryValue = Variant.valueOf ( this.primaryValue );
        final Map<String, Variant> newAttributes = new HashMap<String, Variant> ( this.primaryAttributes );

        for ( final ChainProcessEntry entry : getChainCopy () )
        {
            if ( entry.getWhen ().contains ( IODirection.INPUT ) )
            {
                final Variant newValue = entry.getWhat ().process ( newSecondaryValue, newAttributes );
                if ( newValue != null )
                {
                    newSecondaryValue = newValue;
                }
            }
        }

        Variant newValue = null;
        if ( !this.secondaryValue.equals ( newSecondaryValue ) )
        {
            newValue = this.secondaryValue = Variant.valueOf ( newSecondaryValue );
        }

        this.secondaryAttributes.set ( newValue, newAttributes );
    }

    @Override
    public NotifyFuture<Variant> readValue () throws InvalidOperationException
    {
        return new InstantFuture<Variant> ( this.secondaryValue );
    }

    @Override
    public NotifyFuture<WriteResult> startWriteValue ( final Variant value, final OperationParameters operationParameters )
    {
        return new InstantErrorFuture<WriteResult> ( new InvalidOperationException () );
    }

    @Override
    protected Map<String, Variant> getCacheAttributes ()
    {
        return this.secondaryAttributes.get ();
    }

    @Override
    protected Variant getCacheValue ()
    {
        return this.secondaryValue;
    }

}
