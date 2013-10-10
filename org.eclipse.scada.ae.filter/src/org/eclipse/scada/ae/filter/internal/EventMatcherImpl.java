/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.filter.internal;

import java.beans.PropertyEditor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.filter.EventMatcher;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantEditor;
import org.eclipse.scada.utils.filter.Assertion;
import org.eclipse.scada.utils.filter.Filter;
import org.eclipse.scada.utils.filter.FilterAssertion;
import org.eclipse.scada.utils.filter.FilterExpression;
import org.eclipse.scada.utils.filter.FilterParser;
import org.eclipse.scada.utils.filter.Operator;
import org.eclipse.scada.utils.lang.Apply;
import org.eclipse.scada.utils.propertyeditors.DateEditor;
import org.eclipse.scada.utils.propertyeditors.IntegerEditor;
import org.eclipse.scada.utils.propertyeditors.PropertyEditorRegistry;
import org.eclipse.scada.utils.propertyeditors.StringEditor;
import org.eclipse.scada.utils.propertyeditors.UUIDEditor;
import org.eclipse.scada.utils.str.StringHelper;

public class EventMatcherImpl implements EventMatcher
{
    private static final DateFormat isoDateFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss.S" ); //$NON-NLS-1$

    private static PropertyEditorRegistry propertyEditorRegistry = new PropertyEditorRegistry ();

    private final Filter filter;

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

    public EventMatcherImpl ( final String filter )
    {
        this.filter = new FilterParser ( filter ).getFilter ();
    }

    public EventMatcherImpl ( final Filter filter )
    {
        this.filter = filter;
    }

    @Override
    public boolean matches ( final Event event )
    {
        return matches ( this.filter, event );
    }

    private static boolean matches ( final Filter filter, final Event event )
    {
        if ( filter.isEmpty () )
        {
            return true;
        }
        if ( filter.isAssertion () )
        {
            return matches ( (FilterAssertion)filter, event );
        }
        if ( filter.isExpression () )
        {
            return matches ( (FilterExpression)filter, event );
        }
        return false;
    }

    private static boolean matches ( final FilterExpression expression, final Event event )
    {
        if ( expression.getOperator () == Operator.AND )
        {
            boolean result = true;
            for ( final Filter subFilter : expression.getFilterSet () )
            {
                result = result && matches ( subFilter, event );
            }
            return result;
        }
        else if ( expression.getOperator () == Operator.OR )
        {
            boolean result = false;
            for ( final Filter subFilter : expression.getFilterSet () )
            {
                result = result || matches ( subFilter, event );
            }
            return result;
        }
        else if ( expression.getOperator () == Operator.NOT )
        {
            boolean result = true;
            for ( final Filter subFilter : expression.getFilterSet () )
            {
                result = result && matches ( subFilter, event );
            }
            return !result;
        }
        return false;
    }

    private static boolean matches ( final FilterAssertion assertion, final Event event )
    {
        // special case id
        if ( "id".equals ( assertion.getAttribute () ) ) //$NON-NLS-1$
        {
            return compareId ( assertion, event.getId () );
        }
        // special case source/entryTimestamp
        else if ( "sourceTimestamp".equals ( assertion.getAttribute () ) ) //$NON-NLS-1$
        {
            return compareTimestamp ( assertion, event.getSourceTimestamp () );
        }
        else if ( "entryTimestamp".equals ( assertion.getAttribute () ) ) //$NON-NLS-1$
        {
            return compareTimestamp ( assertion, event.getEntryTimestamp () );
        }
        return compareVariant ( assertion, event.getAttributes ().get ( assertion.getAttribute () ) );
    }

    @SuppressWarnings ( { "unchecked", "incomplete-switch" } )
    private static boolean compareId ( final FilterAssertion assertion, final UUID left )
    {
        if ( assertion.getAssertion () == Assertion.PRESENCE )
        {
            return left != null;
        }
        if ( assertion.getValue () == null )
        {
            return false;
        }
        if ( ! ( assertion.getValue () instanceof String || assertion.getValue () instanceof UUID || assertion.getValue () instanceof Collection<?> ) )
        {
            return false;
        }
        if ( assertion.getAssertion () == Assertion.SUBSTRING )
        {
            return left.toString ().matches ( toRegEx ( (Collection<String>)assertion.getValue () ) );
        }
        final UUID right = UUID.fromString ( assertion.getValue ().toString () );
        switch ( assertion.getAssertion () )
        {
            case LESSTHAN:
                return left.compareTo ( right ) == -1;
            case LESSEQ:
                return left.compareTo ( right ) == -1 || left.compareTo ( right ) == 0;
            case EQUALITY:
                return left.compareTo ( right ) == 0;
            case GREATEREQ:
                return left.compareTo ( right ) == 1 || left.compareTo ( right ) == 0;
            case GREATERTHAN:
                return left.compareTo ( right ) == 1;
            case APPROXIMATE:
                throw new IllegalArgumentException ( Messages.getString ( "EventMatcherImpl.Error.ApproximateNotSupported" ) ); //$NON-NLS-1$
        }
        return false;
    }

