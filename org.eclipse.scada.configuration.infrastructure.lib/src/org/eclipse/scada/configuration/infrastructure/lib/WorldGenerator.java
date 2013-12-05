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
package org.eclipse.scada.configuration.infrastructure.lib;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.generator.GeneratorContext.GlobalContext;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.globalization.EventPoolImport;
import org.eclipse.scada.configuration.globalization.Global;
import org.eclipse.scada.configuration.globalization.Globalization;
import org.eclipse.scada.configuration.globalization.GlobalizeFactory;
import org.eclipse.scada.configuration.globalization.Local;
import org.eclipse.scada.configuration.globalization.MonitorPoolImport;
import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.ExternalDriver;
import org.eclipse.scada.configuration.infrastructure.ExternalDriverPlaceholder;
import org.eclipse.scada.configuration.infrastructure.ExternalNode;
import org.eclipse.scada.configuration.infrastructure.HttpServiceModule;
import org.eclipse.scada.configuration.infrastructure.InfrastructureFactory;
import org.eclipse.scada.configuration.infrastructure.MasterImport;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.infrastructure.Module;
import org.eclipse.scada.configuration.infrastructure.Options;
import org.eclipse.scada.configuration.infrastructure.SystemNode;
import org.eclipse.scada.configuration.infrastructure.ValueArchiveServer;
import org.eclipse.scada.configuration.lib.ExclusiveGroups;
import org.eclipse.scada.configuration.recipe.lib.Output;
import org.eclipse.scada.configuration.utils.TypeWalker;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.Credentials;
import org.eclipse.scada.configuration.world.Driver;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.Node;
import org.eclipse.scada.configuration.world.World;
import org.eclipse.scada.configuration.world.WorldFactory;
import org.eclipse.scada.configuration.world.lib.Nodes;
import org.eclipse.scada.configuration.world.osgi.ApplicationConfiguration;
import org.eclipse.scada.configuration.world.osgi.DataAccessConnection;
import org.eclipse.scada.configuration.world.osgi.DefaultMasterServer;
import org.eclipse.scada.configuration.world.osgi.DefaultValueArchiveServer;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.EventPool;
import org.eclipse.scada.configuration.world.osgi.Exporter;
import org.eclipse.scada.configuration.world.osgi.HttpService;
import org.eclipse.scada.configuration.world.osgi.MonitorPool;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;
import org.eclipse.scada.configuration.world.osgi.profile.ProfileFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorldGenerator
{
    private final static Logger logger = LoggerFactory.getLogger ( WorldGenerator.class );

    @Inject
    @Named ( "infrastructureModel" )
    private org.eclipse.scada.configuration.infrastructure.World infrastructure;

    @Output
    private World world;

    @Output
    private Globalization globalize;

    private Options options;

    public WorldGenerator ()
    {
    }

    public WorldGenerator ( final org.eclipse.scada.configuration.infrastructure.World infrastructure )
    {
        this.infrastructure = infrastructure;
        this.options = infrastructure.getOptions ();
    }

    public void setInfrastructure ( final org.eclipse.scada.configuration.infrastructure.World infrastructure )
    {
        this.infrastructure = infrastructure;
        this.options = infrastructure.getOptions ();
    }

    public WorldGenerator getWorldGenerator ()
    {
        return this;
    }

    public World getWorld ()
    {
        return this.world;
    }

    public Globalization getGlobalize ()
    {
        return this.globalize;
    }

    private final Map<org.eclipse.scada.configuration.infrastructure.Driver, Driver> driverMap = new HashMap<> ();

    private final Map<ValueArchiveServer, org.eclipse.scada.configuration.world.osgi.ValueArchiveServer> valueArchiveMap = new HashMap<> ();

    private final Map<org.eclipse.scada.configuration.world.osgi.MasterServer, org.eclipse.scada.configuration.world.osgi.ValueArchiveServer> archiveMap = new HashMap<> ();

    public Map<org.eclipse.scada.configuration.infrastructure.Driver, Driver> getDriverMap ()
    {
        return this.driverMap;
    }

    public void generate ( final IProgressMonitor monitor )
    {
        this.world = WorldFactory.eINSTANCE.createWorld ();
        this.world.setOptions ( WorldFactory.eINSTANCE.createOptions () );
        this.world.getOptions ().setMasterHandlerPriorities ( this.infrastructure.getDefaultMasterHandlerPriorities () );

        // FIXME: don't create globalize if there is nothing to globalize
        this.globalize = GlobalizeFactory.eINSTANCE.createGlobalization ();
        this.globalize.setWorld ( this.world );

        fillWorld ();
        fillGlobalize ();
    }

    private final Map<MasterServer, MasterContext> ctxMap = new HashMap<> ();

    protected void doNode ( final org.eclipse.scada.configuration.infrastructure.Node infraNode, final Node cfgNode )
    {
        cfgNode.setHostName ( infraNode.getHostName () );
        cfgNode.setName ( infraNode.getName () );
        cfgNode.setShortDescription ( infraNode.getShortDescription () );
        this.world.getNodes ().add ( cfgNode );
    }

    protected void fillWorld ()
    {
        final Map<org.eclipse.scada.configuration.infrastructure.Node, Node> nodes = new HashMap<> ();

        for ( final org.eclipse.scada.configuration.infrastructure.Node anyNode : this.infrastructure.getNodes () )
        {
            if ( anyNode instanceof ExternalNode )
            {
                final org.eclipse.scada.configuration.world.ExternalNode externalNode = WorldFactory.eINSTANCE.createExternalNode ();
                doNode ( anyNode, externalNode );
                nodes.put ( anyNode, externalNode );
                continue;
            }
            if ( ! ( anyNode instanceof SystemNode ) )
            {
                continue;
            }
            final SystemNode infraNode = (SystemNode)anyNode;

            final ApplicationNode node = WorldFactory.eINSTANCE.createApplicationNode ();
            doNode ( anyNode, node );
            node.getServices ().addAll ( EcoreUtil.copyAll ( infraNode.getServices () ) );
            nodes.put ( infraNode, node );

            node.getDeployments ().addAll ( EcoreUtil.copyAll ( infraNode.getDeployment () ) );

            final Map<org.eclipse.scada.configuration.infrastructure.MasterServer, DataAccessConnection> conMap = new HashMap<> ();

            for ( final org.eclipse.scada.configuration.infrastructure.MasterServer infraMaster : infraNode.getMasters () )
            {
                final int in = infraMaster.getInstanceNumber ();

                final DefaultMasterServer master = OsgiFactory.eINSTANCE.createDefaultMasterServer ();
                master.setName ( infraMaster.getName () );
                node.getApplications ().add ( master );

                // create master context
                final MasterContext masterContext = new MasterContext ();
                masterContext.setDefinition ( infraMaster );
                masterContext.setImplementation ( master );
                this.ctxMap.put ( infraMaster, masterContext );

                // set profile
                master.setCustomizationProfile ( createProfile ( this.infrastructure.getDefaultMasterCustomizationProfile () ) );

                // add security configuration
                master.setSecurityConfiguration ( this.infrastructure.getDefaultSecurityConfiguration () );

                // add user service
                Worlds.addUserService ( master, null, this.options );

                // create pools
                master.getMonitorPools ().addAll ( EcoreUtil.copyAll ( this.options.getMonitorPools () ) );
                master.getEventPools ().addAll ( EcoreUtil.copyAll ( this.options.getEventPools () ) );

                // create exporters
                createExporter ( OsgiPackage.Literals.CONFIGURATION_ADMINISTRATOR_EXPORTER, node, master, this.infrastructure.getOptions ().getBaseCaNgpPort () + in );
                createExporter ( OsgiPackage.Literals.ALARMS_EVENTS_EXPORTER, node, master, this.infrastructure.getOptions ().getBaseAeNgpPort () + in );
                final Endpoint ep = createExporter ( OsgiPackage.Literals.DATA_ACCESS_EXPORTER, node, master, this.infrastructure.getOptions ().getBaseDaNgpPort () + in );

                // create self connection
                final DataAccessConnection selfConnection = OsgiFactory.eINSTANCE.createDataAccessConnection ();
                selfConnection.setCredentials ( EcoreUtil.copy ( findLocalCredentials ( infraMaster ) ) );
                selfConnection.setName ( "self" ); //$NON-NLS-1$
                selfConnection.setShortDescription ( "Connection to ourself" );
                selfConnection.setEndpoint ( ep );
                master.getConnections ().add ( selfConnection );

                master.getModules ().addAll ( makeModules ( infraMaster, master ) );

                conMap.put ( infraMaster, selfConnection );
            }

            for ( final org.eclipse.scada.configuration.infrastructure.ValueArchiveServer infraArchive : infraNode.getValueArchives () )
            {
                final int in = infraArchive.getInstanceNumber ();

                final DefaultValueArchiveServer archive = OsgiFactory.eINSTANCE.createDefaultValueArchiveServer ();
                archive.setName ( infraArchive.getName () );
                node.getApplications ().add ( archive );

                // add server to map
                this.valueArchiveMap.put ( infraArchive, archive );

                // set profile
                archive.setCustomizationProfile ( createProfile ( this.infrastructure.getDefaultValueArchiveCustomizationProfile () ) );

                // add security configuration
                archive.setSecurityConfiguration ( this.infrastructure.getDefaultSecurityConfiguration () );

                // add user service
                Worlds.addUserService ( archive, null, this.options );

                createExporter ( OsgiPackage.Literals.HISTORICAL_DATA_EXPORTER, node, archive, this.infrastructure.getOptions ().getBaseHdNgpPort () + in );
                createExporter ( OsgiPackage.Literals.CONFIGURATION_ADMINISTRATOR_EXPORTER, node, archive, this.infrastructure.getOptions ().getBaseCaNgpPort () + in );

                for ( final Map.Entry<org.eclipse.scada.configuration.infrastructure.MasterServer, DataAccessConnection> entry : conMap.entrySet () )
                {
                    if ( entry.getKey ().getArchiveTo () != infraArchive )
                    {
                        continue;
                    }

                    final DataAccessConnection con = EcoreUtil.copy ( entry.getValue () );
                    con.setShortDescription ( String.format ( "Connection to master %s on %s", entry.getKey ().getName (), infraNode.getHostName () ) );
                    con.setName ( String.format ( "%s.%s", entry.getKey ().getName (), infraNode.getHostName () ) );
                    archive.getConnections ().add ( con );

                    this.archiveMap.put ( this.ctxMap.get ( entry.getKey () ).getImplementation (), archive );
                }
            }

        }

        // process drivers

        for ( final org.eclipse.scada.configuration.infrastructure.Node anyNode : this.infrastructure.getNodes () )
        {
            final Node basicNode = nodes.get ( anyNode );
            if ( ! ( basicNode instanceof ApplicationNode ) )
            {
                continue;
            }

            final SystemNode infraNode = (SystemNode)anyNode;

            final ApplicationNode node = (ApplicationNode)basicNode;

            for ( final org.eclipse.scada.configuration.infrastructure.Driver infraDriver : infraNode.getDrivers () )
            {
                createDriver ( infraDriver, nodes, node );
            }
        }

        // do this after all masters and drivers have been created

        for ( final Map.Entry<org.eclipse.scada.configuration.infrastructure.Driver, Driver> entry : this.driverMap.entrySet () )
        {
            for ( final MasterServer master : new TypeWalker<> ( MasterServer.class ).toList ( this.infrastructure ) )
            {
                if ( master.getDriver ().contains ( entry.getKey () ) )
                {
                    connectMasterToDriver ( master, entry.getKey (), entry.getValue ().getEndpoints ().get ( 0 ) );
                }
            }
        }
    }

    private Collection<ApplicationConfiguration> makeModules ( final MasterServer master, final DefaultMasterServer implMaster )
    {
        final Collection<ApplicationConfiguration> result = new LinkedList<> ();

        // process application configurations

        result.addAll ( this.infrastructure.getApplicationConfigurations () );
        ExclusiveGroups.removeGroups ( result, master.getConfigurations () );
        result.addAll ( master.getConfigurations () );

        // process infrastructure configuration

        final org.eclipse.scada.configuration.infrastructure.ApplicationConfiguration cfg = master.getConfiguration ();
        // TODO: add a default configuration
        for ( final Module m : cfg.getModules () )
        {
            // FIXME: add extension scheme
            if ( m instanceof HttpServiceModule )
            {
                final HttpService s = OsgiFactory.eINSTANCE.createHttpService ();
                final Endpoint ep = Worlds.createEndpoint ( ( (HttpServiceModule)m ).getPort () );
                final Node node = Nodes.fromApp ( implMaster );
                node.getEndpoints ().add ( ep );
                s.setEndpoint ( ep );
                result.add ( s );
            }
        }

        // final check is done in the target model

        return EcoreUtil.copyAll ( result );
    }

    public Credentials findLocalCredentials ( final MasterServer master )
    {
        logger.debug ( "Looking for credentials: {}", master );

        if ( master.getLocalCredentials () != null )
        {
            logger.debug ( "Using local: {}", master.getLocalCredentials () );
            return master.getLocalCredentials ();
        }
        else
        {
            logger.debug ( "Using global: {}", this.infrastructure.getDefaultCredentials () );
            return this.infrastructure.getDefaultCredentials ();
        }
    }

    private Profile createProfile ( final Profile profile )
    {
        if ( profile == null )
        {
            return null;
        }

        final Profile newProfile = ProfileFactory.eINSTANCE.createProfile ();

        newProfile.getIncludes ().add ( profile );
        newProfile.setName ( "Local customization profile" );

        return newProfile;
    }

    private void connectMasterToDriver ( final MasterServer master, final org.eclipse.scada.configuration.infrastructure.Driver driver, final Endpoint ep )
    {
        final DataAccessConnection connection = OsgiFactory.eINSTANCE.createDataAccessConnection ();
        connection.setEndpoint ( ep );
        connection.setName ( driver.getName () );
        connection.setCredentials ( EcoreUtil.copy ( Worlds.findConnectionPassword ( driver ) ) );

        final org.eclipse.scada.configuration.world.osgi.MasterServer mappedMaster = this.ctxMap.get ( master ).getImplementation ();
        mappedMaster.getConnections ().add ( connection );
    }

    private Driver createDriver ( final org.eclipse.scada.configuration.infrastructure.Driver driver, final Map<org.eclipse.scada.configuration.infrastructure.Node, Node> nodes, final ApplicationNode node )
    {
        if ( driver instanceof org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver )
        {
            final DriverFactory factory = Activator.findDriverFactory ( ( (AbstractFactoryDriver)driver ).getDriverTypeId () );
            if ( factory == null )
            {
                throw new IllegalStateException ( String.format ( "Unable to locate driver factory for type '%s'", driver ) );
            }

            final Driver result = factory.createDriver ( this.infrastructure, (AbstractFactoryDriver)driver, nodes );

            finishDriver ( result, driver, node, true );

            return result;
        }
        else if ( driver instanceof ExternalDriver )
        {
            final ExternalDriverPlaceholder result = InfrastructureFactory.eINSTANCE.createExternalDriverPlaceholder ();
            result.getEndpoints ().add ( Worlds.createDaEndpoint ( this.options, driver ) );

            finishDriver ( result, driver, node, false );

            return result;
        }
        throw new IllegalStateException ( String.format ( "Driver type '%s' is not supported", driver.eClass ().getName () ) );
    }

    private void finishDriver ( final Driver driver, final org.eclipse.scada.configuration.infrastructure.Driver infraDriver, final ApplicationNode node, final boolean add )
    {
        driver.setName ( infraDriver.getName () );

        if ( driver.getEndpoints ().isEmpty () )
        {
            // create a connection for the driver
            throw new IllegalStateException ( String.format ( "Driver has no endpoints: %s", driver ) );
        }

        node.getEndpoints ().addAll ( driver.getEndpoints () );
        this.driverMap.put ( infraDriver, driver );
        if ( add )
        {
            node.getApplications ().add ( driver );
        }
    }

    protected void fillGlobalize ()
    {
        for ( final org.eclipse.scada.configuration.infrastructure.Node anyNode : this.infrastructure.getNodes () )
        {
            if ( ! ( anyNode instanceof SystemNode ) )
            {
                continue;
            }
            final SystemNode infraNode = (SystemNode)anyNode;

            for ( final org.eclipse.scada.configuration.infrastructure.MasterServer infraMaster : infraNode.getMasters () )
            {
                if ( infraMaster.getImportMaster ().isEmpty () )
                {
                    // if there are no master imports we don't need no global instance
                    continue;
                }

                final MasterContext master = this.ctxMap.get ( infraMaster );

                final Global global = GlobalizeFactory.eINSTANCE.createGlobal ();
                this.globalize.getGlobals ().add ( global );
                global.setGlobal ( master.getImplementation () );

                for ( final EventPool pool : this.options.getEventPools () )
                {
                    final EventPoolImport eventImport = GlobalizeFactory.eINSTANCE.createEventPoolImport ();
                    eventImport.setIncludeLocal ( true );
                    eventImport.setLocalName ( pool.getName () );
                    eventImport.setPoolSize ( pool.getSize () );
                    eventImport.setName ( "proxy." + pool.getName () );
                    global.getEventPoolImports ().add ( eventImport );
                }

                for ( final MonitorPool pool : this.options.getMonitorPools () )
                {
                    final MonitorPoolImport monitorImport = GlobalizeFactory.eINSTANCE.createMonitorPoolImport ();
                    monitorImport.setIncludeLocal ( true );
                    monitorImport.setLocalName ( pool.getName () );
                    monitorImport.setName ( "proxy." + pool.getName () );
                    global.getMonitorPoolImports ().add ( monitorImport );
                }

                for ( final MasterImport masterImport : infraMaster.getImportMaster () )
                {
                    final Local local = GlobalizeFactory.eINSTANCE.createLocal ();
                    global.getLocals ().add ( local );
                    local.setId ( masterImport.getId () );
                    local.setLocal ( this.ctxMap.get ( masterImport.getImportedMaster () ).getImplementation () );
                    local.getAuthoratives ().addAll ( EcoreUtil.copyAll ( masterImport.getImportedMaster ().getAuthoratives () ) );
                    local.setLogonCredentials ( Worlds.findConnectionCredentials ( masterImport ) );

                    final MasterContext importedMaster = this.ctxMap.get ( masterImport.getImportedMaster () );
                    importedMaster.getGlobalContext ().add ( new GlobalContext ( local, masterImport ) );
                }
            }
        }
    }

    private Endpoint createExporter ( final EClass exporterClass, final Node node, final EquinoxApplication application, final int port )
    {
        final Endpoint ep = Worlds.createEndpoint ( port );
        node.getEndpoints ().add ( ep );
        final Exporter exporter = (Exporter)EcoreUtil.create ( exporterClass );
        exporter.setName ( application.getName () + "/exporter" );
        exporter.getEndpoints ().add ( ep );
        application.getExporter ().add ( exporter );
        return ep;
    }

    public Map<org.eclipse.scada.configuration.world.osgi.MasterServer, org.eclipse.scada.configuration.world.osgi.ValueArchiveServer> getArchiveMap ()
    {
        return this.archiveMap;
    }

    public MasterContext getMasterContext ( final MasterServer master )
    {
        return this.ctxMap.get ( master );
    }
}
