package org.eclipse.neoscada.da.server.iec62541;

import static org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned.uint;
import static org.eclipse.milo.opcua.stack.core.util.ConversionUtil.toList;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import org.eclipse.milo.opcua.sdk.client.api.UaClient;
import org.eclipse.milo.opcua.stack.core.Identifiers;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.enumerated.BrowseDirection;
import org.eclipse.milo.opcua.stack.core.types.enumerated.BrowseResultMask;
import org.eclipse.milo.opcua.stack.core.types.enumerated.NodeClass;
import org.eclipse.milo.opcua.stack.core.types.structured.BrowseDescription;
import org.eclipse.milo.opcua.stack.core.types.structured.BrowseResult;
import org.eclipse.milo.opcua.stack.core.types.structured.ReferenceDescription;
import org.eclipse.scada.da.core.DataItemInformation;
import org.eclipse.scada.da.core.browser.Entry;
import org.eclipse.scada.da.core.server.browser.NoSuchFolderException;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.da.server.browser.common.Folder;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.browser.common.FolderListener;
import org.eclipse.scada.da.server.common.DataItemInformationBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpcTreeFolder implements org.eclipse.scada.da.server.browser.common.Folder
{
    private static final Logger logger = LoggerFactory.getLogger ( OpcTreeFolder.class );

    private static final Set<IODirection> inAndOut = EnumSet.allOf ( IODirection.class );

    protected FolderCommon folderImpl = new FolderCommon ();

    protected boolean refreshed = false;

    private final ItemManager itemManager;

    protected final String prefix;

    protected UaClient client = null;

    private final NodeId nodeId;

    private final List<String> path;

    public OpcTreeFolder ( final ItemManager itemManager, final String prefix, final UaClient client, final NodeId opcNode, final List<String> path )
    {
        logger.trace ( "constructor called with prefix = {}, opcNodeId = {}, path = {}", new Object[] { prefix, opcNode, path } );
        this.itemManager = itemManager;
        this.prefix = prefix;
        this.client = client;
        this.nodeId = opcNode;
        this.path = new ArrayList<> ( path );
    }

    @Override
    public Entry[] list ( final Stack<String> path ) throws NoSuchFolderException
    {
        return this.folderImpl.list ( path );
    }

    @Override
    public void subscribe ( final Stack<String> path, final FolderListener listener, final Object tag ) throws NoSuchFolderException
    {
        checkRefresh ();
        this.folderImpl.subscribe ( path, listener, tag );
    }

    @Override
    public void unsubscribe ( final Stack<String> path, final Object tag ) throws NoSuchFolderException
    {
        try
        {
            this.folderImpl.unsubscribe ( path, tag );
        }
        finally
        {
            checkCleanUp ();
        }
    }

    private void checkCleanUp ()
    {
        synchronized ( this )
        {
            this.refreshed = false;
            this.folderImpl.clear ();
        }
    }

    @Override
    public void added ()
    {
        this.folderImpl.added ();
    }

    @Override
    public void removed ()
    {
        this.folderImpl.removed ();
    }

    protected void checkRefresh ()
    {
        logger.trace ( "checkRefresh ()" );
        synchronized ( this )
        {
            if ( this.refreshed )
            {
                logger.trace ( "refresh not needed" );
                return;
            }
            this.refreshed = true;
        }
        refresh ();
    }

    private void refresh ()
    {
        logger.trace ( "refresh ()" );
        if ( this.client == null )
        {
            logger.trace ( "refresh () - client is null" );
            this.refreshed = false;
            return;
        }

        logger.trace ( "refresh () - starting browse" );
        this.client.browse ( createBrowseDescription ( this.nodeId ) ).whenCompleteAsync ( new BiConsumer<BrowseResult, Throwable> () {
            @Override
            public void accept ( final BrowseResult browseResult, final Throwable t )
            {
                logger.trace ( "refresh () - browse complete result = {}", browseResult, t );
                if ( t == null )
                {
                    checkForFolders ( toList ( browseResult.getReferences () ) );
                }
                else
                {
                    browseError ( t );
                }
            }
        } );
    }

    /**
     * Unfortunately we can't decide which node is a folder or not, without
     * browsing.
     * So we browse the next level ...
     *
     * @param referenceDescriptions
     */
    private void checkForFolders ( final List<ReferenceDescription> referenceDescriptions )
    {
        final String folders = referenceDescriptions.stream ().map ( referenceDescription -> referenceDescription.getDisplayName ().getText () ).collect ( Collectors.joining ( ", " ) );
        logger.trace ( "checkForFolders () - {}", folders );
        final List<CompletableFuture<BrowseResult>> allPromises = new ArrayList<> ();
        final boolean[] isFolderish = new boolean[referenceDescriptions.size ()];
        int i = 0;
        for ( final ReferenceDescription referenceDescription : referenceDescriptions )
        {
            logger.trace ( "checkForFolders () - checking '{}'", referenceDescription.getDisplayName ().getText () );
            final int ii = i;
            final CompletableFuture<BrowseResult> promise = this.client.browse ( createBrowseDescription ( referenceDescription.getNodeId ().local ().get () ) );
            promise.whenCompleteAsync ( new BiConsumer<BrowseResult, Throwable> () {
                @Override
                public void accept ( final BrowseResult browseResult, final Throwable t )
                {
                    if ( t == null )
                    {
                        logger.trace ( "checkForFolders () - browse succeeded for '{}'", referenceDescription.getDisplayName ().getText () );
                        try
                        {
                            final List<ReferenceDescription> childReferenceDescriptions = toList ( browseResult.getReferences () );
                            logger.trace ( "checkForFolders () - browse succeeded for '{}', numer of sub elements: {}", referenceDescription.getDisplayName ().getText (), childReferenceDescriptions.size () );
                            isFolderish[ii] = childReferenceDescriptions.size () > 0;
                        }
                        catch ( final Exception e )
                        {
                            logger.trace ( "checkForFolders () - browse succeeded for '{}' but exception happened", referenceDescription.getDisplayName ().getText (), e );
                        }
                    }
                    else
                    {
                        logger.debug ( "checkForFolders () - browse failed", t );
                        browseError ( t );
                    }
                }
            } );
            allPromises.add ( promise );
            i += 1;
        }

        @SuppressWarnings ( "unchecked" )
        final CompletableFuture<BrowseResult>[] cfs = allPromises.toArray ( new CompletableFuture[allPromises.size ()] );
        CompletableFuture.allOf ( cfs ).whenCompleteAsync ( new BiConsumer<Void, Throwable> () {
            @Override
            public void accept ( final Void v, final Throwable t )
            {
                if ( t == null )
                {
                    logger.trace ( "checkForFolders () - completed all futures '{}'", folders );
                    // really ensure that all futures are completed
                    allPromises.stream ().map ( future -> future.join () ).count ();
                    logger.trace ( "checkForFolders () - completed all futures '{}' - joined", folders );
                    browseComplete ( referenceDescriptions, isFolderish );
                }
                else
                {
                    logger.trace ( "checkForFolders () - completed all futures, failed", t );
                    browseError ( t );
                }

            }
        } );
    }

    private BrowseDescription createBrowseDescription ( final NodeId nodeId )
    {
        return new BrowseDescription ( nodeId, //
                BrowseDirection.Forward, //
                Identifiers.References, //
                true, //
                uint ( NodeClass.Object.getValue () | NodeClass.Variable.getValue () ), //
                uint ( BrowseResultMask.All.getValue () ) );
    }

    private void browseComplete ( final List<ReferenceDescription> referenceDescriptions, final boolean[] isFolderish )
    {
        final Map<String, Folder> folders = new HashMap<> ();
        final Map<String, DataItemInformation> items = new HashMap<> ();

        int i = 0;
        for ( final ReferenceDescription referenceDescription : referenceDescriptions )
        {
            logger.trace ( "browseComplete () - i = {}, folder = {}, isFolderish = {}", new Object[] { i, referenceDescription.getDisplayName ().getText (), isFolderish[i] } );
            final String nodeName = referenceDescription.getDisplayName ().getText ();
            final String id = makeId ( nodeName );
            final NodeId nodeId = referenceDescription.getNodeId ().local ().get ();
            if ( isFolderish[i] )
            {
                final ArrayList<String> newPath = new ArrayList<> ( this.path );
                newPath.add ( nodeName );
                folders.put ( referenceDescription.getDisplayName ().getText (), new OpcTreeFolder ( this.itemManager, id, this.client, nodeId, newPath ) );
            }
            if ( referenceDescription.getNodeClass ().equals ( NodeClass.Variable ) )
            {
                final DataItemInformation itemInformation = new DataItemInformationBase ( id, inAndOut );
                this.itemManager.registerItem ( id, nodeId );
                items.put ( nodeName, itemInformation );
            }
            i += 1;
        }

        this.folderImpl.add ( folders, items );
    }

    protected String makeId ( final String name )
    {
        return this.prefix + "." + name;
    }

    private void browseError ( final Throwable t )
    {
        logger.info ( "browse on path '{}' failed with", this.path, t );
    }
}
