/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.common.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.scada.core.InvalidSessionException;
import org.eclipse.scada.core.server.common.session.AbstractSessionImpl;
import org.eclipse.scada.da.core.Location;
import org.eclipse.scada.da.core.browser.Entry;
import org.eclipse.scada.da.core.server.Session;
import org.eclipse.scada.da.core.server.browser.HiveBrowser;
import org.eclipse.scada.da.core.server.browser.NoSuchFolderException;
import org.eclipse.scada.da.server.browser.common.Folder;
import org.eclipse.scada.da.server.browser.common.FolderListener;
import org.eclipse.scada.utils.concurrent.FutureTask;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HiveBrowserCommon implements HiveBrowser, FolderListener, SessionListener
{

    private final static Logger logger = LoggerFactory.getLogger ( HiveBrowserCommon.class );

    private HiveCommon hive = null;

    private final Map<Object, SessionCommon> subscriberMap = new HashMap<Object, SessionCommon> ();

    private ExecutorService operationService;

    public HiveBrowserCommon ( final HiveCommon hive )
    {
        this.hive = hive;
        this.hive.addSessionListener ( this );
    }

    public void start ()
    {
        this.operationService = Executors.newFixedThreadPool ( 1 );
    }

    public void stop ()
    {
        this.operationService.shutdown ();
    }

    @Override
    public NotifyFuture<Entry[]> startBrowse ( final Session session, final Location location ) throws InvalidSessionException
    {
        logger.debug ( "List request for: {}", location );

        final SessionCommon sessionCommon = this.hive.validateSession ( session );

        final Folder folder = getRootFolder ();

        // create the future and pass it to the default operation service
        final FutureTask<Entry[]> future = new FutureTask<Entry[]> ( new BrowseCallable ( folder, location ) );
        sessionCommon.addFuture ( future );
        this.operationService.execute ( future );
        return future;
    }

    @Override
    public void subscribe ( final Session session, final Location location ) throws NoSuchFolderException, InvalidSessionException
    {
        this.hive.validateSession ( session );

        if ( getRootFolder () == null )
        {
            logger.warn ( "Having a brower interface without root folder" );
            throw new NoSuchFolderException ( location.asArray () );
        }

        final Stack<String> pathStack = location.getPathStack ();

        synchronized ( this.subscriberMap )
        {
            logger.debug ( "Adding path: {}", location );

            final SessionCommon sessionCommon = (SessionCommon)session;
            final Object tag = new Object ();
            sessionCommon.getData ().addPath ( tag, new Location ( location ) );
            this.subscriberMap.put ( tag, sessionCommon );

            boolean success = false;
            try
            {
                getRootFolder ().subscribe ( pathStack, this, tag );
                success = true;
            }
            finally
            {
                if ( !success )
                {
                    sessionCommon.getData ().removePath ( new Location ( location ) );
                    this.subscriberMap.remove ( tag );
                }
            }
        }

    }

    @Override
    public void unsubscribe ( final Session session, final Location location ) throws NoSuchFolderException, InvalidSessionException
    {
        this.hive.validateSession ( session );

        if ( getRootFolder () == null )
        {
            logger.warn ( "Having a brower interface without root folder" );
            throw new NoSuchFolderException ( location.asArray () );
        }

        unsubscribePath ( (SessionCommon)session, location );
    }

    private void unsubscribePath ( final SessionCommon session, final Location location ) throws NoSuchFolderException
    {
        final Object tag = session.getData ().getTag ( new Location ( location ) );
        if ( tag != null )
        {
            session.getData ().removePath ( location );
            synchronized ( this.subscriberMap )
            {
                this.subscriberMap.remove ( tag );
            }

            final Stack<String> pathStack = location.getPathStack ();

            getRootFolder ().unsubscribe ( pathStack, tag );
        }
    }

    @Override
    public void changed ( final Object tag, final List<Entry> added, final Set<String> removed, final boolean full )
    {
        final SessionCommon session = this.subscriberMap.get ( tag );
        if ( session != null )
        {
            final Location location = session.getData ().getPaths ().get ( tag );
            try
            {
                session.getFolderListener ().folderChanged ( location, added, removed, full );
            }
            catch ( final Exception e )
            {
            }
        }
    }

    @Override
    public void create ( final AbstractSessionImpl session )
    {
    }

    @Override
    public void destroy ( final SessionCommon session )
    {
        logger.debug ( "Session destroy: {} entries", session.getData ().getPaths ().size () );

        final Map<Object, Location> entries;

        synchronized ( session.getData ().getPaths () )
        {
            entries = new HashMap<Object, Location> ( session.getData ().getPaths () );
        }

        for ( final Map.Entry<Object, Location> entry : entries.entrySet () )
        {
            try
            {
                logger.debug ( "Unsubscribe path: {}", entry.getValue () );
                unsubscribePath ( session, entry.getValue () );
            }
            catch ( final NoSuchFolderException e )
            {
                // just warn as debug since this doesn't matter anyway
                logger.debug ( "Unable to unsubscribe form path", e );
            }
        }

        session.getData ().clearPaths ();
        logger.debug ( "Destruction of session ok" );
    }

    public abstract Folder getRootFolder ();
}