    @SuppressWarnings ( { "unchecked", "incomplete-switch" } )
    private static boolean compareTimestamp ( final FilterAssertion assertion, final Date left )
    {
        if ( assertion.getAssertion () == Assertion.PRESENCE )
        {
            return left != null;
        }
        if ( assertion.getValue () == null )
        {
            return false;
        }
        if ( ! ( assertion.getValue () instanceof String || assertion.getValue () instanceof Date || assertion.getValue () instanceof Collection<?> ) )
        {
            return false;
        }
        if ( assertion.getAssertion () == Assertion.SUBSTRING )
        {
            return isoDateFormat.format ( left ).matches ( toRegEx ( (Collection<String>)assertion.getValue () ) );
        }
        Date right = null;
        if ( assertion.getValue () instanceof String )
        {
            final PropertyEditor pe = propertyEditorRegistry.findCustomEditor ( Date.class );
            pe.setAsText ( (String)assertion.getValue () );
            right = (Date)pe.getValue ();
        }
        else if ( assertion.getValue () instanceof Date )
        {
            right = (Date)assertion.getValue ();
        }
        else
        {
            throw new IllegalArgumentException ( Messages.getString ( "EventMatcherImpl.Error.ValueTypeNotSupported" ) ); //$NON-NLS-1$
        }
        switch ( assertion.getAssertion () )
        {
            case LESSTHAN:
                return left.compareTo ( right ) == -1;
            case LESSEQ:
                return left.compareTo ( right ) == -1 || left.compareTo ( right ) == 0;
            case EQUALITY:
                return left.compareTo ( right ) == 0;
            case GREATEREQ:
                return left.compareTo ( right ) == 1 || left.compareTo ( right ) == 0;
            case GREATERTHAN:
                return left.compareTo ( right ) == 1;
            case APPROXIMATE:
                throw new IllegalArgumentException ( Messages.getString ( "EventMatcherImpl.Error.ApproximateNotSupported" ) ); //$NON-NLS-1$
        }
        return false;
    }

    @SuppressWarnings ( { "unchecked", "incomplete-switch" } )
    private static boolean compareVariant ( final FilterAssertion assertion, final Variant left )
    {
        if ( assertion.getAssertion () == Assertion.PRESENCE )
        {
            return left != null;
        }
        if ( assertion.getValue () == null )
        {
            return false;
        }
        if ( left == null )
        {
            return false;
        }
        if ( ! ( assertion.getValue () instanceof String || assertion.getValue () instanceof Date || assertion.getValue () instanceof Collection<?> ) )
        {
            return false;
        }
        if ( assertion.getAssertion () == Assertion.SUBSTRING )
        {
            return left.asString ( "" ).matches ( toRegEx ( (Collection<String>)assertion.getValue () ) ); //$NON-NLS-1$
        }
        Variant right = null;
        if ( assertion.getValue () instanceof String )
        {
            final PropertyEditor pe = propertyEditorRegistry.findCustomEditor ( Variant.class );
            pe.setAsText ( (String)assertion.getValue () );
            right = (Variant)pe.getValue ();
        }
        else if ( assertion.getValue () instanceof Variant )
        {
            right = (Variant)assertion.getValue ();
        }
        else
        {
            throw new IllegalArgumentException ( Messages.getString ( "EventMatcherImpl.Error.ValueTypeNotSupported" ) ); //$NON-NLS-1$
        }
        switch ( assertion.getAssertion () )
        {
            case LESSTHAN:
                return left.compareTo ( right ) == -1;
            case LESSEQ:
                return left.compareTo ( right ) == -1 || left.compareTo ( right ) == 0;
            case EQUALITY:
                return left.compareTo ( right ) == 0;
            case GREATEREQ:
                return left.compareTo ( right ) == 1 || left.compareTo ( right ) == 0;
            case GREATERTHAN:
                return left.compareTo ( right ) == 1;
            case APPROXIMATE:
                throw new IllegalArgumentException ( Messages.getString ( "EventMatcherImpl.Error.ApproximateNotSupported" ) ); //$NON-NLS-1$
        }
        return false;
    }

    private static String toRegEx ( final Collection<String> parts )
    {
        return StringHelper.join ( parts, ".*", new Apply<String> () { //$NON-NLS-1$
            @Override
            public String apply ( final String parameter )
            {
                return Pattern.quote ( parameter );
            }
        } );
    }
}
