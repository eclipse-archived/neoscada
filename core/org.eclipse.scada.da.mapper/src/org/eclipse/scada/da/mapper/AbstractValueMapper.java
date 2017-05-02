/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.mapper;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.eclipse.scada.core.Variant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractValueMapper implements ValueMapper
{
    private static final Logger logger = LoggerFactory.getLogger ( AbstractValueMapper.class );

    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock ( false );

    private final Lock readLock = this.readWriteLock.readLock ();

    private final Lock writeLock = this.readWriteLock.writeLock ();

    private final Map<String, String> data = new HashMap<String, String> ();

    private final Set<ValueMapperListener> listeners = new LinkedHashSet<ValueMapperListener> ();

    private Variant defaultValue = Variant.NULL;

    protected void configure ( final Map<String, String> data, final Variant defaultValue )
    {
        ValueMapperListener[] listeners;
        try
        {
            this.writeLock.lock ();

            this.data.clear ();
            this.data.putAll ( data );

            this.defaultValue = defaultValue;

            listeners = this.listeners.toArray ( new ValueMapperListener[this.listeners.size ()] );
        }
        finally
        {
            this.writeLock.unlock ();
        }

        fireStateChange ( listeners );
    }

    private void fireStateChange ( final ValueMapperListener[] listeners )
    {
        for ( final ValueMapperListener listener : listeners )
        {
            try
            {
                listener.stateChanged ();
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to handle state change", e );
            }
        }
    }

    protected Variant defaultValue ( final Variant currentValue )
    {
        if ( this.defaultValue != null )
        {
            return this.defaultValue;
        }
        else
        {
            return currentValue;
        }
    }

    @Override
    public Variant mapValue ( final Variant value )
    {
        if ( value == null )
        {
            return defaultValue ( value );
        }

        try
        {
            this.readLock.lock ();
            final String result = this.data.get ( value.asString ( null ) );
            if ( result == null )
            {
                return defaultValue ( value );
            }
            return Variant.valueOf ( result );
        }
        catch ( final Exception e )
        {
            logger.info ( "Failed to map value", e );
            return defaultValue ( value );
        }
        finally
        {
            this.readLock.unlock ();
        }
    }

    public void dispose ()
    {
        try
        {
            this.writeLock.lock ();
            this.listeners.clear ();
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    @Override
    public void addListener ( final ValueMapperListener listener )
    {
        try
        {
            this.writeLock.lock ();
            this.listeners.add ( listener );
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    @Override
    public void removeListener ( final ValueMapperListener listener )
    {
        try
        {
            this.writeLock.lock ();
            this.listeners.remove ( listener );
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }
}