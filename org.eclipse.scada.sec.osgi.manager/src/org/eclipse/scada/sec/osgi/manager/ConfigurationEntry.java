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
package org.eclipse.scada.sec.osgi.manager;

import java.util.Map;

import org.eclipse.scada.sec.AuthorizationResult;
import org.eclipse.scada.sec.AuthorizationService;
import org.eclipse.scada.sec.authz.AuthorizationContext;
import org.eclipse.scada.sec.authz.AuthorizationRule;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurationEntry extends AbstractBaseRule implements Comparable<ConfigurationEntry>
{

    private final static Logger logger = LoggerFactory.getLogger ( ConfigurationEntry.class );

    private final String id;

    private final Map<String, String> properties;

    private final AuthorizationManagerImpl managerImpl;

    private final String serviceType;

    private final int priority;

    private volatile AuthorizationRule rule;

    private AuthorizationService service;

    private Throwable error;

    public ConfigurationEntry ( final AuthorizationManagerImpl managerImpl, final String id, final String serviceType, final int priority, final Map<String, String> properties )
    {
        this.managerImpl = managerImpl;
        this.id = id;
        this.serviceType = serviceType;
        this.properties = properties;
        this.priority = priority;
    }

    public String getId ()
    {
        return this.id;
    }

    public int getPriority ()
    {
        return this.priority;
    }

    public String getServiceType ()
    {
        return this.serviceType;
    }

    public Throwable getError ()
    {
        return this.error;
    }

    public boolean isRealized ()
    {
        return this.rule != null;
    }

    public boolean realize ()
    {
        if ( this.rule != null )
        {
            return false;
        }

        logger.debug ( "Trying to realize configuration - id: {}, serviceType: {}, properties: {}", new Object[] { this.id, this.serviceType, this.properties } );

        final AuthorizationService service = this.managerImpl.findService ( this.serviceType );
        if ( service != null )
        {
            this.service = service;
            try
            {
                this.rule = service.createRule ( this.properties );
                this.error = null;
                return true;
            }
            catch ( final Exception e )
            {
                this.error = e;
                logger.warn ( "Failed to realize rule", e );
                return false;
            }
        }
        return false;
    }

    public void unrealize ()
    {
        if ( this.rule != null )
        {
            logger.debug ( "Unrealizing rule - id: {}", this.id );
            this.rule.dispose ();
            this.rule = null;
            this.service = null;
            this.error = null;
        }
    }

    @Override
    public void dispose ()
    {
        unrealize ();
    }

    public boolean realizedBy ( final AuthorizationService service )
    {
        return this.service == service;
    }

    @Override
    protected NotifyFuture<AuthorizationResult> procesAuthorize ( final AuthorizationContext context )
    {
        final AuthorizationRule rule = this.rule;
        if ( rule == null )
        {
            return new InstantErrorFuture<AuthorizationResult> ( new IllegalStateException ( String.format ( "Configuration entry is not realized - id: %s, serviceType: %s", this.id, this.serviceType ) ) );
        }
        return rule.authorize ( context );
    }

    /**
     * Sorted by highest priority first
     */
    @Override
    public int compareTo ( final ConfigurationEntry o )
    {
        if ( o == null )
        {
            return 1;
        }

        return this.priority < o.priority ? 1 : this.priority == o.priority ? 0 : -1;
    }

}
