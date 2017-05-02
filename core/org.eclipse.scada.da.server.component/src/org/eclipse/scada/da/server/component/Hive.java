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
package org.eclipse.scada.da.server.component;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.subscription.SubscriptionManagerListener;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.ValidationStrategy;
import org.eclipse.scada.da.server.common.osgi.AbstractOsgiHiveCommon;
import org.eclipse.scada.da.server.component.osgi.OsgiFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hive extends AbstractOsgiHiveCommon implements ComponentHost
{
    private final static Logger logger = LoggerFactory.getLogger ( Hive.class );

    private final FolderCommon rootFolder = new FolderCommon ();

    private Component component;

    private ComponentNode rootNode;

    private OsgiFactory osgiFactory;

    public Hive ( final BundleContext context, final Executor executor )
    {
        super ( context, executor );

        setValidatonStrategy ( ValidationStrategy.GRANT_ALL );

        setRootFolder ( this.rootFolder );
    }

    @Override
    public void addItemSubscriptionListener ( final SubscriptionManagerListener<String> listener )
    {
        super.addItemSubscriptionListener ( listener );
    }

    @Override
    public void removeItemSubscriptionListener ( final SubscriptionManagerListener<String> listener )
    {
        super.removeItemSubscriptionListener ( listener );
    }

    @Override
    protected void performStart () throws Exception
    {
        super.performStart ();

        final FolderCommon rootNodeFolder = new FolderCommon ();
        this.rootFolder.add ( "components", rootNodeFolder, null );

        this.rootNode = new ComponentNode ( null, rootNodeFolder );

        this.osgiFactory = new OsgiFactory ( FrameworkUtil.getBundle ( Hive.class ).getBundleContext (), this );
    }

    @Override
    protected void performStop () throws Exception
    {
        this.osgiFactory.dispose ();

        this.rootFolder.remove ( "components" );
        this.rootNode = null;

        if ( this.component != null )
        {
            this.component.dispose ();
            this.component = null;
        }

        super.performStop ();
    }

    @Override
    public ComponentHandle registerComponent ( final ComponentFactory componentFactory ) throws Exception
    {
        logger.debug ( "Register component: {}", componentFactory );

        final String[] prefix = componentFactory.getPrefix ();

        final ComponentFolder folder = new ComponentFolder ();

        final Component component = componentFactory.createComponent ( this, folder.getFolderImpl () );
        folder.setComponent ( component );

        try
        {
            synchronized ( this )
            {
                return performRegisterComponent ( prefix, folder, component );
            }
        }
        catch ( final Exception e )
        {
            logger.info ( "Failed to register new component", e );
            component.dispose ();
            throw e;
        }
    }

    private synchronized ComponentHandle performRegisterComponent ( final String[] prefix, final ComponentFolder folder, final Component component )
    {
        logger.debug ( "Register new component - prefix: {}, folder: {}, component: {}", prefix, folder, component );

        this.rootNode.registerComponent ( new LinkedList<> ( Arrays.asList ( prefix ) ), folder, component );
        return new ComponentHandle () {

            @Override
            public void unregister ()
            {
                performUnregister ( prefix, component );
            }

        };
    }

    private synchronized void performUnregister ( final String[] prefix, final Component component )
    {
        logger.debug ( "Perform unregister component - prefix: {}, component: {}", prefix, component );

        try
        {
            this.rootNode.unregisterComponent ( new LinkedList<> ( Arrays.asList ( prefix ) ), component );
        }
        finally
        {
            component.dispose ();
        }
    }

    @Override
    public String getHiveId ()
    {
        return "org.eclipse.scada.da.server.component"; //$NON-NLS-1$
    }

}
