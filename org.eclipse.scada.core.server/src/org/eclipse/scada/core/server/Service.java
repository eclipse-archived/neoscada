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
package org.eclipse.scada.core.server;

import java.util.Properties;

import org.eclipse.scada.core.InvalidSessionException;
import org.eclipse.scada.core.UnableToCreateSessionException;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.lifecycle.LifecycleAware;

public interface Service<S extends Session> extends LifecycleAware
{
    /**
     * Create a new session for further accessing the hive
     * 
     * @param props
     *            properties used to create the session
     * @return a new session
     * @throws UnableToCreateSessionException
     *             in the case the session could not be created
     * @since 1.1
     */
    public NotifyFuture<S> createSession ( Properties props, CallbackHandler callbackHandler );

    /**
     * Close the provided session
     * Closing the session includes: unregistering from all items, canceling all
     * running operations
     * 
     * @param session
     *            the session to close
     * @throws InvalidSessionException
     *             In the case the session is not a valid session
     */
    public void closeSession ( S session ) throws InvalidSessionException;

}
