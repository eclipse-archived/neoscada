/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jürgen Rose - additional work
 *******************************************************************************/
package org.eclipse.scada.ca.jdbc.internal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.scada.utils.osgi.jdbc.CommonConnectionAccessor;
import org.eclipse.scada.utils.osgi.jdbc.DataSourceConnectionAccessor;
import org.eclipse.scada.utils.osgi.jdbc.data.RowMapper;
import org.eclipse.scada.utils.osgi.jdbc.data.RowMapperAdapter;
import org.eclipse.scada.utils.osgi.jdbc.data.RowMapperMappingException;
import org.eclipse.scada.utils.osgi.jdbc.pool.PoolConnectionAccessor;
import org.eclipse.scada.utils.osgi.jdbc.task.CommonConnectionTask;
import org.eclipse.scada.utils.osgi.jdbc.task.ConnectionContext;
import org.osgi.service.jdbc.DataSourceFactory;

public class JdbcStorageDAOImpl implements JdbcStorageDAO
{
    private static final String defaultOrder = " ORDER BY instance_id, factory_id, configuration_id, chunk_seq";

    private final String tableName = getTableName ();

    private final int chunkSize = getChunkSize ();

    private final boolean fixNull = isFixNull ();

    private final String instanceId = getInstanceId ();

    private final RowMapper<Entry> mapper = new RowMapperAdapter<Entry> () {
        @Override
        public Entry mapRow ( final ResultSet rs ) throws SQLException
        {
            final Entry entry = new Entry ();
            entry.setInstance ( rs.getString ( "instance_id" ) );
            entry.setFactoryId ( rs.getString ( "factory_id" ) );
            entry.setConfigurationId ( rs.getString ( "configuration_id" ) );
            entry.setKey ( rs.getString ( "ca_key" ) );
            entry.setValue ( rs.getString ( "ca_value" ) );
            entry.setSeq ( rs.getInt ( "chunk_seq" ) );
            return entry;
        }
    };

    private final CommonConnectionAccessor accessor;

    public JdbcStorageDAOImpl ( final DataSourceFactory dataSourceFactory, final Properties dataSourceProperties, final boolean usePool ) throws SQLException
    {
        this.accessor = usePool ? new PoolConnectionAccessor ( dataSourceFactory, dataSourceProperties ) : new DataSourceConnectionAccessor ( dataSourceFactory, dataSourceProperties );
    }

    public void dispose ()
    {
        this.accessor.dispose ();
    }

    protected List<Entry> internalLoad ( final ConnectionContext connectionContext, final String sql, final Object... parameters ) throws SQLException
    {
        return deChunk ( fixNulls ( connectionContext.query ( JdbcStorageDAOImpl.this.mapper, sql, parameters ) ) );
    }

    protected List<Entry> load ( final String sql, final Object... parameters )
    {
        final List<Entry> result = this.accessor.doWithConnection ( new CommonConnectionTask<List<Entry>> () {
            @Override
            protected List<Entry> performTask ( final ConnectionContext connectionContext ) throws Exception
            {
                return connectionContext.query ( JdbcStorageDAOImpl.this.mapper, sql, parameters );
            }
        } );

        return deChunk ( fixNulls ( result ) );
    }

    @Override
    public List<Entry> loadAll ()
    {
        return load ( String.format ( "SELECT * FROM %s WHERE instance_id = ? %s", JdbcStorageDAOImpl.this.tableName, defaultOrder ), this.instanceId );
    }

    @Override
    public List<Entry> loadFactory ( final String factoryId )
    {
        return load ( String.format ( "SELECT * FROM %s WHERE instance_id = ? AND factory_id = ? %s", this.tableName, defaultOrder ), this.instanceId, factoryId );
    }

    @Override
    public List<String> listFactories ()
    {
        final String sql = String.format ( "SELECT DISTINCT factory_id FROM %s WHERE instance_id = ?", JdbcStorageDAOImpl.this.tableName );
        return this.accessor.doWithConnection ( new CommonConnectionTask<List<String>> () {
            @Override
            protected List<String> performTask ( final ConnectionContext connectionContext ) throws Exception
            {
                return connectionContext.query ( new RowMapperAdapter<String> () {
                    @Override
                    public String mapRow ( final ResultSet resultSet ) throws SQLException, RowMapperMappingException
                    {
                        return resultSet.getString ( 1 );
                    }
                }, sql, JdbcStorageDAOImpl.this.instanceId );
            }
        } );
    }

