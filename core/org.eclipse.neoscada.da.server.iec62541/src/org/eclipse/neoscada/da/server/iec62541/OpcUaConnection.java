package org.eclipse.neoscada.da.server.iec62541;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.SessionActivityListener;
import org.eclipse.milo.opcua.sdk.client.api.ServiceFaultListener;
import org.eclipse.milo.opcua.sdk.client.api.UaClient;
import org.eclipse.milo.opcua.sdk.client.api.UaSession;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaSubscription;
import org.eclipse.milo.opcua.stack.client.UaTcpStackClient;
import org.eclipse.milo.opcua.stack.core.security.SecurityPolicy;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.eclipse.milo.opcua.stack.core.types.structured.ServiceFault;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.chain.item.ChainCreator;
import org.eclipse.scada.da.server.common.exporter.StaticObjectExporter;
import org.eclipse.scada.da.server.common.impl.HiveCommon;
import org.eclipse.scada.da.server.common.item.factory.DefaultChainItemFactory;
import org.eclipse.scada.da.server.common.item.factory.FolderItemFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class OpcUaConnection implements SessionActivityListener, ServiceFaultListener
{
    private static final Logger logger = LoggerFactory.getLogger ( OpcUaConnection.class );

    public static final String DATA_DELIM = System.getProperty ( "org.eclipse.neoscada.da.server.opcua.dataDelimiter", "!" );

    private FolderItemFactory stateItemFactory;

    private final FolderCommon connectionFolder;

    private final HiveCommon hive;

    private final FolderCommon rootFolder;

    private final ItemManager itemManager;

    private final Map<String, RemoteDataItem> items = new HashMap<> ();
    
    private final String id;

    private final ServerConfiguration configuration;

    private OpcUaClient client;

    private final ScheduledExecutorService executor;

    private StaticObjectExporter<ServerStateInformation> serverStateExporter;

    private final OpcRootTreeFolder browserFolder;

    private Future<?> reconnectFuture;

    protected Supplier<UaSubscription> subscriptionSupplier;

    public OpcUaConnection ( final String id, final ServerConfiguration configuration, final OpcUaHive hive, final FolderCommon rootFolder )
    {
        logger.trace ( "constructor called" );
        this.id = id;
        this.configuration = configuration;
        this.executor = Executors.newSingleThreadScheduledExecutor ( new ThreadFactoryBuilder ().setNameFormat ( makeBeanName ( "UA/" + this.configuration.getUrl () + "-%d" ) ).build () );

        this.hive = hive;
        this.rootFolder = rootFolder;
        this.connectionFolder = new FolderCommon ();

        final Map<String, Variant> attributes = new HashMap<> ();
        attributes.put ( "description", Variant.valueOf ( "The root node of the server namespace" ) );

        this.itemManager = new ItemManager ();
        this.browserFolder = new OpcRootTreeFolder ( this.itemManager, makeDataId ( null ) );
        this.connectionFolder.add ( "tree", this.browserFolder, attributes );

    }

//    public ConnectionConfig getConfiguration ()
//    {
//        return this.configuration;
//    }

    public void start ()
    {
        logger.debug ( "start ()" );
        final Map<String, Variant> attributes = new HashMap<> ( 1 );
        attributes.put ( "description", Variant.valueOf ( "Folder for connection: " + this.configuration.getUrl () ) );

        this.rootFolder.add ( this.id, this.connectionFolder, attributes );

        // create root factory

        this.stateItemFactory = new DefaultChainItemFactory ( this.hive, this.connectionFolder, makeId ( "state" ), "state" );

        this.serverStateExporter = new StaticObjectExporter<> ( this.stateItemFactory.createSubFolderFactory ( "server" ), ServerStateInformation.class, true, false, null );
        this.serverStateExporter.setTarget ( new ServerStateInformation.Builder ().create () );

        scheduleReconnect ();
    }

    private void handleSelectEndpoint ()
    {
        logger.trace ( "handleSelectEndpoint ()" );
        final CompletableFuture<EndpointDescription[]> promise = UaTcpStackClient.getEndpoints ( this.configuration.getUrl ().toString () );
        promise.whenCompleteAsync ( ( endpointDescriptions, t ) -> {
            if ( t != null )
            {
                handleErrorNoEndpointFound ( t );
            }
            else
            {
                final Optional<EndpointDescription> found = Arrays.stream ( endpointDescriptions ) //
                        .filter ( e -> e.getSecurityPolicyUri ().equals ( SecurityPolicy.None.getSecurityPolicyUri () ) ) //
                        .findFirst ();
                if ( found.isPresent () )
                {
                    handleCreateClient ( found.get () );
                }
                else
                {
                    handleErrorNoEndpointFound ( new RuntimeException ( "no desired endpoint could be selected" ) );

                }
            }
        }, this.executor );
    }

    protected void handleCreateClient ( final EndpointDescription endpointDescription )
    {
        logger.trace ( "handleCreateClient () - {}", endpointDescription );
        final EndpointDescription usedEndpointDescription = new EndpointDescription ( endpointDescription.getEndpointUrl (), //
                endpointDescription.getServer (), //
                endpointDescription.getServerCertificate (), //
                endpointDescription.getSecurityMode (), //
                endpointDescription.getSecurityPolicyUri (), //
                endpointDescription.getUserIdentityTokens (), //
                endpointDescription.getTransportProfileUri (), //
                endpointDescription.getSecurityLevel () );
        logger.trace ( "handleCreateClient () - used endpoint = {}", usedEndpointDescription );
        final OpcUaClientConfigBuilder clientConfigBuilder = new OpcUaClientConfigBuilder ();
        clientConfigBuilder.setEndpoint ( usedEndpointDescription );
        // FIXME: check why this was removed, if we need it at all
        // clientConfigBuilder.setSecureChannelReauthenticationEnabled ( false );
        this.client = new OpcUaClient ( clientConfigBuilder.build () );
        this.client.addSessionActivityListener ( this );
        this.client.addFaultListener ( this );
        final CompletableFuture<UaClient> promise = this.client.connect ();
        promise.whenCompleteAsync ( new BiConsumer<UaClient, Throwable> () {
            @Override
            public void accept ( final UaClient connectedClient, final Throwable t )
            {
                // FIXME: this is one of the options which will have to come from
                if ( t == null )
                {
                    logger.trace ( "handleCreateClient () - connected to '{}'", usedEndpointDescription );
                    connected ();
                }
                else
                {
                    logger.info ( "handleCreateClient () - connect to '{}' failed", usedEndpointDescription, t );
                    OpcUaConnection.this.browserFolder.connectionLost ();
                }
            }
        }, this.executor );
    }

    protected void connected ()
    {
        logger.info ( "connected ()" );
        final CompletableFuture<UaSubscription> promise = this.client.getSubscriptionManager ().createSubscription ( 250 );
        promise.whenCompleteAsync ( new BiConsumer<UaSubscription, Throwable> () {
            @Override
            public void accept ( final UaSubscription subscription, final Throwable t )
            {
                if ( t == null )
                {
                    logger.trace ( "connected () - subscription created" );
                    OpcUaConnection.this.browserFolder.connectionEstablished ( OpcUaConnection.this.client );
                    OpcUaConnection.this.subscriptionSupplier = () -> subscription;
                    for ( final RemoteDataItem remoteDataItem : OpcUaConnection.this.items.values () )
                    {
                        remoteDataItem.setSubscriptionSupplier ( OpcUaConnection.this.subscriptionSupplier );
                        remoteDataItem.wakeup ();
                    }
                }
                else
                {
                    logger.trace ( "connected () - subscription creation failed", t );
                }
            }
        } );
        if ( this.reconnectFuture != null )
        {
            this.reconnectFuture.cancel ( true );
        }

        OpcUaConnection.this.serverStateExporter.setTarget ( new ServerStateInformation.Builder ().state ( MiloConnectionState.CONNECTED ).create () );
    }

    protected void handleErrorNoEndpointFound ( final Throwable t )
    {
        logger.trace ( "handleErrorNoEndpointFound ()", t );
        OpcUaConnection.this.serverStateExporter.setTarget ( new ServerStateInformation.Builder ().state ( MiloConnectionState.SLEEPING ).create () );
    }

    public void dispose ()
    {
        logger.info ( "dispose ()" );
        if ( this.client != null )
        {
            this.client.disconnect ();
            this.client = null;
        }
        if ( this.executor != null )
        {
            this.executor.shutdown ();
        }
    }

    private static String makeBeanName ( final String string )
    {
        return string.replaceAll ( "[?*.:]+", "_" );
    }

    public synchronized DataItem getRemoteDataItem ( final String remoteId )
    {
        logger.trace ( "getRemoteDataItem () - {}", remoteId );
        final String clientHandle = makeDataId ( remoteId );
        logger.trace ( "getRemoteDataItem () - {} -> {}", remoteId, clientHandle );

        RemoteDataItem item = this.items.get ( clientHandle );
        if ( item != null )
        {
            logger.trace ( "getRemoteDataItem () - {} -> {} found!", remoteId, clientHandle );
            return item;
        }

        logger.trace ( "getRemoteDataItem () - {} -> {} create a new RemoteDataItem", remoteId, clientHandle );
        item = new RemoteDataItem ( clientHandle, this.hive.getOperationService (), this.client, remoteId, this.itemManager, this.subscriptionSupplier );

        ChainCreator.applyDefaultInputChain ( item );
        this.items.put ( clientHandle, item );

        this.hive.registerItem ( item );

        return item;
    }

    private String makeId ( final String localId )
    {
        if ( localId == null )
        {
            return this.id;
        }

        return this.id + "." + localId;
    }

    private String makeDataId ( final String remoteId )
    {
        if ( remoteId == null )
        {
            return this.id + ".data" + DATA_DELIM;
        }
        else
        {
            return this.id + ".data" + DATA_DELIM + remoteId;
        }
    }

    @Override
    public void onSessionActive ( final UaSession session )
    {
        logger.info ( "onSessionActive ()" );
    }

    @Override
    public void onSessionInactive ( final UaSession session )
    {
        logger.info ( "onSessionInactive ()" );

        this.browserFolder.connectionLost ();

        final Map<String, Variant> attributes = new HashMap<> ( 3 );

        attributes.put ( "subscription.error", Variant.TRUE );
        attributes.put ( "subscription.state", Variant.valueOf ( "DISCONNECTED" ) );
        attributes.put ( "timestamp", Variant.valueOf ( System.currentTimeMillis () ) );

        for ( final RemoteDataItem item : this.items.values () )
        {
            item.updateData ( Variant.NULL, attributes, AttributeMode.SET );
        }

        this.client.getSubscriptionManager ().clearSubscriptions ();

        OpcUaConnection.this.serverStateExporter.setTarget ( new ServerStateInformation.Builder ().state ( MiloConnectionState.SLEEPING ).create () );
        scheduleReconnect ();
    }

    private void scheduleReconnect ()
    {
        logger.debug ( "scheduleReconnect ()" );
        this.reconnectFuture = this.executor.scheduleWithFixedDelay ( new Runnable () {

            @Override
            public void run ()
            {
                OpcUaConnection.this.serverStateExporter.setTarget ( new ServerStateInformation.Builder ().state ( MiloConnectionState.CONNECTING ).create () );
                handleSelectEndpoint ();
            }
        }, 0, 10, TimeUnit.SECONDS ); // FIXME: make reconnect delay configurable
    }

    @Override
    public void onServiceFault ( final ServiceFault serviceFault )
    {
        logger.warn ( "onServiceFault (), {}", serviceFault );
    }
}
