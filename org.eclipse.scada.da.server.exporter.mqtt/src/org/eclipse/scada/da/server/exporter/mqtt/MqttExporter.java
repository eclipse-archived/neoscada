/*******************************************************************************
 * Copyright (c) 2013 Jürgen Rose and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jürgen Rose - initial API and implementation
 *******************************************************************************/

package org.eclipse.scada.da.server.exporter.mqtt;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDefaultFilePersistence;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.InvalidSessionException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantEditor;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.core.server.Hive;
import org.eclipse.scada.da.core.server.InvalidItemException;
import org.eclipse.scada.da.core.server.ItemChangeListener;
import org.eclipse.scada.da.core.server.Session;
import org.eclipse.scada.sec.PermissionDeniedException;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.lifecycle.LifecycleAware;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.eclipse.scada.utils.osgi.pool.ObjectPool;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolListener;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;

public class MqttExporter implements LifecycleAware
{

    private final static Logger logger = LoggerFactory.getLogger ( MqttExporter.class );

    private static final String defaultClientId = MqttClient.generateClientId ();

    public static final String isoDatePattern = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final DateFormat isoDateFormat = new SimpleDateFormat ( isoDatePattern );

    private static class VariantTypeAdapter implements JsonSerializer<Variant>, JsonDeserializer<Variant>
    {
        @Override
        public JsonElement serialize ( final Variant src, final Type typeOfSrc, final JsonSerializationContext context )
        {
            return new JsonPrimitive ( src.toString () );
        }

        @Override
        public Variant deserialize ( final JsonElement json, final Type typeOfT, final JsonDeserializationContext context ) throws JsonParseException
        {
            final VariantEditor ve = new VariantEditor ();
            ve.setAsText ( json.getAsJsonPrimitive ().getAsString () );
            return (Variant)ve.getValue ();
        }
    }

    private static final Gson gson = new GsonBuilder ().setDateFormat ( DateFormat.FULL ).setDateFormat ( isoDatePattern ).registerTypeAdapter ( Variant.class, new VariantTypeAdapter () ).create ();

    private final BundleContext context;

    private final ExecutorService executor;

    private boolean started = false;

    private String clientId;

    private URI uri;

    private File persistencePath;

    private Character delimiter = '.';

    private String prefix;

    private String writeValueSuffix;

    private String username;

    private String password;

    private MqttClient client;

    private SingleServiceTracker<Hive> hiveTracker;

    private SingleServiceTracker<ObjectPool<MqttItemToTopic>> poolTracker;

    private Hive hive;

    private ObjectPool<MqttItemToTopic> pool;

    private ObjectPoolListener<MqttItemToTopic> poolListener;

    private final BiMap<String, String> itemsToReadTopics = HashBiMap.create ();

    private final BiMap<String, String> itemsToWriteTopics = HashBiMap.create ();

    private final Map<String, DataItemValue> lastValues = new HashMap<String, DataItemValue> ();

    private Session session;

    public MqttExporter ( final BundleContext context, final ExecutorService executor )
    {
        this.context = context;
        this.executor = executor;
    }

