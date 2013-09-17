/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.callback;

import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @since 1.1
 */
public final class Callbacks
{

    private final static Logger logger = LoggerFactory.getLogger ( Callbacks.class );

    private Callbacks ()
    {
    }

    /**
     * Process the callbacks, even if the callbackHandler is <code>null</code>
     * <p>
     * If the provided callback handler is <code>null</code> then all callbacks
     * will automatically be canceled and an {@link InstantFuture} is returned.
     * </p>
     * 
     * @param callbackHandler
     *            the callback handler to use (optional)
     * @param callbacks
     *            the callbacks to process
     * @return the future
     */
    public static NotifyFuture<Callback[]> callback ( final CallbackHandler callbackHandler, final Callback[] callbacks )
    {
        if ( callbacks == null )
        {
            return new InstantFuture<Callback[]> ( callbacks );
        }

        if ( callbackHandler == null )
        {
            for ( final Callback callback : callbacks )
            {
                logger.debug ( "Cancelling callback: {}", callback );
                if ( callback != null )
                {
                    callback.cancel ();
                }
            }
            return new InstantFuture<Callback[]> ( callbacks );
        }
        else
        {
            return callbackHandler.performCallback ( callbacks );
        }
    }

    public static NotifyFuture<Callback[]> callback ( final CallbackHandler callbackHandler, final Callback callback )
    {
        return callback ( callbackHandler, new Callback[] { callback } );
    }

    /**
     * Cancel all callbacks
     * 
     * @param callbacks
     *            the callbacks to cancel
     * @return the future
     */
    public static NotifyFuture<Callback[]> cancelAll ( final Callback[] callbacks )
    {
        if ( callbacks == null )
        {
            return new InstantFuture<Callback[]> ( callbacks );
        }

        for ( final Callback callback : callbacks )
        {
            logger.debug ( "Cancelling callback: {}", callback );
            callback.cancel ();
        }

        return new InstantFuture<Callback[]> ( callbacks );
    }
}