    private List<Entry> loadConfiguration ( final ConnectionContext connectionContext, final String factoryId, final String configurationId ) throws SQLException
    {
        return internalLoad ( connectionContext, String.format ( "SELECT * FROM %s WHERE instance_id = ?  AND factory_id = ? AND configuration_id = ? %s", this.tableName, defaultOrder ), this.instanceId, factoryId, configurationId );
    }

    @Override
    public Map<String, String> storeConfiguration ( final String factoryId, final String configurationId, final Map<String, String> properties, final boolean fullSet )
    {
        return this.accessor.doWithConnection ( new CommonConnectionTask<Map<String, String>> () {

            @Override
            protected Map<String, String> performTask ( final ConnectionContext connectionContext ) throws Exception
            {
                connectionContext.setAutoCommit ( false );
                final Map<String, String> result = internalStoreConfiguration ( connectionContext, factoryId, configurationId, properties, fullSet );
                connectionContext.commit ();
                return result;
            }
        } );
    }

    protected Map<String, String> internalStoreConfiguration ( final ConnectionContext connectionContext, final String factoryId, final String configurationId, final Map<String, String> properties, final boolean fullSet ) throws SQLException
    {
        if ( fullSet )
        {
            internalDeleteConfiguration ( connectionContext, factoryId, configurationId );
        }

        final Set<String> keys = new LinkedHashSet<String> ();
        final List<Entry> toStore = new ArrayList<Entry> ();
        for ( final Map.Entry<String, String> entry : properties.entrySet () )
        {
            // add to store list if we have data
            if ( entry.getValue () != null )
            {
                final Entry dataEntry = new Entry ();
                dataEntry.setInstance ( this.instanceId );
                dataEntry.setFactoryId ( factoryId );
                dataEntry.setConfigurationId ( configurationId );
                dataEntry.setKey ( entry.getKey () );
                dataEntry.setValue ( entry.getValue () );
                toStore.add ( dataEntry );
            }

            keys.add ( entry.getKey () );
        }

        // always delete
        if ( !keys.isEmpty () )
        {
            final Object[] parameters = new Object[3 + keys.size ()];

            // fill first three parameters
            parameters[0] = this.instanceId;
            parameters[1] = factoryId;
            parameters[2] = configurationId;

            // append all other keys from the set
            {
                int i = 3;
                final Iterator<String> iter = keys.iterator ();
                while ( iter.hasNext () )
                {
                    parameters[i] = iter.next ();
                    i++;
                }
            }

            // construct the SQL statement
            final StringBuilder sb = new StringBuilder ();
            sb.append ( "DELETE FROM " ).append ( this.tableName ).append ( " WHERE instance_id = ? AND factory_id = ? AND configuration_id = ? and ca_key in (" );
            for ( int i = 0; i < keys.size (); i++ )
            {
                sb.append ( i == 0 ? "?" : ", ?" );
            }
            sb.append ( ")" );

            // trigger SQL
            connectionContext.update ( sb.toString (), parameters );
        }

        // split up entries and store
        for ( final Entry entry : chunk ( toStore ) )
        {
            storeEntry ( connectionContext, entry );
        }

        // fetch result and return it
        final Map<String, String> result = new HashMap<String, String> ( 4 );
        for ( final Entry entry : loadConfiguration ( connectionContext, factoryId, configurationId ) )
        {
            if ( entry.getKey () != null )
            {
                result.put ( entry.getKey ().intern (), entry.getValue () );
            }
            else
            {
                result.put ( null, entry.getValue () );
            }
        }
        return result;
    }

    private void storeEntry ( final ConnectionContext connectionContext, final Entry entry ) throws SQLException
    {
        final Object[] params = new Object[] { entry.getInstance (), entry.getFactoryId (), entry.getConfigurationId (), entry.getKey (), entry.getValue (), entry.getSeq () };
        connectionContext.update ( String.format ( "INSERT INTO %s (instance_id, factory_id, configuration_id, ca_key, ca_value, chunk_seq) VALUES (?, ?, ?, ?, ?, ?)", this.tableName ), params );
    }

