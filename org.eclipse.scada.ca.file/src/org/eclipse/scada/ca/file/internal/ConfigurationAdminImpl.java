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
package org.eclipse.scada.ca.file.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.eclipse.scada.ca.common.AbstractConfigurationAdministrator;
import org.eclipse.scada.ca.common.ConfigurationImpl;
import org.eclipse.scada.ca.oscar.OscarLoader;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.str.StringReplacer;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Interner;

public class ConfigurationAdminImpl extends AbstractConfigurationAdministrator
{
    private static final String URI_CHARSET = "UTF-8";

    private final static class DataFilenameFilter implements FilenameFilter
    {
        @Override
        public boolean accept ( final File dir, final String name )
        {
            if ( ".meta".equals ( name ) )
            {
                return false;
            }
            return true;
        }
    }

    private static final String META_FILE = ".meta";

    private final static Logger logger = LoggerFactory.getLogger ( ConfigurationAdminImpl.class );

    private static final String STORE = "scadaConfigStore";

    private final BundleContext context;

    private File root;

    private final Interner<String> stringInterner;

    public ConfigurationAdminImpl ( final BundleContext context, final Interner<String> stringInterner ) throws Exception
    {
        super ( context );
        this.stringInterner = stringInterner;
        this.context = context;
        initRoot ();
    }

    protected String intern ( final String string )
    {
        return this.stringInterner.intern ( string );
    }

    protected File getRootFile ()
    {
        final String rootDir = getRootFileName ();

        if ( rootDir == null || rootDir.isEmpty () )
        {
            return this.context.getDataFile ( STORE );
        }
        else
        {
            return new File ( rootDir );
        }
    }

    private String getRootFileName ()
    {
        return StringReplacer.replace ( System.getProperty ( "org.eclipse.scada.ca.file.root", null ), System.getProperties () );
    }

    private void initRoot () throws Exception
    {
        this.root = getRootFile ();
        if ( this.root != null )
        {
            logger.info ( "Checking CA root at: {}", this.root.getAbsolutePath () );
            if ( !this.root.exists () )
            {
                logger.warn ( "Storage root does not exist: {}, Try to provision...", this.root );
                this.root.mkdir ();
                provisionData ();
            }
            if ( !this.root.isDirectory () )
            {
                logger.warn ( "File exists but is not a directory: {}", this.root );
                this.root = null;
            }
        }
        else
        {
            logger.warn ( "No file system support" );
        }
    }

    protected void provisionData () throws Exception
    {
        final String oscarUrl = System.getProperty ( "org.eclipse.scada.ca.file.provisionOscarUrl" );
        if ( oscarUrl != null )
        {
            logger.info ( "Provisioning CA from: oscar {}", oscarUrl );

            final InputStream stream = new URL ( oscarUrl ).openStream ();
            try
            {
                performOscarProvision ( stream );
            }
            finally
            {
                stream.close ();
            }
            return;
        }

        final String jsonUrl = System.getProperty ( "org.eclipse.scada.ca.file.provisionJsonUrl" );
        if ( jsonUrl != null )
        {
            logger.info ( "Provisioning CA from: json {}", jsonUrl );

            final InputStream stream = new URL ( jsonUrl ).openStream ();
            try
            {
                performProvision ( OscarLoader.loadJsonData ( stream ) );
            }
            finally
            {
                stream.close ();
            }
        }
    }

    private void performProvision ( final Map<String, Map<String, Map<String, String>>> json )
    {
        for ( final Map.Entry<String, Map<String, Map<String, String>>> factory : json.entrySet () )
        {
            final String factoryId = factory.getKey ();
            for ( final Map.Entry<String, Map<String, String>> cfg : factory.getValue ().entrySet () )
            {
                try
                {
                    writeConfiguraton ( factoryId, cfg.getKey (), cfg.getValue (), true );
                }
                catch ( final Exception e )
                {
                    logger.warn ( String.format ( "Failed to provision - %s/%s", factoryId, cfg.getKey () ), e );
                }
            }
        }
    }

    private void performOscarProvision ( final InputStream stream ) throws Exception
    {
        performProvision ( new OscarLoader ( stream ).getData () );
    }

