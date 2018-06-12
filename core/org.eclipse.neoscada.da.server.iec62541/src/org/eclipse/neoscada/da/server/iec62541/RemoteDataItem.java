package org.eclipse.neoscada.da.server.iec62541;

import static com.google.common.collect.Lists.newArrayList;
import static org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned.uint;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaMonitoredItem;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaSubscription;
import org.eclipse.milo.opcua.stack.core.AttributeId;
import org.eclipse.milo.opcua.stack.core.Identifiers;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.DateTime;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;
import org.eclipse.milo.opcua.stack.core.types.builtin.StatusCode;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.MonitoringMode;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.BrowsePath;
import org.eclipse.milo.opcua.stack.core.types.structured.BrowsePathResult;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoredItemCreateRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoringParameters;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadValueId;
import org.eclipse.milo.opcua.stack.core.types.structured.RelativePath;
import org.eclipse.milo.opcua.stack.core.types.structured.RelativePathElement;
import org.eclipse.milo.opcua.stack.core.types.structured.TranslateBrowsePathsToNodeIdsResponse;
import org.eclipse.neoscada.da.server.iec62541.ItemManager;
import org.eclipse.neoscada.da.server.iec62541.ItemManager.NodeInfo;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.SuspendableDataItem;
import org.eclipse.scada.da.server.common.chain.DataItemInputOutputChained;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;

public class RemoteDataItem extends DataItemInputOutputChained implements SuspendableDataItem
{
    private final static Logger logger = LoggerFactory.getLogger ( RemoteDataItem.class );

    private final OpcUaClient client;

    private final ItemManager itemManager;

    private NodeId nodeId;

    private long handle;

    private Supplier<UaSubscription> subscriptionSupplier;

    public RemoteDataItem ( final String id, final Executor executor, final OpcUaClient client, final String itemName, final ItemManager itemManager, final Supplier<UaSubscription> subscriptionSupplier )
    {
        super ( id, executor );

        this.client = client;
        this.itemManager = itemManager;
        this.subscriptionSupplier = subscriptionSupplier;

        final Optional<NodeInfo> nodeInfo = this.itemManager.getNodeInfo ( id );
        if ( nodeInfo.isPresent () )
        {
            this.nodeId = nodeInfo.get ().getNodeId ();
            this.handle = nodeInfo.get ().getHandle ();
        }
        else
        {
            this.nodeId = translateBrowsePath ( itemName );
            if ( this.nodeId != null )
            {
                final NodeInfo newNodeInfo = itemManager.registerItem ( id, this.nodeId );
                this.handle = newNodeInfo.getHandle ();
            }
        }
    }

    private NodeId translateBrowsePath ( final String itemName )
    {
        try
        {
            final RelativePathElement[] relativePaths = Arrays.asList ( itemName.split ( "\\." ) ).stream ().map ( //
                    element -> new RelativePathElement ( Identifiers.HierarchicalReferences, false, true, new QualifiedName ( itemName.startsWith ( "Server." ) ? 0 : 2, element ) ) ).toArray ( RelativePathElement[]::new );
            final TranslateBrowsePathsToNodeIdsResponse response = this.client.translateBrowsePaths ( Arrays.asList ( //
                    new BrowsePath ( Identifiers.ObjectsFolder, new RelativePath ( //
                            relativePaths ) ) //
            ) ).get ( 30, TimeUnit.SECONDS );

            final BrowsePathResult browsePathResult = response.getResults ()[0];
            final NodeId n = browsePathResult.getTargets ()[browsePathResult.getTargets ().length - 1].getTargetId ().local ().get ();
            return n;
        }
        catch ( final Exception e )
        {
            return null;
        }
    }

    @Override
    public synchronized void suspend ()
    {
    }

