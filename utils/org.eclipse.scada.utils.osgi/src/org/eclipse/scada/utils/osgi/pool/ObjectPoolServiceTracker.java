/*******************************************************************************
 * Copyright (c) 2006, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.osgi.pool;

import java.util.Dictionary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectPoolServiceTracker<S> extends AbstractObjectPoolServiceTracker<S>
{

    private final static Logger logger = LoggerFactory.getLogger ( ObjectPoolServiceTracker.class );

    private final ObjectPoolListener<S> clientListener;

    public ObjectPoolServiceTracker ( final ObjectPoolTracker<S> poolTracker, final String serviceId, final ObjectPoolListener<S> listener )
    {
        super ( poolTracker, serviceId );
        this.clientListener = listener;
        logger.debug ( "new pool service tracker for {}", serviceId );
    }

    @Override
    protected void handleServiceAdded ( final S service, final Dictionary<?, ?> properties )
    {
        fireServiceAdded ( service, properties );
    }

    private void fireServiceAdded ( final S service, final Dictionary<?, ?> properties )
    {
        this.clientListener.serviceAdded ( service, properties );
    }

    @Override
    protected void handleServiceModified ( final S service, final Dictionary<?, ?> properties )
    {
        fireServiceModified ( service, properties );
    }

    private void fireServiceModified ( final S service, final Dictionary<?, ?> properties )
    {
        this.clientListener.serviceModified ( service, properties );
    }

    @Override
    protected void handleServiceRemoved ( final S service, final Dictionary<?, ?> properties )
    {
        fireServiceRemoved ( service, properties );
    }

    private void fireServiceRemoved ( final S service, final Dictionary<?, ?> properties )
    {
        this.clientListener.serviceRemoved ( service, properties );
    }

}