    @Override
    public synchronized void start () throws Exception
    {
        super.start ();

        final long start = System.currentTimeMillis ();
        performInitialLoad ();
        logger.info ( "Took {} seconds to initial load CA", ( System.currentTimeMillis () - start ) / 1000 );
    }

    protected void performInitialLoad ()
    {
        logger.info ( "Loading initial set from: {}", this.root );

        if ( this.root == null )
        {
            logger.warn ( "No root found" );
            return;
        }

        for ( final String pathName : this.root.list () )
        {
            try
            {
                final File path = new File ( this.root, pathName );
                if ( path.isDirectory () )
                {
                    logger.debug ( "Checking for path: {}", path.getName () );
                    final String factoryId = detectFactory ( path );
                    if ( factoryId != null )
                    {
                        logger.debug ( String.format ( "Path %s is a possible factory (%s). Adding...", path.getName (), factoryId ) );
                        performLoadFactory ( factoryId );
                    }
                }
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to load factory: " + pathName, e );
            }
        }
    }

    private String detectFactory ( final File path )
    {
        final File meta = new File ( path, META_FILE );
        final Properties p = new Properties ();
        FileInputStream stream = null;
        try
        {
            stream = new FileInputStream ( meta );
            p.load ( stream );
        }
        catch ( final Exception e )
        {
            return null;
        }
        finally
        {
            if ( stream != null )
            {
                try
                {
                    stream.close ();
                }
                catch ( final IOException e )
                {
                    logger.warn ( "Failed to close stream", e );
                }
            }
        }
        return p.getProperty ( "id" );
    }

    protected void performLoadFactory ( final String factoryId ) throws Exception
    {
        if ( this.root == null )
        {
            logger.warn ( "No root found" );
            return;
        }

        final File path = getFactoryPath ( factoryId );
        loadAll ( path, factoryId );
    }

    private void createStore ( final File factoryRoot, final String factoryId )
    {
        if ( !factoryRoot.mkdir () )
        {
            logger.warn ( "Failed to create store: {}", factoryRoot );
            return;
        }
        final File meta = new File ( factoryRoot, META_FILE );
        final Properties p = new Properties ();
        p.put ( "id", factoryId );
        FileOutputStream stream = null;
        try
        {
            stream = new FileOutputStream ( meta );

            logger.debug ( "Creating new store: {}", factoryRoot );
            p.store ( stream, "" );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to initialize store: {}", factoryRoot );
        }
        finally
        {
            if ( stream != null )
            {
                try
                {
                    stream.close ();
                }
                catch ( final IOException e )
                {
                    logger.warn ( "Failed to close stream", e );
                }
            }
        }
    }

    private void loadAll ( final File configurationRoot, final String factoryId ) throws UnsupportedEncodingException
    {
        logger.debug ( "Loading from: {}", configurationRoot.getName () );

        final List<ConfigurationImpl> configurations = new LinkedList<ConfigurationImpl> ();

        for ( final File file : configurationRoot.listFiles ( new DataFilenameFilter () ) )
        {
            logger.trace ( "Loading file: {}", file.getName () );
            final String id = idFromFile ( file );
            final ConfigurationImpl cfg = loadConfiguration ( factoryId, id, file );

            if ( cfg != null )
            {
                configurations.add ( cfg );
            }
        }

        addStoredFactory ( factoryId, configurations.toArray ( new ConfigurationImpl[configurations.size ()] ) );
    }

    private ConfigurationImpl loadConfiguration ( final String factoryId, final String configurationId, final File file )
    {
        try
        {
            final Properties p = new Properties ();

            final FileInputStream stream = new FileInputStream ( file );
            try
            {
                p.load ( stream );
            }
            finally
            {
                stream.close ();
            }

            final Map<String, String> result = new HashMap<String, String> ();
            for ( final Entry<Object, Object> entry : p.entrySet () )
            {
                result.put ( intern ( entry.getKey ().toString () ), intern ( entry.getValue ().toString () ) );
            }

            return new ConfigurationImpl ( configurationId, factoryId, result );
        }
        catch ( final Throwable e )
        {
            logger.warn ( "Failed to load" );
            return null;
        }
    }

    private String getPath ( final String factoryId ) throws UnsupportedEncodingException
    {
        return encode ( factoryId );
    }

