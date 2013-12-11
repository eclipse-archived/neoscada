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
package org.eclipse.scada.configuration.component.generator;

import static org.eclipse.scada.configuration.component.lib.Items.registerMappedItem;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.generator.util.Components;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.Helper;
import org.eclipse.scada.configuration.component.lib.create.MasterItemCreatorImpl;
import org.eclipse.scada.configuration.component.lib.create.MasterListener;
import org.eclipse.scada.configuration.generator.GeneratorContext;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.Device;
import org.eclipse.scada.configuration.infrastructure.Driver;
import org.eclipse.scada.configuration.infrastructure.MasterImport;
import org.eclipse.scada.configuration.item.CustomizationRequest;
import org.eclipse.scada.configuration.lib.Items;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.osgi.DataAccessConnection;
import org.eclipse.scada.configuration.world.osgi.Exporter;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.SourceItem;
import org.eclipse.scada.configuration.world.osgi.ValueArchiveServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemCreatorImpl extends MasterItemCreatorImpl
{
    private final static Logger logger = LoggerFactory.getLogger ( ItemCreatorImpl.class );

    private final Component component;

    private final GeneratorContext ctx;

    public ItemCreatorImpl ( final GeneratorContext ctx, final MasterContext master, final Component component )
    {
        super ( master, component, component.getLevel () );
        this.ctx = ctx;
        this.component = component;
    }

    @Override
    public CreationRequest<SourceItem> createSourceItem ( final Driver source, final String sourceName )
    {
        final CreationRequest<SourceItem> req = super.createSourceItem ( source, sourceName );

        if ( source != null )
        {
            req.addMasterListener ( new MasterListener<SourceItem> () {

                @Override
                public void setMaster ( final SourceItem item, final MasterContext master )
                {
                    setDriverConnection ( source, item, master );
                }
            } );
        }

        return req;
    }

    @Override
    public CreationRequest<SourceItem> createImportItem ( final MasterImport masterImport, final String sourceName )
    {
        final CreationRequest<SourceItem> req = super.createImportItem ( masterImport, sourceName );

        req.addMasterListener ( new MasterListener<SourceItem> () {

            @Override
            public void setMaster ( final SourceItem item, final MasterContext master )
            {
                final MasterContext importedMaster = ItemCreatorImpl.this.ctx.getMasterContext ( masterImport.getImportedMaster () );

                final DataAccessConnection con = findConnection ( master.getImplementation (), importedMaster.getImplementation () );
                if ( con == null )
                {
                    throw new IllegalStateException ( String.format ( "Unable to find DataAccess connection from %s to %s", master.getImplementation (), importedMaster.getImplementation () ) );
                }
                item.setConnection ( con );
            }
        } );

        return req;
    }

    private static DataAccessConnection findConnection ( final MasterServer from, final MasterServer to )
    {
        for ( final org.eclipse.scada.configuration.world.osgi.Connection c : from.getConnections () )
        {
            if ( ! ( c instanceof DataAccessConnection ) )
            {
                continue;
            }

            for ( final Exporter e : to.getExporter () )
            {
                final Endpoint ep = c.getMatchingEndpoint ( e );
                if ( ep != null )
                {
                    // this is a common endpoing of the connection and the exporter
                    return (DataAccessConnection)c;
                }
            }
        }
        return null;
    }

    @Override
    public <T extends Device> CreationRequest<SourceItem> createDeviceItem ( final T device, final String sourceName )
    {
        final CreationRequest<SourceItem> req = super.createDeviceItem ( device, sourceName );

        req.addMasterListener ( new MasterListener<SourceItem> () {

            @Override
            public void setMaster ( final SourceItem item, final MasterContext master )
            {
                final AbstractFactoryDriver driver = Helper.findDriverForDevice ( master.getDefinition (), device );
                if ( driver == null )
                {
                    throw new RuntimeException ( String.format ( "Device '%s' does not belong to a driver that is assigned to master server %s", device, master.getDefinition () ) );
                }

                setDriverConnection ( driver, item, master );
            }
        } );

        return req;
    }

    /**
     * Set the connection based on a driver
     * 
     * @param source
     *            the driver
     * @param item
     *            the item to set
     * @param master
     *            the master context
     */
    private void setDriverConnection ( final Driver source, final SourceItem item, final MasterContext master )
    {
        final org.eclipse.scada.configuration.world.Driver driver = ItemCreatorImpl.this.ctx.getDriverMap ().get ( source );
        if ( driver == null )
        {
            throw new IllegalStateException ( String.format ( "Driver '%s' cannot be resolved.", source ) );
        }
        final Collection<Endpoint> endpoints = driver.getEndpoints ();
        Helper.setSourceConnectionFromEndpoints ( item, master.getImplementation (), endpoints );
    }

    @Override
    protected <T extends Item> void itemAdded ( final T item, final CustomizationRequest customizationRequest, final List<String> originalLocalTags, final Set<MasterListener<T>> masterListeners )
    {
        super.itemAdded ( item, customizationRequest, originalLocalTags, masterListeners );

        registerMappedItem ( this.ctx, this.component, originalLocalTags, item );

        if ( isArchive ( item, customizationRequest ) )
        {
            logger.debug ( "Archive item: {}", item );
            final ValueArchiveServer archive = this.ctx.getArchiveServer ( this.master.getImplementation () );
            if ( archive == null )
            {
                throw new IllegalStateException ( String.format ( "Item %s should be archive but no archive server is configured on %s", item, this.master ) );
            }
            Items.addArchive ( archive, item );
        }
    }

    @Override
    protected void customizeItem ( final Item item, final CustomizationRequest customizationRequest )
    {
        Components.customizeItem ( this.component, item, customizationRequest );
    }

    protected boolean isArchive ( final Item item, final CustomizationRequest customizationRequest )
    {
        return Components.isArchived ( this.component, item, customizationRequest );
    }

}
