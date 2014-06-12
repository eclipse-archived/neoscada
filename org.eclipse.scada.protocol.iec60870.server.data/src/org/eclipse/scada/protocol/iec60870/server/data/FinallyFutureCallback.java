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
package org.eclipse.scada.protocol.iec60870.server.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.FutureCallback;

public abstract class FinallyFutureCallback<V> implements FutureCallback<V>
{

    private final static Logger logger = LoggerFactory.getLogger ( FinallyFutureCallback.class );

    @Override
    public void onSuccess ( final V result )
    {
        onFinally ();
    }

    @Override
    public void onFailure ( final Throwable t )
    {
        logger.debug ( "Failed", t );
        onFinally ();
    }

    public abstract void onFinally ();
}
