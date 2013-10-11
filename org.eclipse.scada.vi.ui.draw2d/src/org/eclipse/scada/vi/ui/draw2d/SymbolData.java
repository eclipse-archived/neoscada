/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.SummaryInformation;

/**
 * Holds the data of the registered items for one symbol
 * <p>
 * All items that are registered for one symbol will provide the data to the
 * symbols SymbolData instance. The information can be accessed by calling
 * methods like {@link #getPrimaryValue(String)} or {@link #getValue(String)}.
 * </p>
 * <p>
 * If the item was registered using
 * {@link SymbolContext#registerItem(String, String, String, boolean, boolean)}
 * with
 * <q>ignoreSummary</q> set to <code>true</code> then the value of this dataitem
 * will not be considered for the summary state.
 * </p>
 * 
 * @author Jens Reimann
 * @since 0.17.0
 */
public class SymbolData
{
    private final SymbolController controller;

    public SymbolData ( final SymbolController symbolController )
    {
        this.controller = symbolController;
    }

    public Map<String, DataItemValue> getValues ()
    {
        return convert ( this.controller.getRegistrationManagerData () );
    }

    private Map<String, DataItemValue> convert ( final Map<String, DataValue> data )
    {
        final Map<String, DataItemValue> values = new LinkedHashMap<String, DataItemValue> ( data.size () );
        for ( final Map.Entry<String, DataValue> entry : data.entrySet () )
        {
            if ( entry.getValue () == null )
            {
                continue;
            }
            values.put ( entry.getKey (), entry.getValue ().getValue () );
        }
        return values;
    }

    public DataItemValue getValue ( final String name )
    {
        final DataValue dv = this.controller.getRegistrationManagerData ().get ( name );
        if ( dv == null )
        {
            return null;
        }
        return dv.getValue ();
    }

    public Variant getPrimaryValue ( final String name )
    {
        final DataItemValue div = getValue ( name );
        if ( div == null )
        {
            return Variant.NULL;
        }
        else
        {
            return div.getValue ();
        }
    }

    public boolean isError ( final String name )
    {
        final DataItemValue div = getValue ( name );
        if ( div == null )
        {
            return true;
        }
        else
        {
            if ( !div.isConnected () || div.isError () )
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public boolean isAlarm ( final String name )
    {
        final DataItemValue div = getValue ( name );
        if ( div == null )
        {
            return false;
        }
        else
        {
            return div.isAlarm ();
        }
    }

    public boolean isManual ( final String name )
    {
        final DataItemValue div = getValue ( name );
        if ( div == null )
        {
            return false;
        }
        else
        {
            return div.isManual ();
        }
    }

    public boolean isBlocked ( final String name )
    {
        final DataItemValue div = getValue ( name );
        if ( div == null )
        {
            return false;
        }
        else
        {
            return div.isBlocked ();
        }
    }

    public boolean isAckRequired ( final String name )
    {
        final DataItemValue div = getValue ( name );
        if ( div == null )
        {
            return false;
        }
        else
        {
            return div.isAttribute ( "ackRequired", false );
        }
    }

    public boolean isValid ( final String name )
    {
        final DataItemValue div = getValue ( name );
        if ( div == null )
        {
            return false;
        }
        else
        {
            if ( !div.isConnected () || div.isError () || div.getValue () == null || div.getValue ().isNull () )
            {
                return false;
            }
            else
            {
                return true;
            }
        }
    }

    public boolean isAttributeWithDefault ( final String name, final String attributeName, final boolean defaultValue )
    {
        final DataItemValue div = getValue ( name );
        if ( div == null )
        {
            return defaultValue;
        }
        else
        {
            final Variant attr = div.getAttributes ().get ( attributeName );
            if ( attr == null || attr.isNull () )
            {
                return defaultValue;
            }
            else
            {
                return attr.asBoolean ();
            }
        }
    }

    public Variant getAttributeValue ( final String name, final String attributeName )
    {
        final DataItemValue div = getValue ( name );
        if ( div == null )
        {
            return Variant.NULL;
        }
        else
        {
            final Variant attr = div.getAttributes ().get ( attributeName );
            if ( attr == null )
            {
                return Variant.NULL;
            }
            else
            {
                return attr;
            }
        }
    }

    public SummaryInformation getSummary ()
    {
        return this.controller.getSummaryInformation ();
    }

}
