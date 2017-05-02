/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jürgen Rose - further development
 *******************************************************************************/
package org.eclipse.scada.utils.osgi.jdbc.data;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SingleColumnRowMapper<T> implements RowMapper<T>
{
    private final Class<T> clazz;

    public SingleColumnRowMapper ( final Class<T> clazz )
    {
        this.clazz = clazz;
    }

    @Override
    public void validate ( final ResultSet resultSet ) throws RowMapperValidationException, SQLException
    {
        final ResultSetMetaData md = resultSet.getMetaData ();
        if ( md.getColumnCount () != 1 )
        {
            throw new RowMapperValidationException ( "Column count must be exactly one" );
        }
    }

    @Override
    public T mapRow ( final ResultSet resultSet ) throws RowMapperMappingException, SQLException
    {
        final Object result = resultSet.getObject ( 1 );

        if ( this.clazz.isAssignableFrom ( result.getClass () ) )
        {
            return this.clazz.cast ( result );
        }
        else
        {
            throw new RowMapperMappingException ( String.format ( "Failed to map from data type %s to %s", result.getClass (), this.clazz ) );
        }
    }

    @Override
    public T nullObject ()
    {
        return null;
    }
}