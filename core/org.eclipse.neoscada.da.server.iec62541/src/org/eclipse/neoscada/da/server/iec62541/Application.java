package org.eclipse.neoscada.da.server.iec62541;

import java.io.File;

import org.eclipse.scada.core.ConnectionInformation;
// import org.eclipse.scada.da.server.ngp.Exporter;

public class Application
{

    public static void main ( final String[] args ) throws Exception
    {
        //        // default configuration
        //        String configDir = "/etc/neoscada/drivers/opcua";
        //        String exportUri = "da:ngp://0.0.0.0:2137";
        //
        //        // config file would be the first command line parameter
        //        if ( args.length > 0 )
        //        {
        //            configDir = args[0];
        //        }
        //        // exportUri would be the second command line parameter
        //        if ( args.length > 1 )
        //        {
        //            exportUri = args[1];
        //        }
        //
        //        // is config file accessible at all?
        //        if ( !new File ( configDir ).canRead () )
        //        {
        //            System.err.println ( "config dir '" + configDir + "' does not exists or can not be read!" );
        //            System.exit ( 1 );
        //        }
        //
        //        System.out.println ( "Staring OPC UA driver with config dir " + configDir );
        //        System.out.println ( "Exporting hive on address " + exportUri );
        //
        //        // instanciate and start hive & driver
        //        final OpcUaHive hive = new OpcUaHive ( configDir );
        //        hive.start ();
        //
        //        final Exporter exporter = new Exporter ( hive, ConnectionInformation.fromURI ( exportUri ) );
        //        exporter.start ();
        //
        //        Runtime.getRuntime ().addShutdownHook ( new Thread () {
        //            @Override
        //            public void run ()
        //            {
        //                try
        //                {
        //                    if ( exporter != null )
        //                    {
        //                        exporter.stop ();
        //                    }
        //                }
        //                catch ( final Throwable e )
        //                {
        //                    e.printStackTrace ();
        //                }
        //                try
        //                {
        //                    if ( hive != null )
        //                    {
        //                        hive.stop ();
        //                    }
        //                }
        //                catch ( final Exception e )
        //                {
        //                    e.printStackTrace ();
        //
        //                }
        //            }
        //        } );
    }
}
