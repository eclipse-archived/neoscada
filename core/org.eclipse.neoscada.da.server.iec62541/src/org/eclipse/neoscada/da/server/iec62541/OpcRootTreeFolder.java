package org.eclipse.neoscada.da.server.iec62541;

import java.util.Collections;

import org.eclipse.milo.opcua.sdk.client.api.UaClient;
import org.eclipse.milo.opcua.stack.core.Identifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpcRootTreeFolder extends OpcTreeFolder
{
    private static final Logger logger = LoggerFactory.getLogger ( OpcRootTreeFolder.class );

    public OpcRootTreeFolder ( final ItemManager itemManager, final String prefix )
    {
        super ( itemManager, prefix, null, Identifiers.ObjectsFolder, Collections.emptyList () );
        logger.trace ( "constructor finished" );
    }

    public void connectionEstablished ( final UaClient client )
    {
        logger.debug ( "connectionEstablished ()" );
        this.client = client;
        checkRefresh ();
    }

    public void connectionLost ()
    {
        logger.debug ( "connectionLost ()" );
        this.folderImpl.clear ();
        this.refreshed = false;
    }

    @Override
    protected String makeId ( final String name )
    {
        return this.prefix + name;
    }
}
