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
package org.eclipse.scada.configuration.component.lib.create;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.Components;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.infrastructure.Device;
import org.eclipse.scada.configuration.infrastructure.Driver;
import org.eclipse.scada.configuration.infrastructure.MasterImport;
import org.eclipse.scada.configuration.item.CustomizationRequest;
import org.eclipse.scada.configuration.lib.Locator;
import org.eclipse.scada.configuration.lib.Names;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.osgi.ChangeCounterItem;
import org.eclipse.scada.configuration.world.osgi.ChangeType;
import org.eclipse.scada.configuration.world.osgi.ConstantItem;
import org.eclipse.scada.configuration.world.osgi.ErrorHandling;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.PersistentItem;
import org.eclipse.scada.configuration.world.osgi.ReferenceItem;
import org.eclipse.scada.configuration.world.osgi.SourceItem;
import org.eclipse.scada.configuration.world.osgi.TransientItem;
import org.eclipse.scada.core.Variant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractComponentItemCreator extends AbstractItemCreator
{
    private final static Logger logger = LoggerFactory.getLogger ( AbstractComponentItemCreator.class );

    protected final Component component;

    public AbstractComponentItemCreator ( final Component component )
    {
        this.component = component;
    }

    @Override
    public CreationRequest<ReferenceItem> createReferenceItem ( final Item source )
    {
        final ReferenceItem item = OsgiFactory.eINSTANCE.createReferenceItem ();
        item.setSource ( source );
        return addItem ( item );
    }

    @Override
    public CreationRequest<PersistentItem> createPersistentItem ()
    {
        final PersistentItem item = OsgiFactory.eINSTANCE.createPersistentItem ();
        return addItem ( item );
    }

    @Override
    public CreationRequest<TransientItem> createTransientItem ()
    {
        final TransientItem item = OsgiFactory.eINSTANCE.createTransientItem ();
        return addItem ( item );
    }

    @Override
    public CreationRequest<ConstantItem> createConstantItem ( final String value )
    {
        final ConstantItem item = OsgiFactory.eINSTANCE.createConstantItem ();
        item.setValue ( value );
        return addItem ( item );
    }

    @Override
    public CreationRequest<ChangeCounterItem> createChangeCounterItem (ChangeType changeType, ErrorHandling errorHandling, List<Variant> values)
    {
        final ChangeCounterItem item = OsgiFactory.eINSTANCE.createChangeCounterItem ();
        item.setOnError ( errorHandling );
        item.setType ( changeType );
        item.getValues ().addAll ( values );
        return addItem ( item );
    }

    protected abstract void customizeItem ( final Item item, final CustomizationRequest customizationRequest );

    @Override
    public <T extends Item> CreationRequest<T> addItem ( final T item )
    {
        List<String> hier;

        if ( this.component != null )
        {
            hier = Components.makeHierarchy ( this.component );
        }
        else if ( item.getInformation () != null )
        {
            hier = item.getInformation ().getHierarchy ();
        }
        else
        {
            throw new IllegalStateException ( String.format ( "Unable to add item %s since it neither has a component nor a hiearchy set.", item ) );
        }

        return new AbstractCreationRequest<T> ( this.component, hier ) {
            @Override
            public T create ()
            {
                return addItem ( item, buildRequest ( item ), getMasterListeners () );
            }
        };
    }

    protected abstract <T extends Item> void itemAdded ( final T item, final CustomizationRequest customizationRequest, final List<String> originalLocalTags, final Set<MasterListener<T>> masterListeners );

    protected <T extends Item> T addItem ( final T item, final CustomizationRequest customizationRequest, final Set<MasterListener<T>> masterListeners )
    {
        final List<String> originalLocalTags = new ArrayList<> ( customizationRequest.getLocalTags () ); // we do need a copy

        customizeItem ( item, customizationRequest );

        // set the name after customizing
        final List<String> hier = new LinkedList<> ();
        hier.addAll ( customizationRequest.getHierarchy () );
        hier.addAll ( customizationRequest.getLocalTags () );
        item.setName ( Names.makeHierarchy ( hier ) ); // FIXME: should allow a different naming scheme
        logger.debug ( "Setting item name: {}", item.getName () );

        if ( item.getInformation () == null )
        {
            item.setInformation ( OsgiFactory.eINSTANCE.createItemInformation () );
        }
        // apply the hierarchy afterwards ... overriding!
        ECollections.setEList ( item.getInformation ().getHierarchy (), customizationRequest.getHierarchy () );

        itemAdded ( item, customizationRequest, originalLocalTags, masterListeners );

        return item;
    }

    @Override
    public <T extends Item> T addItem ( final T item, final CustomizationRequest customizationRequest )
    {
        return addItem ( item, customizationRequest, Collections.<MasterListener<T>> emptySet () );
    }

    @Override
    public CreationRequest<SourceItem> createSelfItem ( final String sourceName )
    {
        final SourceItem item = OsgiFactory.eINSTANCE.createSourceItem ();
        item.setSourceName ( sourceName );

        final CreationRequest<SourceItem> req = addItem ( item );

        req.addMasterListener ( new MasterListener<SourceItem> () {

            @Override
            public void setMaster ( final SourceItem item, final MasterContext master )
            {
                final List<Endpoint> endpoints = Locator.getSelfEndpoints ( master.getImplementation () );
                Helper.setSourceConnectionFromEndpoints ( item, master.getImplementation (), endpoints );
            }
        } );

        return req;
    }

    @Override
    public CreationRequest<SourceItem> createSourceItem ( final Driver source, final String sourceName )
    {
        final SourceItem item = OsgiFactory.eINSTANCE.createSourceItem ();
        item.setSourceName ( sourceName );
        return addItem ( item );
    }

    @Override
    public <T extends Device> CreationRequest<SourceItem> createDeviceItem ( final T device, final String sourceName )
    {
        final SourceItem item = OsgiFactory.eINSTANCE.createSourceItem ();
        item.setSourceName ( sourceName );
        return addItem ( item );
    }

    @Override
    public CreationRequest<SourceItem> createImportItem ( final MasterImport masterImport, final String sourceName )
    {
        final SourceItem item = OsgiFactory.eINSTANCE.createSourceItem ();
        item.setSourceName ( sourceName );
        return addItem ( item );
    }
}