    public void update ( final Map<String, String> parameters )
    {
        if ( this.started )
        {
            throw new RuntimeException ( "MQTT client must not be started when updating parameters!" );
        }
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );
        if ( cfg.getString ( "clientId" ) != null )
        {
            this.clientId = cfg.getString ( "clientId" );
        }
        if ( cfg.getString ( "uri" ) != null )
        {
            this.uri = URI.create ( cfg.getString ( "uri" ) );
        }
        if ( cfg.getString ( "persistencePath" ) != null )
        {
            this.persistencePath = new File ( cfg.getString ( "persistencePath" ) );
        }
        if ( cfg.getString ( "delimiter" ) != null )
        {
            this.delimiter = cfg.getString ( "delimiter", "." ).charAt ( 0 );
        }
        if ( cfg.getString ( "prefix" ) != null )
        {
            this.prefix = cfg.getString ( "prefix" );
        }
        this.writeValueSuffix = cfg.getString ( "writeSuffix", "$write" );
        this.username = cfg.getString ( "username", "mqtt" );
        this.password = cfg.getString ( "password", "" );
    }

    @Override
    public void start ()
    {
        this.executor.submit ( new Runnable () {
            @Override
            public void run ()
            {
                MqttExporter.this.started = true;

                // check parameters
                final String effectiveClientId = MqttExporter.this.clientId == null ? getDefaultClientId () : MqttExporter.this.clientId;
                logger.info ( "using clientId {}", effectiveClientId );
                final URI effectiveUri = MqttExporter.this.uri == null ? getDefaultUri () : MqttExporter.this.uri;
                logger.info ( "using URI {}", effectiveUri );
                final File effectivePersistencePath = MqttExporter.this.persistencePath == null ? getDefaultPersistencePath () : MqttExporter.this.persistencePath;
                logger.info ( "using persistence path {}", effectivePersistencePath );

                // set up setting
                if ( effectivePersistencePath.mkdirs () )
                {
                    logger.info ( "created mqtt persistence directory {}", effectivePersistencePath );
                }
                final MqttConnectOptions options = new MqttConnectOptions ();

                // start client
                logger.debug ( "starting MQTT client" );
                try
                {
                    MqttExporter.this.client = new MqttClient ( effectiveUri.toString (), effectiveClientId, new MqttDefaultFilePersistence ( effectivePersistencePath.getAbsolutePath () ) );
                    MqttExporter.this.client.connect ( options );
                }
                catch ( final MqttException e )
                {
                    logger.error ( "failed to start MQTT client", e );
                }

                // register for hive
                MqttExporter.this.hiveTracker = new SingleServiceTracker<Hive> ( MqttExporter.this.context, Hive.class, new SingleServiceListener<Hive> () {

                    @Override
                    public void serviceChange ( final ServiceReference<Hive> reference, final Hive service )
                    {
                        setHive ( service );
                    }

                } );
                MqttExporter.this.hiveTracker.open ();

                // register for pool
                Filter filter = null;
                try
                {
                    filter = FrameworkUtil.createFilter ( "(" + ObjectPool.OBJECT_POOL_CLASS + "=" + MqttItemToTopic.class.getName () + ")" );
                }
                catch ( final InvalidSyntaxException e )
                {
                    logger.error ( "parsing of filter failed", e );
                }
                MqttExporter.this.poolTracker = new SingleServiceTracker<> ( MqttExporter.this.context, filter, new SingleServiceListener<ObjectPool<MqttItemToTopic>> () {
                    @Override
                    public void serviceChange ( final ServiceReference<ObjectPool<MqttItemToTopic>> reference, final ObjectPool<MqttItemToTopic> service )
                    {
                        setPool ( service );
                    }
                } );
                MqttExporter.this.poolTracker.open ();
            }
        } );
    }

    @Override
    public void stop () throws Exception
    {
        this.executor.submit ( new Runnable () {
            @Override
            public void run ()
            {
                if ( MqttExporter.this.client != null )
                {
                    logger.debug ( "stopping MQTT client" );
                    try
                    {
                        MqttExporter.this.client.disconnect ( TimeUnit.SECONDS.toMillis ( 30 ) );
                    }
                    catch ( final MqttException e )
                    {
                        logger.warn ( "could not properly shut down MQTT client", e );
                    }
                    finally
                    {
                        MqttExporter.this.client = null;
                    }
                }

                if ( MqttExporter.this.poolTracker != null )
                {
                    MqttExporter.this.poolTracker.close ();
                }
                MqttExporter.this.poolTracker = null;

                if ( MqttExporter.this.hiveTracker != null )
                {
                    MqttExporter.this.hiveTracker.close ();
                }
                MqttExporter.this.hiveTracker = null;

                MqttExporter.this.itemsToReadTopics.clear ();
                MqttExporter.this.itemsToWriteTopics.clear ();
                MqttExporter.this.session = null;

                MqttExporter.this.started = false;
            }
        } );
    }

    private void setHive ( final Hive hive )
    {
        this.executor.submit ( new Runnable () {
            @Override
            public void run ()
            {
                if ( ( hive == null ) && ( MqttExporter.this.hive != null ) && ( MqttExporter.this.pool != null ) )
                {
                    try
                    {
                        unRealizeSubscriptions ( MqttExporter.this.hive, MqttExporter.this.pool );
                    }
                    catch ( final InvalidSessionException | MqttException e )
                    {
                        logger.error ( "call of unRealizeSubscriptions failed", e );
                    }
                }
                MqttExporter.this.hive = hive;
                if ( ( MqttExporter.this.hive != null ) && ( MqttExporter.this.pool != null ) )
                {
                    try
                    {
                        realizeSubscriptions ( MqttExporter.this.hive, MqttExporter.this.pool );
                    }
                    catch ( InterruptedException | ExecutionException | TimeoutException | MqttException e )
                    {
                        logger.error ( "call of realizeSubscriptions failed", e );
                    }
                }
            }
        } );
    }

    private void setPool ( final ObjectPool<MqttItemToTopic> pool )
    {
        this.executor.submit ( new Runnable () {
            @Override
            public void run ()
            {
                if ( ( pool == null ) && ( MqttExporter.this.pool != null ) && ( MqttExporter.this.hive != null ) )
                {
                    try
                    {
                        unRealizeSubscriptions ( MqttExporter.this.hive, MqttExporter.this.pool );
                    }
                    catch ( final InvalidSessionException | MqttException e )
                    {
                        logger.error ( "call of unRealizeSubscriptions failed", e );
                    }
                }
                MqttExporter.this.pool = pool;
                if ( ( MqttExporter.this.hive != null ) && ( MqttExporter.this.pool != null ) )
                {
                    try
                    {
                        realizeSubscriptions ( MqttExporter.this.hive, MqttExporter.this.pool );
                    }
                    catch ( InterruptedException | ExecutionException | TimeoutException | MqttException e )
                    {
                        logger.error ( "call of realizeSubscriptions failed", e );
                    }
                }
            }
        } );
    }

    private void realizeSubscriptions ( final Hive hive, final ObjectPool<MqttItemToTopic> pool ) throws InterruptedException, ExecutionException, TimeoutException, MqttException
    {
        // set up session for openSCADA item subscriptions
        final Properties sessionProperties = new Properties ();
        sessionProperties.put ( "user", this.username );
        sessionProperties.put ( "password", this.password );
        final NotifyFuture<Session> sessionFuture = hive.createSession ( sessionProperties, null );
        this.session = sessionFuture.get ( 30, TimeUnit.SECONDS );

        setupMqtt ( hive, this.session );

        setupItemListener ( hive, this.session );

        setupPoolListener ( hive, this.session );
    }

    private void unRealizeSubscriptions ( final Hive hive, final ObjectPool<MqttItemToTopic> pool ) throws InvalidSessionException, MqttException
    {
        if ( this.poolListener != null )
        {
            pool.removeListener ( this.poolListener );
        }
        if ( this.session != null )
        {
            this.session.setListener ( (ItemChangeListener)null );
            hive.closeSession ( this.session );
        }
        if ( this.client != null )
        {
            this.client.setCallback ( null );
        }
    }

    private void setupMqtt ( final Hive hive, final Session session ) throws MqttException
    {
        this.client.setCallback ( new MqttCallback () {
            @Override
            public void messageArrived ( final MqttTopic topic, final MqttMessage message ) throws Exception
            {
                logger.trace ( "received message '{}' on topic '{}'", message, topic );
                MqttExporter.this.executor.submit ( new Callable<Void> () {
                    @Override
                    public Void call () throws Exception
                    {
                        final String itemId = MqttExporter.this.itemsToWriteTopics.inverse ().get ( topic.getName () );
                        if ( itemId != null )
                        {
                            writeMessageToItem ( hive, session, itemId, message );
                        }
                        else
                        {
                            logger.warn ( "received message '{}' on topic '{}' but no corresponding item found", message, topic );
                        }
                        return null;
                    }
                } );
            }

            @Override
            public void deliveryComplete ( final MqttDeliveryToken token )
            {
                // TODO: implement this
                logger.trace ( "deliveryComplete {}", token );
            }

            @Override
            public void connectionLost ( final Throwable th )
            {
                // TODO: implement this
                logger.warn ( "connectionLost", th );
            }
        } );
    }

    private void setupItemListener ( final Hive hive, final Session session )
    {
        session.setListener ( new ItemChangeListener () {
            @Override
            public void dataChanged ( final String itemId, final Variant value, final Map<String, Variant> attributes, final boolean cache )
            {
                MqttExporter.this.executor.submit ( new Runnable () {
                    @Override
                    public void run ()
                    {
                        logger.trace ( "dataChanged ({}, {}, {}, cached = {})", new Object[] { itemId, value, attributes, cache } );
                        final String topic = MqttExporter.this.itemsToReadTopics.get ( itemId );
                        if ( topic != null )
                        {
                            publishValue ( itemId, topic, value, attributes, cache );
                        }
                        else
                        {
                            logger.warn ( "received value change '{}' for item '{}' but corresponding topic was not found", value, itemId );
                        }
                    }
                } );
            }

            @Override
            public void subscriptionChanged ( final String itemId, final SubscriptionState subscriptionState )
            {
                MqttExporter.this.executor.submit ( new Runnable () {
                    @Override
                    public void run ()
                    {
                        logger.trace ( "subscriptionChanged ({}, {}, {}, cached = {})", new Object[] { itemId, subscriptionState } );
                        final String topic = MqttExporter.this.itemsToReadTopics.get ( itemId );
                        if ( topic != null )
                        {
                            publishSubscriptionState ( itemId, topic, subscriptionState );
                        }
                        else
                        {
                            logger.warn ( "subscription change '{}' for item '{}' but corresponding topic was not found", subscriptionState, itemId );
                        }
                    }
                } );
            }
        } );
    }

    private void setupPoolListener ( final Hive hive, final Session session )
    {
        this.poolListener = new ObjectPoolListener<MqttItemToTopic> () {
            @Override
            public void serviceRemoved ( final MqttItemToTopic itemToTopic, final Dictionary<?, ?> properties )
            {
                try
                {
                    unsubscribe ( session, itemToTopic );
                }
                catch ( InvalidSessionException | InvalidItemException | MqttException e )
                {
                    logger.error ( "unsubscribe failed", e );
                }
            }

            @Override
            public void serviceModified ( final MqttItemToTopic itemToTopic, final Dictionary<?, ?> properties )
            {
                throw new UnsupportedOperationException ( "serviceModified must not be called" );
            }

            @Override
            public void serviceAdded ( final MqttItemToTopic itemToTopic, final Dictionary<?, ?> properties )
            {
                try
                {
                    subscribe ( session, itemToTopic );
                }
                catch ( InvalidSessionException | InvalidItemException | MqttException e )
                {
                    logger.error ( "subscribe failed", e );
                }
            }
        };
        this.pool.addListener ( this.poolListener );
    }

    private void subscribe ( final Session session, final MqttItemToTopic itemToTopic ) throws InvalidSessionException, InvalidItemException, MqttSecurityException, MqttException
    {
        this.executor.submit ( new Callable<Void> () {
            @Override
            public Void call () throws Exception
            {
                logger.trace ( "subscribe () called with {}", itemToTopic );
                if ( itemToTopic.isWritable () )
                {
                    logger.trace ( "subscribe () called on topic '{}'", makeWriteTopicName ( itemToTopic ) );
                    MqttExporter.this.client.subscribe ( makeWriteTopicName ( itemToTopic ) );
                    MqttExporter.this.itemsToWriteTopics.put ( itemToTopic.getItemId (), makeWriteTopicName ( itemToTopic ) );
                }
                if ( itemToTopic.isReadable () )
                {
                    MqttExporter.this.hive.subscribeItem ( session, itemToTopic.getItemId () );
                    MqttExporter.this.itemsToReadTopics.put ( itemToTopic.getItemId (), makeReadTopicName ( itemToTopic ) );
                }
                return null;
            }
        } );
    }

    private void unsubscribe ( final Session session, final MqttItemToTopic itemToTopic ) throws InvalidSessionException, InvalidItemException, MqttException
    {
        this.executor.submit ( new Callable<Void> () {
            @Override
            public Void call () throws Exception
            {
                logger.trace ( "unsubscribe () called with '{}'", itemToTopic );
                if ( itemToTopic.isReadable () )
                {
                    MqttExporter.this.itemsToReadTopics.remove ( itemToTopic.getItemId () );
                    MqttExporter.this.hive.unsubscribeItem ( session, itemToTopic.getItemId () );
                }
                if ( itemToTopic.isWritable () )
                {
                    logger.trace ( "unsubscribe () called on topic '{}'", makeWriteTopicName ( itemToTopic ) );
                    MqttExporter.this.itemsToWriteTopics.remove ( itemToTopic.getItemId () );
                    MqttExporter.this.client.unsubscribe ( makeWriteTopicName ( itemToTopic ) );
                }
                return null;
            }
        } );
    }

    /**
     * convert received mqtt message and write it to item
     * 
     * @param hive
     * @param session
     * @param itemId
     * @param message
     * @throws InvalidSessionException
     * @throws PermissionDeniedException
     * @throws InvalidItemException
     * @throws MqttException
     */
    private void writeMessageToItem ( final Hive hive, final Session session, final String itemId, final MqttMessage message ) throws InvalidSessionException, PermissionDeniedException, InvalidItemException, MqttException
    {
        final DataItemValue div = messageToValue ( itemId, message );
        if ( div != null )
        {
            if ( div.getValue () != null )
            {
                hive.startWrite ( session, itemId, div.getValue (), null, null );
            }
            if ( ( div.getAttributes () != null ) && !div.getAttributes ().isEmpty () )
            {
                hive.startWriteAttributes ( session, itemId, div.getAttributes (), null, null );
            }
        }
    }

    /**
     * merge last DataItemValue with new value and publish it on topic
     * 
     * @param itemId
     * @param topic
     * @param value
     * @param attributes
     * @param cache
     */
    private void publishValue ( final String itemId, final String topic, final Variant value, final Map<String, Variant> attributes, final boolean cache )
    {
        // first update last value
        DataItemValue div = this.lastValues.get ( itemId );
        if ( div == null )
        {
            div = new DataItemValue ( value, attributes, SubscriptionState.DISCONNECTED );
        }
        div = new DataItemValue ( value, attributes, div.getSubscriptionState () );
        this.lastValues.put ( itemId, div );

        publishValue ( topic, div );
    }

    /**
     * merge last DataItemValue with new subscription state and publish it on
     * topic
     * 
     * @param itemId
     * @param topic
     * @param subscriptionState
     */
    private void publishSubscriptionState ( final String itemId, final String topic, final SubscriptionState subscriptionState )
    {
        // first update last value
        DataItemValue div = this.lastValues.get ( itemId );
        if ( div == null )
        {
            div = new DataItemValue ( Variant.NULL, Collections.<String, Variant> emptyMap (), subscriptionState );
        }
        div = new DataItemValue ( div.getValue (), div.getAttributes (), subscriptionState );
        this.lastValues.put ( itemId, div );

        publishValue ( topic, div );
    }

    /**
     * send DataItemValue to topic
     * 
     * @param topic
     * @param div
     */
    private void publishValue ( final String topic, final DataItemValue div )
    {
        logger.trace ( "publish dataItemValue {} on topic {}", div, topic );
        try
        {
            this.client.getTopic ( topic ).publish ( valueToMessage ( div ) );
        }
        catch ( final MqttException e )
        {
            logger.error ( "could not publish message {} on topic {}", div, topic, e );
        }
    }

    /**
     * @param itemId
     * @param message
     *            from MQTT topic
     * @return converted value
     * @throws MqttException
     */
    private DataItemValue messageToValue ( final String itemId, final MqttMessage message ) throws MqttException
    {
        final DataItemValue div;
        try
        {
            div = gson.fromJson ( new String ( message.getPayload (), "UTF-8" ), DataItemValue.class );
            if ( message.isRetained () || message.isDuplicate () )
            {
                logger.info ( "message is retained/duplicate, will not write" );
                return null;
            }
            return div;
        }
        catch ( JsonSyntaxException | UnsupportedEncodingException e1 )
        {
            logger.warn ( "could not parse message {}", message );
            return null;
        }
    }

    private MqttMessage valueToMessage ( final DataItemValue value )
    {
        final MqttMessage message = new MqttMessage ();
        try
        {
            message.setPayload ( gson.toJson ( value ).getBytes ( "UTF-8" ) );
        }
        catch ( final UnsupportedEncodingException e )
        {
            logger.warn ( "could not convert value", e );
        }
        message.setRetained ( true );
        return message;
    }

    /**
     * converts item name to topic, or just uses the topic given in
     * configuration
     * 
     * @param itemToTopic
     * @return
     */
    private String makeReadTopicName ( final MqttItemToTopic itemToTopic )
    {
        final StringBuilder sb = new StringBuilder ();
        if ( this.prefix != null )
        {
            sb.append ( this.prefix );
        }
        if ( itemToTopic.getReadTopic () != null )
        {
            sb.append ( itemToTopic.getReadTopic () );
            return sb.toString ();
        }
        sb.append ( itemToTopic.getItemId ().replace ( this.delimiter, '/' ) );
        return sb.toString ();
    }

    /**
     * converts item name to topic, or just uses the topic given in
     * configuration
     * 
     * @param itemToTopic
     * @return
     */
    private String makeWriteTopicName ( final MqttItemToTopic itemToTopic )
    {
        final StringBuilder sb = new StringBuilder ();
        if ( this.prefix != null )
        {
            sb.append ( this.prefix );
        }
        if ( itemToTopic.getWriteValueTopic () != null )
        {
            sb.append ( itemToTopic.getWriteValueTopic () );
            return sb.toString ();
        }
        sb.append ( itemToTopic.getItemId ().replace ( this.delimiter, '/' ) );
        sb.append ( this.writeValueSuffix );
        return sb.toString ();
    }

    /**
     * @return default clientId given through system property
     */
    private String getDefaultClientId ()
    {
        return System.getProperty ( "org.openscada.da.server.mqtt.exporter.clientId", defaultClientId );
    }

    /**
     * @return default persistence property given through system property
     */
    private File getDefaultPersistencePath ()
    {
        return new File ( System.getProperty ( "org.openscada.da.server.mqtt.exporter.persistence", System.getProperty ( "user.home" ) + File.separator + ".openscada" + File.separator + "mqtt" ) );
    }

    /**
     * @return default mqtt uri given through system property
     */
    private URI getDefaultUri ()
    {
        return URI.create ( System.getProperty ( "org.openscada.da.server.mqtt.exporter.uri", "tcp://localhost:1883" ) );
    }

}
