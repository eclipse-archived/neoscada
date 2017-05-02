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
package org.eclipse.scada.da.server.common.osgi;

import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.server.common.osgi.SessionPrivilegeTracker;
import org.eclipse.scada.core.server.common.session.AbstractSessionImpl;
import org.eclipse.scada.core.server.common.session.AbstractSessionImpl.DisposeListener;
import org.eclipse.scada.core.server.common.session.PrivilegeListenerImpl;
import org.eclipse.scada.da.server.common.impl.HiveCommon;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.osgi.TrackingAuditLogImplementation;
import org.eclipse.scada.sec.osgi.TrackingAuthenticationImplementation;
import org.eclipse.scada.sec.osgi.TrackingAuthorizationImplementation;
import org.eclipse.scada.sec.osgi.TrackingAuthorizationTracker;
import org.osgi.framework.BundleContext;

public abstract class AbstractOsgiHiveCommon extends HiveCommon
{
    private final BundleContext context;

    private TrackingAuthenticationImplementation authenticationImplementation;

    private TrackingAuthorizationImplementation authorizationManager;

    private TrackingAuthorizationTracker authorizationTracker;

    private TrackingAuditLogImplementation auditLogTracker;

    private final Executor executor;

    public AbstractOsgiHiveCommon ( final BundleContext context )
    {
        this ( context, null );
    }

    public AbstractOsgiHiveCommon ( final BundleContext context, final Executor executor )
    {
        this.context = context;
        this.executor = executor;

        if ( context != null )
        {
            this.authenticationImplementation = new TrackingAuthenticationImplementation ( context );
            this.authorizationManager = new TrackingAuthorizationImplementation ( context );
            this.authorizationTracker = new TrackingAuthorizationTracker ( context );

            this.auditLogTracker = new TrackingAuditLogImplementation ( context );

            setAuthenticationImplementation ( this.authenticationImplementation );
            setAuthorizationImplementation ( this.authorizationManager );
            setAuditLogService ( this.auditLogTracker );
        }
    }

    @Override
    protected void handleSessionCreated ( final AbstractSessionImpl session, final Properties properties, final UserInformation userInformation )
    {
        super.handleSessionCreated ( session, properties, userInformation );

        final Executor executor = this.executor != null ? this.executor : getOperationService ();

        final Set<String> privileges = extractPrivileges ( properties );
        final SessionPrivilegeTracker privTracker = new SessionPrivilegeTracker ( executor, new PrivilegeListenerImpl ( session ), this.authorizationTracker, privileges, userInformation );

        session.addDisposeListener ( new DisposeListener () {

            @Override
            public void disposed ()
            {
                privTracker.dispose ();
            }
        } );
    }

    @Override
    protected void performStart () throws Exception
    {
        super.performStart ();

        if ( this.context != null )
        {
            this.authorizationManager.open ();
            this.authorizationTracker.open ();
            this.authenticationImplementation.open ();
            this.auditLogTracker.open ();
        }
    }

    @Override
    protected void performStop () throws Exception
    {
        if ( this.context != null )
        {
            this.auditLogTracker.close ();
            this.authenticationImplementation.close ();
            this.authorizationTracker.close ();
            this.authorizationManager.close ();
        }

        super.performStop ();
    }
}