/*******************************************************************************
 * Copyright (c) 2006, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.osgi;

import java.util.Map;
import java.util.Set;

import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;

public class FilterUtil
{

    protected static Filter createFilter ( final String operand, final Map<String, String> parameters ) throws InvalidSyntaxException
    {
        final StringBuilder sb = new StringBuilder ();

        sb.append ( "(" );
        sb.append ( operand );

        for ( final Map.Entry<String, String> entry : parameters.entrySet () )
        {
            addPair ( sb, entry.getKey (), entry.getValue () );
        }
        sb.append ( ")" );

        return FrameworkUtil.createFilter ( sb.toString () );
    }

    public static Filter createClassFilter ( final String clazz ) throws InvalidSyntaxException
    {
        return FrameworkUtil.createFilter ( String.format ( "(%s=%s)", Constants.OBJECTCLASS, clazz ) );
    }

    public static Filter createClassAndPidFilter ( final String clazz, final String persistentId ) throws InvalidSyntaxException
    {
        return FrameworkUtil.createFilter ( String.format ( "(&(%s=%s)(%s=%s))", Constants.OBJECTCLASS, clazz, Constants.SERVICE_PID, persistentId ) );
    }

    public static Filter createClassAndPidFilter ( final Class<?> clazz, final String persistentId ) throws InvalidSyntaxException
    {
        return FrameworkUtil.createFilter ( String.format ( "(&(%s=%s)(%s=%s))", Constants.OBJECTCLASS, clazz.getName (), Constants.SERVICE_PID, persistentId ) );
    }

    public static Filter createAndFilter ( final Filter... filters ) throws InvalidSyntaxException
    {
        return createFilter ( "&", filters );
    }

    public static Filter createOrFilter ( final Filter... filters ) throws InvalidSyntaxException
    {
        return createFilter ( "|", filters );
    }

    protected static Filter createFilter ( final String operand, final Filter... filters ) throws InvalidSyntaxException
    {
        final StringBuilder sb = new StringBuilder ();

        sb.append ( "(" );
        sb.append ( operand );

        for ( final Filter filter : filters )
        {
            sb.append ( filter.toString () );
        }

        sb.append ( ")" );

        return FrameworkUtil.createFilter ( sb.toString () );
    }

    public static Filter createAndFilter ( final Map<String, String> parameters ) throws InvalidSyntaxException
    {
        return createFilter ( "&", parameters );
    }

    public static Filter createOrFilter ( final Map<String, String> parameters ) throws InvalidSyntaxException
    {
        return createFilter ( "|", parameters );
    }

    public static Filter createAndFilter ( final String clazz, final Map<String, String> parameters ) throws InvalidSyntaxException
    {
        return createAndFilter ( createClassFilter ( clazz ), createAndFilter ( parameters ) );
    }

    public static Filter createSimpleOr ( final String attribute, final Set<String> values ) throws InvalidSyntaxException
    {
        final StringBuilder sb = new StringBuilder ();

        sb.append ( "(|" );

        for ( final String value : values )
        {
            addPair ( sb, attribute, value );
        }

        sb.append ( ")" );

        return FrameworkUtil.createFilter ( sb.toString () );
    }

    private static void addPair ( final StringBuilder stringBuilder, final String key, final String value )
    {
        stringBuilder.append ( "(" );
        stringBuilder.append ( key );
        stringBuilder.append ( "=" );
        stringBuilder.append ( value );
        stringBuilder.append ( ")" );
    }
}
