/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.globalization.lib;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.globalization.Authorative;
import org.eclipse.scada.configuration.globalization.EventPoolImport;
import org.eclipse.scada.configuration.globalization.Exclude;
import org.eclipse.scada.configuration.globalization.Filter;
import org.eclipse.scada.configuration.globalization.Global;
import org.eclipse.scada.configuration.globalization.Globalization;
import org.eclipse.scada.configuration.globalization.Include;
import org.eclipse.scada.configuration.globalization.ItemNameFilter;
import org.eclipse.scada.configuration.globalization.Local;
import org.eclipse.scada.configuration.globalization.MonitorPoolImport;
import org.eclipse.scada.configuration.lib.DefaultFeatures;
import org.eclipse.scada.configuration.lib.Names;
import org.eclipse.scada.configuration.utils.TypeWalker;
import org.eclipse.scada.configuration.world.Credentials;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.osgi.AknProxy;
import org.eclipse.scada.configuration.world.osgi.AlarmsEventsConnection;
import org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule;
import org.eclipse.scada.configuration.world.osgi.ApplicationModule;
import org.eclipse.scada.configuration.world.osgi.Connection;
import org.eclipse.scada.configuration.world.osgi.DataAccessConnection;
import org.eclipse.scada.configuration.world.osgi.DataAccessExporter;
import org.eclipse.scada.configuration.world.osgi.EventPool;
import org.eclipse.scada.configuration.world.osgi.EventPoolProxy;
import org.eclipse.scada.configuration.world.osgi.Exporter;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.ItemExport;
import org.eclipse.scada.configuration.world.osgi.MonitorPool;
import org.eclipse.scada.configuration.world.osgi.MonitorPoolProxy;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.SourceItem;
import org.eclipse.scada.configuration.world.osgi.SummaryItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class GlobalizationProcessor
{

    private final static Logger logger = LoggerFactory.getLogger ( GlobalizationProcessor.class );

    @Inject
    private Globalization globalizationModel;

    public GlobalizationProcessor ()
    {
    }

    public GlobalizationProcessor ( final Globalization globalization )
    {
        this.globalizationModel = globalization;
    }

    protected int countJobs ()
    {
        int count = 0;

        for ( final Global global : this.globalizationModel.getGlobals () )
        {
            count += global.getLocals ().size ();
        }

        return count;
    }

    public void preProcess ( final IProgressMonitor monitor )
    {
        monitor.beginTask ( "Globalizing world - Phase 1/2", countJobs () );

        try
        {
            for ( final Global global : this.globalizationModel.getGlobals () )
            {
                for ( final Local local : global.getLocals () )
                {
                    preProcessRule ( global, local );
                    monitor.worked ( 1 );
                }
            }
        }
        finally
        {
            monitor.done ();
        }
    }

    private static class Entry
    {
        private final Global global;

        private final Local local;

        private final DataAccessConnection daConnection;

        private final AlarmsEventsConnection aeConnection;

        public Entry ( final Global global, final Local local, final DataAccessConnection daConnection, final AlarmsEventsConnection aeConnection )
        {
            this.global = global;
            this.local = local;
            this.daConnection = daConnection;
            this.aeConnection = aeConnection;
        }

        public DataAccessConnection getDaConnection ()
        {
            return this.daConnection;
        }

        public AlarmsEventsConnection getAeConnection ()
        {
            return this.aeConnection;
        }

        public Local getLocal ()
        {
            return this.local;
        }

        public Global getGlobal ()
        {
            return this.global;
        }
    }

    private final Collection<Entry> entries = new LinkedList<> ();

    public void postProcess ( final IProgressMonitor monitor )
    {
        monitor.beginTask ( "Globalizing world - Phase 2/2", this.entries.size () + this.globalizationModel.getGlobals ().size () );

        try
        {
            postProcessGlobal ( monitor );
            // process after since we need the AE module
            for ( final Entry entry : this.entries )
            {
                postProcessEntry ( entry );
                monitor.worked ( 1 );
            }
        }
        finally
        {
            monitor.done ();
        }
    }

    private void postProcessGlobal ( final IProgressMonitor monitor )
    {
        for ( final Global global : this.globalizationModel.getGlobals () )
        {
            final AlarmsEventsModule module = addAEModule ( global );

            processPull ( module, global );
            processEventPools ( global, module );
            processMonitorPools ( global, module );

            monitor.worked ( 1 );
        }
    }

    protected void processMonitorPools ( final Global global, final AlarmsEventsModule module )
    {
        for ( final MonitorPoolImport monitors : global.getMonitorPoolImports () )
        {
            final MonitorPoolProxy monitorProxy = OsgiFactory.eINSTANCE.createMonitorPoolProxy ();
            module.getMonitorPoolProxies ().add ( monitorProxy );
            monitorProxy.setName ( monitors.getName () );
            monitorProxy.setShortDescription ( monitors.getShortDescription () );
            if ( monitors.isIncludeLocal () )
            {
                for ( final MonitorPool localPool : global.getGlobal ().getMonitorPools () )
                {
                    if ( localPool.getName ().equals ( monitors.getLocalName () ) )
                    {
                        monitorProxy.getLocal ().add ( localPool );
                    }
                }

            }

            for ( final Local local : global.getLocals () )
            {
                boolean found = false;
                for ( final MonitorPool localPool : local.getLocal ().getMonitorPools () )
                {
                    if ( localPool.getName ().equals ( monitors.getLocalName () ) )
                    {
                        monitorProxy.getRemote ().add ( localPool );
                        found = true;
                    }
                }
                if ( !found )
                {
                    throw new IllegalStateException ( String.format ( "Monitor pool '%s' could not be found on instance '%s'", monitors.getLocalName (), Names.makeName ( local.getLocal () ) ) );
                }
            }
        }
    }

    protected void processEventPools ( final Global global, final AlarmsEventsModule module )
    {
        for ( final EventPoolImport events : global.getEventPoolImports () )
        {
            final EventPoolProxy eventProxy = OsgiFactory.eINSTANCE.createEventPoolProxy ();
            module.getEventPoolProxies ().add ( eventProxy );
            eventProxy.setName ( events.getName () );
            eventProxy.setShortDescription ( events.getShortDescription () );
            eventProxy.setSize ( events.getPoolSize () );
            if ( events.isIncludeLocal () )
            {
                eventProxy.getLocal ().addAll ( global.getGlobal ().getEventPools () );
            }

            for ( final Local local : global.getLocals () )
            {
                boolean found = false;
                for ( final EventPool localPool : local.getLocal ().getEventPools () )
                {
                    if ( localPool.getName ().equals ( events.getLocalName () ) )
                    {
                        eventProxy.getRemote ().add ( localPool );
                        found = true;
                    }
                }
                if ( !found )
                {
                    throw new IllegalStateException ( String.format ( "Event pool '%s' could not be found on instance '%s'", events.getLocalName (), Names.makeName ( local.getLocal () ) ) );
                }
            }
        }
    }

    protected void processPull ( final AlarmsEventsModule module, final Global global )
    {
        if ( global.getLocalPull () == null )
        {
            return;
        }

        module.getPullEvents ().add ( EcoreUtil.copy ( global.getLocalPull () ) );
    }

    private int aknProxyCounter = 1;

    private void postProcessEntry ( final Entry entry )
    {
        processItems ( entry.getGlobal (), entry.getLocal (), entry.getDaConnection () );

        final AlarmsEventsModule module = findAEModule ( entry.getGlobal () );

        for ( final Authorative auth : entry.getLocal ().getAuthoratives () )
        {
            final AknProxy aknProxy = OsgiFactory.eINSTANCE.createAknProxy ();
            aknProxy.setConnection ( entry.getAeConnection () );
            aknProxy.setPriority ( this.aknProxyCounter * 100 );
            aknProxy.setPattern ( makeAknProxyPattern ( auth.getHierarchy () ) );
            this.aknProxyCounter++;

            module.getAknProxies ().add ( aknProxy );
        }
    }

    private Pattern makeAknProxyPattern ( final List<String> hierarchy )
    {
        final String str = Names.makeHierarchy ( hierarchy );
        return Pattern.compile ( "^" + Pattern.quote ( str ) + "$" );
    }

    private void preProcessRule ( final Global global, final Local local )
    {
        final DataAccessConnection da = createConnection ( OsgiPackage.Literals.DATA_ACCESS_CONNECTION, DataAccessConnection.class, global, local );
        final AlarmsEventsConnection ae = createConnection ( OsgiPackage.Literals.ALARMS_EVENTS_CONNECTION, AlarmsEventsConnection.class, global, local );

        this.entries.add ( new Entry ( global, local, da, ae ) );
    }

    private AlarmsEventsModule addAEModule ( final Global global )
    {
        final AlarmsEventsModule aeModule = OsgiFactory.eINSTANCE.createAlarmsEventsModule ();
        final Iterator<ApplicationModule> i = global.getGlobal ().getModules ().iterator ();
        while ( i.hasNext () )
        {
            if ( i.next () instanceof AlarmsEventsModule )
            {
                i.remove ();
            }
        }
        global.getGlobal ().getModules ().add ( aeModule );
        return aeModule;
    }

    private AlarmsEventsModule findAEModule ( final Global global )
    {
        final Iterator<ApplicationModule> i = global.getGlobal ().getModules ().iterator ();
        while ( i.hasNext () )
        {
            final ApplicationModule current = i.next ();
            if ( current instanceof AlarmsEventsModule )
            {
                return (AlarmsEventsModule)current;
            }
        }
        throw new IllegalStateException ( String.format ( "Unable to find %s", AlarmsEventsModule.class ) );
    }

    protected void processItems ( final Global global, final Local local, final DataAccessConnection da )
    {
        final List<DataAccessExporter> exporters = new TypeWalker<> ( DataAccessExporter.class ).toList ( global.getGlobal () );

        int count = 0;
        for ( final Item item : local.getLocal ().getItems () )
        {
            if ( !isIncluded ( local, item ) )
            {
                continue;
            }

            final SourceItem sourceItem = createGlobalItem ( global, local, item, da );
            global.getGlobal ().getItems ().add ( sourceItem );

            final ItemExport export = OsgiFactory.eINSTANCE.createItemExport ();
            export.setExportName ( item.getName () );
            export.setItem ( sourceItem );

            // add the export
            for ( final DataAccessExporter exp : exporters )
            {
                exp.getExports ().add ( export );
            }

            count++;
        }

        logger.info ( "Globalized {} items", count );
    }

    private SourceItem createGlobalItem ( final Global global, final Local local, final Item item, final DataAccessConnection da )
    {
        final SourceItem sourceItem = OsgiFactory.eINSTANCE.createSourceItem ();

        sourceItem.setInformation ( EcoreUtil.copy ( item.getInformation () ) );
        sourceItem.setSourceName ( item.getName () );
        sourceItem.setConnection ( da );

        if ( item instanceof SummaryItem )
        {
            sourceItem.setName ( makeGlobalSummaryName ( global, local, item ) );
        }
        else
        {
            sourceItem.setName ( item.getName () );
        }

        // FIXME: customize global item

        final int level = findAttributesHierarchyLevel ( item ) + 1;

        DefaultFeatures.ASUM ( level ).customize ( sourceItem );
        this.hierarchyLevelMap.put ( sourceItem, level );

        return sourceItem;
    }

    private String makeGlobalSummaryName ( final Global global, final Local local, final Item item )
    {
        return "SYSTEM" + Names.delimiter + "globalizedSummaries" + Names.delimiter + local.getId () + Names.delimiter + item.getName ();
    }

    private final Map<Item, Integer> hierarchyLevelMap = new HashMap<> ();

    private int findAttributesHierarchyLevel ( final Item item )
    {
        final Integer result = this.hierarchyLevelMap.get ( item );
        if ( result == null )
        {
            return 1;
        }
        else
        {
            return result;
        }
    }

    private Boolean isIncluded ( final Collection<Filter> filters, final Item item )
    {
        for ( final Filter filter : filters )
        {
            final Boolean result = check ( filter, item );
            if ( result == null )
            {
                continue;
            }
            return result;
        }
        return null;
    }

    private boolean isIncluded ( final Local local, final Item item )
    {
        Boolean result;

        result = isIncluded ( local.getFilters (), item );
        if ( result != null )
        {
            return result;
        }

        result = isIncluded ( local.getGlobal ().getFilters (), item );
        if ( result != null )
        {
            return result;
        }

        return local.isDefaultInclude (); // default is not to include
    }

    private Boolean check ( final Filter filter, final Item item )
    {
        if ( filter instanceof Exclude )
        {
            if ( ( (Exclude)filter ).getPattern ().matcher ( item.getName () ).matches () )
            {
                return false;
            }
        }
        else if ( filter instanceof Include )
        {
            if ( ( (Exclude)filter ).getPattern ().matcher ( item.getName () ).matches () )
            {
                return false;
            }
        }
        else if ( filter instanceof ItemNameFilter )
        {
            final String itemName = ( (ItemNameFilter)filter ).getItemName ();
            if ( itemName != null && itemName.equals ( item.getName () ) )
            {
                return ( (ItemNameFilter)filter ).isInclude ();
            }
        }
        else
        {
            throw new IllegalStateException ( String.format ( "Filter type %s unsupported", filter.getClass () ) );
        }
        // known filter but no match
        return null;
    }

    private <T extends Connection> T createConnection ( final EClass connectionClass, final Class<T> clazz, final Global global, final Local local )
    {
        final T connection = clazz.cast ( OsgiFactory.eINSTANCE.create ( connectionClass ) );

        final String cname = String.format ( "global.%s.to.%s", Names.makeName ( local.getLocal () ), Names.makeName ( global.getGlobal () ) );
        connection.setName ( cname );

        // set credentials
        connection.setCredentials ( findCredentials ( global, local ) );

        // add connection to "from"
        global.getGlobal ().getConnections ().add ( connection );

        // point connection to "to"
        final LinkedList<Endpoint> endpoints = new LinkedList<> ();
        for ( final Exporter exporter : local.getLocal ().getExporter () )
        {
            endpoints.addAll ( connection.getPossibleEndpoints ( exporter ) );
        }

        if ( endpoints.isEmpty () )
        {
            throw new IllegalStateException ( String.format ( "Unable to find an exporter that could serve as endpoint for connection type %s on master %s", connectionClass.getName (), local.getLocal ().getName () ) );
        }

        final Endpoint endpoint = endpoints.getFirst ();
        connection.setEndpoint ( endpoint );

        // FIXME: adding connection analyzers to "app", in phase 1

        return connection;
    }

    private Credentials findCredentials ( final Global global, final Local local )
    {
        if ( local.getLogonCredentials () != null )
        {
            return local.getLogonCredentials ();
        }
        else if ( global.getDefaultLogonCredentials () != null )
        {
            return global.getDefaultLogonCredentials ();
        }
        else
        {
            return this.globalizationModel.getDefaultLogonCredentials ();
        }
    }

}
