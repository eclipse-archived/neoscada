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
package org.eclipse.scada.da.server.jdbc;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.da.jdbc.configuration.ColumnMappingType;
import org.eclipse.scada.da.jdbc.configuration.CommandsType;
import org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage;
import org.eclipse.scada.da.jdbc.configuration.ConnectionType;
import org.eclipse.scada.da.jdbc.configuration.DocumentRoot;
import org.eclipse.scada.da.jdbc.configuration.QueryType;
import org.eclipse.scada.da.jdbc.configuration.RootType;
import org.eclipse.scada.da.jdbc.configuration.TabularQueryType;
import org.eclipse.scada.da.jdbc.configuration.UpdateColumnsType;
import org.eclipse.scada.da.jdbc.configuration.UpdateMappingType;
import org.eclipse.scada.da.jdbc.configuration.UpdateType;
import org.eclipse.scada.da.jdbc.configuration.util.ConfigurationResourceFactoryImpl;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.ValidationStrategy;
import org.eclipse.scada.da.server.common.impl.HiveCommon;
import org.eclipse.scada.da.server.jdbc.Update.Mapping;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hive extends HiveCommon
{

    private final static Logger logger = LoggerFactory.getLogger ( Hive.class );

    private final FolderCommon rootFolder;

    private final Collection<Connection> connections = new LinkedList<Connection> ();

    private ScheduledExecutorService timer;

    private final ConnectionFactory connectionFactory;

    private final RootType root;

    public Hive () throws IOException
    {
        this ( parse ( URI.createFileURI ( "configuration.xml" ) ), null );
    }

    public Hive ( final String uri, final BundleContext bundleContext ) throws IOException
    {
        this ( parse ( URI.createURI ( uri ) ), bundleContext );
    }

    public Hive ( final RootType root, final BundleContext bundleContext )
    {
        this.root = root;
        this.connectionFactory = new DefaultConnectionFactory ( bundleContext );
        // create root folder
        this.rootFolder = new FolderCommon ();
        setRootFolder ( this.rootFolder );

        setValidatonStrategy ( ValidationStrategy.GRANT_ALL );
    }

    private static RootType parse ( final URI uri ) throws IOException
    {
        final ResourceSet rs = new ResourceSetImpl ();
        rs.getResourceFactoryRegistry ().getExtensionToFactoryMap ().put ( "*", new ConfigurationResourceFactoryImpl () );

        final Resource r = rs.createResource ( uri );
        r.load ( null );

        final DocumentRoot doc = (DocumentRoot)EcoreUtil.getObjectByType ( r.getContents (), ConfigurationPackage.Literals.DOCUMENT_ROOT );
        if ( doc == null )
        {
            return null;
        }
        else
        {
            return doc.getRoot ();
        }
    }

    @Override
    public String getHiveId ()
    {
        return "org.eclipse.scada.da.server.jdbc";
    }

    @Override
    protected void performStart () throws Exception
    {
        super.performStart ();

        this.timer = Executors.newSingleThreadScheduledExecutor ( new NamedThreadFactory ( "JdbcHiveTimer", true ) );

        configure ();
        register ();
    }

    @Override
    protected void performStop () throws Exception
    {
        this.timer.shutdown ();
        unregister ();
        super.performStop ();
    }

    public void register ()
    {
        for ( final Connection connection : this.connections )
        {
            connection.register ( this, this.rootFolder, this.timer );
        }
    }

    public void unregister ()
    {
        for ( final Connection connection : this.connections )
        {
            connection.unregister ( this );
        }
    }

    private void configure ()
    {
        for ( final ConnectionType connectionType : this.root.getConnection () )
        {
            createConnection ( connectionType );
        }
    }

    private void createConnection ( final ConnectionType connectionType )
    {
        final Connection connection = new Connection ( this.connectionFactory, connectionType.getId (), connectionType.getTimeout (), connectionType.getConnectionClass (), connectionType.getUri (), connectionType.getUsername (), connectionType.getPassword () );

        for ( final QueryType queryType : connectionType.getQuery () )
        {
            createQuery ( connection, queryType, convertMappings ( queryType.getColumnMapping () ) );
        }

        for ( final TabularQueryType queryType : connectionType.getTabularQuery () )
        {
            createTabularQuery ( connection, queryType, convertMappings ( queryType.getColumnMapping () ), convertUpdateColumns ( queryType ), convertCommands ( queryType ) );
        }

        for ( final UpdateType updateType : connectionType.getUpdate () )
        {
            createUpdate ( connection, updateType );
        }

        this.connections.add ( connection );
    }

    private Map<String, String> convertCommands ( final TabularQueryType queryType )
    {
        final Map<String, String> result = new HashMap<> ();

        for ( final CommandsType command : queryType.getCommands () )
        {
            String sql = command.getSql ();
            if ( sql == null || sql.isEmpty () )
            {
                sql = command.getSql1 ();
            }

            result.put ( command.getLocalName (), sql );
        }

        return result;
    }

    private Map<String, String> convertUpdateColumns ( final TabularQueryType queryType )
    {
        String defaultUpdateSql = queryType.getDefaultUpdateSql ();
        if ( defaultUpdateSql == null || defaultUpdateSql.isEmpty () )
        {
            defaultUpdateSql = queryType.getDefaultUpdateSql1 ();
        }

        if ( defaultUpdateSql == null || defaultUpdateSql.isEmpty () )
        {
            return Collections.emptyMap ();
        }

        if ( queryType.getUpdateColumns () == null || queryType.getUpdateColumns ().isEmpty () )
        {
            return Collections.emptyMap ();
        }

        final Map<String, String> result = new HashMap<> ( queryType.getUpdateColumns ().size () );

        for ( final UpdateColumnsType updateCol : queryType.getUpdateColumns () )
        {
            final String updateSql = updateCol.getCustomUpdateSql ();
            if ( updateSql == null || updateSql.isEmpty () )
            {
                result.put ( updateCol.getColumnName (), String.format ( defaultUpdateSql, updateCol.getColumnName () ) );
            }
            else
            {
                result.put ( updateCol.getColumnName (), updateSql );
            }
        }

        return result;
    }

    private Map<Integer, String> convertMappings ( final List<ColumnMappingType> list )
    {
        final Map<Integer, String> result = new HashMap<Integer, String> ();

        for ( final ColumnMappingType mapping : list )
        {
            result.put ( mapping.getColumnNumber (), mapping.getAliasName () );
        }

        return result;
    }

    private void createUpdate ( final Connection connection, final UpdateType updateType )
    {
        String sql = updateType.getSql ();
        if ( sql == null || sql.length () == 0 )
        {
            sql = updateType.getSql1 ();
        }

        logger.info ( "Create update: {}", sql );

        final Update update = new Update ( updateType.getId (), sql, connection );

        for ( final UpdateMappingType mappingValue : updateType.getMapping () )
        {
            update.addMapping ( new Mapping ( mappingValue.getName (), mappingValue.getNamedParameter () ) );
        }

        connection.add ( update );
    }

    private void createQuery ( final Connection connection, final QueryType queryType, final Map<Integer, String> columnAliases )
    {
        String sql = queryType.getSql ();
        if ( sql == null || sql.length () == 0 )
        {
            sql = queryType.getSql1 ();
        }

        logger.info ( "Creating new query: {}", sql );

        connection.add ( new Query ( queryType.getId (), queryType.getPeriod (), sql, connection, columnAliases ) );
    }

    private void createTabularQuery ( final Connection connection, final TabularQueryType queryType, final Map<Integer, String> columnAliases, final Map<String, String> updateMap, final Map<String, String> commands )
    {
        String sql = queryType.getSql ();
        if ( sql == null || sql.isEmpty () )
        {
            sql = queryType.getSql1 ();
        }

        logger.info ( "Creating new tabular query: {} / {}", sql );
        connection.add ( new TabularQuery ( queryType.getId (), queryType.getIdColumn (), queryType.getPeriod (), sql, connection, columnAliases, updateMap, commands ) );
    }

}
