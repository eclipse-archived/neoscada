/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.osgi.internal;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.common.osgi.SessionPrivilegeTracker;
import org.eclipse.scada.core.server.common.session.AbstractSessionImpl;
import org.eclipse.scada.core.server.common.session.PrivilegeListenerImpl;
import org.eclipse.scada.core.server.common.session.AbstractSessionImpl.DisposeListener;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.browser.common.query.GroupFolder;
import org.eclipse.scada.da.server.browser.common.query.IDNameProvider;
import org.eclipse.scada.da.server.browser.common.query.InvisibleStorage;
import org.eclipse.scada.da.server.browser.common.query.ItemDescriptor;
import org.eclipse.scada.da.server.browser.common.query.SplitGroupProvider;
import org.eclipse.scada.da.server.browser.common.query.SplitNameProvider;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.ValidationStrategy;
import org.eclipse.scada.da.server.common.impl.HiveCommon;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.osgi.TrackingAuditLogImplementation;
import org.eclipse.scada.sec.osgi.TrackingAuthenticationImplementation;
import org.eclipse.scada.sec.osgi.TrackingAuthorizationImplementation;
import org.eclipse.scada.sec.osgi.TrackingAuthorizationTracker;
import org.eclipse.scada.utils.collection.MapBuilder;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HiveImpl extends HiveCommon
{

    private final static Logger logger = LoggerFactory.getLogger ( HiveImpl.class );

    private FolderCommon rootFolder;

    private final BundleContext context;

    private final InvisibleStorage storage;

    private final Map<ServiceReference<?>, ItemDescriptor> items;

    private final TrackingAuthorizationImplementation authorizationManager;

    private final TrackingAuthorizationTracker authorizationTracker;

    private final Executor executor;

    private final TrackingAuthenticationImplementation authenticationImplementation;

    private final TrackingAuditLogImplementation auditLogTracker;

    public HiveImpl ( final BundleContext context, final Executor executor ) throws InvalidSyntaxException
    {
        this.context = context;
        this.executor = executor;

        this.authenticationImplementation = new TrackingAuthenticationImplementation ( context );
        this.authorizationManager = new TrackingAuthorizationImplementation ( context );
        this.authorizationTracker = new TrackingAuthorizationTracker ( context );

        this.auditLogTracker = new TrackingAuditLogImplementation ( context );

        setAuthenticationImplementation ( this.authenticationImplementation );
        setAuthorizationImplementation ( this.authorizationManager );
        setAuditLogService ( this.auditLogTracker );

        setValidatonStrategy ( ValidationStrategy.GRANT_ALL );

        setRootFolder ( this.rootFolder = new FolderCommon () );

        this.items = new HashMap<ServiceReference<?>, ItemDescriptor> ();

        this.storage = new InvisibleStorage ();
        final GroupFolder allItemsFolder = new GroupFolder ( new SplitGroupProvider ( new IDNameProvider (), "\\.", 0, 2 ), new SplitNameProvider ( new IDNameProvider (), "\\.", 0, 2, "." ) );
        this.rootFolder.add ( "all", allItemsFolder, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "A folder containing the full item space" ) ).getMap () );
        this.storage.addChild ( allItemsFolder );
    }

    @Override
    public String getHiveId ()
    {
        return "org.openscada.da.server.osgi";
    }

    @Override
    protected void performStart () throws Exception
    {
        this.authorizationManager.open ();
        this.authorizationTracker.open ();
        this.authenticationImplementation.open ();
        this.auditLogTracker.open ();
        super.performStart ();
    }

    @Override
    protected void performStop () throws Exception
    {
        super.performStop ();
        this.auditLogTracker.close ();
        this.authenticationImplementation.close ();
        this.authorizationTracker.close ();
        this.authorizationManager.close ();
    }

    @Override
    protected void handleSessionCreated ( final AbstractSessionImpl session, final Properties properties, final UserInformation userInformation )
    {
        super.handleSessionCreated ( session, properties, userInformation );

        final Set<String> privileges = extractPrivileges ( properties );
        final SessionPrivilegeTracker privTracker = new SessionPrivilegeTracker ( this.executor, new PrivilegeListenerImpl ( session ), this.authorizationTracker, privileges, userInformation );

        session.addDisposeListener ( new DisposeListener () {

            @Override
            public void disposed ()
            {
                privTracker.dispose ();
            }
        } );
    }

    public synchronized void addItem ( final DataItem item, final Dictionary<?, ?> properties )
    {
        registerItem ( item );

        final Map<String, Variant> attributes = new HashMap<String, Variant> ( 0 );
        fillAttributes ( attributes, properties );

        final ItemDescriptor descriptor = new ItemDescriptor ( item, attributes );

        this.storage.added ( descriptor );
    }

    private static void fillAttributes ( final Map<String, Variant> attributes, final Dictionary<?, ?> properties )
    {
        if ( properties == null )
        {
            return;
        }

        final Object description = properties.get ( Constants.SERVICE_DESCRIPTION );
        if ( description != null )
        {
            attributes.put ( "description", Variant.valueOf ( description ) );
        }
    }

    public synchronized void removeItem ( final DataItem item )
    {
        unregisterItem ( item );
        this.storage.removed ( new ItemDescriptor ( item, null ) );
    }

    public synchronized void addItem ( final ServiceReference<?> serviceReference )
    {
        if ( !serviceReference.isAssignableTo ( this.context.getBundle (), DataItem.class.getName () ) )
        {
            return;
        }
        final DataItem item = (DataItem)this.context.getService ( serviceReference );
        registerItem ( item );

        final Map<String, Variant> attributes = new HashMap<String, Variant> ( 0 );

        final ItemDescriptor descriptor = new ItemDescriptor ( item, attributes );
        this.storage.added ( descriptor );

        this.items.put ( serviceReference, descriptor );
        logger.info ( "Exporting {} as {}", serviceReference, item.getInformation ().getName () );
    }

    public synchronized void removeItem ( final ServiceReference<?> serviceReference )
    {
        logger.info ( "Removing {}", serviceReference );

        this.context.ungetService ( serviceReference );

        final ItemDescriptor descriptor = this.items.remove ( serviceReference );
        this.storage.removed ( descriptor );
        unregisterItem ( descriptor.getItem () );
    }
}
