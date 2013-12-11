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
package org.eclipse.scada.configuration.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.scada.configuration.lib.ItemCustomizer;
import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.configuration.world.osgi.Item;

public class CustomizationRequest
{
    private final LinkedList<String> localTags;

    private final Set<String> customizationTags;

    private final Item item;

    private final List<String> hierarchy;

    private final Object component;

    private final int globalizationLevel;

    public CustomizationRequest ( final Object component, final Item item, final List<String> hierarchy, final List<String> localTags, final Set<String> customizationTags, final int globalizationLevel )
    {
        this.component = component;
        this.item = item;
        this.hierarchy = Collections.unmodifiableList ( new ArrayList<> ( hierarchy ) );
        this.localTags = new LinkedList<> ( localTags );
        this.customizationTags = new HashSet<> ( customizationTags );
        this.globalizationLevel = globalizationLevel;
    }

    public int getGlobalizationLevel ()
    {
        return this.globalizationLevel;
    }

    public Object getComponent ()
    {
        return this.component;
    }

    private boolean isClass ( final String name, final Class<?> clazz )
    {
        if ( name.equals ( clazz.getName () ) )
        {
            return true;
        }
        if ( name.equals ( clazz.getSimpleName () ) )
        {
            return true;
        }
        return false;
    }

    public boolean isComponentClass ( final String name )
    {
        if ( name == null || this.component == null )
        {
            return false;
        }

        for ( final Class<?> clazz : this.component.getClass ().getInterfaces () )
        {
            if ( isClass ( name, clazz ) )
            {
                return true;
            }
        }

        return false;
    }

    public Item getItem ()
    {
        return this.item;
    }

    public LinkedList<String> getLocalTags ()
    {
        return this.localTags;
    }

    public boolean isLocalTags ( final String... localTags )
    {
        return this.localTags.equals ( Arrays.asList ( localTags ) );
    }

    public boolean isLocalTag ( final String localTags )
    {
        return this.localTags.equals ( Arrays.asList ( localTags ) );
    }

    public Set<String> getCustomizationTags ()
    {
        return this.customizationTags;
    }

    /**
     * Get an unmodifiable hierarchy list
     */
    public List<String> getHierarchy ()
    {
        return this.hierarchy;
    }

    public boolean hasTag ( final String tag )
    {
        return this.customizationTags.contains ( tag );
    }

    public boolean isType ( final DataType... dataTypes )
    {
        if ( this.item.getInformation () == null )
        {
            return false;
        }

        if ( this.item.getInformation ().getDataType () == null )
        {
            return false;
        }

        for ( final DataType dataType : dataTypes )
        {
            if ( this.item.getInformation ().getDataType ().equals ( dataType ) )
            {
                return true;
            }
        }
        return false;
    }

    public boolean isStringType ()
    {
        return isType ( DataType.STRING );
    }

    public boolean isFloatType ()
    {
        return isType ( DataType.FLOAT );
    }

    public boolean isBooleanType ()
    {
        return isType ( DataType.BOOLEAN );
    }

    public boolean isInt64Type ()
    {
        return isType ( DataType.INT64 );
    }

    public boolean isInt32Type ()
    {
        return isType ( DataType.INT32 );
    }

    public boolean isAnalog ()
    {
        return isType ( DataType.INT32, DataType.INT64, DataType.FLOAT );
    }

    public boolean isDigital ()
    {
        return isType ( DataType.BOOLEAN );
    }

    public void addFeature ( final ItemCustomizer customizer )
    {
        customizer.customize ( this.item );
    }
}
