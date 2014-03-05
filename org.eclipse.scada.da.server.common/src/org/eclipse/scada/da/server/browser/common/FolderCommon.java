/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.browser.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.core.DataItemInformation;
import org.eclipse.scada.da.core.browser.Entry;
import org.eclipse.scada.da.core.server.browser.NoSuchFolderException;
import org.eclipse.scada.da.server.common.DataItem;

/**
 * A common folder implementation which can be used to easily implement folders.
 * 
 * @author Jens Reimann
 */
public class FolderCommon implements Folder
{

    private final Map<String, Entry> entryMap = new HashMap<String, Entry> ();

    private final Map<Object, FolderListener> listeners = new HashMap<Object, FolderListener> ();

    @Override
    public Entry[] list ( final Stack<String> path ) throws NoSuchFolderException
    {
        if ( path.isEmpty () )
        {
            return getAllEntries ();
        }
        else
        {
            return getFolderEntry ( path.pop () ).list ( path );
        }
    }

    private synchronized Entry[] getAllEntries ()
    {
        return this.entryMap.values ().toArray ( new Entry[this.entryMap.size ()] );
    }

    private synchronized Entry getEntry ( final String name )
    {
        return this.entryMap.get ( name );
    }

    private Folder getFolderEntry ( final String name ) throws NoSuchFolderException
    {
        final Entry entry = getEntry ( name );
        if ( entry instanceof FolderEntryCommon )
        {
            return ( (FolderEntryCommon)entry ).getFolder ();
        }
        else
        {
            throw new NoSuchFolderException ( new String[] { name } );
        }

    }

