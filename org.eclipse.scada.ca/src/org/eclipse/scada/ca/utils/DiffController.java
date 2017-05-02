/*******************************************************************************
 * Copyright (c) 2011, 2015 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - improve handling, relocate to common base
 *******************************************************************************/
package org.eclipse.scada.ca.utils;

import static org.eclipse.scada.utils.progress.ProgressMonitors.orDefault;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.ca.data.DiffEntry;
import org.eclipse.scada.ca.data.FactoryInformation;
import org.eclipse.scada.ca.data.Operation;
import org.eclipse.scada.utils.progress.ProgressMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiffController
{
    private final static Logger logger = LoggerFactory.getLogger ( DiffController.class );

    private Map<String, Map<String, Map<String, String>>> localData;

    private Set<String> ignoreFactories = new HashSet<String> ();

    private Map<String, Set<String>> ignoreFields = new HashMap<String, Set<String>> ();

    private Map<String, Map<String, Map<String, String>>> remoteData;

    public void setLocalData ( final Map<String, Map<String, Map<String, String>>> localData )
    {
        this.localData = localData;
    }

    public Set<String> getIgnoreFactories ()
    {
        return this.ignoreFactories;
    }

    public Map<String, Set<String>> getIgnoreFields ()
    {
        return this.ignoreFields;
    }

    public long setRemoteData ( final Collection<FactoryInformation> remoteData )
    {
        final Map<String, Map<String, Map<String, String>>> data = new HashMap<String, Map<String, Map<String, String>>> ();
        final long count = ConfigurationHelper.convert ( remoteData, data );

        setRemoteData ( data );
        return count;
    }

    public void setRemoteData ( final Map<String, Map<String, Map<String, String>>> data )
    {
        this.remoteData = data;
    }

    public List<DiffEntry> merge ( ProgressMonitor monitor )
    {
        monitor = orDefault ( monitor );
        try
        {
            if ( this.remoteData == null || this.localData == null )
            {
                return null;
            }

            monitor.beginTask ( Messages.getString("DiffController.TaskName"), this.localData.size () + this.remoteData.size () ); //$NON-NLS-1$
            return processMerge ( monitor );
        }
        finally
        {
            monitor.done ();
        }
    }

    private List<DiffEntry> processMerge ( final ProgressMonitor monitor )
    {
        final List<DiffEntry> result = new LinkedList<DiffEntry> ();

        for ( final Map.Entry<String, Map<String, Map<String, String>>> factoryEntry : this.localData.entrySet () )
        {
            // ignore from factory list
            if ( this.ignoreFactories.contains ( factoryEntry.getKey () ) )
            {
                continue;
            }

            // if the target does not contain our factory
            if ( !this.remoteData.containsKey ( factoryEntry.getKey () ) )
            {
                addAll ( factoryEntry.getKey (), result, factoryEntry.getValue () );
            }
            else
            {
                final Map<String, Map<String, String>> remoteFactory = this.remoteData.get ( factoryEntry.getKey () );
                for ( final Map.Entry<String, Map<String, String>> cfgEntry : factoryEntry.getValue ().entrySet () )
                {
                    if ( !remoteFactory.containsKey ( cfgEntry.getKey () ) )
                    {
                        result.add ( new DiffEntry ( factoryEntry.getKey (), cfgEntry.getKey (), Operation.ADD, null, cfgEntry.getValue (), null ) );
                    }
                    else
                    {
                        // modify detection is only needed once
                        final Map<String, String> remoteData = remoteFactory.get ( cfgEntry.getKey () );
                        if ( !isEqual ( cfgEntry.getValue (), remoteData ) )
                        {
                            logger.debug ( "Detected update" ); //$NON-NLS-1$
                            logger.debug ( "From: {}", remoteData ); //$NON-NLS-1$
                            logger.debug ( "To: {}", cfgEntry.getValue () ); //$NON-NLS-1$
                            final DiffEntry diffEntry = makeDiffEntry ( factoryEntry.getKey (), cfgEntry.getKey (), remoteData, cfgEntry.getValue () );
                            if ( diffEntry != null )
                            {
                                result.add ( diffEntry );
                            }
                        }
                    }
                }
            }
            monitor.worked ( 1 );
        }

        for ( final Map.Entry<String, Map<String, Map<String, String>>> factoryEntry : this.remoteData.entrySet () )
        {
            // ignore from factory list
            if ( this.ignoreFactories.contains ( factoryEntry.getKey () ) )
            {
                continue;
            }

            // if the target does not contain our factory
            if ( !this.localData.containsKey ( factoryEntry.getKey () ) )
            {
                removeAll ( factoryEntry.getKey (), result, factoryEntry.getValue () );
            }
            else
            {
                final Map<String, Map<String, String>> localFactory = this.localData.get ( factoryEntry.getKey () );
                for ( final Map.Entry<String, Map<String, String>> cfgEntry : factoryEntry.getValue ().entrySet () )
                {
                    if ( !localFactory.containsKey ( cfgEntry.getKey () ) )
                    {
                        result.add ( new DiffEntry ( factoryEntry.getKey (), cfgEntry.getKey (), Operation.DELETE, null, cfgEntry.getValue (), null ) );
                    }
                }
            }
            monitor.worked ( 1 );
        }

        return result;
    }

    private DiffEntry makeDiffEntry ( final String factoryId, final String configurationId, final Map<String, String> remoteData, final Map<String, String> localData )
    {
        final Set<String> ignoreFields = this.ignoreFields != null ? this.ignoreFields.get ( factoryId ) : null;
        if ( ignoreFields == null || ignoreFields.isEmpty () )
        {
            // nothing to ignore so we can perform an UPDATE_SET operation
            return new DiffEntry ( factoryId, configurationId, Operation.UPDATE_SET, remoteData, localData, null );
        }

        // from here on we need to check for field updates

        final Map<String, String> addedOrUpdatedData = new HashMap<String, String> ();
        final Set<String> removedData = new HashSet<String> ();
        final Map<String, String> oldData = new HashMap<String, String> ();

        // check for updates or additions
        for ( final Map.Entry<String, String> entry : localData.entrySet () )
        {
            if ( ignoreFields.contains ( entry.getKey () ) )
            {
                continue;
            }

            // check if the entry differs
            if ( entry.getValue () != null && remoteData.containsKey ( entry.getKey () ) )
            {
                if ( !entry.getValue ().equals ( remoteData.get ( entry.getKey () ) ) )
                {
                    oldData.put ( entry.getKey (), remoteData.get ( entry.getKey () ) );
                    addedOrUpdatedData.put ( entry.getKey (), entry.getValue () );
                }
            }
            else
            {
                oldData.put ( entry.getKey (), null );
                addedOrUpdatedData.put ( entry.getKey (), entry.getValue () );
            }
        }

        // check for removals
        for ( final Map.Entry<String, String> entry : remoteData.entrySet () )
        {
            final String key = entry.getKey ();
            if ( !localData.containsKey ( key ) && !ignoreFields.contains ( key ) )
            {
                oldData.put ( key, entry.getValue () );
                removedData.add ( key );
            }
        }

        // we have no changes
        if ( addedOrUpdatedData.isEmpty () && removedData.isEmpty () )
        {
            return null;
        }

        return new DiffEntry ( factoryId, configurationId, Operation.UPDATE_DIFF, oldData, addedOrUpdatedData, removedData );
    }

    /**
     * Check of two data sets are equal
     *
     * @param localData
     *            the local file data
     * @param remoteData
     *            the remote server data
     * @return the result
     */
    private boolean isEqual ( final Map<String, String> localData, final Map<String, String> remoteData )
    {
        return remoteData.equals ( localData );
    }

    private void addAll ( final String factoryId, final Collection<DiffEntry> result, final Map<String, Map<String, String>> value )
    {
        for ( final Map.Entry<String, Map<String, String>> cfgEntry : value.entrySet () )
        {
            result.add ( new DiffEntry ( factoryId, cfgEntry.getKey (), Operation.ADD, null, cfgEntry.getValue (), null ) );
        }
    }

    private void removeAll ( final String factoryId, final Collection<DiffEntry> result, final Map<String, Map<String, String>> value )
    {
        for ( final Map.Entry<String, Map<String, String>> cfgEntry : value.entrySet () )
        {
            result.add ( new DiffEntry ( factoryId, cfgEntry.getKey (), Operation.DELETE, null, cfgEntry.getValue (), null ) );
        }
    }

    public void addIgnoreFactory ( final String factoryId )
    {
        this.ignoreFactories.add ( factoryId );
    }

    public void setIgnoreFactories ( final Set<String> factories )
    {
        this.ignoreFactories = new HashSet<String> ( factories );
    }

    public void addIgnoreEntry ( final String factoryId, final String fieldName )
    {
        Set<String> fields = this.ignoreFields.get ( factoryId );
        if ( fields == null )
        {
            fields = new HashSet<String> ();
            this.ignoreFields.put ( factoryId, fields );
        }
        fields.add ( fieldName );
    }

    public void setIgnoreFields ( final Map<String, Set<String>> ignoreFields )
    {
        if ( ignoreFields != null )
        {
            this.ignoreFields = new HashMap<String, Set<String>> ( ignoreFields );
        }
        else
        {
            this.ignoreFields = null;
        }
    }

    public Map<String, Map<String, Map<String, String>>> getLocalData ()
    {
        return this.localData;
    }

    public Map<String, Map<String, Map<String, String>>> getRemoteData ()
    {
        return this.remoteData;
    }

    public Set<String> makeKnownFactories ()
    {
        final Set<String> result = new HashSet<String> ();
        result.addAll ( this.localData.keySet () );
        result.addAll ( this.remoteData.keySet () );
        return result;
    }

}
