/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.event;

import java.beans.PropertyEditor;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantEditor;
import org.eclipse.scada.utils.filter.Assertion;
import org.eclipse.scada.utils.filter.Filter;
import org.eclipse.scada.utils.filter.FilterAssertion;
import org.eclipse.scada.utils.filter.FilterExpression;
import org.eclipse.scada.utils.propertyeditors.DateEditor;
import org.eclipse.scada.utils.propertyeditors.IntegerEditor;
import org.eclipse.scada.utils.propertyeditors.PropertyEditorRegistry;
import org.eclipse.scada.utils.propertyeditors.StringEditor;
import org.eclipse.scada.utils.propertyeditors.UUIDEditor;

public class FilterUtils
{
    public static PropertyEditorRegistry propertyEditorRegistry = new PropertyEditorRegistry ();

    static
    {
        propertyEditorRegistry.registerCustomEditor ( String.class, new StringEditor () );
        propertyEditorRegistry.registerCustomEditor ( Integer.class, new IntegerEditor () );
        propertyEditorRegistry.registerCustomEditor ( Date.class, new DateEditor () );
        propertyEditorRegistry.registerCustomEditor ( java.sql.Date.class, new DateEditor () );
        propertyEditorRegistry.registerCustomEditor ( Calendar.class, new DateEditor () );
        propertyEditorRegistry.registerCustomEditor ( UUID.class, new UUIDEditor () );
        propertyEditorRegistry.registerCustomEditor ( Variant.class, new VariantEditor () );
    }

    /**
     * converts string values in filter to actual Variant Values
     * 
     * @param filter
     * @return
     */
    @SuppressWarnings ( "unchecked" )
    public static void toVariant ( final Filter filter )
    {
        if ( filter.isAssertion () )
        {
            final FilterAssertion filterAssertion = (FilterAssertion)filter;
            // first convert String for case of like query * -> %
            if ( filterAssertion.getValue () instanceof List && filterAssertion.getAssertion () == Assertion.SUBSTRING )
            {
                final List<String> values = (List<String>)filterAssertion.getValue ();
                final StringBuilder sb = new StringBuilder ();
                int i = 0;
                for ( final String string : values )
                {
                    if ( i > 0 && i < values.size () )
                    {
                        sb.append ( "%" );
                    }
                    sb.append ( string );
                    i += 1;
                }
                filterAssertion.setValue ( sb.toString () );
            }
            if ( filterAssertion.getValue () instanceof String )
            {
                if ( "id".equals ( filterAssertion.getAttribute () ) )
                {
                    final PropertyEditor pe = propertyEditorRegistry.findCustomEditor ( UUID.class );
                    pe.setAsText ( (String)filterAssertion.getValue () );
                    filterAssertion.setValue ( pe.getValue () );
                }
                else if ( "sourceTimestamp".equals ( filterAssertion.getAttribute () ) || "entryTimestamp".equals ( filterAssertion.getAttribute () ) )
                {
                    final PropertyEditor pe = propertyEditorRegistry.findCustomEditor ( Date.class );
                    pe.setAsText ( (String)filterAssertion.getValue () );
                    filterAssertion.setValue ( pe.getValue () );
                }
                else
                {
                    final VariantEditor ve = new VariantEditor ();
                    ve.setAsText ( (String)filterAssertion.getValue () );
                    filterAssertion.setValue ( ve.getValue () );
                }
            }
        }
        else if ( filter.isExpression () )
        {
            final FilterExpression filterExpression = (FilterExpression)filter;
            for ( final Filter child : filterExpression.getFilterSet () )
            {
                toVariant ( child );
            }
        }
    }
}
