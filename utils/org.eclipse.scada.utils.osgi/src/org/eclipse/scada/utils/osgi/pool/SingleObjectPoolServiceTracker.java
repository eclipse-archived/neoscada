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
import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleObjectPoolServiceTracker<S> extends AbstractObjectPoolServiceTracker<S>
{

    private final static Logger logger = LoggerFactory.getLogger ( SingleObjectPoolServiceTracker.class );

    private static final int DEFAULT_PRIORITY = 0;

    public interface ServiceListener<S>
    {
        public void serviceChange ( S service, Dictionary<?, ?> properties );
    }

    private final ServiceListener<S> listener;

    public SingleObjectPoolServiceTracker ( final ObjectPoolTracker<S> poolTracker, final String serviceId, final ServiceListener<S> listener )
    {
        super ( poolTracker, serviceId );
        this.listener = listener;
    }

    protected int getPriority ( final Dictionary<?, ?> properties )
    {
        return getPriority ( properties, DEFAULT_PRIORITY );
    }

    protected int getPriority ( final Dictionary<?, ?> properties, final int defaultPriority )
    {
        final Object o = properties.get ( Constants.SERVICE_RANKING );
        if ( o instanceof Number )
        {
            return ( (Number)o ).intValue ();
        }
        else
        {
            return defaultPriority;
        }
    }

    private final Map<S, Dictionary<?, ?>> services = new HashMap<S, Dictionary<?, ?>> ();

    private volatile S currentService;

    @Override
    protected synchronized void handleServiceAdded ( final S service, final Dictionary<?, ?> properties )
    {
        this.services.put ( service, properties );
        update ();
    }

    @Override
    protected synchronized void handleServiceModified ( final S service, final Dictionary<?, ?> properties )
    {
        this.services.put ( service, properties );
        update ();
    }

    @Override
    protected synchronized void handleServiceRemoved ( final S service, final Dictionary<?, ?> properties )
    {
        this.services.remove ( service );
        update ();
    }

    protected void update ()
    {
        S bestService = null;
        Dictionary<?, ?> bestProperties = null;
        final int bestPriority = Integer.MIN_VALUE;

        for ( final Map.Entry<S, Dictionary<?, ?>> entry : this.services.entrySet () )
        {
            final int priority = getPriority ( entry.getValue () );
            if ( priority > bestPriority )
            {
                bestService = entry.getKey ();
                bestProperties = entry.getValue ();
            }
        }

        setService ( bestService, bestProperties );
    }

    private synchronized void setService ( final S bestService, final Dictionary<?, ?> bestProperties )
    {
        if ( this.currentService != bestService )
        {
            logger.debug ( "Change service: {} -> {}", new Object[] { this.currentService, bestService } );
            this.currentService = bestService;
            fireServiceChange ( bestService, bestProperties );
        }
    }

    private void fireServiceChange ( final S bestService, final Dictionary<?, ?> bestProperties )
    {
        if ( this.listener != null )
        {
            this.listener.serviceChange ( bestService, bestProperties );
        }
    }

    public S getCurrentService ()
    {
        return this.currentService;
    }
}
