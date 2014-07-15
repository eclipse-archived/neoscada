/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.iec60870;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.core.DataItemInformation;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.browser.common.query.AttributeNameProvider;
import org.eclipse.scada.da.server.browser.common.query.GroupFolder;
import org.eclipse.scada.da.server.browser.common.query.IDNameProvider;
import org.eclipse.scada.da.server.browser.common.query.InvisibleStorage;
import org.eclipse.scada.da.server.browser.common.query.ItemDescriptor;
import org.eclipse.scada.da.server.browser.common.query.SplitGroupProvider;
import org.eclipse.scada.da.server.browser.common.query.SplitNameProvider;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.DataItemInformationBase;
import org.eclipse.scada.da.server.common.chain.DataItemInputOutputChained;
import org.eclipse.scada.da.server.common.chain.item.SumErrorChainItem;
import org.eclipse.scada.da.server.common.exporter.ObjectExporter;
import org.eclipse.scada.da.server.common.item.factory.DefaultChainItemFactory;
import org.eclipse.scada.protocol.iec60870.ProtocolOptions;
import org.eclipse.scada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.DoublePoint;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.Value;
import org.eclipse.scada.protocol.iec60870.client.AutoConnectClient;
import org.eclipse.scada.protocol.iec60870.client.AutoConnectClient.ModulesFactory;
import org.eclipse.scada.protocol.iec60870.client.AutoConnectClient.State;
import org.eclipse.scada.protocol.iec60870.client.AutoConnectClient.StateListener;
import org.eclipse.scada.protocol.iec60870.client.ClientModule;
import org.eclipse.scada.protocol.iec60870.client.data.DataHandler;
import org.eclipse.scada.protocol.iec60870.client.data.DataListener;
import org.eclipse.scada.protocol.iec60870.client.data.DataModule;
import org.eclipse.scada.protocol.iec60870.client.data.DataProcessor;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Connection
{
    private final static Logger logger = LoggerFactory.getLogger ( Connection.class );

    private final DataHandler handler;

    private final AutoConnectClient client;

    private final FolderCommon folder;

    private final AtomicBoolean disposed = new AtomicBoolean ( false );

    private final Hive hive;

    private final DefaultChainItemFactory stateFactory;

    private final GroupFolder dataFolder;

    private final InvisibleStorage storage;

    private final ObjectExporter clientExporter;

    private ClientState clientState;

    private final StateListener clientListener = new StateListener () {

        @Override
        public void stateChanged ( final State state, final Throwable e )
        {
            handleStateChanged ( state, e );
        }
    };

    private final ModulesFactory modulesFactory;

    private final DataListener dataListener = new DataListener () {

        @Override
        public void update ( final ASDUAddress commonAddress, final InformationObjectAddress objectAddress, final Value<?> value )
        {
            handleDataUpdate ( commonAddress, objectAddress, value );
        }

        @Override
        public void disconnected ()
        {
            handleDisconnected ();
        }
    };

    private ProtocolOptions protocolOptions;

    private Executor executor;

    private final Map<String, DataItemInputOutputChained> itemCache = new HashMap<> ();

    private String id;

    public Connection ( final String id, final Hive hive, final Executor executor, final ConnectionConfiguration configuration )
    {
        this.hive = hive;

        this.id = id;

        this.executor = executor;
        this.handler = new DataProcessor ( executor, this.dataListener );
        final DataModule dataModule = new DataModule ( this.handler, configuration.getDataModuleOptions () );

        this.protocolOptions = configuration.getProtocolOptions ();

        this.folder = new FolderCommon ();
        hive.getRootFolder ().add ( id, this.folder, null );

        this.stateFactory = new DefaultChainItemFactory ( hive, this.folder, id + ".state", "state" );
        this.dataFolder = new GroupFolder ( new SplitGroupProvider ( new AttributeNameProvider ( "iec.60870.address" ), "\\.", 0, 1 ), new SplitNameProvider ( new IDNameProvider (), "\\.", -2, 0, "." ) );

        this.storage = new InvisibleStorage ();
        this.storage.addChild ( this.dataFolder );
        this.folder.add ( "data", this.dataFolder, null );

        this.clientExporter = new ObjectExporter ( this.stateFactory.createSubFolderFactory ( "client" ) );
        this.clientExporter.attachTarget ( this.clientState = new ClientState () );

        this.modulesFactory = new ModulesFactory () {
            @Override
            public List<ClientModule> createModules ()
            {
                return Collections.singletonList ( (ClientModule)dataModule );
            }
        };

        this.client = new AutoConnectClient ( configuration.getHost (), configuration.getPort (), configuration.getProtocolOptions (), this.modulesFactory, this.clientListener );
    }

    protected void handleDisconnected ()
    {
        // FIXME: dispose all items
    }

    protected void handleDataUpdate ( final ASDUAddress commonAddress, final InformationObjectAddress objectAddress, final Value<?> value )
    {
        logger.trace ( "data update - {}-{} = {}", commonAddress, objectAddress, value );

        final DataItemInputOutputChained item = getItem ( commonAddress, objectAddress );
        updateItem ( item, value );
    }

    private void updateItem ( final DataItemInputOutputChained item, final Value<?> value )
    {
        final Variant variant = convertValue ( value );

        final Object o = value.getValue ();

        final Map<String, Variant> attributes = new HashMap<> ();
        attributes.put ( "timestamp", Variant.valueOf ( value.getTimestamp () ) );

        if ( o != null )
        {
            attributes.put ( "iec.data.type", Variant.valueOf ( o.getClass () ) );
        }

        if ( value.isOverflow () )
        {
            attributes.put ( "overflow.error", Variant.TRUE );
        }
        if ( value.getQualityInformation ().isSubstituted () )
        {
            attributes.put ( "manual", Variant.TRUE );
        }
        if ( !value.getQualityInformation ().isValid () )
        {
            attributes.put ( "iec60870.data.error", Variant.TRUE );
        }
        if ( value.getQualityInformation ().isBlocked () )
        {
            attributes.put ( "blocked", Variant.TRUE );
        }
        if ( !value.getQualityInformation ().isTopical () )
        {
            attributes.put ( "iec60870.topical.error", Variant.TRUE );
        }

        item.updateData ( variant, attributes, AttributeMode.SET );
    }

    private Variant convertValue ( final Value<?> value )
    {
        final Object o = value.getValue ();
        if ( o instanceof DoublePoint )
        {
            final DoublePoint dp = (DoublePoint)o;
            switch ( dp )
            {
                case OFF:
                    return Variant.FALSE;
                case ON:
                    return Variant.TRUE;
                default:
                    return Variant.NULL;
            }
        }
        return Variant.valueOf ( value.getValue () );
    }

    private synchronized DataItemInputOutputChained getItem ( final ASDUAddress commonAddress, final InformationObjectAddress objectAddress )
    {
        final String localId = makeLocalId ( commonAddress, objectAddress );

        final DataItemInputOutputChained item = this.itemCache.get ( localId );

        if ( item == null )
        {
            return createItem ( localId, commonAddress, objectAddress );
        }
        else
        {
            return item;
        }
    }

    private DataItemInputOutputChained createItem ( final String localId, final ASDUAddress commonAddress, final InformationObjectAddress objectAddress )
    {
        final String id = this.id + ".data." + localId;

        final DataItemInformation di = new DataItemInformationBase ( id, EnumSet.of ( IODirection.INPUT, IODirection.OUTPUT ) );

        final DataItemInputOutputChained item = new DataItemInputOutputChained ( di, this.executor ) {

            @Override
            protected NotifyFuture<WriteResult> startWriteCalculatedValue ( final Variant value, final OperationParameters operationParameters )
            {
                return handleStartWriteValue ( commonAddress, objectAddress, value, operationParameters );
            }
        };

        item.addChainElement ( IODirection.INPUT, new SumErrorChainItem () );

        this.itemCache.put ( localId, item );

        final Map<String, Variant> attributes = new HashMap<String, Variant> ();
        attributes.put ( "iec.60870.address", Variant.valueOf ( localId ) );

        this.hive.registerItem ( item );
        this.storage.added ( new ItemDescriptor ( item, attributes ) );

        return item;
    }

    protected NotifyFuture<WriteResult> handleStartWriteValue ( final ASDUAddress commonAddress, final InformationObjectAddress objectAddress, final Variant value, final OperationParameters operationParameters )
    {
        return new InstantErrorFuture<WriteResult> ( new UnsupportedOperationException () ); // FIXME: implement
    }

    private String makeLocalId ( final ASDUAddress commonAddress, final InformationObjectAddress objectAddress )
    {
        final StringBuilder sb = new StringBuilder ();

        switch ( this.protocolOptions.getAdsuAddressType () )
        {
            case SIZE_1:
            {
                sb.append ( String.format ( "%d", commonAddress.getAddress () & 0xFF ) );
                break;
            }
            default:
            {
                final int a = commonAddress.getAddress ();
                sb.append ( String.format ( "%d.%d", a >> 8 & 0xFF, a & 0xFF ) );
                break;
            }
        }

        sb.append ( '.' );

        switch ( this.protocolOptions.getInformationObjectAddressType () )
        {
            case SIZE_1:
            {
                sb.append ( String.format ( "%d", objectAddress.getAddress () & 0xFF ) );
                break;
            }
            case SIZE_2:
            {
                final int a = objectAddress.getAddress ();
                sb.append ( String.format ( "%d.%d", a >> 8 & 0xFF, a & 0xFF ) );
                break;
            }
            default:
            {
                final int a = objectAddress.getAddress ();
                sb.append ( String.format ( "%d.%d.%d", a >> 16 & 0xFF, a >> 8 & 0xFF, a & 0xFF ) );
                break;
            }
        }

        return sb.toString ();
    }

    protected void handleStateChanged ( final State state, final Throwable e )
    {
        logger.info ( "Connection state changed: {}", state );

        this.clientState.setConnectionState ( "" + state );
    }

    public void dispose ()
    {
        if ( !this.disposed.compareAndSet ( false, true ) )
        {
            return;
        }

        this.stateFactory.dispose ();
        this.hive.getRootFolder ().remove ( this.folder );

        try
        {
            this.client.close ();
        }
        catch ( final InterruptedException e )
        {
            logger.warn ( "Failed to close client", e );
        }
    }
}