    private String encode ( final String path ) throws UnsupportedEncodingException
    {
        return URLEncoder.encode ( path, URI_CHARSET );
    }

    private String idFromFile ( final File file ) throws UnsupportedEncodingException
    {
        final String name = file.getName ();
        return URLDecoder.decode ( name, URI_CHARSET );
    }

    @Override
    protected void performPurge ( final UserInformation userInformation, final String factoryId, final PurgeFuture future ) throws Exception
    {
        logger.info ( "Request to delete: {}", factoryId );

        if ( this.root == null )
        {
            logger.warn ( "Unable to store : no root" );
            return;
        }
        final File path = getFactoryPath ( factoryId );

        for ( final File file : path.listFiles ( new DataFilenameFilter () ) )
        {
            logger.info ( "Delete file: {}", file.getName () );
            final String id = idFromFile ( file );

            final ConfigurationFuture subFuture = new ConfigurationFuture ();
            changeConfiguration ( userInformation, factoryId, id, null, subFuture );

            future.addChild ( subFuture );

            file.delete ();
        }

        final File metaFile = new File ( path, ".meta" );
        metaFile.delete ();

        logger.debug ( "Delete factory root: {}", path );
        path.delete ();

        future.setComplete ();
    }

    protected Map<String, String> writeConfiguraton ( final String factoryId, final String configurationId, final Map<String, String> properties, final boolean fullSet ) throws Exception
    {
        if ( this.root == null )
        {
            logger.warn ( "Unable to store : no root" );
            throw new RuntimeException ( "No root to store" );
        }

        final File path = getFactoryPath ( factoryId );
        final File file = new File ( path, encode ( configurationId ) );

        logger.info ( "Storing {} to {}", configurationId, file );

        final Map<String, String> newProperties = new HashMap<String, String> ();

        // if this is differential, load in old data first
        if ( !fullSet )
        {
            final ConfigurationImpl oldConfig = loadConfiguration ( factoryId, configurationId, file );
            if ( oldConfig != null )
            {
                newProperties.putAll ( oldConfig.getData () );
            }
        }

        // merge in changes
        for ( final Map.Entry<String, String> entry : properties.entrySet () )
        {
            final String key = entry.getKey ();
            final String value = entry.getValue ();
            if ( value != null )
            {
                newProperties.put ( intern ( key ), intern ( value ) );
            }
            else
            {
                newProperties.remove ( key );
            }
        }

        // convert to properties and store
        final Properties p = new Properties ();
        p.putAll ( newProperties );

        final FileOutputStream stream = new FileOutputStream ( file );
        try
        {
            logger.debug ( "Storing {}/{} -> {}", new Object[] { factoryId, configurationId, newProperties } );
            p.store ( stream, "" );
        }
        finally
        {
            stream.close ();
        }

        return newProperties;
    }

    @Override
    protected void performStoreConfiguration ( final UserInformation userInformation, final String factoryId, final String configurationId, final Map<String, String> properties, final boolean fullSet, final ConfigurationFuture future ) throws FileNotFoundException, IOException
    {
        try
        {
            final Map<String, String> newProperties = writeConfiguraton ( factoryId, configurationId, properties, fullSet );
            changeConfiguration ( userInformation, factoryId, configurationId, newProperties, future );
        }
        catch ( final Exception e )
        {
            future.setError ( e );
            return;
        }
    }

    private File getFactoryPath ( final String factoryId ) throws UnsupportedEncodingException
    {
        final File path = new File ( this.root, getPath ( factoryId ) );
        if ( !path.exists () )
        {
            logger.info ( "Store for factory ({}) does not exist", factoryId );
            createStore ( path, factoryId );
        }
        return path;
    }

    @Override
    protected void performDeleteConfiguration ( final UserInformation userInformation, final String factoryId, final String configurationId, final ConfigurationFuture future ) throws Exception
    {
        final File path = getFactoryPath ( factoryId );

        final File file = new File ( path, encode ( configurationId ) );

        logger.info ( "Deleting {}", configurationId );

        if ( !file.delete () )
        {
            logger.info ( "Failed to delete: {}", file );
        }

        // notify the abstract service from our content change
        changeConfiguration ( userInformation, factoryId, configurationId, null, future );
    }
}
