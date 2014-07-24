/*******************************************************************************
 * Copyright (c) 2010, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - clean up subscription manager, change shutdown handling
 *     IBH SYSTEMS GmbH - add context information
 *******************************************************************************/
package org.eclipse.scada.da.server.common.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.eclipse.scada.core.InvalidSessionException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.core.server.common.AuthorizationProvider;
import org.eclipse.scada.core.server.common.AuthorizedOperation;
import org.eclipse.scada.core.server.common.ServiceCommon;
import org.eclipse.scada.core.server.common.session.AbstractSessionImpl;
import org.eclipse.scada.core.subscription.ListenableSubscriptionManager;
import org.eclipse.scada.core.subscription.SubscriptionListener;
import org.eclipse.scada.core.subscription.SubscriptionManagerListener;
import org.eclipse.scada.core.subscription.SubscriptionValidator;
import org.eclipse.scada.core.subscription.ValidationException;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.core.server.Hive;
import org.eclipse.scada.da.core.server.InvalidItemException;
import org.eclipse.scada.da.core.server.Session;
import org.eclipse.scada.da.core.server.browser.HiveBrowser;
import org.eclipse.scada.da.server.browser.common.Folder;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.ValidationStrategy;
import org.eclipse.scada.da.server.common.factory.DataItemFactory;
import org.eclipse.scada.da.server.common.factory.DataItemValidator;
import org.eclipse.scada.da.server.common.impl.stats.HiveCommonStatisticsGenerator;
import org.eclipse.scada.sec.AuthorizationReply;
import org.eclipse.scada.sec.AuthorizationRequest;
import org.eclipse.scada.sec.AuthorizationResult;
import org.eclipse.scada.sec.PermissionDeniedException;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.collection.MapBuilder;
import org.eclipse.scada.utils.concurrent.CallingFuture;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A common base for implementing Hive instances <h1>Lifecycle</h1>
 * <p>
 * Hives are created using the constructor. There is no defined destructor.
 * However there are start and stop methods that may create and free resources.
 * All resources allocated in the start method should be destroyed in the stop
 * method.
 * </p>
 * <p>
 * The item subscription manager will also be created in the
 * {@link #performStart()} method. So registering items is only possible
 * <em>after</em> the hive has been started.
 * </p>
 * <code>
 * protected void performStart () {
 *  super.performStart ();
 *  registerItem ( "abc", … );
 * }
 * </code>
 */
public abstract class HiveCommon extends ServiceCommon<Session, SessionCommon> implements Hive
{
    private final static Logger logger = LoggerFactory.getLogger ( HiveCommon.class );

    private final Set<SessionCommon> sessions = new HashSet<SessionCommon> ();

    private final Map<String, DataItem> itemMap = new HashMap<String, DataItem> ( 1000 );

    private Lock itemMapReadLock;

    private Lock itemMapWriteLock;

    private HiveBrowserCommon browser;

    private Folder rootFolder;

    private final Set<SessionListener> sessionListeners = new CopyOnWriteArraySet<SessionListener> ();

    private volatile ExecutorService operationService;

    private final List<DataItemFactory> factoryList = new CopyOnWriteArrayList<DataItemFactory> ();

    private ListenableSubscriptionManager<String> itemSubscriptionManager;

    private final Set<DataItemValidator> itemValidators = new CopyOnWriteArraySet<DataItemValidator> ();

    private ValidationStrategy validationStrategy = ValidationStrategy.GRANT_ALL;

    private HiveCommonStatisticsGenerator statisticsGenerator;

    private boolean autoEnableStats = true;

    private final ReadWriteLock browserLock = new ReentrantReadWriteLock ();

    private final AuthorizationProvider<AbstractSessionImpl> authorizationProvider = new AuthorizationProvider<AbstractSessionImpl> () {

        @Override
        public NotifyFuture<UserInformation> impersonate ( final AbstractSessionImpl session, final String targetUserName, final CallbackHandler handler )
        {
            return makeEffectiveUserInformation ( session, targetUserName, handler );
        }

        @Override
        public NotifyFuture<AuthorizationReply> authorize ( final AuthorizationRequest authorizationRequest, final CallbackHandler callbackHandler, final AuthorizationResult defaultResult )
        {
            return HiveCommon.this.authorize ( authorizationRequest, callbackHandler, defaultResult );
        }
    };

    private final AtomicBoolean running = new AtomicBoolean ();

    private SubscriptionValidator<String> subscriptionValidator;

    public HiveCommon ()
    {
        final ReentrantReadWriteLock itemMapLock = new ReentrantReadWriteLock ( Boolean.getBoolean ( "org.eclipse.scada.da.server.common.fairItemMapLock" ) );

        this.itemMapReadLock = itemMapLock.readLock ();
        this.itemMapWriteLock = itemMapLock.writeLock ();

        this.subscriptionValidator = new SubscriptionValidator<String> () {

            @Override
            public boolean validate ( final SubscriptionListener<String> listener, final String topic )
            {
                return validateItem ( topic );
            }
        };
    }

    protected void addItemSubscriptionListener ( final SubscriptionManagerListener<String> listener )
    {
        checkRunning ();

        this.itemSubscriptionManager.addManagerListener ( listener );
    }

    protected void removeItemSubscriptionListener ( final SubscriptionManagerListener<String> listener )
    {
        checkRunning ();

        this.itemSubscriptionManager.removeManagerListener ( listener );
    }

    @Override
    public void start () throws Exception
    {
        logger.info ( "Starting Hive" );

        if ( !this.running.compareAndSet ( false, true ) )
        {
            return;
        }

        this.operationService = Executors.newFixedThreadPool ( 1, new NamedThreadFactory ( "HiveCommon/" + getHiveId () ) );
        this.itemSubscriptionManager = new ListenableSubscriptionManager<String> ( this.operationService, this.subscriptionValidator );

        if ( this.autoEnableStats && this.rootFolder instanceof FolderCommon )
        {
            enableStats ( (FolderCommon)this.rootFolder );
        }

        performStart ();
    }

    @Override
    public void stop () throws Exception
    {
        logger.info ( "Stopping hive" );

        if ( !this.running.compareAndSet ( true, false ) )
        {
            return;
        }

        performStop ();

        disableStats ();

        try
        {
            this.itemMapWriteLock.lock ();
            this.itemMap.clear ();
        }
        finally
        {
            this.itemMapWriteLock.unlock ();
        }

        this.browserLock.writeLock ().lock ();
        try
        {
            if ( this.browser != null )
            {
                this.browser.stop ();
                this.browser = null;
            }
        }
        finally
        {
            this.browserLock.writeLock ().unlock ();
        }

        if ( this.itemSubscriptionManager != null )
        {
            this.itemSubscriptionManager.dispose ();
            this.itemSubscriptionManager = null;
        }

        if ( this.operationService != null )
        {
            this.operationService.shutdown ();
            this.operationService = null;
        }
    }

    /**
     * Called then the hive should perform its startup procedure
     * <p>
     * This is internally dispatched when the {@link #start()} method was called
     * and the hive was not already started.
     * </p>
     */
    protected void performStart () throws Exception
    {
    }

    /**
     * Called then the hive should perform its shutdown procedure
     * <p>
     * This is internally dispatched when the {@link #stop()} method was called
     * and the hive was already started.
     * </p>
     */
    protected void performStop () throws Exception
    {
    }

    /**
     * Get a unique ID for you hive type
     *
     * @return a unique id of you hive type
     */
    public abstract String getHiveId ();

    public void addSessionListener ( final SessionListener listener )
    {
        this.sessionListeners.add ( listener );
    }

    public void removeSessionListener ( final SessionListener listener )
    {
        this.sessionListeners.remove ( listener );
    }

    private void fireSessionCreate ( final AbstractSessionImpl session )
    {
        if ( this.statisticsGenerator != null )
        {
            this.statisticsGenerator.sessionCreated ( session );
        }

        for ( final SessionListener listener : this.sessionListeners )
        {
            try
            {
                listener.create ( session );
            }
            catch ( final Throwable e )
            {
            }
        }

    }

    private void fireSessionDestroy ( final SessionCommon session )
    {
        if ( this.statisticsGenerator != null )
        {
            this.statisticsGenerator.sessionDestroyed ( session );
        }

        synchronized ( this.sessionListeners )
        {
            for ( final SessionListener listener : this.sessionListeners )
            {
                try
                {
                    listener.destroy ( session );
                }
                catch ( final Throwable e )
                {
                }
            }
        }
    }

    /**
     * Set the root folder. <br/>
     * <p>
     * <em>Note:</em>The root folder can only be set once. All further set
     * requests are ignored.
     * </p>
     * <p>
     * <em>Note:</em>The root folder must be set before the start method is
     * called (e.g. in the constructor)
     * </p>
     */
    protected synchronized void setRootFolder ( final Folder rootFolder )
    {
        if ( this.rootFolder == null )
        {
            this.rootFolder = rootFolder;
        }
    }

    private void enableStats ( final FolderCommon rootFolder )
    {
        disableStats ();

        final HiveCommonStatisticsGenerator stats = new HiveCommonStatisticsGenerator ( "statistics" );
        this.statisticsGenerator = stats;

        final FolderCommon statsFolder = new FolderCommon ();
        rootFolder.add ( "statistics", statsFolder, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "A folder containing statistic items" ) ).getMap () );

        stats.register ( this, statsFolder );
    }

    private void disableStats ()
    {
        if ( this.statisticsGenerator == null )
        {
            return;
        }

        this.statisticsGenerator.unregister ();
        this.statisticsGenerator = null;

        if ( this.rootFolder instanceof FolderCommon && this.autoEnableStats )
        {
            ( (FolderCommon)this.rootFolder ).remove ( "statistics" );
        }
    }

    /**
     * Validate a session and return the session common instance if the session
     * is valid
     *
     * @param session
     *            the session to validate
     * @return the session common instance
     * @throws InvalidSessionException
     *             in the case of an invalid session
     */
    public SessionCommon validateSession ( final org.eclipse.scada.core.server.Session session ) throws InvalidSessionException
    {
        if ( ! ( session instanceof SessionCommon ) )
        {
            throw new InvalidSessionException ();
        }

        final SessionCommon sessionCommon = (SessionCommon)session;
        if ( sessionCommon.getHive () != this )
        {
            throw new InvalidSessionException ();
        }

        if ( !this.sessions.contains ( sessionCommon ) )
        {
            throw new InvalidSessionException ();
        }

        return sessionCommon;
    }

    // implementation of hive interface

    @Override
    public NotifyFuture<Session> createSession ( final Properties properties, final Map<String, Object> contextInformation, final CallbackHandler callbackHandler )
    {
        if ( !this.running.get () )
        {
            return new InstantErrorFuture<> ( makeCheckRunningException () );
        }

        final NotifyFuture<UserInformation> loginFuture = loginUser ( properties, contextInformation, callbackHandler );

        return new CallingFuture<UserInformation, Session> ( loginFuture ) {

            @Override
            public Session call ( final Future<UserInformation> future ) throws Exception
            {
                return createSession ( future, properties, callbackHandler );
            }
        };
    }

    protected Session createSession ( final Future<UserInformation> loginFuture, final Properties properties, final CallbackHandler callbackHandler ) throws InterruptedException, ExecutionException
    {
        final UserInformation user = loginFuture.get ();

        logger.debug ( "Create Session - user: {}", user );

        final Map<String, String> sessionProperties = new HashMap<String, String> ();

        fillSessionProperties ( user, sessionProperties );

        final SessionCommon session = new SessionCommon ( this, user, sessionProperties );

        handleSessionCreated ( session, properties, user );

        synchronized ( this.sessions )
        {
            this.sessions.add ( session );
            fireSessionCreate ( session );
        }

        return session;
    }

    protected void handleSessionCreated ( final AbstractSessionImpl session, final Properties properties, final UserInformation userInformation )
    {
    }

    /**
     * Close a session.
     * The session will be invalid after it has been closed. All subscriptions
     * will become invalid. All pending operation will get canceled.
     */
    @Override
    public void closeSession ( final Session session ) throws InvalidSessionException
    {
        final SessionCommon sessionCommon = validateSession ( session );

        checkRunning ();

        synchronized ( this.sessions )
        {
            this.sessions.remove ( session );
        }

        logger.info ( "Close session: {}", session );
        fireSessionDestroy ( (SessionCommon)session );

        // destroy all subscriptions for this session
        this.itemSubscriptionManager.unsubscribeAll ( sessionCommon );

        // cancel all pending operations
        sessionCommon.dispose ();
    }

    @Override
    public void subscribeItem ( final Session session, final String itemId ) throws InvalidSessionException, InvalidItemException
    {
        logger.debug ( "Subscribing item: {}", itemId );

        checkRunning ();

        // validate the session first
        final SessionCommon sessionCommon = validateSession ( session );

        // subscribe using the new item subscription manager
        try
        {
            // request realization
            retrieveItem ( itemId );
            // and subscribe to item
            this.itemSubscriptionManager.subscribe ( itemId, sessionCommon );
        }
        catch ( final ValidationException e )
        {
            throw new InvalidItemException ( itemId );
        }
    }

    /**
     * Unsubscribe a session from an item
     */
    @Override
    public void unsubscribeItem ( final Session session, final String itemId ) throws InvalidSessionException, InvalidItemException
    {
        logger.debug ( "Unsubscribing item: {}", itemId );

        checkRunning ();

        final SessionCommon sessionCommon = validateSession ( session );

        // unsubscribe using the new item subscription manager
        this.itemSubscriptionManager.unsubscribe ( itemId, sessionCommon );
    }

    private void checkRunning ()
    {
        if ( !this.running.get () )
        {
            throw makeCheckRunningException ();
        }
    }

    private static IllegalStateException makeCheckRunningException ()
    {
        return new IllegalStateException ( "Hive is not running running. Start it first!" );
    }

    /**
     * Register a new item with the hive
     * <p>
     * Note that registering an item is only possible after the Hive has been
     * started.
     * </p>
     *
     * @param item
     *            the item to register
     */
    public void registerItem ( final DataItem item )
    {
        logger.debug ( "Register item: {}", item );

        checkRunning ();

        try
        {
            this.itemMapWriteLock.lock ();

            final String id = item.getInformation ().getName ();

            if ( !this.itemMap.containsKey ( id ) )
            {
                // first add internally ...
                this.itemMap.put ( id, item );

                if ( this.statisticsGenerator != null )
                {
                    this.statisticsGenerator.itemRegistered ( item );
                }
            }
            else
            {
                logger.warn ( String.format ( "Duplicate error: item %s already registered with hive", item.getInformation ().getName () ) );
            }

            // add new topic to the new item subscription manager
            this.itemSubscriptionManager.setSource ( id, new DataItemSubscriptionSource ( getOperationService (), item, this.statisticsGenerator ) );
        }
        finally
        {
            this.itemMapWriteLock.unlock ();
        }
    }

    private Executor getOperationServiceInstance ()
    {
        checkRunning ();

        return this.operationService;
    }

    public Executor getOperationService ()
    {
        return new Executor () {
            @Override
            public void execute ( final Runnable command )
            {
                final Executor executor = getOperationServiceInstance ();
                if ( executor == null )
                {
                    throw new IllegalStateException ( "Hive is disposed" );
                }
                executor.execute ( command );
            }
        };
    }

    /**
     * Remove an item from the hive.
     *
     * @param item
     *            the item to remove
     */
    public void unregisterItem ( final DataItem item )
    {
        logger.debug ( "Unregister item: {}", item );

        if ( !this.running.get () )
        {
            // we silently ignore this there, since everything should already be unregistered
            return;
        }

        try
        {
            this.itemMapWriteLock.lock ();

            final String id = item.getInformation ().getName ();
            if ( this.itemMap.containsKey ( id ) )
            {
                this.itemMap.remove ( id );
                if ( this.statisticsGenerator != null )
                {
                    this.statisticsGenerator.itemUnregistered ( item );
                }
            }

            // remove the source from the manager
            this.itemSubscriptionManager.setSource ( id, null );
        }
        finally
        {
            this.itemMapWriteLock.unlock ();
        }
    }

    private void factoryCreate ( final String id )
    {
        logger.debug ( "FactoryCreate - itemId: {}", id );

        /* locking the factory list so that no one else can perform the creation process until we are done */
        synchronized ( this.factoryList )
        {
            for ( final DataItemFactory factory : this.factoryList )
            {
                if ( factory.canCreate ( id ) )
                {
                    // we let the factory create the item
                    factory.create ( id );
                    // only try one factory
                    return;
                }
            }
        }

    }

    /**
     * Validate a data item id if it can be provided by the hive.
     * <p>
     * The hive will perform several methods to check if the item id is valid.
     * <p>
     * Implementations must not create items based an a validation check!
     *
     * @return <code>true</code> if the item id is valid <code>false</code>
     *         otherwise
     */
    protected boolean validateItem ( final String id )
    {
        if ( this.validationStrategy == ValidationStrategy.GRANT_ALL )
        {
            return true;
        }

        // First check if the item already exists
        if ( lookupItem ( id ) != null )
        {
            return true;
        }

        // now check if the item passes the validators
        for ( final DataItemValidator dataItemValidator : this.itemValidators )
        {
            if ( dataItemValidator.isValid ( id ) )
            {
                return true;
            }
        }

        synchronized ( this.factoryList )
        {
            for ( final DataItemFactory factory : this.factoryList )
            {
                if ( factory.canCreate ( id ) )
                {
                    return true;
                }
            }
        }
        return false;
    }

    public DataItem lookupItem ( final String id )
    {
        try
        {
            this.itemMapReadLock.lock ();
            return this.itemMap.get ( id );
        }
        finally
        {
            this.itemMapReadLock.unlock ();
        }
    }

    protected DataItem retrieveItem ( final String id )
    {
        final DataItem dataItem = lookupItem ( id );
        if ( dataItem != null )
        {
            return dataItem;
        }

        // let it create
        factoryCreate ( id );

        // and refetch
        return lookupItem ( id );
    }

    private static final String DATA_ITEM_OBJECT_TYPE = "ITEM"; //$NON-NLS-1$

    @Override
    public NotifyFuture<WriteAttributeResults> startWriteAttributes ( final Session session, final String itemId, final Map<String, Variant> attributes, final OperationParameters operationParameters, final CallbackHandler callbackHandler ) throws InvalidSessionException, InvalidItemException, PermissionDeniedException
    {
        final SessionCommon sessionCommon = validateSession ( session );

        return new AuthorizedOperation<WriteAttributeResults, AbstractSessionImpl> ( this.authorizationProvider, sessionCommon, DATA_ITEM_OBJECT_TYPE, itemId, "WRITE_ATTRIBUTES", makeSetAttributesContext ( attributes ), operationParameters, sessionCommon.wrapCallbackHandler ( callbackHandler ), DEFAULT_RESULT ) {

            @Override
            protected NotifyFuture<WriteAttributeResults> granted ( final org.eclipse.scada.core.server.OperationParameters effectiveOperationParameters )
            {
                return processWriteAttributes ( sessionCommon, itemId, attributes, effectiveOperationParameters );
            }
        };
    }

    protected NotifyFuture<WriteAttributeResults> processWriteAttributes ( final SessionCommon session, final String itemId, final Map<String, Variant> attributes, final org.eclipse.scada.core.server.OperationParameters operationParameters )
    {
        logger.debug ( "Process write attributes - itemId: {}, attributes: {}", itemId, attributes );

        final DataItem item = retrieveItem ( itemId );

        if ( item == null )
        {
            return new InstantErrorFuture<WriteAttributeResults> ( new InvalidItemException ( itemId ).fillInStackTrace () );
        }

        // stats
        if ( this.statisticsGenerator != null )
        {
            this.statisticsGenerator.startWriteAttributes ( session, itemId, attributes.size () );
        }

        // go
        final NotifyFuture<WriteAttributeResults> future = item.startSetAttributes ( attributes, operationParameters );
        try
        {
            session.addFuture ( future );
            return future;
        }
        catch ( final InvalidSessionException e )
        {
            return new InstantErrorFuture<WriteAttributeResults> ( e );
        }
    }

    private Map<String, Object> makeSetAttributesContext ( final Map<String, Variant> attributes )
    {
        final Map<String, Object> context = new HashMap<String, Object> ( 1 );
        context.put ( "attributes", attributes );
        return context;
    }

    private Map<String, Object> makeWriteValueContext ( final Variant value )
    {
        final Map<String, Object> context = new HashMap<String, Object> ( 1 );
        context.put ( "value", value );
        return context;
    }

    @Override
    public NotifyFuture<WriteResult> startWrite ( final Session session, final String itemId, final Variant value, final OperationParameters operationParameters, final CallbackHandler callbackHandler ) throws InvalidSessionException, InvalidItemException
    {
        final SessionCommon sessionCommon = validateSession ( session );

        return new AuthorizedOperation<WriteResult, AbstractSessionImpl> ( this.authorizationProvider, sessionCommon, DATA_ITEM_OBJECT_TYPE, itemId, "WRITE", makeWriteValueContext ( value ), operationParameters, sessionCommon.wrapCallbackHandler ( callbackHandler ), DEFAULT_RESULT ) {

            @Override
            protected NotifyFuture<WriteResult> granted ( final org.eclipse.scada.core.server.OperationParameters effectiveOperationParameters )
            {
                return processWrite ( sessionCommon, itemId, value, effectiveOperationParameters );
            }
        };
    }

    protected NotifyFuture<WriteResult> processWrite ( final SessionCommon session, final String itemId, final Variant value, final org.eclipse.scada.core.server.OperationParameters effectiveOperationParameters )
    {
        logger.debug ( "Processing write - granted - itemId: {}, value: {}", itemId, value );

        final DataItem item = retrieveItem ( itemId );

        if ( item == null )
        {
            return new InstantErrorFuture<WriteResult> ( new InvalidItemException ( itemId ).fillInStackTrace () );
        }

        // stats
        if ( this.statisticsGenerator != null )
        {
            this.statisticsGenerator.startWrite ( session, itemId, value );
        }

        // go
        final NotifyFuture<WriteResult> future = item.startWriteValue ( value, effectiveOperationParameters );
        try
        {
            session.addFuture ( future );
            return future;
        }
        catch ( final InvalidSessionException e )
        {
            return new InstantErrorFuture<WriteResult> ( e );
        }
    }

    @Override
    public HiveBrowser getBrowser ()
    {
        this.browserLock.readLock ().lock ();
        try
        {
            if ( this.browser != null || this.rootFolder == null )
            {
                return this.browser;
            }
        }
        finally
        {
            this.browserLock.readLock ().unlock ();
        }

        this.browserLock.writeLock ().lock ();
        try
        {
            // we need to check again
            if ( this.browser != null || this.rootFolder == null )
            {
                return this.browser;
            }
            this.browser = new HiveBrowserCommon ( this ) {

                @Override
                public Folder getRootFolder ()
                {
                    return HiveCommon.this.rootFolder;
                }
            };
            this.browser.start ();
            return this.browser;
        }
        finally
        {
            this.browserLock.writeLock ().unlock ();
        }
    }

    public void addItemFactory ( final DataItemFactory factory )
    {
        this.factoryList.add ( factory );
    }

    public void removeItemFactory ( final DataItemFactory factory )
    {
        this.factoryList.remove ( factory );
    }

    /**
     * Gets a set of all items in granted state.
     *
     * @return The list of granted items.
     */
    public Set<String> getGrantedItems ()
    {
        return this.itemSubscriptionManager.getAllGrantedTopics ();
    }

    public void addDataItemValidator ( final DataItemValidator dataItemValidator )
    {
        this.itemValidators.add ( dataItemValidator );
    }

    public void removeItemValidator ( final DataItemValidator dataItemValidator )
    {
        this.itemValidators.remove ( dataItemValidator );
    }

    protected ValidationStrategy getValidationStrategy ()
    {
        return this.validationStrategy;
    }

    /**
     * Set the validation strategy <br/>
     * <em>Note:</em> The validation strategy has to be set before the hive is
     * started (e.g. in the constructor of the hive).
     *
     * @param validatonStrategy
     */
    protected void setValidatonStrategy ( final ValidationStrategy validatonStrategy )
    {
        this.validationStrategy = validatonStrategy;
    }

    public boolean isAutoEnableStats ()
    {
        return this.autoEnableStats;
    }

    /**
     * This will disable the automatic generation of the stats module when
     * setting
     * the root folder. Must be called before {@link #setRootFolder(Folder)}
     *
     * @param autoEnableStats
     */
    public void setAutoEnableStats ( final boolean autoEnableStats )
    {
        this.autoEnableStats = autoEnableStats;
    }
}