    @Override
    public List<Entry> purgeFactory ( final String factoryId )
    {
        final List<Entry> entries = fixNulls ( loadFactory ( factoryId ) );
        this.accessor.doWithConnection ( new CommonConnectionTask<Void> () {

            @Override
            protected Void performTask ( final ConnectionContext connectionContext ) throws Exception
            {
                connectionContext.update ( String.format ( "DELETE FROM %s WHERE instance_id = ? AND factory_id = ?", JdbcStorageDAOImpl.this.tableName ), JdbcStorageDAOImpl.this.instanceId, factoryId );
                return null;
            }
        } );

        return entries;
    }

    @Override
    public void deleteConfiguration ( final String factoryId, final String configurationId )
    {
        this.accessor.doWithConnection ( new CommonConnectionTask<Void> () {
            @Override
            protected Void performTask ( final ConnectionContext connectionContext ) throws Exception
            {
                connectionContext.setAutoCommit ( false );
                internalDeleteConfiguration ( connectionContext, factoryId, configurationId );
                connectionContext.commit ();
                return null;
            }
        } );
    }

    protected void internalDeleteConfiguration ( final ConnectionContext connectionContext, final String factoryId, final String configurationId ) throws SQLException
    {
        connectionContext.update ( String.format ( "DELETE FROM %s WHERE instance_id = ? AND factory_id = ? AND configuration_id = ?", this.tableName ), this.instanceId, factoryId, configurationId );
    }

    protected List<Entry> fixNulls ( final List<Entry> data )
    {
        if ( !this.fixNull )
        {
            return data;
        }

        for ( final Entry entry : data )
        {
            if ( entry.getValue () == null )
            {
                entry.setValue ( "" );
            }
        }

        return data;
    }

    protected List<Entry> chunk ( final List<Entry> data )
    {
        // shortcut: we don't need to chunk
        if ( this.chunkSize == 0 )
        {
            return data;
        }
        final List<Entry> result = new ArrayList<Entry> ();
        for ( final Entry entry : data )
        {
            // shortcut: we don't need to chunk
            if ( ( entry.getValue () == null ) || ( entry.getValue ().length () <= this.chunkSize ) )
            {
                result.add ( entry );
                continue;
            }
            // loop over string
            int from = 0;
            int to = this.chunkSize;
            int seq = 1;
            do
            {
                // special case last chunk
                if ( to > entry.getValue ().length () )
                {
                    to = entry.getValue ().length ();
                }
                // create new entry and add to result
                final Entry newEntry = new Entry ( entry );
                newEntry.setValue ( entry.getValue ().substring ( from, to ) );
                newEntry.setSeq ( seq );
                result.add ( newEntry );
                // runtime variables
                from += this.chunkSize;
                to += this.chunkSize;
                seq += 1;
            } while ( from < entry.getValue ().length () );
        }
        return result;
    }

    protected List<Entry> deChunk ( final List<Entry> data )
    {
        final List<Entry> result = new ArrayList<Entry> ();
        Entry newEntry = new Entry ();
        for ( final Entry entry : data )
        {
            // if there is only one, add it to result and continue
            if ( entry.getSeq () == 0 )
            {
                // but add last chunked one first
                if ( newEntry.getSeq () > 0 )
                {
                    newEntry.setSeq ( 0 );
                    result.add ( newEntry );
                    newEntry = new Entry ();
                }
                result.add ( entry );
                continue;
            }
            newEntry.setInstance ( entry.getInstance () );
            newEntry.setFactoryId ( entry.getFactoryId () );
            newEntry.setConfigurationId ( entry.getConfigurationId () );
            newEntry.setKey ( entry.getKey () );
            newEntry.setValue ( ( newEntry.getValue () == null ? "" : newEntry.getValue () ) + entry.getValue () );
            newEntry.setSeq ( entry.getSeq () );
        }
        // if the last one is also chunked, it is not already added, so do it now
        if ( newEntry.getSeq () > 0 )
        {
            newEntry.setSeq ( 0 );
            result.add ( newEntry );
        }
        return result;
    }

    private static String getTableName ()
    {
        return System.getProperty ( "org.eclipse.scada.ca.jdbc.table", "ca_data" );
    }

    private static int getChunkSize ()
    {
        return Integer.getInteger ( "org.eclipse.scada.ca.jdbc.chunksize", 0 );
    }

    private static boolean isFixNull ()
    {
        return Boolean.getBoolean ( "org.eclipse.scada.ca.jdbc.fixnull" );
    }

    private static String getInstanceId ()
    {
        return System.getProperty ( "org.eclipse.scada.ca.jdbc.instance", "default" );
    }

}
