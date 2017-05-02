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
package org.eclipse.scada.sec.osgi;

import org.eclipse.scada.sec.AuthorizationReply;
import org.eclipse.scada.sec.AuthorizationRequest;
import org.eclipse.scada.sec.audit.AuditLogService;
import org.eclipse.scada.sec.authz.AuthorizationContext;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @since 1.1
 */
public class TrackingAuditLogImplementation implements AuditLogService
{

    private final static Logger logger = LoggerFactory.getLogger ( TrackingAuditLogImplementation.class );

    private final SingleServiceTracker<AuditLogService> tracker;

    private volatile AuditLogService service;

    private final SingleServiceListener<AuditLogService> listener = new SingleServiceListener<AuditLogService> () {

        @Override
        public void serviceChange ( final ServiceReference<AuditLogService> reference, final AuditLogService service )
        {
            setService ( service );
        }
    };

    public TrackingAuditLogImplementation ( final BundleContext context )
    {
        this.tracker = new SingleServiceTracker<AuditLogService> ( context, AuditLogService.class, this.listener );
    }

    protected void setService ( final AuditLogService service )
    {
        logger.info ( "Setting audit log service: {}", service );
        this.service = service;
    }

    public void open ()
    {
        this.tracker.open ();
    }

    public void close ()
    {
        this.tracker.close ();
    }

    @Override
    public void info ( final String message, final Object... arguments )
    {
        checkService ().info ( message, arguments );
    }

    @Override
    public void debug ( final String message, final Object... arguments )
    {
        checkService ().debug ( message, arguments );
    }

    @Override
    public void info ( final String message, final Throwable e, final Object... arguments )
    {
        checkService ().info ( message, e, arguments );
    }

    @Override
    public void debug ( final String message, final Throwable e, final Object... arguments )
    {
        checkService ().debug ( message, e, arguments );
    }

    @Override
    public void authorizationRequested ( final AuthorizationRequest request )
    {
        checkService ().authorizationRequested ( request );
    }

    @Override
    public void authorizationFailed ( final AuthorizationContext context, final AuthorizationRequest request, final Throwable error )
    {
        checkService ().authorizationFailed ( context, request, error );
    }

    @Override
    public void authorizationDone ( final AuthorizationContext context, final AuthorizationRequest request, final AuthorizationReply reply )
    {
        checkService ().authorizationDone ( context, request, reply );
    }

    protected AuditLogService checkService ()
    {
        final AuditLogService service = this.service;
        if ( service != null )
        {
            return service;
        }
        throw new IllegalStateException ( String.format ( "No audit log service found" ) );
    }

}