    @Override
    public void wakeup ()
    {
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                internalWakeup ();
            }
        } );
    }

    protected synchronized void internalWakeup ()
    {
        updateData ( Variant.NULL, Collections.singletonMap ( "opcua.init.error", Variant.TRUE ), AttributeMode.SET );

        final ReadValueId readValueId = new ReadValueId ( this.nodeId, AttributeId.Value.uid (), null, QualifiedName.NULL_VALUE );

        final UInteger clientHandle = uint ( this.handle );

        // use same interval as subscription manager
        final MonitoringParameters parameters = new MonitoringParameters ( clientHandle, this.subscriptionSupplier.get ().getRequestedPublishingInterval (), // sampling interval
                null, // filter, null means use default
                uint ( 10 ), // queue size
                true // discard oldest
        );

        final MonitoredItemCreateRequest request = new MonitoredItemCreateRequest ( readValueId, MonitoringMode.Reporting, parameters );
        final BiConsumer<UaMonitoredItem, Integer> onItemCreated = ( item, id ) -> item.setValueConsumer ( this::onSubscriptionValue );

        this.subscriptionSupplier.get ().createMonitoredItems ( TimestampsToReturn.Both, newArrayList ( request ), onItemCreated );
    }

    @Override
    protected NotifyFuture<WriteResult> startWriteCalculatedValue ( final Variant value, final OperationParameters operationParameters )
    {
        final List<NodeId> nodeIds = ImmutableList.of ( this.nodeId );
        final org.eclipse.milo.opcua.stack.core.types.builtin.Variant v = new org.eclipse.milo.opcua.stack.core.types.builtin.Variant ( value.getValue () );
        final DataValue dv = new DataValue ( v, null, null );
        final CompletableFuture<List<StatusCode>> writePromise = this.client.writeValues ( nodeIds, ImmutableList.of ( dv ) );
        // FIXME: this always results in an ok somehow
        return new TransformResultFuture<List<StatusCode>, WriteResult> ( writePromise, this.executor ) {
            @Override
            protected WriteResult transform ( final List<StatusCode> from ) throws Exception
            {
                if ( from.size () == 0 )
                {
                    return new WriteResult ( new IndexOutOfBoundsException ( "list of returned statuscodes was empty!" ) );
                }
                else if ( from.get ( 0 ).isGood () )
                {
                    return WriteResult.OK;
                }
                else
                {
                    return new WriteResult ( new IllegalArgumentException ( from.get ( 0 ).toString () ) );
                }
            }
        };
    }

    private void onSubscriptionValue ( final UaMonitoredItem item, final DataValue value )
    {
        logger.info ( "subscription value received: item={}, value={}, type={}, class={}", item.getReadValueId ().getNodeId (), value.getValue (), value.getValue ().getDataType (), value.getValue ().getValue ().getClass () );

        final Map<String, Variant> attributes = new HashMap<> ();
        attributes.put ( "opcua.init.error", Variant.NULL );
        attributes.put ( "timestamp", Variant.valueOf ( value.getSourceTime ().getJavaDate ().getTime () ) );
        attributes.put ( "opcua.servertimestamp", Variant.valueOf ( value.getServerTime ().getJavaDate ().getTime () ) );
        if ( value.getStatusCode ().isGood () )
        {
            attributes.put ( "opcua.error", Variant.NULL );
            attributes.put ( "opcua.overflow.error", Variant.NULL );
            attributes.put ( "opcua.uncertain.error", Variant.NULL );
        }
        else
        {
            attributes.put ( "opcua.error", Variant.TRUE );
            if ( value.getStatusCode ().isOverflowSet () )
            {
                attributes.put ( "opcua.overflow.error", Variant.TRUE );
            }
            if ( value.getStatusCode ().isUncertain () )
            {
                attributes.put ( "opcua.uncertain.error", Variant.TRUE );
            }
        }
        updateData ( convertValue ( value, attributes ), attributes, AttributeMode.UPDATE );
    }

    private Variant convertValue ( final DataValue value, final Map<String, Variant> attributes )
    {
        if ( ( value == null ) || ( value.getValue () == null ) || !value.getValue ().getDataType ().isPresent () )
        {
            return Variant.NULL;
        }
        final NodeId dataType = value.getValue ().getDataType ().get ();
        if ( Identifiers.DateTime.equals ( dataType ) )
        {
            final long ts = ( (DateTime)value.getValue ().getValue () ).getJavaDate ().getTime ();
            attributes.put ( "formatted", Variant.valueOf ( String.format ( "%s", ( (DateTime)value.getValue ().getValue () ) ) ) );
            return Variant.valueOf ( ts );
        }
        else if ( Identifiers.LocalizedText.equals ( dataType ) )
        {
            final String t = ( (LocalizedText)value.getValue ().getValue () ).getText ();
            attributes.put ( "formatted", Variant.valueOf ( String.format ( "%s", ( (LocalizedText)value.getValue ().getValue () ) ) ) );
            return Variant.valueOf ( t );
        }
        return Variant.valueOf ( value.getValue ().getValue () );
    }

    public void setSubscriptionSupplier ( final Supplier<UaSubscription> subscriptionSupplier )
    {
        this.subscriptionSupplier = subscriptionSupplier;
    }
}
