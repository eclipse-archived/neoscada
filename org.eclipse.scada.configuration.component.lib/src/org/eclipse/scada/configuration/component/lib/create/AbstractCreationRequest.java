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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.scada.configuration.item.CustomizationRequest;
import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.ItemInformation;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;

public abstract class AbstractCreationRequest<T extends Item> implements CreationRequest<T>
{
    private List<String> localTags = Collections.emptyList ();

    private Set<String> customizationTags = Collections.emptySet ();

    private final ItemInformation itemInformation;

    private final List<String> hierarchy;

    private final Object component;

    private final Set<MasterListener<T>> masterListeners = new HashSet<> ();

    public AbstractCreationRequest ( final Object component, final List<String> hierarchy )
    {
        this.component = component;
        this.hierarchy = Collections.unmodifiableList ( new ArrayList<> ( hierarchy ) );

        this.itemInformation = OsgiFactory.eINSTANCE.createItemInformation ();
        this.itemInformation.getHierarchy ().addAll ( this.hierarchy );
    }

    @Override
    public CreationRequest<T> localTags ( final String... localTags )
    {
        if ( localTags != null )
        {
            this.localTags = Arrays.asList ( localTags );
        }
        else
        {
            this.localTags = Collections.emptyList ();
        }
        return this;
    }

    @Override
    public CreationRequest<T> localTags ( final Collection<String> localTags )
    {
        if ( localTags != null )
        {
            this.localTags = new ArrayList<> ( localTags );
        }
        else
        {
            this.localTags = Collections.emptyList ();
        }
        return this;
    }

    @Override
    public CreationRequest<T> information ( final String description, final String unit, final String system )
    {
        this.itemInformation.setDescription ( description );
        this.itemInformation.setUnit ( unit );
        this.itemInformation.setSystem ( system );
        return this;
    }

    @Override
    public CreationRequest<T> dataType ( final DataType dataType )
    {
        this.itemInformation.setDataType ( dataType );
        return this;
    }

    @Override
    public CreationRequest<T> customizationTags ( final String... tags )
    {
        if ( tags != null )
        {
            this.customizationTags = new HashSet<> ( Arrays.asList ( tags ) );
        }
        else
        {
            this.customizationTags = Collections.emptySet ();
        }
        return this;
    }

    @Override
    public CreationRequest<T> customizationTags ( final Collection<String> tags )
    {
        if ( tags != null )
        {
            this.customizationTags = new HashSet<> ( tags );
        }
        else
        {
            this.customizationTags = Collections.emptySet ();
        }
        return this;
    }

    @Override
    public CreationRequest<T> request ( final CustomizationRequest request )
    {
        customizationTags ( request.getCustomizationTags () );
        localTags ( request.getLocalTags () );

        if ( request.getItem ().getInformation () != null )
        {
            this.itemInformation.setDataType ( request.getItem ().getInformation ().getDataType () );
            this.itemInformation.setDescription ( request.getItem ().getInformation ().getDescription () );
            this.itemInformation.setSystem ( request.getItem ().getInformation ().getSystem () );
        }
        return this;
    }

    public CustomizationRequest buildRequest ( final Item item )
    {
        item.setInformation ( this.itemInformation );
        return new CustomizationRequest ( this.component, item, this.hierarchy, this.localTags, this.customizationTags );
    }

    @Override
    public void addMasterListener ( final MasterListener<T> masterListener )
    {
        this.masterListeners.add ( masterListener );
    }

    public Set<MasterListener<T>> getMasterListeners ()
    {
        return this.masterListeners;
    }

}