    /**
     * Bulk add items
     * 
     * @param folders
     *            folders to register or <code>null</code> if no folders should
     *            be registered
     * @param items
     *            items to register or <code>null</code> if no item should be
     *            registered
     * @return number of items added
     */
    public synchronized int add ( final Map<String, Folder> folders, final Map<String, DataItemInformation> items )
    {
        int size = 0;
        if ( folders != null )
        {
            size += folders.size ();
        }
        if ( items != null )
        {
            size += items.size ();
        }

        final List<Entry> entries = new ArrayList<Entry> ( size );

        // add folders
        if ( folders != null )
        {
            for ( final Map.Entry<String, Folder> folderEntry : folders.entrySet () )
            {
                final String name = folderEntry.getKey ();
                final Folder folder = folderEntry.getValue ();
                if ( !this.entryMap.containsKey ( name ) )
                {
                    final Entry entry = new FolderEntryCommon ( name, folder, null );
                    this.entryMap.put ( name, entry );

                    folder.added ();
                    entries.add ( entry );
                }
            }
        }

        // add items
        if ( items != null )
        {
            for ( final Map.Entry<String, DataItemInformation> itemEntry : items.entrySet () )
            {
                final String name = itemEntry.getKey ();
                final DataItemInformation itemInformation = itemEntry.getValue ();
                if ( !this.entryMap.containsKey ( name ) )
                {
                    final Entry entry = new DataItemEntryCommon ( name, itemInformation, null );
                    this.entryMap.put ( name, entry );
                    entries.add ( entry );
                }
            }
        }

        // send out bulk notify
        if ( !entries.isEmpty () )
        {
            notifyAdd ( entries );
        }

        return entries.size ();
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.da.server.browser.common.ConfigurableFolder#add(java.lang.String, org.eclipse.scada.da.server.browser.common.Folder, java.util.Map)
     */
    public synchronized boolean add ( final String name, final Folder folder, final Map<String, Variant> attributes )
    {
        if ( !this.entryMap.containsKey ( name ) )
        {
            final Entry entry = new FolderEntryCommon ( name, folder, attributes );
            this.entryMap.put ( name, entry );
            notifyAdd ( entry );
            folder.added ();
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean add ( final String name, final DataItem dataItem, final Map<String, Variant> attributes )
    {
        return add ( name, dataItem.getInformation (), attributes );
    }

    public boolean add ( final String name, final DataItemInformation itemInformation, final Map<String, Variant> attributes )
    {
        if ( itemInformation == null || itemInformation.getName () == null )
        {
            throw new NullPointerException ( "Item must have an id" );
        }

        synchronized ( this )
        {
            if ( !this.entryMap.containsKey ( name ) )
            {
                final Entry entry = new DataItemEntryCommon ( name, itemInformation, attributes );
                this.entryMap.put ( name, entry );
                notifyAdd ( entry );
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public synchronized boolean remove ( final String name )
    {
        if ( this.entryMap.containsKey ( name ) )
        {
            final Entry entry = this.entryMap.remove ( name );
            if ( entry instanceof FolderEntryCommon )
            {
                ( (FolderEntryCommon)entry ).getFolder ().removed ();
            }

            notifyRemove ( name );
            return true;
        }
        else
        {
            return false;
        }
    }

    public synchronized String findEntry ( final DataItem item )
    {
        for ( final Iterator<Map.Entry<String, Entry>> i = this.entryMap.entrySet ().iterator (); i.hasNext (); )
        {
            final String itemId = item.getInformation ().getName ();
            final Map.Entry<String, Entry> entry = i.next ();
            if ( entry.getValue () instanceof DataItemEntryCommon )
            {
                if ( ( (DataItemEntryCommon)entry.getValue () ).getId () == itemId )
                {
                    return entry.getKey ();
                }
            }
        }
        return null;
    }

    public synchronized String findEntry ( final Folder folder )
    {
        for ( final Iterator<Map.Entry<String, Entry>> i = this.entryMap.entrySet ().iterator (); i.hasNext (); )
        {
            final Map.Entry<String, Entry> entry = i.next ();
            if ( entry.getValue () instanceof FolderEntryCommon )
            {
                if ( ( (FolderEntryCommon)entry.getValue () ).getFolder () == folder )
                {
                    return entry.getKey ();
                }
            }
        }
        return null;
    }

    public synchronized boolean remove ( final Folder folder )
    {
        for ( final Iterator<Map.Entry<String, Entry>> i = this.entryMap.entrySet ().iterator (); i.hasNext (); )
        {
            final Map.Entry<String, Entry> entry = i.next ();
            if ( entry.getValue () instanceof FolderEntryCommon )
            {
                if ( ( (FolderEntryCommon)entry.getValue () ).getFolder () == folder )
                {
                    i.remove ();
                    folder.removed ();
                    notifyRemove ( entry.getKey () );
                    return true;
                }
            }
        }
        return false;
    }

    public synchronized boolean remove ( final DataItem item )
    {
        for ( final Iterator<Map.Entry<String, Entry>> i = this.entryMap.entrySet ().iterator (); i.hasNext (); )
        {
            final String itemId = item.getInformation ().getName ();
            final Map.Entry<String, Entry> entry = i.next ();
            if ( entry.getValue () instanceof DataItemEntryCommon )
            {
                if ( ( (DataItemEntryCommon)entry.getValue () ).getId () == itemId )
                {
                    i.remove ();
                    notifyRemove ( entry.getKey () );
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void subscribe ( final Stack<String> path, final FolderListener listener, final Object tag ) throws NoSuchFolderException
    {
        if ( path.isEmpty () )
        {
            addListener ( listener, tag );
        }
        else
        {
            getFolderEntry ( path.pop () ).subscribe ( path, listener, tag );
        }
    }

    @Override
    public void unsubscribe ( final Stack<String> path, final Object tag ) throws NoSuchFolderException
    {
        if ( path.isEmpty () )
        {
            removeListener ( tag );
        }
        else
        {
            getFolderEntry ( path.pop () ).unsubscribe ( path, tag );
        }
    }

    private synchronized void addListener ( final FolderListener listener, final Object tag )
    {
        this.listeners.put ( tag, listener );
        sendCurrentList ( listener, tag );
    }

    private synchronized void removeListener ( final Object tag )
    {
        this.listeners.remove ( tag );
    }

    public synchronized void clearListeners ()
    {
        this.listeners.clear ();
    }

    /**
     * Check if there are subscribers
     * 
     * @return <code>true</code> if there are active subscribers
     */
    public synchronized boolean hasSubscribers ()
    {
        return !this.listeners.isEmpty ();
    }

    private synchronized void sendCurrentList ( final FolderListener listener, final Object tag )
    {
        listener.changed ( tag, new ArrayList<Entry> ( this.entryMap.values () ), Collections.<String> emptySet (), true );
    }

    private synchronized void notifyAdd ( final List<Entry> added )
    {
        for ( final Map.Entry<Object, FolderListener> entry : this.listeners.entrySet () )
        {
            entry.getValue ().changed ( entry.getKey (), added, Collections.<String> emptySet (), false );
        }
    }

    private synchronized void notifyAdd ( final Entry added )
    {
        notifyAdd ( Arrays.asList ( added ) );
    }

    private synchronized void notifyRemove ( final String removed )
    {
        final Set<String> list = Collections.singleton ( removed );
        for ( final Map.Entry<Object, FolderListener> entry : this.listeners.entrySet () )
        {
            entry.getValue ().changed ( entry.getKey (), Collections.<Entry> emptyList (), list, false );
        }
    }

    /**
     * Get the number of entries in this folder
     * 
     * @return the number of entries in this folder
     */
    public int size ()
    {
        return this.entryMap.size ();
    }

    @Override
    public void added ()
    {
    }

    @Override
    public void removed ()
    {
        clearListeners ();
    }

    /**
     * clear all folder content at once
     */
    public synchronized void clear ()
    {
        for ( final Map.Entry<Object, FolderListener> entry : this.listeners.entrySet () )
        {
            entry.getValue ().changed ( entry.getKey (), Collections.<Entry> emptyList (), Collections.<String> emptySet (), true );
        }

        for ( final Map.Entry<String, Entry> entry : this.entryMap.entrySet () )
        {
            if ( entry instanceof FolderEntryCommon )
            {
                ( (FolderEntryCommon)entry ).getFolder ().removed ();
            }
        }

        this.entryMap.clear ();
    }
}
