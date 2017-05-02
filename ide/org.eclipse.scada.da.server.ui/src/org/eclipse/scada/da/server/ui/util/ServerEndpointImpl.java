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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.scada.da.server.exporter.Export;
import org.eclipse.scada.da.server.ui.HivesPlugin;
import org.eclipse.scada.da.server.ui.ServerEndpoint;
import org.eclipse.scada.utils.beans.AbstractPropertyChange;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerEndpointImpl extends AbstractPropertyChange implements ServerEndpoint
{

    private final static Logger logger = LoggerFactory.getLogger ( ServerEndpointImpl.class );

    private boolean running;

    private final Export endpoint;

    private Throwable error;

    public ServerEndpointImpl ( final Export endpoint )
    {
        this.endpoint = endpoint;
    }

    @Override
    public void stop () throws CoreException
    {
        try
        {
            this.endpoint.stop ();
            setRunning ( false );
            setError ( null );
        }
        catch ( final Exception e )
        {
            setError ( e );
            throw new CoreException ( StatusHelper.convertStatus ( HivesPlugin.PLUGIN_ID, e ) );
        }
    }

    @Override
    public void start () throws CoreException
    {
        try
        {
            this.endpoint.start ();
            setRunning ( true );
            setError ( null );
        }
        catch ( final Exception e )
        {
            setError ( e );
            throw new CoreException ( StatusHelper.convertStatus ( HivesPlugin.PLUGIN_ID, e ) );
        }
    }

    @Override
    public String getLabel ()
    {
        return this.endpoint.getConnectionInformation ().toString ();
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

    protected void setError ( final Throwable error )
    {
        firePropertyChange ( PROP_ERROR, this.error, this.error = error );
    }

    @Override
    public Throwable getError ()
    {
        return this.error;
    }

    public void dispose ()
    {
        try
        {
            this.endpoint.stop ();
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to stop endpoint when disposing" );
        }
    }

}
