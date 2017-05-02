/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common.chain;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.InvalidOperationException;
import org.eclipse.scada.core.NotConvertableException;
import org.eclipse.scada.core.NullValueException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.core.DataItemInformation;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.da.server.common.DataItemInformationBase;
import org.eclipse.scada.da.server.common.SuspendableDataItem;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public abstract class DataItemOutputChained extends DataItemBaseChained implements SuspendableDataItem
{

    public DataItemOutputChained ( final DataItemInformation dataItemInformation, final Executor executor )
    {
        super ( dataItemInformation, executor );
    }

    public DataItemOutputChained ( final String id, final Executor executor )
    {
        this ( new DataItemInformationBase ( id, EnumSet.of ( IODirection.OUTPUT ) ), executor );
    }

    public NotifyFuture<Variant> readValue () throws InvalidOperationException
    {
        throw new InvalidOperationException ();
    }

    public synchronized void writeValue ( final Variant value ) throws InvalidOperationException, NullValueException, NotConvertableException
    {
        final Variant newValue = process ( value );

        if ( newValue != null )
        {
            writeCalculatedValue ( newValue );
        }
    }

    @Override
    protected void process ()
    {
        process ( null );
    }

    protected Variant process ( Variant value )
    {
        final Map<String, Variant> primaryAttributes = new HashMap<String, Variant> ( this.primaryAttributes );

        for ( final ChainProcessEntry entry : getChainCopy () )
        {
            if ( entry.getWhen ().contains ( IODirection.OUTPUT ) )
            {
                final Variant newValue = entry.getWhat ().process ( value, primaryAttributes );
                if ( newValue != null )
                {
                    value = newValue;
                }
            }
        }

        this.secondaryAttributes.set ( null, primaryAttributes );

        return value;
    }

    public void suspend ()
    {
    }

    public void wakeup ()
    {
        if ( this.secondaryAttributes.get ().size () > 0 )
        {
            notifyData ( null, this.secondaryAttributes.get () );
        }
    }

    protected abstract void writeCalculatedValue ( Variant value ) throws NullValueException, NotConvertableException;

}
