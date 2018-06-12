package org.eclipse.neoscada.da.server.iec62541;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.nio.file.NoSuchFileException;
import java.util.Properties;
import java.util.SortedSet;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionConfig implements Serializable, Comparable<ConnectionConfig>
{
    private static final Logger logger = LoggerFactory.getLogger ( ConnectionConfig.class );

    private static final long serialVersionUID = 8349020525329377351L;

    private final String name;

    private final URI uri;

    public ConnectionConfig ( final String name, final URI uri )
    {
        this.name = name;
        this.uri = uri;
    }

    public static SortedSet<ConnectionConfig> readConnectionConfigs ( final File dir )
    {
        final TreeSet<ConnectionConfig> connectionConfigs = new TreeSet<> ();
        for ( final File configFile : dir.listFiles () )
        {
            if ( !configFile.getName ().endsWith ( ".properties" ) )
            {
                logger.trace ( "ignore file in config directory {}", configFile );
                continue;
            }
            try
            {
                final ConnectionConfig plantConfig = toConnectionConfig ( configFile );
                connectionConfigs.add ( plantConfig );
            }
            catch ( final Exception e )
            {
                logger.warn ( "failed to load configuration because {}", e.getMessage () );
            }
        }
        return connectionConfigs;
    }

    private static ConnectionConfig toConnectionConfig ( final File configFile ) throws IOException
    {
        if ( configFile.isDirectory () )
        {
            throw new NoSuchFileException ( configFile + " is a directory" );
        }
        if ( !configFile.canRead () )
        {
            throw new NoSuchFileException ( configFile + " can not be read" );
        }
        final Properties properties = new Properties ();
        properties.load ( new FileReader ( configFile ) );
        return new ConnectionConfig ( properties.getProperty ( "name", properties.getProperty ( "uri", "opc.tcp://localhost:4840/DataAccess" ) //
                .replace ( '.', '_' ) //
                .replace ( ':', '_' ) //
                .replace ( '/', '_' ) //
                .replaceAll ( "_+", "_" ) ), //
                URI.create ( properties.getProperty ( "uri", "opc.tcp://localhost:4840/DataAccess" ) ) );
    }

    public String getName ()
    {
        return this.name;
    }

    public URI getUri ()
    {
        return this.uri;
    }

    @Override
    public int compareTo ( final ConnectionConfig o )
    {
        final int tmp = this.name.compareTo ( o.name );
        return tmp == 0 ? this.uri.compareTo ( o.uri ) : tmp;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = ( prime * result ) + ( ( this.name == null ) ? 0 : this.name.hashCode () );
        result = ( prime * result ) + ( ( this.uri == null ) ? 0 : this.uri.hashCode () );
        return result;
    }

    @Override
    public boolean equals ( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( getClass () != obj.getClass () )
        {
            return false;
        }
        final ConnectionConfig other = (ConnectionConfig)obj;
        if ( this.name == null )
        {
            if ( other.name != null )
            {
                return false;
            }
        }
        else if ( !this.name.equals ( other.name ) )
        {
            return false;
        }
        if ( this.uri == null )
        {
            if ( other.uri != null )
            {
                return false;
            }
        }
        else if ( !this.uri.equals ( other.uri ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString ()
    {
        return "ConnectionConfig [name=" + this.name + ", uri=" + this.uri + "]";
    }
}
