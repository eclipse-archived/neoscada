/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.ui.util;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.scada.da.server.exporter.Export;
import org.eclipse.scada.da.server.ui.HivesPlugin;
import org.eclipse.scada.da.server.ui.ServerDescriptor;
import org.eclipse.scada.utils.beans.AbstractPropertyChange;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.scada.da.core.server.Hive;
import org.eclipse.scada.ui.utils.status.StatusHelper;

public class ServerDescriptorImpl extends AbstractPropertyChange implements ServerDescriptor
{
    private final Hive hive;

    private boolean running;

    private final WritableSet endpoints;

    private final Set<ServerEndpointImpl> endpointImpls = new HashSet<ServerEndpointImpl> ();

    private final String labelAddition;

    private Throwable error;

    public ServerDescriptorImpl ( final Realm realm, final Hive hive, final Set<Export> exporters, final String labelAddition )
    {
        this.hive = hive;
        this.endpoints = new WritableSet ( realm );
        this.labelAddition = labelAddition;

        if ( exporters != null )
        {
            for ( final Export exporter : exporters )
            {
                final ServerEndpointImpl endpoint = new ServerEndpointImpl ( exporter );
                addEndpoint ( endpoint );
            }
        }
    }

    public void dispose ()
    {
        try
        {
            stop ();
        }
        catch ( final CoreException e )
        {
            StatusManager.getManager ().handle ( e.getStatus () );
        }

        for ( final ServerEndpointImpl endpoint : this.endpointImpls )
        {
            endpoint.dispose ();
        }
        this.endpointImpls.clear ();

        if ( !this.endpoints.isDisposed () )
        {
            this.endpoints.clear ();
            this.endpoints.dispose ();
        }
    }

    protected void setRunning ( final boolean running )
    {
        firePropertyChange ( PROP_RUNNING, this.running, this.running = running );
    }

    @Override
    public boolean isRunning ()
    {
        return this.running;
    }

    @Override
    public void start () throws CoreException
    {
        try
        {
            this.hive.start ();
            setRunning ( true );
            setError ( null );
        }
        catch ( final Exception e )
        {
            setError ( e );
            throw new CoreException ( StatusHelper.convertStatus ( HivesPlugin.PLUGIN_ID, e ) );
        }

        // start endpoints
        final MultiStatus ms = new MultiStatus ( HivesPlugin.PLUGIN_ID, 0, "Starting endpoints", null );
        for ( final ServerEndpointImpl endpoint : this.endpointImpls )
        {
            try
            {
                endpoint.start ();
            }
            catch ( final CoreException e )
            {
                ms.add ( e.getStatus () );
            }
        }
        throwMultiStatus ( ms );
    }

    @Override
    public void stop () throws CoreException
    {
        try
        {
            this.hive.stop ();
            setRunning ( false );
            setError ( null );
        }
        catch ( final Exception e )
        {
            setError ( e );
            throw new CoreException ( StatusHelper.convertStatus ( HivesPlugin.PLUGIN_ID, e ) );
        }

        // stop endpoints
        final MultiStatus ms = new MultiStatus ( HivesPlugin.PLUGIN_ID, 0, "Stopping endpoints", null );
        for ( final ServerEndpointImpl endpoint : this.endpointImpls )
        {
            try
            {
                endpoint.stop ();
            }
            catch ( final CoreException e )
            {
                ms.add ( e.getStatus () );
            }
        }
        throwMultiStatus ( ms );
    }

    public void throwMultiStatus ( final MultiStatus ms ) throws CoreException
    {
        if ( !ms.isOK () )
        {
            if ( ms.getChildren ().length == 1 )
            {
                throw new CoreException ( ms.getChildren ()[0] );
            }
            else
            {
                throw new CoreException ( ms );
            }
        }
    }

    @Override
    public String getAdditionalLabe ()
    {
        return this.labelAddition;
    }

    @Override
    public String getLabel ()
    {
        try
        {
            return (String)PojoProperties.value ( "hiveId" ).getValue ( this.hive );
        }
        catch ( final Exception e )
        {
        }
        return this.hive.toString ();
    }

    @Override
    public ImageDescriptor getImageDescriptor ()
    {
        return null;
    }

    @Override
    public IObservableSet getEndpoints ()
    {
        return this.endpoints;
    }

    @Override
    public Hive getHive ()
    {
        return this.hive;
    }

    @Override
    public boolean hasManagementInterface ()
    {
        return false;
    }

    @Override
    public void createManagementInterface ( final Composite parent )
    {
    }

    protected void addEndpoint ( final ServerEndpointImpl endpoint )
    {
        this.endpointImpls.add ( endpoint );
        this.endpoints.getRealm ().asyncExec ( new Runnable () {
            @Override
            public void run ()
            {
                if ( !ServerDescriptorImpl.this.endpoints.isDisposed () )
                {
                    ServerDescriptorImpl.this.endpoints.add ( endpoint );
                }
            };
        } );
    }

    protected void removeEndpoint ( final ServerEndpointImpl endpoint )
    {
        this.endpointImpls.remove ( endpoint );
        this.endpoints.getRealm ().asyncExec ( new Runnable () {
            @Override
            public void run ()
            {
                if ( !ServerDescriptorImpl.this.endpoints.isDisposed () )
                {
                    ServerDescriptorImpl.this.endpoints.remove ( endpoint );
                }
            };
        } );

    }

    protected void setError ( final Throwable error )
    {
        firePropertyChange ( PROP_ERROR, this.error, this.error = error );
    }

    @Override
    public Throwable getError ()
    {
        return this.error;
    }

}
