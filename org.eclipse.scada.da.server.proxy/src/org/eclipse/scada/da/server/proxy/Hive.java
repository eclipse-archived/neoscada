/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.proxy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.proxy.configuration.ConfigurationPackage;
import org.eclipse.scada.da.proxy.configuration.RootType;
import org.eclipse.scada.da.proxy.configuration.util.ConfigurationResourceFactoryImpl;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.impl.HiveCommon;
import org.eclipse.scada.da.server.proxy.configuration.XMLConfigurator;
import org.eclipse.scada.da.server.proxy.connection.ProxyConnection;
import org.eclipse.scada.da.server.proxy.utils.ProxyPrefixName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Juergen Rose &lt;juergen.rose@th4-systems.com&gt;
 */
public class Hive extends HiveCommon
{

    private final static Logger logger = LoggerFactory.getLogger ( Hive.class );

    private final FolderCommon rootFolder;

    private final Map<ProxyPrefixName, ProxyConnection> connections = new HashMap<ProxyPrefixName, ProxyConnection> ();

    private boolean initialized = false;

    private String separator = ".";

    private FolderCommon connectionsFolder;

    private final XMLConfigurator configurator;

    public Hive () throws IOException
    {
        this ( new XMLConfigurator ( parse ( URI.createFileURI ( "configuration.xml" ) ) ) );
    }

    public Hive ( final String uri ) throws IOException
    {
        this ( new XMLConfigurator ( parse ( URI.createURI ( uri ) ) ) );
    }

    public Hive ( final XMLConfigurator configurator )
    {
        this.configurator = configurator;

        this.rootFolder = new FolderCommon ();
        setRootFolder ( this.rootFolder );
    }

    public Hive ( final RootType root ) throws Exception
    {
        this ( new XMLConfigurator ( root ) );
    }

    private static RootType parse ( final URI uri ) throws IOException
    {
        final ResourceSet rs = new ResourceSetImpl ();

        rs.getResourceFactoryRegistry ().getExtensionToFactoryMap ().put ( "*", new ConfigurationResourceFactoryImpl () );
        final Resource r = rs.createResource ( uri );
        r.load ( null );

        return (RootType)EcoreUtil.getObjectByType ( r.getContents (), ConfigurationPackage.Literals.ROOT_TYPE );
    }

    @Override
    public String getHiveId ()
    {
        return "org.eclipse.scada.da.server.proxy";
    }

    /**
     * @param group
     * @return
     */
    public ProxyConnection addConnection ( final ProxyPrefixName prefix )
    {
        if ( this.initialized )
        {
            throw new IllegalArgumentException ( "no further connections may be added when initialize() was already called!" );
        }
        if ( this.connections.keySet ().contains ( prefix ) )
        {
            throw new IllegalArgumentException ( "prefix must not already exist!" );
        }

        final ProxyConnection connection = new ProxyConnection ( this, prefix, this.connectionsFolder );
        this.connections.put ( prefix, connection );
        return connection;
    }

    /**
     * @param configurator
     * @throws Exception
     */
    @Override
    protected void performStart () throws Exception
    {
        super.performStart ();

        logger.info ( "Starting hive" );

        // create connections folder
        this.connectionsFolder = new FolderCommon ();
        this.rootFolder.add ( "connections", this.connectionsFolder, new HashMap<String, Variant> () );

        if ( this.configurator != null )
        {
            this.configurator.configure ( this );
        }

        for ( final ProxyConnection connection : this.connections.values () )
        {
            connection.start ();
        }

        // addItemFactory ( new ProxyDataItemFactory ( this.connections, this.separator ) );

        this.initialized = true;
    }

    @Override
    protected void performStop () throws Exception
    {
        for ( final ProxyConnection connection : this.connections.values () )
        {
            connection.stop ();
        }
        super.performStop ();
    }

    /**
     * @param separator
     */
    public void setSeparator ( final String separator )
    {
        if ( this.initialized )
        {
            throw new IllegalArgumentException ( "separator may not be changed when initialize() was already called!" );
        }
        this.separator = separator;
    }

    /**
     * @return separator which separates prefix from rest of item name
     */
    public String getSeparator ()
    {
        return this.separator;
    }
}
