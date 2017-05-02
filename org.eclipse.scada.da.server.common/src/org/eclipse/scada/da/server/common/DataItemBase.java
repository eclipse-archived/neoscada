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

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.core.DataItemInformation;
import org.eclipse.scada.da.server.common.chain.DataItemBaseChained;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is an abstract base class for the {@link DataItem} interface. It also
 * supports
 * the {@link SuspendableDataItem} interface.
 * 
 * @author Jens Reimann &lt;jens.reimann@th4-systems.com&gt;
 * @see SuspendableDataItem
 */
public abstract class DataItemBase implements DataItem
{

    private final static Logger logger = LoggerFactory.getLogger ( DataItemBase.class );

    protected ItemListener listener;

    private final DataItemInformation information;

    public DataItemBase ( final DataItemInformation information )
    {
        this.information = information;
    }

    @Override
    public DataItemInformation getInformation ()
    {
        return this.information;
    }

    @Override
    public synchronized void setListener ( final ItemListener listener )
    {
        if ( this.listener != listener )
        {
            handleListenerChange ( listener );
        }
    }

    protected synchronized void handleListenerChange ( final ItemListener listener )
    {
        if ( listener == null )
        {
            if ( this instanceof SuspendableDataItem )
            {
                ( (SuspendableDataItem)this ).suspend ();
            }
            this.listener = null;
        }
        else if ( this.listener == null )
        {
            // we might need the listener in the wakeup call 
            this.listener = listener;
            if ( this instanceof SuspendableDataItem )
            {
                ( (SuspendableDataItem)this ).wakeup ();
            }
        }
        else
        {
            // listener changer
            this.listener = listener;
        }

        if ( this.listener != null )
        {
            Variant cacheValue = getCacheValue ();
            if ( cacheValue != null && cacheValue.isNull () )
            {
                cacheValue = null;
            }
            Map<String, Variant> cacheAttributes = getCacheAttributes ();
            if ( cacheAttributes != null && cacheAttributes.isEmpty () )
            {
                cacheAttributes = null;
            }
            if ( cacheValue != null || cacheAttributes != null )
            {
                notifyData ( cacheValue, cacheAttributes, true );
            }
        }
    }

    protected Variant getCacheValue ()
    {
        return null;
    }

    protected Map<String, Variant> getCacheAttributes ()
    {
        return null;
    }

    /**
     * Notify a data change without checking for a real change.
     * <p>
     * See {@link #notifyData(Variant, Map, boolean)} when and how to use the
     * method!
     * 
     * @param value
     *            the value to send
     * @param attributes
     *            the attributes to send
     */
    protected void notifyData ( final Variant value, final Map<String, Variant> attributes )
    {
        notifyData ( value, attributes, false );
    }

    /**
     * Notify a data change without checking for a real change.
     * <p>
     * This method simply forwards the change notification to the currently
     * connected listener. It does not provide any real difference check and
     * should therefore only be called by implementations that check for
     * difference first.
     * <p>
     * If you simple want to send data away without the need to check for
     * differences first see {@link DataItemBaseChained}, {@link DataItemInput}
     * or one of their derivations.
     * 
     * @param value
     *            the value to send
     * @param attributes
     *            the attributes to send
     * @param cache
     *            cache bit
     */
    public void notifyData ( final Variant value, final Map<String, Variant> attributes, final boolean cache )
    {
        logger.debug ( "Notify data - value: {}, attributes: {}, cache: {}", new Object[] { value, attributes, cache } );

        final ItemListener listener;

        synchronized ( this )
        {
            listener = this.listener;
        }

        if ( listener != null )
        {
            listener.dataChanged ( this, value, attributes, cache );
        }
    }
}
